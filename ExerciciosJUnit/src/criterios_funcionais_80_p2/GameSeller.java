package criterios_funcionais_80_p2;

public class GameSeller {
	public static int JOGO_TABULEIRO = 1;
	public static int JOGO_STREAM = 2;
	public static int JOGO_DVD = 3;
	
	public static double FRETE_GRATIS = 0d;
	public static double FRETE_PAGO_TABULEIRO = 30d;
	public static double FRETE_PAGO_DVD_SEM_DESCONTO = 30d;
	public static double FRETE_PAGO_DVD_COM_DESCONTO = 20d;

	/*
	 * Este método retorna o preço calculado para um Jogo comprado na loja virtual
	 * GameSeller. Se o Jogo for de tabuleiro a cobrança do frete deve ser de 30
	 * reais em todas as compras abaixo de 200 reais, caso contrário o frete será
	 * grátis. Se o jogo for STREAM nunca será comprado frete. Se o jogo for em DVD
	 * o valor de frete será de 30 reais (para compras até 100 reais) e de 20 reais
	 * para compras superiores a 100 reais. Caso algum dos parâmetros seja invalido
	 * o método deve lançar ArgumentoInvalidoException
	 */
	
	public double calculaPreco(int tipoJogo, double valor) throws ArgumentoInvalidoException {
		validar(tipoJogo, valor);
		
		if(tipoJogo == GameSeller.JOGO_TABULEIRO) {
			if(valor < 200)
				return valor + GameSeller.FRETE_PAGO_TABULEIRO;
			else
				return valor + GameSeller.FRETE_GRATIS;
		}
		
		else if(tipoJogo == GameSeller.JOGO_STREAM) {
			return valor + GameSeller.FRETE_GRATIS;
		}
		
		else{
			if(valor <= 100) 
				return valor + GameSeller.FRETE_PAGO_DVD_SEM_DESCONTO;
			else
				return valor + GameSeller.FRETE_PAGO_DVD_COM_DESCONTO;
		}
	}
	
	private void validar(int tipoJogo, double valor) throws ArgumentoInvalidoException {
		if(isJogoInvalido(tipoJogo) || valor < 0) {
			throw new ArgumentoInvalidoException("Tipo de jogo invalido ou valor negativo fornecido");
		}
	}
	

	private boolean isJogoInvalido(int tipoJogo) {
		if(tipoJogo != GameSeller.JOGO_TABULEIRO & 
		   tipoJogo != GameSeller.JOGO_STREAM && 
		   tipoJogo != GameSeller.JOGO_DVD) {
			return true;
		}
		
		return false;
	}

}
