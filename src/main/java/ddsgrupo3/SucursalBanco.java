package ddsgrupo3;

public class SucursalBanco extends Local{
	private List<Service> servicios;
	
	//----------
	//Metodos
	//----------
	
	public String conocerTipo(){
		return "Sucursal De Banco";
	}
	public Boolean estaCercaDe (Double latitud,Double longitud){
		return estaCercaDePorDefecto(latitud,longitud);
	}
	public	Boolean	tieneLaClave(String clave)
	{
		Boolean valorVerdad;
		valorVerdad = super.tieneLaClave(clave);
		valorVerdad = (this.serviciosTienenLaClave(clave)) || valorVerdad;
		return valorVerdad;
	}
	public	Boolean	serviciosTienenLaClave(String clave)
	{
		return this.getServicios().contains());
	}
	//----------
	//Getters y Setters
	//----------
	
	public Service[] getServicios() {
		return servicios;
	}
	public void setServicios(Service[] servicios) {
		this.servicios = servicios;
	}
}
