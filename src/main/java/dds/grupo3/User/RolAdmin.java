package dds.grupo3.User;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import dds.grupo3.Interfaces.Funcionalidad;
import dds.grupo3.Interfaces.creadorRoles;
import ddsgrupo3.Factory;

public class RolAdmin implements creadorRoles
{
	private String permisosArchivo="";
	
	@Override
	public Rol crearRol() {
		Rol admin = new Rol();
		admin.setNombre("admin");
		permisosArchivo=(String) getString(admin.getNombre());	
		String listaPermisos[]=permisosArchivo.split(",");
		System.out.println(listaPermisos.toString());
		List<Funcionalidad> permisos = new ArrayList<Funcionalidad>();
		for(String i:listaPermisos){
			permisos.add((Funcionalidad) Factory.getObject(i));
		}
		admin.setPermisos(permisos);
		return admin;
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
