package dds.grupo3.Control;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import spark.template.handlebars.HandlebarsTemplateEngine;
import dds.grupo3.BaseDeDatos.BorrarBusqueda;
import dds.grupo3.BaseDeDatos.CreadorDePoisBDD;
import dds.grupo3.BaseDeDatos.QueryPermisos;
//import dds.grupo3.BaseDeDatos.CreadorDePoisBDD;
//import dds.grupo3.BaseDeDatos.CreadorDeUsuariosBDD;
import dds.grupo3.DTOs.Busquedas;
import dds.grupo3.Interfaces.*;
import dds.grupo3.POIsSistem.*;
import dds.grupo3.User.*;
import dds.grupo3.UsoTerminales.Cronometrador;
import spark.Spark;

public class App {

	private static Session session;

	public static void main(String[] args) {

		session=iniciarSesionBDD();
		
		Integer aux = 100000;
		Cronometrador.establecerTope(aux.longValue());
		Usuario usuario=new Usuario();

		HandlebarsTemplateEngine engine = new HandlebarsTemplateEngine();

		ControllerPantallaInicio inicio = new ControllerPantallaInicio();
		ControllerBusqueda busqueda=new ControllerBusqueda();
		ControllerInfoAvanzada informacion=new ControllerInfoAvanzada();
		ControllerHistorialBusquedas historial= new ControllerHistorialBusquedas();
		ControllerAccionConsulta consulta= new ControllerAccionConsulta();
		ControllerLogin login = new ControllerLogin();
		ControllerMenu menu = new ControllerMenu();
		ControllerAltaPOI altaPoi = new ControllerAltaPOI();
		ControllerBajaPOI bajaPoi = new ControllerBajaPOI();
		ControllerPoiABorrar poiABorrar=new ControllerPoiABorrar();
		ControllerModificacionPOI modificacionPOI=new ControllerModificacionPOI();
		ControllerPoiAModificar poiAModificar=new ControllerPoiAModificar();
		
		Spark.staticFileLocation("/templates");
		
		Spark.get("/pantallaInicio", (req, res) ->inicio.show(req, res,usuario),engine);
		Spark.get("/busqueda", (req, res) -> busqueda.show(req, res,session,informacion),engine);
		Spark.get("/infoAvanzada",(req,res)->informacion.show(req, res,session),engine);
		Spark.get("/historial", (req, res) -> historial.show(req, res,session,informacion),engine);
		Spark.get("/acciones",(req,res)->consulta.show(req, res,usuario,session), engine);
		Spark.get("/login", (req, res) -> login.show(req, res,usuario,session), engine);
		Spark.post("/login", (req, res) -> login.show(req, res,usuario,session), engine);
		Spark.get("/menuPrincipal", (req, res) ->menu.show(req, res,usuario,session), engine);
		Spark.get("/altaPoi", (req, res) ->altaPoi.show(req, res, session,usuario),engine);
		Spark.post("/altaPoi", (req, res) ->altaPoi.show(req, res,session, usuario),engine);
		Spark.get("/bajaPoi", (req, res) ->bajaPoi.show(req, res, session),engine);
		Spark.get("/infoPOIaBorrar", (req, res) ->poiABorrar.show(req, res, session),engine);
		Spark.get("/modificacionPoi", (req, res) ->modificacionPOI.show(req, res, session),engine);
		Spark.get("/infoPOIaModificar", (req, res) ->poiAModificar.show(req, res, session),engine);
		Spark.post("/modificacionPoi", (req, res) ->modificacionPOI.show(req, res,session),engine);
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
        configuration.addAnnotatedClass(Busquedas.class);
        configuration.addAnnotatedClass(Usuario.class);
        configuration.addAnnotatedClass(Rol.class);
        configuration.addAnnotatedClass(RealizarAcciones.class);
        
        ServiceRegistry serviceRegistry = 
      		new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        Session session= sessionFactory.openSession();
//        CreadorDePoisBDD.inicializar(session);
//        CreadorDeUsuariosBDD.inicializar(session);
        return session;
	}
	
	public static void cerrarSesion (Session session){
		session.close();
	}
}
