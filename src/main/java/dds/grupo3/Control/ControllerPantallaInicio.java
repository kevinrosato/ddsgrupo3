package dds.grupo3.Control;

import java.util.HashMap;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class ControllerPantallaInicio {
	public ModelAndView show( Request request, Response response) {
		request.session().attribute("log", "false");
		request.session().attribute("totalFecha", "false");
		request.session().attribute("totalUsuario", "false");
//		if(usuario.getNombre()!=""){
//			usuario.setNombre("");
//			usuario.setContrasenia("");
//			usuario.setRol(new RolTerminal().crearRol());
//		}
		HashMap<String, Object> viewModel = new HashMap<>();
		return new ModelAndView(viewModel, "pantallaInicio.html");
	}
}
