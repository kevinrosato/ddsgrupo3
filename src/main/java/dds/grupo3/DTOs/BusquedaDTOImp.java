package dds.grupo3.DTOs;

import java.util.List;
import dds.grupo3.Interfaces.BusquedaDTO;
import dds.grupo3.Interfaces.POIGral;

public class BusquedaDTOImp implements BusquedaDTO {

	private List<POIGral> listaPOIs;

	private	Integer	Respuestas;
	private	Integer	Retardo;
	private	String	Terminal;
	private	String	Parametro;
	private	String	Fecha;

	@Override
	public void setCantRespuestas(Integer cantRespuestas) {
	Respuestas = cantRespuestas;
	}
	public List<POIGral> getListaPOIs() {
		return listaPOIs;
	}
	public void setListaPOIs(List<POIGral> listaPOIs) {
		this.listaPOIs = listaPOIs;
	}
	public Integer getRespuestas() {
		return Respuestas;
	}
	public void setRespuestas(Integer respuestas) {
		Respuestas = respuestas;
	}
	@Override
	public void setRetardo(Integer l) {
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
	public Integer getRetardo() {
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
