package dds.grupo3.User;

import java.util.ArrayList;
import java.util.List;

import dds.grupo3.Interfaces.Funcionalidad;
import dds.grupo3.Interfaces.creadorRoles;
import ddsgrupo3.Factory;

public class RolStandar implements creadorRoles
{
	@Override
	public Rol crearRol() {
		Rol rol = new Rol();
		rol.setNombre("standar");
		List<Funcionalidad> permisos = new ArrayList<Funcionalidad>();
		permisos.add((Funcionalidad) Factory.getObject("Consultar"));
		rol.setPermisos(permisos);
		return rol;
	}	
}
