package dds.grupo3.Control;


import java.util.HashMap;

////import spark.template.handlebars.HandlebarsTemplateEngine;
//
//import java.io.InputStream;
//
//import javax.servlet.MultipartConfigElement;


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
		ControllerHistorialBusquedas historial= new ControllerHistorialBusquedas();
		Spark.get("/busqueda", (req, res) -> busqueda.show(req, res,usuario),engine);
		Spark.get("/infoAvanzada",(req,res)->informacion.show(req, res, busqueda.getResultadosAnteriores()),engine);
		Spark.get("/historial", (req, res) -> historial.show(req, res,historial.getListaHistorial()),engine);
		Spark.get("/webapp/css/bootstrap.min.css", (req, res) -> {
			HashMap viewModel = new HashMap();
			return new ModelAndView(viewModel,"../../../../webapp/css/bootstrap.min.css");
		},engine);
		Spark.get("/webapp/css/mdb.min.css", (req, res) -> {
			HashMap viewModel = new HashMap();
			return new ModelAndView(viewModel,"../../../../webapp/css/mdb.min.css");
		},engine);
	}
}
