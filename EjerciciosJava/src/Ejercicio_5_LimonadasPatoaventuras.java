import java.io.*;

public class Ejercicio_5_LimonadasPatoaventuras {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static void main(String[] args) throws IOException {
        int cantidadLimonadas;
        double utilidad, ingresoTotal, gastoTotal, ganaciaHugo, gananciaPaco, gananciaLuis;

        out.print("Digite la cantidad total de limonadas: ");
        cantidadLimonadas = Integer.parseInt(in.readLine());

        ingresoTotal = cantidadLimonadas * 10;
        gastoTotal = cantidadLimonadas * 5.5;
        utilidad = ingresoTotal - gastoTotal;

        ganaciaHugo = utilidad * 0.4;
        gananciaPaco = utilidad * 0.3;
        gananciaLuis = utilidad * 0.3;

        out.println("Ingreso total: " + ingresoTotal);
        out.println("Gasto total: " + gastoTotal);
        out.println("Utilidad total: " + utilidad);

        out.println("Ganancias: ");
        out.println("Hugo: " + ganaciaHugo);
        out.println("Paco: " + gananciaPaco);
        out.println("Luis: " + gananciaLuis);
    }
}
