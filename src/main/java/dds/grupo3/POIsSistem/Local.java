package dds.grupo3.POIsSistem;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import dds.grupo3.Interfaces.POI;

public class Local extends POI{
	
	private Integer 	codigoPostal = 0;
	private Byte 		departamento = 0;
	private Byte 		piso = 0;
	private Byte 		unidad = 0; 
	private Servicio 	rubro = new Servicio(""); 
	//local no va a usar "servicios", solo sus subclases
	private List<Servicio> servicios = new ArrayList<Servicio>();
	private String palabrasClaves="";
	
	//----------
	//Constructor
	//----------
		
	public Local (String name)
	{
		this.setNombre(name);
	}
	//----------
	//Metodos
	//----------
	
	public String conocerTipo(){
		return "Local";
	}
	
	public Boolean estaCercaComoPOI(Ubicacion lugar){
		return super.estaCercaDe(lugar);
	}
		
	public Boolean estaCercaDe(Ubicacion lugar)
	{	
		return this.seEncuentraAMenosDe(lugar, this.getRubro().getRadioCercania());
	}
	
	public Boolean estaDisponible(Calendar horario){
		return rubro.atendesEnEsteHorario(horario);
	}
	
	@Override
	public	Boolean	tieneLaClave(String clave){
		return	((super.tieneLaClave(clave))
				||	(this.getPiso().toString().contains(clave)) 
				||	(this.getCodigoPostal().toString().contains(clave))
				||	(this.getDepartamento().toString().contains(clave))
				||	(this.rubro.tieneLaClave(clave)));		
	}
	
	//metodo utilizado por las subclases
	public	Boolean	serviciosTienenLaClave(String clave){
		Boolean valorVerdad=false; 
		for(Servicio i: this.getServicios())
		{	if(i.tieneLaClave(clave))	valorVerdad = true;		}
		return valorVerdad;
	}
	//metodo de cgp y banco
	public List<String> mostrarInfo(){
		List<String> informacion=new ArrayList<String>();
		informacion.add("Direccion="+this.getCalle()+" "+this.getAltura());
		informacion.add("Zona="+this.getBarrio());
		return informacion;
	}
	
	
	@Override
	public List<String> mostrarInformacionAvanzada() {
		List<String> informacion=new ArrayList<String>();
		informacion.add("Direccion="+this.getCalle()+" "+this.getAltura());
		informacion.add("Nombre="+this.getNombre());
		informacion.add("Rubro="+this.getRubro().getNombre());
		return informacion;
	}
	
//	@Override
//	protected void mostrarInformacionServicios(){
//		System.out.println(""+this.conocerTipo()+": "+this.getNombre()+",\n servicios:"+this.getServicios().);
//	}
//	public void mostrarInformacion(){
//		System.out.println("Local "+this.getNombre());
//	}
	
	//----------
	//Getters y Setters
	//----------

	public Integer getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(Integer codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	public Byte getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Byte departamento) {
		this.departamento = departamento;
	}
	public Byte getPiso() {
		return piso;
	}
	public void setPiso(Byte piso) {
		this.piso = piso;
	}
	public Byte getUnidad() {
		return unidad;
	}
	public void setUnidad(Byte unidad) {
		this.unidad = unidad;
	}
	public Servicio getRubro() {
		return rubro;
	}
	public void setRubro(Servicio rubro)
	{
		this.rubro = rubro;
	}
	public Servicio getServicio(Integer n){
		return servicios.get(n);
	}
	public List<Servicio> getServicios(){
		return servicios;
	}
	public void setServicio(String nameServicio)
	{
		Servicio servicio = new Servicio(nameServicio);
		this.getServicios().add(servicio);
	}

	public String getPalabrasClaves() {
		return palabrasClaves;
	}

	public void setPalabrasClaves(String palabrasClaves) {
		this.palabrasClaves = palabrasClaves;
	}

}
