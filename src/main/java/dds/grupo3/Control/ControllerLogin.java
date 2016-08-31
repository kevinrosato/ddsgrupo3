package dds.grupo3.Control;

import java.util.HashMap;




import dds.grupo3.User.Usuario;
//import pokemon.model.Usuario;
//import pokemon.repositories.UsuarioRepositorio;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class ControllerLogin {

	public ModelAndView show(Request request, Response response, Usuario user) {
		HashMap<String, Object> viewModel = new HashMap<>();
				
		//viewModel.put("usuario", usuario.getUsuario());
		
		// obtengo los datos ingresados en el formulario del login
		/*if(!request.queryParams().isEmpty()){

		String usuario=request.queryParams("usuario");
		String password=request.queryParams("password");
		
		
		
		}
		//if(usuario.equals(user.getNombre()) && password.equals(user.getContrasenia())  ){
			
			//String[] ingresar=request.queryParamsValues("ingresar");
			
			
			
			//return new ModelAndView(viewModel, "login.html");
		//}else{
			
		*/	return new ModelAndView(viewModel, "login.html");

		//}
		

	}

}
