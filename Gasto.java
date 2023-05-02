import java.util.ArrayList;
import java.util.Scanner;

public class Gasto {
    String nome;
    static ArrayList<String> tipo = new ArrayList<String>();
    String data;
    double valor;
    String formaPagamento;

    public static void addGasto() {
        Scanner l = new Scanner(System.in);
        String separador = "-------------------";

        System.out.println("Adicionar gasto");
        System.out.println(separador);
        System.out.println("1 - *Cadastrar novo tipo de gasto*");
        for (String t : tipo) {
            System.out.println((tipo.indexOf(t) + 2) + " - " + t);
        }
        System.out.print("- ");

        int opt = l.nextInt();
        if (opt == 1) {
            System.out.println("");
            System.out.print("Escreva o nome para o novo tipo de gasto: ");
            tipo.add(l.next());
        }

        // l.close();
    }
}