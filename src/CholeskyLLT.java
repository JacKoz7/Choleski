public class CholeskyLLT {
    private int[][] matrix;
    private int size;
    private int[] solutions;
    private double[][] L;
    private double[] y;
    private double[][] LT;
    private double[] x;

    public CholeskyLLT(int[][] matrix, int size, int[] solutions) {
        this.matrix = matrix;
        this.size = size;
        this.solutions = solutions;
        this.L = new double[size][size];
        this.y = new double[size];
        this.LT = new double[size][size];
        this.x = new double[size];
    }

    public void gettingL() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j <= i; j++) {
                double sum = 0;
                if (i == j) {
                    for (int k = 0; k < j; k++) {
                        sum += Math.pow(L[j][k], 2);
                    }
                    L[j][j] = Math.sqrt(matrix[j][j] - sum);
                } else {
                    for (int k = 0; k < j; k++) {
                        sum += (L[i][k] * L[j][k]);
                    }
                    L[i][j] = (matrix[i][j] - sum) / L[j][j];
                }
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(L[i][j] + "   ");
            }
            System.out.println();
        }
    }
    public void gettingLT() {
        // Transpozycja macierzy L
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                LT[i][j] = L[j][i];
            }
        }

        // wyswietlanie LT
        System.out.println("\nMacierz transponowana LT:");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(LT[i][j] + "   ");
            }
            System.out.println();
        }
    }
    public double[] solveLEquation() {
        for (int i = 0; i < size; i++) {
            double sum = 0;
            for (int j = 0; j < i; j++) {
                sum += L[i][j] * y[j];
            }
            y[i] = (solutions[i] - sum) / L[i][i];
        }

        return y;
    }

    public double[] solveLTEquation() {

        for (int i = size - 1; i >= 0; i--) {
            double sum = 0;
            for (int j = size - 1; j > i; j--) {
                sum += LT[i][j] * x[j];
            }
            x[i] = (y[i] - sum) / LT[i][i];
        }

        return x;
    }
}
