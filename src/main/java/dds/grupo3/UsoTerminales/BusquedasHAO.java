package dds.grupo3.UsoTerminales;

import java.util.List;
import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.persistence.Query;
import org.hibernate.Session;
import dds.grupo3.DTOs.Busquedas;
import dds.grupo3.Interfaces.POI;
import ddsgrupo3.Factory;

public class BusquedasHAO {
		
//------------------------ Comienzo de Mensajes------------------------------------------------------------------------
	public	static	Busquedas	guardarBusqueda(String terminalID,String param1, List<POI> pois, Integer retardo, Session session)
	{
		System.out.println("Grabando Busqueda");
		session.beginTransaction();
		Busquedas busqueda = (Busquedas) Factory.getObject("Busqueda");
		Calendar fecha = new GregorianCalendar();
		Date hoy = new Date(fecha.getTimeInMillis());
		busqueda.setCantRespuestas(pois.size());
		busqueda.setFecha(hoy);
		busqueda.setParametro(param1);
		busqueda.setRetardo(retardo);
		busqueda.setTerminal(terminalID);
		busqueda.setPOIs(pois);

		session.save(busqueda);
		session.getTransaction().commit();
		System.out.println("Guardado");
    	return	busqueda;
	}
	public static	List<Busquedas>	crearDTOsDe(String qry,Session session)
	{	
		System.out.println("Buscando: "+qry);
		Query query = session.createQuery(qry);
		System.out.println("Flag");
		@SuppressWarnings("unchecked")
		List<Busquedas> lista = query.getResultList();
		System.out.println(lista.toString());
		return lista;
	}
}
