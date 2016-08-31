package dds.grupo3.Control;

import java.util.HashMap;






import dds.grupo3.Interfaces.User;
import dds.grupo3.User.CuentasUsuario;
import dds.grupo3.User.Usuario;
//import pokemon.model.Usuario;
//import pokemon.repositories.UsuarioRepositorio;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class ControllerLogin {

	public ModelAndView show(Request request, Response response, Usuario user) {
		HashMap<String, Object> viewModel = new HashMap<>();
		// obtengo los datos ingresados en el formulario del login
		if(request.queryParams().isEmpty()) return new ModelAndView(viewModel,"login.html");
		String username=request.queryParams("usuario");
		if (username==null) username="";
		String password=request.queryParams("password");
		if (password==null) password="";
		//Boolean usuarioCorrecto = esUsuarioCorrecto(usuario, password);
		//System.out.println("El usuario ingresado en el LOGIN es: "+ usuario);
		//System.out.println("password ingresado en el LOGIN es: "+ password);
		//User  usuario = CuentasUsuario.instanciarUsuario(username, password);
		if(username.contains("nicolas") & password.contains("1234")){
					//String[] ingresar=request.queryParamsValues("ingresar");
			return new ModelAndView(viewModel, "menuPrincipal.html");
			}
		viewModel.put("error", "usted ha ingresado un usuario o password");
		return new ModelAndView(viewModel, "login.html");
	}

}
