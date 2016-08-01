package dds.grupo3.User;

import java.util.List;

import dds.grupo3.Interfaces.Funcionalidad;
import dds.grupo3.Interfaces.POIGral;
import dds.grupo3.Interfaces.Reporte;
import ddsgrupo3.Factory;

public class ReportarPOI implements Funcionalidad {

	private	String dato;
	
	@Override
	public Object realizarFuncionConPOI(List<POIGral> listaPois, Object tipoReporte)
	{
		Reporte rep = (Reporte)	Factory.getObject((String) tipoReporte);
		System.out.println("Se crea bien la clase Reporte por "+tipoReporte);
		rep.crear(dato);
		return rep;
	}

	@Override
	public void setParametro(Object obj) {
		dato = (String) obj;
	}
}
