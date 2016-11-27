package dds.grupo3.DTOs.EnDesuso;

import java.util.ArrayList;
import java.util.List;

import dds.grupo3.DTOs.CentroDTO;
import dds.grupo3.Interfaces.CGPDAO;
import dds.grupo3.Interfaces.POIGral;

public class DAOCentrosImplementacion implements CGPDAO{

	private List<CentroDTO>	centros= new ArrayList<CentroDTO>();

	public	List<POIGral>	getByKey(String clave)
	{   
		List<POIGral> listaAux = new ArrayList<POIGral>();
		
		for (CentroDTO i: centros)
		{
			POIGral	centro = new Centro(i);
			if (clave.equals(null) || centro.tieneLaClave(clave))
			{
				try {Thread.sleep(1);}
				catch (InterruptedException e)
				{e.printStackTrace();}
				
				listaAux.add(centro);
			}
		}
		return listaAux;
	}
	public	List<POIGral>	getAll()
	{   
		List<POIGral> listaAux = new ArrayList<POIGral>();
		
		for (CentroDTO i: centros)
		{
			POIGral	centro = new Centro(i);
			try {Thread.sleep(100);}
			catch (InterruptedException e)
			{e.printStackTrace();}
			
			listaAux.add(centro);
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
