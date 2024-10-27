package model;

public class Mecanico {
    private int id;
    private String nombre;
    private String especialidad;
    private String horario;

    // Constructor completo
    public Mecanico(int id, String nombre, String especialidad, String horario) {
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.horario = horario;
    }

    // Constructor sin ID (para nuevos mecánicos antes de ser guardados en la BD)
    public Mecanico(String nombre, String especialidad, String horario) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.horario = horario;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    // Método toString para mostrar la información del mecánico
    @Override
    public String toString() {
        return "Mecanico{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", especialidad='" + especialidad + '\'' +
                ", horario='" + horario + '\'' +
                '}';
    }
}
