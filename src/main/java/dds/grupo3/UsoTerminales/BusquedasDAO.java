package dds.grupo3.UsoTerminales;

import java.sql.CallableStatement;
import java.sql.Connection;

import java.sql.ResultSet;
import java.util.Calendar;
import java.util.GregorianCalendar;

import ddsgrupo3.AdminConexiones;
import ddsgrupo3.Factory;

public class BusquedasDAO {
	
	private static Connection conexion = AdminConexiones.conectarA(
			"com.microsoft.sqlserver.jdbc.SQLServerDriver",
			((String) Factory.getString("urlBaseDeDatos")),
			"dds3.POIs","dds3");
	
//------------------------ Comienzo de Mensajes------------------------------------------------------------------------
	public	static	Integer	guardarBusqueda(String terminal, String frase, Integer cantResultados,Long retardo)
	{
		Calendar fecha = new GregorianCalendar();
		String fechaS = Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
		fechaS = fechaS.concat("/");
		fechaS = fechaS.concat(Integer.toString(1 + fecha.get(Calendar.MONTH)));
		fechaS = fechaS.concat("/");
		fechaS = fechaS.concat(Integer.toString(fecha.get(Calendar.YEAR)));
		return	agregarATabla(frase,terminal,fechaS,cantResultados,retardo);
	}
//------------------------ Comienzo de SQLs------------------------------------------------------------------------
 
	private	static	Integer agregarATabla(String frase, String fecha, String terminal, Integer cantResultados, Long retardo)
	{
		CallableStatement consulta = null;
		ResultSet resultados = null;
		Integer auxiliar = null;
		try {
		    consulta = conexion.prepareCall("INSERT INTO "
 				+((String) Factory.getString("tablaDeBusqeudas"))+
		    	" VALUES ('"+frase+"','"+terminal+"'"
		    	+",'"+fecha+"',"+cantResultados.toString()+","+retardo.toString()+")");
			consulta.execute();
			
			consulta = null;
			
		    consulta = conexion.prepareCall("SELECT TOP 1 F.ID FROM "
		    		+((String) Factory.getString("tablaDeBusqeudas"))+
		    		" F ORDER BY F.ID DESC");
			consulta.execute();
		    resultados = consulta.executeQuery();
		    while(resultados.next())	auxiliar = resultados.getInt(1); 
		    return auxiliar;
		}
		catch (Exception e){
		e.printStackTrace();
		throw new RuntimeException(e);
		}
	}
	public static	ResultSet ejecutar(String qry)
	{
		CallableStatement consulta = null;
		ResultSet resultados = null;
		try {
		    consulta = conexion.prepareCall(qry);
			consulta.execute();
			resultados = consulta.executeQuery();
			return resultados;
		} catch (Exception e4) {
			e4.printStackTrace();
			throw new RuntimeException(e4);
		}
	}
}
