package dds.grupo3.User;

import java.util.List;
import java.util.Scanner;

import dds.grupo3.Interfaces.Funcionalidad;
import dds.grupo3.Interfaces.POIGral;
import dds.grupo3.Interfaces.User;

public class VerHistorial implements Funcionalidad {

	private String archivo="/historial";
	
	@Override
	public Integer desplegarConsola(User usuario, String terminal_ID, Scanner teclado) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String mostrarOpcion() {
		return "VER HISTORIAL DE BUSQUEDAS";
	}

	@Override
	public Object realizarFuncion(List<POIGral> listaPois, Object poi) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setParametro(Object obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getArchivo() {
		// TODO Auto-generated method stub
		return archivo;
	}

	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}

}
