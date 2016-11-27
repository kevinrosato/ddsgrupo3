package dds.grupo3.UsoTerminales.EnDesuso;

import dds.grupo3.OtrasClases.Factory;

public class FabricaReportes {
	public	static String	crearQueryVariables(String[] parametros)
	{
		return	"SELECT "+parametros[2]+
				" FROM "+((String) Factory.getString("tablaDeBusqeudas"))+
				" WHERE "+parametros[0]+"='"+parametros[1]+
				"' GROUP BY "+parametros[2];
	}
	public static String crearQueryEcuacion(String[] parametros, String valor)
	{
		String calculo;
		if(parametros[3] == "Respuestas")
		{
			calculo = "Sum("+((String) Factory.getString("tablaDeBusqeudas"))+
					".Respuestas)";
		}
		else if (parametros[3] == "Cantidad")
		{
			calculo = "DISTINCT COUNT(*)";
		}
		else	calculo = "*";
		
		return "SELECT "+calculo+" FROM "
				+((String) Factory.getString("tablaDeBusqeudas"))+
				" WHERE "+parametros[0]+
				"='"+parametros[1]+
				"' AND "+parametros[2]+"='"+valor+"'";
	}
}
