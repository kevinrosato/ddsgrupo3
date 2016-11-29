package dds.grupo3.BaseDeDatos;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;


public class BorrarBusqueda {
	@SuppressWarnings("deprecation")
	public static void borrarBusqueda(Session session, String id) {

		String hql = "SELECT b.busqueda_id FROM Busquedas b join b.POIs p WHERE p.poi_id LIKE "+id;
		List<Integer> lista = realizarQuery(hql, session);
		if (!lista.isEmpty()) {
			Transaction t = session.beginTransaction();
			session.createSQLQuery("DELETE FROM POIsxBusqueda WHERE poi_id LIKE "+id).executeUpdate();
			session.clear();
			t.commit();
		}
	}

	@SuppressWarnings("unchecked")
	private static List<Integer> realizarQuery(String hql, Session session) {
		Query query = session.createQuery(hql);
		return (List<Integer>) query.getResultList();
	}
}
