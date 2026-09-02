package vallegrande.edu.pe.miperfil.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class PerfilView {
    private VBox contenedor;
    private Label titulo;
    private TextField txtNombre;
    private TextField txtCarrera;
    private ComboBox<String> cboSemestre;
    private ComboBox<String> cboHobby;
    private Button btnMostrar;
    private Button btnLimpiar;
    private Label lblResultado;

    public PerfilView() {
        titulo = new Label("REGISTRO DE PERFIL");
        titulo.getStyleClass().add("titulo");

        txtNombre = new TextField();
        txtNombre.setPromptText("Ingrese su nombre");

        txtCarrera = new TextField();
        txtCarrera.setPromptText("Ingrese su carrera");

        cboSemestre = new ComboBox<>();
        cboSemestre.getItems().addAll("1° Semestre", "2° Semestre", "3° Semestre", "4° Semestre", "5° Semestre", "6° Semestre");
        cboSemestre.setPromptText("Seleccione semestre");
        cboSemestre.setMaxWidth(Double.MAX_VALUE);

        cboHobby = new ComboBox<>();
        cboHobby.getItems().addAll("Videojuegos", "Deportes", "Música", "Lectura", "Fotografía", "Programación");
        cboHobby.setPromptText("Seleccione hobby o pasatiempo");
        cboHobby.setMaxWidth(Double.MAX_VALUE);

        btnMostrar = new Button("Mostrar Perfil");
        btnMostrar.getStyleClass().add("button-primary");

        btnLimpiar = new Button("Limpiar");
        btnLimpiar.getStyleClass().add("button-secondary");

        HBox contenedorBotones = new HBox(10, btnMostrar, btnLimpiar);
        contenedorBotones.setAlignment(Pos.CENTER);

        lblResultado = new Label();
        lblResultado.getStyleClass().add("label-resultado");

        contenedor = new VBox(12);
        contenedor.setPadding(new Insets(20));
        contenedor.setAlignment(Pos.CENTER);
        contenedor.getChildren().addAll(
                titulo,
                txtNombre,
                txtCarrera,
                cboSemestre,
                cboHobby,
                contenedorBotones,
                lblResultado
        );
    }

    public VBox getContenedor() { return contenedor; }
    public TextField getTxtNombre() { return txtNombre; }
    public TextField getTxtCarrera() { return txtCarrera; }
    public ComboBox<String> getCboSemestre() { return cboSemestre; }
    public ComboBox<String> getCboHobby() { return cboHobby; }
    public Button getBtnMostrar() { return btnMostrar; }
    public Button getBtnLimpiar() { return btnLimpiar; }
    public Label getLblResultado() { return lblResultado; }
}