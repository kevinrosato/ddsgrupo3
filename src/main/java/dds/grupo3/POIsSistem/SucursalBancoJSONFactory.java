package dds.grupo3.POIsSistem;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import com.sun.jersey.api.client.ClientResponse;
 

public class SucursalBancoJSONFactory { //Genera objetos del tipo SucursalBancoJSON conectandose a la URL
										//Luegos los agrega a la lista de tipo POIGral
	public List<POI> generarPoi() {
			List<POI> listaPois = new ArrayList<POI>();
			RequestService requester;
			requester = new RequestService();
		    JsonFactory jsonFactory = new JsonFactory();
	        ClientResponse response = requester.getBookByFilter("banco","creditos");
	        JSONArray jsonArray = new JSONArray(response.getEntity(String.class));
	            for (int i = 0; i < jsonArray.length(); i++) {
	            	SucursalBancoJSON sucursalBanco= new SucursalBancoJSON();
	                sucursalBanco=jsonFactory.fromJson(jsonArray.getJSONObject(i).toString(),SucursalBancoJSON.class);
	                listaPois.add(sucursalBanco);
	            }
	            /*for(int i=0; i<listaPois.size(); i++){
	            	listaPois.get(i).mostrarInformacionAvanzada();
	            }*/ //Solo para testear
	       return listaPois;
	}
}
