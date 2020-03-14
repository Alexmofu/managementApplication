package managementApplication;

import com.sun.deploy.util.ArrayUtil;
import com.sun.security.ntlm.Client;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.EnumSet;

public class Controlador {
    @FXML
    private RadioButton btn_incidencias_sinResolver;

    @FXML
    private RadioButton btn_incidencias_resuelta;

    @FXML
    private MenuItem topmenu_close;

    @FXML
    private MenuItem topmenu_version;

    @FXML
    private TextField field_client_nif;

    @FXML
    private TextField field_client_nombre;

    @FXML
    private TextField field_client_apellidos;

    @FXML
    private TextField field_client_direccion;

    @FXML
    private TextField field_client_localidad;

    @FXML
    private TextField field_client_cp;

    @FXML
    private TextField field_client_telefono;

    @FXML
    private GridPane grid_bottom_clientes;

    @FXML
    private TextField field_client_page;

    @FXML
    private TextField field_tipoIncidencia;

    @FXML
    private TextField field_products_codigo;

    @FXML
    private TextField field_products_nombre;

    @FXML
    private TextField field_products_descripcion;

    @FXML
    private TextField field_products_unidades;

    @FXML
    private GridPane grid_bottom_productos;

    @FXML
    private TextField field_products_page;

    @FXML
    private TextField field_incidencias_codigo;

    @FXML
    private TextField field_incidencias_nombreCliente;

    @FXML
    private TextField field_incidencias_descripcion;

    @FXML
    private TextField field_incidencias_estado;

    @FXML
    private GridPane grid_bottom_incidencias;

    @FXML
    private TextField field_incidencias_page;

    @FXML
    private TextField field_client_type;

    @FXML
    private ChoiceBox<String> choice_client_payment;

    @FXML
    private ChoiceBox<String> choice_incidencias_type;

    @FXML
    private TextField field_client_credit;

    @FXML
    private TextField field_clientes_comunidadRegantes;

    @FXML
    private TextField field_clientes_numInvernaderos;

    @FXML
    private TextField field_clientes_tipoCultivo;



    /**
     * Atributos para posición de páginas
     */

    private int client_pos = 0;
    private int products_pos = 0;
    private int incidencias_pos = 0;
    private Agricultor agricultor;

    public void initialize() {

        choice_client_payment.getItems().add("CONTADO");
        choice_client_payment.getItems().add("TREINTA_DIAS");
        choice_client_payment.getItems().add("SESENTA_DIAS");
        choice_incidencias_type.getItems().add("HARDWARE");
        choice_incidencias_type.getItems().add("PRESUPUESTO");
        choice_incidencias_type.getItems().add("SOFTWARE");

        GestionDatos.inicializarDatos();
        //Update de las 3 Pestañas
        client_DataUpdate();
        products_DataUpdate();
        incidences_DataUpdate();
    }

    /**
     * Botones
     */
    @FXML
    public void btn_topmenu_save(){
        GestionDatos.guardarDatos();
        incidences_DataUpdate();
        client_DataUpdate();
        products_DataUpdate();
    }

    @FXML
    public void btn_topmenu_load(){
        GestionDatos.cargarDatos();
        incidences_DataUpdate();
        client_DataUpdate();
        products_DataUpdate();
    }

    @FXML
    public void eliminarCliente(){
        System.arraycopy(GestionDatos.ArrayClientes,client_pos +1,GestionDatos.ArrayClientes,client_pos,GestionDatos.ArrayClientes.length - client_pos - 1);
        client_DataUpdate();

    }

    @FXML
    public void eliminarProducto(){
        System.arraycopy(GestionDatos.ArrayProductos,client_pos +1,GestionDatos.ArrayProductos,client_pos,GestionDatos.ArrayProductos.length - client_pos - 1);
        products_DataUpdate();

    }

    @FXML
    public void eliminarIncidencia(){
        System.arraycopy(GestionDatos.ArrayIncidencias,client_pos +1,GestionDatos.ArrayIncidencias,client_pos,GestionDatos.ArrayIncidencias.length - client_pos - 1);
        incidences_DataUpdate();

    }

    public void btn_topmenu_close() {
        Platform.exit();
    }

    public void btn_topmenu_version(ActionEvent Event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("About.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("About");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
        stage.setResizable(false);
    }

    public void btn_addClient(ActionEvent Event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AddClient.fxml"));
        Scene sceneClient = new Scene(root);
        Stage stageAddClient = new Stage();
        stageAddClient.setScene(sceneClient);
        stageAddClient.setTitle("Añadir Cliente");
        stageAddClient.initModality(Modality.APPLICATION_MODAL);
        stageAddClient.show();
        stageAddClient.setResizable(false);
    }

    public void btn_addIncidencia(ActionEvent Event) throws IOException {
        GestionDatos.ArrayIncidencias[lastNotNullIncidencia()] = new Incidencia(0,"","",TipoIncidencia.HARDWARE,false); // falta añadir una función para que el código no sea 0 y sea el último disponible
        incidencias_pos = 0;
        for (int i = 0; i < GestionDatos.ArrayIncidencias.length; i++) {
            incidencias_pos++;
            if (GestionDatos.ArrayIncidencias[i] == null) {
                incidencias_pos--;
                incidencias_pos--;
                incidences_DataUpdate();
                break;

            }
        }
    }

    public static int lastNotNullIncidencia(){
        int lastIncidencia = 0;
        for (int i = 0; i < GestionDatos.ArrayIncidencias.length; i++) {
            lastIncidencia++;
            if (GestionDatos.ArrayIncidencias[i] == null) {
                lastIncidencia--;
                break;

            }
        }
        return lastIncidencia;
    }

    public static int lastNotNullProducto(){
        int lastProducto = 0;
        for (int i = 0; i < GestionDatos.ArrayProductos.length; i++) {
            lastProducto++;
            if (GestionDatos.ArrayProductos[i] == null) {
                lastProducto--;
                break;

            }
        }
        return lastProducto;
    }
    public void btn_addProducto(ActionEvent Event) throws IOException {
        GestionDatos.ArrayProductos[lastNotNullProducto()] = new Producto("", "", "", 0);
        products_pos = 0;
        for (int i = 0; i < GestionDatos.ArrayProductos.length; i++) {
            products_pos++;
            if (GestionDatos.ArrayProductos[i] == null) {
                products_pos--;
                products_pos--;
                products_DataUpdate();
                break;

            }
        }
    }

    //Va a la primera entrada
    public void btn_client_first(ActionEvent Event) {
        client_pos = 0;
        client_DataUpdate();
    }

    //Va a la entrada anterior
    public void btn_client_previous(ActionEvent Event) {
        if (client_pos > 0) {
            if (GestionDatos.ArrayClientes[client_pos - 1] != null) {
                client_pos--;
                client_DataUpdate();
            }
        }
    }

    //Va a la siguiente entrada
    public void btn_client_next(ActionEvent Event) {
        if (GestionDatos.ArrayClientes[client_pos + 1] != null) {
            client_pos++;
            client_DataUpdate();
        }
    }

    //Va a la última entrada iterando desde el principio
    public void btn_client_last(ActionEvent Event) {
        client_pos = 0;
        for (int i = 0; i < GestionDatos.ArrayClientes.length; i++) {
            client_pos++;
            if (GestionDatos.ArrayClientes[i] == null) {
                client_pos--;
                client_pos--;
                client_DataUpdate();
                break;

            }
        }
    }

    //Añade los cambios al cliente actual
    public void btn_client_save(ActionEvent Event) {
        GestionDatos.ArrayClientes[client_pos].setNif(field_client_nif.getText());
        GestionDatos.ArrayClientes[client_pos].setNombre(field_client_nombre.getText());
        GestionDatos.ArrayClientes[client_pos].setApellidos(field_client_apellidos.getText());
        GestionDatos.ArrayClientes[client_pos].setDireccion(field_client_direccion.getText());
        GestionDatos.ArrayClientes[client_pos].setLocalidad(field_client_localidad.getText());
        GestionDatos.ArrayClientes[client_pos].setCodigoPostal(field_client_cp.getText());
        try {
            GestionDatos.ArrayClientes[client_pos].setTelefono(Integer.parseInt(field_client_telefono.getText()));
            field_client_telefono.setPromptText("123456789");
        } catch (Exception e) {
            GestionDatos.escribirFallo(e);

            field_client_telefono.setPromptText("Error, el Teléfono debe tener el siguiente formato: 123456789");
            field_client_telefono.clear();
        }

        try{
            if (GestionDatos.ArrayClientes[client_pos].getClass().equals(Agricultor.class)) {
                Agricultor a = (Agricultor) GestionDatos.ArrayClientes[client_pos];
                a.setCultivo(field_clientes_tipoCultivo.getText());
                a.setComunidadRegantes(field_clientes_comunidadRegantes.getText());
                a.setNumeroInvernaderos(Integer.parseInt(field_clientes_numInvernaderos.getText()));
            }

        }catch (Exception e){
            GestionDatos.escribirFallo(e);
            field_client_credit.setPromptText("123456789");
        }
            if(GestionDatos.ArrayClientes[client_pos].getClass().equals(Distribuidor.class)){
                Distribuidor a = (Distribuidor) GestionDatos.ArrayClientes[client_pos];
                a.setCreditoDisponible(Float.parseFloat(field_client_credit.getText()));
                try{
                    //System.out.println(choice_client_payment.getValue()); // DEBUG
                    String tipoPago = choice_client_payment.getValue();
                    if (tipoPago.equals("CONTADO")){
                        a.setNewFormaDePago(FormaDePago.CONTADO);
                    }else if (tipoPago.equals("SESENTA_DIAS")){
                        a.setNewFormaDePago(FormaDePago.SESENTA_DIAS);
                    }else if (tipoPago.equals("TREINTA_DIAS")){
                        a.setNewFormaDePago(FormaDePago.TREINTA_DIAS);
                    }

                }catch (Exception e) {
                    GestionDatos.escribirFallo(e);
                    choice_incidencias_type.setAccessibleText("ERROR");
                }
            }
        client_DataUpdate();
    }

    //Va a la primera entrada
    public void btn_products_first(ActionEvent Event) {
        products_pos = 0;
        products_DataUpdate();
    }

    //Va a la entrada anterior
    public void btn_products_previous(ActionEvent Event) {
        if (products_pos > 0) {
            if (GestionDatos.ArrayProductos[products_pos - 1] != null) {
                products_pos--;
                products_DataUpdate();
            }
        }
    }

    //Va a la siguiente entrada
    public void btn_products_next(ActionEvent Event) {
        if (GestionDatos.ArrayProductos[products_pos + 1] != null) {
            products_pos++;
            products_DataUpdate();
        }
    }

    //Va a la primera entrada
    public void btn_casualties_first(ActionEvent Event) {
        incidencias_pos = 0;
        incidences_DataUpdate();
    }

    //Va a la última entrada iterando desde el principio
    public void btn_products_last(ActionEvent Event) {
        products_pos = 0;
        for (int i = 0; i < GestionDatos.ArrayProductos.length; i++) {
            products_pos++;
            if (GestionDatos.ArrayProductos[i] == null) {
                products_pos--;
                products_pos--;
                products_DataUpdate();
                break;

            }
        }
    }

    //Añade los cambios al cliente actual
    public void btn_products_save(ActionEvent Event) {
        GestionDatos.ArrayProductos[products_pos].setCodigo(field_products_codigo.getText());
        GestionDatos.ArrayProductos[products_pos].setNombre(field_products_nombre.getText());
        GestionDatos.ArrayProductos[products_pos].setDescripcion(field_products_descripcion.getText());
        try {
            GestionDatos.ArrayProductos[products_pos].setUnidades(Integer.parseInt(field_products_unidades.getText()));
            field_products_unidades.setPromptText("111111111");
        } catch (Exception e) {
            GestionDatos.escribirFallo(e);
            field_products_unidades.setPromptText("Error, las unidades deben tener el siguiente formato: 123456789");
            field_products_unidades.clear();
        }
        products_DataUpdate();
    }

    //Va a la entrada anterior
    public void btn_casualties_previous(ActionEvent Event) {
        if (incidencias_pos > 0) {
            if (GestionDatos.ArrayIncidencias[incidencias_pos - 1] != null) {
                incidencias_pos--;
                incidences_DataUpdate();
            }
        }
    }

    //Va a la siguiente entrada
    public void btn_casualties_next(ActionEvent Event) {
        if (GestionDatos.ArrayIncidencias[incidencias_pos + 1] != null) {
            incidencias_pos++;
            incidences_DataUpdate();
        }
    }

    //Va a la última entrada iterando desde el principio
    public void btn_incidences_last(ActionEvent Event) {
        incidencias_pos = 0;
        for (int i = 0; i < GestionDatos.ArrayIncidencias.length; i++) {
            incidencias_pos++;
            if (GestionDatos.ArrayIncidencias[i] == null) {
                incidencias_pos--;
                incidencias_pos--;
                incidences_DataUpdate();
                break;

            }
        }
    }

    //Añade los cambios al cliente actual
    public void btn_incidencias_save(ActionEvent Event) {
        GestionDatos.ArrayIncidencias[incidencias_pos].setNombreCliente(field_incidencias_nombreCliente.getText());
        GestionDatos.ArrayIncidencias[incidencias_pos].setDescripcion(field_incidencias_descripcion.getText());
        try {
            GestionDatos.ArrayIncidencias[incidencias_pos].setCodigo(Integer.parseInt(field_incidencias_codigo.getText()));
            GestionDatos.ArrayIncidencias[incidencias_pos].setStatus(Boolean.parseBoolean(field_incidencias_estado.getText()));

            field_incidencias_codigo.setPromptText("111111111");
        } catch (Exception e) {
            GestionDatos.escribirFallo(e);
            field_incidencias_codigo.setPromptText("Error, el código debe tener el siguiente formato: 123456789");
            field_incidencias_codigo.clear();
        }
        try {
            GestionDatos.ArrayIncidencias[incidencias_pos].setTipoIncidente(TipoIncidencia.valueOf(field_tipoIncidencia.getText()));
            field_tipoIncidencia.setPromptText("HARDWARE, SOFTWARE, PRESUPUESTO");
        } catch (Exception e) {
            GestionDatos.escribirFallo(e);
            field_tipoIncidencia.setPromptText("Error, las incidencias solo pueden ser: HARDWARE, SOFTWARE, PRESUPUESTO");
            field_tipoIncidencia.clear();
        }
        try{
            //System.out.println(choice_incidencias_type.getValue()); // DEBUG

            String tipoIncidencia = choice_incidencias_type.getValue();
            if (tipoIncidencia.equals("HARDWARE")){
                GestionDatos.ArrayIncidencias[incidencias_pos].setTipoIncidente(TipoIncidencia.HARDWARE);
            }else if (tipoIncidencia.equals("SOFTWARE")){
                GestionDatos.ArrayIncidencias[incidencias_pos].setTipoIncidente(TipoIncidencia.SOFTWARE);
            }else if (tipoIncidencia.equals("PRESUPUESTO")){
                GestionDatos.ArrayIncidencias[incidencias_pos].setTipoIncidente(TipoIncidencia.PRESUPUESTO);
            }

        }catch (Exception e) {
            GestionDatos.escribirFallo(e);
            choice_incidencias_type.setAccessibleText("ERROR");
        }
        incidences_DataUpdate();
    }

    public void setBtn_incidencias_sinResolver() {
        field_incidencias_estado.setText("false");
        btn_incidencias_sinResolver.setSelected(true);
        btn_incidencias_resuelta.setSelected(false);
        btn_incidencias_resuelta.setDisable(false);
        btn_incidencias_sinResolver.setDisable(true);
    }

    public void setBtn_incidencias_resuelta() {
        field_incidencias_estado.setText("true");
        btn_incidencias_sinResolver.setSelected(false);
        btn_incidencias_resuelta.setSelected(true);
        btn_incidencias_resuelta.setDisable(true);
        btn_incidencias_sinResolver.setDisable(false);
    }

    /**
     * Actualizacion de valores en pantalla
     */
    public void client_DataUpdate() {
        if (GestionDatos.ArrayClientes[client_pos] != null) {
            field_client_nif.setText(String.valueOf(GestionDatos.ArrayClientes[client_pos].getNif()));
            field_client_nombre.setText(String.valueOf(GestionDatos.ArrayClientes[client_pos].getNombre()));
            field_client_apellidos.setText(String.valueOf(GestionDatos.ArrayClientes[client_pos].getApellidos()));
            field_client_direccion.setText(String.valueOf(GestionDatos.ArrayClientes[client_pos].getDireccion()));
            field_client_localidad.setText(String.valueOf(GestionDatos.ArrayClientes[client_pos].getLocalidad()));
            field_client_cp.setText(String.valueOf(GestionDatos.ArrayClientes[client_pos].getCodigoPostal()));
            field_client_telefono.setText(String.valueOf(GestionDatos.ArrayClientes[client_pos].getTelefono()));
            try{
                if (GestionDatos.ArrayClientes[client_pos].getClass().equals(Agricultor.class)){
                    Agricultor a = (Agricultor) GestionDatos.ArrayClientes[client_pos];
                    field_client_type.setText("Agricultor");
                    field_clientes_tipoCultivo.setText(a.getCultivo());
                    field_clientes_comunidadRegantes.setText(a.getComunidadRegantes());
                    field_clientes_numInvernaderos.setText(String.valueOf(a.getNumeroInvernaderos()));
                    field_client_credit.setText("");
                    field_client_credit.setDisable(true);
                    choice_client_payment.setDisable(true);
                    field_clientes_tipoCultivo.setDisable(false);
                    field_clientes_comunidadRegantes.setDisable(false);
                    field_clientes_numInvernaderos.setDisable(false);
                }else if (GestionDatos.ArrayClientes[client_pos].getClass().equals(Distribuidor.class)){
                    Distribuidor a = (Distribuidor) GestionDatos.ArrayClientes[client_pos];
                    field_client_type.setText("Distribuidor");
                    field_client_credit.setText(String.valueOf(a.creditoDisponible));
                    field_clientes_numInvernaderos.setText("");
                    field_clientes_comunidadRegantes.setText("");
                    field_clientes_tipoCultivo.setText("");
                    field_client_credit.setDisable(false);
                    choice_client_payment.setDisable(false);
                    field_clientes_tipoCultivo.setDisable(true);
                    field_clientes_comunidadRegantes.setDisable(true);
                    field_clientes_numInvernaderos.setDisable(true);
                    choice_client_payment.setValue(a.getNewFormaDePago().toString());
                }

            }catch (Exception e){
                GestionDatos.escribirFallo(e);
                choice_incidencias_type.setAccessibleText("ERROR");
            }
            field_client_page.setText(String.valueOf(client_pos + 1));
        }
    }

    public void products_DataUpdate() {
        if (GestionDatos.ArrayProductos[products_pos] != null) {
            field_products_codigo.setText(String.valueOf(GestionDatos.ArrayProductos[products_pos].getCodigo()));
            field_products_nombre.setText(String.valueOf(GestionDatos.ArrayProductos[products_pos].getNombre()));
            field_products_descripcion.setText(String.valueOf(GestionDatos.ArrayProductos[products_pos].getDescripcion()));
            field_products_unidades.setText(String.valueOf(GestionDatos.ArrayProductos[products_pos].getUnidades()));
            field_products_page.setText(String.valueOf(products_pos + 1));
        }
    }

    public void incidences_DataUpdate() {
        if (GestionDatos.ArrayIncidencias[incidencias_pos] != null) {
            field_incidencias_codigo.setText(String.valueOf(GestionDatos.ArrayIncidencias[incidencias_pos].getCodigo()));
            field_incidencias_nombreCliente.setText(String.valueOf(GestionDatos.ArrayIncidencias[incidencias_pos].getNombreCliente()));
            field_incidencias_descripcion.setText(String.valueOf(GestionDatos.ArrayIncidencias[incidencias_pos].getDescripcion()));
            field_incidencias_estado.setText(String.valueOf(GestionDatos.ArrayIncidencias[incidencias_pos].isStatus()));
            field_incidencias_page.setText(String.valueOf(incidencias_pos + 1));
            field_tipoIncidencia.setText(String.valueOf(GestionDatos.ArrayIncidencias[incidencias_pos].getTipoIncidente()));

            if (GestionDatos.ArrayIncidencias[incidencias_pos].getTipoIncidente() == TipoIncidencia.HARDWARE) {
                choice_incidencias_type.setValue("HARDWARE");
            }else if (GestionDatos.ArrayIncidencias[incidencias_pos].getTipoIncidente() == TipoIncidencia.SOFTWARE){
                choice_incidencias_type.setValue("SOFTWARE");
            }else if (GestionDatos.ArrayIncidencias[incidencias_pos].getTipoIncidente() == TipoIncidencia.PRESUPUESTO){
                choice_incidencias_type.setValue("PRESUPUESTO");
            }

            btn_incidencias_sinResolver.setSelected(false);
            btn_incidencias_resuelta.setSelected(false);
            btn_incidencias_resuelta.setDisable(false);
            btn_incidencias_sinResolver.setDisable(false);
        }
    }
}