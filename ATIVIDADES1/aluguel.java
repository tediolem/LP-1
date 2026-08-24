import java.util.Scanner;

public class aluguel {
    void main() {
        double preco, dia, quilometroMax, rodado, precoQuilometro, total,carro,adicional,x;
        Scanner s = new Scanner(System.in);

        preco = 250;//dia

        IO.println("Quantos dias foi alugado:");
        dia = s.nextDouble();
        IO.println("Quantos KM foi rodado:");
        rodado = s.nextDouble();
        quilometroMax= dia*500;
        total = dia * preco;
        x= 0;
        if (rodado>quilometroMax){
            x= rodado-quilometroMax;
            x= x*2;
            total= total+x;
        }

        carro = dia*preco;
        IO.println("===========================");
        IO.println("Aluguel do carro: $"+carro);
        IO.println("Adicional por KM: $"+x);
        IO.println("Total a ser pago: $"+total);
        IO.println("===========================");
    }
}
