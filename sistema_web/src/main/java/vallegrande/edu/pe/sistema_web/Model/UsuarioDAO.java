package vallegrande.edu.pe.sistema_web.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    public List<Usuario> listar() {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT id, nombre, email, telefono, producto, tipo_comprador, mensaje FROM usuarios";

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Usuario u = new Usuario();
                u.setId(rs.getInt("id"));
                u.setNombre(rs.getString("nombre"));
                u.setEmail(rs.getString("email"));
                u.setTelefono(rs.getString("telefono"));
                u.setProducto(rs.getString("producto"));
                u.setTipoComprador(rs.getString("tipo_comprador"));
                u.setMensaje(rs.getString("mensaje"));

                lista.add(u);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public void insertar(Usuario usuario) {
        String sql = """
                INSERT INTO usuarios
                (nombre, email, telefono, producto, tipo_comprador, mensaje)
                VALUES (?, ?, ?, ?, ?, ?)
                """;

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getTelefono());
            stmt.setString(4, usuario.getProducto());
            stmt.setString(5, usuario.getTipoComprador());
            stmt.setString(6, usuario.getMensaje());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Actualiza un usuario existente en la base de datos
    public void actualizar(Usuario usuario) {
        String sql = """
                UPDATE usuarios
                SET nombre = ?,
                    email = ?,
                    telefono = ?,
                    producto = ?,
                    tipo_comprador = ?,
                    mensaje = ?
                WHERE id = ?
                """;

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getTelefono());
            stmt.setString(4, usuario.getProducto());
            stmt.setString(5, usuario.getTipoComprador());
            stmt.setString(6, usuario.getMensaje());
            stmt.setInt(7, usuario.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminar(int id) {
        String sql = """
                DELETE FROM usuarios
                WHERE id = ?
                """;

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}