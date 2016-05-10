package ddsgrupo3;

import java.util.ArrayList;
import java.util.List;

public class Mapa {
	
	private List<POI> listaPois=new ArrayList<POI>();
	
	//----------
	//Metodos
	//----------

	public	List<POI>	buscarPOI(String palabraClave)	{	
		List<POI> listaAux =new ArrayList<POI>();
		for (Integer i = 0; i < this.getListaPois().size(); i++){
			if (this.getListaPois().get(i).tieneLaClave(palabraClave)){
				listaAux.add(this.getListaPois().get(i));
			}
		}
		return listaAux;	
	}
	
	public void mostrarPOIS(String palabraClave){
		List<POI> lista=buscarPOI(palabraClave);
		System.out.println("Puntos de Interes con la clave "+palabraClave+":");
		for(int i=0; i<lista.size(); i++){
			lista.get(i).mostrarInformacion();
		}
		if(lista.size()==0){
			System.out.println("No se encontraron resultados.");
		}
	}
	
	public Integer	cantPOIs()	{
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
	public void agregarPoi(POI poi){
		listaPois.add(poi);
	}
	
}
