public class Tips {
 

    static void inicializarBarcosComputadora(int[] barcos) {
        int posicion;
        boolean bandera;

        for (int i = 0; i < 5; i++) {
            do {
                posicion = (int) (barcos.length * Math.random());
                if (barcos[posicion] == 0) {
                    barcos[posicion] = (i+1);
                    bandera = false;
                } else {
                    bandera = true;
                }
            } while (bandera);
        }
    }

    static void inicializarBarcosUsuario(int[] barcos) {
        int posicion;
        boolean bandera;

        for (int i = 0; i < 5; i++) {
            do {
                posicion = Utils.leerRangosEnteros("Digite la posición del barco #"+(i+1)+": ", 1, barcos.length);
                posicion--;
                if (barcos[posicion] == 0) {
                    barcos[posicion] = (i+1);
                    bandera = false;
                    System.out.println("Barco colocado");
                } else {
                    bandera = true;
                    System.out.println("Intente otra posición, Ya hay un barco");
                }
            } while (bandera);
        }
    }


    static void imprimir(int[] m) {
        for (int i = 0; i < m.length; i++) {
                if (m[i] == 0) {
                    System.out.print("+ ");
                } else {
                    System.out.print("* ");
                }
                
        }
        System.out.println();
    }

    static void imprimirNumero(int[] m) {
        for (int i = 0; i < m.length; i++) {
                System.out.printf("%1d ", m[i]);
        }
        System.out.println();
    }


    public static void main(String[] args) {
        // int[] barcos = new int[20];
        // int[] usuario = new int[20];
        // inicializarBarcosComputadora(barcos);
        // imprimir(barcos);
        // inicializarBarcosUsuario(usuario);
        // imprimir(usuario);

        boolean turno = true;
        for (int i = 0; i < 10; i++) {
            if (turno) {
                System.out.println("Es turno de la compu");
            } else {
                System.out.println("Es turno del usuario");
            }
            turno = !turno;
        }
    }

}
