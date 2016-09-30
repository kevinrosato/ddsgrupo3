package dds.grupo3.Control;

public class ResultadoBusqueda {

	private String id;
	private String nombre;
	private String direccion;
	
	public ResultadoBusqueda(String nombre,String direccion,String id){
		this.nombre=nombre;
		this.direccion=direccion;
		this.setId(id);
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
			
}
