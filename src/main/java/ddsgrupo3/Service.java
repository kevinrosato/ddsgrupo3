package ddsgrupo3;

public class Service 
{
	private String nombre;
	private Horario horario;
	private Double radio;
	//----------
	//Metodos
	//----------
	
	public Boolean tieneLaClave(String clave) {
		return(this.getNombre().contains(clave));
	}
	
	//----------------
	//Getters y Setters
	//----------------
	
	public Double getRadioCercania() {
		return radio;
	}
	public void setRadioCercania(Double r) {
		this.radio = r;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Horario getHorario() {
		return horario;
	}
	public void setHorario(Horario horario) {
		this.horario = horario;
	}
	public Double getRadio() {
		return radio;
	}
	public void setRadio(Double radio) {
		this.radio = radio;
	}
		
}

