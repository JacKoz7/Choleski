import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of matrix rows: ");
        int N = scanner.nextInt();
        int[][] matrix = new int[N][N]; //Matrix A
        int[] AnsList = new int[N]; //Matrix with equation results
        System.out.println("Fill in the matrix rows ");
        for(int i = 0; i < N; i++){
            System.out.println("Row " + (i + 1) + ":");
            for(int j = 0; j < N; j++){
                System.out.print("Enter value for column " + (j + 1) + ": ");
                matrix[i][j] = scanner.nextInt();
            }
        }
        System.out.println("\nEnter right side of the equation, i.e., matrix b: ");
        for(int i = 0; i < N; i++){
            System.out.print("Result of equation " + (i + 1) + ": ");
            AnsList[i] = scanner.nextInt();
        }
        System.out.println("\nEntered matrix:");
        //displaying matrix A
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Matrix b");
        //displaying equation results
        for (int i = 0; i < N; i++){
            System.out.println(AnsList[i] + " ");
        }
        System.out.println();
        CholeskyLLT choleskyLLT = new CholeskyLLT(matrix, N, AnsList);
        CholeskyMDM2 choleskyMDM2 = new CholeskyMDM2(matrix, N, AnsList);
        System.out.println("Choose a method: ");
        System.out.println("1 - A = LL^T");
        System.out.println("2 - A = MDM*");
        int choice = scanner.nextInt();
        if(choice == 1){
            System.out.println("Selected A = LL^T");
            System.out.println("\nMatrix L looks like this: ");
            choleskyLLT.gettingL(); //creates and displays matrix L
            double[] y = choleskyLLT.solveLEquation(); // calculates all y
            System.out.println("\nResults y");
            for (int i = 0; i < N; i++) {
                System.out.print(y[i] + "\n");
            }
            choleskyLLT.gettingLT(); //Creates and displays matrix LT
            double[] x = choleskyLLT.solveLTEquation(); //calculates all x
            System.out.println("\nResults x");
            for(int i = 0; i < N; i++){
                System.out.print(x[i] + "\n");
            }
        } else if (choice == 2) {
            System.out.println("Selected A = MDM*");
            double[][][] result = choleskyMDM2.CholeskySecond();
            System.out.println("\nMatrix M: ");
            choleskyMDM2.printMatrix(result[0]);
            System.out.println("\nMatrix D: ");
            choleskyMDM2.printMatrix(result[1]);
            System.out.println("\nMatrix M*: ");
            choleskyMDM2.printMatrix(choleskyMDM2.transpositionM(result[0]));
            System.out.println("\nMatrix D^-1: ");
            choleskyMDM2.printMatrix(choleskyMDM2.Diagonal(result[1]));
            System.out.println("\nResults y: ");
            double[] y = choleskyMDM2.calculateY(result[0], AnsList);
            for (double value : y) {
                System.out.print(value + "\n");
            }
            double[] x = choleskyMDM2.calculateX(choleskyMDM2.transpositionM(result[0]), choleskyMDM2.Diagonal(result[1]), y);
            System.out.println("\nResults x: ");
            for (double value : x) {
                System.out.print(value + "\n");
            }
        }else{
            System.out.println("Invalid choice");
        }
    }
}