package JogoDaForca;

public class Palavras {

  private static Util util=new Util();

  /**
   *
   * Lista de palavras, onde o primeiro indice refere-se ao tema atual
   */
  private String lista[][]= {{"Palavras reservadas do Java","byte","short","char","int","long","float","double","const","void","boolean","abstract","else","goto","return","this","while","assert",
    "class","enum","if","native","throw","extends","implements","new","static","throws","break","for","continue","final","import","package","strictfp","transient","default","finally","instanceof",
    "private","super","try","case","do","protected","switch","catch","interface","public","synchronized","volatile"},{"Cereais, frutas, verduras e legumes","morango","banana","goiaba","abacate",
      "manga","pera","uva","kiwi","cereja","maracuja","laranja","tangerina","abacaxi","amora","caqui","melancia","pessego","lima","alface","couve","beterraba","cenoura","repolho","milho","ervilha",
      "pepino","azeitona","vagem","chuchu","abobora","brocolis","alecrim","pimenta","tomate","cebola","alho","abobrinha","alcega","alcachofra","rabanete","aipim","batata","carambola","trigo","arroz",
      "feijao","amendoim","rucula","beringela","graviola"}};

  public String[] listaDePalavras(int nivelAtual) {
    String m[]=lista[nivelAtual-1];
    m[0]=m[m.length-1];
    m[m.length-1]="";
    return m;
  }

  /**
   *
   * Retorna o total de temas disponiveis
   */
  public int totalDeTemas() {
    return lista.length;
  }

  /**
   *
   * Retorna o total de palavras disponiveis no tema do nivelAtual
   */
  public int totalDePalavras(int nivelAtual) {
    return lista[nivelAtual-1].length-1;
  }

  /**
   *
   * Retorna o tema do nivelAtual, caso disponivel. Do caso contrario, retorna "Indisponivel"
   */
  public String getTemaAtual(int nivelAtual) {
    return nivelAtual>0&&nivelAtual<=totalDeTemas()?lista[nivelAtual-1][0]:"Indisponivel";
  }

  /**
   *
   * Retorna uma palavra aleatoria dentre as palavras disponiveis no tema do nivelAtual
   */
  public String getAleatoria(int nivelAtual) {
    return lista[nivelAtual-1][util.rnd(1,totalDePalavras(nivelAtual)-1)];
  }

  /**
   *
   * Returna 'true' se a palavra informada estiver na lista de palavras do nivel atual
   */
  public boolean estaNaLista(int nivelAtual,String palavra) {
    for (String i : lista[nivelAtual-1]) {
      if (!i.equals(getTemaAtual(nivelAtual))&&i.toLowerCase().equals(palavra.toLowerCase())) return true;
    }
    return false;
  }

}
