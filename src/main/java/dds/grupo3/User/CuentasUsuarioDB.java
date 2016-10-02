package dds.grupo3.User;

import dds.grupo3.Interfaces.User;
import dds.grupo3.Interfaces.UserCounts;
import javax.persistence.Query;
import org.hibernate.Session;

public class CuentasUsuarioDB implements UserCounts{

	private Session session;
	public CuentasUsuarioDB(Session sessionRECV) {
	session = sessionRECV;
	}

	public User	instanciarUsuario(String username,String pass)
	{
		String hql = "FROM Usuario u WHERE u.username = '"+username+"' AND u.contrasenia = '"+pass+"'";
		System.out.println("Buscando: "+hql);
		Query query= session.createQuery(hql);
		Usuario user = (Usuario) query.getSingleResult();
		return user;
	}
}
