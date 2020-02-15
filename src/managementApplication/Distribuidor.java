package managementApplication;

public class Distribuidor extends Cliente{
    /**
     * Atributos
     */
    float creditoDisponible;
    FormaDePago  newFormaDePago;

    /**
     * Constructor
     */
    public Distribuidor(String nif, String nombre, String apellidos, String direccion, String localidad, String codigoPostal, int telefono, float creditoDisponible, FormaDePago newFormaDePago) {
        super(nif, nombre, apellidos, direccion, localidad, codigoPostal, telefono);
        this.creditoDisponible = creditoDisponible;
        this.newFormaDePago = newFormaDePago;
    }

    /**
     * Get y Set
     */

    public float getCreditoDisponible() {
        return creditoDisponible;
    }

    public void setCreditoDisponible(float creditoDisponible) {
        this.creditoDisponible = creditoDisponible;
    }

    public FormaDePago getNewFormaDePago() {
        return newFormaDePago;
    }

    public void setNewFormaDePago(FormaDePago newFormaDePago) {
        this.newFormaDePago = newFormaDePago;
    }
}
