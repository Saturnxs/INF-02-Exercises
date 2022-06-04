import java.io.*;

public class ThomasEmanuelBermudezMora_Bono2_Tarea3 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static void main(String[] args) throws Exception {
        // Variables de entrada
        int cantidadEstudiantes = 0, nivelEstudiante, opcionEquipo, opcionBeca;

        // Variables intermedias
        int totalEstudiantesBecados = 0, totalEstudiantesNoBecados = 0;
        int[] totalEstudiantesPorNivel = new int[5];
        int totalEstudiantesBaloncesto = 0, totalEstudiantesNatacion = 0, totalEstudiantesAjedrez = 0, totalEstudiantesSinEquipo = 0;
        int montoMensualBecaDeportiva = 0, montoAnualBecaDeportiva = 0, montoMensualBecaAcademica = 0, montoAnualBecaAcademica = 0;
        Double porcentajeEstudiantesBecados, porcentajeNoEstudiantesBecados;

        // Variables de salida
        String reporteTresAños = "";

        out.println("\nBinvenido al programa administrador de becas y equipos deportivos");

        for (int i = 1; i <= 3; i++) {

            for (int j = 0; j < totalEstudiantesPorNivel.length; j++) {
                totalEstudiantesPorNivel[j] = 0;
            }
            totalEstudiantesBaloncesto = 0;
            totalEstudiantesNatacion = 0;
            totalEstudiantesAjedrez = 0;
            totalEstudiantesSinEquipo = 0;
            montoMensualBecaAcademica = 0;
            montoAnualBecaAcademica = 0;
            montoMensualBecaDeportiva = 0;
            montoAnualBecaDeportiva = 0;
            totalEstudiantesBecados = 0;
            totalEstudiantesNoBecados = 0;
            porcentajeEstudiantesBecados = (double) 0;
            porcentajeNoEstudiantesBecados = (double) 0;

            out.println("\nRespuetas año " + i + "\n");
            out.print("Ingrese la cantidad de estudiantes que llenaron la encuesta: ");
            cantidadEstudiantes = Integer.parseInt(in.readLine());

            for (int j = 1; j <= cantidadEstudiantes; j++) {

                out.println("\nEstudiante encuestado #" + j + "\n");
                do {
                    out.print("1) ¿En qué nivel se encuentra? (1 al 5): ");
                    nivelEstudiante = Integer.parseInt(in.readLine());
                } while (nivelEstudiante > 5 || nivelEstudiante < 1);

                totalEstudiantesPorNivel[nivelEstudiante - 1]++;

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

            reporteTresAños += "\nReporte de becas y equipos deportivos año "+i;
            reporteTresAños += "\n\nTotal de estudiantes que respondieron la encuesta por nivel:";

            for (int j = 0; j < totalEstudiantesPorNivel.length; j++) {
                reporteTresAños += "\nNivel " + (j + 1) + ": " + totalEstudiantesPorNivel[j];
            }

            reporteTresAños += "\n\nPorcentaje becas";
            reporteTresAños += "\nPorcentaje total de estudiantes becados: " + porcentajeEstudiantesBecados + " %";
            reporteTresAños += "\nPorcentaje total de estudiantes no becados: " + porcentajeNoEstudiantesBecados + " %";

            reporteTresAños += "\n\nBecas deportivas";
            reporteTresAños += "\nMonto total mensual: " + montoMensualBecaDeportiva;
            reporteTresAños += "\nMonto total anual: " + montoAnualBecaDeportiva;

            reporteTresAños += "\n\nBecas académicas";
            reporteTresAños += "\nMonto total mensual: " + montoMensualBecaAcademica;
            reporteTresAños += "\nMonto total anual: " + montoAnualBecaAcademica;

            reporteTresAños += "\n\nTotal de estudiantes que pertenecen a los equipos:";
            reporteTresAños += "\nBaloncesto: " + totalEstudiantesBaloncesto;
            reporteTresAños += "\nNatación: " + totalEstudiantesNatacion;
            reporteTresAños += "\nAjedrez: " + totalEstudiantesAjedrez;
            reporteTresAños += "\nNinguno: " + totalEstudiantesSinEquipo + "\n";
        }
        out.println(reporteTresAños);
    }
}