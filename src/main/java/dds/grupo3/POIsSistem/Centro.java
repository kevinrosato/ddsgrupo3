package dds.grupo3.POIsSistem;

import java.util.Calendar;

import dds.grupo3.DTOs.CentroDTO;
import dds.grupo3.DTOs.HorariosServDTO;
import dds.grupo3.DTOs.ServDTO;

public class Centro extends POI implements POIGral {

	CentroDTO	infoDTO;


	public Centro(CentroDTO	centro)
	{
		this.setInfoDTO(centro);
	}
//	mensajes
	@Override
	public void mostrarInformacionAvanzada()
	{
		this.getInfoDTO().toString();
	}
	@Override
	public void mostrarInformacion()
	{
		this.mostrarInformacionAvanzada();
	}
	@Override
	public Boolean estaCercaDe(Ubicacion ubicacion)
	{
		return ubicacion.getComuna().equals(this.getInfoDTO().getNumComuna());
	}
	@Override
	public Boolean tieneLaClave(String clave)
	{
		return (this.getInfoDTO().getDomicilioCompleto().contains(clave)
				|| this.getInfoDTO().getZonasIncluidas().contains(clave));
	}
	@Override
	public Boolean estaDisponible(Calendar horaActual){
		Integer diaSolicitado= horaActual.get(Calendar.DAY_OF_WEEK);
		Integer horaSolicitada= horaActual.get(Calendar.HOUR_OF_DAY)*100+horaActual.get(Calendar.MINUTE);
		for (ServDTO i: this.getInfoDTO().getServicios())
		{
			for (HorariosServDTO j: i.getHorarios())
			{
				Horario horario = new Horario();
				horario.setDiaInicio((j.getDia() % 7)+1); //Parseado porque los DTO empiezan 1=Lunes y los nuestros 1=Domingo
				horario.setDiaFinal((j.getDia() % 7)+1);
				horario.setHorarioInicio(j.getHoraInicio()*100 + j.getMinInicio());
				horario.setHorarioCierre(j.getHoraFin()*100 + j.getMinFin());
				if(diaSolicitado>=horario.getDiaInicio() &&  diaSolicitado<=horario.getDiaFinal() &&
						(horaSolicitada>=horario.getHorarioInicio())&& (horaSolicitada<=horario.getHorarioCierre()))
				{
					return true;
				}
			}
		}
		return false;
	}
	@Override
	public Boolean esValido()
	{
		return true;
	}
	@Override
	public String conocerTipo()
	{
		return "Centro De Gestion y Participacion (CGP)";
	}
	
//	GyS
	public CentroDTO getInfoDTO()
	{
		return infoDTO;
	}
	public void setInfoDTO(CentroDTO infoDTO)
	{
		this.infoDTO = infoDTO;
	}
	}
