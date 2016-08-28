package dds.grupo3.Control;


import java.util.ArrayList;
import java.util.List;

////import spark.template.handlebars.HandlebarsTemplateEngine;
//
//import java.io.InputStream;
//
//import javax.servlet.MultipartConfigElement;


import dds.grupo3.Interfaces.AdministradorPOIs;
import dds.grupo3.Interfaces.POIGral;
import dds.grupo3.User.Usuario;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class App {

	public static void main(String[] args) {

		AdministradorPOIs mapa=Inicializacion.init();
		List<POIGral> resultadosAnteriores=new ArrayList<POIGral>();
		Usuario usuario=new Usuario();
		usuario.setMapa(mapa);
		HandlebarsTemplateEngine engine = new HandlebarsTemplateEngine();

		 
		Spark.get("/busqueda", (req, res) ->ControllerBusqueda.show(req, res,usuario,resultadosAnteriores),engine);
	}
}
