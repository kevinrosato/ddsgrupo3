package dds.grupo3.UsoTerminales;

import java.io.FileInputStream;
import java.util.Properties;

import dds.grupo3.Interfaces.BusquedaDTO;
import ddsgrupo3.Mailbox;

public class Cronometrador {

	static	Long topeEnMicros;
	static  Long tiempoComienzo;
	static  Long tiempoFin;
	static  FileInputStream file;

	static	public	void	comienzo()
	{
		tiempoComienzo=System.nanoTime();
	}
	static	public	Integer	finCuenta()
	{
		tiempoFin=System.nanoTime();
		return (int) ((tiempoFin-tiempoComienzo)/1000);
	}
	static	public	void	checkRetraso(BusquedaDTO Busqueda)
	{
		if (((tiempoFin-tiempoComienzo)/1000000) > topeEnMicros)
		{
			reportarRetraso(Busqueda);
		}
	}
	static	public	void	establecerTope(Long uSeg)
	{
		topeEnMicros = uSeg;
	}
	static	private	void	reportarRetraso(BusquedaDTO Busqueda)
	{
		try {
			file= new FileInputStream("Cronometrador.properties");
			Properties propiedades = new Properties();
			propiedades.load(file);
			String mail = propiedades.getProperty("mailAdminDefault");
			Mailbox.enviarMail(mail, "Reporte de retraso", "Se informa que la busqueda con ID="+
			                                              Busqueda.getId()+" supero el retraso tope asignado.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
