package dds.grupo3.Control;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Before;

import dds.grupo3.DTOs.CentroDTO;
import dds.grupo3.DTOs.DAOCentrosImplementacion;
import dds.grupo3.DTOs.HorariosServDTO;
import dds.grupo3.DTOs.ServDTO;
import dds.grupo3.Interfaces.AdministradorPOIs;
import dds.grupo3.Interfaces.CGPDAO;
import dds.grupo3.POIsSistem.CGP;
import dds.grupo3.POIsSistem.Horario;
import dds.grupo3.POIsSistem.Local;
import dds.grupo3.POIsSistem.ParadaColectivo;
import dds.grupo3.POIsSistem.Servicio;
import dds.grupo3.POIsSistem.SucursalBanco;
import dds.grupo3.POIsSistem.Ubicacion;
import dds.grupo3.User.Rol;
import dds.grupo3.UsoTerminales.Cronometrador;
import ddsgrupo3.Factory;
import ddsgrupo3.LevenshteinDistance;
import ddsgrupo3.Mapa;

public class Inicializacion {

	
	
		
	public static AdministradorPOIs init() {
		//----------
				//Parametros Iniciales
				//----------
//				Calendar 		calendario;
//				LevenshteinDistance calculador;
				AdministradorPOIs 			mapa;
				SucursalBanco 	sucursal,	sucursal2;
				Local 			local,		local2,		carrousel;
				ParadaColectivo parada,		parada2;
				CGP 			cgp, 		cgp2, 		cgp3;
				Servicio 		rubroM,		servicio1,	servicio2,	servicio3,	comercial;
//				Integer 		comunaActual;
				Ubicacion 		ubicacionActual;
				Horario 		horario,	horario1,	horario2,	horario3,	horario4,	horario5;
//				CentroDTO		cgpDTO1,	cgpDTO2,	cgpDTO3,	cgpDTO4,	cgpDTO5;
//				ServDTO			servDTO1,	servDTO2,	servDTO3,	servDTO4,	servDTO5;
//				HorariosServDTO	horServDTO1,horServDTO2,horServDTO3,horServDTO4,horServDTO5;
//				CGPDAO			cgpDAO;
//				Rol				admin, standar;
		
			mapa		= (AdministradorPOIs) Factory.getObject("AdminPOIs");
			
	//////// Seteo DTOs
			
//			cgpDTO1		= new CentroDTO();
//			cgpDTO1.setDomicilioCompleto("Casares 1234");
//			cgpDTO1.setNombreDirector("Oliver Queen");
//			cgpDTO1.setNumComuna(1);
//			cgpDTO1.setZonasIncluidas("Belgrano, Caballito, Zamora");
//				List<ServDTO> servicios = new ArrayList<>();
//				servDTO1	= new ServDTO();
//				servDTO1.setNombreServ("Asesoramiento Contable");
//				List<HorariosServDTO> horarios = new ArrayList<>();
//					horServDTO1	= new HorariosServDTO();
//					horServDTO1.setDia(1);
//					horServDTO1.setHoraInicio(7);
//					horServDTO1.setMinInicio(0);
//					horServDTO1.setHoraFin(15);
//					horServDTO1.setMinFin(30);
//					horarios.add(horServDTO1);
//					horServDTO2	= new HorariosServDTO();
//					horServDTO2.setDia(2);
//					horServDTO2.setHoraInicio(7);
//					horServDTO2.setMinInicio(0);
//					horServDTO2.setHoraFin(15);
//					horServDTO2.setMinFin(30);
//					horarios.add(horServDTO2);
//					horServDTO3	= new HorariosServDTO();
//					horServDTO3.setDia(3);
//					horServDTO3.setHoraInicio(11);
//					horServDTO3.setMinInicio(30);
//					horServDTO3.setHoraFin(18);
//					horServDTO3.setMinFin(30);
//					horarios.add(horServDTO3);
//					horServDTO4	= new HorariosServDTO();
//					horServDTO4.setDia(4);
//					horServDTO4.setHoraInicio(7);
//					horServDTO4.setMinInicio(0);
//					horServDTO4.setHoraFin(15);
//					horServDTO4.setMinFin(30);
//					horarios.add(horServDTO4);
//					horServDTO5	= new HorariosServDTO();
//					horServDTO5.setDia(5);
//					horServDTO5.setHoraInicio(7);
//					horServDTO5.setMinInicio(0);
//					horServDTO5.setHoraFin(15);
//					horServDTO5.setMinFin(30);
//					horarios.add(horServDTO5);
//				servDTO1.setHorarios(horarios);
//				servicios.add(servDTO1);
//				servDTO2	= new ServDTO();
//				servDTO2.setNombreServ("Rentas");
//				servDTO2.setHorarios(horarios);
//				servicios.add(servDTO2);
//			cgpDTO1.setServicios(servicios);
//			
//			cgpDTO2		= new CentroDTO();
//			cgpDTO2.setDomicilioCompleto("Gorriti 1234");
//			cgpDTO2.setNombreDirector("Felicity Smoak");
//			cgpDTO2.setNumComuna(5);
//			cgpDTO2.setZonasIncluidas("Medrano");
//				List<ServDTO> servicios2 = new ArrayList<>();
//				servDTO3	= new ServDTO();
//				servDTO3.setNombreServ("Inmigracion");
//				servDTO4	= new ServDTO();
//				servDTO4.setHorarios(horarios);
//				servicios2.add(servDTO3);
//				servDTO4.setNombreServ("AFIP");
//				servDTO4.setHorarios(horarios);
//				servicios2.add(servDTO4);
//			cgpDTO2.setServicios(servicios2);
//			
//			cgpDTO3		= new CentroDTO();
//			cgpDTO3.setDomicilioCompleto("Salta 1234");
//			cgpDTO3.setNombreDirector("Barry Allen");
//			cgpDTO3.setNumComuna(3);
//			cgpDTO3.setZonasIncluidas("Central City, Starling City, Metropolis");
//				List<ServDTO> servicios3 = new ArrayList<>();
//				servDTO5	= new ServDTO();
//				servDTO5.setNombreServ("Asesoramientos Varios");
//				servDTO5.setHorarios(horarios);
//				servicios3.add(servDTO5);
//				servicios3.add(servDTO1);
//			cgpDTO3.setServicios(servicios3);
//			
//			cgpDAO		= new DAOCentrosImplementacion();
//			List<CentroDTO> coleccionDTO = new ArrayList<CentroDTO>();
//			coleccionDTO.add(cgpDTO1);
//			coleccionDTO.add(cgpDTO2);
//			coleccionDTO.add(cgpDTO3);
//			cgpDAO.setCentros(coleccionDTO);
//
//			mapa.setBaseDatosCGP(cgpDAO);
//			
		
	//////////Fin Seteo DTOs		
			sucursal 	= new SucursalBanco("Galicia Microcentro");
					servicio3 = new Servicio("Transferencia");
						horario3 = new Horario();
						horario3.setDiaInicio(2);
						horario3.setDiaFinal(6);
						horario3.setHorarioInicio(1000);
						horario3.setHorarioCierre(1500);
						List<Horario> lista5 = new ArrayList<Horario>();
						lista5.add(horario3);
					servicio3.setHorario(lista5);
			sucursal.setServicio(servicio3);
			sucursal.setAltura(500);
			sucursal.setBarrio("Microcentro");
			sucursal.setCalle("Espada");
			sucursal.setCallesPerpenDer("Escudo");
			sucursal.setCallesPerpenIzq("Pe�a");
			sucursal.setCodigoPostal(2524);
			sucursal.setComuna(1);
			sucursal.setLocalidad("Microcentro");
			sucursal.setPais("Argentina");
			sucursal.setProvincia("CABA");
			sucursal.setLatitud(1.00);
			sucursal.setLongitud(1.00);
			sucursal.setServicio("Deposito");
			sucursal.setServicio("Extracciones");
			sucursal.setServicio("Prestamos");

			
			sucursal2 = new SucursalBanco("Santander Rio");
			sucursal2.setAltura(2500);
			sucursal2.setBarrio("Lugano");
			sucursal2.setCalle("Azcuenaga");
			sucursal2.setCallesPerpenDer("Perito");
			sucursal2.setCallesPerpenIzq("Moreno");
			sucursal2.setCodigoPostal(1818);
			sucursal2.setComuna(8);
			sucursal2.setLocalidad("Lugano");
			sucursal2.setPais("Argentina");
			sucursal2.setProvincia("CABA");
			sucursal2.setLatitud(1.008);
			sucursal2.setLongitud(1.003);
			sucursal2.setServicio("Deposito");
			sucursal2.setServicio("Extracciones");
			sucursal2.setServicio("Prestamos");
			
			local = new Local("Lo de Carlos");
				rubroM = new Servicio("Muebleria");
				rubroM.setRadioCercania(78.0);
			local.setRubro(rubroM);
			local.setAltura(345);
			local.setBarrio("Banfield");
			local.setCalle("Casares");
			local.setCallesPerpenDer("Espegazini");
			local.setCallesPerpenIzq("Pena");
			local.setCodigoPostal(1830);
			local.setLocalidad("Lomas de Zamora");
			local.setPais("Argentina");
			local.setProvincia("Buenos Aires");
			local.setLatitud(1.0007);
			local.setLongitud(1.00);
			
			carrousel = new Local("Carrousel");
				comercial = new Servicio("comercial");
					horario4 = new Horario();		horario4.setDiaInicio(2);	horario4.setDiaFinal(7);
					horario4.setHorarioInicio(1000);	horario4.setHorarioCierre(1300);
					horario5 = new Horario(); 		horario5.setDiaInicio(2);	horario5.setDiaFinal(7);
					horario5.setHorarioInicio(1700);	horario5.setHorarioCierre(2030);
					List<Horario> lista6 = new ArrayList<Horario>();
					lista6.add(horario4);	lista6.add(horario5);
				comercial.setHorario(lista6);
			carrousel.setRubro(comercial);
			
			parada	= new ParadaColectivo();
			parada.setLatitud(1.0008);
			parada.setLongitud(1.00);
			parada.setLocalidad("Medrano");
			parada.setPais("Argentina");
			parada.setProvincia("CABA");
			parada.setBarrio("Medrano");
			parada.setCalle("Cordoba");
			parada.setCallesPerpenIzq("Medrano");
			parada.setCallesPerpenDer("Figueroa");
			String[] lista = {"151","106","99"};
			parada.setLineas(lista);
			
			parada2	= new ParadaColectivo();
			parada2.setLatitud(1.0008);
			parada2.setLongitud(1.00);
			parada2.setPais("Aregentina");
			parada2.setProvincia("CABA");
			parada2.setBarrio("Caballito");
			parada2.setCalle("Arenal");
			parada2.setCallesPerpenIzq("Freire");
			parada2.setCallesPerpenDer("Conde");
			String[] lista2={"60","120","151"};
			parada2.setLineas(lista2);
			
			cgp	= new CGP("Sede Medrano",(byte) 5);
				servicio1 = new Servicio("Asesoramiento Contable");
					horario2 = new Horario(); 	horario2.setDiaInicio(7);	horario2.setDiaFinal(7);
					horario2.setHorarioInicio(1100);	horario2.setHorarioCierre(1200);
					List<Horario> lista3 = new ArrayList<Horario>();
					lista3.add(horario2);
				servicio1.setHorario(lista3);
				servicio2 = new Servicio("Rentas");
					horario1 = new Horario();		horario1.setDiaInicio(2);	horario1.setDiaFinal(6);
					horario1.setHorarioInicio(1000);	horario1.setHorarioCierre(1500);
					List<Horario> lista4 = new ArrayList<Horario>();
					lista4.add(horario1);
				servicio2.setHorario(lista4);
			cgp.setServicio(servicio1);
			cgp.setServicio(servicio2);
			cgp.setComuna(5);
			cgp.setAltura(123);
			cgp.setBarrio("Avellaneda");
			cgp.setCalle("San Martin");
			cgp.setCallesPerpenDer("Salta");
			cgp.setCallesPerpenIzq("Jujuy");
			cgp.setCodigoPostal(1645);
			cgp.setComuna(5);
			cgp.setLocalidad("Palermo");
			cgp.setPais("Argentina");
			cgp.setProvincia("CABA");

			cgp2 = new CGP("Sede Caballito",(byte) 6);
				servicio3 = new Servicio("Asesoramiento Legal");
			cgp2.setServicio(servicio3);
			cgp2.setAltura(1234);
			cgp2.setBarrio("Azul");
			cgp2.setCalle("Alemania");
			cgp2.setCallesPerpenDer("Espada");
			cgp2.setCallesPerpenIzq("Pared");
			cgp2.setCodigoPostal(2524);
			cgp2.setComuna(1);
			cgp2.setLocalidad("Caballito");
			cgp2.setPais("Argentina");
			cgp2.setProvincia("CABA");
			
			cgp3 = new CGP("Sede Microcentro",(byte) 8);
			cgp3.setAltura(432);
			cgp3.setBarrio("Zamore");
			cgp3.setCalle("Cielo");
			cgp3.setCallesPerpenDer("Espa�a");
			cgp3.setCallesPerpenIzq("Boedo");
			cgp3.setCodigoPostal(3524);
			cgp3.setComuna(4);
			cgp3.setLocalidad("Microcentro");
			cgp3.setPais("Argentina");
			cgp3.setProvincia("CABA");
			
			ubicacionActual = new Ubicacion(1.00, 1.00);
			ubicacionActual.setComuna(5);
//			
//			calendario = Calendar.getInstance();
//			calendario.set(2016,5,19); 
//			calendario.set(Calendar.DAY_OF_WEEK, 3);
//			calendario.set(Calendar.HOUR_OF_DAY, 19);
//			calendario.set(Calendar.MINUTE, 59);

			horario = new Horario();
			horario.setDiaInicio(3);
			horario.setDiaFinal(3);
			horario.setHorarioInicio(900);
			horario.setHorarioCierre(2000);
					
			mapa.setUbicacionActual(ubicacionActual);
			mapa.agregarPoi(cgp);
			mapa.agregarPoi(cgp2);
			mapa.agregarPoi(cgp3);
			mapa.agregarPoi(parada);
			mapa.agregarPoi(parada2);
			mapa.agregarPoi(local);
			mapa.agregarPoi(carrousel);
			mapa.agregarPoi(sucursal);
			mapa.agregarPoi(sucursal2);
			mapa.setHoraActual(Calendar.getInstance());
//			Integer aux = 10;
//			Cronometrador.establecerTope(aux.longValue());
			return mapa;
	}
}
