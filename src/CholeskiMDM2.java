public class CholeskiMDM2 {
    private int[][] macierz;
    private int size;
    private double[][] M;
    private double[][] D;

    public CholeskiMDM2(int[][] macierz, int size, int[] solutions) {
        this.macierz = macierz;
        this.size = size;
        this.M = new double[size][size];
        this.D = new double[size][size];
    }
    public double[][][] CholeskiDlaChetnych(){ //metoda obliczajaca M I D
        for (int i = 0; i < size; i++) {
            double sum = macierz[i][i];
            for (int k = 0; k < i; k++) {
                sum -= M[i][k] * D[k][k] * M[i][k];
            }

            D[i][i] = sum;

            for (int j = i; j < size; j++) {
                sum = macierz[j][i];
                for (int k = 0; k < i; k++) {
                    sum -= M[j][k] * D[k][k] * M[i][k];
                }
                M[j][i] = sum / D[i][i];
            }
        }

        return new double[][][]{M, D};
    }

    public double[][] transpozycjaM(double[][] matrix) {
        double[][] result = new double[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result[j][i] = matrix[i][j];
            }
        }

        return result;
    }

    public void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    public double[][] Diagonal(double[][] matrix) { //metoda obliczajaca D^-1
        double[][] result = new double[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(matrix[i][j] != 0) {
                    result[i][j] = 1.0 / matrix[i][j];
                }else{
                    result[i][j] = 0;
                }
            }
        }
        return result;
    }

    public double[] calculateY(double[][] matrixM, int[] solutions) {
        double[] y = new double[size];

        for (int i = 0; i < size; i++) {
            double sum = 0.0;
            for (int j = 0; j < i; j++) {
                sum += matrixM[i][j] * y[j];
            }
            y[i] = (solutions[i] - sum) / matrixM[i][i];
        }

        return y;
    }

    public double[] calculateX(double[][] matrixMTransposed, double[][] matrixDInverse, double[] y) {
        double[] x = new double[size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (matrixDInverse[i][j] != 0) {
                    y[i] *= matrixDInverse[i][j];
                }
            }
        }

        for (int i = size - 1; i >= 0; i--) {
            double sum = 0.0;
            for (int j = size - 1; j > i; j--) {
                sum += matrixMTransposed[i][j] * x[j];
            }
            x[i] = (y[i] - sum) / matrixMTransposed[i][i];
        }

        return x;
    }

}