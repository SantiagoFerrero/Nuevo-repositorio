package dao;

import model.Turno;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TurnoDAOImpl implements TurnoDAO {
    @Override
    public void agregarTurno(Turno turno) {
        String sql = "INSERT INTO Turno (cliente_id, mecanico_id, fecha, hora, estado) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConexionBD.getInstancia().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, turno.getClienteId());
            stmt.setInt(2, turno.getMecanicoId());
            stmt.setDate(3, Date.valueOf(turno.getFecha()));
            stmt.setTime(4, Time.valueOf(turno.getHora()));
            stmt.setString(5, turno.getEstado());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Turno> obtenerTurnos() {
        List<Turno> turnos = new ArrayList<>();
        String sql = "SELECT * FROM Turno";
        try (Connection conn = ConexionBD.getInstancia().getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Turno turno = new Turno(
                        rs.getInt("id"),
                        rs.getInt("cliente_id"),
                        rs.getInt("mecanico_id"),
                        rs.getDate("fecha").toLocalDate(),
                        rs.getTime("hora").toLocalTime(),
                        rs.getString("estado")
                );
                turnos.add(turno);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return turnos;
    }
}
