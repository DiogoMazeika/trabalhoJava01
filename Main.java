import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner leitor = new Scanner(System.in);
        int opt = 0;

        while (opt != 6) {
            System.out.println(" Gestão financeira");
            System.out.println("-------------------");
            System.out.println("Escolha:");
            System.out.println("1 - Adicionar Gasto");
            System.out.println("2 - Adicionar Ganho");
            System.out.println("3 - Relatório de Gastos");
            System.out.println("4 - Relatório de Ganhos");
            System.out.println("5 - Relatório Mensal");
            System.out.println("6 - Sair");
            System.out.print("- ");

            opt = leitor.nextInt();
            System.out.println("");
            if (opt == 1) {
                Gasto.addGasto();
            }
            opt = 0;

        }

        // leitor.close();
    }
}