package dds.grupo3.Control;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import spark.template.handlebars.HandlebarsTemplateEngine;
import dds.grupo3.DTOs.ResultadoBusquedaDTO;
import dds.grupo3.Interfaces.*;
import dds.grupo3.POIsSistem.*;
import dds.grupo3.User.*;
import dds.grupo3.UsoTerminales.Cronometrador;
import spark.Spark;

public class App {

	private static Session session;

	public static void main(String[] args) {

		session=iniciarSesionBDD();
		
//		AdministradorPOIs mapa=Inicializacion.init();
		Integer aux = 100;
		Cronometrador.establecerTope(aux.longValue());
		Usuario usuario=new Usuario();
//		usuario.setMapa(mapa);
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
		Spark.get("/historial", (req, res) -> historial.show(req, res,session),engine);
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
        //TODO esto lo sacan de comentario para crear las tablas o si las quieren vaciar
        configuration.addAnnotatedClass(POI.class);
        configuration.addAnnotatedClass(Local.class);
        configuration.addAnnotatedClass(ParadaColectivo.class);
        configuration.addAnnotatedClass(Servicio.class);
        configuration.addAnnotatedClass(CGP.class);
        configuration.addAnnotatedClass(SucursalBanco.class);
        configuration.addAnnotatedClass(Horario.class);
        configuration.addAnnotatedClass(Ubicacion.class);
        configuration.addAnnotatedClass(ResultadoBusquedaDTO.class);
        configuration.addAnnotatedClass(Usuario.class);
        configuration.addAnnotatedClass(Rol.class);
        
        ServiceRegistry serviceRegistry = 
      		new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        Session session= sessionFactory.openSession();
//        CreadorDePoisBDD.inicializar(session);
        return session;
	}
	
	public static void cerrarSesion (Session session){
		session.close();
	}
}
