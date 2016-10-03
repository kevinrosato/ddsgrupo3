package dds.grupo3.DTOs;

import java.sql.Date;
import java.util.List;
import dds.grupo3.Interfaces.BusquedaDTO;
import dds.grupo3.Interfaces.POI;

public class BusquedaDTOImp implements BusquedaDTO {

	private List<POI> listaPOIs;

	private	Integer	Respuestas;
	private	Integer	Retardo;
	private	String	Terminal;
	private	String	Parametro;
	private	Date	Fecha;

	@Override
	public void setCantRespuestas(Integer cantRespuestas) {
	Respuestas = cantRespuestas;
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
	public void setFecha(Date fecha) {
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
		return Fecha.toString();
	}
	@Override
	public Integer getId() {
		return 0;
	}
	@Override
	public void setPOIs(List<POI> lista) {
		listaPOIs = lista;
	}
	@Override
	public List<POI> getPOIs() {
		return listaPOIs;
	}
}
