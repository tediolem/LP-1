//class
public class Camelo__ {
    //atributos
    private int Quant_Camelos,Primeiro,Segundo,Terceiro,Sobra;



    //metodo de acesso
    public void setQuant_Camelos(int c){
        Quant_Camelos = c;
    }
    public int getPrimeiro(){
        return Primeiro;
    }
    public int getSegundo(){
        return Segundo;
    }
    public int getTerceiro(){
        return Terceiro;
    }
    public int getSobra(){
        return Sobra;
    }

    //metodo
    public void calculoCamelos(){
        if(Quant_Camelos % 1 == 0){
            Quant_Camelos = Quant_Camelos +1;
        }
    }
    public void calculoIrmaos(){
        Primeiro = Quant_Camelos/2;
        Segundo = Quant_Camelos/3;
        Terceiro = Quant_Camelos/9;
        Sobra = Quant_Camelos - (Primeiro + Segundo + Terceiro);
    }



}
