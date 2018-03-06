package qma;

/**
 * Classe que representa o caixa do sistema.
 * Controla o fluxo de dinheiro do sistema.
 * 
 * @author Matheus Oliveira Pereira
 * @author Gabriel Alves Tavares
 */
public class Caixa {
	private int dinheiro;
	
	/**
	 * Construtor do objeto Caixa.
	 */
	public Caixa() {
		this.dinheiro = 0;
	}
	
	/**
	 * Método utilizado para adicionar dinheiro ao
	 * caixa.
	 * 
	 * @param quantidade a quantidade de dinheiro a ser adicionada
	 */
	public void adicionarDinheiro(int quantidade) {
		if( quantidade < 0 ) {
			throw new IllegalArgumentException("A quantidade de dinheiro depositada não pode ser negativa!");
		}
		
		this.dinheiro += quantidade;
	}
	
	/**
	 * Retorna a quantidade de dinheiro em
	 * caixa.
	 * 
	 * @return a quantidade de dinheiro em caixa
	 */
	public int getDinheiro() {
		return this.dinheiro;
	}
}
