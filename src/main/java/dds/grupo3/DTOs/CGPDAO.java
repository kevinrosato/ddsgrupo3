package dds.grupo3.DTOs;

import java.util.ArrayList;
import java.util.List;

import dds.grupo3.POIsSistem.Centro;
import dds.grupo3.POIsSistem.POI;

public class CGPDAO {

	private List<CentroDTO>	centros;

	public	List<POI>	getByKey(String clave)
	{
		List<POI> listaAux = new ArrayList<POI>();
		for (CentroDTO i: centros)
		{
			POI	centro = new Centro(i);
			if (centro.tieneLaClave(clave))
			{
				listaAux.add(centro);
			}
		}
		return listaAux;
	}
	
	public List<CentroDTO> getCentros() {
		return centros;
	}
	public void setCentros(List<CentroDTO> Centros) {
		centros = Centros;
	}
}
