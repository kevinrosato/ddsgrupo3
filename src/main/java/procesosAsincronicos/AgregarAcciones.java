package procesosAsincronicos;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dds.grupo3.Interfaces.ProcesoAsincronico;


public class AgregarAcciones extends ProcesoAsincronico{
    //TODO: Nicole, pone la ejecucion en paralelo en un override del run
	//fijate la clase ProcesoAsincronico cualquier cosa avisa si no se entiende
	//en el run no pongas inputs ya que corren en paralelo, no deberia haber scanner o input del usuario
	//TODO: Ademas hace override de realizarfuncionconpoi para pedir que permisos cambiar mediante scanner
	private String permisosNuevos="";
	private Scanner scanner=new Scanner(System.in);
	private String respuesta;
	
	public AgregarAcciones(String permisosNuevos){
		this.permisosNuevos=permisosNuevos;
	}
	
	public void execute(){
		System.out.println("¿Desea deshacer los cambios?(Y/N)");
		respuesta=scanner.nextLine();
		if(respuesta.equals("N")){
			try {
				escribirArchivo();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void escribirArchivo() throws IOException{
		List<String> newLines = new ArrayList<>();
		for (String linea : Files.readAllLines(Paths.get("Rol.properties"), StandardCharsets.UTF_8)) {
			newLines.add(linea+","+permisosNuevos);
		}
		Files.write(Paths.get("Rol.properties"), newLines, StandardCharsets.UTF_8);
	}
}
