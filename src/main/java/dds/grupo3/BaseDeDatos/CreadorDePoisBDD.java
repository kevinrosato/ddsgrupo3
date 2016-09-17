package dds.grupo3.BaseDeDatos;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import dds.grupo3.Interfaces.POI;
import dds.grupo3.POIsSistem.Local;

public class CreadorDePoisBDD {

   public static void main(String[] args) {
        SessionFactory sessionFactory;
           
        Configuration configuration=new Configuration();
        configuration.configure();
        configuration.addAnnotatedClass(POI.class);
        configuration.addAnnotatedClass(Local.class);
        
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        
        Local poi=new Local();
        poi.setId(1);
        poi.setNombre("LOCALL");
        poi.setCodigoPostal(1428);
        
        Session session=sessionFactory.openSession();
 
        session.beginTransaction();
        session.save(poi);
        session.getTransaction().commit();
        
        
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
