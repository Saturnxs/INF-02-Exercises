import java.io.*;

public class primo {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static void main(String[] args) throws Exception {
        int divisor = 2;
        boolean bandera = true;
        int numero = 0;

        out.print("Ingrese el número: ");
        numero = Integer.parseInt(in.readLine());

        while((bandera == true) && (divisor < numero))
        {
            if ((numero % divisor) == 0) {
                bandera = false;
            } else {
                divisor++;
            }
        }

        if (bandera == true) {
            out.println("Es primo");
        } else {
            out.println("No es primo");
        }
    }
}
