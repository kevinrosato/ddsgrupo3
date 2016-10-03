package dds.grupo3.Control;

import java.io.FileInputStream;
import org.hibernate.Session;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import dds.grupo3.BaseDeDatos.QueryUsuario;
import dds.grupo3.User.RolAdmin;
import dds.grupo3.User.Usuario;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class ControllerLogin {

	public ModelAndView show(Request request, Response response, Usuario user,Session session) {
		HashMap<String, Object> viewModel = new HashMap<>();
		// obtengo los datos ingresados en el formulario del login
		if(request.queryParams().isEmpty()) return new ModelAndView(viewModel,"login.html");
		String username=request.queryParams("usuario");
		if (username==null) username="";
		String password=request.queryParams("password");
		if (password==null) password="";
		if(QueryUsuario.realizarBusqueda(session, username, password)){
			user.setNombre(username);
			user.setContrasenia(password);
			user.setRol(new RolAdmin().crearRol());
			return new ModelAndView(viewModel, "redirectLoginAMenu.html");
		}
		else{
			viewModel.put("error", "Usted ha ingresado un usuario o password incorrecto");
			return new ModelAndView(viewModel, "login.html");
		}
	}

}
