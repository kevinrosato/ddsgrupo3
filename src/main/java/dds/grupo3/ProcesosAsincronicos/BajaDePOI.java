package dds.grupo3.ProcesosAsincronicos;
import java.io.FileInputStream;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import dds.grupo3.Interfaces.AdministradorPOIs;
import dds.grupo3.Interfaces.POIGral;
import dds.grupo3.Interfaces.ProcesoAsincronico;
import dds.grupo3.Interfaces.User;
import dds.grupo3.User.BorrarPOI;
import ddsgrupo3.Mapa;

public class BajaDePOI extends ProcesoAsincronico{
	private List<POIGral> listaPois;
	private AdministradorPOIs mapa=new Mapa();
	Boolean error=false;
	
	public BajaDePOI(AdministradorPOIs mapa){
		this.mapa=mapa;
	}
	
	@Override
	public void run(){
		error=false;
		listaPois=llenarListaPOI();
		if (!error){
			try{
				for(POIGral poi:listaPois){
					mapa.realizarFuncConPoi(new BorrarPOI(), poi);
				}
				this.resultadoOK();
			}
			catch(Exception e){
				this.resultadoError(e.toString());
			}
		}
	}
	public List<POIGral>  llenarListaPOI(){
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
			this.resultadoError(e.toString());
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
	@Override
	public Integer desplegarConsola(User usuario, String terminal_ID,Scanner teclado) {
		usuario.bajaDePOI(terminal_ID);
		return null;
	}
	@Override
	public void mostrarOpcion() {
		System.out.println("-->	BAJA DE POIS");
	}
	@Override
	public void pedirInfo() {
		mapa=usuario.getMapa();
		System.out.println("---------------------------------------");
		System.out.println("		BAJA DE POIS");
		System.out.println("----------------------------------------");
		System.out.println();
	}
	@Override
	public void setTask() {
		task= new BajaDePOI(mapa);
	}
	@Override
	public String setProceso() {
		return "Baja de POI";
	}
}
