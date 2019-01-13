package Exemplos;

public class Loops {
  public static void main(String args[]) {
    /**
     * Loops em Java são idênticos aos loops em C++, com excessão do 'goto' que aparentemente não funciona, apesar de 'goto' ser uma palavra reservada em Java.
     */

    System.out.println("Laco for()");
    for (int n=0; n<10; n++) System.out.print(n+" ");
    System.out.println();

    System.out.println("Laco while()");
    int n=0;
    while (n<10) {
      System.out.print(n+" ");
      n++;
    }
    System.out.println();

    System.out.println("Laco do ... while()");
    n=0;
    do {
      System.out.print(n+" ");
      n++;
    }
    while (n<10);
    System.out.println();

    System.out.println("Laco for() Enhanced");
    int nums[]= {0,1,2,3,4,5,6,7,8,9};
    for (int i : nums) System.out.print(i+" ");
    System.out.println();

  }
}