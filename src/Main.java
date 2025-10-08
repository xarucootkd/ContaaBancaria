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
            limparTela();
            contaUser.exibirDadosConta();
            System.out.println("Suas Informções estão corretas? (s / n)");
            String decisaoUser = entradaUser.nextLine();
            if (decisaoUser.equals("s")) {
                break;
            } else {
                System.out.println("""
                        1- Nome da Conta
                        2- Tipo da Conta
                        3- Continuar
                        
                        Escolha o que deseja alterar:""");
                int escolhaAlterarUser = entradaUser.nextInt();
                entradaUser.nextLine();
                if (escolhaAlterarUser == 1) {
                    System.out.println("Digite o nome da Conta:");
                    contaUser.setNome(entradaUser.nextLine());
                } else if (escolhaAlterarUser == 2) {
                    contaUser.exibirTipoConta();
                    contaUser.setTipoConta(entradaUser.nextInt());
                    entradaUser.nextLine();
                } else {
                    break;
                }

            }
        }

        while (true) {
            contaUser.exibirDadosConta();
            contaUser.exibirOpcoes();

            int escolhaUser = entradaUser.nextInt();
            entradaUser.nextLine();

            if (escolhaUser == 1) { //Funcionalidade RECEBER
                if (contaUser.getAtivo()) {
                    System.out.printf("Digite o valor para depositar: %n");
                    contaUser.depositar(entradaUser.nextDouble());
                    entradaUser.nextLine();
                    System.out.println("Deposito feito com sucesso");
                } else {
                    contaUser.desativadoMensagem();
                }

            } else if (escolhaUser == 2) { //Funcionalidade TRANSFERIR
                if (contaUser.getAtivo()) {
                    if (contaUser.getTipoConta().equals("Salário")) {
                        System.out.println("Seu tipo de conta é apenas para deposito.");
                        System.out.println("Altere seu tipo de conta para poder transfeir");
                    } else {
                        System.out.printf("Digite o valor para transferência:  %n");
                        contaUser.transferir(entradaUser.nextDouble());
                        entradaUser.nextLine();
                    }
                } else {
                    contaUser.desativadoMensagem();
                }

            } else if (escolhaUser == 3) {
                contaUser.trocarAtivo();

            } else if (escolhaUser == 4) { //Funcionalidade Sair
                break;

            } else {
                System.out.printf("Digite uma opção válida.%n%n");
            }

            System.out.println("ENTER para voltar ao inicio.");
            entradaUser.nextLine();
            limparTela();

        }
    }

}
