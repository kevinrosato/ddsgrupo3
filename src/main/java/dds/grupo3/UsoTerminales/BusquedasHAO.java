package dds.grupo3.UsoTerminales;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import dds.grupo3.DTOs.ResultadoBusquedaDTO;
import dds.grupo3.Interfaces.BusquedaDTO;
import dds.grupo3.Interfaces.POI;
import ddsgrupo3.Factory;

public class BusquedasHAO {
		
//------------------------ Comienzo de Mensajes------------------------------------------------------------------------
	public	static	BusquedaDTO	guardarBusqueda(String terminalID,String param1, List<POI> pois, Integer retardo, Session session)
	{
		session.beginTransaction();
		ResultadoBusquedaDTO busqueda = (ResultadoBusquedaDTO) Factory.getObject("Busqueda");
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
    	return	busqueda;
	}
//------------------------ Comienzo de SQLs------------------------------------------------------------------------
 	
	@SuppressWarnings("unchecked")
	public static	List<BusquedaDTO>	crearDTOsDe(String qry,Session session)
	{		
		Query query= session.createQuery(qry);
		return (List<BusquedaDTO>) query.getResultList();
	}
}
