/*
    Banco X17
    CONTA BANCARIA

    FUNCIONALIDADES:

    - Dados da conta
    - Consultar Saldo
    - Enviar Valor
    - Receber Valor
    - Sair do app

 */

import java.util.Scanner;

public class ContaBancaria {

    public static void main(String[] args) {

        Scanner entradaUser = new Scanner(System.in);

        double saldo = 3000;
                
        System.out.printf("""
                ***********************
                       Banco SHD
                
                Dados iniciais do cliente:
                
                Nome: Paulo Pantoja
                Tipo conta: Corrente
                Saldo: %.2f
                
                ***********************
                """, saldo);

        System.out.println("""
                Operações
                
                1- Consultar saldo
                2- Receber valor
                3- Transferir valor
                4- Sair
                """);

        System.out.print("Digite a opção desejada: ");


        int escolhaUser = entradaUser.nextInt();

        /*
            Funcionalidade CONSULTAR SALDO
         */
        if (escolhaUser == 1) {
            System.out.printf("""
                    *************************************
                      Seu saldo atual é de: R$ %.2f
                    *************************************
                    """, saldo);
        /*
            Funcionalidade RECEBER
         */
        } else if (escolhaUser == 2 ) {
            System.out.printf("Digite o valor para deposito:  %n");
            double valorReceber = entradaUser.nextDouble();
            saldo = saldo + valorReceber;
            System.out.println("Deposito feito com sucesso");
            System.out.println(saldo);

        /*
            Funcionalidade TRANSFERIR
         */
        } else if (escolhaUser == 3) {
            System.out.printf("Digite o valor para transferência:  %n");
            double valorTransferir = entradaUser.nextDouble();
            saldo = saldo - valorTransferir;

            if (saldo < 0) {
                System.out.println("Transferência não realizada, saldo insuficiente.");
            } else {
                System.out.println("Transferência realizada com sucesso.");
                System.out.println(saldo);
//                System.out.println("Deseja realizar outra operação? (s/n)"); Irei Adicionar quando colocar o laço While

            }
        }

    }

}
