package dds.grupo3.User;

import java.io.FileInputStream;
import java.util.Properties;

import dds.grupo3.Interfaces.User;
import dds.grupo3.Interfaces.creadorRoles;
import ddsgrupo3.Factory;

public class CuentasUsuario {

	public static User	instanciarUsuario(String username, String pass)
	{
		if(verificarExistencia(username, pass))
		{		
			User usuario = (User) Factory.getObject("Usuario");
			usuario.setNombre(username);
			usuario.setContrasenia(pass);
			usuario.setRol( getRol(username.concat("ROL")));
			return usuario;
		}
		System.out.println("Cuenta no existe");
		return null;	
	}
	
	private static boolean verificarExistencia(String username, String pass)
	{	
		return pass.contains((String) getString(username));
	}

	public static Rol getRol (String name)
	{
		String rolname = (String) getString(name);
		creadorRoles creador = (creadorRoles) Factory.getObject(rolname);
		return creador.crearRol();
	}
	
	private static Object getString (String name)
	{
		try
		{
			FileInputStream file = new FileInputStream("Database.properties");
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
