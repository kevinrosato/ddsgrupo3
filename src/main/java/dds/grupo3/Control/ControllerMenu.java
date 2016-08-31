package dds.grupo3.Control;

import java.util.HashMap;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class ControllerMenu {

	public ModelAndView show( Request request, Response response) {
		HashMap<String, Object> viewModel = new HashMap<>();
		return new ModelAndView(viewModel, "menuPrincipal.html");
	}
}
