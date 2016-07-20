package dds.grupo3.DTOs;

import java.util.Calendar;

import dds.grupo3.Interfaces.POI;
import dds.grupo3.Interfaces.POIGral;
import dds.grupo3.POIsSistem.Horario;
import dds.grupo3.POIsSistem.Ubicacion;

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
		System.out.println(this.getInfoDTO().toString());
	}
	@Override
	public void mostrarInformacion()
	{
		System.out.println(this.getInfoDTO().mostrar());
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
				|| this.getInfoDTO().getZonasIncluidas().contains(clave)
				|| this.getInfoDTO().getNombreDirector().contains(clave));
	}
	@Override
	public Boolean estaDisponible(Calendar horaActual){
		for (ServDTO i: this.getInfoDTO().getServicios())
		{
			for (HorariosServDTO j: i.getHorarios())
			{
				Horario horario = new Horario();
				horario.setDiaInicio((j.getDia() % 7)+1); //Parseado porque los DTO empiezan 1=Lunes y los nuestros 1=Domingo
				horario.setDiaFinal((j.getDia() % 7)+1);
				horario.setHorarioInicio(j.getHoraInicio()*100 + j.getMinInicio());
				horario.setHorarioCierre(j.getHoraFin()*100 + j.getMinFin());
				if(horario.estaEnElRango(horaActual))
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
