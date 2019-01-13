package JogoDaVelha;

class JogoDaVelha {
  public static Util util=new Util();
  public static int campos[][]=new int[3][3];
  public static int turn=util.rnd(1,2);
  public static int choice,filled;
  public static boolean vsCpu,fimDeJogo;

  public static void main(String args[]) {
    choice=0;
    filled=0;
    util.cls();
    util.imprimirTexto("Jogo da Velha\n\n");
    util.imprimirTexto("Escolha uma opcao:\n");
    util.imprimirTexto("1 - Player VS Player\n");
    util.imprimirTexto("2 - Player VS CPU\n");
    util.imprimirTexto("3 - Sair\n");
    do {
      choice=util.getNumero();
      if (choice<0||choice>3) util.imprimirTexto("Opcao invalida!\n\n");
    }
    while (choice<1||choice>3);
    vsCpu=(choice==1?false:true);
    fimDeJogo=(choice<3?false:true);
    if (!fimDeJogo) startGame();
  }

  public static void startGame() {
    while (!fimDeJogo) {
      for (int n=0; !fimDeJogo&&n<2; n++) {
        util.cls();
        desenhaCampo();
        if (!fimDeJogo) {
          if (turn==2&&vsCpu) choice=cpuTurn(turn);
          else {
            do {
              choice=util.getNumero("Seu turno, jogador "+turn+"...\n")-1;
              if (choice<0||choice>8) util.imprimirTexto("Tecla invalida! Tente o teclado numerico da direita (1-9)\n\n");
            }
            while (choice<0||choice>8);
          }
          campos[(int) (choice/3)][choice%3]=turn;
          turn=turn==2?1:2;
          if (++filled==9||whoWin()>0) fimDeJogo=true;
        }
      }
      desenhaCampo();
    }
    if (whoWin()==0) util.imprimirTexto("Deu velha!\n");
    else if (vsCpu) util.imprimirTexto((whoWin()==1?"Voce":"CPU")+" venceu!\n");
    else util.imprimirTexto("Jogador "+whoWin()+" venceu!\n");
  }

  public static int whoWin() {
    for (int n=1; n<=2; n++) for (int n2=0; n2<3; n2++) {
      if ((check(n2*3)==n&&check(n2*3+1)==n&&check(n2*3+2)==n)||(check(n2)==n&&check(3+n2)==n&&check(6+n2)==n)||(n2<2&&(check(n2*2)==n&&check(4)==n&&check(8-n2*2)==n))) return n;
    }
    return 0;
  }

  public static void desenhaCampo() {
    util.cls();
    for (int y=2; y>=0; y--) {
      for (int x=0; x<3; x++) util.imprimirTexto("["+(campos[y][x]==0?" ":campos[y][x]==1?"O":"X")+"]");
      util.imprimirTexto();
    }

  }

  public static boolean check(int pos1,int pos2,int pos3,int val) {
    return (campos[(int) (pos1/3)][pos1%3]==val&&campos[(int) (pos2/3)][pos2%3]==val&&campos[(int) (pos3/3)][pos3%3]==0)?true:false;
  }

  public static int check(int pos1,int pos2,int pos3) {
    return (campos[(int) (pos1/3)][pos1%3]!=0&&campos[(int) (pos2/3)][pos2%3]==0&&campos[(int) (pos3/3)][pos3%3]==0)?util.rnd(0,1)==0?pos2:pos3:-1;
  }

  public static int check(int pos) {
    return campos[(int) (pos/3)][pos%3];
  }

  public static int tryToTrap(int pos1,int pos2) {
    return (check(pos1)==0&&check(pos2)==0)?(util.rnd(0,1)==1?pos1:pos2):-1;
  }

  public static int cpuTurn(int turn) {
    int choice=-1;
    for (int t=turn, z=0; choice==-1&&z<2; z++, t=t==1?2:1) {
      int pos[][]= {{0,1,2,0,2,1,1,2,0},{0,3,6,0,6,3,3,6,0},{0,4,8,0,8,4,4,8,0,2,4,6,2,6,4,4,6,2}};
      for (int n=0; choice==-1&&n<3; n++) for (int n2=0; choice==-1&&n2+3<pos[2].length; n2+=3) {
        if (n2+3<pos[0].length) {
          if (check(pos[0][n2]+3*n,pos[0][n2+1]+3*n,pos[0][n2+2]+3*n,t)) choice=pos[0][n2+2]+3*n;
          if (check(pos[1][n2+n],pos[1][n2+n+1],pos[1][n2+n+2],t)) choice=pos[1][n2+n+2];
        }
        else if (n==0&&check(pos[2][n2],pos[2][n2+1],pos[2][n2+2],t)) choice=pos[2][n2+2];
      }
    }
    if (check(4)==turn&&choice==-1) {
      int pos[]= {0,2,0,6,0,8,2,6,2,8,6,8,1,7,4,5};
      for (int n=0; choice==-1&&n+1<pos.length; n+=2) choice=tryToTrap(pos[n],pos[n+1]);
    }
    if (choice==-1) {
      if (check(4)==0) choice=4;
      else {
        do choice=util.rnd(0,8);
        while (check(choice)!=0);
      }
    }
    return choice;
  }
}