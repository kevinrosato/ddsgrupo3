package ddsgrupo3;

public abstract class POI {
	private String nombre;
	private String barrio;
	private String calle;
	private String[] callesPerpendiculares;
	private String localidad;
	private String provincia;
	private String pais;
	private Integer altura;
	private Double latitud;
	private Double longitud;
	
	//----------
	//Metodos
	//----------
	public Boolean esValido() {
		return (nombre!=null && latitud!=null && longitud!=null);
	}
	
	public Boolean estaCercaDePorDefecto(Double latitud, Double longitud){
		return (this.seEncuentraAMenosDe(latitud, longitud, 500.00));
	}
	
	public Boolean seEncuentraAMenosDe (Double latitud, Double longitud,Double dist){
		final int R = 6371; // Radio de la tierra
	    Double latDistance = Math.toRadians(latitud - this.getLatitud());
	    Double lonDistance = Math.toRadians(longitud - this.getLongitud());
	    
	    Double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
	            + Math.cos(Math.toRadians(this.getLatitud())) * Math.cos(Math.toRadians(latitud))
	            * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
	    
	    Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
	    Double distancia = R * c * 1000; // Convertir a Metros
	    return distancia<dist;
	}
	
	//----------------
	//Getters y Setters
	//----------------
	public void setLatitud(Double latitud) {
		this.latitud = latitud;
	}
	public Double getLatitud(){
		return latitud;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getBarrio() {
		return barrio;
	}
	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public Integer getAltura() {
		return altura;
	}
	public void setAltura(Integer altura) {
		this.altura = altura;
	}
	public Double getLongitud() {
		return longitud;
	}
	public void setLongitud(Double longitud) {
		this.longitud = longitud;
	}
	public String[] getCallesPerpendiculares() {
		return callesPerpendiculares;
	}
	public void setCallesPerpendiculares(String[] callesPerpendiculares) {
		this.callesPerpendiculares = callesPerpendiculares;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
    
}