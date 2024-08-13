package teste;

import java.util.Scanner;

public class Teste {

    public static void main(String[] args) {
        Contas contas = new Contas();
        contas.id = new int[]{1, 2, 3};
        contas.saldo = new Double[]{1000.50, 1500.75, 2000.00};
        contas.titular = new String[]{"Alice", "Bob", "Charlie"};
        contas.banco = new String[]{"santander", "itau", "caixa"};
        contas.ativo = new Boolean[]{true, false, true};

        Movimentacao movimentacao = new Movimentacao();

        Scanner scan = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("Escolha uma ação digitando o numero apenas:");
            System.out.println(" 1- Transação ");
            System.out.println(" 2- Depósito");
            System.out.println(" 3- Saque");
            System.out.println(" 4- Ver extrato");
            System.out.println(" 5- Sair");

            int acao = scan.nextInt();
            if (acao == 1) {
                try {
                    System.out.println("Escolha o id do pagador:");
                    int id_pagador = scan.nextInt() - 1;
                    System.out.println("Escolha o id do Receptor:");
                    int id_receptor = scan.nextInt() - 1;
                    System.out.println("Digite o valor da transação:");
                    Double transacaoValor = scan.nextDouble();
                    Double saldoPagador = contas.saldo[id_pagador];
                    Double saldoReceptor = contas.saldo[id_receptor];
                    if (saldoPagador < transacaoValor) {
                        System.out.println("Pagador não tem saldo");
                    } else {
                        saldoReceptor += transacaoValor;
                        saldoPagador -= transacaoValor;
                        contas.saldo[id_pagador] = saldoPagador;
                        contas.saldo[id_receptor] = saldoReceptor;
                        movimentacao.adicionarMovimentacao(Double.valueOf(transacaoValor), id_pagador + 1, id_receptor + 1, 1, "2024-08-13");
                        System.out.println("Saldo do receptor agora:" + saldoReceptor);
                        System.out.println("Saldo do pagador agora:" + saldoPagador);
                    }
                } catch (Exception e) {
                    System.out.println("Erro na transação. Verifique os dados inseridos.");
                    scan.nextLine(); // Limpar o buffer do scanner
                }
            } else if (acao == 2) {
                try {
                    System.out.println("Escolha o id da conta que irá receber o depósito:");
                    int id_deposito = scan.nextInt() - 1;
                    System.out.println("Digite o valor do depósito:");
                    Double depositoValor = scan.nextDouble();
                    if (depositoValor < 0) {
                        System.out.println("Valor do depósito não pode ser negativo");
                    } else {
                        Double saldoDeposito = contas.saldo[id_deposito];
                        saldoDeposito += depositoValor;
                        contas.saldo[id_deposito] = saldoDeposito;
                        movimentacao.adicionarMovimentacao(Double.valueOf(depositoValor), 0, id_deposito + 1, 2, "2024-08-13");
                        System.out.println("Saldo da conta agora:" + saldoDeposito);
                    }
                } catch (Exception e) {
                    System.out.println("Erro no depósito. Verifique os dados inseridos.");
                    scan.nextLine(); // Limpar o buffer do scanner
                }
            } else if (acao == 3) {
                try {
                    System.out.println("Escolha o id da conta que irá fazer o saque:");
                    int id_saque = scan.nextInt() - 1;
                    System.out.println("Digite o valor do saque:");
                    Double saqueValor = scan.nextDouble();
                    if (saqueValor < 0) {
                        System.out.println("Valor do saque não pode ser negativo");
                    } else {
                        Double saldoSaque = contas.saldo[id_saque];
                        if (saldoSaque < saqueValor) {
                            System.out.println("Valor do saque não pode ser maior que o valor disponível na conta");
                        } else {
                            saldoSaque -= saqueValor;
                            contas.saldo[id_saque] = saldoSaque;
                            movimentacao.adicionarMovimentacao(Double.valueOf(saqueValor), id_saque + 1, 0, 3, "2024-08-13");
                            System.out.println("Saldo da conta agora:" + saldoSaque);
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Erro no saque. Verifique os dados inseridos.");
                    scan.nextLine(); // Limpar o buffer do scanner
                }
            } else if (acao == 4) {
                System.out.println("Extrato de Movimentações:");
                for (int i = 0; i < movimentacao.tamanho(); i++) {
                    System.out.println("Movimentação " + (i + 1) + ":");
                    System.out.println("Valor: " + movimentacao.exibirValor(i));
                    System.out.println("Pagante ID: " + movimentacao.exibirPagante(i));
                    System.out.println("Receptor ID: " + movimentacao.exibirReceptor(i));
                    System.out.println("Tipo: " + movimentacao.exibirTipoMovimentacao(i));
                    System.out.println("Data: " + movimentacao.exibirData(i));
                    System.out.println("------------------------");
                }
            } else if (acao == 5) {
                continuar = false;
                System.out.println("Encerrando o programa...");
            } else {
                System.out.println("Escolha um valor válido");
            }
        }
        scan.close();
    }
}
