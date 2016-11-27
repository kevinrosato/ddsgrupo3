package dds.grupo3.ProcesosAsincronicos_EnDesuso;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimerTask;

import dds.grupo3.Interfaces.AdministradorPOIs;
import dds.grupo3.Interfaces.User;
import dds.grupo3.Interfaces.EnDesuso.CommandProcesos;
import dds.grupo3.POIsSistem.Local;

public class ActualizacionLocalComercial extends TimerTask implements CommandProcesos{
	private User usuario;
	private Calendar fechaInicio;
	
	@Override
	public void run(){
		ResultadosProcesos resultado=new ResultadosProcesos(this,this.fechaInicio);
		AdministradorPOIs mapa=usuario.getMapa();
		String nombreLocal;
		String palabrasClaves;
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
				nombreLocal=lista[0];
				palabrasClaves=lista[1];
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
			resultado.resultadoOK();
		}
		catch(Exception e){
			e.printStackTrace();
			resultado.resultadoError(e.toString());
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


	public void pedirInfo() {
		System.out.println("---------------------------------------");
		System.out.println("	ACTUALIZACION DE LOCALES COMERCIALES");
		System.out.println("----------------------------------------");
		System.out.println();
	}

	public void setTask(TimerTask task,Calendar fechaInicio,User usuario,String terminalID) {
		ActualizacionLocalComercial auxiliar= new ActualizacionLocalComercial();
		auxiliar.usuario=usuario;
		fechaInicio=Calendar.getInstance();
		auxiliar.fechaInicio=fechaInicio;
		task= auxiliar;
		
	}

	public String setProceso() {
		return "Actualizacion Local Comercial";
	}
}
