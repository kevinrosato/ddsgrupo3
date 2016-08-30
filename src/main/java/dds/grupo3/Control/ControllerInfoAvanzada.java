package dds.grupo3.Control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import dds.grupo3.Interfaces.POIGral;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class ControllerInfoAvanzada {

	POIGral poi;
	
	public ModelAndView show( Request request, Response response,List<POIGral> resultadosAnteriores) {
		HashMap viewModel = new HashMap();
		String nombrePoi=request.queryParams("value_key"); 
		List<InformacionPoi> informacionPois=new ArrayList<InformacionPoi>();
		List<String> infoRecibida=new ArrayList<String>();
		String imagen="";
		String infoAvanzada="";
		for(POIGral poi:resultadosAnteriores){
			if(poi.mostrarInformacion()[0].equals(nombrePoi)){
				imagen=poi.getImagen();
				infoRecibida=poi.mostrarInformacionAvanzada();
				for(String i:infoRecibida){
					InformacionPoi infoAGuardar=new InformacionPoi(i.split("=")[0],i.split("=")[1]);
					informacionPois.add(infoAGuardar);
				}
			}
		}
		viewModel.put("imagen", imagen);
		viewModel.put("infoAvanzada", informacionPois);
		return new ModelAndView(viewModel,"infoAvanzada.html");
	}
	
	public void setPoi(POIGral poi){
		this.poi=poi;
	}
}
