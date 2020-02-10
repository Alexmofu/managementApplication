package managementApplication;

public class Incidencia {
    /**
     * Atributos
     */
    private int codigo;
    private String nombreCliente;
    private String descripcion;
    private boolean status;

    /**
     * Constructor de Incidencias
     */

    public Incidencia(int codigo, String nombreCliente, String descripcion, boolean status) {
        this.codigo = codigo;
        this.nombreCliente = nombreCliente;
        this.descripcion = descripcion;
        this.status = status;
    }

    /**
     * Get & Set
     */

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
