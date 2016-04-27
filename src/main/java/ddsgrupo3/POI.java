package ddsgrupo3;

import java.util.List;

public class POI {
	private String nombre;
	private String barrio;
	private String calle;
	private String localidad;
	private int altura;
	private Double latitud;
	private Double longitud;
	List<TipoDePoi> pois;
	
	public void setLatitud(Double latitud) {
		this.latitud = latitud;
		
	}

	public Double getLatitud(){
		return latitud;
	}
	public Boolean esValido() {
		  return (!nombre.equals(null) && !latitud.equals(null) && !longitud.equals(null));
	}
}