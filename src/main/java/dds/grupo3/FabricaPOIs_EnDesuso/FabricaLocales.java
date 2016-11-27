package dds.grupo3.FabricaPOIs_EnDesuso;

import java.util.Scanner;

import dds.grupo3.Interfaces.POI;
import dds.grupo3.POIsSistem.Local;

public class FabricaLocales implements FabricaEspecifica{

	@Override
	public POI cargarPOI(POI poi) {
		@SuppressWarnings("resource")
		Scanner teclado = new Scanner(System.in);
		System.out.println("Ingrese datos del POI de la siguiente manera:");
		System.out.println("codigoPostal,departamento,piso,unidad,rubro");
		System.out.println("Deje en blanco los campos que no use.");
		String aux = teclado.nextLine();
		String[] campos = aux.trim().split(",");
		
		((Local) poi).setCodigoPostal(Integer.parseInt(campos[0]));
		((Local) poi).setDepartamento(Byte.parseByte(campos[1]));
		((Local) poi).setPiso(Byte.parseByte(campos[2]));
		((Local) poi).setUnidad(Byte.parseByte(campos[3]));
		return poi;
	}
}
