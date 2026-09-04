package vallegrande.edu.pe.preguntaspreguntonas.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class QuizView {

    public void startView(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/vallegrande/edu/pe/preguntaspreguntonas/hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Juego de Preguntas y Respuestas");
        stage.setScene(scene);
        stage.show();
    }
}