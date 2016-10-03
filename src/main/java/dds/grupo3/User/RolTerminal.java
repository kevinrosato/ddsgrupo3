package dds.grupo3.User;

import java.util.ArrayList;
import java.util.List;

import dds.grupo3.Interfaces.creadorRoles;

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
