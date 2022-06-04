// import java.io.*;

// public class Aeropuerto {
//     static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//     static PrintStream out = System.out;

//     public static void main(String[] args) throws Exception {
//         /**
//          * Declaración de variables: datos de entrada, intermedios y de salida.
//          **/
//         int cantidadTiquetesRegulares, cantidadTiquetesPreferenciales, cantidadTiquetesPrimeraClase, ruta;
//         String origen = "SJO", destino;
//         int distancia, precioRegular, precioPreferencial, precioPrimeraClase;
//         int ingresosPreferencial, ingresosPrimeraClase, ingresosRegular, ingresosTotales = 0, pasajerosTotales = 0;
//         int ingresosPreferencialTotal = 0, ingresosPrimeraClaseTotal = 0, ingresosRegularTotal = 0;
//         int cantidadVuelos, kilometrosRecorridos, kilometrosTotales = 0, maximoVuelos = 0, ingresosRuta, pasajerosRuta;
//         String rutaMasVuelos = "", reportePorRutas = "";
//         out.println("Bienvenido al sistema de reportes de GeekAir");
//         // Ciclo que se encarga de obtener la información de cada una de las rutas
//         for (ruta = 1; ruta <= 5; ruta++) {
//             // Se reinicia el valor de las variables acumuladoras que almacenan los datos de
//             // cada ruta
//             ingresosPreferencial = 0;
//             ingresosPrimeraClase = 0;
//             ingresosRegular = 0;
//             ingresosRuta = 0;
//             pasajerosRuta = 0;
//             switch (ruta) {
//                 case 1:
//                     distancia = 8331;
//                     destino = "BFS";
//                     precioRegular = 465;
//                     precioPreferencial = 365;
//                     precioPrimeraClase = 665;
//                     break;
//                 case 2:
//                     distancia = 8707;
//                     destino = "LHR";
//                     precioRegular = 470;
//                     precioPreferencial = 370;
//                     precioPrimeraClase = 670;
//                     break;
//                 case 3:
//                     distancia = 2077;
//                     destino = "MCO";
//                     precioRegular = 375;
//                     precioPreferencial = 275;
//                     precioPrimeraClase = 575;
//                     break;
//                 case 4:
//                     distancia = 4861;
//                     destino = "SJC";
//                     precioRegular = 390;
//                     precioPreferencial = 290;
//                     precioPrimeraClase = 590;
//                     break;
//                 case 5:
//                     distancia = 13183;
//                     destino = "HND";
//                     precioRegular = 650;
//                     precioPreferencial = 550;
//                     precioPrimeraClase = 850;
//                     break;
//                 default:
//                     distancia = 0;
//                     destino = "";
//                     precioRegular = 0;
//                     precioPreferencial = 0;
//                     precioPrimeraClase = 0;
//                     break;
//             }
//             // Se define la cantidad de vuelos que se realizó en la ruta.
//             // De esta forma se define el valor de la bandera a utilizar en el ciclo que
//             // obtiene los datos de los vuelos
//             out.println("¿Cuántos vuelos hizo la ruta " + "(" + origen + " - " + destino + ")");
//             cantidadVuelos = Integer.parseInt(in.readLine());
//             // En caso de haberse registrado vuelos para la ruta se consultan los datos de
//             // los mismos
//             // De lo contrario, se omite el proceso
//             if (cantidadVuelos > 0) {
//                 kilometrosRecorridos = distancia * cantidadVuelos;
//                 for (int i = 1; i <= cantidadVuelos; i++) {

//                     out.println("Digite la cantidad de tiquetes regulares vendidos en el vuelo " + i + ": ");
//                     cantidadTiquetesRegulares = Integer.parseInt(in.readLine());
//                     out.println("Digite la cantidad de tiquetes preferenciales vendidos en el vuelo " + i + ": ");
//                     cantidadTiquetesPreferenciales = Integer.parseInt(in.readLine());
//                     out.println("Digite la cantidad de tiquetes de primera clase vendidos en el vuelo " + i + ": ");
//                     cantidadTiquetesPrimeraClase = Integer.parseInt(in.readLine());
//                     pasajerosRuta += cantidadTiquetesRegulares + cantidadTiquetesPreferenciales
//                             + cantidadTiquetesPrimeraClase;
//                     ingresosRegular += cantidadTiquetesRegulares * precioRegular;
//                     ingresosPreferencial += cantidadTiquetesPreferenciales * precioPreferencial;
//                     ingresosPrimeraClase += cantidadTiquetesPrimeraClase * precioPrimeraClase;
//                 }
//                 // Se compara la cantidad de vuelos realizados en esta ruta con la variable
//                 // maximoVuelos
//                 // Se verifica si es la ruta con mayor cantidad de vuelos registrados y se
//                 // almacena su valor en caso de serlo
//                 if (cantidadVuelos > maximoVuelos) {
//                     maximoVuelos = cantidadVuelos;
//                     rutaMasVuelos = "Ruta " + "(" + origen + " - " + destino + ")";
//                 } else if (cantidadVuelos == maximoVuelos) {
//                     rutaMasVuelos += "Ruta " + "(" + origen + " - " + destino + ")";
//                 }
//                 ingresosRuta += ingresosRegular + ingresosPreferencial + ingresosPrimeraClase;

//                 reportePorRutas += "\n-----------------------------------------\n";
//                 reportePorRutas += "Desglose ruta " + "(" + origen + " - " + destino + ")";
//                 reportePorRutas += "\n-----------------------------------------\n";
//                 reportePorRutas += "Ingresos de tiquetes regulares: " + "$" + ingresosRegular + "\n";
//                 reportePorRutas += "Ingresos de tiquetes preferenciales: " + "$" + ingresosPreferencial + "\n";
//                 reportePorRutas += "Ingresos de tiquetes de primera clase: " + "$" + ingresosPrimeraClase + "\n";
//                 reportePorRutas += "Total de ingresos obtenidos en la ruta: " + "$" + ingresosRuta + "\n";
//                 // Se acumulan los resultados de la ruta en las variables acumuladoras del
//                 // programa
//                 pasajerosTotales += pasajerosRuta;
//                 ingresosRegularTotal += ingresosRegular;
//                 ingresosPreferencialTotal += ingresosPreferencial;
//                 ingresosPrimeraClaseTotal += ingresosPrimeraClase;
//                 ingresosTotales += ingresosRuta;
//                 kilometrosTotales += kilometrosRecorridos;
//             } else {
//                 out.println("No se vendieron vuelos en la ruta " + "(" + origen + " - " + destino + ")");
//                 reportePorRutas += "\n-----------------------------------------\n";
//                 reportePorRutas += "Desglose ruta " + "(" + origen + " - " + destino + ")";
//                 reportePorRutas += "\n-----------------------------------------\n";
//                 reportePorRutas += "No se reportaron ganancias para esta ruta \n";
//             }
//         }
//         // Se imprimen los valores almacenados en las diferentes variables acumuladoras
//         // Estas contienen los resultados obtenidos a lo largo del programa
//         out.println("\n" + "¡Muchas gracias por ingresar la información!");
//         out.println("El reporte de cada una de las rutas es: " + "\n" + reportePorRutas);
//         out.println("El reporte final de las rutas es: ");
//         out.println("Total de pasajeros en todas las rutas: " + pasajerosTotales);
//         out.println("Total de kilómetros recorridos durante los vuelos: " + kilometrosTotales);
//         out.println("La(s) ruta(s) con más vuelos realizados: " + rutaMasVuelos);
//         out.println("-----------------------------");
//         out.println("Recaudación de las rutas");
//         out.println("-----------------------------");
//         out.println("Regular: $" + ingresosRegularTotal);
//         out.println("Preferencial: $" + ingresosPreferencialTotal);
//         out.println("Primera clase: $" + ingresosPrimeraClaseTotal);
//         out.println("TOTAL: $" + ingresosTotales);
//         out.println("-----------------------------");
//     }
// }
