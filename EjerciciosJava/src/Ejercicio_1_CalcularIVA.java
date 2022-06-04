import java.io.*;

public class Ejercicio_1_CalcularIVA {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static void main(String[] args) throws IOException {
        String nombreProducto;
        double precioProducto;
        double precioProductoFinal;

        out.println("Digite el nombre del producto: ");
        nombreProducto = in.readLine();

        out.println("Digite el precio del producto: ");
        precioProducto = Double.parseDouble(in.readLine());

        precioProductoFinal = precioProducto * 0.13;

        out.println(nombreProducto + " tiene un precio final de " + precioProductoFinal + " colones.");

    }
}