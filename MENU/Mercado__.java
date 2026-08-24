//classe
public class Mercado__ {
    //atributos
    private double[] Valor_Prod = new double[10];
    private int[] Quant_Prod = new int[10];
    private double Total,Desc,Pagar;
    private String[] Prod = {"Arroz", "Feijão","Óleo","Açucar","Café","Macarrão","Farinha","Fúba","Molho/extrato de tomate","Sal"};

    //metodos de acesso
    public void setValor_Prod(double Valor, int i){
        Valor_Prod[i] = Valor;
    }
    public void setQuant_Prod(int Quant, int i){
        Quant_Prod [i] = Quant;
    }



    public String getProd(int i){
        return Prod[i];
    }
    public double getValor_Prod(int i){
        return Valor_Prod[i];
    }
    public int getQuant_Prod(int i){
        return Quant_Prod[i];
    }
    public double getTotal(){
        return Total;
    }
    public double getDesc(){
        return Desc;
    }
    public double getPagar(){
        return Pagar;
    }

    //metodo

    public void calculoTotal(){
        for (int i=0; i<10; i++){
            Total = (Valor_Prod[i] * Quant_Prod[i])+Total;
        }
    }

    public void calculoDesc(){
        if (Total>100){
            Desc = Total * 0.10;
        }
    }

    public void calculoPagar(){
        Pagar = Total - Desc;
    }


}
