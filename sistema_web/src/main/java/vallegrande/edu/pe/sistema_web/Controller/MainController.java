package vallegrande.edu.pe.sistema_web.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import vallegrande.edu.pe.sistema_web.Model.Usuario;
import vallegrande.edu.pe.sistema_web.Model.UsuarioDAO;

public class MainController {

    @FXML private TableView<Usuario> tablaUsuarios;
    @FXML private TableColumn<Usuario, Integer> colId;
    @FXML private TableColumn<Usuario, String> colNombre;
    @FXML private TableColumn<Usuario, String> colEmail;
    @FXML private TableColumn<Usuario, String> colTelefono;
    @FXML private TableColumn<Usuario, String> colProducto;
    @FXML private TableColumn<Usuario, String> colTipoComprador;
    @FXML private TableColumn<Usuario, String> colMensaje;

    private final UsuarioDAO usuarioDAO = new UsuarioDAO();

    @FXML
    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        colProducto.setCellValueFactory(new PropertyValueFactory<>("producto"));
        colTipoComprador.setCellValueFactory(new PropertyValueFactory<>("tipoComprador"));
        colMensaje.setCellValueFactory(new PropertyValueFactory<>("mensaje"));

        cargarDatosBD();
    }

    private void cargarDatosBD() {
        ObservableList<Usuario> lista = FXCollections.observableArrayList(usuarioDAO.listar());
        tablaUsuarios.setItems(lista);
    }
}