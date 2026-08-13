import java.util.Scanner;

public class Mercado {
    void main () {
        int p1,p2,p3,p4,p5,p6,p7,p8,p9,p10;
        int q1,q2,q3,q4,q5,q6,q7,q8,q9,q10;
        double soma,total,desconto,x;

        desconto=0;
        total=0;

        Scanner s=new Scanner(System.in);
        IO.println ("==========================");
        IO.println ("Qual o preço do arroz: ");
        p1=s.nextInt();
        IO.println ("Quantidade: ");
        q1=s.nextInt();
        IO.println ("==========================");
        IO.println ("Qual o preço do feijão: ");
        p2=s.nextInt();
        IO.println ("Quantidade: ");
        q2=s.nextInt();
        IO.println ("==========================");
        IO.println ("Qual o preço do óleo: ");
        p3=s.nextInt();
        IO.println ("Quantidade: ");
        q3=s.nextInt();
        IO.println ("==========================");
        IO.println ("Qual o preço do açúcar: ");
        p4=s.nextInt();
        IO.println ("Quantidade: ");
        q4=s.nextInt();
        IO.println ("==========================");
        IO.println ("Qual o preço do café: ");
        p5=s.nextInt();
        IO.println ("Quantidade: ");
        q5=s.nextInt();
        IO.println ("==========================");
        IO.println ("Qual o preço do macarrão: ");
        p6=s.nextInt();
        IO.println ("Quantidade: ");
        q6=s.nextInt();
        IO.println ("==========================");
        IO.println ("Qual o preço do farinha: ");
        p7=s.nextInt();
        IO.println ("Quantidade: ");
        q7=s.nextInt();
        IO.println ("==========================");
        IO.println ("Qual o preço do fubá: ");
        p8=s.nextInt();
        IO.println ("Quantidade: ");
        q8=s.nextInt();
        IO.println ("==========================");
        IO.println ("Qual o preço do molho de tomate: ");
        p9=s.nextInt();
        IO.println ("Quantidade: ");
        q9=s.nextInt();
        IO.println ("==========================");
        IO.println ("Qual o preço do sal: ");
        p10=s.nextInt();
        IO.println ("Quantidade: ");
        q10=s.nextInt();
        IO.println ("==========================");
        soma=(p1*q1)+(p2*q2)+(p3*q3)+(p4*q4)+(p5*q5)+(p6*q6)+(p7*q7)+(p8*q8)+(p9*q9)+(p10*q10);

        if(soma>=100){
            total = (soma * 0.90);
            desconto=(soma*0.10);
        }
        else {
            total=soma;
        }
        IO.println ("==========================");
        IO.println ("Compra finalizada:");
        IO.println ("Arros :    x"+q1+" $"+p1);
        IO.println ("Feijão :   x"+q2+" $"+p2);
        IO.println ("Óleo :     x"+q3+" $"+p3);
        IO.println ("Açúcar :   x"+q4+" $"+p4);
        IO.println ("Café :     x"+q5+" $"+p5);
        IO.println ("Macarrão : x"+q6+" $"+p6);
        IO.println ("Farinha :  x"+q7+" $"+p7);
        IO.println ("Fubá :     x"+q8+" $"+p8);
        IO.println ("Molho :    x"+q9+" $"+p9);
        IO.println ("Sal :      x"+q10+" $"+p10);
        IO.println ("==========================");
        IO.println ("Total : $" +soma);
        IO.println ("Desconto : $" +desconto);
        IO.println ("A pagar : $" +total);
        IO.println ("==========================");
    }
}
