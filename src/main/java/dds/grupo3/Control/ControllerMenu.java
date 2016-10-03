package dds.grupo3.Control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hibernate.Session;

import dds.grupo3.BaseDeDatos.QueryPermisos;
import dds.grupo3.Interfaces.Funcionalidad;
import dds.grupo3.Interfaces.User;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class ControllerMenu {

	public ModelAndView show( Request request, Response response,User usuario,Session session) {
		HashMap<String, Object> viewModel = new HashMap<>();
		List<String> permisos = new ArrayList<String>();
		List<OpcionDelMenu> opcionesMenu = new ArrayList<OpcionDelMenu>();
		permisos=buscarPermisos(session,usuario);
		for(String p:permisos){
			try {
				System.out.println("dds.grupo3.User."+p);
				Funcionalidad func = (Funcionalidad) Class.forName("dds.grupo3.User."+p).newInstance();
				OpcionDelMenu opcion=new OpcionDelMenu(func.getArchivo(),func.mostrarOpcion());
				opcionesMenu.add(opcion);
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		viewModel.put("opcionesMenu", opcionesMenu);
		return new ModelAndView(viewModel, "menuPrincipal.html");
	}
	private static List<String> buscarPermisos(Session session, User usuario){
		List<String> permisos = new ArrayList<String>();
		permisos=QueryPermisos.realizarBusqueda(session, usuario);
		if(permisos!=null){
			return permisos;
		}
		else{
			return usuario.getRol().getPermisos();
		}
	}
}
