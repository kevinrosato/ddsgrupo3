package ddsgrupo3;

public class Service 
{
	private String nombre;
	private int horario;

	//----------
	//Metodos
	//----------
	
	public Boolean tieneLaClave(String clave)
	{
		return	(clave == this.getNombre());
	}
	//----------------
	//Getters y Setters
	//----------------
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
		
}

