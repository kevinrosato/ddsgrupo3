package dds.grupo3.Control;

import java.util.HashMap;
import org.hibernate.Session;

import dds.grupo3.Interfaces.AdministradorPOIs;
import dds.grupo3.Interfaces.User;
import dds.grupo3.User.CuentasUsuarioDB;
import ddsgrupo3.admin;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class ControllerLogin {

	public ModelAndView show(Request request, Response response,Session session) {
		HashMap<String, Object> viewModel = new HashMap<>();
		CuentasUsuarioDB cuentas = new CuentasUsuarioDB(session);
		if(request.queryParams().isEmpty()) return new ModelAndView(viewModel,"login.html");
		String username=request.queryParams("usuario");
		if (username==null) username="";
		String password=request.queryParams("password");
		if (password==null) password="";

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
}
