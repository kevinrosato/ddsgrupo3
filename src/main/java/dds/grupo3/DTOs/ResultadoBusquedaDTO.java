package dds.grupo3.DTOs;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import dds.grupo3.Interfaces.BusquedaDTO;
import dds.grupo3.Interfaces.POI;

@SuppressWarnings("serial")
@Entity
@Table(name="POI")
@Inheritance(strategy=InheritanceType.JOINED)
public class ResultadoBusquedaDTO implements BusquedaDTO,Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
    @Column(name="id")
    private int id;

	@OneToMany (mappedBy="pois",cascade= CascadeType.ALL)
	private List<POI> listaPOIs;

	@Column(name="Respuestas")
	private	Integer	Respuestas;
	@Column(name="Retardo")
	private	Integer	Retardo;
	@Column(name="Terminal")
	private	String	Terminal;
	@Column(name="Parametro")
	private	String	Parametro;
	@Column(name="Fecha")
	private	Date Fecha;

	@Override
	public void setCantRespuestas(Integer cantRespuestas) {
	Respuestas = cantRespuestas;
	}
	public List<POI> getListaPOIs() {
		return listaPOIs;
	}
	public void setListaPOIs(List<POI> listaPOIs) {
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
	}
	public void setFechas(Date fecha) {	
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
}
