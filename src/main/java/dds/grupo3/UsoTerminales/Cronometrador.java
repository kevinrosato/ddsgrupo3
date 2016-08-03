package dds.grupo3.UsoTerminales;

public class Cronometrador {

	static	Long topeEnMicros;
	static  Long tiempoComienzo;
	static  Long tiempoFin;

	static	public	void	comienzo()
	{
		tiempoComienzo=System.nanoTime();
	}
	static	public	Long	finCuenta()
	{
		tiempoFin=System.nanoTime();
		Long aux = (tiempoFin-tiempoComienzo)/1000;
		return aux;	
	}
	static	public	void	checkRetraso(Integer IDBusqueda)
	{
		if (((tiempoFin-tiempoComienzo)/1000) > topeEnMicros)
		{
			reportarRetaso(IDBusqueda);
		}
	}
	static	public	void	establecerTope(Long uSeg)
	{
		topeEnMicros = uSeg;
	}
	static	private	void	reportarRetaso(Integer IDBusqueda)
	{
		
	}
}
