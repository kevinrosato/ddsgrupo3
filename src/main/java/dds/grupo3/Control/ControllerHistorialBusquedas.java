package dds.grupo3.Control;

import java.util.HashMap;
import java.util.List;

import org.hibernate.Session;

import dds.grupo3.Interfaces.BusquedaDTO;
import dds.grupo3.UsoTerminales.BusquedasDAO;
import ddsgrupo3.Factory;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class ControllerHistorialBusquedas {

	List<BusquedaDTO> listaHistorial;
	
	public List<BusquedaDTO> getListaHistorial() {
		return listaHistorial;
	}
	public void setListaHistorial(List<BusquedaDTO> listaHistorial) {
		this.listaHistorial = listaHistorial;
	}
	public ModelAndView show( Request request, Response response, Session session) {
		HashMap<String, Object> viewModel = new HashMap<>();
		if(!request.queryParams().isEmpty()){
			String username=request.queryParams("paramU");
			String fechaI=request.queryParams("paramF1");
			String fechaF=request.queryParams("paramF2");

			listaHistorial = obtenerBusquedas(username,fechaI,fechaF); 
			viewModel.put("resultados", listaHistorial);
			return new ModelAndView(viewModel,"historialBusquedas.html");
		}
		else{
			return new ModelAndView(viewModel, "historialBusquedas.html");
		}
	}
	private List<BusquedaDTO> obtenerBusquedas(String username,String nombre1,String nombre2){
		String parametro1 = "";
		String parametro2 = "";
		String parametro3 = "";
		String	qry	=	"SELECT * FROM	"+((String) Factory.getString("tablaDeBusqeudas"));
		String where = "";
		if (!username.isEmpty())
		{
			where=" WHERE ";
			parametro1 = "Terminal like '%"+username+"%'";
		}
		if (!nombre1.isEmpty())
		{
			where=" WHERE ";	
			parametro2 = "FechaD>='"+nombre1+"'";
		}
		if (!nombre2.isEmpty())
		{
			where=" WHERE ";
			parametro3 = "FechaD<='".concat(nombre2).concat("'");
		}
		
		if(!username.isEmpty())
		{
			if(!nombre1.isEmpty() || !nombre2.isEmpty())
			{
				parametro1.concat(" AND ");		
			}
		}
		if(!nombre1.isEmpty())
		{
			if(!nombre2.isEmpty())
			{
				parametro2.concat(" AND ");		
			}
		}
		qry	=	qry.concat(where).concat(parametro1).concat(parametro2).concat(parametro3);
		System.out.println(qry);
		this.setListaHistorial(BusquedasDAO.crearDTOsDe(qry));
		return this.getListaHistorial();
	}
}
