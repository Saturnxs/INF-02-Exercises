import java.io.*;

public class App {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static void main(String[] args) throws Exception {
        int cantidadExamenes, cantidadEstudiantes, estudiantesAprobados = 0, estudiantesAmpliacion = 0,
                estudiantesReprobados = 0;
        Double notaExamen, notaTotal, promedioNotas;

        out.print("Ingrese la cantidad de estudiantes: ");
        cantidadEstudiantes = Integer.parseInt(in.readLine());

        for (int i = 1; i < cantidadEstudiantes; i++) {
            notaExamen = (double) 0;
            notaTotal = (double) 0;
            promedioNotas = (double) 0;

            out.print("Ingrese la cantidad de examénes del estudiante "+i+": ");
            cantidadExamenes = Integer.parseInt(in.readLine());

            for (int j = 1; j < cantidadExamenes; j++) {
                out.print("Digite la nota del " +j+ " éxamen del estudiante " +i+ ": ");
                notaExamen = Double.parseDouble(in.readLine());
                notaTotal = notaTotal + notaExamen;

            }

            promedioNotas = notaTotal / cantidadExamenes;

            if (promedioNotas >= 70) {
                out.println("Aprobó con " + promedioNotas);
                estudiantesAprobados = estudiantesAprobados++;
            } else if (promedioNotas < 70 && promedioNotas >= 60) {
                out.println("Debe ir a ampliación con " + promedioNotas);
                estudiantesAmpliacion = estudiantesAmpliacion++;
            } else {
                out.println("Reprobó con " + promedioNotas);
                estudiantesReprobados = estudiantesReprobados++;
            }
        }

        out.println("Cantidad de estudiantes aprobados: " + estudiantesAprobados);
        out.println("Cantidad de estudiantes en ampliación: " + estudiantesAmpliacion);
        out.println("Cantidad de estudiantes reprobados: " + estudiantesReprobados);

    }
}
