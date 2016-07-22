package dds.grupo3.UsoTerminales;

import java.util.Hashtable;
import java.util.List;

import dds.grupo3.Interfaces.BusquedaDTO;
import dds.grupo3.Interfaces.Reporte;

public class ReportePorFecha implements Reporte {

	private	Hashtable<String, Integer> tablaReporte;
	private	List<String>	listaStrings;
	@Override
	public void mostrar() {
		System.out.println("|	Fecha:	|	Busquedas:	|");
		for(String i: listaStrings)
		{
			System.out.println("	"+i+"	|	"+tablaReporte.get(i)+"	|");
		}
	}

	@Override
	public void crear(String terminal) {
		
		BusquedasDAO database = new BusquedasDAO
				("com.microsoft.sqlserver.jdbc.SQLServerDriver",
				"jdbc:sqlserver://Tec\\TC:1433;databaseName=busquedas",
				"dds3.POIs","dds3");
		List<BusquedaDTO> lista = database.buscar_En_Tabla(terminal);
		
		Integer auxiliar = 0;
		for(BusquedaDTO i : lista)
		{
			for(BusquedaDTO j: lista)
			{
				if (j.getFecha().equals(i.getFecha()))	auxiliar ++;
			}
			listaStrings.add(i.getFecha());
			tablaReporte.put(i.getFecha(),auxiliar);
			auxiliar = 0;
		}
	}

	@Override
	public Integer verInfoSegun(String key)
	{
		return tablaReporte.get(key);
	}

}
