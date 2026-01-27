import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int opcion;

        int contCtoF = 0;
        int contFtoC = 0;
        int contKmMillas = 0;
        int contMillasKm = 0;

        do {

            mostrarMenu();

            opcion = obtenerOpcionValida(scanner);

            switch (opcion) {

                case 1:
                    double celsius = obtenerNumero(scanner, "Ingresa grados Celsius:");
                    double fahrenheit = (celsius * 9 / 5) + 32;
                    System.out.println("Resultado: " + fahrenheit + " °F");
                    contCtoF++;
                    break;

                case 2:
                    double far = obtenerNumero(scanner, "Ingresa grados Fahrenheit:");
                    double cel = (far - 32) * 5 / 9;
                    System.out.println("Resultado: " + cel + " °C");
                    contFtoC++;
                    break;

                case 3:
                    double km = obtenerNumero(scanner, "Ingresa kilometros:");
                    double millas = km * 0.621371;
                    System.out.println("Resultado: " + millas + " millas");
                    contKmMillas++;
                    break;

                case 4:
                    double mi = obtenerNumero(scanner, "Ingresa millas:");
                    double kms = mi / 0.621371;
                    System.out.println("Resultado: " + kms + " km");
                    contMillasKm++;
                    break;

                case 5:
                    System.out.println("Saliendo del programa...");
                    break;

            }

            System.out.println();

        } while (opcion != 5);

        int total = contCtoF + contFtoC + contKmMillas + contMillasKm;

        System.out.println("----- RESUMEN -----");
        System.out.println("Total de conversiones: " + total);
        System.out.println("Celsius a Fahrenheit: " + contCtoF);
        System.out.println("Fahrenheit a Celsius: " + contFtoC);
        System.out.println("Km a Millas: " + contKmMillas);
        System.out.println("Millas a Km: " + contMillasKm);

        scanner.close();
    }

    /**
     * Muestra en pantalla el menu principal de conversiones.
     */
    public static void mostrarMenu() {

        System.out.println("MENU DE CONVERSIONES");
        System.out.println("1) °C a °F");
        System.out.println("2) °F a °C");
        System.out.println("3) Km a Millas");
        System.out.println("4) Millas a Km");
        System.out.println("5) Salir");
    }

    /**
     * Solicita al usuario una opcion del menú y lo valida
     *
     * @param scanner objeto Scanner para leer datos del teclado
     * @return opcion valida elegida por el usuario
     */
    public static int obtenerOpcionValida(Scanner scanner) {

        int opcion;

        while (true) {

            System.out.print("Selecciona una opcion (1-5): ");

            if (scanner.hasNextInt()) {

                opcion = scanner.nextInt();

                if (opcion >= 1 && opcion <= 5) {
                    return opcion;
                }

                System.out.println("Opcion invalida, intenta de nuevo.");

            } else {
                System.out.println("Debes ingresar un numero.");
                scanner.next();
            }
        }
    }

    /**
     * Solicita al usuario un valor numerico (double) y lo valida
     *
     * @param scanner objeto Scanner para leer datos del teclado
     * @param mensaje texto que se muestra al usuario al pedir el dato
     * @return valor numerico ingresado
     */
    public static double obtenerNumero(Scanner scanner, String mensaje) {

        double valor;

        while (true) {

            System.out.println(mensaje);

            if (scanner.hasNextDouble()) {

                valor = scanner.nextDouble();
                return valor;

            } else {

                System.out.println("Dato invalido, intenta nuevamente.");
                scanner.next();
            }
        }
    }

}
