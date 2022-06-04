
import java.util.Arrays;

public class Ordenamiento {


    public static int generarNumeroAleatorio(int limite) {
        return (int)  (Math.random() * limite) ;
    }

    public static int[] generarArregloAleatorio(int t, int l) {
        int[] resultado = new int[t];
        for (int i = 0; i < resultado.length; i++) {
            resultado[i] = generarNumeroAleatorio(l);
        }
        return resultado;
    }

    public static void imprimir(int[] arr) {
        for (int x : arr) {
            System.out.printf("%3d,", x);
        }
        System.out.println();
    }


    public static int buscarLineal(int[] arr, int valor) {
        int posicion = -1;

        for (int i = 0; i < arr.length; i++) {
            if (valor == arr[i]) {
                posicion = i;
                break;
            }
        }

        return posicion;
    }


    public static void main(String[] args) {
        long inicio, fin, dif;
        int pos = 0;

        int valorBuscado;

        System.out.print("Creación: ");
        inicio = System.nanoTime();
        int[] arreglo = generarArregloAleatorio(10000000, 999999999);
        fin = System.nanoTime();
        dif = fin - inicio;
        System.out.println(dif/1000);

        valorBuscado = arreglo[ generarNumeroAleatorio(arreglo.length) ];
        System.out.println("Valor a buscar: " +valorBuscado);


        System.out.print("Búsqueda lineal: ");
        inicio = System.nanoTime();
        pos = buscarLineal(arreglo, valorBuscado);
        fin = System.nanoTime();
        dif = fin - inicio;
        System.out.println(dif/1000);
        
        System.out.print("Ordenamiento: ");
        inicio = System.nanoTime();
        Arrays.sort(arreglo);
        fin = System.nanoTime();
        dif = fin - inicio;
        System.out.println(dif/1000);


        System.out.print("Búsqueda binaria: ");
        inicio = System.nanoTime();
        pos = Arrays.binarySearch(arreglo, valorBuscado);
        fin = System.nanoTime();
        dif = fin - inicio;
        System.out.println(dif/1000);
        
        
    }
}
