/**
 * Biblioteca para quebrar Strings em tokens
*/
import java.util.StringTokenizer;

public class Strings {
	public static void main(String args[]) {
			/**
			 *	Diferente de C++, no Java você tem a disponibilidade de uso de Strings
			 *	sem a necessidade de bibliotecas externas.
			 */
			
			String nome = "Steve", nome2 = "STEVE", sobrenome = " Nunes da Silva", numero = "8000";
			System.out.println("Conteudo da String = " 								+ 	nome											);
			System.out.println("Conteudo em minusculo = " 							+ 	nome.toLowerCase()								);
			System.out.println("Conteudo em manusculo = " 							+ 	nome.toUpperCase()								);
			System.out.println("Comeca com 'St'? = "	 							+ 	(nome.startsWith("St") ? "Sim" : "Nao")			);
			System.out.println("Termina com 've'? = "	 							+ 	(nome.endsWith("ve") ? "Sim" : "Nao")			);
			System.out.println("Substituir 'e' por 'i' = " 							+ 	nome.replace('e','i')							);
			System.out.println("Substituir 'eve' por 'ini' = " 						+ 	nome.replace("eve","ini")						);
			System.out.println("Total de letras = " 								+ 	nome.length()									);
			System.out.println("Primeira letra = " 									+ 	nome.charAt(0)									);
			System.out.println("Posicao da primeira letra 'e' = "					+ 	nome.indexOf('e')								);
			System.out.println("Posicao da ultima letra 'e' = "						+ 	nome.lastIndexOf('e')							);
			System.out.println("Existe letra 'w' na String? "						+ 	(nome.indexOf('w') == -1 ? "Nao" : "Sim")		);
			System.out.println("Existe letra 't' na String? "						+ 	(nome.indexOf('t') == -1 ? "Nao" : "Sim")		);
			System.out.println("Da segunda ate a quinta letra = "					+ 	nome.subSequence(1,4)							);
			System.out.println("Concatenar String nome com sobrenome: "				+ 	nome.concat(sobrenome)							);
			System.out.println("Concatenar String nome com sobrenome: "				+ 	nome+sobrenome									);
			System.out.println("Posicao da primeira letra da palavra 'da' = "		+ 	sobrenome.indexOf("da")							);
			System.out.println("String nome eh igual a String nome2? "				+ 	(nome.equals(nome2) ? "Sim" : "Nao")			);
			System.out.println("String nome eh igual a String nome2? "				+ 	(nome.equalsIgnoreCase(nome2) ? "Sim" : "Nao")	);
			System.out.println("String esta vazia? "								+ 	(nome.length() == 0 ? "Sim" : "Nao")			);
			System.out.println("String esta vazia? "								+ 	(nome.isEmpty() ? "Sim" : "Nao")				);
			int n = Integer.parseInt(numero) ;	//Converte String em int
			n = Integer.valueOf(numero);		//Alternativa de conversão de String em int
			System.out.println("Variavel int com valor obtido de uma String = "		+ 	n												);
			String n2 = "" + n;					//Converter int em String
			n2 = Integer.toString(n);			//Alternativa de conversão de int em String
			System.out.println("String com valor obtido de um int = "				+ 	n2												);
			char nome3[] = {'R','o','b','e','r','t',' ','G','a','r','c','i','a'};
			String nome4 = new String(nome3);	//Converter array de char em String
			char nome5[] = nome.toCharArray();	//Converte String em array de char
			
			/**
			 * Quebrando uma String em tokens com a biblioteca StringTokenizer
			 */
			StringTokenizer palavra = new StringTokenizer(nome + sobrenome);
			for (n = 1; palavra.hasMoreTokens(); n++)
				System.out.println("Token " + n + ": " + palavra.nextToken());
			palavra = new StringTokenizer("Testando@a@quebra@de@uma@palavra@usando@a@arroba@como@delimitador", "@");
			System.out.println("Total de tokens: " + palavra.countTokens());
			for (n = 1; palavra.hasMoreTokens(); n++)
				System.out.println("Token " + n + ": " + palavra.nextToken());
			
	}
}