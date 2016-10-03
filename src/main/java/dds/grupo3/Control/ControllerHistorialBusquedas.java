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
			String dI=request.queryParams("DI");
			String mI=request.queryParams("MI");
			String yI=request.queryParams("YI");
			String dF=request.queryParams("DF");
			String mF=request.queryParams("MF");
			String yF=request.queryParams("YF");

			listaHistorial = obtenerBusquedas(param,dI,mI,yI,dF,mF,yF,session); 
			viewModel.put("resultados", listaHistorial);
			return new ModelAndView(viewModel,"historialBusquedas.html");
		}
		else{
			return new ModelAndView(viewModel, "historialBusquedas.html");
		}
	}
	public List<Busquedas> obtenerBusquedas(String username,String dI,String mI,String yI,String dF,String mF,String yF,Session session){
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
		if (!yF.isEmpty() || !mF.isEmpty()|| !dF.isEmpty())
		{
			where=" WHERE ";	
			parametro2 = "b.Fecha>= "+yF+"-"+mF+"-"+dF;
		}
		if (!yI.isEmpty() || !mI.isEmpty()|| !dI.isEmpty())
		{
			where=" WHERE ";
			parametro3 = "b.Fecha<= "+yI+"-"+mI+"-"+dI;
		}
		
		if(!username.isEmpty())
		{
			if(!yI.isEmpty() || !mI.isEmpty()|| !dI.isEmpty() || !yF.isEmpty() || !mF.isEmpty()|| !dF.isEmpty())
			{
				parametro1.concat(" AND ");		
			}
		}
		if(!yI.isEmpty() || !mI.isEmpty()|| !dI.isEmpty())
		{
			if(!yF.isEmpty() || !mF.isEmpty()|| !dF.isEmpty())
			{
				parametro2.concat(" AND ");		
			}
		}
		qry	=	qry.concat(where).concat(parametro1).concat(parametro2).concat(parametro3);
		this.setListaHistorial(BusquedasHAO.crearDTOsDe(qry, session));
		return this.getListaHistorial();
	}
}
