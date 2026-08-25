import java.util.Scanner;

void main() {
    int Opcao;
    Opcao = 10;
    Scanner s=new Scanner(System.in);

    IO.println("===================================");
    IO.println("Feito por: Miguel Tediole LP1 2°BD ");
    while (Opcao != 0){
        IO.println("===================================");
        IO.println("Escolha uma das opções:");
        IO.println("1.Calculo_Viagem");
        IO.println("2.Login_Simplificado");
        IO.println("3.Temperatura");
        IO.println("4.Calculo_Múltiplo");
        IO.println("5.Compra_Desconto");
        IO.println("6.Calculo_Camelos");
        IO.println("7.Aluguel_Carro");
        IO.println("0.PARA SAIR");
        IO.println("===================================");
        Opcao=s.nextInt();

        switch (Opcao) {

            case 1:
                Viagem__ viagem = new Viagem__();
                IO.println("Você escolheu Calculo_Viagem:");
                IO.println("===================================");
                IO.println("Qual a distância percorrida na viagem:");
                double d = s.nextDouble();
                IO.println("Qual o valor pago no combustível:");
                double p = s.nextDouble();
                viagem.setDist(d);
                viagem.setPreco(p);
                viagem.setCons();
                viagem.calculoGasto_Comb();
                viagem.calculoDesc();
                viagem.calculoTotal();
                IO.println("-----------------------------------");
                IO.println("Gasto com combustível: R$" + viagem.getGasto_Comb());
                IO.println("Desconto: R$" + viagem.getDesc());
                IO.println("Total pago: R$" + viagem.getTotal());
                IO.println("===================================");

                s.nextLine();
                IO.println("PRESCIONE ENTER PARA VOLTA AO MENU!");
                s.nextLine();
                break;

            case 2:
                Login__ login = new Login__();
                login.setSenha_Correta();
                IO.println("Você escolheu Login_Simplificado");
                IO.println("===================================");
                while (login.getVerificador() != 1){
                    IO.println("Digite sua senha:");
                    String senha = s.next();
                    login.setSenha(senha);
                    login.verificacaoSenha();
                    if (login.getVerificador() != 1) {
                        IO.println("Acesso negado!");
                    }
                }
                IO.println("Acesso Liberado: Seja bem vindo!");
                s.nextLine();
                IO.println("PRESCIONE ENTER PARA VOLTA AO MENU!");
                s.nextLine();
                break;

            case 3:
                Temperatuta__ temperatura= new Temperatuta__();
                IO.println("Você escolheu Temperatua");
                IO.println("===================================");
                for (int i=1; i<13; i++) {
                    IO.println("Qual a temperatua no " + i+"° mês:");
                    int temp = s.nextInt();
                    temperatura.setTemperatura(temp);
                    temperatura.calculoAno();
                    temperatura.calculoMes();
                    if (temperatura.getVerificador_Mes() == 1){
                        IO.println("A temperatua no " + i+"° mês foi agradável");
                    }
                    else {
                        IO.println("A temperatua no " + i+"° mês foi frio");
                    }
                    IO.println("-----------------------------------");
                }
                if (temperatura.getVerificador_Ano() >= 0){
                    IO.println("A temperatua neste ano foi agradável");
                }
                else {
                    IO.println("A temperatua neste ano foi frio");
                }

                s.nextLine();
                IO.println("PRESCIONE ENTER PARA VOLTA AO MENU!");
                s.nextLine();
                break;

            case 4:
                Multiplo__ multiplo = new Multiplo__();
                IO.println("Você escolhee Verificação_Múltiplo :");
                IO.println("===================================");
                IO.println("Qual o primeiro número:");
                int num1=s.nextInt();
                IO.println("Qual o segundo número:");
                int num2=s.nextInt();
                multiplo.setNumero1(num1);
                multiplo.setNumero2(num2);
                multiplo.Verificacao();
                IO.println("===================================");
                if (multiplo.getVerificador() == 1){
                    IO.println(multiplo.getNumero1()+" é múltiplo de "+multiplo.getNumero2());
                }
                else {
                    IO.println(multiplo.getNumero1()+" não é múltiplo de "+multiplo.getNumero2());
                }

                s.nextLine();
                IO.println("PRESCIONE ENTER PARA VOLTA AO MENU!");
                s.nextLine();
                break;

            case 5:
                Mercado__ mercado = new Mercado__();
                IO.println("Você escolheu Compra_Desconto:");
                IO.println("===================================");
                for (int i=0; i<10; i++) {
                    IO.println("Qual o valor do "+mercado.getProd(i));
                    double  Valor=s.nextDouble();
                    IO.println("Qual a quantidade de "+mercado.getProd(i));
                    int Quant=s.nextInt();
                    IO.println("-----------------------------------");
                    mercado.setValor_Prod(Valor, i);
                    mercado.setQuant_Prod(Quant, i);
                }
                for (int i=0; i<10; i++) {
                    IO.println(mercado.getProd(i)+":  "+mercado.getQuant_Prod(i)+"x R$"+mercado.getValor_Prod(i));
                }
                IO.println("-----------------------------------");
                mercado.calculoTotal();
                mercado.calculoDesc();
                mercado.calculoPagar();
                IO.println("Total: R$ " + String.format("%.2f", mercado.getTotal()));
                IO.println("Desconto: R$ " + String.format("%.2f", mercado.getDesc()));
                IO.println("A pagar: R$ " + String.format("%.2f", mercado.getPagar()));
                IO.println("-----------------------------------");
                s.nextLine();
                IO.println("PRESCIONE ENTER PARA VOLTA AO MENU!");
                s.nextLine();
                break;
                
            case 6:
                Camelo__ camelo = new Camelo__();
                IO.println("Você escolheu Calculo_Camelo:");
                IO.println("===================================");
                IO.println("Quantos camelos tem: ");
                int c =s.nextInt();
                IO.println("-----------------------------------");
                camelo.setQuant_Camelos(c);
                camelo.calculoCamelos();
                camelo.calculoIrmaos();
                IO.println("Mais velho recebeu: "+camelo.getPrimeiro()+" camelos ");
                IO.println("Hamed Namir recebeu: "+camelo.getSegundo()+" camelos ");
                IO.println("Harin recebeu: "+camelo.getTerceiro()+" camelos ");
                IO.println("Ainda sobraram "+camelo.getSobra()+" camelos");
                s.nextLine();
                IO.println("PRESCIONE ENTER PARA VOLTA AO MENU!");
                s.nextLine();
                break;

            case 7:
                Aluguel__ aluguel = new Aluguel__();
                IO.println("Você escolheu Calculo_Aluguel:");
                IO.println("===================================");
                IO.println("Quantos dias você ficou com o carro: ");
                int dia=s.nextInt();
                IO.println("Quantos Km você rodou com o carro: ");
                double Km =s.nextDouble();
                aluguel.setKm_rodado(Km);
                aluguel.setAluguel_Carro();
                aluguel.setKm_MaxD();
                aluguel.setPreco_Km();
                aluguel.setDias(dia);
                aluguel.calculoKm();
                aluguel.calculoTotal();
                IO.println("-----------------------------------");
                IO.println("------------NOTA FISCAl------------");
                IO.println("Dias: "+aluguel.getDias()+"                   x R$"+aluguel.getAluguel_Carro());
                IO.println("Km rodado: "+aluguel.getKm_Rodado()+"     máx dia: "+aluguel.getKm_MaxD());
                IO.println("Km's ultrapassados: "+aluguel.getKm_Ultrapassado()+"     x R$"+aluguel.getPreco_Km());
                IO.println("-----------------------------------");
                IO.println("Total: R$"+aluguel.getTotal());

                s.nextLine();
                IO.println("PRESCIONE ENTER PARA VOLTA AO MENU!");
                s.nextLine();
                break;
        }

    }
}
