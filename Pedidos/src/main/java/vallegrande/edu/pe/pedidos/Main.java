package vallegrande.edu.pe.pedidos;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import vallegrande.edu.pe.pedidos.controller.MainController;
import vallegrande.edu.pe.pedidos.view.MainView;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        MainView view = new MainView();
        MainController controller = new MainController(view);

        Scene scene = new Scene(view, 900, 600);

        primaryStage.setTitle("Sistema de Gestión de Pedidos");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}