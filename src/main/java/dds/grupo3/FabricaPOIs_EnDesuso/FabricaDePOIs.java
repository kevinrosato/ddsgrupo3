package dds.grupo3.FabricaPOIs_EnDesuso;

import java.util.Scanner;

import dds.grupo3.Interfaces.POI;
import dds.grupo3.OtrasClases.Factory;

public class FabricaDePOIs {
	public static POI	crearPOICompleto(String clase)
	{
		POI poi = (POI) Factory.getObject(clase);
		System.out.println("Ingrese los datos del POI nuevo.");
		clase = "F".concat(clase);
		FabricaEspecifica f = (FabricaEspecifica) Factory.getObject(clase);
		cargarPOI(poi,pedirInfo().trim().split(","));
		return	f.cargarPOI(poi);
	}
	private static String pedirInfo(){
		@SuppressWarnings("resource")
		Scanner teclado = new Scanner(System.in);
		System.out.println("Ingrese datos del POI de la siguiente manera:");
		System.out.println("comuna,lat,long,nombre,calle,altura,callesPerpenIzq,callesPerpenDer,barrio,localidad,provincia,pais");
		System.out.println("Deje en blanco los campos que no use.");
		return teclado.nextLine();
	}	
	public static void cargarPOI(POI poi,String[] campos){
//		poi.setComuna(Integer.parseInt(campos[0]));
//		poi.setLatitud(Double.parseDouble(campos[1]));
//		poi.setLongitud(Double.parseDouble(campos[2]));
		poi.setNombre(campos[0]);
		poi.setBarrio(campos[1]);
		poi.setCalle(campos[2]);
		poi.setAltura(Integer.parseInt(campos[3]));
		poi.setCallesPerpenIzq(campos[4]);
		poi.setCallesPerpenDer(campos[5]);
		poi.setLocalidad(campos[6]);
		poi.setProvincia(campos[7]);
		poi.setPais(campos[8]);
	}
}
