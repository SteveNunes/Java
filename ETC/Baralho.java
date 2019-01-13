package ETC;

class Baralho {
  private Carta[] cartas=new Carta[Naipe.values().length*Valor.values().length];

  Baralho() {
    int posicao=0;
    for (Valor valor : Valor.values()) for (Naipe naipe : Naipe.values()) cartas[posicao++]=new Carta(naipe,valor);
  }

  public static void main(String valorCarta[]) {
    Valor escolha=Valor.DEZ;
    if (valorCarta.length>0) {
      for (Valor valor : Valor.values()) if (valorCarta[0].equals(valor.name())) escolha=valor;
    }
    Baralho baralho=new Baralho();
    Carta[] maioresQue=baralho.cartasMaioresQue(escolha);
    for (Carta carta : maioresQue) System.out.println(carta);
  }

  Carta[] cartasMaioresQue(Valor valorDaCarta) {
    int tamanho=(Valor.values().length-valorDaCarta.ordinal()-1)*Naipe.values().length;
    Carta[] resultado=new Carta[tamanho];
    int posicao=0;
    for (Valor valor : Valor.values()) for (Naipe naipe : Naipe.values()) if (valor.ordinal()>valorDaCarta.ordinal()) resultado[posicao++]=new Carta(naipe,valor);
    return resultado;
  }
}

class Carta {
  private Naipe naipe;
  private Valor valor;

  Carta(Naipe naipe,Valor valor) {
    this.naipe=naipe;
    this.valor=valor;
  }

  public Naipe naipe() {
    return naipe;
  }

  public Valor valor() {
    return valor;
  }

  public String toString() {
    return naipe+" "+valor;
  }
}

enum Naipe {
  PAUS,COPAS,ESPADA,OURO;
}

enum Valor {
  AS,DOIS,TRES,QUATRO,CINCO,SEIS,SETE,OITO,NOVE,DEZ,VALETE,DAMA,REIS;
}