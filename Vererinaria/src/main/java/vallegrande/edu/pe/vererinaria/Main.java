package vallegrande.edu.pe.gestionveterinaria;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import vallegrande.edu.pe.gestionveterinaria.Controller.MainController;
import vallegrande.edu.pe.gestionveterinaria.View.MainView;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            MainView mainView = new MainView();
            new MainController(mainView, primaryStage, "Usuario Demo");

            Scene scene = new Scene(mainView, 1280, 720);
            primaryStage.setTitle("Sistema de Gestión de Veterinaria");
            primaryStage.setScene(scene);
            primaryStage.setMaximized(true);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}