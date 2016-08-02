package dds.grupo3.UsoTerminales;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import dds.grupo3.Interfaces.Reporte;
import ddsgrupo3.Factory;

public class ReporteDeBusquedasxFecha implements Reporte {

	private	Hashtable<String, Integer> tablaReporte = new Hashtable<>();
	private	List<String>	listaStrings = new ArrayList<>();
	@Override
	public void mostrar() {
		System.out.println("|Fecha:			||Cantidad de Consultas:	|");
		for(String i: listaStrings)
		{
			System.out.println(""+i+"				"+tablaReporte.get(i).toString());
		}
	}

	@Override
	public void crearSegun(String valor)
	{
		BusquedasDAO database = new BusquedasDAO();
		String	qry	=	"SELECT DISTINCT Fecha,COUNT(*) FROM "
		+((String) Factory.getString("tablaDeBusqeudas"))+
						" GROUP BY Fecha";
		ResultSet resultados = database.ejecutar(qry);
		try {
			while(resultados.next())
			{
				listaStrings.add(resultados.getString("Fecha"));
				tablaReporte.put(resultados.getString("Fecha"),resultados.getInt(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
