import java.util.Scanner;

public class Loading {
    void main () {
        int senhaUsuario, senha;
        Scanner s=new Scanner(System.in);
        senha= 1234;
        IO.println("Digite sua senha:");
        senhaUsuario=s.nextInt();

        if (senhaUsuario == senha) {
            System.out.println("Acesso Permitido");
        }
        else {
            System.out.println("Acesso Negado");
        }
    }
}
