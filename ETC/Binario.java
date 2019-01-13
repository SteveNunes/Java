package ETC;

public class Binario {

  public static void main(String args[]) {
    for (int n=0; n<100; n++) System.out.println(n+" = "+converter(n));
  }

  public static String converter(int num) {
    StringBuilder result;
    result=new StringBuilder();
    int n=1;
    for (; n+n<=num; n*=2);
    for (; n>=1; n/=2) {
      result.append(n<=num?"1":"0");
      if (n<=num) num-=n;
    }
    return result.toString();
  }
}