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
        String sql = "SELECT id, name, email, phone, product, buyer_type, message FROM users";

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Usuario u = new Usuario();
                u.setId(rs.getInt("id"));
                u.setNombre(rs.getString("name"));
                u.setEmail(rs.getString("email"));
                u.setTelefono(rs.getString("phone"));
                u.setProducto(rs.getString("product"));
                u.setTipoComprador(rs.getString("buyer_type"));
                u.setMensaje(rs.getString("message"));

                lista.add(u);
            }

        } catch (SQLException e) {
            System.err.println("❌ Error al listar usuarios desde Aiven:");
            e.printStackTrace();
        }

        return lista;
    }

    public void insertar(Usuario usuario) {
        String sql = """
                INSERT INTO users
                (name, email, phone, product, buyer_type, message)
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
            System.err.println("❌ Error al insertar usuario:");
            e.printStackTrace();
        }
    }

    public void actualizar(Usuario usuario) {
        String sql = """
                UPDATE users
                SET name = ?,
                    email = ?,
                    phone = ?,
                    product = ?,
                    buyer_type = ?,
                    message = ?
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
            System.err.println("❌ Error al actualizar usuario:");
            e.printStackTrace();
        }
    }

    public void eliminar(int id) {
        String sql = """
                DELETE FROM users
                WHERE id = ?
                """;

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("❌ Error al eliminar usuario:");
            e.printStackTrace();
        }
    }
}