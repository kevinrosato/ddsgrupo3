package ddsgrupo3;

import java.util.List;

public class SucursalBanco extends Local{
	private List<Servicio> servicios;
	
	//----------
	//Constructor
	//----------
	public SucursalBanco(String name)
	{
		this.setNombre(name);
		servicios = null;
	}
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
		return	(super.tieneLaClave(clave))
				||	(this.serviciosTienenLaClave(clave));
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
	
	public Servicio getServicio(Integer n) 
	{
		return servicios.get(n);
	}
	public List<Servicio> getServicios() {
		return servicios;
	}
	public void setServicio(Servicio servicio)
	{
		servicios.add(servicio);
	}
}