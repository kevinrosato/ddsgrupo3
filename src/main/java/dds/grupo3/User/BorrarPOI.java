package dds.grupo3.User;

import java.util.List;
import java.util.Scanner;

import dds.grupo3.Interfaces.Funcionalidad;
import dds.grupo3.Interfaces.POIGral;
import dds.grupo3.Interfaces.User;

public class BorrarPOI implements Funcionalidad{
	
	private String archivo="";
	
	@Override
	public Object realizarFuncion(List<POIGral> listaPois, Object poi)
	{
		if(listaPois.remove((POIGral) poi))	return poi;
		else return null;
	}

	@Override
	public void setParametro(Object obj){}

	@Override
	public Integer desplegarConsola(User usuario, String terminal_ID,Scanner teclado) {
		usuario.borrarPOI(usuario.consultarPOI(terminal_ID));
		return 0;
	}

	@Override
	public String mostrarOpcion() {
		return "BORRAR POI";
	}

	public String getArchivo() {
		return archivo;
	}

	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}
}
