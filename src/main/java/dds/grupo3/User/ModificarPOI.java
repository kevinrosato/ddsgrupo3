package dds.grupo3.User;

import java.util.List;
import java.util.Scanner;

import dds.grupo3.FabricaPOIs.FabricaDePOIs;
import dds.grupo3.Interfaces.Funcionalidad;
import dds.grupo3.Interfaces.POI;
import dds.grupo3.Interfaces.POIGral;
import dds.grupo3.Interfaces.User;

public class ModificarPOI implements Funcionalidad{

	private POIGral poiNuevo;
	private String archivo;
	
	@Override
	public POIGral realizarFuncion(List<POIGral> listaPois, Object poi)
	{
		listaPois.set(listaPois.indexOf((POIGral) poi),this.poiNuevo);
		return poiNuevo;
	}
	@Override
	public void setParametro(Object obj)
	{
		poiNuevo = (POIGral) obj;
	}
	@Override
	public Integer desplegarConsola(User usuario, String terminal_ID,Scanner teclado) {
		System.out.println("---------------------------------------");
		System.out.println("		MODIFICACION DE UN POI");
		System.out.println("----------------------------------------");
		System.out.println();
		POIGral poiOriginal = usuario.consultarPOI(terminal_ID);
		POI poiNuevo = FabricaDePOIs.crearPOICompleto(poiOriginal.conocerTipo());
		usuario.modificarPOI(poiOriginal, poiNuevo);
		return 0;
	}
	@Override
	public String mostrarOpcion() {
		return "MODIFICAR POI EXISTENTE";
	}
	public String getArchivo() {
		return archivo;
	}
	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}
}
