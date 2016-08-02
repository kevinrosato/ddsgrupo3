package dds.grupo3.ProcesosAsincronicos;

import java.util.ArrayList;
import java.util.List;

import dds.grupo3.Interfaces.ProcesoAsincronico;
import dds.grupo3.Interfaces.User;

public class ProcesoMultiple extends ProcesoAsincronico{
	//TODO: Implementacion real
	private List<ProcesoAsincronico> procesos= new ArrayList<ProcesoAsincronico>();
	
	@Override
	public void execute(){
		for(ProcesoAsincronico i:procesos){
			i.execute();
		}
	}

	@Override
	public Integer desplegarConsola(User usuario, String terminal_ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void mostrarOpcion() {
		// TODO Auto-generated method stub
		
	}
}
