package dds.grupo3.FabricaPOIs;

import java.util.Scanner;

import dds.grupo3.Interfaces.POI;
import dds.grupo3.POIsSistem.SucursalBanco;

public class FabricaSucursales implements FabricaEspecifica {

	@Override
	public POI cargarPOI(POI poi) {
		@SuppressWarnings("resource")
		Scanner teclado = new Scanner(System.in);
		System.out.println("Ingrese datos del POI de la siguiente manera:");
		System.out.println("codigoPostal,departamento,piso,unidad,servicios");
		System.out.println("Deje en blanco los campos que no use.");
		String aux = teclado.nextLine();
		String[] campos = aux.trim().split(",");
		
		((SucursalBanco) poi).setCodigoPostal(Integer.parseInt(campos[0]));
		((SucursalBanco) poi).setDepartamento(Byte.parseByte(campos[1]));
		((SucursalBanco) poi).setPiso(Byte.parseByte(campos[2]));
		((SucursalBanco) poi).setUnidad(Byte.parseByte(campos[3]));
		return poi;
	}
}
