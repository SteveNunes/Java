public class Variaveis {
	public static void main(String args[]) {
			/**
			 *	Tipos de variaveis		Espaço ocupado na memória		Valores
			 *
			 *	byte					1 byte							-128 a 127
			 *	short					2 bytes							-32.768 a 32.767
			 *	int						4 bytes							-2.147.483.648 a 2.147.483.647
			 *	long					8 bytes							-922.337.203.685.475.808 a 922.337.203.685.475.807
			 *	float					4 bytes							1.4e-45 a 3.4e38
			 *	double					8 bytes							4.9e-324 a 1.7e308
			 *	boolean					1 byte							true ou false
			 *	char					2 bytes							1 letra ou igual a byte (-128 a 127)
			 *
			 *	Diferente do C++, para declarar uma variavel do tipo 'float', mesmo deixando explicito que é uma variavel
			 *	do tipo 'float', é preciso fazer um cast, de uma dessas duas formas:
			 */
			float n1 = 1.5f;
			float n2 = (float)1.5;
			 
			/**
			 *	Diferente do C++, você deve sempre fazer um cast ao passar um valor para uma variavel de um tipo diferente,
			 *	mesmo em casos que funcionariam perfeitamente, como por exemplo:
			 *	int c;
			 *	float d = 1.5;
			 *	double e = 2.345;
			 *	c = d; //Em C++ isso é permitido e a variavel 'c' receberia a parte inteira da variavel 'd'
			 *	c = e; //Em C++ isso é permitido e a variavel 'c' receberia a parte inteira da variavel 'e'
			 *
			 *	Como deve ser feito em Java:
			 */
			int n3;
			n3 = (int)n1; //Recebe a parte inteira da variavel 'n1'
			n3 = (int)n2; //Recebe a parte inteira da variavel 'n2'
			
			/**
			 *	Diferente do C++, um tipo 'boolean' só recebe os valores literais 'true' ou 'false', e não '0' ou '1'.
			 * Condições onde você quer verificar se uma variavel numérica é 0 ou não, não funcionarão da seguinte forma:
			 * if (variavel) //Variavel menor ou maior que 0
			 * if (!variavel) //Variavel igual a 0
			 * Esse formato serve apenas para identificar se um boolean é 'true' ou 'false'
			 */
			boolean variavel = false;
			if (variavel) System.out.println("A variavel contem 'true'");
			if (!variavel) System.out.println("A variavel contem 'false'");
			 
			/**
			 * Matriz
			 */
			int nums[]; //Matriz declarada, mas não iniciada. Causará erro de null point exception ao tentar acessar seu conteudo.
			nums = new int[10]; //Iniciando uma matriz após a declaração
			int numeros[] = new int[3]; //Declarando e iniciando uma matriz no mesmo comando
			int maisNumeros[] = {1, 2, 3, 4, 5}; //Declarando e iniciando uma matriz já com valores pre-definidos no mesmo comando
			 
			/**
			 *	Diferente do C++, uma matriz multi-dimensional pode ter tamanhos diferentes em cada dimensão.
			 */
			int n[][] = new int[4][];
			n[0] = new int[3];
			n[1] = new int[4];
			n[2] = new int[5];
			n[3] = new int[6];
			int t1[]={1, 2, 3};
			n[0] = t1;
			int t2[]={4, 5, 6, 7};
			n[1] = t2;
			int t3[]={8, 9, 10, 11, 12};
			n[2] = t3;
			int t4[]={13, 14, 15, 16, 17, 18};
			n[3] = t4;
			for (int i1[] : n) {
				for (int i2 : i1) System.out.print(i2 + " ");
				System.out.println();
			}

	}
}
