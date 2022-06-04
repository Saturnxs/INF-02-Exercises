import java.io.*;

public class ThomasEmanuelBermúdezMora_Tarea1{

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;
    
    public static void main(String[] args) throws Exception{
        
        int mesesTrabajados = 1;

        Double salarioMensual, salariosPendientes, vacacionesNoGozadas, aguinaldoPromocional, preaviso, cesantia, liquidacion;

        out.print("Ingrese su salario mensual: ");
        salarioMensual = Double.parseDouble(in.readLine());

        salariosPendientes = salarioMensual * mesesTrabajados;
        vacacionesNoGozadas = (salarioMensual/30)*14;
        aguinaldoPromocional = (mesesTrabajados * salarioMensual)/12;
        preaviso = salarioMensual;
        cesantia = ((salarioMensual/30)*20)*2;

        liquidacion = salariosPendientes+vacacionesNoGozadas+aguinaldoPromocional+preaviso+cesantia;

        out.print("Su liquidación corresponde a "+liquidacion+" colones.");

    }
}