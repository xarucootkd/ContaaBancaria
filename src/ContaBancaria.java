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
//        double enviarValor = entradaUser.nextDouble();
//        double receberValor = entradaUser.nextDouble();


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

        if (escolhaUser == 1) {
            System.out.printf("""
                    *************************************
                      Seu saldo atual é de: R$ %.2f
                    *************************************
                    """, saldo);
        }

    }

}
