package ddsgrupo3;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import dds.grupo3.Interfaces.AdministradorPOIs;
import dds.grupo3.Interfaces.CGPDAO;
import dds.grupo3.Interfaces.Funcionalidad;
import dds.grupo3.Interfaces.POIGral;
import dds.grupo3.JSON.SucursalBancoJSONFactory;
import dds.grupo3.POIsSistem.Ubicacion;

public class Mapa	implements AdministradorPOIs{
	
	public List<POIGral> listaPois = new ArrayList<POIGral>();
	private Calendar horaActual;
	private Ubicacion ubicacionActual;
	private CGPDAO baseDatosCGP;
	//----------
	//Metodos
	//----------
	public Mapa(){
		SucursalBancoJSONFactory factoryJson= new SucursalBancoJSONFactory();
		listaPois.addAll(factoryJson.generarPoi());
	}
	//----------------------------------------------
	//METODOS ABCM
	public Object realizarFuncConPoi(Funcionalidad funcionalidad,Object poi){
		return funcionalidad.realizarFuncion(listaPois,poi);
	}	
	
	//----------
	//Getters y Setters
	//----------

	public List<POIGral> getListaPois() {
		List<POIGral>	listaAux = new ArrayList<>();
		listaAux.addAll(baseDatosCGP.getAll());
		listaAux.addAll(this.listaPois);
		return listaAux;
	}
	public void setListaPois(List<POIGral> listaPois) {
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
	public void agregarPoi(POIGral poi){
		listaPois.add(poi);
	}
	public CGPDAO getBaseDatosCGP() {
		return baseDatosCGP;
	}
	public void setBaseDatosCGP(CGPDAO dB) {
		this.baseDatosCGP = dB;
		listaPois.addAll(baseDatosCGP.getAll());
	}
/*
 * OBSOLETOS
 */
	public void buscarYmostrar(String clave)
	{
		mostrarPOIs(clave, this.buscarEn(clave, this.getListaPois()));
	}
	private	List<POIGral>	buscarEn(String palabraClave, List<POIGral> lista)
	{	
		palabraClave = palabraClave.trim();
		if (palabraClave.contains("Disponible")) return this.buscarDisponibles(lista);
		else if (palabraClave.contains("Cercano")) return this.buscarCercanos(lista);
		else return	this.buscarPOIs(palabraClave, lista);
	}
	private	List<POIGral>	buscarDisponibles(List<POIGral> lista)
	{
		List<POIGral> listaAux = new ArrayList<POIGral>();		
		for (POIGral i: lista)
		{
			if (i.estaDisponible(this.getHoraActual()))	listaAux.add(i);
		}
		return listaAux;
	}
	private	List<POIGral>	buscarPOIs(String palabraClave, List<POIGral> lista)
	{	
		List<POIGral> listaAux = new ArrayList<POIGral>();
		for (POIGral i: lista)
		{
			if (i.tieneLaClave(palabraClave))	listaAux.add(i);
		}
		return listaAux;	
	}
	private	List<POIGral>	buscarCercanos(List<POIGral> lista)
	{
		List<POIGral> listaAux = new ArrayList<POIGral>();		
		for (POIGral i: lista)
		{
			if (i.estaCercaDe(this.getUbicacionActual()))	listaAux.add(i);
		}
		return listaAux;	
	}
	private void mostrarPOIs(String palabraClave, List<POIGral> lista)
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
		else
		{
			for(POIGral i: lista)	i.mostrarInformacion();
		}
	}

}
