package vallegrande.edu.pe.gestionveterinaria.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MascotaDAO {

    public List<vallegrande.edu.pe.gestionveterinaria.Model.Mascota> listarTodos() throws SQLException {
        List<vallegrande.edu.pe.gestionveterinaria.Model.Mascota> lista = new ArrayList<>();
        String sql = "SELECT id_mascota, nombre, especie, raza, edad, dueno, telefono " +
                "FROM mascotas ORDER BY id_mascota ASC";

        try (Connection conn = vallegrande.edu.pe.gestionveterinaria.Model.Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                vallegrande.edu.pe.gestionveterinaria.Model.Mascota m = new vallegrande.edu.pe.gestionveterinaria.Model.Mascota();
                m.setIdMascota(rs.getInt("id_mascota"));
                m.setNombre(rs.getString("nombre"));
                m.setEspecie(rs.getString("especie"));
                m.setRaza(rs.getString("raza"));
                m.setEdad(rs.getInt("edad"));
                m.setDueno(rs.getString("dueno"));
                m.setTelefono(rs.getString("telefono"));
                lista.add(m);
            }
        }
        return lista;
    }

    public List<vallegrande.edu.pe.gestionveterinaria.Model.Mascota> listarPorEspecieODueno(String texto) throws SQLException {
        List<vallegrande.edu.pe.gestionveterinaria.Model.Mascota> lista = new ArrayList<>();
        String sql = "SELECT id_mascota, nombre, especie, raza, edad, dueno, telefono " +
                "FROM mascotas " +
                "WHERE nombre LIKE ? OR especie LIKE ? OR raza LIKE ? OR dueno LIKE ? " +
                "ORDER BY id_mascota ASC";

        try (Connection conn = vallegrande.edu.pe.gestionveterinaria.Model.Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            String filtro = "%" + texto + "%";
            stmt.setString(1, filtro);
            stmt.setString(2, filtro);
            stmt.setString(3, filtro);
            stmt.setString(4, filtro);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    vallegrande.edu.pe.gestionveterinaria.Model.Mascota m = new vallegrande.edu.pe.gestionveterinaria.Model.Mascota();
                    m.setIdMascota(rs.getInt("id_mascota"));
                    m.setNombre(rs.getString("nombre"));
                    m.setEspecie(rs.getString("especie"));
                    m.setRaza(rs.getString("raza"));
                    m.setEdad(rs.getInt("edad"));
                    m.setDueno(rs.getString("dueno"));
                    m.setTelefono(rs.getString("telefono"));
                    lista.add(m);
                }
            }
        }
        return lista;
    }

    public boolean insertar(vallegrande.edu.pe.gestionveterinaria.Model.Mascota mascota) throws SQLException {
        String sql = "INSERT INTO mascotas (nombre, especie, raza, edad, dueno, telefono) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = vallegrande.edu.pe.gestionveterinaria.Model.Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, mascota.getNombre());
            stmt.setString(2, mascota.getEspecie());
            stmt.setString(3, mascota.getRaza());
            stmt.setInt(4, mascota.getEdad());
            stmt.setString(5, mascota.getDueno());
            stmt.setString(6, mascota.getTelefono());
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean actualizar(vallegrande.edu.pe.gestionveterinaria.Model.Mascota mascota) throws SQLException {
        String sql = "UPDATE mascotas SET nombre = ?, especie = ?, raza = ?, edad = ?, dueno = ?, telefono = ? " +
                "WHERE id_mascota = ?";

        try (Connection conn = vallegrande.edu.pe.gestionveterinaria.Model.Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, mascota.getNombre());
            stmt.setString(2, mascota.getEspecie());
            stmt.setString(3, mascota.getRaza());
            stmt.setInt(4, mascota.getEdad());
            stmt.setString(5, mascota.getDueno());
            stmt.setString(6, mascota.getTelefono());
            stmt.setInt(7, mascota.getIdMascota());
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean eliminar(int id) throws SQLException {
        String sql = "DELETE FROM mascotas WHERE id_mascota = ?";

        try (Connection conn = vallegrande.edu.pe.gestionveterinaria.Model.Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        }
    }
}