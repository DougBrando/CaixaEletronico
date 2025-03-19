package br.senai.lab365.futurodev.caixaeletronico.models;

/**
 * Classe que representa um cliente do caixa eletrônico, com nome, sobrenome e CPF.
 */
public class Cliente {
    private String nome;
    private String sobrenome;
    private String cpf;

    /**
     * Construtor com parâmetros para inicializar os dados do cliente.
     * @param nome Nome do cliente
     * @param sobrenome Sobrenome do cliente
     * @param cpf CPF do cliente
     */
    public Cliente(String nome, String sobrenome, String cpf) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
    }

    /**
     * Construtor vazio para permitir instanciação sem dados iniciais.
     */
    public Cliente() {
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}