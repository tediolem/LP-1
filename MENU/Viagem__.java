//class
public class Viagem__ {
    private double Dist,Preco,Desc,Cons,Gasto_Comb,Total;

    //metodo de acesso
    //set
     public void setDist (double d){
         Dist = d;
     }
     public void setPreco (double p){
        Preco = p;
     }
     public void setCons(){
         Cons = 12;
     }
     //get
     public double getGasto_Comb(){
         return Gasto_Comb;
     }
     public double getDesc(){
         return Desc;
     }
     public double getTotal(){
        return Total;
     }

     //metodos
     public void calculoGasto_Comb(){
         Gasto_Comb = (Dist / Cons) * Preco ;
     }
     public void calculoDesc(){
         if (Dist>=500) {
             Desc = Gasto_Comb * 0.05;
         }
     }
     public void calculoTotal(){
        Total = Gasto_Comb - Desc;
     }
}
