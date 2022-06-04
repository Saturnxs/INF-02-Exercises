import java.io.*;
import java.util.*;

public class ThomasEmanuelBermúdezMora_Tarea5 {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static void main(String[] args) throws NumberFormatException, IOException {
        boolean continuarMenu = true, barcosCargados = false;
        int[] barcosComputadora = null;
        int[] barcosJugador = null;

        imprimirMensaje("¡Bienvenido a Battleship: Batalla Naval!");
        do{
            switch(imprimirMenu()){
                case 1:
                    barcosComputadora = inicializarBarcosComputadora();
                    barcosJugador = inicializarBarcosJugador();
                    barcosCargados = true;
                    break;
                case 2:
                    if(barcosCargados){
                        imprimirBarcos(barcosJugador, barcosComputadora);
                    }
                    else{
                        imprimirMensaje("¡Debes colocar tus tropas en posición antes de empezar!");
                    }
                    break;
                case 3:
                    if(barcosCargados){
                        inicializarJuego(barcosJugador, barcosComputadora);
                        barcosCargados = false;
                    }
                    else{
                        imprimirMensaje("¡Debes colocar tus tropas en posición antes de empezar!");
                    }
                    break;
                case 4:
                    imprimirMensaje("¡Vuelve a probar tus destrezas en alta mar soldado! ¡Nos vemos pronto!");
                    continuarMenu = false;
                    break;
                default:
                    imprimirMensaje("¡Elije una opción válida soldado!");
            }
        }while(continuarMenu);
    }

    static int[] inicializarBarcosComputadora(){
        int[] barcosComputadora = new int[20];
        int indexBarco;
        boolean esCero;

        out.println("\n----------------------------------------------------------");
        out.println("Las embarcaciones de la computadora se están organizando, ¡Prepárate soldado!");
        cargarAnimacion(50);
        for (int i = 0; i < 5; i++) {
            do {
                indexBarco = (int)(barcosComputadora.length * Math.random());
                if (barcosComputadora[indexBarco] == 0) {
                    barcosComputadora[indexBarco] = (i+1);
                    esCero = false;
                } else {
                    esCero = true;
                }
            } while (esCero);
        }
        out.println("\n\n¡Las embarcaciones de la computadora están en posición!");
        out.println("----------------------------------------------------------");
        return barcosComputadora;
    }
    static int[] inicializarBarcosJugador() throws NumberFormatException, IOException{
        int[] barcosJugador = new int[20];
        int indexBarco;
        boolean esCero;

        out.println("\n¡Es tu turno, soldado!");
        for (int i = 0; i < 5; i++) {
            do {
                indexBarco = validarIndiceArreglo("\nIngresa la posición de la embarcación "+(i+1)+" (1-20): ")-1;
                if (barcosJugador[indexBarco] == 0) {
                    barcosJugador[indexBarco] = (i+1);
                    out.println("¡La unidad "+(i+1)+" flota rumbo a la posición "+(indexBarco+1)+"!");
                    esCero = false;
                } else {
                    out.println("¡Cuidado soldado! Ya hay una embarcación en la posición "+(indexBarco+1)+", por favor selecciona otra localización");
                    esCero = true;
                }
            } while (esCero);
        }
        out.println("\n¡Tus embarcaciones están alineadas!¡Dirígete al campo de batalla!");
        out.println("----------------------------------------------------------\n");
        return barcosJugador;
    }
    static void imprimirBarcos(int[] barcosJugador, int[]barcosComputadora){
        out.println("\n----------------------------------------------------------");
        out.println("Tus embarcaciones arribaron a la localización:");
        out.printf(Arrays.toString(barcosJugador));
        out.println("\n\nLas embarcaciones de la computadora están en la localización:");
        out.printf(Arrays.toString(barcosComputadora));
        out.println("\n----------------------------------------------------------\n");
    }
    static int hacerDisparo(int[] barcosAtacados, int indexBarco){
        int barcoDerribado;
        if(barcosAtacados[indexBarco] == 0){
            barcoDerribado = -1;
        }else{
            barcoDerribado = barcosAtacados[indexBarco];
            barcosAtacados[indexBarco] = 0;
        }
        return barcoDerribado;
    }
    static void imprimirGanador(int barcosDerribadosJugador, int barcosDerribadosComputador,int sumaBarcosJugador, int sumaBarcosComputador){
        if(barcosDerribadosComputador == barcosDerribadosJugador){
            if(sumaBarcosJugador > sumaBarcosComputador){
                imprimirMensaje("¡Tuviste más puntos que la computadora!¡Has ganado!");
            }else if(sumaBarcosJugador < sumaBarcosComputador){
                imprimirMensaje("¡La computadora tuvo más puntos que tu!¡Has perdido!");
            }
        }else if(barcosDerribadosJugador > barcosDerribadosComputador){
                imprimirMensaje("¡Derribaste más barcos que la computadora!¡Has ganado!");
        }else if(barcosDerribadosJugador < barcosDerribadosComputador){
            imprimirMensaje("¡La computadora derribó más barcos que tú!¡Has perdido!");
        }else{
            imprimirMensaje("¡La computadora y tú han empatado!¡Vuelve a intentarlo!");
        }
    }
    static int imprimirMenu() throws NumberFormatException, IOException{
        int opcionMenu;
        out.println("Opciones:");
        out.println("1) Inicializar Juego\n2) Imprimir posición de los barcos\n3) Jugar\n4) Salir del juego");
        opcionMenu = validarNumeroEntero("\nSeleccione la opción del menu (1-4): ");
        return opcionMenu;
    }
    static void inicializarJuego(int[] barcosJugador, int[]barcosComputadora) throws NumberFormatException, IOException{
        int indexBarco, barcosDerribadosComputador = 0, barcosDerribadosJugador = 0, turnos = 0, sumaBarcosJugador = 0, sumaBarcosComputador = 0;

        out.println("\n----------------------------------------------------------");
        out.println("¡Ha llegado la hora de probar tus habilidades en altamar!\n");
        out.println("Una espesa niebla no deja visualizar la naves enemigas... ¡Tendremos que atacar a ciegas!");
        out.println("Las embarcaciones de la computadora están justo al frente ¡Vamos a atacar!");
        out.println("---------------------------------------------------------");

        do {
            turnos++;
            out.println("\nTurno "+turnos);
            indexBarco = validarIndiceArreglo("¡Soldado!¡Apunta tus cañones a alguna de las posiciones! (1-20): ") - 1;
            if(barcosComputadora[indexBarco] != 0){
                sumaBarcosJugador += hacerDisparo(barcosComputadora, indexBarco);
                barcosDerribadosJugador++;
                out.print("\n¡Veo humo! ¡Has derribado un barco enemigo!\n");
            }else{
                out.print("\nParece que no derribaste ningún barco...\n");
            }

            out.print("\n¡La máquina está apuntando! ¡A cubierto soldado!\n");
            cargarAnimacion(20);
            indexBarco = (int) (barcosJugador.length * Math.random());
            if(barcosJugador[indexBarco] != 0){
                sumaBarcosComputador += hacerDisparo(barcosJugador, indexBarco);
                barcosDerribadosComputador++;
                out.print("\n¡Nos dieron! ¡El barco en la posición "+(indexBarco+1)+" se hunde!\n");
            }else{
                out.print("\n¡La computadora falló el disparo!\n");
            }
            out.println("\n---------------------------------------------------------");
        } while (turnos < 10 && barcosDerribadosJugador < 5 && barcosDerribadosComputador < 5);

        imprimirGanador(barcosDerribadosJugador, barcosDerribadosComputador, sumaBarcosJugador, sumaBarcosComputador);
    }
    static void cargarAnimacion(int tiempo){
        char[] caracteresAnimacion = new char[]{'|', '/', '-', '\\'};
        for (int i = 0; i <= 100; i++) {
            out.print("Cargando: " + i + "% " + caracteresAnimacion[i % 4] + "\r");
            try {
                Thread.sleep(tiempo);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    static void imprimirMensaje(String mensaje){
        out.println("\n----------------------------------------------------------");
        out.println(mensaje);
        out.println("----------------------------------------------------------\n");
    }
    static int validarNumeroEntero(String mensaje) {
        int  numeroEntero = 0;
        boolean huboExcepcion = false;

        do {
            try {
                out.print(mensaje);
                numeroEntero = Integer.parseInt(in.readLine());
                huboExcepcion = false;
            } catch (Exception e) {
                huboExcepcion = true;
                imprimirMensaje("¡Ingresa un valor válido, soldado!");
            }
        } while (huboExcepcion);

        return numeroEntero;
    }
    static int validarIndiceArreglo(String mensaje){
         int numeroEntero = 0;
         boolean huboExcepcion = false;
         do {
            numeroEntero = validarNumeroEntero(mensaje);
             if (numeroEntero > 20 || numeroEntero < 1) {
                 imprimirMensaje("¡Ingresa un valor válido soldado!");
                 huboExcepcion = true;
             } else {
                huboExcepcion = false;
             }
         } while (huboExcepcion);
         return numeroEntero;
     }
}