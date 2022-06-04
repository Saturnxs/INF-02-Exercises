import java.io.*;

/**
 * Clase Utils
 * Esta clase contiene métodos utilizarios para la lectura de datos básicos.
 * Además, de validaciones de las entradas para facilitar la escritura de
 * códigos.
 * 
 * @author Mauricio Andrés Zamora Hernández
 * @version 1.0
 */
public class Utils {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    /**
     * Este método genera un "menú" con las opciones en un arreglo de String.
     * El método coloca automáticamene el número de selección iniciando en 1.
     * Además, este método tiene validaciones para que solo se pueda seleccionar
     * valores válidos y controla excepciones por tipo de entrada incorrecto.
     * 
     * @param etiqueta Texto que se coloca antes de la impresión del menú.
     *                 Se recomienda un texto que indique que significa las
     *                 opciones.
     * @param opciones Las opciones a mostrar.
     * @return El número seleccionado por el usuario del menú mostrado.
     */
    static int seleccionarElementoTexto(String etiqueta, String[] opciones) {
        int resultado = 0;
        out.println(etiqueta);

        for (int i = 0; i < opciones.length; i++) {
            out.printf("%3d - %s\n", (i + 1), opciones[i]);
        }

        resultado = leerRangosEnteros("Seleccione el ID de la opción", 1, opciones.length);

        return resultado;
    }

    /**
     * Este método permite la lectura de un número entero. Si el usuario digita algo
     * que genere un
     * error, el sistema contniuará solicitando el valor correcto.
     * 
     * @param texto Es el texto utilizado como etiqueta para que el usuario sepa que
     *              se le solicita.
     *              Si no desea imprimir una etiqueta, coloque "".
     * @return Número entero digitado por el usuario.
     */
    public static int leerEntero(String texto) {
        int resultado = 0;
        out.print(texto);

        boolean ocurrioUnaBronca = false;

        do {
            try {
                resultado = Integer.parseInt(in.readLine());
                ocurrioUnaBronca = false;
            } catch (Exception e) {
                ocurrioUnaBronca = true;
                out.println("Intente de nuevo, porque no digito un número");
            }
        } while (ocurrioUnaBronca);

        return resultado;
    }

    /**
     * Este método permite la lectura de un String (texto).
     * 
     * @param texto Es el texto utilizado como etiqueta para que el usuario sepa que
     *              se le solicita.
     *              Si no desea imprimir una etiqueta, coloque "".
     * @return String (texto) digitado por el usuario.
     */
    public static String leerString(String texto) {
        String resultado = null;
        out.print(texto);

        try {
            resultado = in.readLine();

        } catch (Exception e) {
        }

        return resultado;
    }

    /**
     * Este método leer un boolean (true/false), para esto se hace una pregunta de tipo Si y NO,
     * si el usuario escribe un Si, el sistema devuelve un true, el usuario escoge No el sistema
     * devuelve un false. Si no responde a las opciones, el sistema sigue preguntando.
     * 
     * @param pregunta Es el texto de la pregunta, no es necesario colocar los signos de puntuación.
     * @return boolean que corresopnde a la respuesta del usuario True para Si, False para No
     */
    public static boolean leerBoolean(String pregunta) {
        char resultado = Character.UNASSIGNED;
        boolean ocurrioUnaBronca = false;

        out.printf("¿%s? \n\tDigite S para Si, N para No, luego presione ENTER\n", pregunta);

        do {
            try {
                resultado = in.readLine().trim().toUpperCase().charAt(0);
                ocurrioUnaBronca = false;
                if (!(resultado == 'S' || resultado == 'N')) {
                    throw new Exception();
                }
            } catch (Exception e) {
                ocurrioUnaBronca = true;
                out.println("Intente de nuevo, Digite S para Si, N para No, luego presione ENTER");
            }
        } while (ocurrioUnaBronca);



        return resultado == 'S';
    }

    /**
     * Este método permite la lectura de un número doble. Si el usuario digita algo
     * que genere un
     * error, el sistema contniuará solicitando el valor correcto.
     * 
     * @param texto Es el texto utilizado como etiqueta para que el usuario sepa que
     *              se le solicita.
     *              Si no desea imprimir una etiqueta, coloque "".
     * @return Número doble digitado por el usuario.
     */
    public static double leerDoble(String texto) {
        double resultado = 0;
        out.print(texto);

        boolean ocurrioUnaBronca = false;

        do {
            try {
                resultado = Double.parseDouble(in.readLine());
                ocurrioUnaBronca = false;
            } catch (Exception e) {
                ocurrioUnaBronca = true;
                out.println("Intente de nuevo, porque no digito un número");
            }
        } while (ocurrioUnaBronca);

        return resultado;
    }

    /**
     * Este método valida la lectura de un rango de valores enteros, ambos límites
     * inclusive.
     * Si el usuario digita un valor fuera del rango, el sistema le solitará otro
     * valor hasta
     * encontrar un valor válido.
     * 
     * @param etiqueta Es el texto utilizado como etiqueta para que el usuario sepa
     *                 que se le solicita.
     * @param min      Valor mínimo del rango
     * @param max      Valor máximo del rango
     * @return Número entero digitado por el usuario.
     */
    static int leerRangosEnteros(String etiqueta, int min, int max) {
        int resultado = 0;
        out.println(etiqueta);

        do {
            resultado = leerEntero("");
            if (resultado < min || resultado > max) {
                out.println("Valor fuera del rango [" + min + " al " + max + "], digite de nuevo");
            }

        } while (resultado < min || resultado > max);

        return resultado;
    }

    /**
     * Este método valida la lectura de un rango de valores dobles, ambos límites
     * inclusive.
     * Si el usuario digita un valor fuera del rango, el sistema le solitará otro
     * valor hasta
     * encontrar un valor válido.
     * 
     * @param etiqueta Es el texto utilizado como etiqueta para que el usuario sepa
     *                 que se le solicita.
     * @param min      Valor mínimo del rango
     * @param max      Valor máximo del rango
     * @return Número doble digitado por el usuario.
     */
    static double leerRangosDobles(String etiqueta, double min, double max) {
        double resultado = 0;
        out.println(etiqueta);

        do {
            resultado = leerEntero("");
            if (resultado < min || resultado > max) {
                out.println("Valor fuera del rango [" + min + " al " + max + "], digite de nuevo");
            }

        } while (resultado < min || resultado > max);

        return resultado;
    }

}
