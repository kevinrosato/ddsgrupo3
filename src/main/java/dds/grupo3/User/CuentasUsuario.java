package dds.grupo3.User;

import dds.grupo3.Interfaces.User;
import dds.grupo3.Interfaces.creadorRoles;
import ddsgrupo3.Factory;

public class CuentasUsuario {

	public static User	instanciarUsuario(String username,String pass)
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
	
	public static Boolean requierePass(String username) {
		return !((String) Factory.getString(username)).equals("null");}

	private static boolean verificarExistencia(String username, String pass)
	{	
		return pass.contains((String) Factory.getString(username));
	}

	public static Rol getRol (String name)
	{
		String rolname = (String) Factory.getString(name);
		creadorRoles creador = (creadorRoles) Factory.getObject(rolname);
		return creador.crearRol();
	}
}
