package dds.grupo3.UsoTerminales;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.hibernate.Session;

import dds.grupo3.Interfaces.BusquedaDTO;
import dds.grupo3.Interfaces.POI;
import ddsgrupo3.AdminConexiones;
import ddsgrupo3.Factory;

public class BusquedasHAO {
		
//------------------------ Comienzo de Mensajes------------------------------------------------------------------------
	public	static	Integer	guardarBusqueda(String terminalID,String param1, String param2, List<POI> pois, Integer retardo, Session session)
	{
		BusquedaDTO busqueda = (BusquedaDTO) Factory.getObject("Busqueda");
		Calendar fecha = new GregorianCalendar();
		Date hoy = new Date(fecha.getTimeInMillis());
		busqueda.setCantRespuestas(pois.size());
		busqueda.setFecha(hoy);
		busqueda.setParametro(param1);
		busqueda.setRetardo(retardo);
		busqueda.setTerminal(terminalID);
		busqueda.setPOIs(pois);

		session.beginTransaction();
		session.save(busqueda);
    	session.getTransaction().commit();

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
			consulta = admin.getConexion().prepareCall("SELECT TOP 1 F.ID FROM "
				+((String) Factory.getString("tablaDeBusqeudas"))+
				" F ORDER BY F.ID DESC");
			resultados = consulta.executeQuery();
			while(resultados.next())	auxiliar = resultados.getInt(1);     
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return auxiliar;
	}
}
