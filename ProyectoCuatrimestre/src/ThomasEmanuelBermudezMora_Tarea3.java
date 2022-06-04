import java.io.*;

public class ThomasEmanuelBermudezMora_Tarea3 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static void main(String[] args) throws Exception {
        //Variables de entrada
        int cantidadEstudiantes, nivelEstudiante, opcionEquipo, opcionBeca;
        
        //Variables intermedias
        int totalEstudiantesBecados = 0, totalEstudiantesNoBecados = 0;
        
        //Variables de salida
        int[] totalEstudiantesPorNivel = new int[5];
        int totalEstudiantesBaloncesto = 0, totalEstudiantesNatacion = 0, totalEstudiantesAjedrez = 0, totalEstudiantesSinEquipo = 0;
        int montoMensualBecaDeportiva = 0, montoAnualBecaDeportiva = 0, montoMensualBecaAcademica = 0, montoAnualBecaAcademica = 0;
        Double porcentajeEstudiantesBecados, porcentajeNoEstudiantesBecados;

        out.println("\nBinvenido al programa administrador de becas y equipos deportivos");
        out.print("Ingrese la cantidad de estudiantes que llenaron la encuesta: ");
        cantidadEstudiantes = Integer.parseInt(in.readLine());

        for (int i = 1; i <= cantidadEstudiantes; i++) {

            out.println("\nEstudiante encuestado #" + i + "\n");

            do {
                out.print("1) ¿En qué nivel se encuentra? (1 al 5): ");
                nivelEstudiante = Integer.parseInt(in.readLine());

            } while (nivelEstudiante > 5 || nivelEstudiante < 1);

            totalEstudiantesPorNivel[nivelEstudiante-1]++;

            do {
                out.println("2) ¿A cuál equipo deportivo quiere pertenecer?\n1 - Baloncesto\n2 - Natación\n3 - Ajedrez\n4 - Ninguno");
                out.print("Elija del 1 al 4: ");
                opcionEquipo = Integer.parseInt(in.readLine());
            }while(opcionEquipo > 4 || opcionEquipo < 1);

            switch (opcionEquipo) {
                case 1:
                    totalEstudiantesBaloncesto ++;
                    break;
                case 2:
                    totalEstudiantesNatacion ++;
                    break;
                case 3:
                    totalEstudiantesAjedrez ++;
                    break;
                default:
                    totalEstudiantesSinEquipo ++;
                    break;
            }

            do {
                out.println("3) ¿Cuenta con alguna beca?\n1 - Académica\n2 - Deportiva\n3 - Ninguna");
                out.print("Elija del 1 al 3: ");
                opcionBeca = Integer.parseInt(in.readLine());
            } while (opcionBeca > 3 || opcionBeca < 1);

            switch (opcionBeca) {
                case 1:
                    totalEstudiantesBecados ++;
                    montoMensualBecaAcademica += 50000;
                    montoAnualBecaAcademica += 50000*11;
                break;
                case 2:        
                    totalEstudiantesBecados ++;
                    montoMensualBecaDeportiva += 80000;
                    montoAnualBecaDeportiva += 80000*11;
                break;
                default:
                    totalEstudiantesNoBecados ++;
                break;
            }
            
        }

        porcentajeEstudiantesBecados = ((double)(totalEstudiantesBecados*100)/cantidadEstudiantes);
        porcentajeNoEstudiantesBecados = ((double)(totalEstudiantesNoBecados*100)/cantidadEstudiantes);


        out.println("\nReporte de becas y equipos deportivos");
        out.println("\nTotal de estudiantes que respondieron la encuesta por nivel:");

        for (int i = 0; i < totalEstudiantesPorNivel.length; i++) {
            out.println("Nivel "+(i+1)+": "+totalEstudiantesPorNivel[i]);
        }
        
        out.println("\nPorcentaje becas");
        out.println("Porcentaje total de estudiantes becados: "+porcentajeEstudiantesBecados+" %");
        out.println("Porcentaje total de estudiantes no becados: "+porcentajeNoEstudiantesBecados+" %");
        
        
        out.println("\nBecas deportivas");
        out.println("Monto total mensual: "+montoMensualBecaDeportiva);
        out.println("Monto total anual: "+montoAnualBecaDeportiva);
        
        out.println("\nBecas académicas");
        out.println("Monto total mensual: "+montoMensualBecaAcademica);
        out.println("Monto total anual: "+montoAnualBecaAcademica);

        out.println("\nTotal de estudiantes que pertenecen a los equipos:");
        out.println("Baloncesto: "+totalEstudiantesBaloncesto);
        out.println("Natación: "+totalEstudiantesNatacion);
        out.println("Ajedrez: "+totalEstudiantesAjedrez);
        out.println("Ninguno: "+totalEstudiantesSinEquipo+"\n");
    }
}
