package dao;

import model.FichaMecanica;
import java.util.List;

public interface FichaMecanicaDAO {
    void agregarFicha(FichaMecanica fichaMecanica);
    FichaMecanica obtenerFichaPorId(int id);
    List<FichaMecanica> obtenerFichas();
    void actualizarFicha(FichaMecanica fichaMecanica);
    void eliminarFicha(int id);
}