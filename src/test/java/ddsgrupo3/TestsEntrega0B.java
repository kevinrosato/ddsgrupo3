package ddsgrupo3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestsEntrega0B {
	POI poi;
	
	@Before
	public void init(){
		poi = new POI();
		poi.setLatitud(150);
		
	}
	
	
	@Test
	public void tieneLatitud() {
		Assert.assertEquals(150,poi.getLatitud());
		
	}
	
	
}
