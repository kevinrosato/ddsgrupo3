package dds.grupo3.User;

import java.util.List;

import dds.grupo3.Interfaces.Funcionalidad;
import dds.grupo3.Interfaces.POIGral;
import dds.grupo3.Interfaces.User;

public class BorrarPOI implements Funcionalidad{
	
	@Override
	public Object realizarFuncion(List<POIGral> listaPois, Object poi)
	{
		if(listaPois.remove((POIGral) poi))	return poi;
		else return null;
	}

	@Override
	public void setParametro(Object obj){}

	@Override
	public Integer desplegarConsola(User usuario, String terminal_ID) {
		usuario.borrarPOI(usuario.consultarPOI(terminal_ID));
		return 0;
	}

	@Override
	public void mostrarOpcion() {
		System.out.println("--> BORRAR POI");
	}
}
