package dds.grupo3.UsoTerminales;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.List;

import dds.grupo3.Interfaces.BusquedaDTO;
import dds.grupo3.Interfaces.TipoReporte;
import dds.grupo3.Interfaces.User;
import ddsgrupo3.Factory;

public class BusquedasDAO {
	
	private Connection conexion = null;

//------------------------ Comienzo de Mensajes------------------------------------------------------------------------
	public	void	guardarBusqueda(User terminal, String frase, Integer cantResultados,Integer retardo)
	{
		Calendar fecha = new GregorianCalendar();
		String fechaS = Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
		fechaS = fechaS.concat("/");
		fechaS = fechaS.concat(Integer.toString(1 + fecha.get(Calendar.MONTH)));
		fechaS = fechaS.concat("/");
		fechaS = fechaS.concat(Integer.toString(1 + fecha.get(Calendar.YEAR)));
		this.agregarATabla(frase,terminal.getNombre(),fechaS,cantResultados,retardo);
	}	
	public	Hashtable<Object, Object>	reportar(String tipoReporte){
		return ((TipoReporte) Factory.getObject(tipoReporte)).reportarEnTabla(this);
	}

//------------------------ Comienzo de Conexion------------------------------------------------------------------------
	 public Connection getConexion()
	{
		return conexion;
	}
 	public BusquedasDAO(String driver,String url,String usuario,String pass)
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
 
	private Integer agregarATabla(String frase, String terminal, String fecha, Integer cantResultados, Integer retardo) {
		CallableStatement consulta = null;
		try {
		    consulta = conexion.prepareCall("{call dbo.st_agregar_busqueda(?,?,?,?,?,?)}");
			consulta.registerOutParameter(1, java.sql.Types.INTEGER);
			consulta.setString(2, frase);
			consulta.setString(3, terminal);
			consulta.setString(4, fecha);
			consulta.setInt(5,cantResultados);
			consulta.setInt(6,retardo);
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
		    consulta = conexion.prepareCall("{call dbo.st_buscar(?)}");
			consulta.setString(1, palabraClave);
			consulta.execute();
			resultados = consulta.executeQuery();
			
			while( resultados.next() ){
				BusquedaDTO elemento = (BusquedaDTO) Factory.getObject("BusquedaDTO");
				elemento.setTerminal(resultados.getString("terminal"));			//TODO esto y lo de abajo
				elemento.setFecha(resultados.getString("fecha"));
				elemento.setParametro(resultados.getString("parametro"));
				elemento.setCantRespuestas(resultados.getInt(5)); 						//esta provisorio
				elemento.setRetardo(resultados.getInt(6));
				lista.add(elemento);			
			}
		return lista;
		} catch (Exception e4) {
			e4.printStackTrace();
			throw new RuntimeException(e4);
		}
 }
}
