package ddsgrupo3;

import java.util.ArrayList;
import java.util.List;

public class Local extends POI{
	private Integer codigoPostal=0;
	private Byte departamento=0;
	private Byte piso=0;
	private Byte unidad=0; 
	private Servicio rubro=new Servicio(""); 
	//local no va a usar "servicios", solo sus subclases
	private List<Servicio> servicios=new ArrayList<Servicio>();
	
	//----------
	//Constructor
	//----------
	//----------
	//Metodos
	//----------
	
	public String conocerTipo(){
		return "Local Comercial";
	}
	public Boolean estaCercaDe(Double latitud, Double longitud){
		return this.seEncuentraAMenosDe(latitud, longitud, this.getRubro().getRadioCercania());
	}
	public	Boolean	tieneLaClave(String clave)
	{
		return	(super.tieneLaClave(clave))
				||	(this.getPiso().toString().contains(clave)) 
				||	(this.getCodigoPostal().toString().contains(clave))
				||	(this.getDepartamento().toString().contains(clave))
				||	(this.rubro.tieneLaClave(clave));
		
	}
	
	//metodo utilizado por las subclases
	public	Boolean	serviciosTienenLaClave(String clave)
	{
		Boolean valorVerdad=false; 
		for(int i=0;i<getServicios().size();i++){	 
			if(getServicios().get(i).tieneLaClave(clave)){
				valorVerdad = true;
			}
		}
		return valorVerdad;
	}
	
	@Override
	public void mostrarInformacion()
	{
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
	public void setRubro(Servicio rubro) {
		this.rubro = rubro;
	}
	
	public Servicio getServicio(Integer n) 
	{
		return servicios.get(n);
	}
	public List<Servicio> getServicios() {
		return servicios;
	}
	public void setServicio(Servicio servicio)
	{
		this.getServicios().add(servicio);
	}
}
