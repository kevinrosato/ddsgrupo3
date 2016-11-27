package dds.grupo3.FabricaPOIs_EnDesuso;

import java.util.Scanner;

import dds.grupo3.Interfaces.POI;
import dds.grupo3.POIsSistem.ParadaColectivo;

public class FabricaParadas implements FabricaEspecifica {

	@Override
	public POI cargarPOI(POI poi) {
		@SuppressWarnings("resource")
		Scanner teclado = new Scanner(System.in);
		System.out.println("Ingrese las lineas de colectivo:");
		String lineas = teclado.nextLine();
		((ParadaColectivo) poi).setLineas(lineas);
		return poi;
	}
}

