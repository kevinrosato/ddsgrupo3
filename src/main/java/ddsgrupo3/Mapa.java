package ddsgrupo3;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import dds.grupo3.DTOs.CGPDAO;
import dds.grupo3.POIsSistem.POI;
import dds.grupo3.POIsSistem.SucursalBancoJSONFactory;
import dds.grupo3.POIsSistem.Ubicacion;

public class Mapa {
	
	private List<POI> listaPois = new ArrayList<POI>();
	private Calendar horaActual;
	private Ubicacion ubicacionActual;
	private CGPDAO baseDatosCGP= new CGPDAO();
	private List<POI> listaPoisJson= new ArrayList<POI>();
	//----------
	//Metodos
	//----------
	public Mapa(){
		SucursalBancoJSONFactory factoryJson= new SucursalBancoJSONFactory();
		listaPoisJson=factoryJson.generarPoi();
	}
	
	public void realizarBusqueda ()
	{
		List<POI> listaResultante = new ArrayList<POI>();
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Ingrese palabra Clave: ");
		String clave = scanner.nextLine();			
		
		while (!clave.startsWith("-"))
		{	
			if (clave.startsWith("+"))
			{
				clave = clave.substring(1);
				listaResultante = buscarVariasFormas(clave, listaResultante);	
			}
			else	listaResultante = buscarVariasFormas(clave, this.getListaPois());
			
			mostrarPOIs(clave, listaResultante);
			
			System.out.println("Fin Lista");

			System.out.print("Ingrese palabra Clave: ");
			clave = scanner.nextLine();
		}		
		scanner.close();
	}
	
	public	List<POI>	buscarVariasFormas(String palabraClave, List<POI> lista)
	{	
		palabraClave = palabraClave.trim();
		if (palabraClave.contains("Disponible")) return this.buscarDisponibles(lista);
		else if (palabraClave.contains("Cercano")) return this.buscarCercanos(lista);
		else return	this.buscarPOIs(palabraClave, lista, this.getListaPoisJson());
	}
	public	List<POI>	buscarDisponibles(List<POI> lista)
	{
		List<POI> listaAux = new ArrayList<POI>();		
		for (POI i: lista)
		{
			if (i.estaDisponible(this.getHoraActual()))	listaAux.add(i);
		}
		return listaAux;
	}
	public	List<POI>	buscarPOIs(String palabraClave, List<POI> lista, List<POI> listajson)
	{	
		List<POI> listaAux = new ArrayList<POI>();
		for (POI i: lista)
		{
			if (i.tieneLaClave(palabraClave))	listaAux.add(i);
		}
		for(POI i:listajson){
			if(i.tieneLaClave(palabraClave)) listaAux.add(i);
		}
		listaAux.addAll(this.buscarCentros(palabraClave));
		return listaAux;	
	}
	public	List<POI>	buscarCercanos(List<POI> lista)
	{
		List<POI> listaAux = new ArrayList<POI>();		
		for (POI i: lista)
		{
			if (i.estaCercaDe(this.getUbicacionActual()))	listaAux.add(i);
		}
		return listaAux;	
	}
	public List<POI>	buscarCentros(String clave){
		return	this.getBaseDatosCGP().getByKey(clave);
	}
	
	public void buscarYmostrar(String clave)
	{
		mostrarPOIs(clave, this.buscarPOIs(clave, this.getListaPois(),this.getListaPoisJson()));
	}
	public void mostrarPOIs(String palabraClave, List<POI> lista)
	{
		System.out.println("Puntos de Interes con la clave "+palabraClave+":");
		
		if(lista.size() == 0)
		{
			System.out.println("No se encontraron resultados.");
		}
		else if(lista.size() == 1)
		{
			lista.get(0).mostrarInformacionAvanzada();
		}
		else for(POI i: lista)	i.mostrarInformacion();
	}
	
	public Integer	cantPOIs()	{
		return	this.getListaPois().size();
	}
	
	//----------------------------------------------
	//METODOS ABCM
	public void realizarFuncConPoi(Funcionalidad funcionalidad,POI poi){
		funcionalidad.realizarFuncionConPOI(this.getListaPois(),poi);
	}	
	
	
	//----------
	//Getters y Setters
	//----------

	public List<POI> getListaPois() {
		return listaPois;
	}
	public void setListaPois(List<POI> listaPois) {
		this.listaPois = listaPois;
	}
	public Calendar getHoraActual() {
		return horaActual;
	}
	public void setHoraActual(Calendar horaActual) {
		this.horaActual = horaActual;
	}
	public Ubicacion getUbicacionActual() {
		return ubicacionActual;
	}
	public void setUbicacionActual(Ubicacion ubicacionActual) {
		this.ubicacionActual = ubicacionActual;
	}
	//VER DE SACARLO SIN QUE ROMPAN LOS TESTS
	public void agregarPoi(POI poi){
		listaPois.add(poi);
	}

	public CGPDAO getBaseDatosCGP() {
		return baseDatosCGP;
	}
	public void setBaseDatosCGP(CGPDAO baseDatosCGP) {
		this.baseDatosCGP = baseDatosCGP;
	}

	public List<POI> getListaPoisJson() {
		return listaPoisJson;
	}
	public void setListaPoisJson(List<POI> listaPoisJson) {
		this.listaPoisJson = listaPoisJson;
	}
	
}
