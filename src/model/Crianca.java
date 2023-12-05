package model;

import java.util.Scanner;

public class Crianca {

    private static final int NUM_VACINAS = 23;

    private String nome;
    private String dataNascimento;
    private String municipioNascimento;
    private String nomeMae;
    private String nomePai;
    private String telefoneResponsavel;
    private String etnia;
    private Endereco endereco;
    private String[] vacinas;

    public Crianca(String nome, String dataNascimento, String municipioNascimento, String nomeMae, String nomePai,
            String telefoneResponsavel, String etnia) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.municipioNascimento = municipioNascimento;
        this.nomeMae = nomeMae;
        this.nomePai = nomePai;
        this.telefoneResponsavel = telefoneResponsavel;
        this.etnia = etnia;
        this.endereco = null;

        this.vacinas = new String[NUM_VACINAS];
        for (int i = 0; i < NUM_VACINAS; i++) {
            this.vacinas[i] = "Não tomada";
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getMunicipioNascimento() {
        return municipioNascimento;
    }

    public void setMunicipioNascimento(String municipioNascimento) {
        this.municipioNascimento = municipioNascimento;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public String getTelefoneResponsavel() {
        return telefoneResponsavel;
    }

    public void setTelefoneResponsavel(String telefoneResponsavel) {
        this.telefoneResponsavel = telefoneResponsavel;
    }

    public String getEtnia() {
        return etnia;
    }

    public void setEtnia(String etnia) {
        this.etnia = etnia;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String[] getVacinas() {
        return vacinas;
    }

    public void setVacinas(String[] vacinas) {
        this.vacinas = vacinas;
    }

    //Função que faz o registro da vacina com base nos meses da criança
    public void registrarVacinas(int idade, Scanner scanner) {
        for (int i = 0; i < vacinas.length; i++) {
            vacinas[i] = "Não tomada";
        }

        if (idade >= 0) {
            vacinas[0] = perguntarVacina(scanner, "BCG");
            vacinas[1] = perguntarVacina(scanner, "Hepatite B");
        }
        if (idade >= 2) {
            vacinas[2] = perguntarVacina(scanner, "Poliomielite 1ª dose");
            vacinas[3] = perguntarVacina(scanner, "Pneumocócica 10-valente 1ª dose");
            vacinas[4] = perguntarVacina(scanner, "Rotavírus humano G1P1 1ª dose");
            vacinas[5] = perguntarVacina(scanner, "Penta 1ª dose ");
        }
        if (idade >= 3) {
            vacinas[6] = perguntarVacina(scanner, "Meningocócica C 1ª dose");
        }
        if (idade >= 4) {
            vacinas[7] = perguntarVacina(scanner, "Poliomielite 2ª dose");
            vacinas[8] = perguntarVacina(scanner, "Pneumocócica 10-valente 2ª dose");
            vacinas[9] = perguntarVacina(scanner, "Rotavírus humano G1P1 2ª dose");
            vacinas[10] = perguntarVacina(scanner, "Penta 2ª dose");
        }
        if (idade >= 5) {
            vacinas[11] = perguntarVacina(scanner, "Meningocócica C 2ª dose");
        }
        if (idade >= 6) {
            vacinas[12] = perguntarVacina(scanner, "Penta 3ª dose");
            vacinas[13] = perguntarVacina(scanner, "Poliomielite 3ª dose");
            vacinas[14] = perguntarVacina(scanner, "Influenza");
        }
        if (idade >= 9) {
            vacinas[15] = perguntarVacina(scanner, "Febre amarela");
        }
        if (idade >= 12) {
            vacinas[16] = perguntarVacina(scanner, "Pneumocócica 10-valente Reforço");
            vacinas[17] = perguntarVacina(scanner, "Meningocócica C Reforço");
            vacinas[18] = perguntarVacina(scanner, "Tríplice viral 1ª dose");
        }
        if (idade >= 15) {
            vacinas[19] = perguntarVacina(scanner, "DTP 1º reforço");
            vacinas[20] = perguntarVacina(scanner, "Poliomielite 1º reforço");
            vacinas[21] = perguntarVacina(scanner, "Hepatite A");
            vacinas[22] = perguntarVacina(scanner, "Tetraviral");
        }
        
    }

    //Função que faz a pergunta sobre qual vacina a criança tomou ou não
    private static String perguntarVacina(Scanner scanner, String nomeVacina) {
        System.out.print("A criança tomou a vacina " + nomeVacina + "? (Digite 'sim' ou 'nao'): ");
        String resposta = scanner.nextLine().toLowerCase();
        return resposta.equals("sim") ? "Tomada" : "Não tomada";
    }

    //Função que retorna o nome das vacinas
    public String obterNomeVacina(int indiceVacina) {
        switch (indiceVacina) {
            case 0:
                return "BCG";
            case 1:
                return "Hepatite B";
            case 2:
                return "Poliomielite 1ª dose";
            case 3:
                return "Pneumocócica 10-valente 1ª dose";
            case 4:
                return "Rotavírus humano G1P1 1ª dose";
            case 5:
                return "Penta 1ª dose";
            case 6:
                return "Meningocócica C 1ª dose";
            case 7:
                return "Poliomielite 2ª dose";
            case 8:
                return "Pneumocócica 10-valente 2ª dose";
            case 9:
                return "Rotavírus humano G1P1 2ª dose";
            case 10:
                return "Penta 2ª dose";
            case 11:
                return "Meningocócica C 2ª dose";
            case 12:
                return "Penta 3ª dose";
            case 13:
                return "Poliomielite 3ª dose";
            case 14:
                return "Influenza";
            case 15:
                return "Febre amarela";
            case 16:
                return "Pneumocócica 10-valente Reforço";
            case 17:
                return "Meningocócica C Reforço";
            case 18:
                return "Tríplice viral 1ª dose";
            case 19:
                return "DTP 1º reforço";
            case 20:
                return "Poliomielite 1º reforço";
            case 21:
                return "Hepatite A";
            case 22:
                return "Tetraviral";
            default:
                return "Vacina " + (indiceVacina + 1);
        }
    }

}
