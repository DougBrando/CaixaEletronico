package br.senai.lab365.futurodev.caixaeletronico.main;

import br.senai.lab365.futurodev.caixaeletronico.models.Cliente;
import br.senai.lab365.futurodev.caixaeletronico.models.Conta;
import br.senai.lab365.futurodev.caixaeletronico.repositories.ContaRepository;
import java.util.Scanner;

/**
 * Classe principal que implementa a interface de um caixa eletrônico simples.
 * Permite ao usuário realizar operações como criar conta, depositar, sacar, transferir e consultar saldo.
 */
public class Main {
    public static void main(String[] args) {
        // Inicializa o repositório de contas e o scanner para entrada de dados
        ContaRepository contaRepository = new ContaRepository();
        Scanner entrada = new Scanner(System.in);

        System.out.println("Bem vindo ao Caixa Eletrônico!");
        int operacao;

        // Loop principal do menu, executa até o usuário escolher sair (opção 0)
        do {
            System.out.printf("""
                    Escolha uma operação: 
                    1 - Criar conta 
                    2 - Depositar 
                    3 - Sacar 
                    4 - Transferir 
                    5 - Ver Saldo 
                    0 - Sair
                    """);
            operacao = entrada.nextInt();
            entrada.nextLine(); // Limpa o buffer após leitura de inteiro

            // Switch para direcionar a operação escolhida
            switch (operacao) {
                case 1 -> operacaoCadastraConta(entrada, contaRepository);
                case 2 -> operacaoDeposito(entrada, contaRepository);
                case 3 -> operacaoSaque(entrada, contaRepository);
                case 4 -> operacaoTransferencia(entrada, contaRepository);
                case 5 -> operacaoConsultarSaldo(entrada, contaRepository);
                case 0 -> System.out.println("Encerrando a sessão...");
                default -> System.out.println("Selecione uma opção válida.");
            }
        } while (operacao != 0);

        entrada.close(); // Fecha o Scanner para liberar recursos
    }

    /**
     * Consulta o saldo de uma conta específica.
     * @param entrada Scanner para leitura de entrada do usuário
     * @param contaRepository Repositório de contas para buscar a conta
     */
    private static void operacaoConsultarSaldo(Scanner entrada, ContaRepository contaRepository) {
        System.out.println("Digite o número da conta para consultar o saldo: ");
        int numeroConta = entrada.nextInt();
        Conta conta = contaRepository.buscar(numeroConta);
        if (conta != null) {
            System.out.printf("Saldo disponível na conta %d: R$%.2f %n",
                    conta.getNumeroConta(), conta.getSaldo());
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    /**
     * Realiza uma transferência entre duas contas.
     * @param entrada Scanner para leitura de entrada do usuário
     * @param contaRepository Repositório de contas para buscar as contas origem e destino
     */
    private static void operacaoTransferencia(Scanner entrada, ContaRepository contaRepository) {
        System.out.println("Digite a conta origem:");
        int numeroContaOrigem = entrada.nextInt();
        Conta contaOrigem = contaRepository.buscar(numeroContaOrigem);
        if (contaOrigem == null) {
            System.out.println("Conta origem não encontrada.");
            return;
        }

        System.out.println("Digite a conta destino:");
        int numeroContaDestino = entrada.nextInt();
        Conta contaDestino = contaRepository.buscar(numeroContaDestino);
        if (contaDestino == null) {
            System.out.println("Conta destino não encontrada.");
            return;
        }

        System.out.println("Insira o valor para transferir:");
        double valorTransferencia = entrada.nextDouble();
        contaOrigem.transferir(contaDestino, valorTransferencia);
    }

    /**
     * Realiza um saque em uma conta específica.
     * @param entrada Scanner para leitura de entrada do usuário
     * @param contaRepository Repositório de contas para buscar a conta
     */
    private static void operacaoSaque(Scanner entrada, ContaRepository contaRepository) {
        System.out.println("Digite a conta para o saque:");
        int numeroConta = entrada.nextInt();
        Conta contaSaque = contaRepository.buscar(numeroConta);
        if (contaSaque != null) {
            System.out.println("Insira o valor de saque:");
            double valorSaque = entrada.nextDouble();
            contaSaque.sacar(valorSaque);
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    /**
     * Cadastra uma nova conta com informações do cliente.
     * @param entrada Scanner para leitura de entrada do usuário
     * @param contaRepository Repositório de contas para salvar a nova conta
     */
    public static void operacaoCadastraConta(Scanner entrada, ContaRepository contaRepository) {
        Conta novaConta = new Conta();
        System.out.println("Digite um nome: ");
        String nome = entrada.nextLine();
        System.out.println("Digite um sobrenome: ");
        String sobrenome = entrada.nextLine();
        System.out.println("Digite um CPF: ");
        String cpf = entrada.nextLine();

        Cliente novoCliente = new Cliente(nome, sobrenome, cpf);
        novaConta.setTitular(novoCliente);

        contaRepository.salvar(novaConta);
        System.out.println("Conta cadastrada. Número da conta: " + novaConta.getNumeroConta());
    }

    /**
     * Realiza um depósito em uma conta específica.
     * @param entrada Scanner para leitura de entrada do usuário
     * @param contaRepository Repositório de contas para buscar a conta
     */
    public static void operacaoDeposito(Scanner entrada, ContaRepository contaRepository) {
        System.out.println("Digite a conta para o depósito:");
        int numeroConta = entrada.nextInt();
        Conta contaDeposito = contaRepository.buscar(numeroConta);
        if (contaDeposito != null) {
            System.out.println("Insira o valor de depósito:");
            double valorDeposito = entrada.nextDouble();
            contaDeposito.depositar(valorDeposito);
        } else {
            System.out.println("Conta não encontrada.");
        }
        entrada.nextLine(); // Limpa o buffer após nextDouble
    }
}