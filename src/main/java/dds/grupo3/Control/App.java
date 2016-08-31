package dds.grupo3.Control;

import spark.template.handlebars.HandlebarsTemplateEngine;

import dds.grupo3.Interfaces.AdministradorPOIs;
import dds.grupo3.User.Usuario;
import spark.Spark;

public class App {

	public static void main(String[] args) {

		AdministradorPOIs mapa=Inicializacion.init();
		Usuario usuario=new Usuario();
		usuario.setMapa(mapa);
		usuario.setNombre("nicolas");
		usuario.setContrasenia("1234");
		//usuario.setRol("admin");
		HandlebarsTemplateEngine engine = new HandlebarsTemplateEngine();
		ControllerBusqueda busqueda=new ControllerBusqueda();
		ControllerInfoAvanzada informacion=new ControllerInfoAvanzada();
		ControllerHistorialBusquedas historial= new ControllerHistorialBusquedas();
//<<<<<<< HEAD
//		ControllerHistorialBusquedas historial= new ControllerHistorialBusquedas();
//		
//		Spark.get("/busqueda", (req, res) -> busqueda.show(req, res,usuario),engine);
//		Spark.get("/infoAvanzada",(req,res)->informacion.show(req, res, busqueda.getResultadosAnteriores()),engine);
//		Spark.get("/historial", (req, res) -> historial.show(req, res,historial.getListaHistorial()),engine);
//		Spark.get("/webapp/css/bootstrap.min.css", (req, res) -> {
//			HashMap viewModel = new HashMap();
//			return new ModelAndView(viewModel,"../../../../webapp/css/bootstrap.min.css");
//		},engine);
//		Spark.get("/webapp/css/mdb.min.css", (req, res) -> {
//			HashMap viewModel = new HashMap();
//			return new ModelAndView(viewModel,"../../../../webapp/css/mdb.min.css");
//		},engine);
//=======
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
		
//<<<<<<< HEAD
//		Spark.get("/login", (request, response) -> login.show(request, response,usuario), engine);
//		Spark.get("/webapp/css/bootstrap.min.css", (req, res) -> {
//		HashMap viewModel = new HashMap();
//		return new ModelAndView(viewModel,"../../../../webapp/css/bootstrap.min.css");
//		},engine);
//		Spark.get("/webapp/css/mdb.min.css", (req, res) -> {
//		HashMap viewModel = new HashMap();
//		return new ModelAndView(viewModel,"../../../../webapp/css/mdb.min.css");
//		},engine);
//=======
		Spark.get("/login", (req, res) -> login.show(req, res,usuario), engine);
		Spark.get("/menuPrincipal", (req, res) ->menu.show(req, res), engine);
	}
}
