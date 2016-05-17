package ddsgrupo3;

import java.util.Calendar;
import java.util.List;

public class SucursalBanco extends Local{
	
	//----------
	//Constructor
	//----------
	public SucursalBanco(String name)
	{
		super(name);
	}
	//----------
	//Metodos
	//----------	
	
	public String conocerTipo(){
		return "Sucursal De Banco";
	}

	public	Boolean	tieneLaClave(String clave){
		return	(super.tieneLaClave(clave))
				||	(super.serviciosTienenLaClave(clave));
	}
	
	public void mostrarInformacion(){
		System.out.println("Banco "+this.getNombre());
	}
	
	public Boolean estaCercaDe(Ubicacion lugar){
		return super.estaCercaDePorDefecto(lugar);
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