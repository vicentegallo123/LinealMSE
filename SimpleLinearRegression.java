// SimpleLinearRegression.java
import java.lang.Math;

public class SimpleLinearRegression {
    // Variables para los parámetros beta0 y beta1
    private double beta0;
    private double beta1;
    private int n; // Número de datos

    // Constructor
    public SimpleLinearRegression() {
        beta0 = 0;
        beta1 = 0;
    }

    // Calcular beta0 (intercepto)
    public double calculateB0(double[] sales, double[] advertising, double beta1) {
        double sumX = 0, sumY = 0, sumXY = 0, sumX2 = 0;
        n = sales.length; // Número de elementos

        for (int i = 0; i < n; i++) {
            sumX += advertising[i];
            sumY += sales[i];
            sumXY += advertising[i] * sales[i];
            sumX2 += Math.pow(advertising[i], 2);
        }

        beta0 = (sumY * sumX2 - sumX * sumXY) / (n * sumX2 - Math.pow(sumX, 2));
        return beta0;
    }

    // Calcular beta1 (pendiente)
    public double calculateB1(double[] sales, double[] advertising) {
        double sumX = 0, sumY = 0, sumXY = 0, sumX2 = 0;
        n = sales.length; // Número de elementos

        for (int i = 0; i < n; i++) {
            sumX += advertising[i];
            sumY += sales[i];
            sumXY += advertising[i] * sales[i];
            sumX2 += Math.pow(advertising[i], 2);
        }

        beta1 = (n * sumXY - sumX * sumY) / (n * sumX2 - Math.pow(sumX, 2));
        return beta1;
    }

    // Imprimir la ecuación de regresión
    public void printRegressionEquation() {
        System.out.println("\nSales = " + beta0 + " + " + beta1 + " * Advertising");
    }

    // Predecir ventas en función de un valor dado de publicidad
    public void predict(double advertising) {
        double sales = beta0 + (beta1 * advertising);
        System.out.println("\nDado el valor de advertising: " + advertising + 
                           "\nLas ventas predichas son = " + sales);
    }

    // Evaluar el modelo utilizando el error cuadrático medio (MSE)
    public double evaluate(double[] actualSales, double[] advertising) {
        double mse = 0;
        int size = actualSales.length;
        for (int i = 0; i < size; i++) {
            double predictedSales = beta0 + (beta1 * advertising[i]);
            mse += Math.pow(actualSales[i] - predictedSales, 2);
        }
        return mse / size;
    }
}
