package dds.grupo3.User.EnDesuso;

import dds.grupo3.Interfaces.User;
import dds.grupo3.Interfaces.EnDesuso.UserCounts;
import dds.grupo3.Interfaces.EnDesuso.creadorRoles;
import dds.grupo3.OtrasClases.Factory;
import dds.grupo3.User.Rol;

public class CuentasUsuario implements UserCounts{

	public User	instanciarUsuario(String username,String pass)
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
	
	public Boolean requierePass(String username)
	{
		return !((String) Factory.getString(username)).equals("null");
	}
		
	private boolean verificarExistencia(String username, String pass)
	{	
		return pass.contains((String) Factory.getString(username));
	}

	public Rol getRol (String name)
	{
		String rolname = (String) Factory.getString(name);
		creadorRoles creador = (creadorRoles) Factory.getObject(rolname);
		return creador.crearRol();
	}
}
