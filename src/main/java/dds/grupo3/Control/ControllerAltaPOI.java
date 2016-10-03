package dds.grupo3.Control;

import java.util.HashMap;

import dds.grupo3.Interfaces.User;
import dds.grupo3.User.RolTerminal;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class ControllerAltaPOI {

	public static ModelAndView show( Request request, Response response,User usuario) {
		Integer opcion=request.attribute("a");
		System.out.println(opcion);
		HashMap<String, Object> viewModel = new HashMap<>();
		return new ModelAndView(viewModel, "agregarPOI.html");
	}
}
