package ddsgrupo3;

public class Service 
{
	private String nombre;
	private int horario;
	private Double radio;
	//----------
	//Metodos
	//----------
	
	public Boolean tieneLaClave(String clave)
	{
		return	(this.getNombre().contains(clave));
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
		
}

