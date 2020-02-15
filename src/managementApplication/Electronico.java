package managementApplication;

public class Electronico extends Producto{
    /**
     * Atributos
     */
    float tensionTrabajo;
    float temperaturaMaxima;
    int[] dimensiones;


    /**
     * Constructor Electrónico
     */

    public Electronico(String codigo, String nombre, String descripcion, int unidades, float tensionTrabajo, float temperaturaMaxima, int[] dimensiones) {
        super(codigo, nombre, descripcion, unidades);
        this.tensionTrabajo = tensionTrabajo;
        this.temperaturaMaxima = temperaturaMaxima;
        this.dimensiones = dimensiones;
    }

    /**
     * Get y Set
     */
    public float getTensionTrabajo() {
        return tensionTrabajo;
    }

    public void setTensionTrabajo(float tensionTrabajo) {
        this.tensionTrabajo = tensionTrabajo;
    }

    public float getTemperaturaMaxima() {
        return temperaturaMaxima;
    }

    public void setTemperaturaMaxima(float temperaturaMaxima) {
        this.temperaturaMaxima = temperaturaMaxima;
    }

    public int[] getDimensiones() {
        return dimensiones;
    }

    public void setDimensiones(int[] dimensiones) {
        this.dimensiones = dimensiones;
    }
}
