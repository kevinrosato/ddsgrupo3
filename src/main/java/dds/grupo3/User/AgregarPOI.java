package dds.grupo3.User;

import java.util.List;
import java.util.Scanner;

import dds.grupo3.FabricaPOIs.FabricaDePOIs;
import dds.grupo3.Interfaces.Funcionalidad;
import dds.grupo3.Interfaces.POIGral;
import dds.grupo3.Interfaces.User;

public class AgregarPOI implements Funcionalidad {
	
	private String archivo="/altaPoi";
	
	@Override
	public Object realizarFuncion(List<POIGral> listaPois,Object poi)
	{
		if(listaPois.add((POIGral) poi))	return poi;
		else return null;
	}

	@Override
	public void setParametro(Object obj){}

	@Override
	public Integer desplegarConsola(User usuario, String terminal_ID,Scanner teclado){		
		System.out.println("---------------------------------------");
		System.out.println("		ALTA DE UN POI");
		System.out.println("----------------------------------------");
		System.out.println();
			System.out.println("Ingrese datos del POI de la siguiente manera:");
			System.out.println("comuna,lat,long,nombre,calle,altura,callesPerpenIzq,callesPerpenDer,barrio,localidad,provincia,pais");
			System.out.println("Deje en blanco los campos que no use.");
			String camposPOI = teclado.nextLine();
		System.out.println(camposPOI);
		System.out.println();
		System.out.println("Elija el TIPO DE POI que desea agregar:");
		System.out.println(" 1 - CGP");
		System.out.println(" 2 - BANCO");
		System.out.println(" 3 - PARADA DE COLECTIVO");
		System.out.println(" 4 - LOCAL");
		System.out.println(" 5 - Volver al menu principal");
		System.out.print(" OPCION -> ");
		String opcionElegida = teclado.nextLine();
		POIGral poi;
		switch (Integer.parseInt(opcionElegida)) {
			case 1: poi = FabricaDePOIs.crearPOICompleto("CGP");
					break;
			case 2: poi = FabricaDePOIs.crearPOICompleto("Sucursal");
					break;
			case 3: poi = FabricaDePOIs.crearPOICompleto("Parada");
					break;
			case 4: poi = FabricaDePOIs.crearPOICompleto("Local");
					break;
			default: System.out.println ("Opcion incorrecta"); 
					return Integer.parseInt(opcionElegida);
		}	
		usuario.agregarPOI(poi);
		return 0;
	}
	@Override
	public String mostrarOpcion() {
		return "AGREGAR NUEVO POI";
	}

	public String getArchivo() {
		return archivo;
	}

	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}
}
