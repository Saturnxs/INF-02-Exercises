import java.io.*;

public class Ejercicio_2_CalcularKM {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static void main(String[] args) throws IOException {
        int kmInicial;
        int kmFinal;
        int kmTotales;

        out.print("Digite el KM Inicial: ");
        kmInicial = Integer.parseInt(in.readLine());

        out.print("Digite el KM Final: ");
        kmFinal = Integer.parseInt(in.readLine());

        kmTotales = kmFinal - kmInicial;

        out.println("El total de KM es de: " + kmTotales);

    }
}