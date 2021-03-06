package dds.grupo3.POIsSistem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
//import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import dds.grupo3.Interfaces.POI;

@SuppressWarnings("serial")
@Entity
@Table(name="Local")
@PrimaryKeyJoinColumn(name="poi_id")
@Inheritance(strategy=InheritanceType.JOINED)
public class Local extends POI implements Serializable{
	
	@Column(name="codigoPostal")
	private Integer 	codigoPostal;
	@Column(name="departamento")
	private Byte 		departamento;
	@Column(name="piso")
	private Byte 		piso;
	@Column(name="unidad")
	private Byte 		unidad;
	@OneToOne(cascade= CascadeType.ALL) // cambie de manyToOne a oneToOne
	@JoinColumn(name = "servicio_id")
	private Servicio 	rubro; 
	
	//local no va a usar "servicios", solo sus subclases
	@ManyToMany(fetch = FetchType.LAZY,cascade= CascadeType.ALL)
	@JoinTable(name = "LocalxServicio", joinColumns = {@JoinColumn(name = "poi_id")},
	inverseJoinColumns = { @JoinColumn(name = "servicio_id") })
	private List<Servicio> servicios;
	
	@Column(name="palabrasClaves")
	private String palabrasClaves;
	
	//----------
	//Constructor
	//----------		
	
	public Local() {
		this.servicios= new ArrayList<Servicio>();
		this.codigoPostal = 0;
		this.departamento = 0;
		this.piso = 0;
		this.unidad = 0;
		this.palabrasClaves = "";
		this.rubro=null;
	}


	//----------
	//Metodos
	//----------
	
	public List<String> mostrarNombresCampos(){
		List<String> lista=new ArrayList<String>();
		lista.addAll(super.mostrarNombresCampos());
		lista.add("Codigo Postal:");
		lista.add("Departamento:");
		lista.add("Piso:");
		lista.add("Unidad:");
		//falta RUBRO
		return lista;
	}
	
	public String[] mostrarContenidosCampos(){
		String[] lista=new String[16];
		for(int i=0; i<super.mostrarContenidosCampos().length;i++){
			lista[i]=super.mostrarContenidosCampos()[i];
		}
		lista[12]=Integer.toString(this.getCodigoPostal());
		lista[13]=Byte.toString(this.getDepartamento());
		lista[14]=Byte.toString(this.getPiso());
		lista[15]=Byte.toString(this.getUnidad());
		//falta RUBRO
		return lista;
	}
	
	public void settearCampos(String[] campos){
		super.settearCampos(campos);
		if (!campos[12].isEmpty()){this.setCodigoPostal(Integer.parseInt(campos[12]));};
		if (!campos[13].isEmpty()){this.setDepartamento(Byte.parseByte(campos[13]));};
		if (!campos[14].isEmpty()){this.setPiso(Byte.parseByte(campos[14]));};
		if (!campos[15].isEmpty()){this.setUnidad(Byte.parseByte(campos[15]));};
	}
	
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
		informacion.add("Direccion=" + this.getCalle() + " " + this.getAltura());
		informacion.add("Nombre=" + this.getNombre());
		if (this.getRubro() != null) {
			informacion.add("Rubro=" + this.getRubro().getNombre());
		}
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
