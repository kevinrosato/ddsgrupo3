package ddsgrupo3;

public class Ubicacion {
	private Double latitud;
	private Double longitud;
	private Integer comuna;
	
	//----------
	//Constructor
	//----------
		
	public Ubicacion(Double latitud, Double longitud)
	{
		this.setLatitud(latitud);
		this.setLongitud(longitud);
	}
	//----------
	//Metodos
	//----------
	
	public Boolean mismaComuna(Ubicacion comuna2)
	{
		return this.getComuna().equals(comuna2.getComuna());
	}
	
	public Boolean seEncuentraAMenosDe(Ubicacion posicion, Integer dist)
	{
		final int R = 6371; // Radio de la tierra
	    Double latDistance = Math.toRadians(posicion.getLatitud() - this.getLatitud());
	    Double lonDistance = Math.toRadians(posicion.getLongitud() - this.getLongitud());
	    
	    Double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
	            + Math.cos(Math.toRadians(this.getLatitud())) * Math.cos(Math.toRadians(this.getLatitud()))
	            * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
	    
	    Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
	    Double distancia = R * c * 1000; // Convertir a Metros
	    return distancia<dist;
	}	
	public Boolean esValido() {
		return (latitud!=null && longitud!=null);
	}

	//----------------
	//Getters y Setters
	//----------------
	public Integer getComuna() {
		return comuna;
	}
	public void setComuna(Integer comuna) 
	{
		this.comuna = comuna;
	}
	public void setLatitud(Double latitud) {
		this.latitud = latitud;
	}
	public Double getLatitud(){
		return latitud;
	}
	public Double getLongitud() {
		return longitud;
	}
	public void setLongitud(Double longitud) {
		this.longitud = longitud;
	}
}
