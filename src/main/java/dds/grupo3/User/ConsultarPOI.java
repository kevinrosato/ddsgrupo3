package dds.grupo3.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dds.grupo3.Control.Inicializacion;
import dds.grupo3.Interfaces.AdministradorPOIs;
import dds.grupo3.Interfaces.Funcionalidad;
import dds.grupo3.Interfaces.POIGral;
import dds.grupo3.Interfaces.User;

public class ConsultarPOI implements Funcionalidad {

	private AdministradorPOIs mapa;
	private String resto = new String();
	private String nombre1;
	private String nombre2;
	private List<POIGral> listaResultante = new ArrayList<POIGral>();
	private List<String> claves=new ArrayList<String>(); 
	@Override
	public Object realizarFuncion(List<POIGral> listaPois, Object terminalID)
	{
		claves.add(0,nombre1);
		claves.add(1, nombre2);

//		Cronometrador.comienzo();
		for(String clave:claves){
			if(!clave.isEmpty()){
			if (clave.startsWith("-"))
			{
				clave = clave.substring(1);
				resto = resto.replace(clave,"");
				listaResultante.addAll(buscarEn(clave, listaPois));	
			}
			if (clave.startsWith("+"))
			{
				clave = clave.substring(1);
				resto = resto.concat(",");
				resto = resto.concat(clave);
				listaResultante.addAll(buscarEn(clave, listaPois));	
			}
			else
			{
				resto = clave;
				listaResultante.addAll(buscarEn(clave, listaPois));				
			}
			}
		}
//		Long aux =	Cronometrador.finCuenta();
//		clave2 = mostrarPOIs(resto, listaResultante,scanner);
//		Cronometrador.checkRetraso(BusquedasDAO.guardarBusqueda((String) terminalID, resto, listaResultante.size(),aux));	
		return listaResultante;
	}
	
	public static void main(String[] args) {
		AdministradorPOIs mapa=Inicializacion.init();
		ConsultarPOI consulta=new ConsultarPOI();
		consulta.setNombre1("Medrano");
		consulta.setNombre2("Carrousel");
		@SuppressWarnings("unchecked")
		List<POIGral> resultados=(List<POIGral>) consulta.realizarFuncion(mapa.getListaPois(),"0");
		if(resultados.isEmpty()){System.out.println("no hay resultados");}
		else{
		for(POIGral resultado:resultados){
			String[] info=resultado.mostrarInformacion();
			System.out.println("nom: "+info[0]+" direc: "+info[1]);
		}
		}
	}
	
	public	List<POIGral>	buscarEn(String palabraClave, List<POIGral> lista)
	{	
		palabraClave = palabraClave.trim();
		if (palabraClave.contains("Disponible")) return this.buscarDisponibles(lista);
		else if (palabraClave.contains("Cercano")) return this.buscarCercanos(lista);
		else return	this.buscarPOIs(palabraClave, lista);
	}
	public	List<POIGral>	buscarDisponibles(List<POIGral> lista)
	{
		List<POIGral> listaAux = new ArrayList<POIGral>();		
		for (POIGral i: lista)
		{
			if (i.estaDisponible(mapa.getHoraActual()))	listaAux.add(i);
		}
		return listaAux;
	}
	public	List<POIGral>	buscarPOIs(String palabraClave, List<POIGral> lista)
	{	
		List<POIGral> listaAux = new ArrayList<POIGral>();
		for (POIGral i: lista)
		{
			if (i.tieneLaClave(palabraClave))	listaAux.add(i);
		}
		return listaAux;	
	}
	public	List<POIGral>	buscarCercanos(List<POIGral> lista)
	{
		List<POIGral> listaAux = new ArrayList<POIGral>();		
		for (POIGral i: lista)
		{
			if (i.estaCercaDe(mapa.getUbicacionActual()))	listaAux.add(i);
		}
		return listaAux;	
	}
	
	public String mostrarPOIs(String palabraClave, List<POIGral> lista,Scanner scanner)
	{
		String flag = new String();
		System.out.println("Puntos de Interes con la clave "+palabraClave+":");
		if(lista.size() == 0)
		{
			System.out.println("No se encontraron resultados.");
			flag = "N";
		}
		else if(lista.size() == 1)
		{
			lista.get(0).mostrarInformacionAvanzada();
			System.out.print("�POI Indicado? [Y/N]");
			flag = scanner.nextLine();
		}
		else
		{
			for(POIGral i: lista)	i.mostrarInformacion();
			flag = "N";
		}
		return flag;
	}

	@Override
	public void setParametro(Object obj) {
		mapa = (AdministradorPOIs) obj;
	}

	@Override
	public Integer desplegarConsola(User usuario, String terminal_ID,Scanner teclado) {
			System.out.println("---------------------------------------");
			System.out.println("		CONSULTA DE UN POI");
			System.out.println("----------------------------------------");
			System.out.println();
			usuario.consultarPOI(terminal_ID);
		return 0;
	}

	@Override
	public void mostrarOpcion() {
		System.out.println("	BUSCAR UN POI");
	}
	
	public String getNombre1() {
		return nombre1;
	}

	public void setNombre1(String nombre1) {
		this.nombre1 = nombre1;
	}

	public String getNombre2() {
		return nombre2;
	}

	public void setNombre2(String nombre2) {
		this.nombre2 = nombre2;
	}
}
