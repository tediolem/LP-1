//class
public class Temperatuta__ {
    //atributos
    public int Temperatura,Verificador_Mes,Verificador_Ano;

    //metodo de acesso
    public void setTemperatura(int temp){
        Temperatura = temp;
    }

    public int getVerificador_Mes(){
        return Verificador_Mes;
    }
    public int getVerificador_Ano(){
        return Verificador_Ano;
    }

    //metodo
    public void calculoMes(){
        if(Temperatura>=18){
            Verificador_Mes = 1;
        }
        else {
            Verificador_Mes = 0;
        }
    }
    public void calculoAno(){
        if(Temperatura>=18){
            Verificador_Ano = Verificador_Ano +1;
        }
        else {
            Verificador_Ano = Verificador_Ano -1;
        }
    }
}
