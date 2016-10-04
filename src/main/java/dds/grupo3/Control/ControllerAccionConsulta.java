package dds.grupo3.Control;

import java.util.HashMap;

import org.hibernate.Session;

import dds.grupo3.User.RealizarAcciones;
import dds.grupo3.User.Usuario;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class ControllerAccionConsulta {
	public ModelAndView show( Request request, Response response, Usuario user, Session session) {
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
		RealizarAcciones a=(RealizarAcciones)session.get(RealizarAcciones.class, user.getUsername());
		
		request.session().attribute("log", "false");
		a.setLogeo("N");
		request.session().attribute("totalFecha", "false");
		a.setTotal_fecha("N");
		request.session().attribute("totalUsuario", "false");
		a.setTotal_usuario("N");
		if (log.contains("2"))	{
			request.session().attribute("log", "true");
			a.setLogeo("Y");
		}
		if (totalFecha.contains("true")){
			request.session().attribute("totalFecha", "true");
			a.setTotal_fecha("Y");
		}
		
		if (totalUsuario.contains("true")){
			request.session().attribute("totalUsuario", "true");
			a.setTotal_usuario("Y");
		}
		session.beginTransaction();
    	session.saveOrUpdate(a);
    	session.getTransaction().commit();
		return new ModelAndView(viewModel,"acciones.html");
	}
}
