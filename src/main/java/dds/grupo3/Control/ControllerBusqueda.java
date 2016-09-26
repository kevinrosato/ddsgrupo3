package dds.grupo3.Control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import dds.grupo3.BaseDeDatos.QuerysPois;
import dds.grupo3.Interfaces.POI;
import dds.grupo3.UsoTerminales.BusquedasHAO;
import dds.grupo3.UsoTerminales.Cronometrador;
import ddsgrupo3.Factory;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import org.hibernate.Session;

public class ControllerBusqueda {

	private static String terminalID= (String) Factory.getString("IDterminal");
	private List<POI> resultadosAnteriores=new ArrayList<POI>();
	
	public ModelAndView show( Request request, Response response,Session session) {
	
		HashMap<String, Object> viewModel = new HashMap<>();
		if(!request.queryParams().isEmpty()){
			String nombre1=request.queryParams("nombre1");
			String nombre2=request.queryParams("nombre2");
			String[] agregar=request.queryParamsValues("agregar");
			List<ResultadoBusqueda> resultados=new ArrayList<ResultadoBusqueda>();
			if((agregar==null) || (resultadosAnteriores.isEmpty())){
				//Hizo click en buscar->los resultados anteriores en realidad es todo el mapa
				//Hizo click en agregar pero no hay resulados anteriores
				resultados=obtenerBusquedas(new ArrayList<POI>(),nombre1,nombre2,session); 
			}
			else{
				resultados=obtenerBusquedas(resultadosAnteriores,nombre1,nombre2,session); 
			}
			viewModel.put("resultados", resultados);
			return new ModelAndView(viewModel,"busqueda.html");
		}
		else{
			return new ModelAndView(viewModel, "busqueda.html");
		}
	}
	
	public List<POI> getResultadosAnteriores() {
		return resultadosAnteriores;
	}

	public void setResultadosAnteriores(List<POI> resultadosAnteriores) {
		this.resultadosAnteriores = resultadosAnteriores;
	}

	private List<ResultadoBusqueda> obtenerBusquedas(List<POI> listaPois,String nombre1,String nombre2,Session session){
		List<String> claves=new ArrayList<String>();
		claves.add(nombre1);
		claves.add(nombre2);
		List<POI> poisEncontrados=new ArrayList<POI>();
		Cronometrador.comienzo();
		poisEncontrados=QuerysPois.realizarBusqueda(session,claves);
		Long aux =	Cronometrador.finCuenta();
		Cronometrador.checkRetraso(BusquedasHAO.guardarBusqueda
				((String) terminalID, nombre1, nombre2, listaPois,aux.intValue(),session));	
		if(!listaPois.isEmpty()){
			poisEncontrados.retainAll(listaPois);
			System.out.println("lista vacía");
		}
		List<ResultadoBusqueda> resultados=new ArrayList<ResultadoBusqueda>();
		for(POI poi:poisEncontrados){
			 String[] info=poi.mostrarInformacion();
			 ResultadoBusqueda resultado=new ResultadoBusqueda(info[0],info[1],poi.getPoi_id());
			 resultados.add(resultado);
		}
		this.resultadosAnteriores.clear();
		this.resultadosAnteriores.addAll(poisEncontrados);
		return resultados;
	}
}
