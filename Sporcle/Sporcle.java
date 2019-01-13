package Sporcle;

public class Sporcle {

  public static Jogo jogo=new Jogo();
  public static Palavras palavras=new Palavras();
  public static Jogador jogador=new Jogador();
  public static Util util=new Util();

  public static void main(String[] args) {
    util.imprimirTexto(jogo.apresentacao());
    jogador.setNome(util.definirNome("Digite seu nome: ",15));
    do {
      iniciarJogo();
      jogador.resetar();
    }
    while (util.pergunta("Deseja continuar jogando? (s|n)",'s'));
    util.imprimirTexto("\nObrigado por jogar, "+jogador.getNome()+" e ate a proxima!\n");
  }

  public static void iniciarJogo() {
    util.imprimirTexto("\nIniciando jogo!\n\n");
    util.setTempoLimite(300);
    jogo.resetarJogo();
    while (util.getTempoLimite()>0&&palavras.getTemaAtual(jogo.getNivelAtual())!="Indisponivel") {
      jogo.resetarPalavrasDescobertas();
      rodadaAtual();
      fimDeRodada();
    }
    fimDeJogo();
  }

  public static void rodadaAtual() {
    int pontosObtidos;
    String palavra;
    while (util.getTempoLimite()>0&&jogo.getPalavrasRestantes()>0) {
      util.imprimirTexto("Tema atual: "+palavras.getTemaAtual(jogo.getNivelAtual())+"\nPalavras descobertas: "+jogo.getPalavrasDescobertas()+"/"+palavras.totalDePalavras(jogo.getNivelAtual())
        +"\nTotal de erros: "+jogo.getTotalDeErros()+"\nPontuacao atual: "+util.plural("ponto",jogador.getPontos())+"\nTempo restante: "+util.tempoPorExtenso(util.getTempoLimite(),4));
      util.imprimirTexto("\n\n");
      palavra=util.getTexto(true,jogador.getNome()+" por favor informe uma palavra: ");
      if (jogo.palavraJaUtilizada(palavra)) util.imprimirTexto("A palavra "+palavra+" ja foi utilizada! Tente outra palavra!");
      else {
        if (jogo.checarPalavra(palavra)) {
          pontosObtidos=palavra.length()*jogador.getCombo();
          jogador.incrementarPontos(pontosObtidos);
          jogador.incrementarCombo();
          util.imprimirTexto("A palavra '"+palavra+"' esta presente na lista de palavras!\n"+"Voce ganhou +"+util.plural("ponto",pontosObtidos)+"");
        }
        else {
          util.imprimirTexto("A palavra '"+palavra+"' nao esta presente na lista de palavras!\n");
          jogo.incrementaTotalDeErros();
          jogador.setCombo(1);
          util.decTempoLimite(20);
          util.imprimirTexto("Seu tempo foi deduzido em 20 segundos!");
        }
      }
      util.imprimirTexto("\n\n");
    }
  }

  public static void fimDeRodada() {
    if (jogo.getPalavrasRestantes()==0) {
      int pontosObtidos=100*jogo.getNivelAtual();
      jogador.incrementarPontos(pontosObtidos);
      jogo.incrementarNivelAtual();
      util.imprimirTexto("Parabens, "+jogador.getNome()+"! Voce descobriu todas as palavras!\n"+"Com isso, voce recebe um bonus de "+pontosObtidos+" pontos!\n\n");
      if (palavras.getTemaAtual(jogo.getNivelAtual())!="Indisponivel") util.imprimirTexto("Vamos para o proximo level!");
      util.imprimirTexto("\n\n");
    }
  }

  public static void fimDeJogo() {
    if (util.getTempoLimite()<=0) {
      util.imprimirTexto("Fim de jogo, pois o tempo limite terminou!\n\n"+"Lista de palavras que voce nao descobriu:\n\n");
      int quebraLinha=1;
      for (String i : palavras.listaDePalavras(jogo.getNivelAtual())) if (!jogo.palavraJaUtilizada(i)) util.imprimirTexto(i+(quebraLinha++%10==0?"\n":" "));
    }
    else if (palavras.getTemaAtual(jogo.getNivelAtual())!="Indisponivel") util.imprimirTexto("Fim de jogo, pois nao temos mais niveis disponiveis!");
    util.imprimirTexto("\n\n");
  }

}