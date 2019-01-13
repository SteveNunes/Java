package ETC;

class ClassesEHerancas {

  public static Personagem personagem;
  public static Util util=new Util();

  public static void selecionarPersonagem(String nome,int classe) {
    if (classe==Classes.BARBARO.getValor()) personagem=new Barbaro(nome);
    else if (classe==Classes.MAGO.getValor()) personagem=new Mago(nome);
    else if (classe==Classes.ARQUEIRO.getValor()) personagem=new Arqueiro(nome);
    else if (classe==Classes.ROUGE.getValor()) personagem=new Rouge(nome);
    else if (classe==Classes.ALEATORIA.getValor()) selecionarPersonagem(nome,util.rnd(1,4));
  }

  public static void main(String args[]) {

    int escolha;
    util.imprimirTexto("Escolha sua classe:\n\n");
    for (Classes classe : Classes.values()) util.imprimirTexto(classe.getValor()+" - "+classe.name()+"\n");
    do escolha=util.getNumero();
    while (escolha<Classes.BARBARO.getValor()||escolha>Classes.ALEATORIA.getValor());

    selecionarPersonagem("Steve",escolha);

  }
}

enum Classes {
  BARBARO(1),MAGO(2),ARQUEIRO(3),ROUGE(4),ALEATORIA(5);
  private final int valor;

  Classes(int valor) {
    this.valor=valor;
  }

  public int getValor() {
    return valor;
  }
}

class Personagem {

  protected String nome,classe;
  protected int level,experiencia,hp,mp;

  Personagem(String nome,String classe,int hp,int mp) {
    this.nome=nome;
    this.classe=classe;
    this.hp=hp;
    this.mp=mp;
    this.level=1;
  }

  protected void dadosDoPersonagem() {
    System.out.println("Nome: "+nome);
    System.out.println("Classe: "+classe);
    System.out.println("Level: "+level);
    System.out.println("Experiencia: "+experiencia);
    System.out.println("HP: "+hp);
    System.out.println("MP: "+mp);
  }
}

class Barbaro extends Personagem {
  private int forca;

  Barbaro(String nome) {
    super(nome,"Barbaro",1000,100);
    forca=100;
    dadosDoPersonagem();
  }

  protected void dadosDoPersonagem() {
    super.dadosDoPersonagem();
    System.out.println("Forca: "+forca+"\n");
  }
}

class Mago extends Personagem {
  private int magica;

  Mago(String nome) {
    super(nome,"Mago",300,1500);
    magica=100;
    dadosDoPersonagem();
  }

  protected void dadosDoPersonagem() {
    super.dadosDoPersonagem();
    System.out.println("Magica: "+magica+"\n");
  }
}

class Arqueiro extends Personagem {
  private int dextreza;

  Arqueiro(String nome) {
    super(nome,"Arqueiro",550,300);
    dextreza=100;
    dadosDoPersonagem();
  }

  protected void dadosDoPersonagem() {
    super.dadosDoPersonagem();
    System.out.println("Dextreza: "+dextreza+"\n");
  }
}

class Rouge extends Personagem {
  private int sorte;

  Rouge(String nome) {
    super(nome,"Rouge",400,500);
    sorte=100;
    dadosDoPersonagem();
  }

  protected void dadosDoPersonagem() {
    super.dadosDoPersonagem();
    System.out.println("Sorte: "+sorte+"\n");
  }
}