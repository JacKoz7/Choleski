import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj liczbę wierszy macierzy: ");
        int N = scanner.nextInt();
        int[][] macierz = new int[N][N]; //Macierz A
        int[] AnsList = new int[N]; //Macierz z wynikami rownan
        System.out.println("Wypełnij wiersze macierzy ");
        for(int i = 0; i < N; i++){
            System.out.println("Wiersz " + (i + 1) + ":");
            for(int j = 0; j < N; j++){
                System.out.print("Podaj wartość dla kolumny " + (j + 1) + ": ");
                macierz[i][j] = scanner.nextInt();
            }
        }
        System.out.println("\nPodaj prawe strony rownan równań (macierz b): ");
        for(int i = 0; i < N; i++){
            System.out.print("prawa strona "+ (i + 1) + " równania: ");
            AnsList[i] = scanner.nextInt();
        }
        System.out.println("\nWprowadzona macierz:");   //wyswietlanie macierzy A
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(macierz[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Macierz b");  //wyswietlenie wyników równań
        for (int i = 0; i < N; i++){
            System.out.println(AnsList[i] + " ");
        }
        System.out.println();

        CholeskiLLT choleskiLLT = new CholeskiLLT(macierz, N, AnsList); //tworzymy obiekt choleski LLT
        CholeskiMDM2 choleskiMDM2 = new CholeskiMDM2(macierz, N, AnsList); //tworzymy obiekt choleski MDM
        System.out.println("Wybierz metodę: ");
        System.out.println("1 - A = LL^T");
        System.out.println("2 - A = MDM*");
        int choice = scanner.nextInt();
        if(choice == 1){
            System.out.println("Wybrano A = LL^T");
            System.out.println("\nMacierz L wygląda tak: ");
            choleskiLLT.gettingL(); //tworzy i wyswietla macierz L
            double[] y = choleskiLLT.solveLEquation(); // oblicza wszystkie y
            System.out.println("\nWyniki y");
            for (int i = 0; i < N; i++) {
                System.out.print(y[i] + "\n");
            }
            choleskiLLT.gettingLT(); //Tworzy i wyswietla macierz LT
            double[] x = choleskiLLT.solveLTEquation(); //oblicza wszytskie x
            System.out.println("\nWyniki x");
            for(int i = 0; i < N; i++){
                System.out.print(x[i] + "\n");
            }
        } else if (choice == 2) {
            System.out.println("Wybrano A = MDM*");
            double[][][] result = choleskiMDM2.CholeskiDlaChetnych();
            System.out.println("\nMacierz M: ");
            choleskiMDM2.printMatrix(result[0]);
            System.out.println("\nMacierz D: ");
            choleskiMDM2.printMatrix(result[1]);
            System.out.println("\nMacierz M*: ");
            choleskiMDM2.printMatrix(choleskiMDM2.transpozycjaM(result[0]));
            System.out.println("\nMacierz D^-1: ");
            choleskiMDM2.printMatrix(choleskiMDM2.Diagonal(result[1]));
            System.out.println("\nwyniki y: ");
            double[] y = choleskiMDM2.calculateY(result[0], AnsList);
            for (double value : y) {
                System.out.print(value + "\n");
            }
            double[] x = choleskiMDM2.calculateX(choleskiMDM2.transpozycjaM(result[0]), choleskiMDM2.Diagonal(result[1]), y);
            System.out.println("\nwyniki x: ");
            for (double value : x) {
                System.out.print(value + "\n");
            }
        }else{
            System.out.println("Niepoprawny wybór");
        }
    }
}