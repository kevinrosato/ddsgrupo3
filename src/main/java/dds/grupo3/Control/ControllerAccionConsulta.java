package dds.grupo3.Control;

import java.util.HashMap;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class ControllerAccionConsulta {
	public ModelAndView show( Request request, Response response) {
		HashMap<String, Object> viewModel = new HashMap<>();
		//System.out.println(request.session().attribute("log"));
		//System.out.println(request.session().attribute("totalFecha"));
		//System.out.println(request.session().attribute("totalUsuario"));
		if(request.queryParams().isEmpty())	return new ModelAndView(viewModel, "acciones.html");
		String log= request.queryParams("log");
		if (log==null) log="";
		String totalFecha=request.queryParams("totalFecha");
		if (totalFecha==null) totalFecha="";
		String totalUsuario=request.queryParams("totalUsuario");
		if (totalUsuario==null) totalUsuario="";
		//Boolean boolLog=false, boolFecha=false, boolUsuario=false;
		request.session().attribute("log", "false");
		request.session().attribute("totalFecha", "false");
		request.session().attribute("totalUsuario", "false");
		if (log.contains("2"))	{
			//boolLog=true;
			request.session().attribute("log", "true");
		}
		if (totalFecha.contains("true")){
			//boolFecha=true;
			request.session().attribute("totalFecha", "true");
		}
		
		if (totalUsuario.contains("true")){
			//boolUsuario=true;
			request.session().attribute("totalUsuario", "true");
		}
		
		//System.out.println("log="+boolLog+" totalFecha="+boolFecha+" totalUsuario="+ boolUsuario);
		
		return new ModelAndView(viewModel,"acciones.html");
	}
}
