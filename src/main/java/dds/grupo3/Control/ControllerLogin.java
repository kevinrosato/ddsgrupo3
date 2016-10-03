package dds.grupo3.Control;

<<<<<<< HEAD
=======
import java.io.FileInputStream;
import org.hibernate.Session;
import java.io.FileNotFoundException;
import java.io.IOException;
>>>>>>> 81cc08404763d6a46e7183e97054b13936950f97
import java.util.HashMap;
import org.hibernate.Session;

<<<<<<< HEAD
import dds.grupo3.Interfaces.AdministradorPOIs;
import dds.grupo3.Interfaces.User;
import dds.grupo3.User.CuentasUsuarioDB;
import ddsgrupo3.admin;
=======
import dds.grupo3.BaseDeDatos.QueryUsuario;
import dds.grupo3.User.RolAdmin;
import dds.grupo3.User.Usuario;
>>>>>>> 81cc08404763d6a46e7183e97054b13936950f97
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class ControllerLogin {

<<<<<<< HEAD
	public ModelAndView show(Request request, Response response,Session session) {
=======
	public ModelAndView show(Request request, Response response, Usuario user,Session session) {
>>>>>>> 81cc08404763d6a46e7183e97054b13936950f97
		HashMap<String, Object> viewModel = new HashMap<>();
		CuentasUsuarioDB cuentas = new CuentasUsuarioDB(session);
		if(request.queryParams().isEmpty()) return new ModelAndView(viewModel,"login.html");
		String username=request.queryParams("usuario");
		if (username==null) username="";
		String password=request.queryParams("password");
		if (password==null) password="";
<<<<<<< HEAD

		User user = cuentas.instanciarUsuario(username, password);
		AdministradorPOIs mapa = new admin();
		System.out.println("usuario creado!!");
		if(user ==  null){
			viewModel.put("error", "Usted ha ingresado un usuario o password incorrecto");
			return new ModelAndView(viewModel, "login.html");
		}
		else{
			user.setMapa(mapa);
			System.out.println("mapa agregado!!");
			viewModel.put("Usuario",user);
			System.out.println("viewModel creado!!");
			return new ModelAndView(viewModel,"redirectLoginAMenu.html");
		}
	}
=======
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

>>>>>>> 81cc08404763d6a46e7183e97054b13936950f97
}
