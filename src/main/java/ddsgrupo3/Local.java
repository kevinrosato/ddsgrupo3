package ddsgrupo3;

public class Local extends POI{
	private Integer codigoPostal;
	private Byte departamento;
	private Byte piso;
	private Byte unidad; 
	private Service rubro; 
	
	
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
		Boolean valorVerdad;
		valorVerdad = super.tieneLaClave(clave);
		valorVerdad = (clave == this.getPiso().toString()) || valorVerdad;
		valorVerdad = (clave == this.getCodigoPostal().toString()) || valorVerdad;
		valorVerdad = (clave == this.getDepartamento().toString()) || valorVerdad;
		valorVerdad = (this.getRubro().tieneLaClave(clave)) || valorVerdad;
		return valorVerdad;
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
	public Service getRubro() {
		return rubro;
	}
	public void setRubro(Service rubro) {
		this.rubro = rubro;
	}
}
