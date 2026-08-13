import java.util.Scanner;

public class temperatura {
    void main(){
        double[] temperatura = new double[12];
        double soma;
        int t;

        soma=0;
        Scanner s = new Scanner(System.in);
        for (t = 1; t<= 12; t++){
            IO.println("Qual a temperatura registrada no "+t+"° mes: ");
            temperatura[t]=s.nextDouble();
            soma = temperatura[t]+soma;
        }


    }
}
