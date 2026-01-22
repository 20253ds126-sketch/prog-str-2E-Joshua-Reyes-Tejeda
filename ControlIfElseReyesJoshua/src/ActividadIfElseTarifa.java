import java.util.Scanner;

public class ActividadIfElseTarifa {

    public static final int EDAD_MINIMA = 0;
    public static final int EDAD_MAXIMA = 120;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int edad = pedirEntero(scanner, "Ingresa la edad: ");
        boolean esEstudiante = pedirBoolean(scanner, "Es estudiante? (true/false): ");

        if (!edadValida(edad)) {
            System.out.println("Edad inválida");
            return;
        }

        int tarifa = calcularTarifa(edad, esEstudiante);

        imprimirResultado(edad, esEstudiante, tarifa);
    }

    /**
     * Metodo que solicita un entero por consola
     *
     * @param scanner -> previamente creado en main
     * @param mensaje -> texto mostrado al usuario
     * @return -> valor entero ingresado
     */
    public static int pedirEntero(Scanner scanner, String mensaje) {
        System.out.print(mensaje);
        return scanner.nextInt();
    }

    /**
     * Metodo que solicita un booleano por consola
     *
     * @param scanner -> previamente creado en main
     * @param mensaje -> texto mostrado al usuario
     * @return -> true o false segun entrada del usuario
     */
    public static boolean pedirBoolean(Scanner scanner, String mensaje) {
        System.out.print(mensaje);
        return scanner.nextBoolean();
    }

    /**
     * Metodo que valida si la edad se encuentra en rango permitido
     *
     * @param edad -> edad ingresada por usuario
     * @return -> true si es valida, false si no
     */
    public static boolean edadValida(int edad) {
        return edad >= EDAD_MINIMA && edad <= EDAD_MAXIMA;
    }

    /**
     * Metodo que calcula la tarifa segun reglas de negocio
     *
     * @param edad -> edad validada
     * @param esEstudiante -> indica si es estudiante
     * @return -> tarifa final
     */
    public static int calcularTarifa(int edad, boolean esEstudiante) {

        int tarifa;

        if (edad < 12) {
            tarifa = 50;
        } else if (edad <= 17) {

            if (esEstudiante) {
                tarifa = 60;
            } else {
                tarifa = 80;
            }

        } else {

            if (esEstudiante) {
                tarifa = 90;
            } else {
                tarifa = 120;
            }

        }

        return tarifa;
    }

    /**
     * Metodo que imprime los datos finales del programa
     *
     * @param edad -> edad ingresada
     * @param esEstudiante -> si es estudiante o no
     * @param tarifa -> tarifa calculada
     */
    public static void imprimirResultado(int edad, boolean esEstudiante, int tarifa) {

        System.out.println("Edad ingresada: " + edad);

        if (esEstudiante) {
            System.out.println("Es estudiante: SI");
        } else {
            System.out.println("Es estudiante: NO");
        }

        System.out.println("Tarifa final: " + tarifa);
    }
}