import command.CrearClienteCommand;
import command.Invoker;
import dao.ClienteDAO;
import dao.ClienteDAOImpl;
import factory.DAOFactory;
import model.Cliente;
import strategy.GeneradorDeInforme;
import strategy.InformeAnualStrategy;
import strategy.InformeMensualStrategy;
import dao.MecanicoDAO;
import dao.MecanicoDAOImpl;
import dao.TurnoDAO;
import dao.TurnoDAOImpl;
import dao.VehiculoDAO;
import dao.VehiculoDAOImpl;
import dao.FichaMecanicaDAO;
import dao.FichaMecanicaDAOImpl;
import model.Mecanico;
import model.Vehiculo;
import model.Turno;
import model.FichaMecanica;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static ClienteDAO clienteDAO = DAOFactory.getDAOFactory().crearClienteDAO();
    private static GeneradorDeInforme generadorDeInforme = new GeneradorDeInforme();

    public static void main(String[] args) {
        boolean continuar = true;

        while (continuar) {
            mostrarMenuPrincipal();
            int opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    mostrarClientes();
                    break;
                case 2:
                    agregarCliente();
                    break;
                case 3:
                    mostrarVehiculos();  // Implementar método para mostrar vehículos
                    break;
                case 4:
                    agregarVehiculo();  // Implementar método para agregar vehículos
                    break;
                case 5:
                    mostrarMecanicos();  // Implementar método para mostrar mecánicos
                    break;
                case 6:
                    generarInforme();
                    break;
                case 7:
                    mostrarFichaMecanica();  // Implementar método para mostrar ficha mecánica
                    break;
                case 8:
                    agregarTurno();  // Implementar método para agregar turnos
                    break;
                case 0:
                    continuar = false;
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        }
        scanner.close();
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("\n--- Sistema de Gestión ---");
        System.out.println("1. Mostrar clientes");
        System.out.println("2. Agregar cliente");
        System.out.println("3. Mostrar vehículos");
        System.out.println("4. Agregar vehículo");
        System.out.println("5. Mostrar mecánicos");
        System.out.println("6. Generar informe");
        System.out.println("7. Mostrar ficha mecánica");
        System.out.println("8. Agregar turno");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void mostrarClientes() {
        List<Cliente> clientes = clienteDAO.obtenerTodosLosClientes();
        System.out.println("\n--- Lista de Clientes ---");
        for (Cliente cliente : clientes) {
            System.out.println("ID: " + cliente.getId() + ", Nombre: " + cliente.getNombre() +
                    ", Apellido: " + cliente.getApellido() + ", Documento: " + cliente.getDocumento());
        }
    }

    private static void agregarCliente() {
        System.out.println("\n--- Agregar Cliente ---");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Documento: ");
        String documento = scanner.nextLine();

        Cliente cliente = new Cliente(0, nombre, apellido, documento);
        CrearClienteCommand crearClienteCommand = new CrearClienteCommand(clienteDAO, cliente);
        Invoker invoker = new Invoker();
        invoker.addCommand(crearClienteCommand);
        invoker.ejecutarCommands();
        System.out.println("Cliente agregado exitosamente.");
    }

    private static void mostrarVehiculos() {
        VehiculoDAO vehiculoDAO = new VehiculoDAOImpl();
        List<Vehiculo> vehiculos = vehiculoDAO.obtenerVehiculos();
        System.out.println("\n--- Lista de Vehículos ---");
        for (Vehiculo vehiculo : vehiculos) {
            System.out.println("ID: " + vehiculo.getId() + ", Cliente ID: " + vehiculo.getClienteId() +
                    ", Marca: " + vehiculo.getMarca() + ", Modelo: " + vehiculo.getModelo() +
                    ", Póliza: " + vehiculo.getNumeroPoliza());
        }
    }

    private static void agregarVehiculo() {
        System.out.println("\n--- Agregar Vehículo ---");
        System.out.print("ID del Cliente: ");
        int clienteId = Integer.parseInt(scanner.nextLine());
        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();
        System.out.print("Número de Póliza: ");
        String numeroPoliza = scanner.nextLine();

        Vehiculo vehiculo = new Vehiculo(0, clienteId, marca, modelo, numeroPoliza);
        VehiculoDAO vehiculoDAO = new VehiculoDAOImpl();
        vehiculoDAO.agregarVehiculo(vehiculo);
        System.out.println("Vehículo agregado exitosamente.");
    }

    private static void mostrarMecanicos() {
        MecanicoDAO mecanicoDAO = new MecanicoDAOImpl();
        List<Mecanico> mecanicos = mecanicoDAO.obtenerMecanicos();
        System.out.println("\n--- Lista de Mecánicos ---");
        for (Mecanico mecanico : mecanicos) {
            System.out.println("ID: " + mecanico.getId() + ", Nombre: " + mecanico.getNombre() +
                    ", Especialidad: " + mecanico.getEspecialidad() + ", Horario: " + mecanico.getHorario());
        }
    }

    private static void generarInforme() {
        System.out.println("\n--- Generar Informe ---");
        System.out.println("1. Informe Mensual");
        System.out.println("2. Informe Anual");
        System.out.print("Seleccione el tipo de informe: ");
        int opcion = Integer.parseInt(scanner.nextLine());

        switch (opcion) {
            case 1:
                generadorDeInforme.setStrategy(new InformeMensualStrategy());
                generadorDeInforme.generar();
                break;
            case 2:
                generadorDeInforme.setStrategy(new InformeAnualStrategy());
                generadorDeInforme.generar();
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    private static void mostrarFichaMecanica() {
        FichaMecanicaDAO fichaDAO = new FichaMecanicaDAOImpl();
        List<FichaMecanica> fichas = fichaDAO.obtenerFichas();
        System.out.println("\n--- Lista de Fichas Mecánicas ---");
        for (FichaMecanica ficha : fichas) {
            System.out.println("ID: " + ficha.getId() + ", Turno ID: " + ficha.getTurnoId() +
                    ", Mecánico ID: " + ficha.getMecanicoId() + ", Actividades: " + ficha.getActividadesRealizadas() +
                    ", Repuestos: " + ficha.getRepuestosUtilizados() + ", Estado: " + ficha.getEstado());
        }
    }

    private static void agregarTurno() {
        System.out.println("\n--- Agregar Turno ---");
        System.out.print("ID del Cliente: ");
        int clienteId = Integer.parseInt(scanner.nextLine());
        System.out.print("ID del Mecánico: ");
        int mecanicoId = Integer.parseInt(scanner.nextLine());
        System.out.print("Fecha (YYYY-MM-DD): ");
        String fecha = scanner.nextLine();
        System.out.print("Hora (HH:MM): ");
        String hora = scanner.nextLine();
        String estado = "Pendiente";

        Turno turno = new Turno(0, clienteId, mecanicoId, LocalDate.parse(fecha), LocalTime.parse(hora), estado);
        TurnoDAO turnoDAO = new TurnoDAOImpl();
        turnoDAO.agregarTurno(turno);
        System.out.println("Turno agregado exitosamente.");
    }
}