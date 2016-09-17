package dds.grupo3.Interfaces;

import java.util.Calendar;
import java.util.List;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


import dds.grupo3.POIsSistem.Ubicacion;

@Entity
@Table(name="POI")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class POI	implements POIGral,Serializable{
	
	@Id
    @Column(name="id")
    private int id;
	
	@Transient
	private Ubicacion ubicacion;
	
	@Column(name="nombre")
	private String nombre;
	@Column(name="barrio")
	private String barrio;
	@Column(name="calle")
	private String calle;
	@Column(name="callesPerpenIzq")
	private String callesPerpenIzq;
	@Column(name="callesPerpenDer")
	private String callesPerpenDer;
	@Column(name="localidad")
	private String localidad;
	@Column(name="provincia")
	private String provincia;
	@Column(name="pais")
	private String pais;
	@Column(name="altura")
	private Integer altura;
	@Column(name="imagen")
	private String imagen;
	

	//----------
	//Constructor
	//----------
	
	public POI() {
		super();
		this.id = 0;
		this.ubicacion = new Ubicacion(0.0,0.0);
		this.nombre = "";
		this.barrio = "";
		this.calle = "";
		this.callesPerpenIzq = "";
		this.callesPerpenDer = "";
		this.localidad = "";
		this.provincia = "";
		this.pais = "";
		this.altura = 0;
		this.imagen = "";
	}

	
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
				||	(this.getPais().contains(clave))
				||	(this.conocerTipo().contains(clave));
	}

	public Boolean esValido() {
		return (nombre!="" && ubicacion.esValido());
	}

	public Boolean estaCercaDe(Ubicacion posicion){
		return (this.seEncuentraAMenosDe(posicion, 500.00));
	}
	
	public Boolean estaCercaDePorDefecto(Ubicacion posicion){
		return (this.seEncuentraAMenosDe(posicion, 500.00));
	}

	public abstract Boolean estaDisponible(Calendar horario);
	
	public Boolean seEncuentraAMenosDe(Ubicacion posicion, Double dist)
	{
		return this.ubicacion.seEncuentraAMenosDe(posicion, dist);
	}
	public abstract List<String> mostrarInformacionAvanzada();
	
	public String[] mostrarInformacion(){
		String[] informacion=new String[2];
		informacion[0]=nombre;
		informacion[1]=calle+" "+altura;
		return informacion;
	};
	public abstract String conocerTipo();
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
	
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	public String getImagen() {
		return imagen;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}