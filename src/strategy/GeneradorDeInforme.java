package strategy;

public class GeneradorDeInforme {
    private GenerarInformeStrategy strategy;

    public void setStrategy(GenerarInformeStrategy strategy) {
        this.strategy = strategy;
    }

    public void generar() {
        if (strategy != null) {
            strategy.generarInforme();
        } else {
            System.out.println("Estrategia no seleccionada");
        }
    }
}
