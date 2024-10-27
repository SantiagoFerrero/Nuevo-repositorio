package dao;

import model.Turno;
import java.util.List;

public interface TurnoDAO {
    void agregarTurno(Turno turno);
    List<Turno> obtenerTurnos();
}
