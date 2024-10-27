package dao;

import model.FichaMecanica;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FichaMecanicaDAOImpl implements FichaMecanicaDAO {

    @Override
    public void agregarFicha(FichaMecanica fichaMecanica) {
        String sql = "INSERT INTO FichaMecanica (turno_id, mecanico_id, actividades_realizadas, repuestos_utilizados, estado) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConexionBD.getInstancia().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, fichaMecanica.getTurnoId());
            stmt.setInt(2, fichaMecanica.getMecanicoId());
            stmt.setString(3, fichaMecanica.getActividadesRealizadas());
            stmt.setString(4, fichaMecanica.getRepuestosUtilizados());
            stmt.setString(5, fichaMecanica.getEstado());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public FichaMecanica obtenerFichaPorId(int id) {
        String sql = "SELECT * FROM FichaMecanica WHERE id = ?";
        FichaMecanica ficha = null;
        try (Connection conn = ConexionBD.getInstancia().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                ficha = new FichaMecanica(
                        rs.getInt("id"),
                        rs.getInt("turno_id"),
                        rs.getInt("mecanico_id"),
                        rs.getString("actividades_realizadas"),
                        rs.getString("repuestos_utilizados"),
                        rs.getString("estado")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ficha;
    }

    @Override
    public List<FichaMecanica> obtenerFichas() {
        List<FichaMecanica> fichas = new ArrayList<>();
        String sql = "SELECT * FROM FichaMecanica";
        try (Connection conn = ConexionBD.getInstancia().getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                FichaMecanica ficha = new FichaMecanica(
                        rs.getInt("id"),
                        rs.getInt("turno_id"),
                        rs.getInt("mecanico_id"),
                        rs.getString("actividades_realizadas"),
                        rs.getString("repuestos_utilizados"),
                        rs.getString("estado")
                );
                fichas.add(ficha);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fichas;
    }

    @Override
    public void actualizarFicha(FichaMecanica fichaMecanica) {
        String sql = "UPDATE FichaMecanica SET turno_id = ?, mecanico_id = ?, actividades_realizadas = ?, repuestos_utilizados = ?, estado = ? WHERE id = ?";
        try (Connection conn = ConexionBD.getInstancia().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, fichaMecanica.getTurnoId());
            stmt.setInt(2, fichaMecanica.getMecanicoId());
            stmt.setString(3, fichaMecanica.getActividadesRealizadas());
            stmt.setString(4, fichaMecanica.getRepuestosUtilizados());
            stmt.setString(5, fichaMecanica.getEstado());
            stmt.setInt(6, fichaMecanica.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarFicha(int id) {
        String sql = "DELETE FROM FichaMecanica WHERE id = ?";
        try (Connection conn = ConexionBD.getInstancia().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}