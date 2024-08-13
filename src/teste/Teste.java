/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;
import java.util.Scanner;

/**
 *
 * @author si
 */
public class Teste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Contas contas = new Contas();
        contas.id = new int[] {1, 2, 3};
        contas.saldo = new Double[] {1000.50 ,1500.75, 2000.00};
        contas.titular = new String[] {"Alice", "Bob", "Charlie"};
        contas.banco = new String[] {"Banco A", "Banco B", "Banco C"};
        contas.ativo = new Boolean[] {true, false, true};
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Escolha uma ação digitando o numero apenas:");
        System.out.println("1- transação ");
        System.out.println(" 2- ver estrato ");
        System.out.println(" 3- Deposito");
        System.out.println(" 3- Saque");
        int acao = scan.nextInt();
        if (acao == 1) {
            System.out.println("Escolha o id do pagador:");
            int id_pagador = scan.nextInt();
            System.out.println("Escolha o id do Receptor:");
            int id_receptor = scan.nextInt(); 
            System.out.println("Digite o valor da transação:");
            Double transacaoValor = scan.nextDouble();  
            Double saldoPagador = contas.saldo[id_pagador];      
            Double saldoReceptor = contas.saldo[id_receptor];      
            if ( saldoPagador <= transacaoValor) {
                System.out.println("Pagador não tem saldo");
            } if (saldoPagador >= transacaoValor) {
                saldoReceptor += transacaoValor;
                System.out.println("Saldo agora:" + saldoReceptor); 
            } else {
                System.out.println("Erro Geral");
            }

        } if (acao == 2) {
            System.out.println("isso2");
        } else {
            System.out.println("Escolha um valor valido");
        }
    }
    
}
