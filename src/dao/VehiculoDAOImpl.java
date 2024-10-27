package dao;

import model.Vehiculo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehiculoDAOImpl implements VehiculoDAO {
    @Override
    public void agregarVehiculo(Vehiculo vehiculo) {
        String sql = "INSERT INTO Vehiculo (cliente_id, marca, modelo, numero_poliza) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexionBD.getInstancia().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, vehiculo.getClienteId());
            stmt.setString(2, vehiculo.getMarca());
            stmt.setString(3, vehiculo.getModelo());
            stmt.setString(4, vehiculo.getNumeroPoliza());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Vehiculo> obtenerVehiculos() {
        List<Vehiculo> vehiculos = new ArrayList<>();
        String sql = "SELECT * FROM Vehiculo";
        try (Connection conn = ConexionBD.getInstancia().getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Vehiculo vehiculo = new Vehiculo(
                        rs.getInt("id"),
                        rs.getInt("cliente_id"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getString("numero_poliza")
                );
                vehiculos.add(vehiculo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehiculos;
    }
}