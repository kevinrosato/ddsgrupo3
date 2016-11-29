package dds.grupo3.User;


import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import dds.grupo3.Interfaces.Funcionalidad;
import dds.grupo3.Interfaces.POIGral;
import dds.grupo3.Interfaces.User;

@SuppressWarnings("serial")
@Entity
@Table(name="Config_Accion")
public class RealizarAcciones implements Funcionalidad,Serializable{
	@Transient
	private String archivo="/acciones";
	@Id
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name = "username")
	private Usuario user;
	@Column(name="logeo")
	private String logeo="N";
	@Column(name="total_usuario")
	private String total_usuario="N";
	@Column(name="total_fecha")
	private String total_fecha="N";
	
	@Override
	public Integer desplegarConsola(User usuario, String terminal_ID, Scanner teclado) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String mostrarOpcion() {
		// TODO Auto-generated method stub
		return "REALIZAR ACCIONES";
	}

	@Override
	public Object realizarFuncion(List<POIGral> listaPois, Object poi) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setParametro(Object obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getArchivo() {
		// TODO Auto-generated method stub
		return archivo;
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	public String getLogeo() {
		return logeo;
	}

	public void setLogeo(String logeo) {
		this.logeo = logeo;
	}

	public String getTotal_usuario() {
		return total_usuario;
	}

	public void setTotal_usuario(String total_usuario) {
		this.total_usuario = total_usuario;
	}

	public String getTotal_fecha() {
		return total_fecha;
	}

	public void setTotal_fecha(String total_fecha) {
		this.total_fecha = total_fecha;
	}
	

}
