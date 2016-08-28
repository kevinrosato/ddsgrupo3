package dds.grupo3.Control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import dds.grupo3.Interfaces.AdministradorPOIs;
import dds.grupo3.Interfaces.POIGral;
import dds.grupo3.User.ConsultarPOI;
import dds.grupo3.User.Usuario;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class ControllerBusqueda {

	private static String terminalID="0";
	
	public static ModelAndView show( Request request, Response response,Usuario usuario,List<POIGral> resultadosAnteriores) {
	
		HashMap<String, Object> viewModel = new HashMap<>();
		if(!request.queryParams().isEmpty()){
			String nombre1=request.queryParams("nombre1");
			String nombre2=request.queryParams("nombre2");
			String[] agregar=request.queryParamsValues("agregar");
			if((agregar==null) || (resultadosAnteriores.isEmpty())){
				//Hizo click en buscar->los resultados anteriores en realidad es todo el mapa
				//Hizo click en agregar pero no hay resulados anteriores
				resultadosAnteriores=usuario.getMapa().getListaPois();
			}
			List<ResultadoBusqueda> resultados=new ArrayList<ResultadoBusqueda>();
			resultados=obtenerBusquedas(resultadosAnteriores,nombre1,nombre2); 
			viewModel.put("resultados", resultados);
			return new ModelAndView(viewModel,"busqueda.html");
		}
		else{
			return new ModelAndView(viewModel, "busqueda.html");
		}
	}
	
	private static List<ResultadoBusqueda> obtenerBusquedas(List<POIGral> listaPois,String nombre1,String nombre2){
		ConsultarPOI consulta=new ConsultarPOI();
		consulta.setNombre1(nombre1);
		consulta.setNombre2(nombre2);
		List<POIGral> poisEncontrados=new ArrayList<POIGral>();
		poisEncontrados=(List<POIGral>) consulta.realizarFuncion(listaPois,terminalID);
		List<ResultadoBusqueda> resultados=new ArrayList<ResultadoBusqueda>();
		for(POIGral poi:poisEncontrados){
			 String[] info=poi.mostrarInformacion();
			 ResultadoBusqueda resultado=new ResultadoBusqueda(info[0],info[1]);
			 resultados.add(resultado);
		}
		listaPois.clear();
		listaPois.addAll(poisEncontrados);
		return resultados;
	}
}
