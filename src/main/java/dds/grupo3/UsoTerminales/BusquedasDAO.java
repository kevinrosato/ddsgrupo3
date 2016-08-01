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
import dds.grupo3.Interfaces.User;
import ddsgrupo3.Factory;

public class BusquedasDAO {
	
	private Connection conexion = null;

//------------------------ Comienzo de Mensajes------------------------------------------------------------------------
	public	Integer	guardarBusqueda(User terminal, String frase, Integer cantResultados,Long retardo)
	{
		Calendar fecha = new GregorianCalendar();
		String fechaS = Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
		fechaS = fechaS.concat("/");
		fechaS = fechaS.concat(Integer.toString(1 + fecha.get(Calendar.MONTH)));
		fechaS = fechaS.concat("/");
		fechaS = fechaS.concat(Integer.toString(1 + fecha.get(Calendar.YEAR)));
		return this.agregarATabla(frase,terminal.getNombre(),fechaS,cantResultados,retardo);
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
 
	private Integer agregarATabla(String frase, String terminal, String fecha, Integer cantResultados, Long retardo) {
		CallableStatement consulta = null;
		try {
		    consulta = conexion.prepareCall
		    		("INSERT INTO dbo.Consultas_Realizadas"
		    		+ " OUTPUT Inserted.ID "
		    		+ "VALUES ('?','?','?','?'?");
			consulta.setString(1, frase);
			consulta.setString(2, fecha);
			consulta.setString(3, terminal);
			consulta.setInt(4,cantResultados);
			consulta.setLong(5,retardo);
			consulta.execute();
			return consulta.getInt(1);		
		}
		catch (Exception e){
		e.printStackTrace();
		throw new RuntimeException(e);
		}
	}
	public List<BusquedaDTO> buscar_En_Tabla(String palabraClave){
	 
		CallableStatement consulta = null;
		ResultSet resultados = null;
		List<BusquedaDTO> lista = new ArrayList<>();
		try {
		    consulta = conexion.prepareCall("SELECT * FROM dbo.[Tabla Busquedas] WHERE (terminal = '?') OR (fecha = '?')");
			consulta.setString(1, palabraClave);
			consulta.setString(2, palabraClave);
			consulta.execute();
			resultados = consulta.executeQuery();
			
			while( resultados.next() ){
				BusquedaDTO elemento = (BusquedaDTO) Factory.getObject("BusquedaDTO");
				elemento.setTerminal(resultados.getString("Terminal"));	
				elemento.setFecha(resultados.getString("Fecha"));
				elemento.setParametro(resultados.getString("Frase"));
				elemento.setCantRespuestas(resultados.getInt("Resultados"));
				elemento.setRetardo(resultados.getLong("Retardo"));
				lista.add(elemento);			
			}
		return lista;
		} catch (Exception e4) {
			e4.printStackTrace();
			throw new RuntimeException(e4);
		}
	}
}
