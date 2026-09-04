import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int opcao = 10;
        Scanner s = new Scanner(System.in);

        while (opcao != 0) {

            System.out.println("===== MENU =====");
            System.out.println("1 - Loja");
            System.out.println("2 - Trilha");
            System.out.println("3 - Mascara");
            System.out.println("4 - Cabelo");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = s.nextInt();

            switch (opcao) {

                case 1:

                    // ENTRANDO NA LOJA DORINHO'S
                    System.out.println("\n===== DORINHO'S =====");
                    System.out.println("1 - Camisa");
                    System.out.println("2 - Calça");
                    System.out.println("3 - Terno");
                    System.out.print("Escolha o produto: ");

                    int produto = s.nextInt();

                    switch (produto) {

                        case 1:

                            Camisa camisa = new Camisa();

                            camisa.setCor("Rosa");
                            camisa.setTamanho("M");
                            camisa.setPreco(89.90);

                            camisa.exibirDados();

                            camisa.aplicarDesconto();

                            System.out.println("\nDepois do desconto:");
                            camisa.exibirDados();

                            s.nextLine();
                            IO.println("PRESCIONE ENTER PARA VOLTA AO MENU!");
                            s.nextLine();
                            break;


                        case 2:

                            Calsa calca = new Calsa();

                            calca.setCor("Preta");
                            calca.setTamanho(42);
                            calca.setPreco(149.90);

                            calca.exibirDados();

                            calca.aplicarDesconto();

                            System.out.println("\nDepois do desconto:");
                            calca.exibirDados();

                            s.nextLine();
                            IO.println("PRESCIONE ENTER PARA VOLTA AO MENU!");
                            s.nextLine();
                            break;


                        case 3:

                            Terno terno = new Terno();

                            terno.setCor("Azul");
                            terno.setTamanho("G");
                            terno.setPreco(799.90);

                            terno.exibirDados();

                            terno.aplicarDesconto();

                            System.out.println("\nDepois do desconto:");
                            terno.exibirDados();

                            s.nextLine();
                            IO.println("PRESCIONE ENTER PARA VOLTA AO MENU!");
                            s.nextLine();
                            break;
                    }
                break;


                case 2:

                    System.out.println("\n===== TRILHA DE BICICLETA =====");

                    // Dados do ciclista
                    s.nextLine(); // limpa o ENTER que ficou do nextInt()

                    System.out.print("Digite o nome do ciclista: ");
                    String nome = s.nextLine();

                    System.out.print("Digite a idade do ciclista: ");
                    int idade = s.nextInt();

                    System.out.print("Digite a velocidade inicial (km/h): ");
                    double velocidade = s.nextDouble();

                    // Criando o ciclista com os dados informados pelo usuário
                    Ciclista ciclista = new Ciclista(nome, idade, velocidade);

                    // Dados da bicicleta
                    s.nextLine();

                    System.out.print("Digite a marca da bicicleta: ");
                    String marca = s.nextLine();

                    System.out.print("Digite o tamanho do aro: ");
                    int aro = s.nextInt();

                    Bicicleta bicicleta = new Bicicleta(marca, aro, velocidade);

                    // Dados da trilha
                    s.nextLine();

                    System.out.print("Digite o nome da trilha: ");
                    String nomeTrilha = s.nextLine();

                    System.out.print("Digite a distância da trilha (km): ");
                    double distancia = s.nextDouble();

                    s.nextLine();

                    System.out.print("Digite a dificuldade da trilha: ");
                    String dificuldade = s.nextLine();

                    Trilha trilha = new Trilha(nomeTrilha, distancia, dificuldade);

                    // Exibindo os dados
                    System.out.println("\n===== DADOS DA TRILHA =====");
                    trilha.exibirInformacoes();

                    System.out.println("\n===== CICLISTA =====");
                    System.out.println("Nome: " + ciclista.getNome());
                    System.out.println("Idade: " + ciclista.getIdade());
                    System.out.println("Velocidade: " + ciclista.getVelocidade() + " km/h");

                    System.out.println("\n===== BICICLETA =====");
                    System.out.println("Marca: " + bicicleta.getMarca());
                    System.out.println("Aro: " + bicicleta.getAro());

                    // Menu para o usuário controlar o ciclista
                    int acao = 10;

                    while (acao != 0) {

                        System.out.println("\n===== O QUE DESEJA FAZER? =====");
                        System.out.println("1 - Pedalar");
                        System.out.println("2 - Aumentar velocidade");
                        System.out.println("3 - Frear");
                        System.out.println("4 - Acelerar bicicleta");
                        System.out.println("5 - Trocar marcha");
                        System.out.println("6 - Ver informações");
                        System.out.println("0 - Voltar ao menu principal");
                        System.out.print("Escolha uma opção: ");

                        acao = s.nextInt();

                        switch (acao) {

                            case 1:
                                ciclista.pedalar();
                                break;

                            case 2:
                                ciclista.aumentarVelocidade();
                                break;

                            case 3:
                                ciclista.frear();
                                break;

                            case 4:
                                bicicleta.acelerar();
                                break;

                            case 5:
                                System.out.print("Digite a marcha: ");
                                int marcha = s.nextInt();

                                bicicleta.trocarMarcha(marcha);
                                break;

                            case 6:
                                System.out.println("\n===== INFORMAÇÕES =====");
                                System.out.println("Ciclista: " + ciclista.getNome());
                                System.out.println("Idade: " + ciclista.getIdade());
                                System.out.println("Velocidade: "
                                        + ciclista.getVelocidade() + " km/h");

                                System.out.println("Bicicleta: "
                                        + bicicleta.getMarca());

                                System.out.println("Aro: "
                                        + bicicleta.getAro());

                                System.out.println("Trilha: "
                                        + trilha.getNome());

                                System.out.println("Distância: "
                                        + trilha.getDistancia() + " km");

                                System.out.println("Dificuldade: "
                                        + trilha.getDificuldade());
                                break;

                            case 0:
                                System.out.println("Voltando ao menu principal...");
                                break;

                            default:
                                System.out.println("Opção inválida!");
                        }
                    }
                break;

                case 3:

                    System.out.println("\n===== MÁSCARAS ARTESANAIS =====");

                    s.nextLine();

                    System.out.print("Digite o material da máscara: ");
                    String material = s.nextLine();

                    System.out.print("Digite a cor da máscara: ");
                    String cor = s.nextLine();

                    System.out.print("Digite o tamanho da máscara: ");
                    String tamanho = s.nextLine();

                    Mascara mascara = new Mascara(material, cor, tamanho);

                    System.out.print("\nDigite o nome do artesão: ");
                    nome = s.nextLine();

                    System.out.print("Digite a especialidade: ");
                    String especialidade = s.nextLine();

                    System.out.print("Digite os anos de experiência: ");
                    int experiencia = s.nextInt();

                    Artesao artesao = new Artesao(
                            nome,
                            especialidade,
                            experiencia
                    );

                    s.nextLine();

                    System.out.print("\nDigite o nome da coleção: ");
                    String nomeColecao = s.nextLine();

                    System.out.print("Digite a quantidade de máscaras: ");
                    int quantidade = s.nextInt();

                    s.nextLine();

                    System.out.print("Digite a origem da coleção: ");
                    String origem = s.nextLine();

                    Colecao colecao = new Colecao(
                            nomeColecao,
                            quantidade,
                            origem
                    );

                    // TESTANDO OS MÉTODOS

                    System.out.println("\n===== RESULTADOS =====");

                    artesao.exibirDados();
                    artesao.fabricarMascara();
                    artesao.pintarMascara();

                    System.out.println();

                    mascara.exibirMascara();
                    mascara.pintar();
                    mascara.exibirMascara();
                    mascara.restaurar();

                    System.out.println();

                    colecao.exibirColecao();
                    colecao.adicionarMascara();
                    colecao.exibirColecao();

                    s.nextLine();
                    IO.println("\nPRESSIONE ENTER PARA VOLTAR AO MENU!");
                    s.nextLine();

                break;

                case 4:

                    System.out.println("\n===== SALÃO DE BELEZA =====");

                    s.nextLine();

                    // =========================
                    // DADOS DA PESSOA
                    // =========================

                    System.out.print("Digite o nome da pessoa: ");
                    String nomePessoa = s.nextLine();

                    System.out.print("Digite a idade: ");
                    int idadePessoa = s.nextInt();

                    s.nextLine();

                    System.out.print("Digite o estilo do cabelo: ");
                    String estiloPessoa = s.nextLine();

                    Pessoa pessoa = new Pessoa(
                            nomePessoa,
                            idadePessoa,
                            estiloPessoa
                    );

                    // =========================
                    // DADOS DO CABELO
                    // =========================

                    System.out.print("\nDigite o tipo do cabelo: ");
                    String tipoCabelo = s.nextLine();

                    System.out.print("Digite a cor do cabelo: ");
                    String corCabelo = s.nextLine();

                    System.out.print("Digite o comprimento do cabelo (cm): ");
                    double comprimentoCabelo = s.nextDouble();

                    Cabelo cabelo = new Cabelo(
                            tipoCabelo,
                            corCabelo,
                            comprimentoCabelo
                    );

                    // =========================
                    // DADOS DO CABELEIREIRO
                    // =========================

                    s.nextLine();

                    System.out.print("\nDigite o nome do cabeleireiro: ");
                    String nomeCabeleireiro = s.nextLine();

                    System.out.print("Digite os anos de experiência: ");
                    int experienciaCabeleireiro = s.nextInt();

                    s.nextLine();

                    System.out.print("Digite a especialidade: ");
                    String especialidadeCabeleireiro = s.nextLine();

                    Cabeleireiro cabeleireiro = new Cabeleireiro(
                            nomeCabeleireiro,
                            experienciaCabeleireiro,
                            especialidadeCabeleireiro
                    );

                    // =========================
                    // TESTANDO OS MÉTODOS
                    // =========================

                    System.out.println("\n===== PESSOA =====");

                    pessoa.exibirDados();
                    pessoa.escolherEstilo();
                    pessoa.mudarEstilo();

                    System.out.println("\n===== CABELO =====");

                    System.out.println("Tipo: " + cabelo.getTipo());
                    System.out.println("Cor: " + cabelo.getCor());
                    System.out.println("Comprimento: "
                            + cabelo.getComprimento() + " cm");

                    cabelo.cortar();
                    cabelo.pintar();
                    cabelo.pentear();

                    System.out.println("\n===== CABELEIREIRO =====");

                    System.out.println("Nome: " + cabeleireiro.getNome());
                    System.out.println("Experiência: "
                            + cabeleireiro.getExperiencia() + " anos");
                    System.out.println("Especialidade: "
                            + cabeleireiro.getEspecialidade());

                    cabeleireiro.cortarCabelo();
                    cabeleireiro.pintarCabelo();
                    cabeleireiro.fazerPenteado();

                    System.out.println();

                    s.nextLine();
                    IO.println("PRESSIONE ENTER PARA VOLTAR AO MENU!");
                    s.nextLine();

                    break;

            }
        }
    }
}