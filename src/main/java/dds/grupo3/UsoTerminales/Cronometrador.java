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
		Long duracion;
		tiempoFin=System.nanoTime();
		duracion= (tiempoFin-tiempoComienzo)/1000000; //pasa de nanosegundos a milisegundos
		return duracion;
	}
	
	static	public	void	establecerTope(Long uSeg)
	{
		topeEnMicros = uSeg;
	}
}
