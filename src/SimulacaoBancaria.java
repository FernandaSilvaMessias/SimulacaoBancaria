
import java.util.Scanner;
public class SimulacaoBancaria {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double saldo = 0;
        boolean continuar = true;

        while (continuar) {
            exibirMenu();
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    saldo = Depositar(scanner, saldo);
                    break;
                case 2:
                    saldo = Sacar(scanner, saldo);
                    break;
                case 3:
                    Consultar(saldo);
                    break;
                case 4:
                    System.out.println("Programa encerrado.");
                    continuar = false;  // Atualiza a variável de controle para encerrar o loop
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println(" ++++++ Escolha a opção desejada ++++++");
        System.out.println(" 1 - ºDepositar");
        System.out.println(" 2 - ºSacar");
        System.out.println(" 3 - ºConsultar Saldo");
        System.out.println(" 4 - ºEncerrar");
    }

    private static double Depositar(Scanner scanner, double saldo) {
        System.out.println(" >>>> Digite o valor a ser depositado <<<< ");
        double valor = scanner.nextDouble();
        saldo = 0;
        if (valor > 0) {
            saldo += valor;
            System.out.println(" >>>> Deposito realizado com sucesso, Saldo atual: R$ " + saldo);
        } else {
            System.out.println(" >>> Valor inválido. O valor depositado deve ser maior que zero <<<< ");
        }
        return saldo;
    }

    private static double Sacar(Scanner scanner, double saldo) {
        System.out.println(" >>>> Digite o valor a ser sacado.");
        System.out.println("Seu saldo é : R$ " + saldo);
        double valor = scanner.nextDouble();
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println(" >>>> saque realizado com  sucesso, seu saldo é: R$ " + saldo);
        } else {
            System.out.println(" >>> Saldo insuficiente no valor informado <<<< ");
        }
        return saldo;
    }

    private static void Consultar(double saldo) {
        System.out.println(" Seu saldo atual é: " + saldo);
    }
}