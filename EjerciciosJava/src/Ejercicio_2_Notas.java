import java.io.*;

public class Ejercicio_2_Notas {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static void main(String[] args) throws Exception {
        
        int nota1, nota2, nota3, promedio;
        String mensaje;

        out.print("Digite la nota del examen 1: ");
        nota1 = Integer.parseInt(in.readLine());

        out.print("Digite la nota del examen 2: ");
        nota2 = Integer.parseInt(in.readLine());

        out.print("Digite la nota del examen 3: ");
        nota3 = Integer.parseInt(in.readLine());

        promedio = (nota1+nota2+nota3)/3;

        if(promedio >= 70){
            mensaje = "Aprobó el curso";
        }else{
            mensaje = "Reprobó el curso";
        }

        out.println(mensaje);
        out.println("Nota: "+ promedio);
    }
}
