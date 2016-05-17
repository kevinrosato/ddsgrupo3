package ddsgrupo3;

import java.util.Calendar;

public class Horario {
	private Integer diaInicio; //Formato 1 es Domingo, 2 Lunes,...,7 Sabado
	private Integer diaFinal;  //En el caso que no sea un rango (lunes a viernes) y un solo dia (lunes) ambos campos 
	                           //reciben el mismo valor
	private Integer horarioInicio;  //Formato hhmm (HoraHoraMinutoMinuto)
	private Integer horarioCierre;
	
	//----------
	//Metodos
	//----------
	
	public Boolean estaEnElRango (Calendar calendario){
		Integer diaSolicitado= calendario.get(Calendar.DAY_OF_WEEK);
		Integer horaSolicitada= calendario.get(Calendar.HOUR_OF_DAY)*100+calendario.get(Calendar.MINUTE);
		
		return (diaSolicitado>=this.diaInicio &&  diaSolicitado<=this.diaFinal &&
				(horaSolicitada>=this.horarioInicio)&& (horaSolicitada<=this.horarioCierre));
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
	
}
