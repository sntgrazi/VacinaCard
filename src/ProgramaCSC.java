

import java.util.Scanner;
import model.Crianca;
import service.CSCService;

public class ProgramaCSC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int opcao;
        do {
            exibirMenu();
            System.out.print("Escolha a opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    incluirDadosIdentificacao(scanner);
                    break;
                case 2:
                    incluirEndereco(scanner);
                    break;
                case 3:
                    incluirRegistroVacinas(scanner);
                    break;
                case 4:
                    CSCService.listarDadosCSC();
                    break;
                case 5:
                    System.out.println("Saindo do programa. Até mais!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 5);
    }

    //Função para exibir o menu
    private static void exibirMenu() {
        System.out.println("MENU");
        System.out.println("1. Incluir os dados de identificação da criança");
        System.out.println("2. Incluir o endereço da criança");
        System.out.println("3. Incluir o registro das vacinas da criança");
        System.out.println("4. Listar todos os dados da CSC");
        System.out.println("5. Sair do Programa");
    }

    //Função que coleta os dados da criança e manda para o service para salvar os dados
    private static Crianca incluirDadosIdentificacao(Scanner scanner) {
        System.out.print("Digite o nome da criança: ");
        String nome = scanner.nextLine();

        System.out.print("Digite a data de nascimento da criança: ");
        String dataNascimento = scanner.nextLine();

        System.out.print("Digite o município de nascimento da criança: ");
        String municipioNascimento = scanner.nextLine();

        System.out.print("Digite o nome da mãe da criança: ");
        String nomeMae = scanner.nextLine();

        System.out.print("Digite o nome do pai da criança: ");
        String nomePai = scanner.nextLine();

        System.out.print("Digite o telefone do responsável: ");
        String telefoneResponsavel = scanner.nextLine();

        System.out.println("Escolha a etnia da criança:");
        System.out.println("(1) Branca");
        System.out.println("(2) Negra");
        System.out.println("(3) Amarela");
        System.out.println("(4) Parda");
        System.out.println("(5) Indígena");
        int escolhaEtnia = scanner.nextInt();
        scanner.nextLine(); 
        String etnia = obterEtnia(escolhaEtnia);

        return CSCService.incluirDadosIdentificacao(nome, dataNascimento, municipioNascimento,
                nomeMae, nomePai, telefoneResponsavel, etnia);
    }


    //Função que coleta o endereço e manda para o service para salvar
    private static void incluirEndereco(Scanner scanner) {
        System.out.print("Digite o ID da criança: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Digite o logradouro: ");
        String logradouro = scanner.nextLine();

        System.out.print("Digite o número: ");
        String numero = scanner.nextLine();

        System.out.print("Digite o complemento: ");
        String complemento = scanner.nextLine();

        System.out.print("Digite o bairro: ");
        String bairro = scanner.nextLine();

        System.out.print("Digite a cidade: ");
        String cidade = scanner.nextLine();

        System.out.print("Digite o CEP: ");
        String cep = scanner.nextLine();

        System.out.print("Digite o estado: ");
        String estado = scanner.nextLine();

        CSCService.incluirEndereco(id, logradouro, numero, complemento, bairro, cidade, cep, estado);
    }

    //Função que pergunta a quantidade de meses da criança e pergunta com base nos meses as vacinas que a criança tomou
    private static void incluirRegistroVacinas(Scanner scanner) {
        System.out.print("Digite o ID da criança: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Digite a idade da criança (em meses): ");
        int idade = scanner.nextInt();
        scanner.nextLine();

       CSCService.registrarVacinas(id ,idade, scanner);

    }

    //Função que retorna as etnias
    private static String obterEtnia(int escolha) {
        switch (escolha) {
            case 1:
                return "Branca";
            case 2:
                return "Negra";
            case 3:
                return "Amarela";
            case 4:
                return "Parda";
            case 5:
                return "Indígena";
            default:
                return "Não especificada";
        }
    }
}
