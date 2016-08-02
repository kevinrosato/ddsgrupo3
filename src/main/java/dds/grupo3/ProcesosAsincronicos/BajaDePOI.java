package dds.grupo3.ProcesosAsincronicos;
import java.util.Scanner;

import dds.grupo3.Interfaces.POIGral;
import dds.grupo3.Interfaces.ProcesoAsincronico;
import dds.grupo3.Interfaces.User;
import dds.grupo3.User.BorrarPOI;
import ddsgrupo3.Mapa;

public class BajaDePOI extends ProcesoAsincronico{
    //TODO: Implementacion real
	private POIGral poi;
	private Mapa mapa=new Mapa();
	public BajaDePOI(Mapa mapa){
		this.mapa=mapa;
	}
	public void execute(){
		mapa.realizarFuncConPoi(new BorrarPOI(), poi);
	}
	@Override
	public Integer desplegarConsola(User usuario, String terminal_ID,Scanner teclado) {
		// TODO Auto-generated method stub
		System.out.println("---------------------------------------");
		System.out.println("		BAJA DE POIS");
		System.out.println("----------------------------------------");
		System.out.println();
		System.out.println("Se realizo la baja de POIS correctamente.");
		return null;
	}
	@Override
	public void mostrarOpcion() {
		// TODO Auto-generated method stub
		System.out.println("-->	BAJA DE POIS");
	}
}
