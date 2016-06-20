package dds.grupo3.POIsSistem;

import java.util.Calendar;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class SucursalBancoJSON extends POI implements POIGral {
	/*String sURL = "http://freegeoip.net/json/"; //just a string

    // Connect to the URL using java's native library
    URL url = new URL(sURL);
    HttpURLConnection request = (HttpURLConnection) url.openConnection();
    request.connect();

    // Convert to a JSON object to print data
    JsonParser jp = new JsonParser(); //from gson
    JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent())); //Convert the input stream to a json element
    JsonObject rootobj = root.getAsJsonObject(); //May be an array, may be an object. 
    zipcode = rootobj.get("zip_code").getAsString(); //just grab the zipcode*/
	@Override
	public Boolean estaDisponible(Calendar horario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void mostrarInformacion() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String conocerTipo() {
		// TODO Auto-generated method stub
		return null;
	}
		
}
