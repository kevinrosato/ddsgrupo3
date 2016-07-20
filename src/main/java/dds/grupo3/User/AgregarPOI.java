package dds.grupo3.User;

import java.util.List;

import dds.grupo3.Interfaces.Funcionalidad;
import dds.grupo3.Interfaces.POIGral;

public class AgregarPOI implements Funcionalidad {
	@Override
	public POIGral realizarFuncionConPOI(List<POIGral> listaPois,POIGral poi)
	{
		if(listaPois.add(poi))	return poi;
		else return null;
	}

	@Override
	public void setParametro(Object obj){}
}
