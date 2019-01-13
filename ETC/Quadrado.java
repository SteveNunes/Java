package quadrado;
import java.util.Scanner;

public class Quadrado {
    public static void quad(int tam,int tam2,char letra) {
        for (int n1=1;n1 <= tam2;n1++) 
            for (int n2=1;n2 <= tam;n2++) 
                System.out.printf("%c%s",(((n1==1) || (n1==tam2) || (n2==1) || (n2==tam)))?letra:' ',(n2==tam)?"\n":"");
    }
    public static void main(String[] args) {
        quad(4,6,'X');
        quad(20,10,'O');
    }
}