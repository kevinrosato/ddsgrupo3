package dds.grupo3.UsoTerminales;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import dds.grupo3.Interfaces.BusquedaDTO;
import dds.grupo3.Interfaces.Reporte;

public class ReporteImple implements Reporte {

	private String columna1;
	private String columna2;
	
	private	Hashtable<String, Integer> tablaReporte = new Hashtable<>();
	private	List<String>	listaStrings = new ArrayList<>();

	@Override
	public void mostrar() {
		System.out.println("|"+columna1+":			||"+columna2+":			|");
		for(String i: listaStrings)
		{
			System.out.println(""+i+"				"+tablaReporte.get(i));
		}
	}

	@Override
	public void crearFila(String dato, Integer result)
	{
		tablaReporte.put(dato, result);
	}

	@Override
	public Integer verInfoSegun(String key)
	{
		return tablaReporte.get(key);
	}
	public String getColumna1() {
		return columna1;
	}

	public void setColumna1(String columna1) {
		this.columna1 = columna1;
	}

	public String getColumna2() {
		return columna2;
	}

	public void setColumna2(String columna2) {
		this.columna2 = columna2;
	}
	
}
