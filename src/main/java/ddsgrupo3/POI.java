package ddsgrupo3;

import java.util.List;

public class POI {

	private String barrio;
	private String calle;
	private String localidad;
	private int altura;
	private int latitud;
	private int longitud;
	List<TipoDePoi> pois;
	
	public void setLatitud(int platitud) {
		this.latitud = platitud;
		
	}

	public int getLatitud(){
		return latitud;
	}

}