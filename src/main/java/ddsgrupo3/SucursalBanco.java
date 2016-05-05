package ddsgrupo3;

import java.util.List;

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
		Boolean valorVerdad; Integer i=0;
		valorVerdad = this.getServicio(i).tieneLaClave(clave);
		while (!valorVerdad)
			{	 
			valorVerdad = (this.getServicio(i).tieneLaClave(clave)) || valorVerdad;
			}
		return valorVerdad;
	}
	//----------
	//Getters y Setters
	//----------
	
	public Service getServicio(Integer n) 
	{
		return servicios.get(n);
	}
	public List<Service> getServicios() {
		return servicios;
	}
	public void setServicios(List<Service> servicios) {
		this.servicios = servicios;
	}
}