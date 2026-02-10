import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Persona[] personas = new Persona[20];

        int opcion = -1;

        while (opcion != 0) {

            System.out.println("1) Alta");
            System.out.println("2) Buscar por ID");
            System.out.println("3) Baja logica por ID");
            System.out.println("4) Listar activas");
            System.out.println("5) Actualizar nombre por ID");
            System.out.println("0) Salir");

            opcion = sc.nextInt();
            sc.nextLine();

            if (opcion == 1) {

                System.out.println("ID:");
                int id = sc.nextInt();
                sc.nextLine();

                if (id <= 0) {
                    System.out.println("ID invalido");
                    continue;
                }

                boolean repetido = false;

                for (int i = 0; i < personas.length; i++) {
                    if (personas[i] != null && personas[i].getId() == id) {
                        repetido = true;
                    }
                }

                if (repetido) {
                    System.out.println("ID repetido");
                    continue;
                }

                System.out.println("Nombre:");
                String nombre = sc.nextLine();

                if (nombre.isEmpty()) {
                    System.out.println("Nombre invalido");
                    continue;
                }

                boolean agregado = false;

                for (int i = 0; i < personas.length; i++) {
                    if (personas[i] == null) {
                        personas[i] = new Persona(id, nombre);
                        agregado = true;
                        break;
                    }
                }

                if (!agregado) {
                    System.out.println("Arreglo lleno");
                }

            } else if (opcion == 2) {

                System.out.println("ID:");
                int id = sc.nextInt();

                boolean encontrada = false;

                for (int i = 0; i < personas.length; i++) {
                    if (personas[i] != null && personas[i].getId() == id && personas[i].isActiva()) {
                        System.out.println(personas[i]);
                        encontrada = true;
                    }
                }

                if (!encontrada) {
                    System.out.println("No encontrada o inactiva");
                }

            } else if (opcion == 3) {

                System.out.println("ID:");
                int id = sc.nextInt();

                boolean baja = false;

                for (int i = 0; i < personas.length; i++) {
                    if (personas[i] != null && personas[i].getId() == id && personas[i].isActiva()) {
                        personas[i].setActiva(false);
                        baja = true;
                    }
                }

                if (!baja) {
                    System.out.println("No encontrada o inactiva");
                }

            } else if (opcion == 4) {

                for (int i = 0; i < personas.length; i++) {
                    if (personas[i] != null && personas[i].isActiva()) {
                        System.out.println(personas[i]);
                    }
                }

            } else if (opcion == 5) {

                System.out.println("ID:");
                int id = sc.nextInt();
                sc.nextLine();

                boolean actualizada = false;

                for (int i = 0; i < personas.length; i++) {
                    if (personas[i] != null && personas[i].getId() == id && personas[i].isActiva()) {

                        System.out.println("Nuevo nombre:");
                        String nombre = sc.nextLine();

                        if (nombre.isEmpty()) {
                            System.out.println("Nombre invalido");
                            actualizada = true;
                            break;
                        }

                        personas[i].setNombre(nombre);
                        actualizada = true;
                    }
                }

                if (!actualizada) {
                    System.out.println("No encontrada o inactiva");
                }

            } else if (opcion == 0) {

                System.out.println("Fin");

            } else {

                System.out.println("Opcion invalida");

            }
        }

        sc.close();
    }
}

