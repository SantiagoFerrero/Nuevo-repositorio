package factory;

import dao.ClienteDAO;
import dao.ClienteDAOImpl;

public class ClienteDAOFactory extends DAOFactory {
    @Override
    public ClienteDAO crearClienteDAO() {
        return new ClienteDAOImpl();
    }
}
