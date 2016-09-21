package dds.grupo3.BaseDeDatos;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import dds.grupo3.Control.Inicializacion;
import dds.grupo3.Interfaces.POI;
import dds.grupo3.Interfaces.POIGral;
import dds.grupo3.POIsSistem.CGP;
import dds.grupo3.POIsSistem.Horario;
import dds.grupo3.POIsSistem.Local;
import dds.grupo3.POIsSistem.ParadaColectivo;
import dds.grupo3.POIsSistem.Servicio;
import dds.grupo3.POIsSistem.SucursalBanco;
import dds.grupo3.POIsSistem.Ubicacion;
import ddsgrupo3.Mapa;

public class CreadorDePoisBDD {

   public static void main(String[] args) {
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
        
        Mapa mapa=(Mapa) Inicializacion.init();
        
        Session session=sessionFactory.openSession();
 
        for(POIGral poi:mapa.getListaPois()){
        	session.beginTransaction();
        	session.save(poi);
        	session.getTransaction().commit();
        }	
        
//        session.beginTransaction();
//        session.save(poi2);
//        session.getTransaction().commit();
        
     
        
        
//        POIejemplo poi2=(POIejemplo)session.get(POIejemplo.class,1);//Recupera el profesor de la bd
//        System.out.println(poi2.getNombre());
//        System.out.println(poi2.getBarrio());     
//        
//        poi2.setNombre("Emilio");
//        
//        session.beginTransaction();
//        session.update(poi2);//actualiza el registro del profesor en la bd
//        session.getTransaction().commit();        
//
//        session.beginTransaction();
//        session.delete(poi2);//elimina el profesor de la bd
//        session.getTransaction().commit(); 
//        
        
        session.close();
        sessionFactory.close();
    }
}
