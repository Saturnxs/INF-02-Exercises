import java.io.*;

public class PiedraPapelTijera {
    
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    /**
     * Esta función permite determinar la opcion elegida por el usuario para mostrarla como tipo texto
     * @param opcion Este es el valor de la opción seleccionada
     * @return Devuelve un valor String con el nombre de la opción seleccionada
     */
    static String determinarOpcionElegida(int opcion){

        String opcionSeleccionada;

        switch (opcion) {
            case 1:
                opcionSeleccionada = "Piedra";
                break;
        
            case 2:
                opcionSeleccionada = "Papel";
                break;

            default:
                opcionSeleccionada = "Tijera";
                break;
        }

        return opcionSeleccionada;
    } 
    
    public static void main(String[] args) throws Exception {

        // Definir variables
        int opcionUsuario, opcionMaquina, victoriasUsuario=0, victoriasMaquina=0, empates=0;
        String nombreUsuario;

        // Solicitar datos al usuario y procesarlos
        out.println("Escriba su nombre: ");
        nombreUsuario =in.readLine();

        for (int i = 1; i <= 5; i++) {
        
            out.println("PARTIDA: "+i+"\n");
            out.printf("| %2d - %10s |\n", 1,"Piedra");
            out.printf("| %2d - %10s |\n", 2,"Papel");
            out.printf("| %2d - %10s |\n", 3,"Tijera");

            out.println("\nSeleccione una opción: ");
            opcionUsuario = Integer.parseInt(in.readLine());

            opcionMaquina = 1 + (int)(Math.random() * 3);

            out.println( "\n"+nombreUsuario+" ha elegido "+determinarOpcionElegida(opcionUsuario) );
            out.println("La computadora ha elegido "+determinarOpcionElegida(opcionMaquina)+"\n");

            if ((opcionUsuario == 1 && opcionMaquina == 3) || (opcionUsuario == 2 && opcionMaquina == 1) || (opcionUsuario == 3 && opcionMaquina == 2)) {
                
                out.println(nombreUsuario+" ha ganado la partida "+i+"\n");
                victoriasUsuario = victoriasUsuario + 1;

            } else {
                if ((opcionMaquina == 1 && opcionUsuario == 3) || (opcionMaquina == 2 && opcionUsuario == 1) || (opcionMaquina == 3 && opcionUsuario == 2)) {
                   
                    out.println("La computadora ha ganado la partida "+i+"\n");
                    victoriasMaquina = victoriasMaquina + 1;

                } else {
                    
                    out.println("Ha quedado empatada la partida "+i+"\n");
                    empates = empates + 1;

                }  
            }
        }

        if (empates >= 3 || victoriasUsuario == victoriasMaquina) {
            
            out.println("El juego ha quedado empatado.");

        } else {
            
            if (victoriasUsuario > victoriasMaquina) {
                
                out.println(nombreUsuario+" ha ganado el juego.");

            } else {

                out.println("La computadora ha ganado el juego.");

            }

        }
    }
}