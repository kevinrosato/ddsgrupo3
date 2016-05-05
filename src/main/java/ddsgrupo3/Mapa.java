package ddsgrupo3;

import java.util.List;

public class Mapa {
	
	private List<POI> listaPois;
	
	//----------
	//Metodos
	//----------

	public	List<POI>	buscarPOI(String palabraClave)
	{	
		List<POI> listaAux = null;
		for (Integer i = 0; i < this.getListaPois().size(); i++)
		{
			if (this.getListaPois().get(i).tieneLaClave(palabraClave))
			{
				listaAux.add(i, this.getListaPois().get(i));
			}
		}
		return listaAux;
		
	}
	public Integer	cantPOIs()
	{
		return	this.getListaPois().size();
	}
	//----------
	//Getters y Setters
	//----------

	public List<POI> getListaPois() {
		return listaPois;
	}
	public void setListaPois(List<POI> listaPois) {
		this.listaPois = listaPois;
	}	

}
