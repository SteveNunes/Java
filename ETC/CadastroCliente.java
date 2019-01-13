package ETC;

import java.util.ArrayList;
import java.util.List;

class Cliente {
  String Nome;
  int Idade;

  Cliente(String nome,int idade) {
    Nome=nome;
    Idade=idade;
  }
}

public class CadastroCliente {
  private static java.util.Scanner sc=new java.util.Scanner(System.in);
  private static List<Cliente> ListaDeClientes;

  public static void main(String args[]) {
    ListaDeClientes=new ArrayList();
    char c;
    do {
      c=Opcao();
      if (c=='1') CadastrarCliente();
      if (c=='2') RemoverCliente();
      if (c=='3') ListarClientes();
    }
    while (c!='4');
  }

  public static char Opcao() {
    System.out.println("Escolha uma opcao:\n");
    System.out.println("1) Cadastrar novo cliente");
    System.out.println("2) Remover cliente");
    System.out.println("3) Listar clientes");
    System.out.println("4) Sair\n");
    return sc.nextLine().charAt(0);
  }

  public static void CadastrarCliente() {
    System.out.print("Digite o nome: ");
    String nome=sc.nextLine();
    System.out.print("Digite a idade: ");
    int idade=Integer.parseInt(sc.nextLine());
    ListaDeClientes.add(new Cliente(nome,idade));
    System.out.println("\nCliente '"+nome+"' adicionado com sucesso a posicao "+ListaDeClientes.size()+" da lista!\n");
    ExibirInfoDaLista();
  }

  public static void RemoverCliente() {
    int pos;
    do {
      System.out.print("Digite a posicao do cliente a remover: ");
      pos=Integer.parseInt(sc.nextLine());
      if (pos<=0||pos>ListaDeClientes.size()) System.out.println("\nCliente invalido!\n");
    }
    while (pos<=0||pos>ListaDeClientes.size());
    Cliente c=ListaDeClientes.get(pos-1);
    System.out.println("\nCliente '"+c.Nome+"' removido com sucesso!\n");
    ListaDeClientes.remove(pos-1);
    ExibirInfoDaLista();
  }

  public static void ListarClientes() {
    if (ListaDeClientes.size()==0) System.out.println("A lista de clientes esta vazia!\n");
    else {
      String nome;
      ExibirInfoDaLista();
      System.out.println("Listando clientes:\n");
      System.out.println("Posicao\t\tNome\t\t\t\t\tIdade\n");
      for (int n=0; n<ListaDeClientes.size(); n++) {
        Cliente c=ListaDeClientes.get(n);
        nome=(n+1)+"\t\t"+c.Nome;
        for (int n2=0; n2<(5-c.Nome.length()/9); n2++) nome+="\t";
        System.out.println(nome+c.Idade);
      }
      System.out.println();
    }
  }

  public static void ExibirInfoDaLista() {
    System.out.println("Informacao atual da lista de clientes:");
    if (ListaDeClientes.size()==0) System.out.println("A lista de clientes esta vazia!");
    else System.out.println("Quantidade de clientes cadastrados: "+ListaDeClientes.size()+"\n");
  }
}
