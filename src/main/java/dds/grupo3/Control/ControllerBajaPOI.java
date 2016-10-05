package dds.grupo3.Control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hibernate.Session;

import dds.grupo3.BaseDeDatos.QuerysPois;
import dds.grupo3.Interfaces.POI;
import dds.grupo3.Interfaces.POIGral;
import dds.grupo3.User.ConsultarPOI;
import dds.grupo3.UsoTerminales.BusquedasHAO;
import dds.grupo3.UsoTerminales.Cronometrador;
import ddsgrupo3.Factory;
import ddsgrupo3.Mapa;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class ControllerBajaPOI {
	private static String terminalID = (String) Factory.getString("IDterminal");
	private List<POIGral> resultadosAnteriores = new ArrayList<POIGral>();

	public ModelAndView show(Request request, Response response, Session session) {

		HashMap<String, Object> viewModel = new HashMap<>();
		String nombre1 = request.queryParams("nombre1");
		if (nombre1!=null) {
			String[] agregar = request.queryParamsValues("agregar");
			List<ResultadoBusqueda> resultados = new ArrayList<ResultadoBusqueda>();
			if ((agregar == null) || (resultadosAnteriores.isEmpty())) {
				// Hizo click en buscar->los resultados anteriores en realidad
				// es todo el mapa
				// Hizo click en agregar pero no hay resulados anteriores
				resultados = obtenerBusquedas(new ArrayList<POIGral>(), nombre1, session);
			} else {
				resultados = obtenerBusquedas(resultadosAnteriores, nombre1, session);
			}

			viewModel.put("resultados", resultados);
		} else {
			String key = request.queryParams("value_key");
			//elimina el poi
			if (key != null) {
				POIGral poi = QuerysPois.buscarPOI(session, key);
				session.beginTransaction();
				session.delete(poi);
				session.getTransaction().commit();
			} 
		}
		return new ModelAndView(viewModel, "borrarPOI.html");
	}

	public List<POIGral> getResultadosAnteriores() {
		return resultadosAnteriores;
	}

	public void setResultadosAnteriores(List<POIGral> resultadosAnteriores) {
		this.resultadosAnteriores = resultadosAnteriores;
	}

	private List<ResultadoBusqueda> obtenerBusquedas(List<POIGral> listaPois, String nombre1, Session session) {
		List<String> claves = new ArrayList<String>();
		claves.add(nombre1);
		List<POIGral> poisEncontrados = new ArrayList<POIGral>();
		poisEncontrados = this.buscarEnVariosLados(session, claves);
		if (!listaPois.isEmpty()) {
			poisEncontrados.retainAll(listaPois);
		}
		List<ResultadoBusqueda> resultados = new ArrayList<ResultadoBusqueda>();
		for (POIGral poi : poisEncontrados) {
			String[] info = poi.mostrarInformacion();
			ResultadoBusqueda resultado = new ResultadoBusqueda(info[0], info[1], poi.get_id_vista());
			resultados.add(resultado);
		}
		this.resultadosAnteriores.clear();
		this.resultadosAnteriores.addAll(poisEncontrados);
		return resultados;
	}

	@SuppressWarnings("unchecked")
	private List<POIGral> buscarEnVariosLados(Session session, List<String> claves) {
		// busca en BDD de pois
		List<POIGral> busquedas = new ArrayList<POIGral>();
		List<POI> poisSistema = QuerysPois.realizarBusqueda(session, claves);
		busquedas.addAll(poisSistema);
		// busca bancos JSON
		Mapa mapa = new Mapa();
		ConsultarPOI consulta = new ConsultarPOI();
		consulta.setClaves(claves);
		busquedas.addAll((List<POIGral>) mapa.realizarFuncConPoi(consulta, null));
		// busca CGP DAOs
		return busquedas;
	}
}
