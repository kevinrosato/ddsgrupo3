package dds.grupo3.DTOs;

import dds.grupo3.Interfaces.BusquedaDTO;

public class BusquedaDTOImp implements BusquedaDTO {

	private	Integer	Respuestas;
	private	Long	Retardo;
	private	String	Terminal;
	private	String	Parametro;
	private	String	Fecha;


	@Override
	public void setCantRespuestas(Integer cantRespuestas) {
	Respuestas = cantRespuestas;
	}

	@Override
	public void setRetardo(Long l) {
	Retardo = l;
	}

	@Override
	public void setTerminal(String terminal) {
	Terminal = terminal;
	}

	@Override
	public void setParametro(String parametro) {
	Parametro = parametro;
	}

	@Override
	public void setFecha(String fecha) {
	Fecha = fecha;
	}

	@Override
	public Integer getCantRespuestas() {
		return Respuestas;
	}

	@Override
	public Long getRetardo() {
		return Retardo;
	}

	@Override
	public String getTerminal() {
		return Terminal;
	}

	@Override
	public String getParametro() {
		return Parametro;
	}

	@Override
	public String getFecha() {
		return Fecha;
	}
}
