package managementApplication;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.io.IOException;

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

    /**
     * Atributos para posición de páginas
     */

    private int client_pos = 0;
    private int products_pos = 0;
    private int incidencias_pos = 0;

    public void initialize(){
        GestionDatos.inicializarDatos();
        //Update de las 3 Pestañas
        client_DataUpdate();
        products_DataUpdate();
        incidences_DataUpdate();
    }
    /**
     * Botones
     */
    public void btn_topmenu_close(){
        Platform.exit();
    }

    public void btn_topmenu_version(){
    //#PLACEHOLDER
    }

    public void btn_about_close(){
        Platform.exit();
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
    public void btn_client_last(ActionEvent Event){
        client_pos = 0;
        for (int i = 0; i < GestionDatos.ArrayClientes.length; i++) {
            client_pos++;
            if(GestionDatos.ArrayClientes[i] == null){
                client_pos--;
                client_pos--;
                client_DataUpdate();
                break;

            }
        }
    }

    //Añade los cambios al cliente actual
    public void btn_client_add(ActionEvent Event){
        GestionDatos.ArrayClientes[client_pos].setNif(field_client_nif.getText());
        GestionDatos.ArrayClientes[client_pos].setNombre(field_client_nombre.getText());
        GestionDatos.ArrayClientes[client_pos].setApellidos(field_client_apellidos.getText());
        GestionDatos.ArrayClientes[client_pos].setDireccion(field_client_direccion.getText());
        GestionDatos.ArrayClientes[client_pos].setLocalidad(field_client_localidad.getText());
        GestionDatos.ArrayClientes[client_pos].setCodigoPostal(field_client_cp.getText());
        try {
            GestionDatos.ArrayClientes[client_pos].setTelefono(Integer.parseInt(field_client_telefono.getText()));
            field_client_telefono.setPromptText("123456789");
        }catch (Exception e){
            field_client_telefono.setPromptText("Error, el Teléfono debe tener el siguiente formato: 123456789");
            field_client_telefono.clear();
        }
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
    public void btn_products_last(ActionEvent Event){
        products_pos = 0;
        for (int i = 0; i < GestionDatos.ArrayProductos.length; i++) {
            products_pos++;
            if(GestionDatos.ArrayProductos[i] == null){
                products_pos--;
                products_pos--;
                products_DataUpdate();
                break;

            }
        }
    }

    //Añade los cambios al cliente actual
    public void btn_products_add(ActionEvent Event){
        GestionDatos.ArrayProductos[products_pos].setCodigo(field_products_codigo.getText());
        GestionDatos.ArrayProductos[products_pos].setNombre(field_products_nombre.getText());
        GestionDatos.ArrayProductos[products_pos].setDescripcion(field_products_descripcion.getText());
        try {
            GestionDatos.ArrayProductos[products_pos].setUnidades(Integer.parseInt(field_products_unidades.getText()));
            field_products_unidades.setPromptText("111111111");
        }catch (Exception e){
            field_products_unidades.setPromptText("Error, las unidades deben tener el siguiente formato: 123456789");
            field_products_unidades.clear();
        }
    }

    //Va a la entrada anterior
    public void btn_casualties_previous(ActionEvent Event) {
        if(incidencias_pos > 0){
            if(GestionDatos.ArrayIncidencias[incidencias_pos -1] != null){
                incidencias_pos--;
                incidences_DataUpdate();
            }
        }
    }

    //Va a la siguiente entrada
    public void btn_casualties_next(ActionEvent Event) {
        if(GestionDatos.ArrayIncidencias[incidencias_pos + 1] != null){
            incidencias_pos++;
            incidences_DataUpdate();
        }
    }

    //Va a la última entrada iterando desde el principio
    public void btn_incidences_last(ActionEvent Event){
        incidencias_pos = 0;
        for (int i = 0; i < GestionDatos.ArrayIncidencias.length; i++) {
            incidencias_pos++;
            if(GestionDatos.ArrayIncidencias[i] == null){
                incidencias_pos--;
                incidencias_pos--;
                incidences_DataUpdate();
                break;

            }
        }
    }

    //Añade los cambios al cliente actual
    public void btn_incidencias_add(ActionEvent Event){
        GestionDatos.ArrayIncidencias[incidencias_pos].setNombreCliente(field_incidencias_nombreCliente.getText());
        GestionDatos.ArrayIncidencias[incidencias_pos].setDescripcion(field_incidencias_descripcion.getText());
        try {
            GestionDatos.ArrayIncidencias[incidencias_pos].setCodigo(Integer.parseInt(field_incidencias_codigo.getText()));
            GestionDatos.ArrayIncidencias[incidencias_pos].setStatus(Boolean.parseBoolean(field_incidencias_estado.getText()));
            field_incidencias_codigo.setPromptText("111111111");
        }catch (Exception e){
            field_incidencias_codigo.setPromptText("Error, el código debe tener el siguiente formato: 123456789");
            field_incidencias_codigo.clear();
        }
    }

    public void setBtn_incidencias_sinResolver(){
        field_incidencias_estado.setText("false");
        btn_incidencias_sinResolver.setSelected(true);
        btn_incidencias_resuelta.setSelected(false);
        btn_incidencias_resuelta.setDisable(false);
        btn_incidencias_sinResolver.setDisable(true);
    }

    public void setBtn_incidencias_resuelta(){
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
            field_client_page.setText(String.valueOf(client_pos + 1));
    }}

    public void products_DataUpdate() {
        if (GestionDatos.ArrayProductos[products_pos] != null) {
            field_products_codigo.setText(String.valueOf(GestionDatos.ArrayProductos[products_pos].getCodigo()));
            field_products_nombre.setText(String.valueOf(GestionDatos.ArrayProductos[products_pos].getNombre()));
            field_products_descripcion.setText(String.valueOf(GestionDatos.ArrayProductos[products_pos].getDescripcion()));
            field_products_unidades.setText(String.valueOf(GestionDatos.ArrayProductos[products_pos].getUnidades()));
            field_products_page.setText(String.valueOf(products_pos + 1));
        }}

    public void incidences_DataUpdate() {
        if (GestionDatos.ArrayIncidencias[incidencias_pos] != null) {
            field_incidencias_codigo.setText(String.valueOf(GestionDatos.ArrayIncidencias[incidencias_pos].getCodigo()));
            field_incidencias_nombreCliente.setText(String.valueOf(GestionDatos.ArrayIncidencias[incidencias_pos].getNombreCliente()));
            field_incidencias_descripcion.setText(String.valueOf(GestionDatos.ArrayIncidencias[incidencias_pos].getDescripcion()));
            field_incidencias_estado.setText(String.valueOf(GestionDatos.ArrayIncidencias[incidencias_pos].isStatus()));
            field_incidencias_page.setText(String.valueOf(incidencias_pos + 1));
            btn_incidencias_sinResolver.setSelected(false);
            btn_incidencias_resuelta.setSelected(false);
            btn_incidencias_resuelta.setDisable(false);
            btn_incidencias_sinResolver.setDisable(false);
    }}
}