package dao;

import model.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAOImpl implements ClienteDAO {

    // Método para verificar si un documento ya existe
    private boolean existeDocumento(String documento) {
        String sql = "SELECT COUNT(*) FROM Cliente WHERE documento = ?";
        try (Connection conn = ConexionBD.getInstancia().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, documento);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void crearCliente(Cliente cliente) {
        // Verificar si el documento ya existe
        if (existeDocumento(cliente.getDocumento())) {
            System.out.println("Error: El documento ya existe en la base de datos.");
            return;  // No insertar el cliente
        }

        String sql = "INSERT INTO Cliente (nombre, apellido, documento) VALUES (?, ?, ?)";
        try (Connection conn = ConexionBD.getInstancia().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellido());
            stmt.setString(3, cliente.getDocumento());
            stmt.executeUpdate();
            System.out.println("Cliente insertado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<Cliente> obtenerTodosLosClientes() {
        String sql = "SELECT * FROM Cliente";
        List<Cliente> clientes = new ArrayList<>();
        try (Connection conn = ConexionBD.getInstancia().getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Cliente cliente = new Cliente(rs.getInt("id"), rs.getString("nombre"),
                                              rs.getString("apellido"), rs.getString("documento"));
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }

    @Override
    public void actualizarCliente(Cliente cliente) {
        String sql = "UPDATE Cliente SET nombre = ?, apellido = ?, documento = ? WHERE id = ?";
        try (Connection conn = ConexionBD.getInstancia().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellido());
            stmt.setString(3, cliente.getDocumento());
            stmt.setInt(4, cliente.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarCliente(int id) {
        String sql = "DELETE FROM Cliente WHERE id = ?";
        try (Connection conn = ConexionBD.getInstancia().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	@Override
	public Cliente obtenerClientePorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}