package model;
//class
public class Login__ {

    //class
    private String  Senha,Senha_Correta;
    private int Verificador;
    //metodo de acesso
    public void setSenha (String senha){
        Senha = senha;
    }
    public void setSenha_Correta (){
        Senha_Correta = "1234";
    }

    public int getVerificador(){
        return Verificador;
    }
    public String getSenha(){return Senha;}

    //metodos
    public void verificacaoSenha(){
        if (Senha.equals(Senha_Correta)){
            Verificador = 1;
        }
        else {
           Verificador = 0;
        }
    }
}
