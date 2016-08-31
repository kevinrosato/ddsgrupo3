package dds.grupo3.UsoTerminales;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import dds.grupo3.Interfaces.BusquedaDTO;
import ddsgrupo3.AdminConexiones;
import ddsgrupo3.Factory;

public class BusquedasDAO {
	
	private static AdminConexiones admin = new AdminConexiones("com.microsoft.sqlserver.jdbc.SQLServerDriver",
			((String) Factory.getString("urlBaseDeDatos")),
			"dds3.POIs","dds3");
	
//------------------------ Comienzo de Mensajes------------------------------------------------------------------------
	public	static	Integer	guardarBusqueda(String terminal, String frase, Integer cantResultados,Long retardo)
	{
		Calendar fecha = new GregorianCalendar();
		String fechaS = Integer.toString(1 + fecha.get(Calendar.MONTH));
		fechaS = fechaS.concat("-");
		fechaS = fechaS.concat(Integer.toString(fecha.get(Calendar.DAY_OF_MONTH)));
		fechaS = fechaS.concat("-");
		fechaS = fechaS.concat(Integer.toString(fecha.get(Calendar.YEAR)));
		String fecha2 = Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
		fecha2 = fecha2.concat("/");
		fecha2 = fecha2.concat(Integer.toString(1 + fecha.get(Calendar.MONTH)));
		fecha2 = fecha2.concat("/");
		fecha2 = fecha2.concat(Integer.toString(fecha.get(Calendar.YEAR)));
		return	agregarATabla(frase,fecha2,terminal,cantResultados,retardo,fechaS);
	}
//------------------------ Comienzo de SQLs------------------------------------------------------------------------
 
	private	static	Integer agregarATabla(String frase, String fechaFalsa,String terminal,Integer cantResultados, Long retardo,String fecha)
	{
		CallableStatement consulta = null;
		ResultSet resultados = null;
		Integer auxiliar = null;
		try {
		    consulta = admin.getConexion().prepareCall("INSERT INTO "
 				+((String) Factory.getString("tablaDeBusqeudas"))+
		    	" VALUES ('"+frase+"','"+fechaFalsa+"','"+terminal+"'"
		    	+","+cantResultados.toString()+","+retardo.toString()+",'"+fecha+"')");
		    consulta.execute();
			
			consulta = null;
			
		    consulta = admin.getConexion().prepareCall("SELECT TOP 1 F.ID FROM "
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
		    consulta = admin.getConexion().prepareCall(qry);
			consulta.execute();
			resultados = consulta.executeQuery();
			return resultados;
		} catch (Exception e4) {
			e4.printStackTrace();
			throw new RuntimeException(e4);
		}
	}
	public static	List<BusquedaDTO>	crearDTOsDe(String qry)
	{
		List<BusquedaDTO>	lista = new ArrayList<>();
		ResultSet r = null;
		r = ejecutar(qry);
		try {
			while(r.next())
			{
				BusquedaDTO dto = (BusquedaDTO) Factory.getObject("Busqueda");
				dto.setParametro(r.getString(2));
				dto.setTerminal(r.getString(4));
				dto.setCantRespuestas(r.getInt(5));
				dto.setRetardo(r.getInt(6));
				if (r.getDate(7)==null){
					dto.setFecha(r.getString(3));
				}
				else{
					dto.setFecha(r.getDate(7).toString());
				}
				lista.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
}
