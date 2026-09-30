package vallegrande.edu.pe.sistema_web;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.net.URL;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            URL fxmlUrl = getClass().getResource("/hello-view.fxml");

            if (fxmlUrl == null) {
                System.err.println("❌ No se encontró hello-view.fxml en resources.");
                return;
            }

            FXMLLoader loader = new FXMLLoader(fxmlUrl);
            Scene scene = new Scene(loader.load(), 900, 450);

            primaryStage.setTitle("Tabla de Registros - JavaFX");
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception e) {
            System.err.println("❌ Error al cargar la interfaz:");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}