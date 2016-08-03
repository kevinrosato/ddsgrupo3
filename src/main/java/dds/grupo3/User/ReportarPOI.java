package dds.grupo3.User;

import java.util.List;
import java.util.Scanner;

import dds.grupo3.Interfaces.Funcionalidad;
import dds.grupo3.Interfaces.POIGral;
import dds.grupo3.Interfaces.Reporte;
import dds.grupo3.Interfaces.User;
import ddsgrupo3.Factory;

public class ReportarPOI implements Funcionalidad {

	private	String dato;
	
	@Override
	public Object realizarFuncion(List<POIGral> lista, Object parametros)
	{
		String[] aux = ((String) parametros).split(",");
		Reporte rep = (Reporte) Factory.getObject(aux[0]);
		rep.crearSegun(aux[1]);
		return rep;
	}

	@Override
	public void setParametro(Object obj) {
		setDato((String) obj);
	}

	@Override
	public Integer desplegarConsola(User usuario, String terminal_ID,Scanner teclado) {
		System.out.println("---------------------------------------");
		System.out.println("		OPCIONES DE REPORTE");
		System.out.println("----------------------------------------");
		System.out.println();
		System.out.println("Elija el tipo de Reporte:");
		System.out.println("1 - Reporte de Cant Busquedas por Fecha");
		System.out.println("2 - Reporte de Cada Busqueda por Terminal");
		String parametros = teclado.nextLine();

		if(Integer.parseInt(parametros) ==1)
		{
			parametros = "reporte1,";
			parametros = parametros.concat("x");
		}
		else if(Integer.parseInt(parametros) ==2)
		{
			parametros = "reporte3,";
			parametros = parametros.concat("x");
		}
		usuario.reportarSegun(parametros).mostrar();
		return 0;
	}
	@Override
	public void mostrarOpcion() {
		System.out.println("	GENERAR REPORTE");
	}

	public String getDato() {
		return dato;
	}

	public void setDato(String dato) {
		this.dato = dato;
	}
}
