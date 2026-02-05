import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ShippingCalculator calc = new ShippingCalculator();

        //input
        double pesoKg = leerDoubleEnRango(sc, "Ingresa el peso (0.1 - 50.0): ", 0.1, 50.0);
        int distanciaKm = leerIntEnRango(sc, "Ingresa la distancia (1 - 2000): ", 1, 2000);
        int tipoServicio = leerIntEnRango(sc, "Tipo de servicio (1=Estándar, 2=Express): ", 1, 2);
        boolean zonaRemota = leerBoolean(sc, "¿Es zona remota? (true/false): ");

        //process
        double subtotal = calc.calcularSubtotal(pesoKg, distanciaKm, tipoServicio, zonaRemota);
        double iva = calc.calcularIVA(subtotal);
        double total = calc.calcularTotal(subtotal, iva);

        //output
        imprimirTicket(tipoServicio, pesoKg, distanciaKm, zonaRemota, subtotal, iva, total);

        sc.close();
    }

    public static double leerDoubleEnRango(Scanner sc, String msg, double min, double max){
        double valor;

        while(true){
            System.out.println(msg);

            if(sc.hasNextDouble()){
                valor = sc.nextDouble();

                if(valor >= min && valor <= max){
                    return valor;
                }
                System.out.println("Valor fuera de rango.");
            }else{
                System.out.println("Entrada invalida.");
                sc.next();
            }
        }
    }

    public static int leerIntEnRango(Scanner sc, String msg, int min, int max){
        int valor;

        while(true){
            System.out.println(msg);

            if(sc.hasNextInt()){
                valor = sc.nextInt();

                if(valor >= min && valor <= max){
                    return valor;
                }
                System.out.println("Valor fuera de rango.");
            }else{
                System.out.println("Entrada invalida.");
                sc.next();
            }
        }
    }

    public static boolean leerBoolean(Scanner sc, String msg){

        while(true){
            System.out.println(msg);
            String entrada = sc.next();

            if(entrada.equalsIgnoreCase("true")){
                return true;
            }
            else if(entrada.equalsIgnoreCase("false")){
                return false;
            }
            else{
                System.out.println("Solo escribe true o false.");
            }
        }
    }

    public static void imprimirTicket(int servicio, double peso, int distancia,
                                      boolean zonaRemota, double subtotal,
                                      double iva, double total) {

        String nombreServicio;

        if(servicio == 1){
            nombreServicio = "Estándar";
        }else{
            nombreServicio = "Express";
        }

        System.out.println("---Ticket---");
        System.out.println("Servicio: " + nombreServicio);
        System.out.println("Peso: " + peso + " kg");
        System.out.println("Distancia: " + distancia + " km");
        System.out.println("Zona remota: " + zonaRemota);
        System.out.println("Subtotal: $" + subtotal);
        System.out.println("IVA: $" + iva);
        System.out.println("Total: $" + total);
        System.out.println("---Ticket---");
    }
}
