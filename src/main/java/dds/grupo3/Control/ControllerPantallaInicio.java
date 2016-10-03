package dds.grupo3.Control;

import java.util.HashMap;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import dds.grupo3.User.RolTerminal;
import dds.grupo3.User.Usuario;

public class ControllerPantallaInicio {
	public ModelAndView show( Request request, Response response,Usuario usuario) {
		request.session().attribute("log", "false");
		request.session().attribute("totalFecha", "false");
		request.session().attribute("totalUsuario", "false");
		if(usuario.getNombre()!=""){
			usuario=new Usuario();
			usuario.setRol(new RolTerminal().crearRol());
		}
		HashMap<String, Object> viewModel = new HashMap<>();
		return new ModelAndView(viewModel, "pantallaInicio.html");
	}
}
