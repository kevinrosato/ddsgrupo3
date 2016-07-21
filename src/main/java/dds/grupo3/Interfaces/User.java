package dds.grupo3.Interfaces;

import dds.grupo3.User.Rol;

public interface User
{
	public POIGral agregarPOI(POIGral poi);
	public POIGral borrarPOI(POIGral poi);
	//VER COMO SERIA PASANDOLE UNA LISTA DE CAMPOS EN VEZ DE UN POIGral NUEVO
	public POIGral modificarPOI(POIGral poi,POIGral poiNuevo);
	public POIGral consultarPOI(POIGral poi);
	public POIGral realizarFunc(Funcionalidad funcionalidad,POIGral poi);	

	public String getNombre();
	public void setNombre(String nombre);
	public String getContrasenia();
	public void setContrasenia(String contrasenia);
	public Rol getRol();
	public void setRol(Rol rol);
	public AdministradorPOIs getMapa();
	public void setMapa(AdministradorPOIs mapa);
}