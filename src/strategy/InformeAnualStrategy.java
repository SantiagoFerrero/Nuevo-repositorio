package strategy;

public class InformeAnualStrategy implements GenerarInformeStrategy {
    @Override
    public void generarInforme() {
        System.out.println("Generando informe anual...");
    }
}