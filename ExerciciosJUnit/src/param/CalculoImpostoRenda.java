package param;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculoImpostoRenda {

	/**
	 * Este método calcula o imposto a ser pago baseado no valor de uma dada compra.
	 * 
	 * Se 1201 <= valor <= 5000 deve pagar 10% de imposto Se 5001 <= valor <= 10000
	 * deve pagar 15% de imposto Se valor > 10000 deve pagar 20% de imposto Se valor
	 * < 1201 deve pagar 0% de imposto
	 * 
	 * @param valor
	 */
	public static String calculaImposto(double valor) {
		CalculoImpostoRenda calculo = new CalculoImpostoRenda();
		return "Valor em Dinheiro: R$" + calculo.calculaPorcentagem(valor);
	}

	public double calculaPorcentagem(double valor) {
		double impostotot = 0;

		if (valor >= 1201 && valor <= 5000) {
			impostotot = 0.1;
		} else if (valor >= 5001 && valor <= 10000) {
			impostotot = 0.15;
		} else if (valor > 10000){
			impostotot = 0.2;
		}else if(valor < 0) {
			return 0;
		}
		
		BigDecimal result= new BigDecimal(Math.abs(valor * impostotot)).setScale(2, RoundingMode.HALF_EVEN);
		return Double.valueOf(result.toString());
	}

	public static void main(String[] args) {
		System.out.println(calculaImposto(200.5));
	}
}
