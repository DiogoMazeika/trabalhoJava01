import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Gasto> gastos = new ArrayList<Gasto>();
    static ArrayList<Ganho> ganhos = new ArrayList<Ganho>();

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
                int tipo = Gasto.addGasto();
                if (tipo >= 0) {
                    Scanner l = new Scanner(System.in);

                    System.out.print("Escreva o nome para o gasto: ");
                    String nome = l.next();
                    System.out.print("Escreva a data do gasto: ");
                    String data = l.next();
                    System.out.print("Escreva o valor do gasto: ");
                    double valor = l.nextDouble();
                    System.out.print("Escreva a forma de pagamento do gasto: ");
                    String formaPagamento = l.next();

                    gastos.add(new Gasto(
                            tipo,
                            nome,
                            data,
                            valor,
                            formaPagamento));
                }
            } else if (opt == 2) {
                int tipo = Ganho.addGanho();
                if (tipo >= 0) {
                    Scanner l = new Scanner(System.in);

                    System.out.print("Escreva o nome para o ganho: ");
                    String nome = l.next();
                    System.out.print("Escreva a data do ganho: ");
                    String data = l.next();
                    System.out.print("Escreva o valor do ganho: ");
                    double valor = l.nextDouble();

                    ganhos.add(new Ganho(
                            tipo,
                            nome,
                            data,
                            valor));
                }
            } else if (opt == 3) {
                System.out.printf("%30s | %25s | %15s | %7s | %20s\n", "Gasto", "Tipo", "Data", "Valor",
                        "Forma de Pagamento");
                for (Gasto g : gastos) {
                    g.relatorio();
                }
                System.out.println("");
                System.out.println("Aperte qualquer tecla para voltar...");
                Scanner l = new Scanner(System.in);
                l.nextLine();
            } else {// if (opt == 4) {
                System.out.printf("%30s | %25s | %15s | %7s \n", "Gasto", "Tipo", "Data", "Valor");
                for (Ganho g : ganhos) {
                    g.relatorio();
                }
                System.out.println("");
                System.out.println("Aperte qualquer tecla para voltar...");
                Scanner l = new Scanner(System.in);
                l.nextLine();
            }
        }

        // leitor.close();
    }
}