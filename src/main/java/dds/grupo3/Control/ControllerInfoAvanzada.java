package dds.grupo3.Control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import dds.grupo3.Interfaces.POIGral;
import dds.grupo3.User.Usuario;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class ControllerInfoAvanzada {

	POIGral poi;
	
	public ModelAndView show( Request request, Response response,List<POIGral> resultadosAnteriores) {
		HashMap viewModel = new HashMap();
		String nombrePoi=request.queryParams("value_key"); 
		String imagen="";
		String infoAvanzada="";
		for(POIGral poi:resultadosAnteriores){
			if(poi.mostrarInformacion()[0].equals(nombrePoi)){
				infoAvanzada=poi.mostrarInformacionAvanzada();
				imagen=poi.getImagen();
			}
		}
		viewModel.put("imagen", imagen);
		viewModel.put("informacionAvanzada", infoAvanzada);
		return new ModelAndView(viewModel,"infoAvanzada.html");
	}
	
	public void setPoi(POIGral poi){
		this.poi=poi;
	}
}
