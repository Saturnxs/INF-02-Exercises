import java.io.*;

public class Ejercicio_2_Triangulo {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static void main(String[] args) throws Exception {

        Double ladoA;
        Double ladoB;
        Double ladoC;

        out.print("Digite el primer lado: ");
        ladoA = Double.parseDouble(in.readLine());
        
        out.print("Digite el segundo lado: ");
        ladoB = Double.parseDouble(in.readLine());
        
        out.print("Digite el tercer lado: ");
        ladoC = Double.parseDouble(in.readLine());

        
        if(((ladoB+ladoC)>ladoA)&&((ladoA+ladoB)>ladoC)&&((ladoA+ladoC)>ladoB)){
            out.println("Los tres lados conforman un triángulo");
        }else{
            out.println("Los lados no conforman un triángulo");
        }
        

    }
}
