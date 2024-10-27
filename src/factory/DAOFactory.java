package factory;

import dao.ClienteDAO;
import dao.ClienteDAOImpl;

public abstract class DAOFactory {
    public abstract ClienteDAO crearClienteDAO();

    public static DAOFactory getDAOFactory() {
        return new ClienteDAOFactory();
    }
}
