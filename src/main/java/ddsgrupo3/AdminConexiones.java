package ddsgrupo3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AdminConexiones {

	private Connection conexion;
	
	
	public AdminConexiones(String driver, String url, String user, String pass)
	{
		 try
		{
			//LEVANTO EL DRIVER
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			setConexion(DriverManager.getConnection(url,user,pass));
		}
		catch(Exception ex1)
		{		
			System.out.println("error1");
			ex1.printStackTrace();
			throw new RuntimeException(ex1);
		}
 	}
	 public void cerrarConexion(Connection conexion)
	 {
		 try {
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	 }
	public Connection getConexion() {
		return conexion;
	}
	public void setConexion(Connection conexion) {
		this.conexion = conexion;
	}
}
