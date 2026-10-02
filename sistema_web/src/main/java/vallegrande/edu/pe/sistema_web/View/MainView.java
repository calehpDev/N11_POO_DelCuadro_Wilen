package vallegrande.edu.pe.sistema_web.View;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import vallegrande.edu.pe.sistema_web.Model.Usuario;

public class MainView extends BorderPane {

    // Botones del menú
    private Button btnInicio;
    private Button btnUsuarios;

    // Campos del formulario para los datos reales de tu sistema
    private TextField txtNombre;
    private TextField txtEmail;
    private TextField txtTelefono;
    private TextField txtProducto;
    private TextField txtTipoComprador;
    private TextField txtMensaje;

    // Botón para registrar un usuario
    private Button btnRegistrar;

    // Tabla donde se muestran los usuarios
    private TableView<Usuario> tablaUsuarios;

    public MainView() {
        // Inicializamos las secciones de la interfaz
        crearMenu();
        crearTabla();
        crearFormulario();

        // Vista inicial por defecto
        mostrarInicio();
    }

    // Crea el menú lateral
    private void crearMenu() {
        VBox menu = new VBox(15);
        menu.setPadding(new Insets(25));
        menu.setPrefWidth(220);

        Label titulo = new Label("SISTEMA WEB");
        titulo.setStyle(
                "-fx-font-size: 20px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: white;"
        );

        btnInicio = crearBoton("Inicio");
        btnUsuarios = crearBoton("Usuarios");

        menu.getChildren().addAll(titulo, btnInicio, btnUsuarios);
        menu.setStyle("-fx-background-color: #2563EB;");

        setLeft(menu);
    }

    // Método auxiliar para construir botones uniformes
    private Button crearBoton(String texto) {
        Button boton = new Button(texto);
        boton.setPrefWidth(170);
        boton.setPrefHeight(40);
        return boton;
    }

    // Pantalla de Inicio
    public void mostrarInicio() {
        VBox contenido = new VBox(10);
        contenido.setAlignment(Pos.CENTER);

        Label titulo = new Label("BIENVENIDO");
        titulo.setStyle("-fx-font-size: 28px; -fx-font-weight: bold;");

        Label texto = new Label("Sistema de Gestión de Usuarios y Registros");
        texto.setStyle("-fx-font-size: 16px;");

        contenido.getChildren().addAll(titulo, texto);
        setCenter(contenido);
    }

    // Pantalla de Gestión de Usuarios
    public void mostrarUsuarios() {
        VBox contenido = new VBox(15);
        contenido.setPadding(new Insets(25));

        Label titulo = new Label("GESTIÓN DE USUARIOS");
        titulo.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        // Formulario organizado en una rejilla (GridPane)
        GridPane formGrid = new GridPane();
        formGrid.setHgap(10);
        formGrid.setVgap(10);

        formGrid.add(txtNombre, 0, 0);
        formGrid.add(txtEmail, 1, 0);
        formGrid.add(txtTelefono, 2, 0);
        formGrid.add(txtProducto, 0, 1);
        formGrid.add(txtTipoComprador, 1, 1);
        formGrid.add(txtMensaje, 2, 1);

        contenido.getChildren().addAll(
                titulo,
                formGrid,
                btnRegistrar,
                tablaUsuarios
        );

        setCenter(contenido);
    }

    // Instancia los campos de entrada de texto
    private void crearFormulario() {
        txtNombre = new TextField();
        txtNombre.setPromptText("Nombre");

        txtEmail = new TextField();
        txtEmail.setPromptText("Email");

        txtTelefono = new TextField();
        txtTelefono.setPromptText("Teléfono");

        txtProducto = new TextField();
        txtProducto.setPromptText("Producto");

        txtTipoComprador = new TextField();
        txtTipoComprador.setPromptText("Tipo de Comprador");

        txtMensaje = new TextField();
        txtMensaje.setPromptText("Mensaje");

        btnRegistrar = new Button("Registrar Usuario");
        btnRegistrar.setStyle("-fx-background-color: #16A34A; -fx-text-fill: white; -fx-font-weight: bold;");
        btnRegistrar.setPrefHeight(35);
    }

    // Construye la tabla y sus 7 columnas
    @SuppressWarnings("unchecked")
    private void crearTabla() {
        tablaUsuarios = new TableView<>();

        TableColumn<Usuario, Integer> colId = new TableColumn<>("ID");
        TableColumn<Usuario, String> colNombre = new TableColumn<>("Nombre");
        TableColumn<Usuario, String> colEmail = new TableColumn<>("Email");
        TableColumn<Usuario, String> colTelefono = new TableColumn<>("Teléfono");
        TableColumn<Usuario, String> colProducto = new TableColumn<>("Producto");
        TableColumn<Usuario, String> colTipoComprador = new TableColumn<>("Tipo Comprador");
        TableColumn<Usuario, String> colMensaje = new TableColumn<>("Mensaje");

        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        colProducto.setCellValueFactory(new PropertyValueFactory<>("producto"));
        colTipoComprador.setCellValueFactory(new PropertyValueFactory<>("tipoComprador"));
        colMensaje.setCellValueFactory(new PropertyValueFactory<>("mensaje"));

        tablaUsuarios.getColumns().addAll(
                colId, colNombre, colEmail, colTelefono,
                colProducto, colTipoComprador, colMensaje
        );
        tablaUsuarios.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }

    // Asigna los datos a la tabla
    public void mostrarDatosUsuarios(List<Usuario> usuarios) {
        tablaUsuarios.setItems(FXCollections.observableArrayList(usuarios));
    }

    // Limpia las cajas de texto tras el registro
    public void limpiarFormulario() {
        txtNombre.clear();
        txtEmail.clear();
        txtTelefono.clear();
        txtProducto.clear();
        txtTipoComprador.clear();
        txtMensaje.clear();
    }

    // --- Getters requeridos por MainController ---

    public Button getBtnInicio() { return btnInicio; }
    public Button getBtnUsuarios() { return btnUsuarios; }
    public Button getBtnRegistrar() { return btnRegistrar; }

    public String getNombre() { return txtNombre.getText(); }
    public String getEmail() { return txtEmail.getText(); }
    public String getTelefono() { return txtTelefono.getText(); }
    public String getProducto() { return txtProducto.getText(); }
    public String getTipoComprador() { return txtTipoComprador.getText(); }
    public String getMensaje() { return txtMensaje.getText(); }
}