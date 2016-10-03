package ddsgrupo3;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.Before;
import org.junit.Test;

import dds.grupo3.Control.ControllerHistorialBusquedas;
import dds.grupo3.DTOs.ResultadoBusquedaDTO;
import dds.grupo3.Interfaces.POI;
import dds.grupo3.POIsSistem.CGP;
import dds.grupo3.POIsSistem.Horario;
import dds.grupo3.POIsSistem.Local;
import dds.grupo3.POIsSistem.ParadaColectivo;
import dds.grupo3.POIsSistem.Servicio;
import dds.grupo3.POIsSistem.SucursalBanco;
import dds.grupo3.POIsSistem.Ubicacion;
import dds.grupo3.User.Rol;
import dds.grupo3.User.Usuario;

public class TestsEntrega4 {
	//----------
	//Parametros Iniciales
	//----------
    Session 		session;
//	Calendar 		calendario;
//	LevenshteinDistance calculador;
//	AdministradorPOIs 			mapa;
//	SucursalBanco 	sucursal,	sucursal2;
//	Local 			local,		local2,		carrousel;
//	ParadaColectivo parada,		parada2;
//	CGP 			cgp, 		cgp2, 		cgp3;
//	Servicio 		rubroM,		servicio1,	servicio2,	servicio3,	comercial;
//	Integer 		comunaActual;
//	Ubicacion 		ubicacionActual;
//	Horario 		horario,	horario1,	horario2,	horario3,	horario4,	horario5;
//	CentroDTO		cgpDTO1,	cgpDTO2,	cgpDTO3,	cgpDTO4,	cgpDTO5;
//	ServDTO			servDTO1,	servDTO2,	servDTO3,	servDTO4,	servDTO5;
//	HorariosServDTO	horServDTO1,horServDTO2,horServDTO3,horServDTO4,horServDTO5;
//	CGPDAO			cgpDAO;
//	Rol				admin, standar;
	@Before
	public void init() {
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
        session= sessionFactory.openSession();
	}
	
	//-----------------
	//Tests
	//-----------------
	
	@Test //Test de Base de datos
	public void testApk() {
	ControllerHistorialBusquedas control = new ControllerHistorialBusquedas();
	
	List<ResultadoBusquedaDTO> lista = control.obtenerBusquedas("FEDERICO","","", session);
	System.out.println(lista.toString());
	}
}
	
