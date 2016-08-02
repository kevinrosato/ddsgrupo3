package procesosAsincronicos;

import java.util.ArrayList;
import java.util.List;

import dds.grupo3.Interfaces.ProcesoAsincronico;

public class ProcesoMultiple extends ProcesoAsincronico{
	//TODO: Implementacion real
	private List<ProcesoAsincronico> procesos= new ArrayList<ProcesoAsincronico>();
	
	@Override
	public void execute(){
		for(ProcesoAsincronico i:procesos){
			i.execute();
		}
	}
}
