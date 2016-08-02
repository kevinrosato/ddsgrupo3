package dds.grupo3.User;

import java.util.List;
import java.util.Scanner;

import dds.grupo3.Interfaces.Funcionalidad;
import dds.grupo3.Interfaces.POIGral;
import dds.grupo3.Interfaces.Reporte;
import dds.grupo3.Interfaces.User;
import dds.grupo3.UsoTerminales.BusquedasDAO;
import dds.grupo3.UsoTerminales.FabricaReportes;
import ddsgrupo3.Factory;

public class ReportarPOI implements Funcionalidad {

	private	String dato;
	
	@Override
	public Object realizarFuncion(List<POIGral> lista, Object parametros)
	{
		Reporte rep = (Reporte) Factory.getObject("Reporte");
		String[] aux = ((String) parametros).split(",");
		String qry = FabricaReportes.crearQueryVariables(aux);
		BusquedasDAO database = new BusquedasDAO();
		List<String> listaRta = database.obetenerStrings(qry);
		rep.setColumna1(aux[3]);
		rep.setColumna1(aux[4]);
		for(String dato : listaRta)
		{
			rep.crearFila(dato,database.obetenerValor(FabricaReportes.crearQueryEcuacion(aux,dato)));
			
		}
		return rep;
	}

	@Override
	public void setParametro(Object obj) {
		dato = (String) obj;
	}

	@Override
	public Integer desplegarConsola(User usuario, String terminal_ID,Scanner teclado) {
		System.out.println("---------------------------------------");
		System.out.println("		OPCIONES DE REPORTE");
		System.out.println("----------------------------------------");
		System.out.println();
		System.out.println("Elija el tipo de Reporte:");
		System.out.print("Tipo Parametro:");
		String parametros = teclado.nextLine();
		parametros = parametros.concat(",");
		System.out.print("Valor:");
		parametros = parametros.concat(teclado.nextLine());
		parametros = parametros.concat(",");
		System.out.print("Parametro Iterador:");
		parametros = parametros.concat(teclado.nextLine());
		parametros = parametros.concat(",");
		usuario.reportarSegun(parametros);
		System.out.print("Parametro a Mostrar:");
		parametros = parametros.concat(teclado.nextLine());
		parametros = parametros.concat(",");
		usuario.reportarSegun(parametros);
		System.out.print("Mostrar:");
		System.out.println(" 1 - Suma");
		System.out.println(" 2 - Cantidad");
		System.out.println(" 3 - Valor");
		parametros = parametros.concat(teclado.nextLine());
		parametros = parametros.concat(",");
		return null;
	}

	@Override
	public void mostrarOpcion() {
		System.out.println("-->	GENERAR REPORTE");
	}
}
