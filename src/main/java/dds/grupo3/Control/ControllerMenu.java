package dds.grupo3.Control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import dds.grupo3.Interfaces.Funcionalidad;
import dds.grupo3.Interfaces.User;
import dds.grupo3.User.Usuario;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class ControllerMenu {

	public ModelAndView show( Request request, Response response,User usuario) {
		HashMap<String, Object> viewModel = new HashMap<>();
		List<Funcionalidad> permisos = new ArrayList<Funcionalidad>();
		List<OpcionDelMenu> opcionesMenu = new ArrayList<OpcionDelMenu>();
		permisos=usuario.getRol().getPermisos();
		for(Funcionalidad func:permisos){
			OpcionDelMenu opcion=new OpcionDelMenu(func.getArchivo(),func.mostrarOpcion());
			opcionesMenu.add(opcion);
		}
		viewModel.put("opcionesMenu", opcionesMenu);
		return new ModelAndView(viewModel, "menuPrincipal.html");
	}
}
