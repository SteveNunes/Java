package JogoDaForca;

public class JogoDaForca {
	
	public static Jogo jogo = new Jogo();
	public static Palavras palavras = new Palavras();
	public static Jogador jogador = new Jogador();
	public static Util util = new Util();
	
	public static void main(String[] args) {
		util.imprimirTexto(jogo.apresentacao());
		jogador.setNome(util.definirNome("Digite seu nome: ", 15));
		do {
			iniciarJogo();
			jogador.resetar();
		} while (util.pergunta("Deseja continuar jogando? (s|n)", 's'));
		util.imprimirTexto("\nObrigado por jogar, " + jogador.getNome() + " e ate a proxima!\n");
	}
	
	public static void iniciarJogo() {
		util.imprimirTexto("\nIniciando jogo!\n\n");
		jogo.setNivelAtual(1);
		while (!palavras.getTemaAtual(jogo.getNivelAtual()).equals("Indisponivel") && jogador.getVidas() > 0) {
			jogo.gerarPalavra();
			rodadaAtual();
			fimDeRodada();
		}
		fimDeJogo();
	}
	
	public static void rodadaAtual() {
		char letra;
		int encontradas, pontosObtidos;
		while (jogador.getVidas() > 0 && !jogo.palavraFoiRevelada()) {
			util.imprimirTexto("Tema atual: " + palavras.getTemaAtual(jogo.getNivelAtual())
				+ "\nPalavra atual eh: " + jogo.getPalavraOculta() 
				+ "\nVoce tem " + util.plural("vida", jogador.getVidas()));
			util.imprimirTexto("\nPontuacao atual: " + util.plural("ponto",jogador.getPontos()) + ".");
			util.imprimirTexto("\n\n");
			letra = util.getLetra(true, jogador.getNome() + " por favor informe uma letra: ");
			if (jogo.letraJaUtilizada(letra)) 
				util.imprimirTexto("A letra " + letra + " ja foi utilizada! Tente outra letra!");
			else {
				encontradas = jogo.checarLetra(letra);
				if (encontradas > 0) {
					pontosObtidos = encontradas * jogador.getCombo();
					jogador.incrementarPontos(pontosObtidos);
					jogador.incrementarCombo();
					util.imprimirTexto("A letra '" + letra + "' esta presente na palavra oculta!\n"
						+ "Voce ganhou +" + util.plural("ponto",pontosObtidos) + "");
				} else {
					util.imprimirTexto("A letra '" + letra + "' nao esta presente na palavra oculta!\n");
					jogador.decrementarVida();
					jogador.setCombo(1);
					util.imprimirTexto("Voce perdeu uma vida!");
				}
			}
			util.imprimirTexto("\n\n");
		}
	}
	
	public static void fimDeRodada() {
		if (jogo.palavraFoiRevelada()) {
			int pontosObtidos = jogo.getTamanhoDaPalavraAtual();
			jogador.incrementarPontos(pontosObtidos);
			jogo.incrementarNivelAtual();
			util.imprimirTexto("Parabens, " + jogador.getNome() + "! Voce descobriu a palavra oculta!\n"
				+ "Com isso, voce recebe um bonus de " + pontosObtidos + " pontos!\n");
			if (!palavras.getTemaAtual(jogo.getNivelAtual()).equals("Indisponivel")) 
				util.imprimirTexto("Vamos para o proximo level!");
			util.imprimirTexto("\n\n");
		}
	}
	
	public static void fimDeJogo() {
		if (jogador.getVidas() == 0)
			util.imprimirTexto("Fim de jogo, pois voce ficou sem vidas!\n"
					+ "A palavra atual era: " + jogo.getPalavraAtual() + "");
		else if (palavras.getTemaAtual(jogo.getNivelAtual()).equals("Indisponivel")) 
			util.imprimirTexto("Fim de jogo, pois nao temos mais niveis disponiveis!");
		util.imprimirTexto("\n\nPontuacao final: " + util.plural("ponto",jogador.getPontos()) + ".\n\n");
	}
	
}
