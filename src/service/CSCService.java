package service;

import java.util.Scanner;

import model.Crianca;
import model.Endereco;

public class CSCService {

        private static final int MAX_CRIANCAS = 100;
        private static Crianca[] criancas = new Crianca[MAX_CRIANCAS];
        private static int quantidadeCriancasCadastradas = 0;

        public static Crianca incluirDadosIdentificacao(String nome, String dataNascimento, String municipioNascimento,
                        String nomeMae, String nomePai, String telefoneResponsavel, String etnia) {
                Crianca crianca = new Crianca(nome, dataNascimento, municipioNascimento,
                                nomeMae, nomePai, telefoneResponsavel, etnia);

                criancas[quantidadeCriancasCadastradas++] = crianca;

                return crianca;
        }

        public static void incluirEndereco(int id, String logradouro, String numero, String complemento,
                        String bairro, String cidade, String cep, String estado) {
                if (id > 0 && id <= quantidadeCriancasCadastradas) {

                        Crianca crianca = criancas[id - 1];

                        Endereco endereco = new Endereco(logradouro, numero, complemento, bairro, cidade, cep, estado);

                        crianca.setEndereco(endereco);

                        System.out.println("Endereço adicionado com sucesso.");
                } else {
                        System.out.println("ID de criança inválido.");
                }
        }

        public static void listarDadosCSC() {
                System.out.println("LISTA DE CRIANÇAS CADASTRADAS\n");

                for (int i = 0; i < CSCService.quantidadeCriancasCadastradas; i++) {
                        Crianca crianca = CSCService.criancas[i];

                        System.out.println("ID: " + (i + 1));
                        System.out.println("Nome: " + crianca.getNome());
                        System.out.println("Data Nascimento: " + crianca.getDataNascimento());
                        System.out.println("Município de Nascimento: " + crianca.getMunicipioNascimento());
                        System.out.println("Nome da Mãe: " + crianca.getNomeMae());
                        System.out.println("Nome do Pai: " + crianca.getNomePai());
                        System.out.println("Tel. Responsável: " + crianca.getTelefoneResponsavel());
                        System.out.println("Etnia: " + crianca.getEtnia());

                        if (crianca.getEndereco() != null) {
                                Endereco endereco = crianca.getEndereco();
                                System.out.println("Endereço:");
                                System.out.println("  Logradouro: " + endereco.getLogradouro());
                                System.out.println("  N°: " + endereco.getNumero());
                                System.out.println("  Complemento: " + endereco.getComplemento());
                                System.out.println("  Bairro: " + endereco.getBairro());
                                System.out.println("  Cidade: " + endereco.getCidade());
                                System.out.println("  Cep: " + endereco.getCep());
                                System.out.println("  Estado: " + endereco.getEstado());

                        }

                        System.out.println("Vacinas:");

                        for (int j = 0; j < crianca.getVacinas().length; j++) {
                                String nomeVacina = crianca.obterNomeVacina(j);
                                String statusVacina = crianca.getVacinas()[j].equals("Tomada") ? "Tomada"
                                                : "Não tomada";
                                System.out.printf("| %-50s | %-15s |%n", nomeVacina, statusVacina);
                        }

                        System.out.println(
                                        "-----------------------------------------------------------------------------------------------------------------");
                        System.out.println(); 
                }
        }

        private static boolean idValido(int id) {
                return id >= 1 && id <= criancas.length;
        }

        public static void registrarVacinas(int id, int idade, Scanner scanner) {
                if (idValido(id)) {
                        Crianca crianca = criancas[id - 1];
                        crianca.registrarVacinas(idade, scanner);
                        System.out.println("Registro de vacinas adicionado com sucesso para a criança " + id + ".");
                } else {
                        System.out.println("ID de criança inválido.");
                }
        }
}
