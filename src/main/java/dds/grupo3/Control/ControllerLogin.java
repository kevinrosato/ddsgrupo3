package dds.grupo3.Control;

import java.util.HashMap;
import org.hibernate.Session;

import dds.grupo3.BaseDeDatos.QueryUsuario;
import dds.grupo3.User.RealizarAcciones;
import dds.grupo3.User.Usuario;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class ControllerLogin {

	public ModelAndView show(Request request, Response response, Usuario user,Session session) {
		HashMap<String, Object> viewModel = new HashMap<>();
		if(request.queryParams().isEmpty()) return new ModelAndView(viewModel,"login.html");
		String username=request.queryParams("usuario");
		if (username==null) username="";
		String password=request.queryParams("password");
		if (password==null) password="";
		Usuario u=QueryUsuario.realizarBusqueda(session, username, password);
		
		if(u!=null){
			user.setNombre(u.getNombre());
			user.setUsername(u.getUsername());
			user.setContrasenia(u.getContrasenia());
			user.setRol(u.getRol());
			RealizarAcciones a=(RealizarAcciones)session.get(RealizarAcciones.class, user.getUsername());
			if (a==null){
				a= new RealizarAcciones();
				a.setUser(user);
				session.beginTransaction();
	        	session.saveOrUpdate(a);
	        	session.getTransaction().commit();
			}
			request.session().attribute("log", "false");
			request.session().attribute("totalFecha", "false");
			request.session().attribute("totalUsuario", "false");
			if (a.getLogeo().contains("Y"))	request.session().attribute("log", "true");
			if (a.getTotal_fecha().contains("Y"))request.session().attribute("totalFecha", "true");
			if (a.getTotal_usuario().contains("Y"))request.session().attribute("totalUsuario", "true");
		//	System.out.println("log "+request.session().attribute("log"));
		//	System.out.println("totalfecha "+request.session().attribute("totalFecha"));
		//	System.out.println("totalusuario "+request.session().attribute("totalUsuario"));
			return new ModelAndView(viewModel, "redirectLoginAMenu.html");
		}
		else{
			viewModel.put("error", "Usted ha ingresado un usuario o password incorrecto");
			return new ModelAndView(viewModel, "login.html");
		}
	}
}
