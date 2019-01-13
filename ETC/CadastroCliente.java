package ETC;
import java.util.ArrayList;
import java.util.List;

class Cliente {
	String Nome; int Idade;
	Cliente(String nome,int idade) { Nome=nome; Idade=idade; }
}
public class CadastroCliente {
	private static java.util.Scanner sc = new java.util.Scanner(System.in);
	private static List ListaDeClientes;
	public static void main(String args[]) {
		ListaDeClientes = new ArrayList();
		char c=0;
		do {
			c=Opcao();
			if(c=='1') CadastrarCliente();
			if(c=='2') RemoverCliente();
			if(c=='3') ListarClientes();
		}
		while(c!='4');
	}
	public static char Opcao() {
		System.out.println("\nEscolha uma opcao:\n");
		System.out.println("1) Cadastrar novo cliente");
		System.out.println("2) Remover cliente");
		System.out.println("3) Listar clientes");
		System.out.println("4) Sair\n");
		return sc.next().charAt(0);
	}
	public static void CadastrarCliente() {
		System.out.print("Digite o nome: ");
		String nome=sc.next();
		System.out.print("Digite a idade: ");
		int idade=Integer.parseInt(sc.next());
		ListaDeClientes.add(new Cliente(nome,idade));
		System.out.println("Cliente '"+nome+"' adicionado com sucesso!");
	}
	public static void RemoverCliente() {
		int pos;
		do {
			System.out.print("Digite a posicao do cliente a remover: ");
			pos=Integer.parseInt(sc.next());
			if(pos<=0 || pos>ListaDeClientes.size()) System.out.print("Cliente invalido!\n");
		}
		while(pos<=0 || pos>ListaDeClientes.size());
		Cliente c=(Cliente)ListaDeClientes.get(pos-1);
		System.out.println("Cliente '"+c.Nome+"' removido com sucesso!");
		ListaDeClientes.remove(pos-1);
	}
	public static void ListarClientes() {
		if(ListaDeClientes.size()==0) System.out.println("A lista de clientes esta vazia!\n");
		else {
			System.out.print("Listando clientes:\n");
			for(int n=0;n<ListaDeClientes.size();n++) {
				Cliente c=(Cliente)ListaDeClientes.get(n);
				System.out.println("Cliente "+(n+1)+": Nome:"+c.Nome+" Idade: "+c.Idade);
			}
		}
	}
}
