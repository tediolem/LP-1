import java.util.Scanner;

public class viagem {
    void main () {
        double distancia,preco,desconto,consumo,gasto;
        Scanner s=new Scanner(System.in);

        distancia= 0;
        desconto=0;
        consumo=12;

        IO.println("Qual a distancia da viagem :");
        distancia=s.nextDouble();
        IO.println("Qual o preço do combustivel :");
        preco=s.nextDouble();

        gasto= (distancia/consumo)*preco;

        if(distancia>=500) {
            IO.println("Gasto total: "+gasto);
            desconto= gasto*0.05;
            gasto= gasto*0.95;
            IO.println("Desconto: "+desconto);
            IO.println("Total PAGO:"+gasto);

        }
        else {
            IO.println("Total PAGO:"+gasto);
        }
    }
}
