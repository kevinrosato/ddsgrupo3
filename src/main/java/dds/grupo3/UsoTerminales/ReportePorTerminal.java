package dds.grupo3.UsoTerminales;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import dds.grupo3.Interfaces.BusquedaDTO;
import dds.grupo3.Interfaces.Reporte;

public class ReportePorTerminal implements Reporte {

	private	Hashtable<String, Integer> tablaReporte = new Hashtable<>();
	private	List<String>	listaStrings = new ArrayList<>();
	@Override
	public void mostrar() {
		System.out.println("|Terminal:			|	Respuestas:		|");
		for(String i: listaStrings)
		{
			System.out.println(""+i+"				"+tablaReporte.get(i));
		}
	}

	@Override
	public void crear(String fecha) {
		BusquedasDAO database = new BusquedasDAO();
		List<BusquedaDTO> lista = database.buscar_Por("Fecha",fecha,"*");
		Integer aux;
		System.out.println("DTOs Terminados!!");
		for(BusquedaDTO i : lista)
		{
			if (!tablaReporte.containsKey(i.getTerminal()))
			{
				System.out.println(i.toString());
				listaStrings.add(i.getTerminal());
				tablaReporte.put(i.getTerminal(),i.getCantRespuestas());
			}
			else
			{
				aux = tablaReporte.get(i.getTerminal());
				tablaReporte.put(i.getTerminal(),( aux + i.getCantRespuestas()));
			}
		}
	}

	@Override
	public Integer verInfoSegun(String key)
	{
		return tablaReporte.get(key);
	}

}
