import java.util.Scanner;

public class Mercado {
    void main () {
        int p1,p2,p3,p4,p5,p6,p7,p8,p9,p10;
        double soma,total,desconto,x;

        desconto=0;
        total=0;

        Scanner s=new Scanner(System.in);
        IO.println ("==========================");
        IO.println ("Qual o preço do arroz: ");
        p1=s.nextInt();
        IO.println ("==========================");
        IO.println ("Qual o preço do feijão: ");
        p2=s.nextInt();
        IO.println ("==========================");
        IO.println ("Qual o preço do óleo: ");
        p3=s.nextInt();
        IO.println ("==========================");
        IO.println ("Qual o preço do açúcar: ");
        p4=s.nextInt();
        IO.println ("==========================");
        IO.println ("Qual o preço do café: ");
        p5=s.nextInt();
        IO.println ("==========================");
        IO.println ("Qual o preço do macarrão: ");
        p6=s.nextInt();
        IO.println ("==========================");
        IO.println ("Qual o preço do farinha: ");
        p7=s.nextInt();
        IO.println ("==========================");
        IO.println ("Qual o preço do fubá: ");
        p8=s.nextInt();
        IO.println ("==========================");
        IO.println ("Qual o preço do molho de tomate: ");
        p9=s.nextInt();
        IO.println ("==========================");
        IO.println ("Qual o preço do sal: ");
        p10=s.nextInt();
        IO.println ("==========================");
        soma=(p1+p2+p3+p4+p5+p6+p6+p7+p8+p9+p10);

        if(soma>=100){
            total = (soma * 0.90);
            desconto=(soma*0.10);
        }
        else {
            total=soma;
        }
        IO.println ("==========================");
        IO.println ("Compra finalizada:");
        IO.println ("Arros :    $"+p1);
        IO.println ("Feijão :   $"+p2);
        IO.println ("Óleo :     $"+p3);
        IO.println ("Açúcar :   $"+p4);
        IO.println ("Café :     $"+p5);
        IO.println ("Macarrão : $"+p6);
        IO.println ("Farinha :  $"+p7);
        IO.println ("Fubá :     $"+p8);
        IO.println ("Molho :    $"+p9);
        IO.println ("Sal :      $"+p10);
        IO.println ("==========================");
        IO.println ("Total : $" +soma);
        IO.println ("Desconto : $" +desconto);
        IO.println ("A pagar : $" +total);
        IO.println ("==========================");
    }
}
