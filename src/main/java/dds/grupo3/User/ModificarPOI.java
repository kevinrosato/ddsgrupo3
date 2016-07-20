package dds.grupo3.User;

import java.util.List;

import dds.grupo3.Interfaces.Funcionalidad;
import dds.grupo3.Interfaces.POIGral;

public class ModificarPOI implements Funcionalidad{

	private POIGral poiNuevo;
	
	@Override
	public POIGral realizarFuncionConPOI(List<POIGral> listaPois, POIGral poi)
	{
		listaPois.set(listaPois.indexOf(poi),this.poiNuevo);
		return poiNuevo;
	}
	@Override
	public void setParametro(Object obj)
	{
		poiNuevo = (POIGral) obj;
	}
}
