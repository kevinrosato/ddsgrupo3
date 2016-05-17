package ddsgrupo3;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Local extends POI{
	
	private Integer 	codigoPostal = 0;
	private Byte 		departamento = 0;
	private Byte 		piso = 0;
	private Byte 		unidad = 0; 
	private Servicio 	rubro=new Servicio(""); 
	//local no va a usar "servicios", solo sus subclases
	private List<Servicio> servicios=new ArrayList<Servicio>();
	
	//----------
	//Constructor
	//----------
		
	public Local (String name)
	{
		this.setNombre(name);
		rubro = new Servicio("");
	}
	//----------
	//Metodos
	//----------
	
	public String conocerTipo(){
		return "Local Comercial";
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
		for(int i=0; i<getServicios().size(); i++){	 
			if(getServicios().get(i).tieneLaClave(clave)){
				valorVerdad = true;
			}
		}
		return valorVerdad;
	}
	
	@Override
	public void mostrarInformacion(){
		System.out.println("Local "+this.getNombre());
	}
	
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
	public void setRubro(String rubroName)
	{
		Servicio rubroVenta = new Servicio(rubroName);
		this.rubro = rubroVenta;
	}
	protected Servicio getServicio(Integer n){
		return servicios.get(n);
	}
	protected List<Servicio> getServicios(){
		return servicios;
	}
	protected void setServicio(String nameServicio)
	{
		Servicio servicio = new Servicio(nameServicio);
		this.getServicios().add(servicio);
	}
}
