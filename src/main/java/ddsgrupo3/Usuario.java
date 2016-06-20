package ddsgrupo3;

import dds.grupo3.POIsSistem.POI;

public class Usuario {

	private Rol rol=new Rol();
	private Mapa mapa=new Mapa();
	private Funcionalidad funcionalidad;
	
	public void agregarPOI(POI poi){
		funcionalidad=new AgregarPOI();
		realizarFunc(funcionalidad, poi);
	}
	public void borrarPOI(POI poi){
		funcionalidad=new BorrarPOI();
		realizarFunc(funcionalidad, poi);
	}
	//VER COMO SERIA PASANDOLE UNA LISTA DE CAMPOS EN VEZ DE UN POI NUEVO
	public void modificarPOI(POI poi,POI poiNuevo){
		funcionalidad=new ModificarPOI(poiNuevo);
		realizarFunc(funcionalidad, poi);
	}
	public void consultarPOI(POI poi){
		funcionalidad=new ConsultarPOI();
		realizarFunc(funcionalidad, poi);
	}
	
	public void realizarFunc(Funcionalidad funcionalidad,POI poi){
		if(rol.verificarPermisos(funcionalidad)){
			mapa.realizarFuncConPoi(funcionalidad, poi);
		}
		else{
			
		}
	}
}
