import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int a = pedirEntero(scanner, "a: ");
        int b = pedirEntero(scanner, "b: ");
        int c = pedirEntero(scanner, "c: ");

        int suma = calcularSuma(a, b, c);

        mostrarResultados(suma);
    }

    /**
     * Metodo que solicita un numero entero por consola
     * @param scanner -> previamente declarado en main
     * @param mensaje -> texto que se muestra al usuario
     * @return -> valor entero capturado
     */
    public static int pedirEntero(Scanner scanner, String mensaje) {
        System.out.print(mensaje);
        return scanner.nextInt();
    }

    /**
     * Metodo que calcula la suma de tres numeros enteros
     * @param a -> primer valor entero
     * @param b -> segundo valor entero
     * @param c -> tercer valor entero
     * @return -> suma de los tres valores
     */
    public static int calcularSuma(int a, int b, int c) {
        return a + b + c;
    }

    /**
     * Metodo que muestra en consola la suma y el promedio
     * @param suma -> resultado de la suma de los valores
     */
    public static void mostrarResultados(int suma) {
        System.out.println("suma=" + suma);
        System.out.println("prom=" + (suma / 3.0));
    }

}