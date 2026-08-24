import java.util.Scanner;

public class Multiplo {
    void main(){
        int num1,num2;
        double x;
        Scanner s=new Scanner(System.in);
        IO.println("Digite um número");
        num1=s.nextInt();
        IO.println("Digite um número");
            num2=s.nextInt();
        if (num1 % num2 == 0) {
            System.out.println(num1+ " é multiplo de " +num2);
        }
        else {
            System.out.println(num1+ " não é multiplo de " +num2);
        }
    }
}
