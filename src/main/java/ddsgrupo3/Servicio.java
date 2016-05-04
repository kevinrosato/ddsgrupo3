package ddsgrupo3;

import java.util.List;

public class Servicio {
	private List <Horario> horario;
	private String nombre;
	private Double radioCercania;
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
