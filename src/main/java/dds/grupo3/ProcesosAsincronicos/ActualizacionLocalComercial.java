package dds.grupo3.ProcesosAsincronicos;

import java.io.File;
import java.util.Scanner;

import dds.grupo3.Interfaces.AdministradorPOIs;
import dds.grupo3.Interfaces.ProcesoAsincronico;
import dds.grupo3.Interfaces.User;
import dds.grupo3.POIsSistem.Local;

public class ActualizacionLocalComercial extends ProcesoAsincronico{
	//TODO:Implementacion real
	private User usuario;
	private String nombreLocal;
	private String palabrasClaves;
	File archivo=new File("LocalesComerciales.properties");
	
	
	public void run(){
		AdministradorPOIs mapa=usuario.getMapa();
		Boolean tienePOI=false;
		Local localModificado = null;
		Integer indice=0;
		
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
	}
	

	@Override
	public Integer desplegarConsola(User usuario, String terminal_ID,Scanner teclado) {
		// TODO Auto-generated method stub
		System.out.println("---------------------------------------");
		System.out.println("	ACTUALIZACION DE LOCALES COMERCIALES");
		System.out.println("----------------------------------------");
		System.out.println();
		System.out.println("Se actualizaron correctamente.");
		System.out.println();
		return null;
	}

	@Override
	public void mostrarOpcion() {
		// TODO Auto-generated method stub
		System.out.println("-->	ACTUALIZAR LOCALES COMERCIALES");
	}
	@Override
	public void pedirInfo() {
		// TODO Auto-generated method stub		
	}
	@Override
	public void setTask() {
		// TODO Auto-generated method stub		
	}
	@Override
	public String setProceso() {
		// TODO Auto-generated method stub
		return null;
	}
}
