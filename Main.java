import java.util.Calendar;
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

                    System.out.print("Escreva o ano do gasto: ");
                    int ano = l.nextInt();
                    System.out.print("Escreva o mês do gasto: ");
                    int mes = l.nextInt();
                    System.out.print("Escreva o dia do gasto: ");
                    int dia = l.nextInt();
                    Calendar data = Calendar.getInstance();
                    data.set(Calendar.YEAR, ano);
                    data.set(Calendar.MONTH, mes);
                    data.set(Calendar.DAY_OF_MONTH, dia);

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

                    System.out.print("Escreva o ano do ganho: ");
                    int ano = l.nextInt();
                    System.out.print("Escreva o mês do ganho: ");
                    int mes = l.nextInt();
                    System.out.print("Escreva o dia do ganho: ");
                    int dia = l.nextInt();
                    Calendar data = Calendar.getInstance();
                    data.set(Calendar.YEAR, ano);
                    data.set(Calendar.MONTH, mes);
                    data.set(Calendar.DAY_OF_MONTH, dia);

                    System.out.print("Escreva o valor do ganho: ");
                    double valor = l.nextDouble();

                    ganhos.add(new Ganho(
                            tipo,
                            nome,
                            data,
                            valor));
                }
            } else if (opt == 3) {
                System.out.printf("%30s | %25s | %15s | %20s | %7s\n",
                        "Gasto", "Tipo", "Data",
                        "Forma de Pagamento",
                        "Valor");
                for (Gasto g : gastos) {
                    g.relatorio();
                }
                System.out.println("");
                System.out.println("Aperte qualquer tecla para voltar...");
                Scanner l = new Scanner(System.in);
                l.nextLine();
            } else if (opt == 4) {
                System.out.printf("%30s | %25s | %15s | %7s \n", "Gasto", "Tipo", "Data", "Valor");
                for (Ganho g : ganhos) {
                    g.relatorio();
                }
                System.out.println("");
                System.out.println("Aperte qualquer tecla para voltar...");
                Scanner l = new Scanner(System.in);
                l.nextLine();
            } else if (opt == 5) {
                Scanner l = new Scanner(System.in);
                double totalGasto = 0;
                double totalGanho = 0;
                System.out.print("Selecione o ano: ");
                int ano = l.nextInt();
                System.out.print("Selecione o mês: ");
                int mes = l.nextInt();

                Calendar data = Calendar.getInstance();
                data.set(Calendar.YEAR, ano);
                data.set(Calendar.MONTH, mes);
                String mesSelecionado = data.get(Calendar.YEAR) + "/" + data.get(Calendar.MONTH);

                for (Gasto g : gastos) {
                    if (data.get(Calendar.YEAR) == g.data.get(Calendar.YEAR) &&
                            data.get(Calendar.MONTH) == g.data.get(Calendar.MONTH)) {
                        totalGasto += g.valor;
                    }
                }

                for (Ganho g : ganhos) {
                    if (data.get(Calendar.YEAR) == g.data.get(Calendar.YEAR) &&
                            data.get(Calendar.MONTH) == g.data.get(Calendar.MONTH)) {
                        totalGanho += g.valor;
                    }
                }
                System.out.println("");
                System.out.println(mesSelecionado);
                System.out.println("Ganho total: R$" + totalGanho);
                System.out.println("Gasto total: R$" + totalGasto);
                System.out.println("Saldo: R$" + (totalGanho - totalGasto));

                System.out.println("");
                System.out.println("Aperte qualquer tecla para voltar...");
                Scanner l2 = new Scanner(System.in);
                l2.nextLine();
            }
        }

        // leitor.close();
    }
}