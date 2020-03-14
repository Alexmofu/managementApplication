package managementApplication;

import com.sun.security.ntlm.Client;
import sun.swing.StringUIClientPropertyKey;

import java.io.*;
import java.nio.Buffer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GestionDatos implements Serializable{
    /**
     * Atributos
     */
    private final static int year = 2020;
    public static String rutaGuardado = "datos.dat";
    public static String rutaErrores = "errores.dat";

    /**
     * Serialización de datos (Guardado y Carga de Archivos)
     */

    public static void guardarDatos(){
        boolean status = false;
        try{
            FileOutputStream fos = new FileOutputStream(rutaGuardado);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(ArrayClientes);
            oos.writeObject(ArrayProductos);
            oos.writeObject(ArrayIncidencias);
            oos.flush();
            oos.close();
            System.out.println("guardado completado");
            status = true;

        }catch (Exception e){
            escribirFallo(e);
            System.out.println("Error al guardar los datos");
            status = false;
        }
    }

    ///

    public static void cargarDatos(){
        boolean status = false;
        try{
            FileInputStream fis = new FileInputStream(rutaGuardado);
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayClientes = (Cliente[])ois.readObject();
            ArrayProductos = (Producto[])ois.readObject();
            ArrayIncidencias = (Incidencia[])ois.readObject();
            ois.close();
            System.out.println("carga completada");
            status = true;

        }catch (Exception e){
            escribirFallo(e);
            System.out.println("Error al cargar los datos");
            status = false;
        }
    }

    /**
     * Método para escribir en un documento los errores que se registran
     * @param e datos que recibe del error en el catch
     */
    public static void escribirFallo(Exception e) {
        String fecha = new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date());
        try {
            FileOutputStream fos = new FileOutputStream(rutaErrores,true);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
            bw.newLine();
            bw.write("["+fecha+"]");
            bw.newLine();
            bw.newLine();
            bw.write(e.toString());
            bw.newLine();
            bw.flush();
            bw.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    /**
     * Arrays
     */
    public static Cliente[] ArrayClientes = new Cliente[100];
    public static Producto[] ArrayProductos = new Producto[100];
    public static Incidencia[] ArrayIncidencias = new Incidencia[1000];

    public static void inicializarDatos() { // YA NO HACE FALTA, PER LO DEJO POR DEBUG
/**
        ArrayClientes[0] = new Agricultor("12128623Z", "Manolo", "Diaz", "C/ Pastor", "Madrid", "28001", 758354021,"Tomates",5,"Tomateros");
        ArrayClientes[1] = new Agricultor("52789624Z", "Carmen", "Lopez", "C/ Albañiz", "Madrid", "28001", 662712367,"Patatas",20,"Patateros");
        ArrayClientes[2] = new Distribuidor("98711202Z", "Rodrigo", "Ortiz", "C/ Juan Carlos", "Madrid", "28001", 658175369,45,FormaDePago.CONTADO);
        ArrayClientes[3] = new Distribuidor("123456789Z","Pruebas","Mc Milan","C/ Testeo","Pruebalandia","12345",987523456,20,FormaDePago.SESENTA_DIAS);
        ArrayProductos[0] = new Producto("1", "Champú Genérico", "Marca Blanca Genérica del champú más barato 2€", 3027);
        ArrayProductos[1] = new Producto("2", "Cortauñas", "Cortauñas hidráulico de alta presión 700€", 147);
        ArrayProductos[2] = new Producto("3", "Pierna Robótica", "Pierna de alta presión con capacidad de salto alta 825€", 15);
        ArrayIncidencias[0] = new Incidencia(1, "Manolo", "Se me ha caido to el pelo por hecharme ese champú", TipoIncidencia.HARDWARE, false);
        ArrayIncidencias[1] = new Incidencia(2, "Manolo", "La pierna Robótica no enciende", TipoIncidencia.SOFTWARE, true);
        ArrayIncidencias[2] = new Incidencia(3, "Carmen", "Mi marido manolo ha muerto por culpa de el cortauñas hidráulico", TipoIncidencia.PRESUPUESTO, false);
**/
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
