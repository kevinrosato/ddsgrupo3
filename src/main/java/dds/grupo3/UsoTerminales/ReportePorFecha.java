package dds.grupo3.UsoTerminales;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import dds.grupo3.Interfaces.BusquedaDTO;
import dds.grupo3.Interfaces.Reporte;

public class ReportePorFecha implements Reporte {

	private	Hashtable<String, Integer> tablaReporte = new Hashtable<>();
	private	List<String>	listaStrings = new ArrayList<>();
	@Override
	public void crear(String terminal) {
		BusquedasDAO database = new BusquedasDAO();
		List<BusquedaDTO> lista = database.buscar_Por("Terminal",terminal,"*");
		System.out.println("DTOs Terminados!!");
		for(BusquedaDTO i : lista)
		{
			if (!tablaReporte.containsKey(i.getFecha()))
			{
				listaStrings.add(i.getFecha());
				tablaReporte.put(i.getFecha(),1);
			}
			else
			{
				tablaReporte.put(i.getFecha(),(tablaReporte.get(i.getFecha()))+1);
			}
		}
	}
	@Override
	public void mostrar() {
		System.out.println("|	Fecha:	|	Busquedas:	|");
		for(String i: listaStrings)
		{
			System.out.println("	"+i+"	|	"+tablaReporte.get(i)+"	|");
		}
	}
	@Override
	public Integer verInfoSegun(String key)
	{
		return tablaReporte.get(key);
	}
}
