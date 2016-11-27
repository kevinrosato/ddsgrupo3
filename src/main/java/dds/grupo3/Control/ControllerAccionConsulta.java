package dds.grupo3.Control;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.hibernate.Session;

import com.google.common.io.Files;

import dds.grupo3.BaseDeDatos.QueryBusquedas;
import dds.grupo3.DTOs.Busquedas;
import dds.grupo3.Interfaces.POI;
import dds.grupo3.User.RealizarAcciones;
import dds.grupo3.User.Usuario;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class ControllerAccionConsulta {
	@SuppressWarnings("resource")
	public ModelAndView show(Request request, Response response, Usuario user, Session session) {
		HashMap<String, Object> viewModel = new HashMap<>();

		String param = request.queryParams("value_key");
		if (param != null) {
			if (param.equals("2")) {
				PrintWriter writer = null;
				try {
					writer = new PrintWriter("src/main/resources/templates/logs/log.txt", "UTF-8");
					List<Busquedas> listaHistorial = QueryBusquedas.obtenerBusquedas("", "", "", "", "", "", "",
							session);
					for (Busquedas busq : listaHistorial) {
						for (POI poi : busq.getPOIs()) {
							writer.println(busq.getFecha() + " Terminal:" + busq.getTerminal() + " Parametro:"
									+ busq.getParametro() + " Retardo:" + busq.getRetardo().toString() + " Respuestas:"
									+ busq.getCantRespuestas().toString() + " " + poi.getNombre() + "\n");
						}
					}
					writer.flush();
				} catch (IOException e) {
					// do something
				} finally {
					writer.close();
				}
				viewModel.put("log", "Descargar Log");
			}
		}

		// System.out.println(request.session().attribute("log"));
				// System.out.println(request.session().attribute("totalFecha"));
				// System.out.println(request.session().attribute("totalUsuario"));
				/*
				 * if (request.queryParams().isEmpty()) return new
				 * ModelAndView(viewModel, "acciones.html"); String log =
				 * request.queryParams("log"); if (log == null) log = ""; String
				 * totalFecha = request.queryParams("totalFecha"); if (totalFecha ==
				 * null) totalFecha = ""; String totalUsuario =
				 * request.queryParams("totalUsuario"); if (totalUsuario == null)
				 * totalUsuario = ""; RealizarAcciones a = (RealizarAcciones)
				 * session.get(RealizarAcciones.class, user.getUsername());
				 * 
				 * request.session().attribute("log", "false"); a.setLogeo("N");
				 * request.session().attribute("totalFecha", "false");
				 * a.setTotal_fecha("N"); request.session().attribute("totalUsuario",
				 * "false"); a.setTotal_usuario("N"); if (log.contains("2")) {
				 * request.session().attribute("log", "true"); a.setLogeo("Y"); } if
				 * (totalFecha.contains("true")) {
				 * request.session().attribute("totalFecha", "true");
				 * a.setTotal_fecha("Y"); }
				 * 
				 * if (totalUsuario.contains("true")) {
				 * request.session().attribute("totalUsuario", "true");
				 * a.setTotal_usuario("Y"); }
				 */
				/*
				 * session.beginTransaction(); session.saveOrUpdate(a);
				 * session.getTransaction().commit();
				 */
		
		return new ModelAndView(viewModel, "acciones.html");
	}
}
