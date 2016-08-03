package dds.grupo3.UsoTerminales;

import java.sql.CallableStatement;
import java.sql.Connection;

import ddsgrupo3.AdminConexiones;
import ddsgrupo3.Factory;

public class ResultadoDAO {	
	private static Connection conexion = AdminConexiones.conectarA(
			"com.microsoft.sqlserver.jdbc.SQLServerDriver",
	 		((String) Factory.getString("urlBaseDeDatos")),
			"dds3.POIs","dds3");

	public static void agregarABaseDeDatos(String fechaIni, String fechaFin, String proceso, String Resultado, String Error)
	{
		CallableStatement consulta = null;
		try {
		    consulta = conexion.prepareCall("INSERT INTO "
 				+((String) Factory.getString("tablaDeResultados"))+
		    	" VALUES ('"+fechaIni+"','"+fechaFin+"'"
		    	+",'"+proceso+"',"+Resultado+","+Error+")");
			consulta.execute();
		}
		catch (Exception e){
		e.printStackTrace();
		throw new RuntimeException(e);
		}
	}
}

