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
		List<String> permisos=new ArrayList<String>();
		permisos.add("ConsultarPOI");
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
