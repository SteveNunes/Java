package JogoDaForca;

public class Jogo {
	
	private static Palavras palavras = new Palavras();

	private int nivelAtual;
	private String palavraAtual, palavraOculta, letrasJaUtilizadas;
	
	public Jogo() {	nivelAtual = 1; gerarPalavra(); }
	
	/**
	 *
	 * Gera uma nova palavra, baseada no nivel informado. Ao gerar a nova palavra,
	 * a string 'oculta' é redifinida com asteriscos na quantidade de letras da
	 * palavra atual, e a string 'letrasJaUtilizadas' é limpa.
	 */
	public void gerarPalavra() {
		palavraAtual = palavras.getAleatoria(nivelAtual);
		palavraOculta = "";
		letrasJaUtilizadas = "";
		for (int n = 0; n < palavraAtual.length(); n++) palavraOculta += "*";
	}

	public String apresentacao() {
		return "O jogo consiste em tentar descobrir a palavra oculta, informando uma letra\n"
		+ "para que o jogo verifique se esta letra esta presente na palavra ou nao.\n\n"
		+ "Se a letra estiver presente na palavra oculta, a letra eh revelada nas\n"
		+ "posicoes correspondentes da palavra oculta, e voce recebera pontos\n"
		+ "equivalentes a quantidade de letras encontradas, multiplicado pelo\n" 
		+ "total de acertos sequenciais.\n\n"
		+ "Se a letra nao estiver presente na palavra oculta, voce perde uma vida,\n"
		+ "e o valor de acertos sequenciais eh zerado.\n\n"
		+ "Se voce descobrir a palavra oculta, ira para o proximo nivel.\n"
		+ "Atualmente o jogo so possui 2 niveis de dificuldade.\n\n"
		+ "O jogo termina quando nao houver mais niveis de dificuldade para\n"
		+ "prosseguir ou caso o jogador perca todas as vidas.\n\n";
	}
	
	public int getNivelAtual() { return nivelAtual; }
	
	public void setNivelAtual(int nivel) { nivelAtual = nivel; }
	
	public void incrementarNivelAtual() { nivelAtual++; }
	
	public String getPalavraAtual() { return palavraAtual; }

	public String getPalavraOculta() { return palavraOculta; }
	
	public int getTamanhoDaPalavraAtual() { return palavraAtual.length(); }
	
	/**
	 * Returna 'true' se a palavra tiver sido completamente revelada (a palavraOculta não contém mais o caractere '*')
	 */
	public boolean palavraFoiRevelada() { return palavraOculta.indexOf('*') == -1 ? true : false; }

	public boolean letraJaUtilizada(char letra) 
		{ return (letrasJaUtilizadas.length() == 0 || letrasJaUtilizadas.indexOf(letra) == -1) ? false : true; }

	/**
	 *
	 * Verifica se a letra informada esta presente na palavra atual. Se estiver,
	 * atualiza a string 'palavraOculta' revelando a letra nas posicoes correspondentes.
	 * Retorna o total de vezes que a letra foi encontrada na palavra atual.
	 */
	public int checarLetra(char letra) {
		int encontradas = 0;
		letra = Character.toLowerCase(letra);
		if (!palavraFoiRevelada() && !letraJaUtilizada(letra)) {
			String m = "";
			for (int n = 0; n < getPalavraAtual().length(); n++) {
				if (letra == getPalavraAtual().charAt(n)) { 
					encontradas++; 
					m += letra; 
				} else m += palavraOculta.charAt(n);
			}
			letrasJaUtilizadas += letra;
			palavraOculta = m;
		}
		return encontradas;
	}
	
}