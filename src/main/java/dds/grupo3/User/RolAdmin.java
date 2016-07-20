package dds.grupo3.User;

import java.util.ArrayList;
import java.util.List;

import dds.grupo3.Interfaces.Funcionalidad;
import dds.grupo3.Interfaces.creadorRoles;
import ddsgrupo3.Factory;

public class RolAdmin implements creadorRoles
{
	@Override
	public Rol crearRol() {
		Rol admin = new Rol();
		admin.setNombre("admin");
		List<Funcionalidad> permisos = new ArrayList<Funcionalidad>();
		permisos.add((Funcionalidad) Factory.getObject("Agregar"));
		permisos.add((Funcionalidad) Factory.getObject("Borrar"));
		permisos.add((Funcionalidad) Factory.getObject("Modificar"));
		permisos.add((Funcionalidad) Factory.getObject("Consultar"));
		admin.setPermisos(permisos);
		return admin;
	}	
}
