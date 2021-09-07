package meupacote;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import param.temperature.Celsius;
import param.temperature.TempException;

public class MyCelsiusTest {
	
	private MyCelsius myCelsius;
	private MyCelsius otherCelsius;
	private Celsius fakeCelsius;
	private static double ZERO_ABSOLUTO = -273;
	
	@Before
	public void setUp() throws TempException {
		myCelsius = new MyCelsius();
		myCelsius.setValue(33d);
		
		otherCelsius = new MyCelsius();
		otherCelsius.setValue(33d);
		
		fakeCelsius = new Celsius();
		fakeCelsius.setValue(25d);		
	}
	
	@Test
	public void deveRetornarOZeroAbsoluto() {
		assertEquals(-273d, myCelsius.getZEROABSOLUTO(), 0);
	}
	
	@Test
	public void deveRetornarATemperaturaDeCongelar() {
		assertEquals(0d, myCelsius.getFREEZE(), 0);
	}
	
	@Test
	public void deveRetornarATemperaturaDeFerver() {
		assertEquals(100d, myCelsius.getBOIL(), 0);
	}
	
	@Test
	public void deveRetornarAAssinaturaDaTemperatura() {
		assertEquals("33.0 C", myCelsius.toString());
	}
	
	@Test
	public void deveRetornarTrueParaDoisObjetosComAmesmaTemperatura() {
		assertTrue(myCelsius.equals(otherCelsius));
	}
	
	@Test(expected = TempException.class)
	public void deveLancarTempExceptionPorTemperaturaMenosQueZeroAbsoluto() 
														throws TempException {
		myCelsius.setValue(-300d);
	}
	
	@Test
	public void deveFalharPoisSaoObjetosCelsiusDiferentesETemperaturasDiferentes() 
														throws TempException {
		otherCelsius.setValue(15d);
		assertFalse(myCelsius.equals(otherCelsius));
	}
	
	@Test
	public void deveFalharPoisSaoObjetosCelsiusDiferentesETemperaturasIguais() 
														throws TempException {
		fakeCelsius.setValue(33d);
		assertFalse(myCelsius.equals(fakeCelsius));
	}
	

}
