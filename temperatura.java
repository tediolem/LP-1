import java.util.Scanner;

public class temperatura {
    void main() {
        double[] temperatura = new double[13];
        double soma;
        int t,agra,frio;

        soma = 0;
        Scanner s = new Scanner(System.in);
        for (t = 1; t <= 12; t++) {
            IO.println("Qual a temperatura registrada no " + t + "° mes: ");
            temperatura[t] = s.nextDouble();
            soma = temperatura[t] + soma;
        }

        IO.println("==============================================");
        agra= 0;
        frio= 0;
        for (t = 1; t <= 12; t++) {
            if (temperatura[t] > 18){
                IO.println(t + "° mês a temperatura foi agradável.");
                agra= agra+1;
            }
            else{
            IO.println(t + "° mês a temperatura foi frio.");
            frio= frio+1;
            }
        }
        if (agra>frio){
            IO.println("==============================================");
            IO.println("São José é uma cidade com temperatura mais agradável");
            IO.println("==============================================");
        }
        else {
            IO.println("==============================================");
            IO.println("São José é uma cidade com temperatura mais fria");
            IO.println("==============================================");
        }
    }

}
