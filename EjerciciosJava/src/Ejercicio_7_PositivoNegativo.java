import java.io.*;

public class Ejercicio_7_PositivoNegativo {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static void main(String[] args) throws IOException {

        int numero;

        out.print("Digite un número para evaluar: ");
        numero = Integer.parseInt(in.readLine());

        if(numero < 0){
            out.println(numero + " es negativo");
        }else{
            out.println(numero + " es positivo");
        }
    }
}
