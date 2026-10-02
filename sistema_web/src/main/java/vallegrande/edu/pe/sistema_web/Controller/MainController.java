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
        // Evento botón Inicio
        view.getBtnInicio().setOnAction(e -> {
            view.mostrarInicio();
        });

        // Evento botón Usuarios (cambia la vista y carga la tabla)
        view.getBtnUsuarios().setOnAction(e -> {
            view.mostrarUsuarios();
            cargarUsuarios();
        });

        // Evento botón Registrar
        view.getBtnRegistrar().setOnAction(e -> {
            registrarUsuario();
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
            // Validación básica
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

            // Limpia los inputs y refresca la tabla
            view.limpiarFormulario();
            cargarUsuarios();

        } catch (Exception e) {
            System.err.println("❌ Error al registrar usuario: " + e.getMessage());
            e.printStackTrace();
        }
    }
}