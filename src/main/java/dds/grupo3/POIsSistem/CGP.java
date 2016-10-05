package dds.grupo3.POIsSistem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="CGP")
@PrimaryKeyJoinColumn(name="poi_id")
public class CGP extends Local implements Serializable{
	@Column(name="numeroCGP")
	private Byte numeroCGP;
	
	//----------
	//Constructor
	//----------
	public CGP (String name,Byte numeroCGP)
	{
		this.setNumeroCGP(numeroCGP);
		this.setNombre(name);
	}
	public CGP ()
	{
		this.setNumeroCGP((byte) 0);
		this.setNombre("");
	}
	//----------
	//Metodos
	//----------
		
	public List<String> mostrarNombresCampos(){
		List<String> lista=new ArrayList<String>();
		lista.addAll(super.mostrarNombresCampos());
		lista.add("Numero de CGP:");
		return lista;
	}
	public void settearCampos(String[] campos){
		super.settearCampos(campos);
		if (!campos[16].isEmpty()){this.setNumeroCGP(Byte.parseByte(campos[16]));};
	}
	
	public String conocerTipo(){
		return "CGP";
	}
	
	@Override
	public Boolean estaCercaDe(Ubicacion posicion){
		return this.getPosicion().mismaComuna(posicion);		
	}

	public	Boolean	tieneLaClave(String clave) {
		return	(super.tieneLaClave(clave))
				||	(this.getNumeroCGP().toString().contains(clave))
				||	(super.serviciosTienenLaClave(clave));
	}
	
	@Override
	public List<String> mostrarInformacionAvanzada() {
		List<String> informacion=new ArrayList<String>();
		informacion.addAll(super.mostrarInfo());
		String servicios="";
		for(Servicio s:this.getServicios()){
			if(!servicios.equals("")){servicios=servicios+"-"+s.toString();}
			else {servicios=s.toString();}
		}
		informacion.add("Servicios="+servicios);
		return informacion;
	}
	
	// Disponibilidad para CGP
	public Boolean estaDisponible (Calendar horario, String nombreServicio){
		Servicio servicio=getServicios().get(0);
		for(int i=0;!servicio.tieneLaClave(nombreServicio);i++){
			servicio=getServicios().get(i);
		}
		return servicio.atendesEnEsteHorario(horario);
	}
	
	public Boolean estaDisponible (Calendar horario){
		// tiene que mostrar al menos 1 servicio en el CGP que este atendiendo a esa hora
		return this.getServicios().stream().anyMatch(unServicio->unServicio.atendesEnEsteHorario(horario));
	}
	
	//----------
	//Getters y Setters
	//----------

	public Servicio getServicio(Integer n){
		return super.getServicio(n);
	}
	public List<Servicio> getServicios(){
		return super.getServicios();
	}
	public void setServicio(Servicio servicio)
	{
		getServicios().add(servicio);
	}
	public Byte getNumeroCGP() {
		return numeroCGP;
	}
	public void setNumeroCGP(Byte numeroCGP) {
		this.numeroCGP = numeroCGP;
	}
}
