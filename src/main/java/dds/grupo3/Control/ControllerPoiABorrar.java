package dds.grupo3.Control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hibernate.Session;

import dds.grupo3.BaseDeDatos.QuerysPois;
import dds.grupo3.Interfaces.POIGral;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class ControllerPoiABorrar {
	
	public ModelAndView show( Request request, Response response,Session session) {
		HashMap<String, Object> viewModel = new HashMap<String, Object>();
		String key=request.queryParams("value_key");
		String idPoi=key;
		List<InformacionPoi> informacionPois=new ArrayList<InformacionPoi>();
		List<String> infoRecibida=new ArrayList<String>();
		String imagen="";
		
		POIGral poi = QuerysPois.buscarPOI(session, idPoi);
		imagen=poi.getImagen();
		infoRecibida=poi.mostrarInformacionAvanzada();
		for(String i:infoRecibida){
			InformacionPoi infoAGuardar=new InformacionPoi(i.split("=")[0],i.split("=")[1]);
			informacionPois.add(infoAGuardar);
		}
		viewModel.put("imagen", imagen);
		viewModel.put("infoAvanzada", informacionPois);
		viewModel.put("id", idPoi);
		return new ModelAndView(viewModel,"infoPOIaBorrar.html");
	}
}
