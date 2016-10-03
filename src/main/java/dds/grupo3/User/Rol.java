package dds.grupo3.User;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import dds.grupo3.Interfaces.Funcionalidad;

@SuppressWarnings("serial")
@Entity
@Table(name="Rol")
public class Rol implements Serializable{

	@Id
	@GeneratedValue(strategy = IDENTITY) 
	@Column(name="rol_id")
	private int rol_id;

	@ElementCollection
	@CollectionTable(name = "permiso",joinColumns=@JoinColumn(name="rol_id"))
	private List<String> permisos = new ArrayList<String>();
	
	@Column(name="nombre")
	private String nombre;
	
	
	public Boolean verificarPermisos(Funcionalidad funcionalidad){
		Boolean valor=false;
		for(String i:permisos){
			if(i==funcionalidad.getClass().getName()) valor=true; 
		}
		return valor;
	}

	public List<String> getPermisos() {
		return permisos;
	}

	public void setPermisos(List<String> permisos) {
		this.permisos = permisos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
