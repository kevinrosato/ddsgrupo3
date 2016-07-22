package dds.grupo3.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dds.grupo3.Interfaces.AdministradorPOIs;
import dds.grupo3.Interfaces.Funcionalidad;
import dds.grupo3.Interfaces.POIGral;
import dds.grupo3.Interfaces.User;
import dds.grupo3.UsoTerminales.BusquedasDAO;
import dds.grupo3.UsoTerminales.Cronometrador;

public class ConsultarPOI implements Funcionalidad {

	private AdministradorPOIs mapa;

	@Override
	public Object realizarFuncionConPOI(List<POIGral> listaPois, Object user)
	{
		BusquedasDAO database = new BusquedasDAO
				("com.microsoft.sqlserver.jdbc.SQLServerDriver",
				"jdbc:sqlserver://Tec\\TC:1433;databaseName=busquedas",
				"dds3.POIs","dds3");
		List<POIGral> listaResultante = new ArrayList<POIGral>();
		Scanner scanner = new Scanner(System.in);
		String clave = new String();
		do
		{	
			System.out.print("Ingrese palabra Clave: ");
			clave = scanner.nextLine();			
			Cronometrador.comienzo();
			if (clave.startsWith("+"))
			{
				clave = clave.substring(1);
				listaResultante = buscarEn(clave, listaResultante);	
			}
			else	listaResultante = buscarEn(clave, listaPois);				
			clave = mostrarPOIs(clave, listaResultante,scanner);
			database.guardarBusqueda((User) user, clave, listaResultante.size(),Cronometrador.finCuenta());			
		}while (!clave.contains("Y"));
		return listaResultante.get(0);
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
			System.out.print("¿POI Indicado? [Y/N]");
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
}
