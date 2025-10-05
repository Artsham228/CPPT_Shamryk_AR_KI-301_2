import java.io.*;
import java.util.*;

/**
 * Клас Lab1_2 — фігура «пісочний годинник» (заповнені верх і низ)
 */
public class main {
    public static void main(String[] args) throws FileNotFoundException {
        int n;
        char[][] arr;
        char filler;

        Scanner in = new Scanner(System.in);
        File dataFile = new File("MyFile2.txt");
        PrintWriter fout = new PrintWriter(dataFile);

        System.out.print("Введіть розмір квадратної матриці (непарне число ≥ 3): ");
        n = in.nextInt();
        in.nextLine();

        System.out.print("Введіть символ-заповнювач: ");
        String s = in.nextLine();
        if (s.length() != 1) {
            System.out.println("Потрібно ввести рівно один символ!");
            return;
        }
        filler = s.charAt(0);

        arr = new char[n][n];

        // Формування заповнених верхнього і нижнього трикутників
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Верхня половина
                if (i <= n / 2 && (j >= i && j < n - i)) {
                    arr[i][j] = filler;
                }
                // Нижня половина
                else if (i > n / 2 && (j >= n - i - 1 && j <= i)) {
                    arr[i][j] = filler;
                } 
                // Інше — порожнеча
                else {
                    arr[i][j] = ' ';
                }
            }
        }

        // Вивід
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j]);
                fout.print(arr[i][j]);
            }
            System.out.println();
            fout.println();
        }

        fout.flush();
        fout.close();
    }
}
