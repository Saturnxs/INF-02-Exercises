import java.io.*;

public class digitos {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    static int calcularLongitud(int numero)
    {
        return (int)Math.floor(Math.log10(numero) + 1);
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException
    {
        int numeroInput;
        out.print("Ingrese un numero para calcular su longitud: ");
        numeroInput = Integer.parseInt(in.readLine());
        out.println("La longitud del numero es: "+calcularLongitud(numeroInput));
    }
}
