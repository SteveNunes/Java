public class Token {
	
	private String token[], backupToken[], defaultDelimiter;
	private int totalTokenized, backuptotalTokenized;
	private boolean caseIgnore = false;
	
	public Token() { totalTokenized = backuptotalTokenized = 0; defaultDelimiter = " "; caseIgnore = false; }
	
	/**
	 * Apenas para uso privado.
	 * Aplica um tokenize() com os parametros passados, porém salva os parametros
	 * atuaexists da classe para serem recuperados posteriormente.
	 */
	private void saveAndTokenize(String texto, String delimitador) 
		{ backupToken = token; int backuptotalTokenized = totalTokenized; tokenize(texto, delimitador); }
	
	/**
	 * Apenas para uso privado em conjunto com saveAndTokenize().
	 * Recupera os parametros originaexists salvos pelo metodo saveAndTokenize()
	 */
	private void loadSavedTokens() 
		{ if (backuptotalTokenized > 0) { token = backupToken; totalTokenized = backuptotalTokenized; } }

	/**
	 *	Define o delimitador padrão, para o uso de comandos de token sem especificar o delimitador
	 *	@param delimiter - Delimitador a ser definido como padrão
	 */
	public void setDefaultDelimiter(String delimiter) { defaultDelimiter = delimiter; } 
	
	/**
	 *	Retorna um token da lista de tokens obtidos após o uso do metodo tokenize()
	 *	@param posicao - Posição do token a ser obtido
	 */
	public String token(int posicao) 
		{ return (posicao > 0 && posicao <= totalTokenized ? token[posicao - 1] : ""); }

	/**
	 *	Retorna o valor do total de tokens obtidos após o uso do metodo tokenize()
	 */
	public int totalTokenized() { return totalTokenized; }

	/**
	 *	Quebra um texto em tokens, colocando cada token na matriz de String token[]
	 *	e define o valor do atributo 'totalTokenized' para o total de tokens obtidos.
	 *
	 *	@param texto 			- O texto da qual se quer obter o valor do total de tokens
	 *	@param delimitador	 	- Texto ou letra que servirá como delimitador dos tokens
	 */
	public void tokenize(String texto, String delimitador) {
		if (!texto.isEmpty()) {
			java.util.StringTokenizer m = new java.util.StringTokenizer(texto, delimitador);
			token = new String[m.countTokens()];
			for (totalTokenized = 0; m.hasMoreTokens(); totalTokenized++) token[totalTokenized] = m.nextToken();
		}
		else totalTokenized = 0;
	}
	
	/**
	 *	Sobrecarga que permite nao especificar o delimitador, caso ele seja o 'espaço'
	 */
	public void tokenize(String texto) { tokenize(texto, defaultDelimiter); }

	 /**
	 *	Retorna o total de tokens de um texto
	 *
	 *	@param texto 			- O texto da qual se quer obter o valor do total de tokens
	 *	@param delimitador	 	- Texto ou letra que servirá como delimitador dos tokens
	 */
	public int count(String texto, String delimitador) {
		java.util.StringTokenizer m = new java.util.StringTokenizer(texto, delimitador);
		return m.countTokens(); 
	}

	/**
	 *	Sobrecarga que permite nao especificar o delimitador. 
	 *	Nesse caso, será usado o delimitador padrão como parametro.
	 */
	public int count(String texto) { return count(texto, defaultDelimiter); }
	
	/**
	 *	Retorna o token de uma posição especifica de um texto
	 *
	 *	@param texto 			- O texto da qual se quer obter o(s) token(s)
	 *	@param posicaoInicial 	- Posição inicial a ser pego o(s) token(s)
	 *	@param posicaoFinal 	- Posição final a ser pego o(s) token(s)
	 *	@param delimitador	 	- Texto ou letra que servirá como delimitador dos tokens
	 */
	public String get(String texto, int posicaoInicial, int posicaoFinal, String delimitador) {
		saveAndTokenize(texto, delimitador);
		String novaPalavra = "";
		for (int n = 1; n <= totalTokenized; n++)
			if (n >= posicaoInicial && (posicaoFinal == -1 || n <= posicaoFinal))
				novaPalavra += (novaPalavra.isEmpty() ? token(n) : (delimitador + token(n)));
		loadSavedTokens();
		return novaPalavra;
	}

	/**
	 *	Sobrecarga que permite nao especificar o delimitador. 
	 *	Nesse caso, será usado o delimitador padrão como parametro.
	 */
	public String get(String texto, int posicaoInicial, int posicaoFinal)
		{ return get(texto, posicaoInicial, posicaoFinal, defaultDelimiter); }

	/**
	 *	Sobrecarga que permite nao especificar o delimitador. 
	 *	Nesse caso, será usado o delimitador padrão como parametro.
	 */
	public String get(String texto, int posicao, String delimitador)
		{ return get(texto, posicao, posicao, delimitador); }

	/**
	 *	Sobrecarga que permite nao especificar o delimitador. 
	 *	Nesse caso, será usado o delimitador padrão como parametro.
	 */
	public String get(String texto, int posicao)
		{ return get(texto, posicao, defaultDelimiter); }
		
	/**
	 *	Retorna a posição de um token dentro de um texto
	 *
	 *	@param texto 			- O texto da qual se quer obter a posição do token
	 *	@param token			- O token a ser localizado
	 *	@param delimitador	 	- Texto ou letra que servirá como delimitador dos tokens
	 */
	public int find(String texto, String token, String delimitador) {
		int found = 0;
		saveAndTokenize(texto, delimitador);
		for (int n = 1; n <= totalTokenized; n++)
			if (token(n).equals(token)) found = n;
		loadSavedTokens();
		return found;
	}
	
	/**
	 *	Sobrecarga que permite nao especificar o delimitador. 
	 *	Nesse caso, será usado o delimitador padrão como parametro.
	 */
	public int find(String texto, String token) 
		{ return find(texto, token, defaultDelimiter); }

	/**
	 *	Retorna 'true' se o token especificado estiver dentro do texto.
	 *
	 *	@param texto 			- O texto da qual se quer verificar a exexiststencia do token
	 *	@param token			- O token a ser localizado
	 *	@param delimitador	 	- Texto ou letra que servirá como delimitador dos tokens
	 */
	public boolean exists(String texto, String token, String delimitador) 
		{ return find(texto, token, delimitador) > 0 ? true : false; }

	/**
	 *	Sobrecarga que permite nao especificar o delimitador. 
	 *	Nesse caso, será usado o delimitador padrão como parametro.
	 */
	public boolean exists(String texto, String token) 
		{ return exists(texto, token, defaultDelimiter); }

	/**
	 *	Adiciona o token ao final do texto, apenas se esse token ainda não estiver presente no texto.
	 *
	 *	@param texto 			- O texto da qual se quer adicionar o token
	 *	@param token			- O token a ser adicionado
	 *	@param delimitador	 	- Texto ou letra que servirá como delimitador dos tokens
	 */
	public String add(String texto, String token, String delimitador)
		{ return !exists(texto, token, delimitador) ? (texto + delimitador + token) : texto; }
		
	/**
	 *	Sobrecarga que permite nao especificar o delimitador. 
	 *	Nesse caso, será usado o delimitador padrão como parametro.
	 */
	public String add(String texto, String token)
 		{ return add(texto, token, defaultDelimiter); }
		
	/**
	 *	Deleta o token de uma determinada posição do texto
	 *
	 *	@param texto 			- O texto da qual se quer deletar o token
	 *	@param posicao			- A posição do token a ser deletado
	 *	@param delimitador	 	- Texto ou letra que servirá como delimitador dos tokens
	 */
	public String delete(String texto, int posicao, String delimitador) {
		String part1 = (posicao > 1 ? get(texto, 1, posicao - 1, delimitador) : "");
		String part2 = (posicao + 1 < count(texto, delimitador) ? get(texto, posicao + 1, -1, delimitador) : "");
		if (part1.isEmpty() && part2.isEmpty()) return "";
		else if (!part1.isEmpty() && !part2.isEmpty()) return part1 + delimitador + part2;
		else return !part1.isEmpty() ? part1 : part2;
	}

	/**
	 *	Sobrecarga que permite nao especificar o delimitador. 
	 *	Nesse caso, será usado o delimitador padrão como parametro.
	 */
	public String delete(String texto, int posicao)
 		{ return delete(texto, posicao, defaultDelimiter); }

	/**
	 *	Remove o token especificado do texto
	 *
	 *	@param texto 			- O texto da qual se quer remover o token
	 *	@param token			- O token a ser removido
	 *	@param delimitador	 	- Texto ou letra que servirá como delimitador dos tokens
	 */
	public String remove(String texto, String ocorrencia, String delimitador) {
		saveAndTokenize(texto, delimitador);
		String novaPalavra = "";
		for (int n = 1; n <= totalTokenized; n++)
			if (!token(n).equals(ocorrencia))
				novaPalavra += (novaPalavra.isEmpty() ? token(n) : (delimitador + token(n)));
		loadSavedTokens();
		return novaPalavra;
	}

	/**
	 *	Sobrecarga que permite nao especificar o delimitador. 
	 *	Nesse caso, será usado o delimitador padrão como parametro.
	 */
	public String remove(String texto, String ocorrencia)
 		{ return remove(texto, ocorrencia, defaultDelimiter); }
		
	
	/**
	 *	Insere o token especificado no texto, na posição especifcada.
	 *	O token atual na posição especificada é deslocado para direita, jutamente com
	 *	os tokens sequenciaexists, e o novo token é inserido na posição especificada.
	 *
	 *	@param texto 			- O texto da qual se quer inserir o token
	 *	@param token			- O token a ser inserido
	 *	@param delimitador	 	- Texto ou letra que servirá como delimitador dos tokens
	 */
	public String insert(String texto, String ocorrencia, int posicao, String delimitador) {
		String part1 = (posicao > 1 ? get(texto, 1, posicao - 1, delimitador) : "");
		String part2 = (posicao < count(texto, delimitador) ? get(texto, posicao, -1, delimitador) : "");
		return part1 + delimitador + ocorrencia + delimitador + part2;
	}

	/**
	 *	Sobrecarga que permite nao especificar o delimitador. 
	 *	Nesse caso, será usado o delimitador padrão como parametro.
	 */
	public String insert(String texto, String ocorrencia, int posicao)
 		{ return insert(texto, ocorrencia, posicao, defaultDelimiter); }

	/**
	 *	Insere o token especificado no texto, na posição especifcada.
	 *	O token atual na posição especificada é substituido pelo novo token.
	 *
	 *	@param texto 			- O texto da qual se quer inserir o token
	 *	@param token			- O token a ser inserido
	 *	@param delimitador	 	- Texto ou letra que servirá como delimitador dos tokens
	 */
	public String put(String texto, String ocorrencia, int posicao, String delimitador) {
		String part1 = (posicao > 1 ? get(texto, 1, posicao - 1, delimitador) : "");
		String part2 = (posicao + 1 < count(texto, delimitador) ? get(texto, posicao + 1, -1, delimitador) : "");
		return part1 + delimitador + ocorrencia + delimitador + part2;
	}

	/**
	 *	Sobrecarga que permite nao especificar o delimitador. 
	 *	Nesse caso, será usado o delimitador padrão como parametro.
	 */
	public String put(String texto, String ocorrencia, int posicao)
 		{ return put(texto, ocorrencia, posicao, defaultDelimiter); }

	/**
	 *	Substitui o token especificado por outro token. Essa substituição
	 *	poderá ser aplicada em posições especificas ou no texto inteiro.
	 *
	 *	@param texto 			- O texto da qual se quer aplciar a substituição
	 *	@param ocorrencia		- O token a ser localizado para ser substituido
	 *	@param substituicao		- O token a ser inserido no local do token antigo
	 *	@param posicao			- Se for 0, aplica a substituicao em TODAS as ocorrencias encontradas.
	 *							  Se for 1, aplica apenas na primeira ocorrencia,
	 *							  Se for 2, aplica apenas na segunda ocorrencia, e assim em diante...
	 *	@param delimitador	 	- Texto ou letra que servirá como delimitador dos tokens
	 */
	public String replace(String texto, String ocorrencia, String substituicao, int posicao, String delimitador) {
		saveAndTokenize(texto, delimitador);
		String novaPalavra = "", palavra = "";
		int found = 0;
		for (int n = 1; n <= totalTokenized; n++) {
			if (token(n).equals(ocorrencia)) found++;
			palavra = token(n).equals(ocorrencia) && (posicao == 0 || posicao == found) ? substituicao : token(n);
			novaPalavra += (novaPalavra.isEmpty() ? palavra : (delimitador + palavra));
		}
		loadSavedTokens();
		return novaPalavra;
	}

	/**
	 *	Sobrecarga que permite nao especificar o delimitador. 
	 *	Nesse caso, será usado o delimitador padrão como parametro.
	 */
	public String replace(String texto, String ocorrencia, String substituicao, int posicao)
 		{ return replace(texto, ocorrencia, substituicao, posicao, defaultDelimiter); }

	/**
	 *	Sobrecarga que permite nao especificar a posição. 
	 *	Nesse caso, a substituição será aplicada apenas a primeira ocorrencia encontrada.
	 */
	public String replace(String texto, String ocorrencia, String substituicao, String delimitador)
 		{ return replace(texto, ocorrencia, substituicao, 1, delimitador); }

	/**
	 *	Sobrecarga que permite nao especificar a posição e o delimitador.
	 *	Nesse caso, será usado o delimitador padrão como parametro, e a
	 *	substituição será aplicada apenas a primeira ocorrencia encontrada.
	 */
	public String replace(String texto, String ocorrencia, String substituicao)
 		{ return replace(texto, ocorrencia, substituicao, 1, defaultDelimiter); }
		
	/**
	 *	Organiza os tokens, por ordem crescente ou decrescente
	 *
	 *	@param reverse 			- Especifique o valor '1' para ordem decrescente
	 *	@param delimitador	 	- Texto ou letra que servirá como delimitador dos tokens
	 */
	public String sort(String texto, int reverse, String delimitador) {
		saveAndTokenize(texto, delimitador);
		if (reverse == 1) java.util.Arrays.sort(token, java.util.Collections.reverseOrder());
		else java.util.Arrays.sort(token);
		String novaPalavra = "";
		for(String i : token) novaPalavra += (novaPalavra.isEmpty() ? i : (delimitador + i));
		loadSavedTokens();
		return novaPalavra;
	}

	/**
	 *	Sobrecarga que permite nao especificar o parametro 'reverse'
	 *	Nesse caso, será aplicada a ordem crescente
	 */
	public String sort(String texto, String delimitador) { return sort(texto, 0, defaultDelimiter); }

	/**
	 *	Sobrecarga que permite nao especificar o delimitador. 
	 *	Nesse caso, será usado o delimitador padrão como parametro.
	 */
	public String sort(String texto, int reverse) { return sort(texto, reverse, defaultDelimiter); }

	/**
	 *	Sobrecarga que permite nao especificar nem o delimitador, nem o parametro 'reverse'
	 *	Nesse caso, será aplicada a ordem crescente, e será usado o delimitador padrão como parametro.
	 */
	public String sort(String texto) { return sort(texto, 0, defaultDelimiter); }

	/**
	 *	Exemplos de uso de cada um dos metodos dessa classe
	 */
	public static void main(String args[]) {
		Token token = new Token();
 		System.out.println("token.count(\"Steve Nunes da Silva\", \" \") \t\t\t\t- " + token.count("Steve Nunes da Silva", " "));
 		System.out.println("token.get(\"Steve Nunes da Silva\", 2, \" \") \t\t\t\t- " + token.get("Steve Nunes da Silva", 2, " "));
		System.out.println("token.get(\"Steve Nunes da Silva\", 2) \t\t\t\t\t- " + token.get("Steve Nunes da Silva", 2));
		System.out.println("token.get(\"Steve Nunes da Silva\", 2, 3) \t\t\t\t- " + token.get("Steve Nunes da Silva", 2, 3));
		System.out.println("token.get(\"Steve Nunes da Silva\", 2, -1) \t\t\t\t- " + token.get("Steve Nunes da Silva", 2, -1));
		System.out.println("token.add(\"Steve Nunes da Silva\", \"Nunes\") \t\t\t\t- " + token.add("Steve Nunes da Silva", "Nunes"));
		System.out.println("token.add(\"Steve Nunes da\", \"Silva\") \t\t\t\t\t- " + token.add("Steve Nunes da", "Silva"));
		System.out.println("token.delete(\"Steve Nunes da Silva\", 2) \t\t\t\t- " + token.delete("Steve Nunes da Silva", 2));
		System.out.println("token.find(\"Steve Nunes da Silva\", \"Nunes\") \t\t\t\t- " + token.find("Steve Nunes da Silva", "Nunes"));
		System.out.println("token.exists(\"Steve Nunes da Silva\", \"Silva\") \t\t\t\t- " + token.exists("Steve Nunes da Silva", "Silva"));
		System.out.println("token.remove(\"Steve Nunes da Silva\", \"da\") \t\t\t\t- " + token.remove("Steve Nunes da Silva", "da"));
		System.out.println("token.insert(\"Steve Nunes da Silva\", \"Jobs\", 2) \t\t\t- " + token.insert("Steve Nunes da Silva", "Jobs", 2));
		System.out.println("token.put(\"Steve Nunes da Silva\", \"Jobs\", 2) \t\t\t\t- " + token.put("Steve Nunes da Silva", "Jobs", 2));
		System.out.println("token.replace(\"Um Doexists Um Tres Um Quatro Um Cinco\", \"Um\", \"Dez\") \t- " + token.replace("Um Doexists Um Tres Um Quatro Um Cinco", "Um", "Dez"));
		System.out.println("token.replace(\"Um Doexists Um Tres Um Quatro Um Cinco\", \"Um\", \"Dez\" ,2) - " + token.replace("Um Doexists Um Tres Um Quatro Um Cinco", "Um", "Dez" ,2));
		System.out.println("token.replace(\"Um Doexists Um Tres Um Quatro Um Cinco\", \"Um\", \"Dez\" ,3) - " + token.replace("Um Doexists Um Tres Um Quatro Um Cinco", "Um", "Dez" ,3));
		System.out.println("token.sort(\"Joao Maria Bianca Pedro Neide Cris\") \t\t\t- " + token.sort("Joao Maria Bianca Pedro Neide Cris"));
		System.out.println("token.sort(\"Joao Maria Bianca Pedro Neide Cris\", 1) \t\t\t- " + token.sort("Joao Maria Bianca Pedro Neide Cris", 1));
		String texto = "Varias.palavras.separadas.por.ponto.que.serao.quebradas.em.token";
		System.out.println("\nString: " + texto);
		token.tokenize(texto, ".");
		System.out.println("Total de tokens obtidos usando o metodo token.tokenize(texto, \".\"); = token.totalTokenized() = " + token.totalTokenized());
		for(int n = 1; n <= token.totalTokenized(); n++)
			System.out.println("token.token(" + n + ") = " + token.token(n));
		///Teste de velocidade em um ciclo de 1m
		long test=System.currentTimeMillis();
		String m="";
		for(int n=0;n<2000000;n++) token.tokenize("Steve Nunes da Silva"," ");
		System.out.println("token.get() - Duracao: "+(System.currentTimeMillis()-test)+"ms");
    	texto="Steve Nunes da Silva";
		test=System.currentTimeMillis();
		String[] splitString = (texto.split("\\s+"));
		for(int n=0;n<2000000;n++) splitString=(texto.split("\\s+"));
		System.out.println("Token com regex - Duracao: "+(System.currentTimeMillis()-test)+"ms");
	}
	
}