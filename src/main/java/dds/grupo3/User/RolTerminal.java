package dds.grupo3.User;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import dds.grupo3.Interfaces.Funcionalidad;
import dds.grupo3.Interfaces.creadorRoles;
import ddsgrupo3.Factory;

public class RolTerminal implements creadorRoles
{
	private String permisosArchivo="";
	
	@Override
	public Rol crearRol() {
		Rol rol = new Rol();
		rol.setNombre("terminal");
		permisosArchivo=(String) getString(rol.getNombre());	
		String listaPermisos[]=permisosArchivo.split(",");
		List<Funcionalidad> permisos = new ArrayList<Funcionalidad>();
		for(String i:listaPermisos){
			permisos.add((Funcionalidad) Factory.getObject(i));
		}
		rol.setPermisos(permisos);
		return rol;
	}	
	
	private static Object getString (String name)
	{
		try
		{
			FileInputStream file = new FileInputStream("Rol.properties");
			Properties propiedades = new Properties();
			propiedades.load(file);
			return propiedades.getProperty(name);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}	
	}
}
