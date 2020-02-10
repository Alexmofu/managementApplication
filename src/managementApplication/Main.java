package managementApplication;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage escena) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Interfaz.fxml"));
        escena.setTitle("Aplicación de Gestión");
        escena.setScene(new Scene(root));
        escena.setResizable(false);
        escena.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
