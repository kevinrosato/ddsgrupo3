package ddsgrupo3;

public class SucursalBanco extends Local{
	private Servicio[] servicios;
	
	//----------
	//Metodos
	//----------
	
	public String conocerTipo(){
		return "Sucursal De Banco";
	}
	public Boolean estaCercaDe (Double latitud,Double longitud){
		return estaCercaDePorDefecto(latitud,longitud);
	}
	//----------
	//Getters y Setters
	//----------
	
	public Servicio[] getServicios() {
		return servicios;
	}
	public void setServicios(Servicio[] servicios) {
		this.servicios = servicios;
	}
	
}
