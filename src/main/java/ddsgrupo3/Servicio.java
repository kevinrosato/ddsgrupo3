package ddsgrupo3;

import java.util.Calendar;
import java.util.List;

public class Servicio {
	private List <Horario> horario;
	private String nombre="";
	private Double radioCercania;
	
	//----------
	//Constructor
	//----------
	
	public Servicio(String name)
	{
	this.setNombre(name);
	}

	//----------
	//Metodos
	//----------	
	
	public Boolean tieneLaClave(String clave) {
		return	(this.getNombre().contains(clave));
	}
	public Boolean atendesEnEsteHorario(Calendar horario){
		return this.getHorario().stream().anyMatch(unHorario -> unHorario.estaEnElRango(horario));
	}
	
	//----------
	//Getters y Setters
	//----------
	
	public List<Horario> getHorario() {
		return horario;
	}
	public void setHorario(List<Horario> horario) {
		this.horario = horario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getRadioCercania() {
		return radioCercania;
	}
	public void setRadioCercania(Double radioCercania) {
		this.radioCercania = radioCercania;
	}
}
