package Exemplos;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.junit.Test;

public class Regex {

  /**
   * Para fazer testes de expressão regular
   */
  @Test
  public void testaRegex() {
    String texto="Bola";
    Assert.assertEquals(texto.matches("B[aeiou]la"),true);
  }

  public static void main(String[] args) {

    /**
     * String contem 4 metodos especiais para uso com expressões regulares: .matches(), .split(), .replaceFirst() e .replaceAll()
     *
     */
    String texto="Steve Nunes da Silva";
    /**
     * texto.matches() - Retorna 'true' se o pattern for encontrado no texto
     *
     */
    if (texto.matches("\\w.*")) {
      /**
       * texto.split() retorna uma array de strings quebradas usando o pattern especificado como delimitador
       */
      String[] tokens=texto.split("\\s");
      System.out.println("Quebrando a string '"+texto+"' em tokens,\n"+"utilizando o espaco (Regex \\\\s) como delimitador: ");
      for (String token : tokens) System.out.println(token);
      /**
       * texto.replaceAll(pattern, novaOcorrencia) Substitui ocorrencias encontradas na string 'texto' correspondente ao pattern especificado pela 'novaOcorrencia' (No exemplo abaixo, todos os espaços
       * serão substituidos pelo caractere '_' .replaceFirst() faz o mesmo, porém apenas com a primeira ocorrência encontrada.
       */
      System.out.println("\nSubstituindo espaco por '_': "+texto.replaceAll("\\s+","_"));
      texto="Move7@15 Move45@66 Move335@89";
      /**
       * Quando se isola grupos com (), usa-se $NUMERO para obter o valor desses grupos, como demonstrado no exemplo abaixo
       */
      System.out.println("\nSubstituindo o padrao: MoveNUMERO@NUMERO"+" por: /Move\"NUMERO;NUMERO\"\nem '"+texto+"': "+texto.replaceAll("Move(\\d+)@(\\d+)","/Move\"$1;$2\""));
    }
    texto="Steve Nunes da Silva";
    /**
     * .split() retorna uma array de String de tokens recebidos de uma string, usando o pattern de regex especificado como delimitador, nesse caso, a string 'nome' é quebrada em tokens usando o espaço
     * como delimitador.
     */
    String splitString[]=texto.split("\\s+");
    texto="10 horas, 20 minutos e 33 segundos";
    /**
     * Objeto 'Pattern' registra um pattern de regex
     */
    Pattern pattern=Pattern.compile("(\\d+)");
    /**
     * Objeto 'Matcher' registra as ocorrencias encontradas em uma string que batem com o pattern registrado acima
     */
    Matcher matcher=pattern.matcher(texto);
    /**
     * .find() retorna 'true' enquanto for encontrado a ocorrencia pesquisada, uma por vez. .group() retorna a ocorrencia atual. .start() retorna a posição na string onde inicia a ocorrência
     * encontrada .end() retorna a posição na string onde termina a ocorrência encontrada
     */
    System.out.println("\nPesquisando numeros em '"+texto+"'");
    while (matcher.find()) {
      System.out.println("Numero encontrado: '"+matcher.group()+"' Posicao inicial na string: '"+matcher.start()+"' Posicao final na string: '"+matcher.end()+"'");
    }
  }
}
