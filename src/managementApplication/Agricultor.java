package managementApplication;

public class Agricultor extends Cliente{
    /**
     * Atributos
     */
    String cultivo;
    int numeroInvernaderos;
    String comunidadRegantes;

    /**
     * Constructor
     */
    public Agricultor(String nif, String nombre, String apellidos, String direccion, String localidad, String codigoPostal, int telefono, String cultivo, int numeroInvernaderos, String comunidadRegantes) {
        super(nif, nombre, apellidos, direccion, localidad, codigoPostal, telefono);
        this.cultivo = cultivo;
        this.numeroInvernaderos = numeroInvernaderos;
        this.comunidadRegantes = comunidadRegantes;
    }

    /**
     * Get y Set
     */

    public String getCultivo() {
        return cultivo;
    }

    public void setCultivo(String cultivo) {
        this.cultivo = cultivo;
    }

    public int getNumeroInvernaderos() {
        return numeroInvernaderos;
    }

    public void setNumeroInvernaderos(int numeroInvernaderos) {
        this.numeroInvernaderos = numeroInvernaderos;
    }

    public String getComunidadRegantes() {
        return comunidadRegantes;
    }

    public void setComunidadRegantes(String comunidadRegantes) {
        this.comunidadRegantes = comunidadRegantes;
    }
}
