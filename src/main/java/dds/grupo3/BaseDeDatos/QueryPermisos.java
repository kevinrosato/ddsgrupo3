package dds.grupo3.BaseDeDatos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import dds.grupo3.Interfaces.POIGral;
import dds.grupo3.Interfaces.User;
import dds.grupo3.User.Rol;
import dds.grupo3.User.Usuario;

public class QueryPermisos {
	public static List<String> realizarBusqueda(Session session,User usuario){
		Query query= session.createQuery("FROM Rol r "
				+ " WHERE (SELECT count(*) FROM Usuario u WHERE (u.username LIKE '"+usuario.getUsername()+"') AND (r.rol_id=u.rol))>0");
		List<Rol> roles=new ArrayList<Rol>();
		roles=(List<Rol>) query.getResultList();
		if(roles.isEmpty()){
			return null;
		}
		else{
			return roles.get(0).getPermisos();
		}
	}
}
