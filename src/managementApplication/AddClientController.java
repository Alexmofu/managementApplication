package managementApplication;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.event.ActionEvent;

public class AddClientController {

    @FXML
    private Button btn_confirmar;

    @FXML
    private ToggleGroup tg_tipoCliente;

    String toogleValue;

    void cerrarVentana(){
        Stage stageAddClient = (Stage) btn_confirmar.getScene().getWindow();
        stageAddClient.close();
    }

    public static int returnLastArrayClientesPos(){
        int pos = 0;
        for (int i = 0; i < GestionDatos.ArrayClientes.length; i++){
            pos++;
            if (GestionDatos.ArrayClientes[i] == null){
                pos--;
                break;
            }
        }
        return pos;
    }

    @FXML
    void cambioTipoCliente(){
        RadioButton botonSeleccionado = (RadioButton) tg_tipoCliente.getSelectedToggle();
        toogleValue = botonSeleccionado.getText();
    }

    @FXML
    public void confirmarClienteNuevo(){
        int ultimaDisponible;
        try{
            if (toogleValue.equals("Agricultor")) {
                ultimaDisponible = returnLastArrayClientesPos();
                if (ultimaDisponible < GestionDatos.ArrayClientes.length - 1) {
                    GestionDatos.ArrayClientes[ultimaDisponible] = new Agricultor("", "", "", "", "", "", 123456789, "", 0, "");
                    cerrarVentana();
                }
            }else if (toogleValue.equals("Distribuidor")){
                ultimaDisponible = returnLastArrayClientesPos();
                if (ultimaDisponible < GestionDatos.ArrayClientes.length - 1) {
                    GestionDatos.ArrayClientes[ultimaDisponible] = new Distribuidor("", "", "", "", "", "", 0,0,FormaDePago.CONTADO);
                    cerrarVentana();
                }
            }

        }catch (Exception e){
            System.out.println("Cosa mala pasó");
        }
    }
}
