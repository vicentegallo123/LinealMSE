// Main.java
public class Main {

    public static void main(String[] args) {
        // Datos de ventas y publicidad
        double sales[] = {651, 762, 856, 1063, 1190, 1298, 1421, 1440, 1518};
        double advertising[] = {23, 26, 30, 34, 43, 48, 52, 57, 58};

        // Crear un objeto de la clase SimpleLinearRegression
        SimpleLinearRegression model = new SimpleLinearRegression();

        // Dividir datos en entrenamiento (70%) y prueba (30%)
        int splitIndex = (int) (0.7 * sales.length);
        double[] trainSales = new double[splitIndex];
        double[] trainAdvertising = new double[splitIndex];
        double[] testSales = new double[sales.length - splitIndex];
        double[] testAdvertising = new double[sales.length - splitIndex];

        // Llenar los conjuntos de entrenamiento y prueba
        System.arraycopy(sales, 0, trainSales, 0, splitIndex);
        System.arraycopy(advertising, 0, trainAdvertising, 0, splitIndex);
        System.arraycopy(sales, splitIndex, testSales, 0, sales.length - splitIndex);
        System.arraycopy(advertising, splitIndex, testAdvertising, 0, advertising.length - splitIndex);

        // Entrenar el modelo con datos de entrenamiento
        double beta1 = model.calculateB1(trainSales, trainAdvertising);
        double beta0 = model.calculateB0(trainSales, trainAdvertising, beta1);

        // Mostrar la ecuación de regresión
        model.printRegressionEquation();

        // Evaluar el modelo con los datos de prueba
        double mse = model.evaluate(testSales, testAdvertising);
        System.out.println("\nMean Squared Error (MSE) en datos de prueba: " + mse);

        // Predecir ventas en función de 70 millones invertidos en publicidad
        model.predict(70);
    }
}
