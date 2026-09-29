//class
public class Multiplo__ {
    //atributos
    private int Numero1,Numero2,Verificador;

    //metodo de acesso
    public void setNumero1(int num1){
        Numero1 = num1;
    }
    public void setNumero2(int num2){
        Numero2 = num2;
    }

    public int getNumero1(){
        return Numero1;
    }

    public int getNumero2() {
        return Numero2;
    }

    public int getVerificador(){
        return Verificador;
    }

    //metodo
    public void Verificacao(){
        if(Numero1 % Numero2 == 0){
            Verificador = 1;
        }
        else {
            Verificador = 0;
        }
    }
}
