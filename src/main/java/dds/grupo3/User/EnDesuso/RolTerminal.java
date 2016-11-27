package dds.grupo3.User.EnDesuso;

import java.util.ArrayList;
import java.util.List;

import dds.grupo3.Interfaces.EnDesuso.creadorRoles;
import dds.grupo3.User.Rol;

public class RolTerminal implements creadorRoles
{
	@SuppressWarnings("unused")
	private String permisosArchivo="";
	
	@Override
	public Rol crearRol() {
		Rol rol = new Rol();
		rol.setNombre("terminal");
		List<String> permisos=new ArrayList<String>();
		permisos.add("ConsultarPOI");
		rol.setPermisos(permisos);
		return rol;
	}	
}
