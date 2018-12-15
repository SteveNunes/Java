import java.util.Scanner;
import java.util.Calendar;

public class Exemplos {  

    /**
     *   System.currentTimeMillis() - retorna o horario atual (em milisegundos) (Equialente ao clock() do C++)
     *   Math.pow(numero) - Retorna o Exponencial do numero (2^8 q eh igual a 2*2*2*2*2*2*2*2)
     *   Math.sqrt(numero) - Retorna a raiz quadrada do numero
     *   Math.ceil(numero) - Arredonda o numero para cima
     *   Math.floor(numero) - Arredonda o numero para baixo
     *   Math.round(numero) - Arredonda o numero para cima ou para baixo, dependendo do valor da casa decimal
     */
	 
	public static int soma(int n1, int n2) { return n1+n2; }

    public static void main(String[] args) {

        // Atalho para 'new Scanner(System.in)'
        Scanner entrada=new Scanner(System.in);
        // Atalho para 'Calendar.getInstance()'
        Calendar calendario=Calendar.getInstance();
        System.out.printf("%c%c%c%c%c%c\n",'I','n','i','c','i','o');
        System.out.printf("Float com 2 digitos apos a virgula: %.2f\n",1.234567890);
        System.out.printf("Voce eh: (1) Homem? (2) Mulher? ");
        switch (entrada.nextLine().charAt(0)) {
            case '1': case 'h': case 'H': { System.out.printf("Eu tambem ;P\n"); break; }
            case '2': case 'm': case 'M': { System.out.printf("Opa! Podemos sair para um encontro depois, quem sabe... ;)\n"); break; }
            default: { System.out.printf("Opcao invalida! Vou assumir que voce ainda nao saiu do armario! ;P\n"); break; }
        }
        System.out.print("Digite um numero...: "); int nm1=entrada.nextInt();
        System.out.print("Digite outro numero...: "); int nm2=entrada.nextInt();
        System.out.printf("E o resultado de %d + %d eh: %d\n",nm1,nm2,soma(nm1,nm2));
        System.out.print("Digite sua idade: "); int idade=entrada.nextInt();
        // char letra=entrada.nextLine().charAt(0); // Recebe 1 letra do dado digitado pelo usuario (ou letra da posicao (0) da string)
        System.out.printf("Steve %s %c%c %s\n","Nunes",'d','a',"Silva");
        System.out.print("Testando...\n"); // print eh similar ao printf, mas nao aceita variaveis ("%d%", 9)
        System.out.printf("Tenho %d anos.\n",idade);
        if (idade < 6) System.out.printf("Acho bem pouco provavel que voce saiba digitar com apenas %d anos!\n",idade);
        else if (idade < 12) System.out.printf("Voce ainda eh uma crianca!\n");
        else if (idade < 18) System.out.print("Voce eh um adolescente!\n");
        else if (idade < 30) System.out.print("Voce eh jovem!\n");
        else if (idade < 50) System.out.print("Ta comecando a ficar velho, heim!\n");
        else System.out.print("Ta na hora de se aposentar!\n");
        /** System.out.println() eh uma alternativa mais simples para exibir textos com variaveis. print() exibe
		 *	o conteudo sem quebra de linha, println() da uma quebra de linha ao final do texto.
		 */
        System.out.println("Dia "+calendario.get(Calendar.DAY_OF_MONTH)+" do mes "+calendario.get(Calendar.MONTH)+" de "+calendario.get(Calendar.YEAR)+".");
        System.out.println("Ano de nascimento: "+(calendario.get(Calendar.YEAR)-idade));
        System.out.println("Falta(m): "+(365-calendario.get(Calendar.DAY_OF_YEAR))+" dia(s) para acabar o ano.");
        // Numeros float sempre devem acompanhar um f ao final do mesmo.
        float dinheiro=1.99f; System.out.println("So tenho R$"+dinheiro+" na minha carteira...");
        // (condicao)?valor1:valor2 (retorna o valor1 se a condicao for verdadeira, caso contrario retorna o valor2)
        // Alguns tipos de lacos que imprimem o caractere - ateh que o valor de 'a' seja 60 e entao imprime uma quebra de linha.
        int a=1; while (true) { System.out.printf("%c",(a < 60)?'-':'\n'); a++; if (a == 61) break; }
        a=1; while (a <= 60) { System.out.printf("%c",(a < 60)?'-':'\n'); a++; }
        a=0; while (++a <= 60) System.out.printf("%c",(a < 60)?'-':'\n');
        for (a=1;a<=60;a++) System.out.printf("%c",(a < 60)?'-':'\n');
        // Esse laco executa o codigo no minimo 1 vez, mesmo que a condicao do while seja falsa
        a=1; do System.out.printf("%c",(a < 60)?'-':'\n'); while (++a<=60);
        // O comando 'continue' passa para a proxima etapa do laco sem executar os comandos abaixo
        for (a=1;a<=60;a++) { if (a%2 != 0) continue; System.out.printf("%d ",a); }
        System.out.print("\nDigite um numero tipo float: "); float floatNum=entrada.nextFloat();
        System.out.println("Seu numero: " + floatNum);

    }  
 }