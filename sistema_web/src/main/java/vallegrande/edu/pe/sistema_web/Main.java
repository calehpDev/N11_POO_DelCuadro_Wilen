package vallegrande.edu.pe.sistema_web;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import vallegrande.edu.pe.sistema_web.Controller.MainController;
import vallegrande.edu.pe.sistema_web.View.MainView;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        MainView view = new MainView();
        new MainController(view);

        Scene scene = new Scene(view, 900, 600);
        stage.setTitle("Sistema Web - Gestión de Usuarios");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}