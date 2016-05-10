package ddsgrupo3;

public class SucursalBanco extends Local{
	
	//----------
	//Constructor
	//----------
	public SucursalBanco(String name){
		this.setNombre(name);
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
	

}