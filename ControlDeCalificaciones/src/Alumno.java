public class Alumno {

    private String nombre;
    private double[] parciales;
    private int asistencia;
    private boolean entregoProyecto;

    private double promedio;
    private double calificacionFinal;
    private String estado;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double[] getParciales() {
        return parciales;
    }

    public void setParciales(double[] parciales) {
        this.parciales = parciales;
    }

    public int getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(int asistencia) {
        this.asistencia = asistencia;
    }

    public boolean isEntregoProyecto() {
        return entregoProyecto;
    }

    public void setEntregoProyecto(boolean entregoProyecto) {
        this.entregoProyecto = entregoProyecto;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    public double getCalificacionFinal() {
        return calificacionFinal;
    }

    public void setCalificacionFinal(double calificacionFinal) {
        this.calificacionFinal = calificacionFinal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}