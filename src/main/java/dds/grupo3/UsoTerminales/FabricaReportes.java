package dds.grupo3.UsoTerminales;

public class FabricaReportes {
	public	static String	crearQueryVariables(String[] parametros)
	{
		return	"SELECT "+parametros[4]+
				" FROM dbo.Consultas_Realizadas WHERE "+parametros[0]+
				"='"+parametros[1]+
				"' GROUP BY "+parametros[4];
	}
	public static String crearQueryEcuacion(String[] prametros, String valor)
	{
		return null;
	}
}
