package vallegrande.edu.pe.gestionveterinaria.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CitaDAO {

    public List<vallegrande.edu.pe.gestionveterinaria.Model.Cita> listar() throws SQLException {
        List<vallegrande.edu.pe.gestionveterinaria.Model.Cita> lista = new ArrayList<>();
        String sql = "SELECT id_cita, id_mascota, id_veterinario, fecha_cita, estado " +
                "FROM citas ORDER BY id_cita ASC";

        try (Connection conn = vallegrande.edu.pe.gestionveterinaria.Model.Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                vallegrande.edu.pe.gestionveterinaria.Model.Cita c = new vallegrande.edu.pe.gestionveterinaria.Model.Cita();
                c.setIdCita(rs.getInt("id_cita"));
                c.setIdMascota(rs.getInt("id_mascota"));
                c.setIdVeterinario(rs.getInt("id_veterinario"));
                c.setFechaCita(rs.getTimestamp("fecha_cita"));
                c.setEstado(rs.getString("estado"));
                lista.add(c);
            }
        }
        return lista;
    }

    public List<vallegrande.edu.pe.gestionveterinaria.Model.Cita> buscar(String texto) throws SQLException {
        List<vallegrande.edu.pe.gestionveterinaria.Model.Cita> lista = new ArrayList<>();
        String sql = "SELECT id_cita, id_mascota, id_veterinario, fecha_cita, estado " +
                "FROM citas " +
                "WHERE CAST(id_cita AS CHAR) LIKE ? OR CAST(id_mascota AS CHAR) LIKE ? " +
                "OR CAST(id_veterinario AS CHAR) LIKE ? OR estado LIKE ? " +
                "ORDER BY id_cita ASC";

        try (Connection conn = vallegrande.edu.pe.gestionveterinaria.Model.Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            String filtro = "%" + texto + "%";
            stmt.setString(1, filtro);
            stmt.setString(2, filtro);
            stmt.setString(3, filtro);
            stmt.setString(4, filtro);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    vallegrande.edu.pe.gestionveterinaria.Model.Cita c = new vallegrande.edu.pe.gestionveterinaria.Model.Cita();
                    c.setIdCita(rs.getInt("id_cita"));
                    c.setIdMascota(rs.getInt("id_mascota"));
                    c.setIdVeterinario(rs.getInt("id_veterinario"));
                    c.setFechaCita(rs.getTimestamp("fecha_cita"));
                    c.setEstado(rs.getString("estado"));
                    lista.add(c);
                }
            }
        }
        return lista;
    }

    public void insertar(vallegrande.edu.pe.gestionveterinaria.Model.Cita cita) throws SQLException {
        String sql = "INSERT INTO citas (id_mascota, id_veterinario, estado) VALUES (?, ?, ?)";

        try (Connection conn = vallegrande.edu.pe.gestionveterinaria.Model.Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, cita.getIdMascota());
            stmt.setInt(2, cita.getIdVeterinario());
            stmt.setString(3, cita.getEstado());
            stmt.executeUpdate();
        }
    }

    public void actualizar(vallegrande.edu.pe.gestionveterinaria.Model.Cita cita) throws SQLException {
        String sql = "UPDATE citas SET id_mascota = ?, id_veterinario = ?, estado = ? WHERE id_cita = ?";

        try (Connection conn = vallegrande.edu.pe.gestionveterinaria.Model.Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, cita.getIdMascota());
            stmt.setInt(2, cita.getIdVeterinario());
            stmt.setString(3, cita.getEstado());
            stmt.setInt(4, cita.getIdCita());
            stmt.executeUpdate();
        }
    }

    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM citas WHERE id_cita = ?";

        try (Connection conn = vallegrande.edu.pe.gestionveterinaria.Model.Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}