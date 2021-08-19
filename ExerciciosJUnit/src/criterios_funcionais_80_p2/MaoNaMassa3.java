package criterios_funcionais_80_p2;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({MaoNaMassa3.TestParameterizedWithException.class, 
			   MaoNaMassa3.TestParameterizedWithoutException.class})
public class MaoNaMassa3 {

	/**
	 * a) Defina casos de testes baseado no critério Analise do Valor Limite para o
	 * método abaixo.
	 * 
	 * Teremos nosso delta de +1 e -1. Assim pegamos um valor limite, 
	 * e aplicamos o delta somando e diminuindo. Sendo assim teremos os casos:
	 * 
	 * tipoJogo = {-1, 0, 1, 2, 3, 4}
	 * valor associado a JOGO_TABULEIRO = {-1, 199, 200, 201}
	 * valor associado a JOGO_STREAM = {-1}
	 * valor associado a JOGO_DVD = {-1, 99, 100, 101}
	 * 
	 * Assim temos:
	 * 
	 * valor = {-1, 99, 100, 101, 199, 200, 201}
	 * 
	 * b) Crie uma classe de testes parametrizados 
	 * para estes casos de teste que atendem ao critério.
	 * 
	 * Parâmetros = {{1,-1d, ArgumentoInvalidoException},
	 * 				 {1,199d},	
	 * 				 {1,200d},
	 * 				 {1,120d},
	 * 				 {2,-1d, ArgumentoInvalidoException},
	 * 				 {2,0d},
	 * 				 {3,-1d, ArgumentoInvalidoException},
	 * 				 {3,99d,30},
	 * 				 {3,100d,30},
	 * 				 {3,101d,20},
	 * 				 {0, 0d, ArgumentoInvalidoException}
	 * 				 {0, -1d, ArgumentoInvalidoException}
	 * 				 {4, 0d, ArgumentoInvalidoException}
	 * 				 {4, -1d, ArgumentoInvalidoException}
	 * 				}
	 * 
	 * c) Agora construa testes JUnit para exercitar estas entradas. Estes 
	 * testes podem ser parametrizados ou não. Os dois tipos serão considerados.
	 */
	
	public int tipoJogo;
	public double valor;
	public double total;

	public MaoNaMassa3(int tipoJogo, double valor, double total) {
		this.tipoJogo = tipoJogo;
		this.valor = valor;
		this.total = total;
	}


	@RunWith(Parameterized.class)
	public static class TestParameterizedWithoutException extends MaoNaMassa3{
	
		public TestParameterizedWithoutException(int tipoJogo, double valor, double total) {
			super(tipoJogo, valor, total);
		}


		@Parameters
	    public static Collection<Object[]> data() {
	        return Arrays.asList(new Object[][] {     
	        	 {1,199d,229d},	
				 {1,200d,200d},
				 {1,201d,201d},
				 {2,0d,0d},
				 {2,1d,1d},
				 {3,99d,129d},
				 {3,100d,130d},
				 {3,101d,121d}                   
	        });
	    }

		
		@Test
		public void deveFuncionarNasCondicionaisMinimas() throws ArgumentoInvalidoException {
			GameSeller gameSeller = new GameSeller();
			assertEquals(super.total, gameSeller.calculaPreco(super.tipoJogo, super.valor), 0);
		}
	}
	
	
	@RunWith(Parameterized.class)
	public static class TestParameterizedWithException extends MaoNaMassa3{
		
		public Class<? extends Exception> exception; 
		
		public TestParameterizedWithException(int tipoJogo, double valor, Class<? extends Exception> exception) {
			super(tipoJogo, valor, 0);
			this.exception = exception;
		}
		
		@Parameters
	    public static Collection<Object[]> data() {
	        return Arrays.asList(new Object[][] {     
	        	 {1,-1d,ArgumentoInvalidoException.class},	
				 {2,-1d,ArgumentoInvalidoException.class},
				 {3,-1d,ArgumentoInvalidoException.class},
				 {4,-1d,ArgumentoInvalidoException.class},
				 {4, 200d,ArgumentoInvalidoException.class},
				 {0,200d,ArgumentoInvalidoException.class},
				 {0,-1d,ArgumentoInvalidoException.class}                   
	        });
	    }
		

		@Test
		public void deveLancarExceptionParaValoresNegativos() throws ArgumentoInvalidoException {
			GameSeller gameSeller = new GameSeller();
			
			try {
				gameSeller.calculaPreco(tipoJogo, valor);
			}catch(ArgumentoInvalidoException e) {
				assertEquals("Tipo de jogo invalido ou valor negativo fornecido", 
						     e.getMessage());
			}
		}
		
	}
		
}
