package dds.grupo3.Control;

import java.util.HashMap;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import spark.template.handlebars.HandlebarsTemplateEngine;
import dds.grupo3.BaseDeDatos.CreadorDePoisBDD;
import dds.grupo3.BaseDeDatos.Inicializacion;
import dds.grupo3.Interfaces.AdministradorPOIs;
import dds.grupo3.Interfaces.POI;
import dds.grupo3.POIsSistem.CGP;
import dds.grupo3.POIsSistem.Horario;
import dds.grupo3.POIsSistem.Local;
import dds.grupo3.POIsSistem.ParadaColectivo;
import dds.grupo3.POIsSistem.Servicio;
import dds.grupo3.POIsSistem.SucursalBanco;
import dds.grupo3.POIsSistem.Ubicacion;
import dds.grupo3.User.Rol;
import dds.grupo3.User.RolTerminal;
import dds.grupo3.User.Usuario;
import ddsgrupo3.Factory;
import spark.ModelAndView;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class App {

	public static void main(String[] args) {

		Session session=iniciarSesionBDD();
		
		AdministradorPOIs mapa=Inicializacion.init();
		Usuario usuario=new Usuario();
		usuario.setMapa(mapa);
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
		Spark.get("/busqueda", (req, res) -> busqueda.show(req, res,session),engine);
		Spark.get("/infoAvanzada",(req,res)->informacion.show(req, res, busqueda.getResultadosAnteriores()),engine);
		Spark.get("/historial", (req, res) -> historial.show(req, res),engine);
		Spark.get("/acciones",(req,res)->consulta.show(req, res, usuario), engine);
		Spark.get("/login", (req, res) -> login.show(req, res,usuario), engine);
		Spark.post("/login", (req, res) -> login.show(req, res,usuario), engine);
		Spark.get("/menuPrincipal", (req, res) ->menu.show(req, res,usuario), engine);
		
		
		//cerrarSesion(session);
	}
	
	private static Session iniciarSesionBDD(){
		SessionFactory sessionFactory;
		
        Configuration configuration=new Configuration();
        configuration.configure();
        configuration.addAnnotatedClass(POI.class);
        configuration.addAnnotatedClass(Local.class);
        configuration.addAnnotatedClass(ParadaColectivo.class);
        configuration.addAnnotatedClass(Servicio.class);
        configuration.addAnnotatedClass(CGP.class);
        configuration.addAnnotatedClass(SucursalBanco.class);
        configuration.addAnnotatedClass(Horario.class);
        configuration.addAnnotatedClass(Ubicacion.class);
        
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        Session session= sessionFactory.openSession();
        CreadorDePoisBDD.inicializar(session);
        return session;
	}
	
	private static void cerrarSesion (Session session){
		session.close();
	}
}
