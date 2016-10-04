package dds.grupo3.Control;

import java.util.HashMap;

import dds.grupo3.Interfaces.User;
import dds.grupo3.User.RolTerminal;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class ControllerPantallaInicio {
	public ModelAndView show( Request request, Response response,User usuario) {
		
		if(usuario.getNombre()!=""){
			usuario.setNombre("");
			usuario.setContrasenia("");
			usuario.setUsername("");
			usuario.setRol(new RolTerminal().crearRol());
		}
		HashMap<String, Object> viewModel = new HashMap<>();
		return new ModelAndView(viewModel, "pantallaInicio.html");
	}
}
