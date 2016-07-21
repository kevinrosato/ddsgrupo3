package dds.grupo3.User;

import java.util.List;

import dds.grupo3.Interfaces.BusquedaDTO;
import dds.grupo3.Interfaces.Funcionalidad;
import dds.grupo3.Interfaces.POIGral;
import dds.grupo3.Interfaces.User;
import dds.grupo3.UsoTerminales.BusquedasDAO;

public class ReportarPOI implements Funcionalidad {

	private User usuario;
	
	@Override
	public List<BusquedaDTO> realizarFuncionConPOI(List<POIGral> listaPois, POIGral poi)
	{
		BusquedasDAO database = new BusquedasDAO									//Valores a cambiar para la prueba
								("com.microsoft.sqlserver.jdbc.SQLServerDriver",
								"jdbc:sqlserver://Tec\\TC:1433;databaseName=busquedas",
								"dds3.POIs","dds3");
		List<BusquedaDTO> lista = database.buscar_En_Tabla(usuario.getNombre());
		
		return lista;		//Esto no está del TODO terminado
	}

	@Override
	public void setParametro(Object obj) {
		usuario = (User) obj;
	}
}
