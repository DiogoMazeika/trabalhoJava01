import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Ganho {
    static ArrayList<String> tipos = new ArrayList<String>();
    String tipo;
    String nome;
    Calendar data;
    double valor;

    public Ganho(
            int tipo,
            String nome,
            Calendar data,
            double valor) {
        this.tipo = Ganho.tipos.get(tipo);
        this.nome = nome;
        this.data = data;
        this.valor = valor;
    }

    public static int addGanho() {
        Scanner l = new Scanner(System.in);

        System.out.println("Adicionar ganho");
        System.out.println("-------------------");
        System.out.println("1 - *Cadastrar novo tipo de ganho*");
        for (String t : tipos) {
            System.out.println((tipos.indexOf(t) + 2) + " - " + t);
        }
        System.out.print("- ");

        int opt = l.nextInt();
        if (opt == 1) {
            System.out.println("");
            System.out.print("Escreva o nome para o novo tipo de ganho: ");
            tipos.add(l.next());
            return -1;
        } else if ((opt - 2) <= tipos.size()) {
            return opt - 2;
        } else {
            return -1;
        }
        // l.close();
    }

    public void relatorio() {
        System.out.printf("%30s | %25s | %15s | %5.2f\n", nome, tipo,
                data.get(Calendar.DAY_OF_MONTH) + "/" + data.get(Calendar.MONTH) + "/" + data.get(Calendar.YEAR),
                valor);
    }
}