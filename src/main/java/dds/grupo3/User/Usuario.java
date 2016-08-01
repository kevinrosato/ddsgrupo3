package dds.grupo3.User;

import dds.grupo3.Interfaces.AdministradorPOIs;
import dds.grupo3.Interfaces.Funcionalidad;
import dds.grupo3.Interfaces.POIGral;
import dds.grupo3.Interfaces.Reporte;
import dds.grupo3.Interfaces.User;
import ddsgrupo3.Factory;

public class Usuario implements User{

	private String nombre="";
	private String contrasenia="";
	private Rol rol = new Rol();
	private AdministradorPOIs mapa = (AdministradorPOIs) Factory.getObject("AdminPOIs");
	private Funcionalidad funcionalidad;
	
	public Reporte reportePorFecha(String datoDelReporte)
	{
		funcionalidad = (Funcionalidad) Factory.getObject("Reportar");
		funcionalidad.setParametro(datoDelReporte);
		return (Reporte) realizarFunc(funcionalidad, "fecha");
	}
	
	
	public POIGral agregarPOI(POIGral poi){
		funcionalidad = (Funcionalidad) Factory.getObject("Agregar");
		return (POIGral) realizarFunc(funcionalidad, poi);
	}
	public POIGral borrarPOI(POIGral poi){
		funcionalidad = (Funcionalidad) Factory.getObject("Borrar");
		return (POIGral) realizarFunc(funcionalidad, poi);
	}
	//VER COMO SERIA PASANDOLE UNA LISTA DE CAMPOS EN VEZ DE UN POIGral NUEVO
	public POIGral modificarPOI(POIGral poi,POIGral poiNuevo){
		funcionalidad = (Funcionalidad) Factory.getObject("Modificar");
		funcionalidad.setParametro((Object) poiNuevo);
		return (POIGral) realizarFunc(funcionalidad, poi);
	}
	public POIGral consultarPOI(String terminalID){
		funcionalidad = (Funcionalidad) Factory.getObject("Consultar");
		funcionalidad.setParametro((Object) this.getMapa());
		return (POIGral) realizarFunc(funcionalidad, terminalID);
	}
	
	public Object realizarFunc(Funcionalidad funcionalidad,Object poi){
		if(rol.verificarPermisos(funcionalidad))
		{
			return mapa.realizarFuncConPoi(funcionalidad, poi);
		}
		else{
			System.out.println("No tiene permisos para realizar la accion.");
			return null;
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
	public AdministradorPOIs getMapa() {
		return mapa;
	}
	public void setMapa(AdministradorPOIs mapa) {
		this.mapa = mapa;
	}
}
