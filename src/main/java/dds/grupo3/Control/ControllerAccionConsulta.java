package dds.grupo3.Control;

import java.util.HashMap;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import dds.grupo3.User.Usuario;

public class ControllerAccionConsulta {
	public ModelAndView show( Request request, Response response,Usuario usuario) {
		HashMap<String, Object> viewModel = new HashMap<>();
		if(request.queryParams().isEmpty())	return new ModelAndView(viewModel, "acciones.html");
		String log= request.queryParams("log");
		if (log==null) log="";
		String totalFecha=request.queryParams("totalFecha");
		if (totalFecha==null) totalFecha="";
		String totalUsuario=request.queryParams("totalUsuario");
		if (totalUsuario==null) totalUsuario="";
		Boolean boolLog=false, boolFecha=false, boolUsuario=false;
		if (log.contains("2"))	boolLog=true;
		if (totalFecha.contains("true")) boolFecha=true;
		
		if (totalUsuario.contains("true"))	boolUsuario=true;
		
		System.out.println("log="+boolLog+" totalFecha="+boolFecha+" totalUsuario="+ boolUsuario);
		
		return new ModelAndView(viewModel,"acciones.html");
	}
}
