package ddsgrupo3;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.Before;
import org.junit.Test;
import dds.grupo3.BaseDeDatos.QueryBusquedas;
import dds.grupo3.DTOs.Busquedas;
import dds.grupo3.Interfaces.*;
import dds.grupo3.POIsSistem.*;
import dds.grupo3.User.*;

public class TestsEntrega4 {
	//----------
	//Parametros Iniciales
	//----------
    Session 		session;

    SucursalBanco 	sucursal,	sucursal2,	sucursal3;
	Local 			local,		local2,		local3;
	ParadaColectivo parada,		parada2,	parada3;
	CGP 			cgp, 		cgp2, 		cgp3;
	Servicio 		servicio1,	servicio2,	servicio3,	servicio4;
	Ubicacion 		ubicacionActual;
	Horario 		horario,	horario1,	horario2,	horario3,	horario4,	horario5;
	@Before
	public void init() {
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
        configuration.addAnnotatedClass(Busquedas.class);
        configuration.addAnnotatedClass(Busquedas.class);
        configuration.addAnnotatedClass(Usuario.class);
        configuration.addAnnotatedClass(Rol.class);
        configuration.addAnnotatedClass(RealizarAcciones.class);
        
        ServiceRegistry serviceRegistry = 
      		new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        session= sessionFactory.openSession();
	
        //TODO esto es para POIs
		sucursal 	= new SucursalBanco("Santander Rio 14");
		sucursal.setAltura(2491);
		sucursal.setBarrio("Belgrano");
		sucursal.setCalle("Av. Cabildo");
		sucursal.setCallesPerpenDer("Monroe");
		sucursal.setCallesPerpenIzq("Blanco Encalada");
		sucursal.setCodigoPostal(2828);
		sucursal.setComuna(14);
		sucursal.setLocalidad("");
		sucursal.setPais("Argentina");
		sucursal.setProvincia("CABA");
		sucursal.setLatitud(800.00);
		sucursal.setLongitud(444.00);
		horario1 = new Horario();
			horario1.setDiaInicio(2);
			horario1.setDiaFinal(6);
			horario1.setHorarioInicio(1000);
			horario1.setHorarioCierre(1500);
			List<Horario> lista1 = new ArrayList<>();
			lista1.add(horario1);
			servicio1 = new Servicio("Transferencia");
			servicio1.setHorario(lista1);
			servicio2 = new Servicio("Deposito");
			servicio2.setHorario(lista1);
			servicio3 = new Servicio("Extracciones");
			servicio3.setHorario(lista1);			
		sucursal.setServicio(servicio1);
		sucursal.setServicio(servicio2);
		sucursal.setServicio(servicio3);

		sucursal2 	= new SucursalBanco("Galicia 6");
		sucursal2.setAltura(7121);
		sucursal2.setBarrio("Flores");
		sucursal2.setCalle("Av. Rivadavia");
		sucursal2.setCallesPerpenDer("Condarco");
		sucursal2.setCallesPerpenIzq("Bolivia");
		sucursal2.setCodigoPostal(2828);
		sucursal2.setComuna(6);
		sucursal2.setLocalidad("");
		sucursal2.setPais("Argentina");
		sucursal2.setProvincia("CABA");
		sucursal2.setLatitud(800.00);
		sucursal2.setLongitud(444.00);
		sucursal2.setServicio(servicio1);
		sucursal2.setServicio(servicio2);

		local = new Local();
		local.setNombre("Wendy");
		horario2 = new Horario();
		horario2.setDiaInicio(1);
		horario2.setDiaFinal(5);
		horario2.setHorarioInicio(0500);
		horario2.setHorarioCierre(2200);
		List<Horario> lista2 = new ArrayList<>();
		lista2.add(horario2);
		horario3 = new Horario();
		horario3.setDiaInicio(6);
		horario3.setDiaFinal(7);
		horario3.setHorarioInicio(0600);
		horario3.setHorarioCierre(0000);
		lista2.add(horario3);
			servicio4 = new Servicio("Comida Rapida");
			servicio4.setRadioCercania(50.0);
		local.setRubro(servicio4);
		local.setAltura(3253);
		local.setBarrio("Palermo");
		local.setCalle("Av Santa Fe");
		local.setCallesPerpenDer("Bulnes");
		local.setCallesPerpenIzq("Av Cnel Diaz");
		local.setCodigoPostal(1230);
		local.setLocalidad("");
		local.setPais("Argentina");
		local.setProvincia("CABA");
		local.setLatitud(123123.0007);
		local.setLongitud(13213.00);

		parada	= new ParadaColectivo();
		parada.setLatitud(65.23);
		parada.setLongitud(32.2332);
		parada.setLocalidad("Lomas de Zamora");
		parada.setPais("Argentina");
		parada.setProvincia("Buenos Aires");
		parada.setBarrio("Laprida");
		parada.setCalle("Estacion");
		parada.setCallesPerpenIzq("Gorriti");
		parada.setCallesPerpenDer("Laprida");
		parada.setLineas("543,544,540,542,531");
	
		parada2	= new ParadaColectivo();
		parada2.setLatitud(1.0008);
		parada2.setLongitud(1.00);
		parada2.setPais("Aregentina");
		parada2.setProvincia("CABA");
		parada2.setBarrio("Caballito");
		parada2.setCalle("Arenal");
		parada2.setCallesPerpenIzq("Freire");
		parada2.setCallesPerpenDer("Conde");
		parada2.setLineas("60,151,120");
	
	
	}
	
	//-----------------
	//Tests
	//-----------------
	
	@Test //Test de Base de datos
	public void testVerBusqueda() {
	List<Busquedas> lista = QueryBusquedas.obtenerBusquedas("Test","","","","","","", session);
	System.out.println(lista.toString());
	}
	@Test //Test de Base de datos
	public void testAgregarPOI() {
	List<Busquedas> lista = QueryBusquedas.obtenerBusquedas("Test","","","","","","", session);
	System.out.println(lista.toString());
	}
	@Test //Test de Base de datos
	public void testMOdificarPOI() {
	List<Busquedas> lista = QueryBusquedas.obtenerBusquedas("Test","","","","","","", session);
	System.out.println(lista.toString());
	}
	@Test //Test de Base de datos
	public void testBorrarPOI() {
	List<Busquedas> lista = QueryBusquedas.obtenerBusquedas("Test","","","","","","", session);
	System.out.println(lista.toString());
	}
}
	
