package dds.grupo3.BaseDeDatos;


import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import dds.grupo3.Interfaces.POI;
import dds.grupo3.Interfaces.POIGral;
import dds.grupo3.OtrasClases.Mapa;

public class CreadorDePoisBDD {

   @SuppressWarnings({ "deprecation", "unchecked" })
public static void inicializar(Session session) {
        Mapa mapa=new Mapa();
        mapa.getListaPois().clear();
        mapa=(Mapa) Inicializacion.init();
        
        session.beginTransaction();
        session.createSQLQuery("delete POIsXBusqueda").executeUpdate();
        session.getTransaction().commit();
        
        Query query= session.createQuery("FROM POI");
        List<POI> pois=(List<POI>)query.getResultList();
        session.beginTransaction();
        for(POI poi:pois)
        {
        	session.delete(poi);
        }
    	session.getTransaction().commit();
    	
        for(POIGral poi:mapa.getListaPois()){
        	session.beginTransaction();
        	session.save(poi);
        	session.getTransaction().commit();
        }	
   }
 }
