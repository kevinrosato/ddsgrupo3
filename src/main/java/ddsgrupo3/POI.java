package ddsgrupo3;

import java.util.Calendar;

public abstract class POI {
	private Ubicacion ubicacion=new Ubicacion(0.0,0.0);
	private String nombre="";
	private String barrio="";
	private String calle="";
	private String callesPerpenIzq="";
	private String callesPerpenDer="";
	private String localidad="";
	private String provincia="";
	private String pais="";
	private Integer altura=0;
	
	//----------
	//Metodos
	//----------
	
	public	Boolean	tieneLaClave(String clave){
		return	(this.getNombre().contains(clave))
				||	(this.getBarrio().contains(clave))
				||	(this.getCalle().contains(clave))
				||	(this.getLocalidad().contains(clave))
				||	(this.getCallesPerpenIzq().contains(clave))
				||	(this.getCallesPerpenDer().contains(clave))
				||	(this.getProvincia().contains(clave))
				||	(this.getPais().contains(clave));
	}

	public Boolean esValido() {
		return (nombre!="" && ubicacion.esValido());
	}

	public Boolean estaCercaDePorDefecto(Ubicacion posicion){
		return (this.seEncuentraAMenosDe(posicion, 500.00));
	}

	public abstract Boolean estaDisponible(Calendar horario);
	
	public Boolean seEncuentraAMenosDe(Ubicacion posicion, Double dist)
	{
		return this.ubicacion.seEncuentraAMenosDe(posicion, dist);
	}

	public abstract void mostrarInformacion();
	
	//----------------
	//Getters y Setters
	//----------------
	
	public Ubicacion getPosicion()
	{
	return this.ubicacion;
	}
	public void setComuna(Integer comuna) 
	{
	this.ubicacion.setComuna(comuna);
	}
	public Double getLongitud() {
	return this.ubicacion.getLongitud();
	}
	public void setLongitud(Double longitud) {
	this.ubicacion.setLongitud(longitud);
	}
	public Double getLatitud(){
		return this.ubicacion.getLatitud();
	}
	public void setLatitud(Double latitud) {
		this.ubicacion.setLatitud(latitud);
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
	public String getCallesPerpenIzq() {
		return callesPerpenIzq;
	}
	public String getCallesPerpenDer() {
		return callesPerpenDer;
	}
	public void setCallesPerpenIzq(String callesPerpenIzq) {
		this.callesPerpenIzq= callesPerpenIzq;
	}
	public void setCallesPerpenDer(String callesPerpenDer) {
		this.callesPerpenDer= callesPerpenDer;
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