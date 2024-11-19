import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        String nomeCliente = "Marcelo H";
        String tipoConta = "Conta Corrente";
        double saldo = 1000.0;
        
        System.out.println("********************************************************");
        System.out.println("\nNome do Cliente   : " + nomeCliente);
        System.out.println("Tipo de conta     : " + tipoConta);
        System.out.println("Saldo Atual       : R$ " + saldo);
        System.out.println("\n********************************************************");
        
        int opcao = 0;
        while (opcao != 4) {

            System.out.println("\n\nOperações\n\n\n");
            System.out.println("1 - Consultar saldos");
            System.out.println("2 - Receber valor");
            System.out.println("3 - Transferir valor");
            System.out.println("4 - Sair\n\n\n");
            System.out.println("Digite a opcão desejada\n\n");

            opcao = sc.nextInt();
            // pode ser feito com if/else
            switch (opcao) {

                case 1:
                    System.out.println("\nO saldo atualizado é R$" + saldo);
                break;

                case 2:
                    System.out.println("Qual o valor que deseja receber ? ");
                    double valorRecebido = sc.nextDouble();

                    if(valorRecebido > 0){
                        saldo += valorRecebido;
                        System.out.println("Valor recebido com sucesso, -> Saldo atual  " + saldo);
                    } else {
                        System.out.println("Não é possivel receber valores menor que 0");
                    }
                break;

                case 3:
                    System.out.println("Entre com o valor a ser transferido");

                    double valorTransferido = sc.nextDouble();
                    if(valorTransferido <= saldo){
                        saldo -= valorTransferido;
                        System.out.println("Valor transferido com sucesso -> Saldo atual  " + saldo);
                    } else {
                        System.out.println("Não há saldo para realizar a transferencia.");
                    }
                break;

                case 4:
                    System.out.println("Bye - Até a proxima!");
                break;
            
                default:
                    System.out.println("Opção inválida");
                break;
            }

        }
        sc.close();
    }
}
