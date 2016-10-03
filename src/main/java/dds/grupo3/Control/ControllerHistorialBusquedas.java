package dds.grupo3.Control;

import java.util.HashMap;
import java.util.List;
import org.hibernate.Session;

import dds.grupo3.DTOs.ResultadoBusquedaDTO;
import dds.grupo3.Interfaces.BusquedaDTO;
import dds.grupo3.UsoTerminales.BusquedasHAO;
import ddsgrupo3.Factory;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class ControllerHistorialBusquedas {

	List<ResultadoBusquedaDTO> listaHistorial;
	
	public List<ResultadoBusquedaDTO> getListaHistorial() {
		return listaHistorial;
	}
	public void setListaHistorial(List<ResultadoBusquedaDTO> listaHistorial) {
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
	public List<ResultadoBusquedaDTO> obtenerBusquedas(String username,String nombre1,String nombre2,Session session){
		String parametro1 = "";
		String parametro2 = "";
		String parametro3 = "";
		String	qry	="FROM "+((String) Factory.getString("tablaDeBusqeudas")+"");
		String where = "";
		if (!username.isEmpty())
		{
			where=" WHERE ";
			parametro1 = "Terminal like '%"+username+"%'";
		}
		if (!nombre1.isEmpty())
		{
			where=" WHERE ";	
			parametro2 = "FechaD>='"+nombre1+"'";
		}
		if (!nombre2.isEmpty())
		{
			where=" WHERE ";
			parametro3 = "FechaD<='".concat(nombre2).concat("'");
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
