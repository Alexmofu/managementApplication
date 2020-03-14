package managementApplication;

public class Producto extends GestionDatos{
    /**
     * Atributos
     */
    private String codigo;
    private String nombre;
    private String descripcion;
    private int unidades;

    /**
     * Constructor Productos
     */
    public Producto(String codigo, String nombre, String descripcion, int unidades) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.unidades = unidades;
    }

    /**
     * Set & Get
     */
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }
}


