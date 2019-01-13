package ETC;

public class Util {

  private long tempoLimite;
  private java.util.Scanner sc=new java.util.Scanner(System.in);

  /**
   *
   * Pede ao usuario que informe seu nome.
   *
   * @param prompt         - Texto que sera exibido ao pedir o nome do usuario
   * @param maximoDeLetras - Limite de letras que podera ser usado no nome
   *
   */
  public String definirNome(String prompt,int maximoDeLetras) {
    String nome;
    do {
      nome=getTexto(prompt);
      if (nome.length()>maximoDeLetras) imprimirTexto("\nO nome informado eh grande demais!\n"+"Tente outro nome, com no maximo "+maximoDeLetras+" caracteres!\n\n");
    }
    while (nome.length()>maximoDeLetras);
    return nome;
  }

  /**
   *
   * Pede ao usuario que informe uma letra,para um retorno de 'true' caso a letra informada coincida com a letra especificada no parametro 'trueChar'
   *
   * @param prompt   - Texto que sera exibido ao pedir a letra
   * @param trueChar - Letra que causara o retorno de 'true' caso o usuario a informe
   *
   */
  public boolean pergunta(String prompt,char trueChar) {
    return (getLetra(true,prompt)==trueChar)?true:false;
  }

  /**
   *
   * Pede ao usuario que informe uma palavra.
   * 
   * @param toLower setado em true, converte a palavra recebida para minusculo.
   * @param prompt  e o texto que sera exibido ao pedir a palavra.
   *
   *                As sobrecargas do metodo permitem pedir a letra, sem especificar o parametro 'toLower' e tambem pedir o numero sem especificar nada.
   */
  public String getTexto(boolean toLower,String prompt) {
    if (!prompt.equals("")) imprimirTexto(prompt);
    String m=sc.nextLine();
    return (toLower)?m.toLowerCase():m;
  }

  public String getTexto(String prompt) {
    return getTexto(false,prompt);
  }

  public String getTexto() {
    return getTexto(false,"");
  }

  /**
   *
   * Pede ao usuario que informe uma letra.
   * 
   * @param toLower setado em true, converte a letra recebida para minusculo.
   * @param prompt  e o texto que sera exibido ao pedir a letra.
   *
   *                As sobrecargas do metodo permitem pedir a letra, sem especificar o parametro 'toLower' e tambem pedir o numero sem especificar nada.
   */
  public char getLetra(boolean toLower,String prompt) {
    String m=getTexto(toLower,prompt);
    return m.charAt(0);
  }

  public char getLetra(String prompt) {
    return getLetra(false,prompt);
  }

  public char getLetra() {
    return getLetra(false,"");
  }

  /**
   *
   * Pede ao usuario que informe um numero, repetindo o loop enquanto nao receber um numero de fato.
   * 
   * @param toLower setado em true,converte a letra recebida para minusculo.
   * @param prompt  e o texto que sera exibido ao pedir a letra.
   *
   *                As sobrecargas do metodo permitem pedir o numero,sem especificar o parametro 'toLower' e tambem pedir o numero sem especificar nada.
   */

  public int getNumero(boolean toLower,String prompt) {
    String m;
    do m=getTexto(toLower,prompt);
    while (m.charAt(0)<'0'||m.charAt(0)>'9');
    return Integer.parseInt(m);
  }

  public int getNumero(String prompt) {
    return getNumero(false,prompt);
  }

  public int getNumero() {
    return getNumero(false,"");
  }

  /**
   *
   * Imprime o texto especificado no console.
   */
  public void imprimirTexto() {
    System.out.println();
  }

  public void imprimirTexto(char texto) {
    System.out.print(texto);
  }

  public void imprimirTexto(String texto) {
    System.out.print(texto);
  }

  public void imprimirTexto(long texto) {
    System.out.print(texto);
  }

  public void imprimirTexto(double texto) {
    System.out.print(texto);
  }

  /**
   *
   * Limpa a tela (enchendo de linhas sem conteudo). Para o efeito ficar melhor, inicie seu programa ja chamando esse efeito logo de cara,do caso contrario, as primeiras mensagens ficarao coladas no
   * tpo da tela, mas a partir do primeiro cls(), as msgs ficarao coladas na parte inferior
   */
  void cls() {
    for (int n=0; n<50; n++) System.out.println();
  }

  /**
   *
   * Retorna um numero aleatorio entre min e max
   */
  public int rnd(int min,int max) {
    return (int) Math.round((min-1)+Math.random()*(max-min))+1;
  }

  /**
   *
   * Especifique uma palavra no singular e um valor inteiro e sera retornado esse valor, seguido da palavra no singular ou no plural, deoendendo do valor passado.
   *
   * Exemplos:
   *
   * plural("ponto",2) retorna "2 pontos". plural("vida",1) retorna "1 vida".
   */
  public String plural(String palavra,int valor) {
    return ""+valor+" "+palavra+(valor==0||valor>1?"s":"");
  }

  /**
   *
   * Metodos para calculo de tempo limite:
   *
   * setTempoLimite(int segundos) define o tempo limite
   *
   * getTempoLimite() retorna o tempo limite atual
   *
   * decTempoLimite(int segundos) decrementa o tempo restante no total de segundos especificados.
   *
   * tempoPorExtenso(int tempo,int formato) Retorna o valor de tempo por extenso,nos formatos: 1 - Retorna o valor real em segundos 2 - Retorna no formato MM:SS 3 - Retorna no formato HH:MM:SS 4 - Por
   * extenso (12 horas,24 minutos e 45 segundos)
   */

  public void setTempoLimite(int segundos) {
    tempoLimite=System.currentTimeMillis()+1000*segundos;
  }

  public void decTempoLimite(int segundos) {
    tempoLimite-=segundos*1000;
  }

  public void incTempoLimite(int segundos) {
    tempoLimite+=segundos*1000;
  }

  public int getTempoLimite() {
    return (int) ((tempoLimite-System.currentTimeMillis())/1000);
  }

  public String tempoPorExtenso(int tempo,int formato) {
    int hora=0,min=0,sec=0;
    if (formato>4||formato<1) formato=4;
    if (formato>=3) {
      hora=(int) (tempo/3600);
      tempo%=3600;
    }
    min=tempo/60;
    sec=formato>1?tempo%60:tempo;
    if (formato==4) return (hora>0?(plural("hora",hora)+(min>0&&sec>0?",":min>0||sec>0?" e ":"")):"")+(min>0?plural("minuto",min)+(sec>0?" e ":""):"")+(sec>0?plural("segundo",sec):"");
    else return (formato==3?((hora<10?"0":"")+hora+":"):"")+(formato>=2?((min<10?"0":"")+min+":"):"")+(sec<10?"0":"")+sec;
  }

  /**
   * Codifica/descodifica usando a cifra de vigenere
   * 
   * @param codigo - Codigo em vigenere a descodificar ou palavra a codificar para vigenere
   * @param chave  - Palavra chave para a codificacao/descodificacao
   * @param funcao - 0 para codificar,1 para descodificar
   */
  public String vigenere(String codigo,String chave,int funcao) {
    codigo=codigo.toUpperCase().replace(" ","");
    chave=chave.toUpperCase().replace(" ","");
    int codigoTam=codigo.length();
    while (chave.length()<codigoTam) chave+=chave;
    String resultado="";
    for (int n=0, pos; n<codigoTam; n++) {
      if (funcao==0) pos=(codigo.charAt(n)-'A')+(chave.charAt(n)-'A');
      else pos=(codigo.charAt(n)-'A')-(chave.charAt(n)-'A');
      if (pos>25) pos-=26;
      if (pos<0) pos+=26;
      resultado+=(char) ('A'+pos);
    }
    return resultado;
  }

}
