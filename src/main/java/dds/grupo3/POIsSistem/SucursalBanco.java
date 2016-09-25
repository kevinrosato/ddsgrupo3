package dds.grupo3.POIsSistem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="SucursalBanco")
@PrimaryKeyJoinColumn(name="poi_id")
public class SucursalBanco extends Local implements Serializable{
	
	//----------
	//Constructor
	//----------
	public SucursalBanco(String name)
	{
		this.setNombre(name);
	}
	//----------
	//Metodos
	//----------	
	
	public String conocerTipo(){
		return "Sucursal";
	}

	public	Boolean	tieneLaClave(String clave){
		return	(super.tieneLaClave(clave))
				||	(super.serviciosTienenLaClave(clave));
	}
	
//	public void mostrarInformacion(){
//		System.out.println("Banco "+this.getNombre());
//	}
	
	public Boolean estaCercaDe(Ubicacion lugar){
		return this.estaCercaDePorDefecto(lugar);
	}
	
	//CODIGO DUPLICADO con CGP, ver bien como solucionar
	// Disponibilidad para Banco
	public Boolean estaDisponible (Calendar horario, String nombreServicio){
		Servicio servicio=getServicios().get(0);
		for(int i=0;!servicio.tieneLaClave(nombreServicio);i++){
			servicio=getServicios().get(i);
		}
		return servicio.atendesEnEsteHorario(horario);
	}
	
	public Boolean estaDisponible (Calendar horario){
		// tiene que mostrar al menos 1 servicio en el Banco que este atendiendo a esa hora
		return this.getServicios().stream().anyMatch(unServicio->unServicio.atendesEnEsteHorario(horario));
	}
	
	@Override
	public List<String> mostrarInformacionAvanzada(){
		List<String> informacion=new ArrayList<String>();
		informacion.addAll(super.mostrarInfo());
		String servicios="";
		for(Servicio s:this.getServicios()){
			if(!servicios.equals("")){servicios=servicios+", "+s.getNombre();}
			else {servicios=s.getNombre();}
		}
		informacion.add("Servicios="+servicios);
		return informacion;
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
}