package dao;

import model.Vehiculo;
import java.util.List;

public interface VehiculoDAO {
    void agregarVehiculo(Vehiculo vehiculo);
    List<Vehiculo> obtenerVehiculos();
}