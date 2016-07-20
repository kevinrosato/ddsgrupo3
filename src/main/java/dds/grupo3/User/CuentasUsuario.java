package dds.grupo3.User;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import dds.grupo3.Interfaces.User;
import ddsgrupo3.Factory;

public class CuentasUsuario {

	private static List<Rol> roles = new ArrayList<>();
	
	public static User	instanciarUsuario(String username, String pass)
	{
		if(verificarExistencia(username, pass))
		{		
			User usuario = (User) Factory.getObject("Usuario");
			usuario.setNombre(username);
			usuario.setContrasenia(pass);
			usuario.setRol(getRol(username.concat("ROL")));
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
		for(Rol i: roles)
		{
			System.out.println(i.getNombre());
			if(i.getNombre().contains(rolname))	return i;
		}
		return null;
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
	
	public static void agregarRol(Rol r)
	{
		roles.add(r);
	}
}
