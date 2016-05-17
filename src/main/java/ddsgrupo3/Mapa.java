package ddsgrupo3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Mapa {
	
	private List<POI> listaPois=new ArrayList<POI>();
	
	//----------
	//Metodos
	//----------
	
	public void realizarBusqueda ()
	{
		List<POI> listaAux =new ArrayList<POI>();
		Scanner scanner = new Scanner(System.in);
		String control = new String();

		do{	
			System.out.print("Ingrese palabra Clave: ");
			String clave = scanner.nextLine();
			if (clave.startsWith("+"))
			{
				clave = clave.substring(1);
				listaAux = filtrarPOIs(clave, listaAux);	
			}
			else	listaAux = buscarPOI(clave);
			mostrarPOIs(clave, listaAux);
			System.out.println("Fin Lista");
			System.out.println("Desea Repetir?  [Y/N]");
			control = scanner.nextLine();
			control.toUpperCase();
		}while (control.equals("Y"));
		scanner.close();
	}

	public	List<POI>	filtrarPOIs(String palabraClave, List<POI> listaAux)
	{	
		List<POI> listaAux2 =new ArrayList<POI>();
		for (POI i: listaAux)
		{
			if (i.tieneLaClave(palabraClave))	listaAux.add(i);
		}
		return listaAux2;	
	}
	
	public	List<POI>	buscarPOI(String palabraClave)
	{	
		return filtrarPOIs(palabraClave, this.getListaPois());
	}
	
	public void buscarYmostrar(String clave)
	{
		mostrarPOIs(clave, this.getListaPois());
	}
	
	public void mostrarPOIs(String palabraClave, List<POI> lista)
	{
		System.out.println("Puntos de Interes con la clave "+palabraClave+":");
		
		for(POI i: lista)			i.mostrarInformacion();
		
		if(lista.size() == 0)
		{
			System.out.println("No se encontraron resultados.");
		}
	}
	
	public Integer	cantPOIs()	{
		return	this.getListaPois().size();
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
	public void agregarPoi(POI poi){
		listaPois.add(poi);
	}
	
}
