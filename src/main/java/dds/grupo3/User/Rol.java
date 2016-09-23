package dds.grupo3.User;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import dds.grupo3.Interfaces.Funcionalidad;


@Entity
@Table(name="Rol")
public class Rol implements Serializable{

	@Id
	@GeneratedValue(strategy = IDENTITY) // que es lo que haces strategy= IDENTITY?
    @Column(name="rol_id")
	private int rol_id;
	
	private List<Funcionalidad> permisos = new ArrayList<Funcionalidad>();
	
	@Column(name="nombre")
	private String nombre;
	
	
	public Boolean verificarPermisos(Funcionalidad funcionalidad){
		Boolean valor=false;
		for(Funcionalidad i:permisos){
			if(i.getClass()==funcionalidad.getClass()) valor=true; 
		}
		return valor;
	}

	public List<Funcionalidad> getPermisos() {
		return permisos;
	}

	public void setPermisos(List<Funcionalidad> permisos) {
		this.permisos = permisos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
