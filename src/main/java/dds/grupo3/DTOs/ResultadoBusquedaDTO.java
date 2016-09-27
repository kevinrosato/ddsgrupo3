package dds.grupo3.DTOs;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import dds.grupo3.Interfaces.BusquedaDTO;
import dds.grupo3.Interfaces.POI;

@SuppressWarnings("serial")
@Entity
@Table(name="Busquedas")
@Inheritance(strategy=InheritanceType.JOINED)
public class ResultadoBusquedaDTO implements BusquedaDTO,Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
    @Column(name="busqueda_id")
    private int busqueda_id;

	@ManyToMany(fetch = FetchType.LAZY,cascade= CascadeType.ALL)
	@JoinTable	(name = "POIsxBusqueda",joinColumns = {@JoinColumn(name = "busqueda_id", nullable = false, updatable = false)},
	inverseJoinColumns = { @JoinColumn(name = "poi_id",nullable = false, updatable = false) })
	private List<POI> POIs;

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
		return POIs;
	}
	public void setListaPOIs(List<POI> listaPOIs) {
		this.POIs = listaPOIs;
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
	public void setPOIs(List<POI> pois) {
	POIs = pois;
	}
	@Override
	public List<POI> getPOIs() {
	return POIs;
	}
}
