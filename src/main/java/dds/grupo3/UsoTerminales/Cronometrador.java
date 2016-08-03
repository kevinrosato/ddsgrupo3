package dds.grupo3.UsoTerminales;

import java.io.FileInputStream;
import java.util.Properties;

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
			reportarRetraso(IDBusqueda);
		}
	}
	static	public	void	establecerTope(Long uSeg)
	{
		topeEnMicros = uSeg;
	}
	static	private	void	reportarRetraso(Integer IDBusqueda)
	{
		try {
			file= new FileInputStream("Cronometrador.properties");
			Properties propiedades = new Properties();
			propiedades.load(file);
			String mail = propiedades.getProperty("mailAdminDefault");
			Mailbox.enviarMail(mail, "Reporte de retraso", "Se informa que la busqueda con ID="+
			                                              IDBusqueda+" supero el retraso tope asignado.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
