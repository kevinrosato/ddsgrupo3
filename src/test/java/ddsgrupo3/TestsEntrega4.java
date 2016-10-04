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

import dds.grupo3.Control.ControllerHistorialBusquedas;
import dds.grupo3.DTOs.Busquedas;
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
		horario3 = new Horario();
			horario3.setDiaInicio(2);
			horario3.setDiaFinal(6);
			horario3.setHorarioInicio(1000);
			horario3.setHorarioCierre(1500);
			List<Horario> lista5 = new ArrayList<>();
			lista5.add(horario3);
			servicio1 = new Servicio("Transferencia");
			servicio1.setHorario(lista5);
			servicio2 = new Servicio("Deposito");
			servicio2.setHorario(lista5);
			servicio3 = new Servicio("Extracciones");
			servicio3.setHorario(lista5);			
		sucursal.setServicio(servicio1);
		sucursal.setServicio(servicio2);
		sucursal.setServicio(servicio3);

		sucursal2 	= new SucursalBanco("Galicia 6");
		sucursal.setAltura(7121);
		sucursal.setBarrio("Flores");
		sucursal.setCalle("Av. Rivadavia");
		sucursal.setCallesPerpenDer("Brint");
		sucursal.setCallesPerpenIzq("Corrientes");
		sucursal.setCodigoPostal(2828);
		sucursal.setComuna(6);
		sucursal.setLocalidad("");
		sucursal.setPais("Argentina");
		sucursal.setProvincia("CABA");
		sucursal.setLatitud(800.00);
		sucursal.setLongitud(444.00);
		horario3 = new Horario();
			horario3.setDiaInicio(2);
			horario3.setDiaFinal(6);
			horario3.setHorarioInicio(1000);
			horario3.setHorarioCierre(1500);
			List<Horario> lista5 = new ArrayList<>();
			lista5.add(horario3);
			servicio1 = new Servicio("Transferencia");
			servicio1.setHorario(lista5);
			servicio2 = new Servicio("Deposito");
			servicio2.setHorario(lista5);
			servicio3 = new Servicio("Extracciones");
			servicio3.setHorario(lista5);			
		sucursal.setServicio(servicio1);
		sucursal.setServicio(servicio2);
		sucursal.setServicio(servicio3);

	
	
	
	
	
	
	
	
	}
	
	//-----------------
	//Tests
	//-----------------
	
	@Test //Test de Base de datos
	public void testApk() {
	ControllerHistorialBusquedas control = new ControllerHistorialBusquedas();
	
	List<Busquedas> lista = control.obtenerBusquedas("Test","","","","","","", session);
	System.out.println(lista.toString());
	}
}
	
