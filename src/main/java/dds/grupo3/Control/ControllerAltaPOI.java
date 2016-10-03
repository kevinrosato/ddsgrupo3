package dds.grupo3.Control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import dds.grupo3.Interfaces.POI;
import dds.grupo3.Interfaces.User;
import dds.grupo3.POIsSistem.Local;
import dds.grupo3.User.RolTerminal;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class ControllerAltaPOI {
	private static List<ParametrosPOI> resultados=new ArrayList<ParametrosPOI>(); 

	public static ModelAndView show(Request request, Response response, User usuario) {
		HashMap<String, Object> viewModel = new HashMap<>();
		String key = request.queryParams("value_key");
		if (key != null) {
			String opcion = key;
			try {
				POI p = (POI) Class.forName("dds.grupo3.POIsSistem." + opcion).newInstance();
				List<String> campos = new ArrayList<String>();
				resultados.clear();
				campos.addAll(p.mostrarNombresCampos());
				for (int i = 0; i < campos.size(); i++) {
					ParametrosPOI param = new ParametrosPOI();
					param.setCampoNombre(campos.get(i));
					// param.setCampoCodigo(p.getClass().getFields()[i].getName());
					// System.out.println(param.getCampoCodigo());
					resultados.add(param);
				}
				viewModel.put("parametros",resultados);
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			if(!resultados.isEmpty()){
			System.out.println(resultados.get(0).getResultado());
			}
		}
		return new ModelAndView(viewModel, "agregarPOI.html");
	}
}
