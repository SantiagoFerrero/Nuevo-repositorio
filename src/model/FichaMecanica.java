package model;

public class FichaMecanica {
    private int id;
    private int turnoId;
    private int mecanicoId;
    private String actividadesRealizadas;
    private String repuestosUtilizados;
    private String estado;

    // Constructor completo
    public FichaMecanica(int id, int turnoId, int mecanicoId, String actividadesRealizadas, String repuestosUtilizados, String estado) {
        this.id = id;
        this.turnoId = turnoId;
        this.mecanicoId = mecanicoId;
        this.actividadesRealizadas = actividadesRealizadas;
        this.repuestosUtilizados = repuestosUtilizados;
        this.estado = estado;
    }

    // Constructor sin ID (para nuevas fichas antes de ser guardadas en la BD)
    public FichaMecanica(int turnoId, int mecanicoId, String actividadesRealizadas, String repuestosUtilizados, String estado) {
        this.turnoId = turnoId;
        this.mecanicoId = mecanicoId;
        this.actividadesRealizadas = actividadesRealizadas;
        this.repuestosUtilizados = repuestosUtilizados;
        this.estado = estado;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTurnoId() {
        return turnoId;
    }

    public void setTurnoId(int turnoId) {
        this.turnoId = turnoId;
    }

    public int getMecanicoId() {
        return mecanicoId;
    }

    public void setMecanicoId(int mecanicoId) {
        this.mecanicoId = mecanicoId;
    }

    public String getActividadesRealizadas() {
        return actividadesRealizadas;
    }

    public void setActividadesRealizadas(String actividadesRealizadas) {
        this.actividadesRealizadas = actividadesRealizadas;
    }

    public String getRepuestosUtilizados() {
        return repuestosUtilizados;
    }

    public void setRepuestosUtilizados(String repuestosUtilizados) {
        this.repuestosUtilizados = repuestosUtilizados;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    // Método toString para mostrar la información de la ficha mecánica
    @Override
    public String toString() {
        return "FichaMecanica{" +
                "id=" + id +
                ", turnoId=" + turnoId +
                ", mecanicoId=" + mecanicoId +
                ", actividadesRealizadas='" + actividadesRealizadas + '\'' +
                ", repuestosUtilizados='" + repuestosUtilizados + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
