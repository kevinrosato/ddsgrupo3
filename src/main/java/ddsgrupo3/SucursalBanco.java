package ddsgrupo3;

import java.util.List;

public class SucursalBanco extends Local{
	
	//----------
	//Constructor
	//----------
	public SucursalBanco(String name)
	{
		super(name);
	}
	//----------
	//Metodos
	//----------	
	public String conocerTipo(){
		return "Sucursal De Banco";
	}
	
/*	public Boolean estaCercaDe (Double latitud,Double longitud){
		return estaCercaDePorDefecto(latitud,longitud);
	}
*/	public Boolean estaCercaDe (Ubicacion lugar){
	return estaCercaDePorDefecto(lugar);
	}
	

	public	Boolean	tieneLaClave(String clave){
		return	(super.tieneLaClave(clave))
				||	(super.serviciosTienenLaClave(clave));
	}
	
	public void mostrarInformacion(){
		System.out.println("Banco "+this.getNombre());
	}

	//----------
	//Getters y Setters
	//----------
	
	public Servicio getServicio(Integer n){
		return super.getServicio(n);
	}
	public List<Servicio> getServicios(){
		return super.getServicios();
	}
	public void setServicio(String nameServicio)
	{
		super.setServicio(nameServicio);
	}
}