package dds.grupo3.POIsSistem;

import java.util.Calendar;

import dds.grupo3.DTOs.CentroDTO;

public class Centro extends CGP implements POIGral {

	CentroDTO	infoDTO;

//	mensajes
	public Centro(String name, Byte numeroCGP)
	{
		super(name, numeroCGP);
	}
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
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Boolean tieneLaClave(String clave) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Boolean estaDisponible(Calendar horaActual) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Boolean esValido() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String conocerTipo() {
		// TODO Auto-generated method stub
		return null;
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
