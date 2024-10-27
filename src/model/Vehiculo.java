package model;

public class Vehiculo {
    private int id;
    private int clienteId; // ID del cliente al que pertenece el vehículo
    private String marca;
    private String modelo;
    private String numeroPoliza;

    // Constructor completo
    public Vehiculo(int id, int clienteId, String marca, String modelo, String numeroPoliza) {
        this.id = id;
        this.clienteId = clienteId;
        this.marca = marca;
        this.modelo = modelo;
        this.numeroPoliza = numeroPoliza;
    }

    // Constructor sin ID (para nuevos vehículos antes de ser guardados en la BD)
    public Vehiculo(int clienteId, String marca, String modelo, String numeroPoliza) {
        this.clienteId = clienteId;
        this.marca = marca;
        this.modelo = modelo;
        this.numeroPoliza = numeroPoliza;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNumeroPoliza() {
        return numeroPoliza;
    }

    public void setNumeroPoliza(String numeroPoliza) {
        this.numeroPoliza = numeroPoliza;
    }

    // Método toString para mostrar la información del vehículo
    @Override
    public String toString() {
        return "Vehiculo{" +
                "id=" + id +
                ", clienteId=" + clienteId +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", numeroPoliza='" + numeroPoliza + '\'' +
                '}';
    }
}
