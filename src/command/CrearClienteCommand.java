package command;

import dao.ClienteDAO;
import model.Cliente;

public class CrearClienteCommand implements Command {
    private ClienteDAO clienteDAO;
    private Cliente cliente;

    public CrearClienteCommand(ClienteDAO clienteDAO, Cliente cliente) {
        this.clienteDAO = clienteDAO;
        this.cliente = cliente;
    }

    @Override
    public void ejecutar() {
        clienteDAO.crearCliente(cliente);
    }
}
