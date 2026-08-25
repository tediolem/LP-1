public class Aluguel__{
    private double Aluguel_Carro,Km_MaxD,Km_rodado,Km_Ultrapassado,Total,Preco_Km,Adicional;
    private int Dias;

    //metodo de acesso
    public void setDias(int dia){
        Dias = dia;
    }
    public void setKm_rodado(double Km){
        Km_rodado = Km;
    }
    public void setAluguel_Carro(){
        Aluguel_Carro = 550;
    }
    public void setKm_MaxD (){
        Km_MaxD = 1000; //dia
    }
    public void setPreco_Km(){
        Preco_Km = 5.50;//Km a mais
    }

    public int getDias(){
        return Dias;
    }
    public double getKm_Rodado(){
        return Km_rodado;
    }
    public double getAluguel_Carro(){
        return Aluguel_Carro;
    }
    public double getAdicional() {
        return Adicional;
    }
    public double getTotal(){
        return Total;
    }
    public double getKm_Ultrapassado(){
        return Km_Ultrapassado;
    }
    public double getKm_MaxD(){
        return Km_MaxD;
    }
    public double getPreco_Km(){
        return Preco_Km;
    }


    //metodos

   public void calculoKm(){
        if( Km_rodado>(Dias*Km_MaxD)){
            Km_Ultrapassado = Km_rodado - (Dias*Km_MaxD) ;
        }
        else{
            Km_Ultrapassado = 0;
        }
   }
   public void calculoTotal(){
       Adicional = Km_Ultrapassado * Preco_Km;
       Total = (Dias*Aluguel_Carro)+Adicional;
   }



}
