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

public class ControllerInfoAvanzada {

	POIGral poi;
	String pathResultadoAnterior="";
	
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
		viewModel.put("atras", pathResultadoAnterior);
		return new ModelAndView(viewModel,"infoAvanzada.html");
	}
	
	public void setPoi(POIGral poi){
		this.poi=poi;
	}

	public String getPathResultadoAnterior() {
		return pathResultadoAnterior;
	}

	public void setPathResultadoAnterior(String pathResultadoAnterior) {
		this.pathResultadoAnterior = pathResultadoAnterior;
	}
}
