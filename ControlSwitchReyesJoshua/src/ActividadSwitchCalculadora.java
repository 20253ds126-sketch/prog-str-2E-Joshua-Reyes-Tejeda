import java.util.Scanner;

public class ActividadSwitchCalculadora {

    public static final int OPCION_SUMAR = 1;
    public static final int OPCION_RESTAR = 2;
    public static final int OPCION_MULTIPLICAR = 3;
    public static final int OPCION_DIVIDIR = 4;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        mostrarMenu();

        int opcion = pedirEntero(scanner, "Selecciona una opcion: ");

        double a = pedirDouble(scanner, "Ingresa a: ");
        double b = pedirDouble(scanner, "Ingresa b: ");

        ejecutarOperacion(opcion, a, b);
    }

    /**
     * Metodo que imprime el menu de opciones
     */
    public static void mostrarMenu() {
        System.out.println("1) Sumar");
        System.out.println("2) Restar");
        System.out.println("3) Multiplicar");
        System.out.println("4) Dividir");
    }

    /**
     * Metodo que solicita un entero por consola
     *
     * @param scanner -> previamente creado en main
     * @param mensaje -> texto mostrado al usuario
     * @return -> entero capturado
     */
    public static int pedirEntero(Scanner scanner, String mensaje) {
        System.out.print(mensaje);
        return scanner.nextInt();
    }

    /**
     * Metodo que solicita un double por consola
     *
     * @param scanner -> previamente creado en main
     * @param mensaje -> texto mostrado al usuario
     * @return -> valor double capturado
     */
    public static double pedirDouble(Scanner scanner, String mensaje) {
        System.out.print(mensaje);
        return scanner.nextDouble();
    }

    /**
     * Metodo principal que ejecuta la operacion seleccionada
     *
     * @param opcion -> opcion elegida del menu
     * @param a -> primer valor
     * @param b -> segundo valor
     */
    public static void ejecutarOperacion(int opcion, double a, double b) {

        String operacionTexto;
        double resultado;

        switch (opcion) {

            case OPCION_SUMAR:
                operacionTexto = "Suma";
                resultado = a + b;
                imprimirResultado(operacionTexto, a, b, resultado);
                break;

            case OPCION_RESTAR:
                operacionTexto = "Resta";
                resultado = a - b;
                imprimirResultado(operacionTexto, a, b, resultado);
                break;

            case OPCION_MULTIPLICAR:
                operacionTexto = "Multiplicacion";
                resultado = a * b;
                imprimirResultado(operacionTexto, a, b, resultado);
                break;

            case OPCION_DIVIDIR:

                operacionTexto = "Division";

                if (b == 0) {
                    System.out.println("No se puede dividir entre cero");
                } else {
                    resultado = a / b;
                    imprimirResultado(operacionTexto, a, b, resultado);
                }

                break;

            default:
                System.out.println("Opción inválida");
                break;
        }

    }

    /**
     * Metodo que imprime los datos finales del programa
     *
     * @param operacionTexto -> nombre de la operacion
     * @param a -> valor ingresado
     * @param b -> valor ingresado
     * @param resultado -> resultado calculado
     */
    public static void imprimirResultado(String operacionTexto, double a, double b, double resultado) {

        System.out.println("Operacion: " + operacionTexto);
        System.out.println("Valor a: " + a);
        System.out.println("Valor b: " + b);
        System.out.println("Resultado: " + resultado);
    }
}