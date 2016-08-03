package ddsgrupo3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AdminConexiones {

	public static Connection conectarA(String driver, String url, String user, String pass)
	{
		 try
		{
			//LEVANTO EL DRIVER
			Class.forName(driver);
			return DriverManager.getConnection(url,user,pass);
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
}
