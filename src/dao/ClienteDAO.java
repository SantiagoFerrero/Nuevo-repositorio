package dao;

import model.Cliente;
import java.util.List;

public interface ClienteDAO {
    void crearCliente(Cliente cliente);
    Cliente obtenerClientePorId(int id);
    List<Cliente> obtenerTodosLosClientes();
    void actualizarCliente(Cliente cliente);
    void eliminarCliente(int id);
}