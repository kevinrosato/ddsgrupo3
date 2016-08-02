package dds.grupo3.ProcesosAsincronicos;
import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import dds.grupo3.Interfaces.POIGral;
import dds.grupo3.Interfaces.ProcesoAsincronico;
import dds.grupo3.Interfaces.User;
import dds.grupo3.User.BorrarPOI;
import ddsgrupo3.Mapa;

public class BajaDePOI extends ProcesoAsincronico{
	private List<POIGral> poi;
	private Mapa mapa=new Mapa();
	Boolean error=false;
	
	public BajaDePOI(Mapa mapa){
		this.mapa=mapa;
	}
	
	@Override
	public void run(){
		error=false;
		poi=llenarListaPOI();
		if (!error){
			try{
				for(POIGral i:poi){
					mapa.realizarFuncConPoi(new BorrarPOI(), i);
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
			//TODO:Todavia no toma las cosas del archivo
		} catch (Exception e) {
			e.printStackTrace();
			error=true;
			this.resultadoError(e.toString());
		}
		return null;
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
