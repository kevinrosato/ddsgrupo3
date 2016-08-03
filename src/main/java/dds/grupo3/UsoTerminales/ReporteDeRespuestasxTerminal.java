package dds.grupo3.UsoTerminales;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import dds.grupo3.Interfaces.Reporte;
import ddsgrupo3.Factory;

public class ReporteDeRespuestasxTerminal implements Reporte {
	private	Hashtable<String, Integer> tablaReporte = new Hashtable<>();
	private	List<String>	listaStrings = new ArrayList<>();
	private Hashtable<String, Reporte>	listaRepo	= new Hashtable<>();
	
	@Override
	public void mostrar() {
		for(String i: listaStrings)
		{
			System.out.println("__________________________________________");
			listaRepo.get(i).mostrar();
			System.out.println("Total:		"+tablaReporte.get(i));
		}
		System.out.println("__________________________________________");
	}

	@Override
	public void crearSegun(String valor)
	{
		String	qry	=	"SELECT DISTINCT Terminal, Sum(Resultados) FROM "
				+((String) Factory.getString("tablaDeBusqeudas"))+
				" GROUP BY Terminal";
		ResultSet resultados = BusquedasDAO.ejecutar(qry);
		try {
			while(resultados.next())
			{
				listaStrings.add(resultados.getString(1));
					Reporte rep = (Reporte) Factory.getObject("reporte2");
					rep.crearSegun(resultados.getString(1));
					listaRepo.put(resultados.getString(1),rep);
				tablaReporte.put(resultados.getString(1),resultados.getInt(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
