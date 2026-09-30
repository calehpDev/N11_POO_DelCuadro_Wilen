package vallegrande.edu.pe.sistema_web.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    // Apuntamos a la base de datos real: sistema_usuarios
    private static final String URL = "jdbc:mysql://localhost:3309/sistema_usuarios";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public static Connection getConexion() {
        Connection cn = null;
        try {
            cn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Conexión exitosa a la base de datos sistema_usuarios");
        } catch (SQLException e) {
            System.err.println("❌ Error al conectar a la base de datos: " + e.getMessage());
        }
        return cn;
    }
}