package vallegrande.edu.pe.preguntaspreguntonas;

import javafx.application.Application;
import javafx.stage.Stage;
import vallegrande.edu.pe.preguntaspreguntonas.view.QuizView;

import java.io.IOException;

public class main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        QuizView quizView = new QuizView();
        quizView.startView(stage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}