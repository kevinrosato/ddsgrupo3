package dds.grupo3.ProcesosAsincronicos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dds.grupo3.Interfaces.AdministradorPOIs;
import dds.grupo3.Interfaces.ProcesoAsincronico;
import dds.grupo3.Interfaces.User;
import dds.grupo3.POIsSistem.Local;

public class ActualizacionLocalComercial extends ProcesoAsincronico{
	private String nombreLocal;
	private String palabrasClaves;
	
	public ActualizacionLocalComercial(User usuario){
		this.usuario=usuario;
	}
	
	@Override
	public void run(){
		AdministradorPOIs mapa=usuario.getMapa();
		Boolean tienePOI=false;
		Local localModificado = null;
		Integer indice=0;
		List<String> actualizaciones=new ArrayList<String>();
		try {
			actualizaciones=leerArchivo();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try{
			for(int j=0;j<actualizaciones.size();j++){
				String[] lista=actualizaciones.get(j).split(";");
				this.nombreLocal=lista[0];
				this.palabrasClaves=lista[1];
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
			this.resultadoOK();
		}
		catch(Exception e){
			this.resultadoError(e.toString());
		}
	}
	
	public List<String> leerArchivo() throws IOException{
		String linea=""; 
		List<String> actualizaciones=new ArrayList<String>();
		try {
			FileReader fr = new FileReader("LocalesComerciales.txt");
			BufferedReader br = new BufferedReader(fr);
	 	    actualizaciones.add(br.readLine());
		    while(linea!=null){
		    	linea=br.readLine();
		 	    if(linea!=null){actualizaciones.add(linea);}
		    }
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return actualizaciones;  
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
		task = new ActualizacionLocalComercial(usuario);
	}

	@Override
	public String setProceso() {
		return "Actualizacion Local Comercial";
	}
}
