package dds.grupo3.Interfaces;

import java.util.Hashtable;

import dds.grupo3.UsoTerminales.BusquedasDAO;

public interface TipoReporte {
	
	public	Hashtable<Object, Object>	reportarEnTabla(BusquedasDAO claseAcceso);

}
