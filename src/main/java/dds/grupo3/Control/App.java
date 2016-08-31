package dds.grupo3.Control;

import java.util.HashMap;

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
		HandlebarsTemplateEngine engine = new HandlebarsTemplateEngine();
		ControllerBusqueda busqueda=new ControllerBusqueda();
		ControllerInfoAvanzada informacion=new ControllerInfoAvanzada();
		
		Spark.staticFileLocation("/templates");
		
		Spark.get("/pantallaInicio", (req, res) ->{
			return new ModelAndView(new HashMap(),"pantallaInicio.html");
		},engine);
		
		Spark.get("/login", (req, res) ->{
			return new ModelAndView(new HashMap(),"login.html");
		},engine);
		
		Spark.get("/busqueda", (req, res) -> busqueda.show(req, res,usuario),engine);
		
		Spark.get("/infoAvanzada",(req,res)->informacion.show(req, res, busqueda.getResultadosAnteriores()),engine);

	}
}
