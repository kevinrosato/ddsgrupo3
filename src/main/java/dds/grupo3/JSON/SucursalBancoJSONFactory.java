package dds.grupo3.JSON;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import com.sun.jersey.api.client.ClientResponse;

import dds.grupo3.Interfaces.POIGral;
 

public class SucursalBancoJSONFactory { //Genera objetos del tipo SucursalBancoJSON conectandose a la URL
										//Luegos los agrega a la lista de tipo POIGral
	public List<POIGral> generarPoi() {
			List<POIGral> listaPois = new ArrayList<POIGral>();
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
