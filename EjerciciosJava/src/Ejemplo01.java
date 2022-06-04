import java.io.*;

public class Ejemplo01 {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static void main(String[] args) throws Exception {

        int numero01 = 100;
        int numoer02 = 200;
        int resultado = numero01 * numoer02;

        String nombreCompleto = "Thomas E. Bermúdez Mora";
        String alias = "Thom";

        out.println("Nombre: " + nombreCompleto + " Alias: " + alias);

        out.println(resultado);

    }
}
