package dds.grupo3.Control;

import java.util.HashMap;
import java.util.List;

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
	public ModelAndView show( Request request, Response response,List<BusquedaDTO> dtos) {
	
		HashMap<String, Object> viewModel = new HashMap<>();
		if(!request.queryParams().isEmpty()){
			String username=request.queryParams("paramU");
			String fechaI=request.queryParams("ParamF1");
			String fechaF=request.queryParams("ParamF2");

			listaHistorial = obtenerBusquedas(username,fechaI,fechaF); 
			viewModel.put("resultados", listaHistorial);
			return new ModelAndView(viewModel,"historialBusquedas.html");
		}
		else{
			return new ModelAndView(viewModel, "historialBusquedas.html");
		}
	}
	private List<BusquedaDTO> obtenerBusquedas(String username,String nombre1,String nombre2){
		String parametro1 = new String();
		String parametro2 = new String();
		String parametro3 = new String();
		String where = new String();
		where = "";
		if (username!=null)
		{		where=" WHERE ";	parametro1 = " Terminal='"+username+"'";}
		if (nombre1!=null)
		{		where=" WHERE ";	parametro2 = " FechaD<='"+nombre1+"'";}
		if (nombre2!=null)
		{		where=" WHERE ";	parametro3 = " FechaD>='"+nombre2+"'";}
		
		if(username!=null)
		{
			if(nombre1!=null || nombre2!=null)
			{
				parametro1.concat(" AND ");		
			}
		}
		if(nombre1!=null)
		{
			if(nombre2!=null)
			{
				parametro2.concat(" AND ");		
			}
		}
		
		String	qry	=	"SELECT * FROM "
				+((String) Factory.getString("tablaDeBusqeudas"))
				+""+where+""+parametro1+""+parametro2+""+parametro3;	
		this.setListaHistorial(BusquedasDAO.crearDTOsDe(qry));
		return this.getListaHistorial();
	}
}
