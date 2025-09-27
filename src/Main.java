/*
    Banco X17
    CONTA BANCARIA

    FUNCIONALIDADES:

    - Enviar Valor
    - Receber Valor
    - Ativar / Desativar conta
    - Sair do app

 */

import modelos.Conta;
import java.util.Scanner;

public class Main {

//    Função para "limpar" a tela
    public static void limparTela() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Scanner entradaUser = new Scanner(System.in);
        Conta contaUser = new Conta();

        // ESSA PARTE DO CODIGO TA COM BUG
        System.out.println("""
                    ***********************
                           Banco X17
                    ***********************
                    """);
        System.out.println("Nome da conta: ");
        contaUser.setNome(entradaUser.nextLine());
        contaUser.exibirTipoConta();
        contaUser.setTipoConta(entradaUser.nextInt());
        entradaUser.nextLine();


        while (true) {
            contaUser.exibirDadosConta();
            System.out.println("Suas Informções estão corretas? (s / n)");
            String decisaoUser = entradaUser.nextLine();
            entradaUser.nextLine();
            if (decisaoUser.equals("s")) {
                break;
            } else {
                System.out.println("""
                        1- Nome da Conta
                        2- Tipo da Conta
                        3- Continuar
                        
                        Escolha o que deseja alterar:
                        """);
                int escolhaAlterarUser = entradaUser.nextInt();
                if (escolhaAlterarUser == 1) {
                    System.out.println("Digite o nome da Conta:");
                    contaUser.setNome(entradaUser.nextLine());
                } else if (escolhaAlterarUser == 2) {
                    contaUser.exibirTipoConta();
                    contaUser.setTipoConta(entradaUser.nextInt());
                } else {
                    break;
                }

            }
        }

        while (true) {
            contaUser.exibirDadosConta();
            contaUser.exibirOpcoes();

            int escolhaUser = entradaUser.nextInt();

            if (escolhaUser == 1) { //Funcionalidade RECEBER
                System.out.printf("Digite o valor para depositar: %n");
                contaUser.depositar(entradaUser.nextDouble());
                System.out.println("Deposito feito com sucesso");

            } else if (escolhaUser == 2) { //Funcionalidade TRANSFERIR
                System.out.printf("Digite o valor para transferência:  %n");
                contaUser.transferir(entradaUser.nextDouble());

            } else if (escolhaUser == 3) {
                contaUser.trocarAtivo();

            } else if (escolhaUser == 4) { //Funcionalidade Sair
                break;

            } else {
                System.out.printf("Digite uma opção válida.%n%n");
            }

            System.out.println("ENTER para voltar ao inicio.");
            entradaUser.nextLine(); // Consumindo a quebra de linha
            String decisaoUser = entradaUser.nextLine();
            limparTela();

        }
    }

}
