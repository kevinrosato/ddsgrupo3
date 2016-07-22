package dds.grupo3.User;

import java.util.List;

import dds.grupo3.Interfaces.Funcionalidad;
import dds.grupo3.Interfaces.POIGral;

public class BorrarPOI implements Funcionalidad{
	
	@Override
	public Object realizarFuncionConPOI(List<POIGral> listaPois, Object poi)
	{
		if(listaPois.remove((POIGral) poi))	return poi;
		else return null;
	}

	@Override
	public void setParametro(Object obj){}
}
