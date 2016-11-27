package dds.grupo3.ProcesosAsincronicos_EnDesuso;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;
import java.util.TimerTask;

import dds.grupo3.Interfaces.AdministradorPOIs;
import dds.grupo3.Interfaces.POIGral;
import dds.grupo3.Interfaces.User;
import dds.grupo3.Interfaces.EnDesuso.CommandProcesos;
import dds.grupo3.OtrasClases.Mapa;
import dds.grupo3.User.BorrarPOI;

public class BajaDePOI extends TimerTask implements CommandProcesos{
	private List<POIGral> listaPois;
	private AdministradorPOIs mapa=new Mapa();
	Boolean error=false;
	User usuario;
	private Calendar fechaInicio;
	
	@Override
	public void run(){
		ResultadosProcesos resultado=new ResultadosProcesos(this,this.fechaInicio);
		error=false;
		listaPois= new ArrayList<POIGral>();
		listaPois=llenarListaPOI(resultado);
		if (!error){
			try{
				for(POIGral poi:listaPois){
					mapa.realizarFuncConPoi(new BorrarPOI(), poi);
				}
				resultado.resultadoOK();
			}
			catch(Exception e){
				resultado.resultadoError(e.toString());
			}
		}
	}
	
	public List<POIGral>  llenarListaPOI(ResultadosProcesos resultado){
		//Este proceso simula una respuesta a un servidor usando un archivo
		try {
			FileInputStream file;
			file = new FileInputStream("BajaDePOI.properties");
			Properties propiedades = new Properties();
			propiedades.load(file);
			String respuesta = propiedades.getProperty("RespuestaRESTSimulada");
			String [] respuestaVector= respuesta.split(",");
			for (int i=0;i<respuestaVector.length;i++){
				Calendar fechaRespuesta= parseCalendar(respuestaVector[i].split(";")[1]);
				if(Calendar.getInstance().before(fechaRespuesta)){ //Si el dia de hoy es menor al dia del archivo
					for(int y=0;y<mapa.getListaPois().size();y++){
						if(mapa.getListaPois().get(y).tieneLaClave(respuestaVector[i].split(";")[0])){
							POIGral poi=mapa.getListaPois().get(y);
							listaPois.add(poi);
							break;
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			error=true;
			resultado.resultadoError(e.toString());
		}
		return listaPois;
	}
	public Calendar parseCalendar (String a){
		//Pasa de dd/mm/yyyy a Calendar
		Calendar resultado= Calendar.getInstance();
		String [] fechaVector= a.split("/");
		resultado.set(Calendar.YEAR, Integer.parseInt(fechaVector[2]));
		resultado.set(Calendar.MONTH, Integer.parseInt(fechaVector[1])-1);
		resultado.set(Calendar.DAY_OF_MONTH, Integer.parseInt(fechaVector[0]));
		return resultado;
	}
	
	public void pedirInfo() {
		mapa=usuario.getMapa();
		System.out.println("---------------------------------------");
		System.out.println("		BAJA DE POIS");
		System.out.println("----------------------------------------");
		System.out.println();
	}
	
	public void setTask(TimerTask task,Calendar fechaInicio,User usuario,String terminalID) {
		BajaDePOI a= new BajaDePOI();
		a.mapa=mapa;
		fechaInicio=Calendar.getInstance();
		a.fechaInicio=fechaInicio;
		task= (TimerTask) a;
	}
	
	public String setProceso() {
		return "Baja de POI";
	}
}
