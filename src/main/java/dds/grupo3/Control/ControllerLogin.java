package dds.grupo3.Control;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import dds.grupo3.User.RolAdmin;
import dds.grupo3.User.Usuario;
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
		if(this.verificarDatosLogueo(username, password)){
					//String[] ingresar=request.queryParamsValues("ingresar");
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
	
	private Boolean verificarDatosLogueo(String username,String password){
		FileInputStream file;
		Boolean b=false;
		try {
			file = new FileInputStream("Database.properties");
			Properties propiedades = new Properties();
			propiedades.load(file);
			String contrasenia=propiedades.getProperty(username);
			if(contrasenia!=null){
				if(contrasenia.equals(password)){
					b=true;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return b;
	}

}
