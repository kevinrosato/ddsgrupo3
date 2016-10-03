package dds.grupo3.Control;

import java.util.HashMap;
import java.util.List;
import org.hibernate.Session;

import dds.grupo3.DTOs.Busquedas;
import dds.grupo3.UsoTerminales.BusquedasHAO;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class ControllerHistorialBusquedas {

	List<Busquedas> listaHistorial;
	
	public List<Busquedas> getListaHistorial() {
		return listaHistorial;
	}
	public void setListaHistorial(List<Busquedas> listaHistorial) {
		this.listaHistorial = listaHistorial;
	}
	public ModelAndView show( Request request, Response response, Session session) {
		HashMap<String, Object> viewModel = new HashMap<>();
		if(!request.queryParams().isEmpty()){
			String param=request.queryParams("paramU");
			String fechaI=request.queryParams("paramF1");
			String fechaF=request.queryParams("paramF2");

			listaHistorial = obtenerBusquedas(param,fechaI,fechaF,session); 
			viewModel.put("resultados", listaHistorial);
			return new ModelAndView(viewModel,"historialBusquedas.html");
		}
		else{
			return new ModelAndView(viewModel, "historialBusquedas.html");
		}
	}
	public List<Busquedas> obtenerBusquedas(String username,String nombre1,String nombre2,Session session){
		String parametro1 = "";
		String parametro2 = "";
		String parametro3 = "";
		String	qry	="FROM Busquedas b";
		String where = "";
		if (!username.isEmpty())
		{
			where=" WHERE ";
			parametro1 = "b.Terminal like '%"+username+"%'";
		}
		if (!nombre1.isEmpty())
		{
			where=" WHERE ";	
			parametro2 = "b.FechaD>='"+nombre1+"'";
		}
		if (!nombre2.isEmpty())
		{
			where=" WHERE ";
			parametro3 = "b.FechaD<='".concat(nombre2).concat("'");
		}
		
		if(!username.isEmpty())
		{
			if(!nombre1.isEmpty() || !nombre2.isEmpty())
			{
				parametro1.concat(" AND ");		
			}
		}
		if(!nombre1.isEmpty())
		{
			if(!nombre2.isEmpty())
			{
				parametro2.concat(" AND ");		
			}
		}
		qry	=	qry.concat(where).concat(parametro1).concat(parametro2).concat(parametro3);
		this.setListaHistorial(BusquedasHAO.crearDTOsDe(qry, session));
		return this.getListaHistorial();
	}
}
