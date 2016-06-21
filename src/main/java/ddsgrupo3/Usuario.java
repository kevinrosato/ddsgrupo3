package ddsgrupo3;

import dds.grupo3.POIsSistem.POI;

public class Usuario {

	private String nombre="";
	private String contrasenia="";
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
		funcionalidad=new ConsultarPOI(this.getMapa());
		realizarFunc(funcionalidad, poi);
	}
	
	public void realizarFunc(Funcionalidad funcionalidad,POI poi){
		if(rol.verificarPermisos(funcionalidad)){
			mapa.realizarFuncConPoi(funcionalidad, poi);
		}
		else{
			System.out.println("No tiene permisos para realizar la accion.");
		}
	}
	
	//GETTERS Y SETTERS
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}
	public Mapa getMapa() {
		return mapa;
	}
	public void setMapa(Mapa mapa) {
		this.mapa = mapa;
	}
	
	
}
