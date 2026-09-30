package vallegrande.edu.pe.sistema_web.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    public List<Usuario> listar() {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT id, nombre, email, telefono, producto, tipo_comprador, mensaje FROM usuarios";

        try (Connection cn = Conexion.getConexion();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Usuario u = new Usuario(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("email"),
                        rs.getString("telefono"),
                        rs.getString("producto"),
                        rs.getString("tipo_comprador"),
                        rs.getString("mensaje")
                );
                lista.add(u);
            }

        } catch (Exception e) {
            System.err.println("❌ Error al consultar usuarios: " + e.getMessage());
        }

        return lista;
    }
}