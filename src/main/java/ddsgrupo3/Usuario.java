package ddsgrupo3;

import dds.grupo3.POIsSistem.POI;

public class Usuario {

	private Rol rol=new Rol();
	private Mapa mapa=new Mapa();
	
	public void agregarPOI(POI poi){
		rol.realizarFuncPoi(0, mapa, poi);
	}
	public void borrarPOI(POI poi){
		rol.realizarFuncPoi(1, mapa, poi);
	}
	public void modificarPOI(POI poi){
		rol.realizarFuncPoi(2, mapa, poi);
	}
	public void consultarPOI(POI poi){
		rol.realizarFuncPoi(3, mapa, poi);
	}
}
