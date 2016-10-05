package dds.grupo3.Control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import dds.grupo3.FabricaPOIs.FabricaDePOIs;
import dds.grupo3.Interfaces.POI;
import dds.grupo3.Interfaces.POIGral;
import dds.grupo3.Interfaces.User;
import dds.grupo3.POIsSistem.Local;
import dds.grupo3.User.RolTerminal;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class ControllerAltaPOI {
	private static List<ParametrosPOI> resultados = new ArrayList<ParametrosPOI>();
	private String clasePOI="";
	
	public ModelAndView show(Request request, Response response, Session session, User usuario) {
		HashMap<String, Object> viewModel = new HashMap<>();
		String key = request.queryParams("value_key");
		if (key != null) {
			String opcion = key;
			// despliega las opciones correspondientes
			try {
				POI p = (POI) Class.forName("dds.grupo3.POIsSistem." + opcion).newInstance();
				this.clasePOI = p.getClass().getName();
				List<String> campos = new ArrayList<String>();
				resultados.clear();
				campos.addAll(p.mostrarNombresCampos());
				for (int i = 0; i < campos.size(); i++) {
					ParametrosPOI param = new ParametrosPOI();
					param.setCampoNombre(campos.get(i));
					resultados.add(param);
				}
				viewModel.put("parametros", resultados);
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			if (!resultados.isEmpty()) {
				crearPOI(request,session);
			}
		}
		return new ModelAndView(viewModel, "agregarPOI.html");
	}

	private void crearPOI(Request request, Session session) {
		String[] campos = request.queryParamsValues("resultado");
		try {
			POI poi = (POI) Class.forName(this.clasePOI).newInstance();
			poi.settearCampos(campos);
			//transaccion
			session.beginTransaction();
        	session.save((POIGral)poi);
        	session.getTransaction().commit();
			this.clasePOI="";
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
