package ddsgrupo3;

public class Local implements TipoDePoi{
	private Integer codigoPostal;
	private Byte departamento;
	private Byte piso;
	//private Byte unidad;  No entiendo muy bien que hace este atributo
	//private Servicio rubro; Todavia no implementamos servicios
	
	
	//----------
	//Metodos
	//----------
	
	public String conocerTipo(){
		return "Local Comercial";
	}

	//----------
	//Getters y Setters
	//----------

	public Integer getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(Integer codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	public Byte getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Byte departamento) {
		this.departamento = departamento;
	}
	public Byte getPiso() {
		return piso;
	}
	public void setPiso(Byte piso) {
		this.piso = piso;
	}
}
