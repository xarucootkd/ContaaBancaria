package modelos;
 public class Conta {

    private String nome;
    private int tipoConta;
    private boolean ativoConta = true;
    private double saldo = 3000;


    public void exibirDadosConta() {
        System.out.printf("""
                    ***********************
                           Banco X17
                    
                    Dados do cliente:
                    
                    Nome: %s
                    Tipo conta: %s
                    Saldo: %.2f
                    Ativo: %s
                    
                    ***********************
                    """, nome, getTipoConta(), saldo, isAtivo());
    }

    public void exibirOpcoes() {
        System.out.println("""
                    Operações:

                    1- Receber valor
                    2- Transferir valor
                    3- Ativar / Desativar
                    4- Sair
                    """);
        System.out.print("Digite a opção desejada (1, 2 ou 3): ");
    }

    public void exibirTipoConta() {
        System.out.println("""
                    Tipo de Conta
                    
                    Opções:

                    1- Corrente
                    2- Salário
                    """);
        System.out.print("Digite a opção desejada (1 ou 2): ");
    }

     public String getTipoConta() {
         return tipoContaUser(tipoConta);
     }

    public boolean getAtivo(){
        return ativoConta;
    }

     public String isAtivo() {
        if (ativoConta) {
            return "Sim";
        } else {
            return "Não";
        }
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTipoConta(int tipoConta) {
        this.tipoConta = tipoConta;
    }



    public void depositar(double valorDepositar) {
        saldo += valorDepositar;
    }

    public void transferir(double valorTransferir) {
        if (saldo < valorTransferir) {
            System.out.println("Transferência não realizada, saldo insuficiente.");
        } else {
            saldo -= valorTransferir;
            System.out.println("Transferência realizada com sucesso.");
        }

    }

    public void trocarAtivo() {
        this.ativoConta = !this.ativoConta;

        if (ativoConta){
            System.out.println("Conta Ativada");
        } else {
            System.out.println("Conta Desativada");
        }
    }

     public String tipoContaUser (int escolhaContaUser) {
            String tipoContaUser;

            if (escolhaContaUser == 1) {
                tipoContaUser = "Corrente";
                return (tipoContaUser);
            } else if (escolhaContaUser == 2) {
                tipoContaUser = "Salário";
                return (tipoContaUser);
            } else {
                return "Digite uma opção válida. ";
            }
        }

        public void desativadoMensagem () {
                System.out.println("Ative sua conta para realizar essa ação.");
        }

}
