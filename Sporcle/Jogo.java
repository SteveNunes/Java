package Sporcle;

public class Jogo {

  private static Palavras palavras=new Palavras();

  private int totalDeErros,palavrasDescobertas,nivelAtual;
  private String palavrasJaUtilizadas[]=new String[200];

  public String apresentacao() {
    return "O jogo consiste em tentar descobrir em um prazo de 5 minutos, o maior numero de\n"+"palavras de uma determinada lista. Para isso, informe as palavras que voce acha\n"
      +"que estao na lista, e se a palavra informada estiver na lista, voce pontua o total\n"+"de letras da palavra acertada, multiplicado pelo numero de acertos consecutivos.\n"
      +"Se errar, seu tempo limite eh deduzido em 20 segundos, e o valor de acertos\n"+"consecutivos eh zerado.\n\n"+"Se voce descobrir todas as palavras, ira para o proximo nivel.\n"
      +"Atualmente o jogo so possui 2 niveis de dificuldade.\n\n"+"O jogo termina quando nao houver mais niveis para avancar ou quando esgotar seu tempo limite.\n\n";
  }

  public void setNivelAtual(int nivel) {
    nivelAtual=nivel;
  }

  public int getNivelAtual() {
    return nivelAtual;
  }

  public void incrementarNivelAtual() {
    nivelAtual++;
  }

  public int getPalavrasRestantes() {
    return palavras.totalDePalavras(nivelAtual)-palavrasDescobertas;
  }

  public int getPalavrasDescobertas() {
    return palavrasDescobertas;
  }

  public int getTotalDeErros() {
    return totalDeErros;
  }

  public void setTotalDeErros(int erros) {
    totalDeErros=erros;
  }

  public void incrementaTotalDeErros() {
    totalDeErros++;
  }

  public void resetarJogo() {
    nivelAtual=1;
    totalDeErros=0;
  }

  public void resetarPalavrasDescobertas() {
    palavrasDescobertas=0;
    for (int n=0; n<200; n++) palavrasJaUtilizadas[n]="";
  }

  public boolean palavraJaUtilizada(String palavra) {
    for (String i : palavrasJaUtilizadas) if (i.toLowerCase().equals(palavra.toLowerCase())) return true;
    return false;
  }

  /**
   *
   * Verifica se a palavra informada esta presente na lista de palavras atual. Se estiver, retorna 'true'
   */
  public boolean checarPalavra(String palavra) {
    if (palavras.estaNaLista(nivelAtual,palavra)) {
      if (!palavraJaUtilizada(palavra)) palavrasJaUtilizadas[palavrasDescobertas++]=palavra;
      return true;
    }
    else return false;
  }

}