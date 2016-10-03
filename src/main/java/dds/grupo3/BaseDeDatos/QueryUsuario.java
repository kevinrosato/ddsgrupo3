package dds.grupo3.BaseDeDatos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import dds.grupo3.Interfaces.POIGral;
import dds.grupo3.User.Usuario;

public class QueryUsuario {
	public static boolean realizarBusqueda(Session session,String usuario,String password){
		Query query= session.createQuery("FROM Usuario u WHERE (u.username LIKE '"+usuario+"') AND (u.contrasenia LIKE '"+password+"')");
	    List<Usuario> u=query.getResultList();
	    if(u.isEmpty()){
	    	return false;
	    }
		System.out.println("Encontrados");
		return true;
	}
}
