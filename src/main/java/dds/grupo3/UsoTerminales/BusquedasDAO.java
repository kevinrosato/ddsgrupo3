package dds.grupo3.UsoTerminales;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import dds.grupo3.Interfaces.BusquedaDTO;
import ddsgrupo3.Factory;

public class BusquedasDAO {
	
	private Connection conexion = null;

//------------------------ Comienzo de Mensajes------------------------------------------------------------------------
	public	Integer	guardarBusqueda(String terminal, String frase, Integer cantResultados,Long retardo)
	{
		Calendar fecha = new GregorianCalendar();
		String fechaS = Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
		fechaS = fechaS.concat("/");
		fechaS = fechaS.concat(Integer.toString(1 + fecha.get(Calendar.MONTH)));
		fechaS = fechaS.concat("/");
		fechaS = fechaS.concat(Integer.toString(1 + fecha.get(Calendar.YEAR)));
		System.out.println("Busqueda: "+frase+", "+fechaS+", "
				+terminal+", "+cantResultados.toString()+", "+retardo.toString());
		return this.agregarATabla(frase,terminal,fechaS,cantResultados,retardo);
	}
//------------------------ Comienzo de Conexion------------------------------------------------------------------------
	 public Connection getConexion()
	{
		return conexion;
	}
	public	BusquedasDAO ()
	{
		this.conectarseA("com.microsoft.sqlserver.jdbc.SQLServerDriver",
		"jdbc:sqlserver://Tec\\TC:1433;databaseName=Busquedas",
		"dds3.POIs","dds3");
	}
 	private void conectarseA(String driver,String url,String usuario,String pass)
 	{
		try
		{
			//LEVANTO EL DRIVER
			Class.forName(driver);
			conexion = DriverManager.getConnection(url,usuario,pass);
		}
		catch(Exception ex1)
		{		
			System.out.println("error1");
			ex1.printStackTrace();
			throw new RuntimeException(ex1);
		}
 	}
	 public void cerrarConexion()
	 {
		 try {
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	 }
	 
	 
//------------------------ Comienzo de SQLs------------------------------------------------------------------------
 
	private Integer agregarATabla(String frase, String fecha, String terminal, Integer cantResultados, Long retardo)
	{
		CallableStatement consulta = null;
		try {
		    consulta = conexion.prepareCall
		    		("INSERT INTO dbo.Consultas_Realizadas OUTPUT Inserted.ID "
		    		+ "VALUES ('"+frase+"','"+terminal+"'"
		    		+ ",'"+fecha+"',"+cantResultados.toString()+","+retardo.toString()+")");
			consulta.executeQuery();
			System.out.println();
			return 0;
		}
		catch (Exception e){
		e.printStackTrace();
		throw new RuntimeException(e);
		}
	}
	public List<BusquedaDTO> buscar_Por(String parametro, String clave,String Info){
		CallableStatement consulta = null;
		ResultSet resultados = null;
		List<BusquedaDTO> lista = new ArrayList<>();
		try {
			    consulta = conexion.prepareCall("SELECT "+Info+" FROM dbo.Consultas_Realizadas"
			    		+ " WHERE ("+parametro+" = '"+clave+"')");
				consulta.execute();
		    resultados = consulta.executeQuery();
			while( resultados.next() ){
				BusquedaDTO elemento = (BusquedaDTO) Factory.getObject("BusquedaDTO");
				elemento.setTerminal(resultados.getString("Terminal"));	
				elemento.setFecha(resultados.getString("Fecha"));
				elemento.setParametro(resultados.getString("Parametro"));
				elemento.setCantRespuestas(resultados.getInt("Resultados"));
				elemento.setRetardo(resultados.getLong("Demora"));
				lista.add(elemento);			
			}
		return lista;
		} catch (Exception e4) {
			e4.printStackTrace();
			throw new RuntimeException(e4);
		}
	}
	public List<String> buscar_Fechas_Por(String parametro, String clave)
	{
		CallableStatement consulta = null;
		ResultSet resultados = null;
		List<String> lista = new ArrayList<>();
		try {
			    consulta = conexion.prepareCall("SELECT Fecha FROM dbo.Consultas_Realizadas"
			    		+ " WHERE ("+parametro+" = '"+clave+"')");
				consulta.execute();
		    resultados = consulta.executeQuery();
			while( resultados.next() ){
				lista.add(resultados.getString(1));			
			}
		return lista;
		} catch (Exception e4) {
			e4.printStackTrace();
			throw new RuntimeException(e4);
		}
	}
}
