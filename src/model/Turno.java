package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Turno {
    private int id;
    private int clienteId;
    private int mecanicoId;
    private LocalDate fecha;
    private LocalTime hora;
    private String estado;

    // Constructor completo
    public Turno(int id, int clienteId, int mecanicoId, LocalDate fecha, LocalTime hora, String estado) {
        this.id = id;
        this.clienteId = clienteId;
        this.mecanicoId = mecanicoId;
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
    }

    // Constructor sin ID (para nuevos turnos antes de ser guardados en la BD)
    public Turno(int clienteId, int mecanicoId, LocalDate fecha, LocalTime hora, String estado) {
        this.clienteId = clienteId;
        this.mecanicoId = mecanicoId;
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
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

    public int getMecanicoId() {
        return mecanicoId;
    }

    public void setMecanicoId(int mecanicoId) {
        this.mecanicoId = mecanicoId;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    // Método toString para mostrar la información del turno
    @Override
    public String toString() {
        return "Turno{" +
                "id=" + id +
                ", clienteId=" + clienteId +
                ", mecanicoId=" + mecanicoId +
                ", fecha=" + fecha +
                ", hora=" + hora +
                ", estado='" + estado + '\'' +
                '}';
    }
}