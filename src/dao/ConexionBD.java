package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static ConexionBD instancia;
    private Connection connection;
    private static final String URL = "jdbc:mysql://localhost:3306/gestionclientes";
    private static final String USER = "root";
    private static final String PASSWORD = "Santiago2002";

    private ConexionBD() throws SQLException {
        this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static ConexionBD getInstancia() throws SQLException {
        if (instancia == null) {
            instancia = new ConexionBD();
        } else if (instancia.getConnection().isClosed()) {  // Verificar si la conexión está cerrada
            instancia = new ConexionBD();  // Restablecer la conexión si está cerrada
        }
        return instancia;
    }

    public Connection getConnection() {
        return connection;
    }
}