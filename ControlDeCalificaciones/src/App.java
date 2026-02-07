import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Alumno alumno = new Alumno();
        GradeService cal = new GradeService();

        System.out.print("Nombre del alumno: ");
        alumno.setNombre(sc.nextLine());

        double[] parciales = new double[3];

        for (int i = 0; i < 3; i++) {
            parciales[i] = leerDouble(sc, "Parcial " + (i + 1) + ": ");
        }

        alumno.setParciales(parciales);

        alumno.setAsistencia(leerInt(sc, "Asistencia (0-100): "));

        alumno.setEntregoProyecto(leerBoolean(sc, "Entrego proyecto (true/false): "));

        double promedio = cal.calcularPromedio(
                parciales[0],
                parciales[1],
                parciales[2]
        );

        alumno.setPromedio(promedio);

        double finalCalif = cal.calcularFinal(promedio, alumno.getAsistencia());
        alumno.setCalificacionFinal(finalCalif);

        String estado = cal.estadoFinal(
                finalCalif,
                alumno.getAsistencia(),
                alumno.isEntregoProyecto()
        );

        alumno.setEstado(estado);

        mostrarResultado(alumno);
    }

    // -------- lectura de datos --------

    public static double leerDouble(Scanner sc, String msg) {

        double valor;

        while (true) {
            System.out.print(msg);

            if (sc.hasNextDouble()) {
                valor = sc.nextDouble();
                sc.nextLine();

                if (valor >= 0 && valor <= 100) {
                    return valor;
                }
            } else {
                sc.nextLine();
            }

            System.out.println("Dato invalido. Intenta otra vez.");
        }
    }

    public static int leerInt(Scanner sc, String msg) {

        int valor;

        while (true) {
            System.out.print(msg);

            if (sc.hasNextInt()) {
                valor = sc.nextInt();
                sc.nextLine();

                if (valor >= 0 && valor <= 100) {
                    return valor;
                }
            } else {
                sc.nextLine();
            }

            System.out.println("Dato invalido. Intenta otra vez.");
        }
    }

    public static boolean leerBoolean(Scanner sc, String msg) {

        while (true) {
            System.out.print(msg);
            String txt = sc.nextLine();

            if (txt.equalsIgnoreCase("true")) {
                return true;
            }

            if (txt.equalsIgnoreCase("false")) {
                return false;
            }

            System.out.println("Escribe true o false.");
        }
    }

    // -------- salida --------

    public static void mostrarResultado(Alumno a) {

        System.out.println();
        System.out.println("Alumno: " + a.getNombre());

        System.out.print("Parciales: ");
        for (double p : a.getParciales()) {
            System.out.print(p + " ");
        }

        System.out.println();
        System.out.println("Promedio: " + a.getPromedio());
        System.out.println("Asistencia: " + a.getAsistencia());
        System.out.println("Entrego proyecto: " + a.isEntregoProyecto());
        System.out.println("Calificacion final: " + a.getCalificacionFinal());
        System.out.println("Estado: " + a.getEstado());
    }
}
