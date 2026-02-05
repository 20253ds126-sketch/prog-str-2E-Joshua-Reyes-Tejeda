public class ShippingCalculator {

    private double BASE_ESTANDAR = 50;
    private double BASE_EXPRESS = 90;
    private double COSTO_KG = 12;
    private double IVA_RATE = 0.16;

    public double calcularSubtotal(double pesoKg, int distanciaKm,
                                   int tipoServicio, boolean zonaRemota){

        double subtotal = 0;

        if(tipoServicio == 1){
            subtotal += BASE_ESTANDAR;
        }else{
            subtotal += BASE_EXPRESS;
        }

        subtotal += pesoKg * COSTO_KG;

        if(distanciaKm <= 50){
            subtotal += 20;
        }
        else if(distanciaKm <= 200){
            subtotal += 60;
        }
        else{
            subtotal += 120;
        }

        if(zonaRemota){
            subtotal += subtotal * 0.10;
        }

        return subtotal;
    }

    public double calcularIVA(double subtotal){
        return subtotal * IVA_RATE;
    }

    public double calcularTotal(double subtotal, double iva){
        return subtotal + iva;
    }
}

