package param;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CalculoImpostoRendaTest {
	
	@Parameter(0)
	public Double valor;
	
	@Parameter(1)
	public String saida;
	
	@Parameters
	public static Object[][] entry(){
		return new Object[][] {
			{1200d, "Valor em Dinheiro: R$0.0"},
			{1201d, "Valor em Dinheiro: R$120.1"},
			{5001d, "Valor em Dinheiro: R$750.15"},
			{-1d, "Valor em Dinheiro: R$0.0"},
			{10001d, "Valor em Dinheiro: R$2000.2"}
		};
	}
	
	
	@Test
	public void calculoImpostoParametrizado() {
		assertEquals(CalculoImpostoRenda.calculaImposto(valor), saida);
	}	
}
