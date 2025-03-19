package br.senai.lab365.futurodev.caixaeletronico.repositories;

import br.senai.lab365.futurodev.caixaeletronico.models.Conta;
import java.util.ArrayList;
import java.util.List;

/**
 * Repositório responsável por gerenciar o armazenamento e busca de contas.
 * Utiliza uma lista estática em memória como simulação de um banco de dados.
 */
public class ContaRepository {
    // Lista estática que armazena todas as contas criadas
    public static final List<Conta> CONTAS = new ArrayList<>();

    /**
     * Salva uma nova conta no repositório, atribuindo um número único.
     * @param novaConta A conta a ser salva
     */
    public void salvar(Conta novaConta) {
        novaConta.setNumeroConta(CONTAS.size() + 1); // Gera um número sequencial
        CONTAS.add(novaConta);
    }

    /**
     * Busca uma conta pelo número da conta.
     * @param numeroConta O número da conta a ser buscada
     * @return A conta correspondente ou null se não encontrada
     */
    public Conta buscar(int numeroConta) {
        for (Conta conta : CONTAS) {
            if (numeroConta == conta.getNumeroConta()) {
                return conta;
            }
        }
        return null; // Retorna null se a conta não for encontrada
    }
}