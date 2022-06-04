import java.io.*;

public class ThomasEmanuelBermúdezMora_Tarea4_copy {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    static int menu() throws NumberFormatException, IOException {
        int opcionMenu;

        out.println("\nBienvenido al sistema de Eco-factura del CNFL\n");
        out.print("Opciones: \n1) Calcular mes con más consumo\n2) Calcular la eco-factura del mes\n3) Salir\n\nPor favor ingrese opción que desee (1-3): ");
        opcionMenu = Integer.parseInt(in.readLine());

        return opcionMenu;
    }

    static String mesMayorConsumo() throws NumberFormatException, IOException {
        String mesMayorConsumo = "No hay meses de mayor consumo";
        int cantidadMax = 0;
        String[] nombreMeses = new String[6];
        int[] totalKwhMeses = new int[6];

        out.println("\n------------------------- Opcion 1: Calcular mes con más consumo -------------------------\n");
        out.println("Para conocer su mes de mayor consumo ingrese los datos de los 6 últimos meses");

        for (int i = 0; i < totalKwhMeses.length; i++) {
            out.println("\nMes número " + (i + 1));
            out.print("Ingrese el nombre del mes: ");
            nombreMeses[i] = in.readLine();
            out.print("Ingrese la cantidad de kilowatts por hora (KWH) de "+nombreMeses[i].toLowerCase()+": ");
            totalKwhMeses[i] = Integer.parseInt(in.readLine());

            if (totalKwhMeses[i] != 0) {
                if (cantidadMax == totalKwhMeses[i]) {
                    mesMayorConsumo += ", " + nombreMeses[i];
                    cantidadMax = totalKwhMeses[i];
                } else if (cantidadMax < totalKwhMeses[i]) {
                    cantidadMax = totalKwhMeses[i];
                    mesMayorConsumo = nombreMeses[i];
                }
            }
        }
        return mesMayorConsumo;
    }

    static Double montoEnergia(int kwhPunto, int kwhValle, int kwhNoct) {
        Double montoTarifaResidencial = 0.0;

        if (kwhPunto <= 500) {
            montoTarifaResidencial += kwhPunto * 167.72;
        } else {
            montoTarifaResidencial += kwhPunto * 207.39;
        }

        if (kwhValle <= 500) {
            montoTarifaResidencial += kwhValle * 68.75;
        } else {
            montoTarifaResidencial += kwhValle * 83.71;
        }

        if (kwhNoct <= 500) {
            montoTarifaResidencial += kwhNoct * 28.77;
        } else {
            montoTarifaResidencial += kwhNoct * 38.74;
        }

        return montoTarifaResidencial;
    }

    static Double montoAlumbradoPublico(int totalKwh) {
        Double montoAlumbradoPublico = totalKwh * 3.37;
        return montoAlumbradoPublico;
    }

    static Double montoTributoBomberos(int totalKwh) {
        Double montoTributo = totalKwh * 0.0175;
        return montoTributo;
    }

    static Double montoIva(int totalKwh, Double montoEnergia) {
        Double montoIva = 0.0;
        if (totalKwh >= 280) {
            montoIva = montoEnergia * 0.13;
        }
        return montoIva;
    }

    static void solicitarDatosEcoFactura() throws IOException{
        int kwhPunto, kwhValle, kwhNoct;
        String mesFactura;
        
        out.println("\n--------------------------- Opcion 2: Calcular Eco-Factura ---------------------------\n");
        out.println("Para calcular su eco factura ingrese los siguientes datos:\n");
        out.print("Nombre del mes a facturar: ");
        mesFactura = in.readLine();
        out.print("Kilowatts por hora en horario punta en "+mesFactura.toLowerCase()+": ");
        kwhPunto = Integer.parseInt(in.readLine());
        out.print("Kilowatts por hora en horario valle en "+mesFactura.toLowerCase()+": ");
        kwhValle = Integer.parseInt(in.readLine());
        out.print("Kilowatts por hora en horario nocturno en "+mesFactura.toLowerCase()+": ");
        kwhNoct = Integer.parseInt(in.readLine());

        imprimirEcoFactura(mesFactura, kwhPunto, kwhValle, kwhNoct);
    }

    static void imprimirEcoFactura(String mesFactura, int kwhPunto, int kwhValle, int kwhNoct) {
        int totalKwh = kwhPunto + kwhValle + kwhNoct;
        Double  montoFacturadoEnergia = montoEnergia(kwhPunto, kwhValle, kwhNoct),
                montoAlumbrado = montoAlumbradoPublico(totalKwh),
                montoTributo = montoTributoBomberos(totalKwh),
                montoIva = montoIva(totalKwh, montoFacturadoEnergia),
                totalFactura;

        totalFactura = montoFacturadoEnergia + montoAlumbrado + montoTributo + montoIva;

        out.println("\n------------------------------------------------------------------------------------------");
        out.println("Desglose Eco-Factura\n");
        out.println("Mes facturado: "+ mesFactura.toUpperCase());
        out.println("Total de KWH consumidos en "+mesFactura.toLowerCase()+": " + totalKwh);
        out.printf("\nMonto energía: %.2f", montoFacturadoEnergia);
        out.printf("\nMonto alumbrado electrico: %.2f", montoAlumbrado);
        out.printf("\nMonto tributo a bomberos: %.2f", montoTributo);
        out.printf("\nMonto IVA: %.2f \n", montoIva);
        out.printf("\nTotal a pagar: %.2f\n", totalFactura);
        out.println("------------------------------------------------------------------------------------------\n");
    }

    public static void main(String[] args) throws Exception {
        int opcion;
        do {
            opcion = menu();
            switch (opcion) {
                case 1:
                    out.printf("\n------------------------------------------------------------------------------------------\nSu mes de mayor consumo es: %S\n------------------------------------------------------------------------------------------\n", mesMayorConsumo());
                    break;
                case 2:
                    solicitarDatosEcoFactura();
                    break;
                default:
                    out.println("¡Gracias por su visita!");
                    break;
            }
        } while (opcion == 1 || opcion == 2);
    }
}
