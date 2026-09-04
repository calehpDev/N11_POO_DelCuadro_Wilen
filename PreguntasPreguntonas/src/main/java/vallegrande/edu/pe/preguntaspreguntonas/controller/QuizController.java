package vallegrande.edu.pe.preguntaspreguntonas.controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.Duration;
import vallegrande.edu.pe.preguntaspreguntonas.model.Question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuizController {

    @FXML private Label lblTimer;
    @FXML private Label lblScore;
    @FXML private Label lblQuestion;
    @FXML private Button btnOpt0, btnOpt1, btnOpt2, btnOpt3;

    private List<Question> questions = new ArrayList<>();
    private int currentQuestionIndex = 0;
    private int score = 0;

    // Variables del Temporizador
    private Timeline timeline;
    private int timeSeconds = 30;

    @FXML
    public void initialize() {
        loadQuestions();
        showQuestion();
    }

    private void loadQuestions() {
        questions.clear();
        questions.add(new Question("¿Invasión a qué país desencadenó el inicio de la Segunda Guerra Mundial en 1939?", Arrays.asList("Francia", "Polonia", "Rusia", "Bélgica"), 1));
        questions.add(new Question("¿En qué año terminó la Segunda Guerra Mundial?", Arrays.asList("1943", "1944", "1945", "1946"), 2));
        questions.add(new Question("¿Qué ataque sorpresivo provocó la entrada de EE.UU. en la guerra?", Arrays.asList("Ataque a Pearl Harbor", "Batalla de Midway", "Invasión de Normandía", "Batalla de Inglaterra"), 0));
        questions.add(new Question("¿Cuál fue el nombre clave del desembarco aliado en las playas de Normandía?", Arrays.asList("Operación Barbarroja", "Operación Overlord", "Operación Antropos", "Operación Market Garden"), 1));
        questions.add(new Question("¿Quién era el Primer Ministro del Reino Unido durante la mayor parte de la guerra?", Arrays.asList("Neville Chamberlain", "Clement Attlee", "Winston Churchill", "Charles de Gaulle"), 2));
        questions.add(new Question("¿Cómo se llamaba la operación militar alemana para invadir la Unión Soviética?", Arrays.asList("Operación Barbarroja", "Operación León Marino", "Operación Antracita", "Operación Fall Gelb"), 0));
        questions.add(new Question("¿En qué ciudad japonesa se lanzó la primera bomba atómica de la historia?", Arrays.asList("Nagasaki", "Tokio", "Hiroshima", "Osaka"), 2));
        questions.add(new Question("¿Qué batalla es considerada el principal punto de inflexión del frente oriental?", Arrays.asList("Batalla de las Ardenas", "Batalla de Stalingrado", "Batalla de Berlín", "Batalla de Dunkerque"), 1));
        questions.add(new Question("¿Qué tres países principales formaban las potencias del Eje?", Arrays.asList("Alemania, Italia, Japón", "Alemania, URSS, Japón", "Alemania, Italia, España", "Alemania, Austria, Hungría"), 0));
        questions.add(new Question("¿Quién fue el comandante supremo aliado en Europa durante el Desembarco de Normandía?", Arrays.asList("George Patton", "Douglas MacArthur", "Dwight D. Eisenhower", "Bernard Montgomery"), 2));
    }

    private void showQuestion() {
        if (currentQuestionIndex < questions.size()) {
            Question q = questions.get(currentQuestionIndex);
            lblQuestion.setText((currentQuestionIndex + 1) + ". " + q.getQuestionText());
            btnOpt0.setText(q.getOptions().get(0));
            btnOpt1.setText(q.getOptions().get(1));
            btnOpt2.setText(q.getOptions().get(2));
            btnOpt3.setText(q.getOptions().get(3));
            lblScore.setText("Puntaje: " + score + " / " + questions.size());

            // Iniciar o reiniciar el temporizador para la pregunta actual
            startTimer();
        } else {
            stopTimer();
            showFinalResults();
        }
    }

    private void startTimer() {
        stopTimer(); // Detener temporizador previo si existe

        timeSeconds = 30;
        lblTimer.setText("Tiempo: " + timeSeconds + "s");

        timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            timeSeconds--;
            lblTimer.setText("Tiempo: " + timeSeconds + "s");

            if (timeSeconds <= 0) {
                stopTimer();
                // Si se agota el tiempo, pasa automáticamente a la siguiente pregunta
                currentQuestionIndex++;
                showQuestion();
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    private void stopTimer() {
        if (timeline != null) {
            timeline.stop();
        }
    }

    @FXML
    private void handleOptionAction(ActionEvent event) {
        stopTimer(); // Detiene el reloj en cuanto el usuario presiona un botón

        Button clickedButton = (Button) event.getSource();
        int selectedIndex = -1;

        if (clickedButton == btnOpt0) selectedIndex = 0;
        else if (clickedButton == btnOpt1) selectedIndex = 1;
        else if (clickedButton == btnOpt2) selectedIndex = 2;
        else if (clickedButton == btnOpt3) selectedIndex = 3;

        if (selectedIndex == questions.get(currentQuestionIndex).getCorrectIndex()) {
            score++;
        }

        currentQuestionIndex++;
        showQuestion();
    }

    private void showFinalResults() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Juego Terminado");
        alert.setHeaderText("¡Has completado el cuestionario!");
        alert.setContentText("Tu puntuación final es: " + score + " de " + questions.size());
        alert.showAndWait();
    }
}
