package dds.grupo3.BaseDeDatos;

import java.util.List;
import org.hibernate.Session;
import dds.grupo3.DTOs.Busquedas;
import dds.grupo3.UsoTerminales.BusquedasHAO;

public class QueryBusquedas {

	public static List<Busquedas> obtenerBusquedas(String username,String dI,String mI,String yI,String dF,String mF,String yF,Session session){
		String parametro1 = "";
		String parametro2 = "";
		String parametro3 = "";
		String	qry	="FROM Busquedas b";
		String where = "";
		if (!username.isEmpty())
		{
			where=" WHERE ";
			parametro1 = "b.Terminal like '%"+username+"%'";
		}
		if (!yF.isEmpty() || !mF.isEmpty()|| !dF.isEmpty())
		{
			where=" WHERE ";	
			parametro2 = "year(b.Fecha) <= "+yF+" and "
						+"month(b.Fecha) <= "+mF+" and "
						+"day(b.Fecha) <= "+dF;
		}
		if (!yI.isEmpty() || !mI.isEmpty()|| !dI.isEmpty())
		{
			where=" WHERE ";
			parametro3 = "year(b.Fecha) >= "+yI+" and "
						+"month(b.Fecha) >= "+mI+" and "
						+"day(b.Fecha) >= "+dI;
		}
		
		if(!username.isEmpty())
		{
			if(!yI.isEmpty() || !mI.isEmpty()|| !dI.isEmpty() || !yF.isEmpty() || !mF.isEmpty()|| !dF.isEmpty())
			{
				parametro1 = parametro1.concat(" AND ");		
			}
		}
		if(!yF.isEmpty() || !mF.isEmpty()|| !dF.isEmpty())
		{
			if(!yI.isEmpty() || !mI.isEmpty()|| !dI.isEmpty())
			{
				parametro2 = parametro2.concat(" AND ");
			}
		}
		qry	=	qry.concat(where).concat(parametro1).concat(parametro2).concat(parametro3);
		return (BusquedasHAO.crearDTOsDe(qry, session));
	}
}
