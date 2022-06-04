import java.io.*;

public class Proyecto_Entrega3 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    //Programa principal//
    public static void main(String[] args) {
        out.println("¡Bienvenido al sistema de torneos de Quidditch!");

        int totalEquipos = leerTotalEquipos();
        String[] equipos = registrarNombreEquipos(totalEquipos);
        int[] numJuegos = registrarNumJuegos(totalEquipos, equipos);
        int[] numOponentes = registrarNumOponentes(totalEquipos, equipos, numJuegos);

        reporteJuegos(equipos, numJuegos, numOponentes); 

    }

    //---------------------------------------//
    //Rutinas para información de los equipos//
    //---------------------------------------//
    /**
     * Función que retorna el arreglo del total de equipos inicializado.
     * @return Retorna el arreglo totalEquipos inicializado.
     */
    static int leerTotalEquipos(){
        int totalEquipos;
        
        out.print("Por favor, ingrese el total de equipos que participaron en el torneo: ");
        totalEquipos = validarNumeroPositivo(); 
        
        return totalEquipos;
    }
    
    /**
     * Función para asignar el nombre a cada uno de los equipos participantes.
     * @param totalEquipos Recibe el valor del total de equipos a participar.
     * @return Devuelve el arreglo con los nombres de los equipos definidos.
     */
    static String[] registrarNombreEquipos(int totalEquipos){
        String[] equipos = new String[totalEquipos];
        
        out.println("\n-------------- Registro de equipos --------------\n");
        for (int i = 0; i < equipos.length; i++) {
            out.print("Ingrese el nombre del equipo "+(i+1)+": ");
            equipos[i] = leerString();
        }
       
        return equipos;
    }

    /**
     * Función para asignar el número de juegos a cada uno de los equipos.
     * @param totalEquipos Valor del total de equipos a participar.
     * @param equipos Arreglo de los equipos a participar.
     * @return Devuelve el arreglo del número de juegos de cada equipo.
     */
    static int[] registrarNumJuegos(int totalEquipos, String equipos[]){
        int[] numJuegos = new int[totalEquipos];
        
        out.println("\n-------------- Registro informacion de equipos --------------\n");
        for (int i = 0; i < numJuegos.length; i++) {
            out.print("Ingrese la cantidad de juegos de "+equipos[i]+": ");
            numJuegos[i] = validarNumeroPositivo();
        }
        
        return numJuegos;
    }

    /**
     * Función para asignar el numéro de oponentes por cada equipo.
     * @param totalEquipos Valor del total de equipos a participar.
     * @param equipos Arreglo de los equipos a participar.
     * @return Devuelve el arreglo del número de oponentes de cada equipo.
     */
    static int[] registrarNumOponentes(int totalEquipos, String equipos[], int numJuegos[]){
        int[] numOponentes = new int[totalEquipos];
        
        out.println("\n-------------- Registro informacion de oponentes --------------\n");
        for (int i = 0; i < numOponentes.length; i++) {
            numOponentes[i] = validarNumOponentes(numJuegos, equipos, i);

        }
        return numOponentes;
    }

    //------------------------------//
    //Rutinas para reporte de juegos//
    //------------------------------//
    /**
     * Proceso para generar el reporte de los juegos de los equipos. 
     * @param equipos Arreglo de los equipos a participar.
     * @param numJuegos Arreglo del número de juegos de cada equipo.
     * @param numOponentes Arreglo del número de oponentes de cada equipo.
     */
    static void reporteJuegos(String equipos[], int numJuegos[],int numOponentes[]){
        String nombreEquipoRival = "";
        int puntajeJuego = 0, puntajeJuegoRival = 0;
        boolean esSnitchCapturada = false;

        String[] resultados = new String[equipos.length];
        Double[] puntajeTotal = new Double[equipos.length];

        int puntajePartidos = 0;
        double puntajeJuegos, puntajeOponentes;

        for (int i = 0; i < equipos.length; i++) {
            out.println("\n-------------- Registro de marcador de "+equipos[i]+" --------------\n");
            for (int j = 0; j < numJuegos[i]; j++) {
                out.println("Juego " + (j + 1));
    
                nombreEquipoRival = validarNombreOponente(equipos, numJuegos, i);
    
                if(resultados[i]==null){
                    resultados[i] = equipos[i] + " vs " + nombreEquipoRival + "\n";
                }else{
                    resultados[i] += equipos[i] + " vs " + nombreEquipoRival + "\n";
                }
    
                out.print("Marcador de " + equipos[i] + ": ");
                puntajeJuego = validarNumeroPositivo();
    
                out.print("¿"+equipos[i]+" atrapó la Snitch? (SI/NO): ");
                esSnitchCapturada = "SI".equalsIgnoreCase(leerString());
    
                out.print("Marcador de " + nombreEquipoRival + ": ");
                puntajeJuegoRival = validarNumeroPositivo();
    
                if (!esSnitchCapturada) {
                    resultados[i] += puntajeJuego + " - " + puntajeJuegoRival + " *\n";
                } else {
                    resultados[i] += puntajeJuego + " * - " + puntajeJuegoRival + "\n";
                }
                puntajePartidos += puntajeJuego;
            }
     
            if (numJuegos[i] >= 5) {
                puntajeJuegos = 1;
            }else{
                puntajeJuegos = Math.sqrt(numJuegos[i]) / 2.25;
            }
     
            if (numOponentes[i] >= 3) {
                puntajeOponentes = 1;
            } else {
                if (numOponentes[i] == 2) {
                    puntajeOponentes = 2/3;
                }else{
                    puntajeOponentes = 1/3;
                }
            }
            puntajeTotal[i] = puntajePartidos + puntajeJuegos + puntajeOponentes;
        }
        
        imprimirReporteJuegos(equipos,resultados);
        imprimirPuntajeTotal(equipos,puntajeTotal);
        calcularPromedioOponentes(numOponentes);

        imprimirEquipoMayorPartidos(equipos,numJuegos);
        imprimirEquipoMenorPartidos(equipos,numJuegos);
        imprimirMayorCincoPartidos(equipos,numJuegos);

        imprimirMayorDelPromedio(equipos,numOponentes);
    }

    /**
     * Proceso para imprimir el reporte de los juegos.
     * @param equipos Arreglo de los equipos a participar.
     * @param resultados Arreglo que almacena el desglose de los juegos
     */
    static void imprimirReporteJuegos(String equipos[], String resultados[]){
        for (int i = 0; i < resultados.length; i++) {
            out.print("\n-------------- Marcador para " + equipos[i] + "--------------\n\n" + resultados[i]);
        }
    }

    /**
     * Proceso para imprimir el puntaje total de cada equipo.
     * @param equipos Arreglo de los equipos a participar.
     * @param puntajeTotal Arreglo de los puntajes de los equipos.
     */
    static void imprimirPuntajeTotal(String equipos[],Double puntajeTotal[]){
        out.println("\n-------------- Puntajes totales --------------\n");
        for (int i = 0; i < puntajeTotal.length; i++) {
            out.println("El puntaje total del equipo "+equipos[i]+" es: "+puntajeTotal[i]);
        }
    }

    /**
     * Función para calcular el promedio de oponentes diferentes.
     * @param numOponentes Arreglo del número de oponentes de cada equipo.
     * @return Devuelve el promedio de oponentes.
     */
    static Double calcularPromedioOponentes(int numOponentes[]){
        Double promedioOponentes = 0.0;
        for (int i = 0; i < numOponentes.length; i++) {
            promedioOponentes += numOponentes[i];
        }
        return (promedioOponentes/numOponentes.length);
    }

    /**
     * Proceso para imprimir el equipo con mayor cantidad de partidos.
     * @param equipos Arreglo de los equipos a participar.
     * @param numJuegos Arreglo del número de juegos de cada equipo.
     */
    static void imprimirEquipoMayorPartidos(String equipos[], int numJuegos[]){
        int mayorNumeroPartidos = 0;
        String equipoMasPartidos = "NO EXISTE"; 

        out.println("\n-------------- Equipo con más partidos --------------\n");
            for (int i = 0; i < equipos.length; i++) {
                if(numJuegos[i] != 0 && numJuegos[i] > mayorNumeroPartidos){
                    equipoMasPartidos = equipos[i];  
                    mayorNumeroPartidos = numJuegos[i];
                }
            }
            out.println("------------------------------------------");
            out.print(" El equipo con más partidos es: "+equipoMasPartidos+"\n");
            out.println("------------------------------------------");
    }    
    
    /**
     * Proceso para imprimir el equipo con la menor cantidad de partidos.
     * @param equipos Arreglo de los equipos a participar.
     * @param numJuegos Arreglo del número de juegos de cada equipo.
     */
    static void imprimirEquipoMenorPartidos(String equipos[], int numJuegos[]){
        int mayorNumeroPartidos = numJuegos[0];
        String equipoMasPartidos = "NO EXISTE"; 

        out.println("\n-------------- Equipo con menos partidos --------------\n");
            for (int i = 0; i < equipos.length; i++) {
                if(numJuegos[i] != 0 && numJuegos[i] < mayorNumeroPartidos){
                    equipoMasPartidos = equipos[i];  
                    mayorNumeroPartidos = numJuegos[i];
                }
            }
            out.println("------------------------------------------");
            out.print(" El equipo con menos partidos es: "+equipoMasPartidos+"\n");
            out.println("------------------------------------------");
    }

    /**
     * Proceso para imprimir los equipos con cinco o más partidos.
     * @param equipos Arreglo de los equipos a participar.
     * @param numJuegos Arreglo del número de juegos de cada equipo.
     */
    static void imprimirMayorCincoPartidos(String equipos[], int numJuegos[]){
        String equiposMasCincoPart = "";

        out.println("\n-------------- Equipos con más de cinco partidos --------------\n");
        for (int i = 0; i < equipos.length; i++) {
            if(numJuegos[i] != 0 && numJuegos[i] >= 5){
                equiposMasCincoPart += "\n- "+equipos[i];  
            }
        }
        out.println("------------------------------------------");
        out.print(" Los equipos con más de cinco partidos son: "+equiposMasCincoPart+".\n");
        out.println("------------------------------------------");
    }

    /**
     * Proceso para imprimir los equipos con una cantidad de oponentes mayor al promedio.
     * @param equipos Arreglo de los equipos a participar.
     * @param numOponentes Arreglo del número de oponentes de cada equipo.
     */
    static void imprimirMayorDelPromedio(String equipos[], int numOponentes[]){
        Double promedioOponentes = calcularPromedioOponentes(numOponentes);
        String equiposMayorAlPromedio = "";

        out.println("\n-------------- Equipos con más oponentes que el promedio --------------\n");
        for (int i = 0; i < equipos.length; i++) {
            if(numOponentes[i] > promedioOponentes){
                equiposMayorAlPromedio += "\n- "+equipos[i];
            }
        }
        out.println("------------------------------------------");
        out.print(" Los equipos con más oponentes que el promedio son: "+equiposMayorAlPromedio+"\n");
        out.println("------------------------------------------");
    } 

    //---------------------------------------//
    //Rutinas para excepciones y validaciones//
    //---------------------------------------//
    /**
     * La función evalua que el usuario ingrese, estrictamente, un número entero.
     * @return Devuelve el número entero ingresado por el usuario.
     */
    static int leerNumeroEntero() {
        int resultado = 0;
        boolean ocurrioFallo = false;

        do {
            try {
                resultado = Integer.parseInt(in.readLine());
                ocurrioFallo = false;
            } catch (Exception e) {
                ocurrioFallo = true;
                out.println("Intente de nuevo, digite un número entero");
            }
        } while (ocurrioFallo);

        return resultado;
    }
    
    /**
     * La función evalua que el usuario ingrese, estrictamente, una cadena de caracteres.
     * @return Devuelve la cadena de caracteres ingresada por el usuario.
     */
    static String leerString(){
        String resultado = "";
        boolean ocurrioFallo = false;

        do {
            try {
                resultado = in.readLine();
                if (resultado != "" && resultado.trim() != "") {
                    ocurrioFallo = false;
                }else{
                    ocurrioFallo = true;
                    out.println("Intente de nuevo, digite un texto");
                }
            } catch (Exception e) {
                ocurrioFallo = true;
                out.println("Intente de nuevo, digite un texto");
            }
        } while (ocurrioFallo);

        return resultado;
    }

    /**
     * Función para validar que el número ingresado por el usuario sea positivo.
     * @return Devuelve el valor númerico ingresado por el usuario.
     */
    static int validarNumeroPositivo(){
        int resultado = 0;
        boolean ocurrioFallo = false;

        do {
            resultado = leerNumeroEntero();

            if (resultado >= 0) {
                ocurrioFallo = false;
            } else {
                out.println("¡El número debe ser mayor o igual a 0!");
                out.println("Intente de nuevo");
                ocurrioFallo = true; 
            }
        } while (ocurrioFallo);

        return resultado;
    }

    /**
     * Función para validar que el número de oponentes esté en el rango correcto.
     * @param numJuegos Arreglo del numéro de juegos de cada equipo.
     * @param i Valor del índice de la estructura iterativa for.
     * @return Devuelve el valor del número de oponentes digitado por el usuario.
     */
    static int validarNumOponentes(int numJuegos[], String equipos[], int i){
        int resultado = 0;
        boolean ocurrioFallo = false;

        if (numJuegos[i] == 0) {
            resultado = 0;
        } else {
            out.print("Ingrese el número de oponentes que enfrentó "+equipos[i]+": ");
            do {
                resultado = validarNumeroPositivo();
    
                    if (resultado <= numJuegos[i] && resultado <= (equipos.length - 1) && resultado != 0){
                        ocurrioFallo = false;
                    } else {
                        out.println("¡La cantidad de oponentes no es válida!");
                        out.println("Intente de nuevo");
                        ocurrioFallo = true; 
                    }
            } while (ocurrioFallo);  
        }

        return resultado;
    }

    /**
     * Función para validar el nombre del oponente.
     * @param equipos Arreglo de los equipos a participar.
     * @param i Valor del índice de la estructura iterativa for.
     * @return Devuelve el valor del nombre del oponente digitado por el usuario.
     */
    static String validarNombreOponente(String equipos[], int numJuegos[], int i){
        String resultado = "";
        boolean ocurrioFallo = false;

        do {
            out.print("Nombre del equipo contra el que jugó "+equipos[i]+": ");
            resultado = leerString();

            for (int j = 0; j < equipos.length; j++) {
                if ((equipos[j].equalsIgnoreCase(resultado)) && (equipos[i].equalsIgnoreCase(resultado) == false) && (numJuegos[j] != 0)){
                    ocurrioFallo = false;
                    break;
                } else {
                    ocurrioFallo = true;
                }
            }
        } while (ocurrioFallo);

        return resultado;
    }

}
