package dao;

import model.Mecanico;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MecanicoDAOImpl implements MecanicoDAO {
    @Override
    public List<Mecanico> obtenerMecanicos() {
        List<Mecanico> mecanicos = new ArrayList<>();
        String sql = "SELECT * FROM Mecanico";
        try (Connection conn = ConexionBD.getInstancia().getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Mecanico mecanico = new Mecanico(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("especialidad"),
                        rs.getString("horario")
                );
                mecanicos.add(mecanico);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mecanicos;
    }
}
