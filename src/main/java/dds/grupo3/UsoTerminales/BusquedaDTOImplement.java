package dds.grupo3.UsoTerminales;

import dds.grupo3.Interfaces.BusquedaDTO;

public class BusquedaDTOImplement implements BusquedaDTO {

	private	Integer CantRespuestas;
	private	Integer	Retardo;
	private	String	Terminal;
	private	String	Parametro;
	private	String	Fecha;

	public void setCantRespuestas(Integer cantRespuestas) {
		CantRespuestas = cantRespuestas;
	}

	public void setRetardo(Integer retardo) {
		Retardo = retardo;
	}

	public void setTerminal(String terminal) {
		Terminal = terminal;
	}

	public void setParametro(String parametro) {
		Parametro = parametro;
	}

	public void setFecha(String fecha) {
		Fecha = fecha;
	}

	public Integer getCantRespuestas() {
		return CantRespuestas;
	}

	public Integer getRetardo() {
		return Retardo;
	}

	public String getTerminal() {
		return Terminal;
	}

	public String getParametro() {
		return Parametro;
	}

	public String getFecha() {
		return Fecha;
	}
}
