package vallegrande.edu.pe.sistema_web.Controller;

import java.util.List;
import vallegrande.edu.pe.sistema_web.Model.Usuario;
import vallegrande.edu.pe.sistema_web.Model.UsuarioDAO;
import vallegrande.edu.pe.sistema_web.View.MainView;

public class MainController {

    private final MainView view;
    private final UsuarioDAO usuarioDAO;

    public MainController(MainView view) {
        this.view = view;
        this.usuarioDAO = new UsuarioDAO();
        configurarEventos();
    }

    private void configurarEventos() {

        view.getBtnInicio().setOnAction(e -> {
            view.mostrarInicio();
        });

        view.getBtnUsuarios().setOnAction(e -> {
            view.mostrarUsuarios();
            cargarUsuarios();
        });

        view.getBtnRegistrar().setOnAction(e -> {
            registrarUsuario();
        });

        view.getBtnActualizar().setOnAction(e -> {
            actualizarUsuario();
        });

        view.getBtnEliminar().setOnAction(e -> {
            eliminarUsuario();
        });

        view.getTablaUsuarios().setOnMouseClicked(e -> {
            Usuario usuario = view.getUsuarioSeleccionado();
            if (usuario != null) {
                view.cargarUsuarioEnFormulario(usuario);
            }
        });
    }

    private void cargarUsuarios() {
        try {
            List<Usuario> usuarios = usuarioDAO.listar();
            view.mostrarDatosUsuarios(usuarios);
        } catch (Exception e) {
            System.err.println("❌ Error al cargar usuarios: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void registrarUsuario() {
        try {

            if (view.getNombre().trim().isEmpty() || view.getEmail().trim().isEmpty()) {
                System.out.println("⚠️ Por favor completa al menos los campos Nombre y Email.");
                return;
            }

            Usuario usuario = new Usuario();
            usuario.setNombre(view.getNombre());
            usuario.setEmail(view.getEmail());
            usuario.setTelefono(view.getTelefono());
            usuario.setProducto(view.getProducto());
            usuario.setTipoComprador(view.getTipoComprador());
            usuario.setMensaje(view.getMensaje());

            usuarioDAO.insertar(usuario);

            view.limpiarFormulario();
            cargarUsuarios();

        } catch (Exception e) {
            System.err.println("❌ Error al registrar usuario: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void actualizarUsuario() {
        try {
            Usuario usuario = view.getUsuarioSeleccionado();
            if (usuario == null) {
                System.out.println("⚠️ Por favor selecciona un usuario de la tabla para actualizar.");
                return;
            }

            usuario.setNombre(view.getNombre());
            usuario.setEmail(view.getEmail());
            usuario.setTelefono(view.getTelefono());
            usuario.setProducto(view.getProducto());
            usuario.setTipoComprador(view.getTipoComprador());
            usuario.setMensaje(view.getMensaje());

            usuarioDAO.actualizar(usuario);

            view.limpiarFormulario();
            cargarUsuarios();

        } catch (Exception e) {
            System.err.println("❌ Error al actualizar usuario: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void eliminarUsuario() {
        try {
            Usuario usuario = view.getUsuarioSeleccionado();
            if (usuario == null) {
                System.out.println("⚠️ Por favor selecciona un usuario de la tabla para eliminar.");
                return;
            }

            usuarioDAO.eliminar(usuario.getId());

            view.limpiarFormulario();
            cargarUsuarios();

        } catch (Exception e) {
            System.err.println("❌ Error al eliminar usuario: " + e.getMessage());
            e.printStackTrace();
        }
    }
}