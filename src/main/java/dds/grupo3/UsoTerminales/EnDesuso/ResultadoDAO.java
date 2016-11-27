package dds.grupo3.UsoTerminales.EnDesuso;

import java.sql.CallableStatement;

import dds.grupo3.OtrasClases.Factory;
import dds.grupo3.OtrasClases.EnDesuso.AdminConexiones;

public class ResultadoDAO {
	
	private static AdminConexiones admin = new AdminConexiones(
			"com.microsoft.sqlserver.jdbc.SQLServerDriver",
			((String) Factory.getString("urlBaseDeDatos")),
			"dds3.POIs","dds3");
	
	public static void agregarABaseDeDatos(String fechaIni, String fechaFin, String proceso, String Resultado, String Error)
	{
		System.out.println("Agregando a la Base de Datos un Resultado");
		CallableStatement consulta = null;
		try {
		    consulta = admin.getConexion().prepareCall("INSERT INTO "
 				+((String) Factory.getString("tablaDeResultados"))+
		    	" VALUES ('"+fechaIni+"','"+fechaFin+"'"
		    	+",'"+proceso+"','"+Resultado+"','"+Error+"')");
			consulta.execute();
		}
		catch (Exception e){
		e.printStackTrace();
		throw new RuntimeException(e);
		}
	}
}

