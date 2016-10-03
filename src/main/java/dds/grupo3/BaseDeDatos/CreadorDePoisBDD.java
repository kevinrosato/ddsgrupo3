package dds.grupo3.BaseDeDatos;


import org.hibernate.Session;

import dds.grupo3.Interfaces.POIGral;
//import org.hibernate.SessionFactory;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//import org.hibernate.cfg.Configuration;
//import org.hibernate.service.ServiceRegistry;
//
//import dds.grupo3.Interfaces.POI;
//import dds.grupo3.Interfaces.POIGral;
//import dds.grupo3.POIsSistem.CGP;
//import dds.grupo3.POIsSistem.Horario;
//import dds.grupo3.POIsSistem.Local;
//import dds.grupo3.POIsSistem.ParadaColectivo;
//import dds.grupo3.POIsSistem.Servicio;
//import dds.grupo3.POIsSistem.SucursalBanco;
//import dds.grupo3.POIsSistem.Ubicacion;
import ddsgrupo3.Mapa;

public class CreadorDePoisBDD {

   public static void inicializar(Session session) {
        Mapa mapa=new Mapa();
        mapa.getListaPois().clear();
        mapa=(Mapa) Inicializacion.init();
        for(POIGral poi:mapa.getListaPois()){
        	session.beginTransaction();
        	session.save(poi);
        	session.getTransaction().commit();
        }	
   }
 }
