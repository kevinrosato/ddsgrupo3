package dds.grupo3.Control;

import java.util.HashMap;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import dds.grupo3.User.Usuario;

public class ControllerAccionConsulta {
	public ModelAndView show( Request request, Response response,Usuario usuario) {
		HashMap<String, Object> viewModel = new HashMap<>();
		return new ModelAndView(viewModel, "acciones.html");
	}
}
