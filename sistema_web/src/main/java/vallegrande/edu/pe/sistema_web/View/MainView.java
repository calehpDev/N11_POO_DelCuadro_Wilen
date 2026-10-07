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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import vallegrande.edu.pe.sistema_web.Model.Usuario;

public class MainView extends BorderPane {

    private Button btnInicio;
    private Button btnUsuarios;

    private TextField txtNombre;
    private TextField txtEmail;
    private TextField txtTelefono;
    private TextField txtProducto;
    private TextField txtTipoComprador;
    private TextField txtMensaje;

    private Button btnRegistrar;
    private Button btnActualizar;
    private Button btnEliminar;

    private TableView<Usuario> tablaUsuarios;

    public MainView() {

        crearMenu();
        crearTabla();
        crearFormulario();

        mostrarInicio();
    }

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

    private Button crearBoton(String texto) {
        Button boton = new Button(texto);
        boton.setPrefWidth(170);
        boton.setPrefHeight(40);
        return boton;
    }

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

    public void mostrarUsuarios() {
        VBox contenido = new VBox(15);
        contenido.setPadding(new Insets(25));

        Label titulo = new Label("GESTIÓN DE USUARIOS");
        titulo.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        GridPane formGrid = new GridPane();
        formGrid.setHgap(10);
        formGrid.setVgap(10);

        formGrid.add(txtNombre, 0, 0);
        formGrid.add(txtEmail, 1, 0);
        formGrid.add(txtTelefono, 2, 0);
        formGrid.add(txtProducto, 0, 1);
        formGrid.add(txtTipoComprador, 1, 1);
        formGrid.add(txtMensaje, 2, 1);

        HBox botonesBox = new HBox(10);
        botonesBox.getChildren().addAll(btnRegistrar, btnActualizar, btnEliminar);

        contenido.getChildren().addAll(
                titulo,
                formGrid,
                botonesBox,
                tablaUsuarios
        );

        setCenter(contenido);
    }

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


        btnRegistrar = new Button("Registrar");
        btnRegistrar.setPrefHeight(35);


        btnActualizar = new Button("Actualizar");
        btnActualizar.setPrefHeight(35);


        btnEliminar = new Button("Eliminar");
        btnEliminar.setPrefHeight(35);
    }

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

    public void mostrarDatosUsuarios(List<Usuario> usuarios) {
        tablaUsuarios.setItems(FXCollections.observableArrayList(usuarios));
    }

    public void limpiarFormulario() {
        txtNombre.clear();
        txtEmail.clear();
        txtTelefono.clear();
        txtProducto.clear();
        txtTipoComprador.clear();
        txtMensaje.clear();
    }

    public void cargarUsuarioEnFormulario(Usuario usuario) {
        if (usuario != null) {
            txtNombre.setText(usuario.getNombre() != null ? usuario.getNombre() : "");
            txtEmail.setText(usuario.getEmail() != null ? usuario.getEmail() : "");
            txtTelefono.setText(usuario.getTelefono() != null ? usuario.getTelefono() : "");
            txtProducto.setText(usuario.getProducto() != null ? usuario.getProducto() : "");
            txtTipoComprador.setText(usuario.getTipoComprador() != null ? usuario.getTipoComprador() : "");
            txtMensaje.setText(usuario.getMensaje() != null ? usuario.getMensaje() : "");
        }
    }

    public Button getBtnInicio() { return btnInicio; }
    public Button getBtnUsuarios() { return btnUsuarios; }
    public Button getBtnRegistrar() { return btnRegistrar; }
    public Button getBtnActualizar() { return btnActualizar; }
    public Button getBtnEliminar() { return btnEliminar; }

    public TableView<Usuario> getTablaUsuarios() { return tablaUsuarios; }

    public Usuario getUsuarioSeleccionado() {
        return tablaUsuarios.getSelectionModel().getSelectedItem();
    }

    public String getNombre() { return txtNombre.getText(); }
    public String getEmail() { return txtEmail.getText(); }
    public String getTelefono() { return txtTelefono.getText(); }
    public String getProducto() { return txtProducto.getText(); }
    public String getTipoComprador() { return txtTipoComprador.getText(); }
    public String getMensaje() { return txtMensaje.getText(); }
}