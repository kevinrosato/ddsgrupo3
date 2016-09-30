package dds.grupo3.BaseDeDatos;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import dds.grupo3.Interfaces.POI;
import dds.grupo3.Interfaces.POIGral;

public class QuerysPois {

	public static List<POIGral> realizarBusqueda(Session session,List<String> claves){
		List<POIGral> listaResultante=new ArrayList<POIGral>();
		System.out.println("Buscando");
		for(String clave:claves){
			if(!clave.isEmpty()){
				listaResultante.addAll(realizarQuery(buscarParadas(clave),session));
				listaResultante.addAll(realizarQuery(buscarLocales(clave),session));
				listaResultante.addAll(realizarQuery(buscarCGPs(clave),session));
				listaResultante.addAll(realizarQuery(buscarBancos(clave),session));
			}
		}
		System.out.println("Encontrados");
		return listaResultante;
	}
	
	@SuppressWarnings("unchecked")
	private static List<POIGral> realizarQuery(String hql,Session session){
		System.out.println("Buscando:"+hql);
	     Query query= session.createQuery(hql);
	     return (List<POIGral>)query.getResultList();
	}
	
	//VER DE SACAR LA PERSISTENCIA DE LOS BANCOS!
	private static String buscarLocales(String clave){
		return "FROM Local l WHERE ((SELECT count(*) FROM CGP c WHERE l.poi_id=c.poi_id)=0) AND"//Verifica que no sea CGP
				+"((SELECT count(*) FROM SucursalBanco banco WHERE l.poi_id=banco.poi_id)=0) AND"//Verifica que no sea banco
				+"((SELECT count(*) FROM POI p WHERE (p.poi_id=l.poi_id) AND"
				+ "("+obtenerStringLocal(clave)+")"
			    + ")>0 OR ("+buscarEnElRubro(clave)+")>0)";
	}
	
	private static String buscarEnElRubro(String clave){
		return "SELECT count(*) FROM Servicio rubro WHERE (l.rubro=rubro.servicio_id) AND (rubro.nombre LIKE '%"+clave+"%')";
	}
	private static String buscarParadas(String clave){
		return "FROM ParadaColectivo c WHERE "
				+ "(SELECT count(*) FROM POI p WHERE (p.poi_id=c.poi_id) AND "
				+ "(c.lineas LIKE '%"+clave+"%' OR "+buscarPOIS(clave) +")"
				+ ")>0";
	}
	private static String buscarCGPs(String clave){
		return "FROM CGP c WHERE "
				+ "((SELECT count(*) FROM POI p,Local l WHERE (p.poi_id=c.poi_id) AND (l.poi_id=c.poi_id) AND"
				+ "(c.numeroCGP LIKE '%"+clave+"%' OR "+obtenerStringLocal(clave)+")"
				+ ")>0) OR "
				+ "(("+buscarEnLosServicios(clave,"c")+")>0)";
	}
	private static String buscarBancos(String clave){
		return "FROM SucursalBanco suc WHERE"
				+ "((SELECT count(*) FROM POI p,Local l WHERE (p.poi_id=suc.poi_id) AND (l.poi_id=suc.poi_id) AND"
				+ "("+obtenerStringLocal(clave)+")"
				+ ")>0) OR "
				+ "(("+buscarEnLosServicios(clave,"suc")+")>0)";
	}
	private static String buscarEnLosServicios(String clave,String alias){
		return  "SELECT count(distinct s) FROM Servicio s join s.locales sc WHERE (sc.id="+alias+".poi_id) AND (s.nombre LIKE '%"+clave+"%')";
	}
	
	private static String obtenerStringLocal(String clave){
		return "l.codigoPostal LIKE '%"+clave+"%' "
			    + "OR l.departamento LIKE '%"+clave+"%'"
			    + "OR l.palabrasClaves LIKE '%"+clave+"%'"
			    + "OR l.piso LIKE '%"+clave+"%'"
			    + "OR l.unidad LIKE '%"+clave+"%' OR "+buscarPOIS(clave);
	}
	
	private static String buscarPOIS(String clave){
		return "p.nombre LIKE '%"+clave+"%' "
				+ "OR p.altura LIKE '%"+clave+"%'"
				+ "OR p.barrio LIKE '%"+clave+"%'"
				+ "OR p.calle LIKE '%"+clave+"%'"
				+ "OR p.callesPerpenDer LIKE '%"+clave+"%'"
				+ "OR p.callesPerpenIzq LIKE '%"+clave+"%'"
				+ "OR p.localidad LIKE '%"+clave+"%'"
				+ "OR p.pais LIKE '%"+clave+"%'"
				+ "OR p.provincia LIKE '%"+clave+"%'";
	}
}

