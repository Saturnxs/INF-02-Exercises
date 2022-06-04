import java.io.*;

public class Proyecto_Entrega1 {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static void main(String[] args) throws Exception {

        // Definir variables de entrada
        String nombreEquipo;
        int puntajePartidos, juegosEjecutados, oponentesDiferentes;
        
        // Definir variables intermedias
        double puntajeJuegos, puntajeOponentes;

        // Definir variables de salida
        double puntajeTotal;

        // Solicitar datos al usuario
        out.print("Esciba el nombre de su equipo: ");
        nombreEquipo = in.readLine();

        out.print("Indique el puntaje total de todos los partidos: ");
        puntajePartidos = Integer.parseInt(in.readLine());
        
        out.print("Indique el número de juegos ejecutados: ");
        juegosEjecutados = Integer.parseInt(in.readLine());
        
        out.print("Indique el número de oponentes diferentes que ha enfrentado: ");
        oponentesDiferentes = Integer.parseInt(in.readLine());

        // Procesar datos
        if (juegosEjecutados >= 5) {
            puntajeJuegos = 1;
        }else{
            puntajeJuegos = Math.sqrt(juegosEjecutados) / 2.25;
        }

        if (oponentesDiferentes >= 3) {
            puntajeOponentes = 1;
        } else {
            if (oponentesDiferentes == 2) {
                puntajeOponentes = 2/3;
            }else{
                puntajeOponentes = 1/3;
            }
        }

        puntajeTotal = puntajePartidos + puntajeJuegos + puntajeOponentes;

        //Mostrar salida
        out.println("El puntaje total del equipo "+nombreEquipo+" es: "+puntajeTotal);

    }
}