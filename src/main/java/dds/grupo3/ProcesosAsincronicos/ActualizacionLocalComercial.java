package dds.grupo3.ProcesosAsincronicos;

import java.io.File;
import java.util.Scanner;

import dds.grupo3.Interfaces.AdministradorPOIs;
import dds.grupo3.Interfaces.ProcesoAsincronico;
import dds.grupo3.Interfaces.User;
import dds.grupo3.POIsSistem.Local;

public class ActualizacionLocalComercial extends ProcesoAsincronico{
	private User usuario;
	private String nombreLocal;
	private String palabrasClaves;
	File archivo=new File("LocalesComerciales.properties");
	//TODO:Falta que levante el archivo y lo haga sucesivamente
	@Override
	public void run(){
		AdministradorPOIs mapa=usuario.getMapa();
		Boolean tienePOI=false;
		Local localModificado = null;
		Integer indice=0;
		try{
			for(int i=0;i<mapa.getListaPois().size();i++){
				if(mapa.getListaPois().get(i).tieneLaClave(nombreLocal)){
					tienePOI=true;
					localModificado=(Local) mapa.getListaPois().get(i);
					indice=i;
				}
			}
			if(tienePOI){
				localModificado.setPalabrasClaves(palabrasClaves);
				usuario.modificarPOI(mapa.getListaPois().get(indice), localModificado);
			}
			else{
				localModificado.setNombre(nombreLocal);
				localModificado.setPalabrasClaves(palabrasClaves);
				usuario.agregarPOI(localModificado);
			}
			this.resultadoOK();
		}
		catch(Exception e){
			this.resultadoError(e.toString());
		}
				
	}
	

	@Override
	public Integer desplegarConsola(User usuario, String terminal_ID,Scanner teclado) {
		usuario.actualizarLocalComercial(terminal_ID);
		return null;
	}

	@Override
	public void mostrarOpcion() {
		System.out.println("-->	ACTUALIZAR LOCALES COMERCIALES");
	}


	@Override
	public void pedirInfo() {
		System.out.println("---------------------------------------");
		System.out.println("	ACTUALIZACION DE LOCALES COMERCIALES");
		System.out.println("----------------------------------------");
		System.out.println();
	}


	@Override
	public void setTask() {
		task = new ActualizacionLocalComercial();
		
	}


	@Override
	public String setProceso() {
		return "Actualizacion Local Comercial";
	}
}
