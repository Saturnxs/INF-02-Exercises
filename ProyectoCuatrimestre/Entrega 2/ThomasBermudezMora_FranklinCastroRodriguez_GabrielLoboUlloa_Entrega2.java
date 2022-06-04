import java.io.*;

public class ThomasBermudezMora_FranklinCastroRodriguez_GabrielLoboUlloa_Entrega2 {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static void main(String[] args) throws Exception {

        // Variables de entrada
        String nombreEquipo = "", nombreEquipoRival = "";
        int juegosEjecutados = 0, puntajeJuego = 0, puntajeJuegoRival = 0;
        boolean esSnitchCapturada = false;

        // Variables de salida
        String desgloseMarcador = "";
        int puntajePartidos = 0;

        out.println("\nBienvenido al sistema de reporte de resultados!\n");

        out.print("Escriba el nombre de su equipo: ");
        nombreEquipo = in.readLine();

        out.print("Indique el número de juegos ejecutados: ");
        juegosEjecutados = Integer.parseInt(in.readLine());

        for (int i = 0; i < juegosEjecutados; i++) {
            out.println("\nJuego " + (i + 1));

            out.print("Nombre del equipo contra el que jugó: ");
            nombreEquipoRival = in.readLine();

            desgloseMarcador += nombreEquipo + " vs " + nombreEquipoRival + "\n";

            out.print("Marcador de " + nombreEquipo + ": ");
            puntajeJuego = Integer.parseInt(in.readLine());

            out.print("¿Su equipo atrapó la Snitch? (SI/NO): ");
            esSnitchCapturada = "SI".equalsIgnoreCase(in.readLine());

            out.print("Marcador de " + nombreEquipoRival + ": ");
            puntajeJuegoRival = Integer.parseInt(in.readLine());

            if (!esSnitchCapturada) {
                desgloseMarcador += puntajeJuego + " - " + puntajeJuegoRival + " *\n";
            } else {
                desgloseMarcador += puntajeJuego + " * - " + puntajeJuegoRival + "\n";
            }
            puntajePartidos += puntajeJuego;
        }

        out.print("\nMarcador para " + nombreEquipo + "\n");
        out.print("\n" + desgloseMarcador);
        out.print("\nPuntaje total para " + nombreEquipo + ": " + puntajePartidos + "\n\n");

    }
}