import java.io.*;

public class Ejercicio_14_Salario {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static void main(String[] args) throws Exception {

        int horaEntrada, horaSalida, horasTotales;
        Double tarifa, totalDinero;

        out.print("Ingrese su hora de entrada (24): ");
        horaEntrada = Integer.parseInt(in.readLine());

        out.print("Ingrese su hora de salida (24): ");
        horaSalida = Integer.parseInt(in.readLine());

        out.print("Ingrese su tarifa en colones por hora: ");
        tarifa = Double.parseDouble(in.readLine());

        horasTotales = horaSalida - horaEntrada;

        if (horasTotales > 8) {
            totalDinero = (tarifa * 8) + ((tarifa * 1.5) * (horasTotales - 8));
        } else {
            totalDinero = tarifa * horasTotales;
        }

        out.println("Esta jornada usted ganó: " + totalDinero + " colones y trabajó: " + horasTotales + " horas");

    }
}
