package ddsgrupo3;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestsEntrega0B {
	
	//----------
	//Parametros Iniciales
	//----------
	POI poi, poi2;
	ParadaColectivo parada;
	Local local;
	CGP cgp;
	SucursalBanco sucursal;
	@Before
	public void init(){
		poi = new POI();
		poi.setLatitud(40.12);
		poi.setLongitud(42.13);
		poi.setNombre("POI de prueba");
		poi.setCalle("Avenida Rivadavia");
		poi.setAltura(1456);
		poi2= new POI();
		poi2.setLatitud(40.9);
		poi2.setLongitud(42.12);
		parada= new ParadaColectivo();
		local= new Local();
		cgp = new CGP();
		sucursal= new SucursalBanco ();
		parada = new ParadaColectivo();
	}
	
	
	//----------------
	//Tests de Getters
	//----------------
	@Test //Test de latitud
	public void tieneLatitud() {
		Assert.assertEquals(40.12,poi.getLatitud(),0);
	}
	@Test //Test de longitud
	public void tieneLongitud() {
		Assert.assertEquals(42.13,poi.getLongitud(),0);
	}
	@Test //Test de nombre
	public void pruebaNombre() {
		Assert.assertEquals("POI de prueba",poi.getNombre());
	} 
	@Test //Test de calle
	public void pruebaCalle() {
		Assert.assertEquals("Avenida Rivadavia",poi.getCalle());
	}
	@Test //Test de altura
	public void pruebaAltura() {
		Assert.assertEquals(1456,poi.getAltura(),0);
	}
	
	//----------------
	//Tests de Metodos
	//----------------
	@Test //Test de validez
	public void pruebaValidez() {
		Assert.assertTrue(poi.esValido());
	}
	@Test //Test de un POI invalido
	public void pruebaValidez2() {
		Assert.assertFalse(poi2.esValido());
	}
	@Test //Test de distancia entre dos POIs los puntos probados 
		  //Los puntos deben encontrarse en 87km. Como calculamos en metros, 87000mts,
	public void pruebaDistancia() {
		Assert.assertTrue(poi.seEncuentraAMenosDe(poi2, 87000.00));
	}
	@Test //Test de tipo de una parada de colectivos
	public void probarTipoColectivo(){
		poi.setTipoPOI(parada);
		Assert.assertEquals("Parada De Colectivos",poi.tipoPOI.conocerTipo());
	}
	@Test //Test de tipo de un CGP
	public void probarTipoCGP(){
		poi.setTipoPOI(cgp);
		Assert.assertEquals("Centro De Gestión y Participación",poi.tipoPOI.conocerTipo());
	}
	@Test //Test de tipo de una sucursal
	public void probarTipoSucursal(){
		poi.setTipoPOI(sucursal);
		Assert.assertEquals("Sucursal De Banco",poi.tipoPOI.conocerTipo());
	}
	@Test //Test de tipo de un local comercial
	public void probarTipoLocal(){
		poi.setTipoPOI(local);
		Assert.assertEquals("Local Comercial",poi.tipoPOI.conocerTipo());
	}
	
}
