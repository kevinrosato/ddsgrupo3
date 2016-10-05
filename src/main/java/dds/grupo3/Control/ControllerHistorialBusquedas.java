package dds.grupo3.Control;

import java.util.HashMap;
import java.util.List;
import org.hibernate.Session;

import dds.grupo3.BaseDeDatos.QueryBusquedas;
import dds.grupo3.DTOs.Busquedas;
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
			String dI=request.queryParams("DI");
			String mI=request.queryParams("MI");
			String yI=request.queryParams("YI");
			String dF=request.queryParams("DF");
			String mF=request.queryParams("MF");
			String yF=request.queryParams("YF");

			listaHistorial = QueryBusquedas.obtenerBusquedas(param,dI,mI,yI,dF,mF,yF,session); 
			viewModel.put("resultados", listaHistorial);
			return new ModelAndView(viewModel,"historialBusquedas.html");
		}
		else{
			return new ModelAndView(viewModel, "historialBusquedas.html");
		}
	}
}
