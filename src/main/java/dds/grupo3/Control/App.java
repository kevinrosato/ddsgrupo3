package dds.grupo3.Control;

import java.util.HashMap;
import java.util.List;
import spark.template.handlebars.HandlebarsTemplateEngine;

import dds.grupo3.Interfaces.AdministradorPOIs;
import dds.grupo3.User.Usuario;
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
		//usuario.setRol("admin");
		HandlebarsTemplateEngine engine = new HandlebarsTemplateEngine();
		ControllerBusqueda busqueda=new ControllerBusqueda();
		ControllerInfoAvanzada informacion=new ControllerInfoAvanzada();
		ControllerAccionConsulta consulta= new ControllerAccionConsulta();
		ControllerLogin login = new ControllerLogin();
		
		Spark.staticFileLocation("/templates");
		
		Spark.get("/pantallaInicio", (req, res) ->{
			return new ModelAndView(new HashMap(),"pantallaInicio.html");
		},engine);
			
		Spark.get("/busqueda", (req, res) -> busqueda.show(req, res,usuario),engine);
		Spark.get("/infoAvanzada",(req,res)->informacion.show(req, res, busqueda.getResultadosAnteriores()),engine);
		Spark.get("/acciones",(req,res)->consulta.show(req, res, usuario), engine);
		
		Spark.get("/login", (request, response) -> login.show(request, response,usuario), engine);
		
		

	}
}
