package ddsgrupo3;

public class Local extends POI{
	private Integer codigoPostal;
	private Byte departamento;
	private Byte piso;
	private Byte unidad; 
	private Servicio rubro; 
	
	//----------
	//Constructor
	//----------
	//----------
	//Metodos
	//----------
	
	public String conocerTipo(){
		return "Local Comercial";
	}
	public Boolean estaCercaDe(Double latitud, Double longitud){
		return this.seEncuentraAMenosDe(latitud, longitud, this.getRubro().getRadioCercania());
	}
	public	Boolean	tieneLaClave(String clave)
	{
		return	(super.tieneLaClave(clave))
				||	(this.getPiso().toString().contains(clave)) 
				||	(this.getCodigoPostal().toString().contains(clave))
				||	(this.getDepartamento().toString().contains(clave))
				||	(this.rubro.tieneLaClave(clave));
		
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
	public Byte getUnidad() {
		return unidad;
	}
	public void setUnidad(Byte unidad) {
		this.unidad = unidad;
	}
	public Servicio getRubro() {
		return rubro;
	}
	public void setRubro(Servicio rubro) {
		this.rubro = rubro;
	}
}
