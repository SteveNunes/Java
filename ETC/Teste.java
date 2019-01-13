package ETC;

public class Teste {
  public static void main(String args[]) {
    String m="";
    long n2;
    for (int n=0;; n++) {
      n2=System.currentTimeMillis();
      for (int n3=0; n3<100000; n3++) m="Steve";
      System.out.println(System.currentTimeMillis()-n2);
    }

  }
}
