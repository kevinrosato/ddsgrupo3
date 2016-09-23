package dds.grupo3.POIsSistem;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Horario")
public class Horario implements Serializable{
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
    @Column(name="horario_id")
    private int horario_id;
	
	@ManyToOne
	@JoinColumn(name = "servicio_id", nullable = false)
	private Servicio servicio;
	
	@Column(name="diaInicio")
	private Integer diaInicio; //Formato 1 es Domingo, 2 Lunes,...,7 Sabado
	@Column(name="diaFinal")
	private Integer diaFinal;  //En el caso que no sea un rango (lunes a viernes) y un solo dia (lunes) ambos campos 
	                           //reciben el mismo valor
	@Column(name="horarioInicio")
	private Integer horarioInicio;  //Formato hhmm (HoraHoraMinutoMinuto)
	@Column(name="horarioCierre")
	private Integer horarioCierre;
	
	public Horario(Servicio servicio){
		this.horario_id=0;
		this.servicio=servicio;
		this.horarioCierre=0;
		this.horarioInicio=0;
		this.diaFinal=0;
		this.diaInicio=0;
	}
	
	//----------
	//Metodos
	//----------
	
	public Boolean estaEnElRango (Calendar calendario){
		Integer diaSolicitado= calendario.get(Calendar.DAY_OF_WEEK);
		Integer horaSolicitada= calendario.get(Calendar.HOUR_OF_DAY)*100+calendario.get(Calendar.MINUTE);
		
		return (diaSolicitado>=this.diaInicio &&  diaSolicitado<=this.diaFinal &&
				(horaSolicitada>=this.horarioInicio)&& (horaSolicitada<=this.horarioCierre));
	}
	
	public String toString(){
		return ", Fecha: "+this.getDiaInicio()+", Hora: "+this.getHorarioInicio()+"-"+this.getHorarioCierre();
	}
	
	//Metodo Obsoleto
//	
//	private String parserDias(Integer numeroDia){
//		switch(numeroDia){
//			case 1:
//				return "Domingo";
//			case 2:
//				return "Lunes";
//			case 3:
//				return "Martes";
//			case 4:
//				return "Miercoles";
//			case 5:
//				return "Jueves";
//			case 6:
//				return "Viernes";
//			case 7:
//				return "Sabado";
//			default:
//				return "Invalido";
//		}
//	}
	
	//----------
	//Getters y Setters
	//----------
	
	public Integer getHorarioInicio() {
		return horarioInicio;
	}
	public Integer getDiaInicio() {
		return diaInicio;
	}
	public void setDiaInicio(Integer diaInicio) {
		this.diaInicio = diaInicio;
	}

	public Integer getDiaFinal() {
		return diaFinal;
	}

	public void setDiaFinal(Integer diaFinal) {
		this.diaFinal = diaFinal;
	}

	public void setHorarioInicio(Integer horarioInicio) {
		this.horarioInicio = horarioInicio;
	}
	public Integer getHorarioCierre() {
		return horarioCierre;
	}
	public void setHorarioCierre(Integer horarioCierre) {
		this.horarioCierre = horarioCierre;
	}

	public int getHorario_id() {
		return horario_id;
	}

	public void setHorario_id(int horario_id) {
		this.horario_id = horario_id;
	}
	
}
