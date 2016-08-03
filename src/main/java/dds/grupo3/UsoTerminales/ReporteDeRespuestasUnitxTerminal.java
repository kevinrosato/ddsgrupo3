package dds.grupo3.UsoTerminales;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dds.grupo3.Interfaces.Reporte;
import ddsgrupo3.Factory;

public class ReporteDeRespuestasUnitxTerminal implements Reporte {

	private	List<Integer>	lista = new ArrayList<>();
	private String valorDeReporte;

	@Override
	public void mostrar()
	{
		System.out.println("Terminal:	"+valorDeReporte);
		System.out.println("|Resultados en cada Consulta:");
		System.out.println(lista.toString());
	}
	@Override
	public void crearSegun(String valor) {
		valorDeReporte = valor;
		String	qry	=	"SELECT Resultados FROM "
		+((String) Factory.getString("tablaDeBusqeudas"))+
						" WHERE Terminal='"+valor+"'";
		ResultSet resultados = BusquedasDAO.ejecutar(qry);
		try {
			while(resultados.next())
			{
				lista.add(resultados.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
