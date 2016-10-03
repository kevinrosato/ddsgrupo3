package dds.grupo3.User;


import java.io.Serializable;

import javax.persistence.*;

import dds.grupo3.Interfaces.AdministradorPOIs;
import dds.grupo3.Interfaces.Funcionalidad;
import dds.grupo3.Interfaces.POIGral;
import dds.grupo3.Interfaces.Reporte;
import dds.grupo3.Interfaces.User;
import ddsgrupo3.Factory;


@Entity
@Table(name="Usuario")
public class Usuario implements User,Serializable{
	
	@Id
	@Column(name="username")
	private String username;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="contrasenia")
	private String contrasenia;
	
	@ManyToOne (cascade = CascadeType.ALL)
	@JoinColumn(name = "rol_id")
	private Rol rol;
	
	@Transient
	private AdministradorPOIs mapa;
	
	@Transient
	private Funcionalidad funcionalidad;
	
	public Usuario(){
		this.setNombre("");
		this.setContrasenia("");
		this.setRol(new Rol());
		this.setMapa((AdministradorPOIs) Factory.getObject("AdminPOIs"));
	}
	
	public Integer	mostrarOpciones()
	{
		Integer j = 0;
		System.out.println("canto opciones: "+Integer.toString(this.getRol().getPermisos().size()));
		for (String i: this.getRol().getPermisos())
		{
			j++;
			System.out.print(j.toString()+"->	");
			try {
				((Funcionalidad) Class.forName(this.getClass().getPackage().getName()+"."+i).newInstance()).mostrarOpcion();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return j;
	}	
	@Override
	public Reporte reportarSegun(String parametros) {
		funcionalidad = (Funcionalidad) Factory.getObject("Reportar");
		return (Reporte) realizarFunc(funcionalidad, (Object) parametros);
	}
	public POIGral agregarPOI(POIGral poi){
		funcionalidad = (Funcionalidad) Factory.getObject("Agregar");
		return (POIGral) realizarFunc(funcionalidad, poi);
	}
	public POIGral borrarPOI(POIGral poi){
		funcionalidad = (Funcionalidad) Factory.getObject("Borrar");
		return (POIGral) realizarFunc(funcionalidad, poi);
	}
	//VER COMO SERIA PASANDOLE UNA LISTA DE CAMPOS EN VEZ DE UN POIGral NUEVO
	public POIGral modificarPOI(POIGral poi,POIGral poiNuevo){
		funcionalidad = (Funcionalidad) Factory.getObject("Modificar");
		funcionalidad.setParametro((Object) poiNuevo);
		return (POIGral) realizarFunc(funcionalidad, poi);
	}
	public POIGral consultarPOI(String terminalID){
		funcionalidad = (Funcionalidad) Factory.getObject("Consultar");
		funcionalidad.setParametro((Object) this.getMapa());
		return (POIGral) realizarFunc(funcionalidad, terminalID);
	}
	public POIGral dispararProcesoAsincronico(String parametros){
		funcionalidad = (Funcionalidad) Factory.getObject("BajaDePOI");
		funcionalidad.setParametro(parametros);
		return (POIGral) realizarFunc(funcionalidad, this);
	}
	
	public Object realizarFunc(Funcionalidad funcionalidad,Object poi){
		if(rol.verificarPermisos(funcionalidad))
		{
			return mapa.realizarFuncConPoi(funcionalidad, poi);
		}
		else{
			System.out.println("No tiene permisos para realizar la accion.");
			return null;
		}
	}
	
	//GETTERS Y SETTERS
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}
	public AdministradorPOIs getMapa() {
		return mapa;
	}
	public void setMapa(AdministradorPOIs mapa) {
		this.mapa = mapa;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
