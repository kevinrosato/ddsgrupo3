package dds.grupo3.UsoTerminales;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import dds.grupo3.DTOs.ResultadoBusquedaDTO;
import dds.grupo3.Interfaces.BusquedaDTO;
import dds.grupo3.Interfaces.POI;
import ddsgrupo3.AdminConexiones;
import ddsgrupo3.Factory;

public class BusquedasHAO {
		
//------------------------ Comienzo de Mensajes------------------------------------------------------------------------
	public	static	Integer	guardarBusqueda(String terminalID,String param1, List<POI> pois, Integer retardo, Session session)
	{
		for(POI i:pois)
		{
			System.out.println(i.toString());
		}
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

		System.out.println("Guardando Busqueda");
		session.save(busqueda);
		session.getTransaction().commit();
		System.out.println("Fin Transaccion");
    	return	id_UltimoAgregado();
	}
//------------------------ Comienzo de SQLs------------------------------------------------------------------------
 
	private	static	Integer id_UltimoAgregado()
	{
		AdminConexiones admin = new AdminConexiones("com.microsoft.sqlserver.jdbc.SQLServerDriver",
				((String) Factory.getString("urlBaseDeDatos")),
				"dds3.POIs","dds3");
		CallableStatement consulta = null;
		ResultSet resultados = null;
		Integer auxiliar = null;
		try {
			consulta = admin.getConexion().prepareCall("SELECT TOP 1 F.busqueda_id FROM "
				+((String) Factory.getString("tablaDeBusqeudas"))+
				" F ORDER BY F.busqueda_id DESC");
			resultados = consulta.executeQuery();
			while(resultados.next())	auxiliar = resultados.getInt(1);     
			} catch (SQLException e) {
			e.printStackTrace();
		}
		return auxiliar;
	}
	
	@SuppressWarnings("unchecked")
	public static	List<BusquedaDTO>	crearDTOsDe(String qry,Session session)
	{
		
		Query query= session.createQuery(qry);
		return (List<BusquedaDTO>) query.getResultList();
	}
}
