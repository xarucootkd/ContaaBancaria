/*
    Banco X17
    CONTA BANCARIA

    FUNCIONALIDADES:

    - Consultar Saldo
    - Enviar Valor
    - Receber Valor
    - Sair do app

 */

import java.util.Scanner;

public class ContaBancaria {
//    Função para "limpar" a tela
    public static void clearScreen() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Scanner entradaUser = new Scanner(System.in);

        double saldo = 3000; // Saldo Inicial

        while (true) {
            System.out.printf("""
                    ***********************
                           Banco X17
                    
                    Dados iniciais do cliente:
                    
                    Nome: Paulo Pantoja
                    Tipo conta: Corrente
                    Saldo: %.2f
                    
                    ***********************
                    """, saldo);

            System.out.println("""
                    Operações
                    
                    1- Receber valor
                    2- Transferir valor
                    3- Sair
                    """);

            System.out.print("Digite a opção desejada (1, 2 ou 3): ");


            int escolhaUser = entradaUser.nextInt();

            /*
                Funcionalidade RECEBER
             */
            if (escolhaUser == 1) {
                System.out.printf("Digite o valor para deposito:  %n");
                double valorReceber = entradaUser.nextDouble();
                saldo += valorReceber;
                System.out.println("Deposito feito com sucesso");

            /*
                Funcionalidade TRANSFERIR
             */
            } else if (escolhaUser == 2) {
                System.out.printf("Digite o valor para transferência:  %n");
                double valorTransferir = entradaUser.nextDouble();

                if (saldo < valorTransferir) {
                    System.out.println("Transferência não realizada, saldo insuficiente.");
                } else {
                    saldo -= valorTransferir;
                    System.out.println("Transferência realizada com sucesso.");

                }
            } else if (escolhaUser == 3) {
                System.out.println("Saindo...");
                break;
            } else {
                System.out.printf("Digite uma opção válida.%n%n");
            }


            System.out.println("Deseja realizar outra operação? (s/n)");
            entradaUser.nextLine(); // Consumindo a quebra de linha
            String decisaoUser = entradaUser.nextLine();
            if (!decisaoUser.equals("s")) {
                break;
            } else {

                System.out.println("Voltando para o inicio...");
                clearScreen(); // utilizando para limpar quando voltar ao inicio

            }
        }
    }
}
