package br.senai.lab365.futurodev.caixaeletronico.models;

/**
 * Classe que representa uma conta bancária, com titular, saldo e número da conta.
 * Implementa operações básicas como depósito, saque e transferência.
 */
public class Conta {
    private Cliente titular;
    private double saldo;
    private int numeroConta;

    /**
     * Construtor padrão que inicializa o saldo como 0.
     */
    public Conta() {
        this.saldo = 0.0;
    }

    // Getters e Setters
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Cliente getTitular() {
        return titular;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    /**
     * Realiza um depósito na conta, se o valor for positivo.
     * @param valor O valor a ser depositado
     */
    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            System.out.println("Depósito de R$" + valor + " realizado com sucesso!");
        } else {
            System.out.println("Valor inválido para depósito.");
        }
    }

    /**
     * Realiza um saque na conta, se houver saldo suficiente e o valor for válido.
     * @param valor O valor a ser sacado
     * @return true se o saque for bem-sucedido, false caso contrário
     */
    public boolean sacar(double valor) {
        if (this.saldo >= valor && valor > 0) {
            this.saldo -= valor;
            System.out.printf("Saque de R$%.2f realizado com sucesso.%n", valor);
            return true;
        } else {
            System.out.println("Saldo insuficiente ou valor inválido. Saldo disponível: " + this.saldo);
            return false;
        }
    }

    /**
     * Transfere um valor desta conta para outra, se o saque for possível.
     * @param destino A conta de destino da transferência
     * @param valor O valor a ser transferido
     */
    public void transferir(Conta destino, double valor) {
        if (this.sacar(valor)) {
            destino.depositar(valor);
            System.out.printf("Transferência de R$%.2f realizada com sucesso.%n", valor);
        }
    }
}