package strategy;

public class InformeMensualStrategy implements GenerarInformeStrategy {
    @Override
    public void generarInforme() {
        System.out.println("Generando informe mensual...");
    }
}