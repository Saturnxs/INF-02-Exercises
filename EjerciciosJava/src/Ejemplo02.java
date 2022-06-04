import java.io.*;

public class Ejemplo02 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static void main(String[] args) {
        int dividendo = 1;
        int divisor = 3;
        int resultado = (dividendo / divisor) * 10;

        double dividendo2 = 1;
        double divisor2 = 3;
        double resultado2 = (dividendo2 / divisor2) * 10;

        out.println((resultado));
        out.println((resultado2));

    }
}
