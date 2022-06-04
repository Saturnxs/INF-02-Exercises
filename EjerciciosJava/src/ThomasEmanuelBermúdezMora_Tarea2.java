import java.io.*;

public class ThomasEmanuelBermúdezMora_Tarea2 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static void main(String[] args) throws Exception{
        Integer puntosInfracciones, vigenciaLicencia, montoRenovacion;
        Boolean esIdentificacionAlDia, esDictamenVigente, esPagoMultaNoPendiente, esRecargoBCR;

        out.println("\n¡Bienvenido!");
        out.println("Para renovar su licencia debe contar con los siguientes requisitos:\n");
        out.println("1 - Tener su documento de identificación al día y en buen estado.");
        out.println("2 - Tener vigente el dictamen médico digital para licencia.");
        out.println("3 - Haber pagado todas sus multas pendientes.");
        out.println("4 - No haber llegado a los 12 puntos acumulados de infracciones de tránsito.\n");

        out.println("Digite si cuenta con su documento de identificación al día y en buen estado (SI/NO)");
        esIdentificacionAlDia = "SI".equalsIgnoreCase(in.readLine());

        out.println("Digite si el dictamen médico digital para licencia se encuentra vigente (SI/NO)");
        esDictamenVigente = "SI".equalsIgnoreCase(in.readLine());

        out.println("Digite si ha pagado todas sus multas pendientes (SI/NO)");
        esPagoMultaNoPendiente = "SI".equalsIgnoreCase(in.readLine());

        out.println("Digite la cantidad de puntos acumulados de infracciones de tránsito");
        puntosInfracciones = Integer.parseInt(in.readLine());

        if(puntosInfracciones < 12){
            if(esIdentificacionAlDia && esDictamenVigente && esPagoMultaNoPendiente){
                
                out.println("\nUsted cumple con todos los requisitos necesarios para renovar su licencia.");

                if(puntosInfracciones <= 4){
                    montoRenovacion = 5000;
                    vigenciaLicencia = 6;
                }else if(puntosInfracciones >= 5 && puntosInfracciones <= 8){
                    montoRenovacion = 10000;
                    vigenciaLicencia = 4;
                }else{
                    montoRenovacion = 10000;
                    vigenciaLicencia = 3;
                }

                out.println("¿Desea hacer la renovación con el Banco de Costa Rica? (SI/NO)");
                esRecargoBCR = "SI".equalsIgnoreCase(in.readLine());

                if(esRecargoBCR){
                    montoRenovacion = montoRenovacion + 4200;
                }

                out.println("\nEl monto por renovar su licencia es de: "+montoRenovacion+" colones.");
                out.println("La vigencia de su licencia es de "+vigenciaLicencia+" años.\n");

            }else{
                out.println("No cumple con los requisitos necesarios para renovar su licencia. Su licencia no se encuentra suspendida.\n");
            }
        }else{
            out.println("No cumple con los requisitos necesarios para renovar su licencia. Además su licencia está suspendida.\n");
        }

    }
}
