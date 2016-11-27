package dds.grupo3.BaseDeDatos;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dds.grupo3.Interfaces.User;
import dds.grupo3.User.Rol;

public class QueryPermisos {
	@SuppressWarnings({ "unchecked", "deprecation" })
	public static List<String> realizarBusqueda(Session session, User usuario) {
		Query query;
		if (usuario.getNombre() != "") {
			query = session
					.createQuery("FROM Rol r " + " WHERE (SELECT count(*) FROM Usuario u WHERE (u.username LIKE '"
							+ usuario.getUsername() + "') AND (r.rol_id=u.rol))>0");
			List<Rol> roles = new ArrayList<Rol>();
			roles = (List<Rol>) query.getResultList();
			if (roles.isEmpty()) {
				return null;
			} else {
				List<String> permisos = new ArrayList<String>();
				for (Rol rol : roles) {
					query = session.createSQLQuery(
							"SELECT p.permisos FROM permiso p, rol r WHERE r.rol_id=p.rol_id and r.nombre LIKE '"
									+ rol.getNombre() + "'");
					permisos.addAll((List<String>) query.getResultList());
				}
				return permisos;

			}
		} else {
			query = session.createSQLQuery(
					"SELECT p.permisos FROM permiso p, rol r WHERE r.rol_id=p.rol_id and r.nombre LIKE 'transeunte'");
			List<String> permisos = new ArrayList<String>();
			permisos = (List<String>) query.getResultList();
			return permisos;
		}
	}
}
