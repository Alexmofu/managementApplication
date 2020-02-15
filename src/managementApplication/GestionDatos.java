package managementApplication;

public class GestionDatos {
    /**
     * Atributos
     */
    private final static int year = 2020;

    /**
     * Arrays
     */
    public static Cliente[] ArrayClientes = new Cliente[100];
    public static Producto[] ArrayProductos = new Producto[100];
    public static Incidencia[] ArrayIncidencias = new Incidencia[1000];

    public static void inicializarDatos() {
        ArrayClientes[0] = new Agricultor("12128623Z", "Manolo", "Diaz", "C/ Pastor", "Madrid", "28001", 758354021,"Tomates",5,"Tomateros");
        ArrayClientes[1] = new Agricultor("52789624Z", "Carmen", "Lopez", "C/ Albañiz", "Madrid", "28001", 662712367,"Patatas",20,"Patateros");
        ArrayClientes[2] = new Distribuidor("98711202Z", "Rodrigo", "Ortiz", "C/ Juan Carlos", "Madrid", "28001", 658175369,45,FormaDePago.CONTADO);
        ArrayClientes[3] = new Distribuidor("123456789Z","Pruebas","Mc Milan","C/ Testeo","Pruebalandia","12345",987523456,20,FormaDePago.SESENTA_DIAS);
        ArrayProductos[0] = new Producto("1", "Champú Genérico", "Marca Blanca Genérica del champú más barato 2€", 3027);
        ArrayProductos[1] = new Producto("2", "Cortauñas", "Cortauñas hidráulico de alta presión 700€", 147);
        ArrayProductos[2] = new Producto("3", "Pierna Robótica", "Pierna de alta presión con capacidad de salto alta 825€", 15);
        ArrayIncidencias[0] = new Incidencia(1, "Manolo", "Se me ha caido todo el pelo por hecharme ese champú", TipoIncidencia.HARDWARE, false);
        ArrayIncidencias[1] = new Incidencia(2, "Manolo", "La pierna Robótica no enciende", TipoIncidencia.SOFTWARE, true);
        ArrayIncidencias[2] = new Incidencia(3, "Carmen", "Mi marido manolo ha muerto por culpa de el cortauñas hidráulico", TipoIncidencia.PRESUPUESTO, false);
    }

    /**
     * Gets
     */
    public Cliente getCliente(int numeroCliente) {
        return ArrayClientes[numeroCliente];
    }

    public Producto getProducto(int numeroProducto) {
        return ArrayProductos[numeroProducto];
    }

    public Incidencia getIncidencia(int numeroIncidencia) {
        return ArrayIncidencias[numeroIncidencia];
    }

    public Cliente getUltimoCliente() {
        int i;
        for (i = 0; i < ArrayClientes.length; i++) {
            if (ArrayClientes[i] == null) {
                break;
            }
            i++;
        }
        return ArrayClientes[i - 1];
    }

    public Producto getUltimoProducto() {
        int i;
        for (i = 0; i < ArrayProductos.length; i++) {
            if (ArrayProductos[i] == null) {
                break;
            }
            i++;
        }
        return ArrayProductos[i - 1];
    }

    public Incidencia getUltimaIncidencia() {
        int i;
        for (i = 0; i < ArrayIncidencias.length; i++) {
            if (ArrayIncidencias[i] == null) {
                break;
            }
            i++;
        }
        return (ArrayIncidencias[i - 1]);
    }
}
