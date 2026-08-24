import java.util.Scanner;


public class Camelo {
    void main(){
        int camelos,x,soma,primeiro,segundo,terceiro;
        Scanner s=new Scanner(System.in);

       IO.println("Quantos camelos se tem :");
       camelos=s.nextInt();

       if (camelos % 1 ==0){
           camelos= camelos+1;
       }

        primeiro= camelos/2;
        segundo=  camelos/3;
        terceiro= camelos/9;

        IO.println("Mais velho recebeu: "+primeiro+" camelos "); 
        IO.println("Hamed Namir recebeu: "+segundo+" camelos ");
        IO.println("Harin recebeu: "+terceiro+" camelos ");

    }
}
