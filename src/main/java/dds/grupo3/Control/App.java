package dds.grupo3.Control;

import java.util.HashMap;
import spark.template.handlebars.HandlebarsTemplateEngine;

import dds.grupo3.Interfaces.AdministradorPOIs;
import dds.grupo3.User.Rol;
import dds.grupo3.User.RolTerminal;
import dds.grupo3.User.Usuario;
import ddsgrupo3.Factory;
import spark.ModelAndView;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class App {

	public static void main(String[] args) {

		AdministradorPOIs mapa=Inicializacion.init();
		Usuario usuario=new Usuario();
		usuario.setMapa(mapa);
		usuario.setNombre("nicolas");
		usuario.setContrasenia("1234");
		usuario.setRol(new RolTerminal().crearRol());
		HandlebarsTemplateEngine engine = new HandlebarsTemplateEngine();
		ControllerBusqueda busqueda=new ControllerBusqueda();
		ControllerInfoAvanzada informacion=new ControllerInfoAvanzada();
		ControllerHistorialBusquedas historial= new ControllerHistorialBusquedas();

		ControllerAccionConsulta consulta= new ControllerAccionConsulta();
		ControllerLogin login = new ControllerLogin();
		ControllerMenu menu = new ControllerMenu();
		ControllerPantallaInicio inicio = new ControllerPantallaInicio();
		Spark.staticFileLocation("/templates");
		
		Spark.get("/pantallaInicio", (req, res) ->inicio.show(req, res, usuario),engine);
		Spark.get("/busqueda", (req, res) -> busqueda.show(req, res,usuario),engine);
		Spark.get("/infoAvanzada",(req,res)->informacion.show(req, res, busqueda.getResultadosAnteriores()),engine);
		Spark.get("/historial", (req, res) -> historial.show(req, res),engine);
		Spark.get("/acciones",(req,res)->consulta.show(req, res, usuario), engine);
		Spark.get("/login", (req, res) -> login.show(req, res,usuario), engine);
		Spark.post("/login", (req, res) -> login.show(req, res,usuario), engine);
		Spark.get("/menuPrincipal", (req, res) ->menu.show(req, res,usuario), engine);
	}
}
