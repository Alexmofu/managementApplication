package managementApplication;

public class Incidencia extends GestionDatos{
    /**
     * Atributos
     */
    private int codigo;
    private String nombreCliente;
    private String descripcion;
    private boolean status;
    TipoIncidencia tipoIncidente;

    /**
     * Constructor de Incidencias
     */

    public Incidencia(int codigo, String nombreCliente, String descripcion, TipoIncidencia tipoIncidente, boolean status) {
        this.codigo = codigo;
        this.nombreCliente = nombreCliente;
        this.descripcion = descripcion;
        this.tipoIncidente = tipoIncidente;
        this.status = status;
    }

    /**
     * Get & Set
     */

    public TipoIncidencia getTipoIncidente() {
        return tipoIncidente;
    }

    public void setTipoIncidente(TipoIncidencia tipoIncidente) {
        this.tipoIncidente = tipoIncidente;
    }

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
