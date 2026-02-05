import java.util.*;

public class Main {

    private static final int MIN = 1;
    private static final int MAX = 100;
    private static final int LIMITE_INTENTOS = 7;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int secreto = generarNumeroSecreto(random);
        boolean gano = false;
        int intentos = 0;

        int fueraRango = 0;
        int noNumericos = 0;

        System.out.println("Adivina el numero entre " + MIN + " y " + MAX);
        System.out.println("Tienes " + LIMITE_INTENTOS + " intentos.");

        while (intentos < LIMITE_INTENTOS && !gano) {

            int resultado = pedirNumero(scanner);

            if (resultado == Integer.MIN_VALUE) {
                noNumericos++;
                continue;
            }

            if (resultado < MIN || resultado > MAX) {
                fueraRango++;
                System.out.println("Numero fuera de rango. Debe ser entre " + MIN + " y " + MAX);
                continue;
            }

            intentos++;

            if (resultado == secreto) {
                System.out.println("¡Ganaste!");
                gano = true;

            } else if (resultado > secreto) {
                System.out.println("El numero secreto es menor.");

            } else {
                System.out.println("El numero secreto es mayor.");
            }
        }

        mostrarResultadoFinal(gano, secreto, fueraRango, noNumericos);

        scanner.close();
    }

    /**
     * Genera un numero aleatorio entre MIN y MAX.
     *
     * @param random generador de numeros aleatorios
     * @return numero secreto
     */
    public static int generarNumeroSecreto(Random random) {
        return random.nextInt(MAX - MIN + 1) + MIN;
    }

    /**
     * Solicita al usuario un numero por teclado.
     *
     * @param scanner objeto Scanner para leer datos
     * @return numero ingresado o Integer.MIN_VALUE si no es numerico
     */
    public static int pedirNumero(Scanner scanner) {

        System.out.print("Ingresa un numero: ");

        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        } else {
            System.out.println("Entrada no numerica.");
            scanner.next();
            return Integer.MIN_VALUE;
        }
    }

    /**
     * Muestra el resumen final del juego.
     *
     * @param gano indica si el jugador gano
     * @param secreto numero secreto
     * @param fueraRango cantidad de numeros fuera del rango
     * @param noNumericos cantidad de entradas no numericas
     */
    public static void mostrarResultadoFinal(boolean gano, int secreto,
                                             int fueraRango, int noNumericos) {

        System.out.println();
        System.out.println("----- RESULTADO FINAL -----");

        if (!gano) {
            System.out.println("Perdiste. El numero secreto era: " + secreto);
        }

        System.out.println("Fuera de rango: " + fueraRango);
        System.out.println("Entradas no numericas: " + noNumericos);
    }
}
