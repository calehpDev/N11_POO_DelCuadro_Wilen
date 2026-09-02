package vallegrande.edu.pe.miperfil.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class PerfilView {
    private VBox contenedor;
    private Label titulo;
    private TextField txtNombre;
    private TextField txtCarrera;
    private TextField txtSemestre;
    private TextField txtHobby; // Dato adicional
    private Button btnMostrar;
    private Label lblResultado;

    public PerfilView(){
        titulo = new Label("MI PERFIL");
        titulo.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: #1e293b;");

        txtNombre = new TextField();
        txtNombre.setPromptText("Ingrese su nombre");
        txtNombre.setStyle("-fx-padding: 8; -fx-background-radius: 5;");

        txtCarrera = new TextField();
        txtCarrera.setPromptText("Ingrese su carrera");
        txtCarrera.setStyle("-fx-padding: 8; -fx-background-radius: 5;");

        txtSemestre = new TextField();
        txtSemestre.setPromptText("Ingrese su semestre");
        txtSemestre.setStyle("-fx-padding: 8; -fx-background-radius: 5;");

        txtHobby = new TextField();
        txtHobby.setPromptText("Ingrese su hobby o pasatiempo");
        txtHobby.setStyle("-fx-padding: 8; -fx-background-radius: 5;");

        btnMostrar = new Button("Confirmar y Mostrar Perfil");
        btnMostrar.setStyle("-fx-background-color: #2563eb; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 8 16; -fx-background-radius: 5;");

        lblResultado = new Label();
        lblResultado.setStyle("-fx-font-size: 13px; -fx-text-fill: #0f172a;");

        contenedor = new VBox(12);
        contenedor.setPadding(new Insets(20));
        contenedor.setAlignment(Pos.CENTER);
        contenedor.setStyle("-fx-background-color: #f1f5f9;");

        contenedor.getChildren().addAll(
                titulo,
                txtNombre,
                txtCarrera,
                txtSemestre,
                txtHobby,
                btnMostrar,
                lblResultado
        );
    }
    public VBox getContenedor(){
        return contenedor;
    }
    public TextField getTxtNombre(){
        return txtNombre;
    }
    public TextField getTxtCarrera(){
        return txtCarrera;
    }
    public TextField getTxtSemestre(){
        return txtSemestre;
    }
    public TextField getTxtHobby(){
        return txtHobby;
    }
    public Button getBtnMostrar(){
        return btnMostrar;
    }
    public Label getLblResultado(){
        return lblResultado;
    }
}