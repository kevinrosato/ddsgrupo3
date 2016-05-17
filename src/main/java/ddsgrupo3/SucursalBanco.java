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
	
/*	public Boolean estaCercaDe (Double latitud,Double longitud){
		return estaCercaDePorDefecto(latitud,longitud);
	}
*/	public Boolean estaCercaDe (Ubicacion lugar){
	return estaCercaDePorDefecto(lugar);
	}
	

	public	Boolean	tieneLaClave(String clave){
		return	(super.tieneLaClave(clave))
				||	(super.serviciosTienenLaClave(clave));
	}
	
	public void mostrarInformacion(){
		System.out.println("Banco "+this.getNombre());
	}
	
	public Boolean estaDisponible (Calendar horario, Servicio servicio){
		Integer horaSolicitada= horario.get(Calendar.HOUR_OF_DAY)*100+horario.get(Calendar.MINUTE);
		//	return (horaSolicitada>=10 && horaSolicitada<=15);	
		return (servicio.atendesEnEsteHorario(horario) && horaSolicitada>=10 && horaSolicitada<=15) ;
		// falta analizar q sea de lunes a viernes
	
	}
	
	public Boolean estaDisponible (Calendar horario){
		Integer horaSolicitada= horario.get(Calendar.HOUR_OF_DAY)*100+horario.get(Calendar.MINUTE);

		return (this.getServicios().stream().anyMatch(unServicio->unServicio.atendesEnEsteHorario(horario) &&
				horaSolicitada>=10 && horaSolicitada<=15));
		// tmb falta analizar q sea de lunes a viernes horario de banco
		
	
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
	public void setServicio(String nameServicio)
	{
		super.setServicio(nameServicio);
	}
}