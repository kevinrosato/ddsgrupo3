package dds.grupo3.Control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hibernate.Session;

import dds.grupo3.BaseDeDatos.QuerysPois;
import dds.grupo3.Interfaces.POI;
import dds.grupo3.Interfaces.POIGral;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class ControllerPoiAModificar {
	
	public ModelAndView show(Request request, Response response, Session session) {

		HashMap<String, Object> viewModel = new HashMap<String, Object>();
		String key=request.queryParams("value_key");
		String idPoi=key;
		
		POIGral poi = QuerysPois.buscarPOI(session, idPoi);
		List<String> campos = new ArrayList<String>();
		String[] contenidos = new String[20];
		List<ParametrosPOI> resultados = new ArrayList<ParametrosPOI>();
		
		campos.addAll(((POI) poi).mostrarNombresCampos());
		contenidos=((POI) poi).mostrarContenidosCampos();
		for (int i = 0; i < campos.size(); i++) {
			ParametrosPOI param = new ParametrosPOI();
			param.setCampoNombre(campos.get(i));
			param.setContenido(contenidos[i]);
			resultados.add(param);
		}
		viewModel.put("parametros", resultados);
		viewModel.put("id", idPoi);
		return new ModelAndView(viewModel,"infoPOIaModificar.html");
	}
}
