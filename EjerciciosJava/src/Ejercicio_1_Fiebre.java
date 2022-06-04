import java.io.*;

public class Ejercicio_1_Fiebre {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static void main(String[] args) throws Exception {
        Double temperatura;
        String mensaje;

        out.print("Digite su temperatura: ");
        temperatura = Double.parseDouble(in.readLine());
        
        if (temperatura >= 38) {
            mensaje = "Tiene fiebre";
        } else {
            mensaje = "Temperatura normal";
        }
        out.println(mensaje);
    }
}