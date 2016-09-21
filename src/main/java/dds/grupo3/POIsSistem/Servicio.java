package dds.grupo3.POIsSistem;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Servicio")
public class Servicio {
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
    @Column(name="servicio_id")
    private int servicio_id;
	@OneToMany (mappedBy="servicio",cascade= CascadeType.ALL)
	private List <Horario> horario;
	@Column(name="nombre")
	private String nombre;
	@Column(name="radioCercania")
	private Double radioCercania;
	
	//para los rubros de los locales
	
	//----------
	//Constructor
	//----------
	
	public Servicio(String name)
	{
		this.setServicio_id(0);
		this.setNombre(name);
		this.setHorario(new ArrayList<Horario>());
		this.setRadioCercania(0.0);
	
	}

	//----------
	//Metodos
	//----------	
	
	public Boolean tieneLaClave(String clave) {
		return	(this.getNombre().contains(clave));
	}

	//public boolean estasEnHorarioBancario(Calendar horario2, SucursalBanco banco) {
	//	Integer horaSolicitada= horario2.get(Calendar.HOUR_OF_DAY)*100+horario2.get(Calendar.MINUTE);
	//	return (horaSolicitada>=10 && horaSolicitada<=15);	
	//}
	public Boolean atendesEnEsteHorario(Calendar horario){
		return this.getHorario().stream().anyMatch(unHorario -> unHorario.estaEnElRango(horario));
	}
	
	public String toString(){
		String horario="";
		for(Horario h:this.horario){
			if(!horario.equals("")){horario=horario+"-"+h.toString();}
			else {horario=h.toString();}
		}
		return "Nombre servicio: "+this.getNombre()+", Horarios de atencion: "+ horario+".";
	}
	//----------
	//Getters y Setters
	//----------
	
	public List<Horario> getHorario() {
		return horario;
	}
	public void setHorario(List<Horario> horario) {
		this.horario = horario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getRadioCercania() {
		return radioCercania;
	}
	public void setRadioCercania(Double radioCercania) {
		this.radioCercania = radioCercania;
	}

	public int getServicio_id() {
		return servicio_id;
	}

	public void setServicio_id(int servicio_id) {
		this.servicio_id = servicio_id;
	}


}
