package app;


import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        int n;
        char[][] arr;
        char filler;

        Scanner in = new Scanner(System.in);
        System.out.print("Введіть розмір n: ");
        n = in.nextInt();
        System.out.print("Введіть символ-заповнювач: ");
        filler = in.next().charAt(0);

        arr = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j >= i && j < n - i || j <= i && j >= n - i - 1)
                    arr[i][j] = filler;
                else
                    arr[i][j] = ' ';
            }
        }

        // Вивід у файл
        PrintWriter out = new PrintWriter(new File("output.txt"));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                out.print(arr[i][j]);
                System.out.print(arr[i][j]);
            }
            out.println();
            System.out.println();
        }

        out.close();
        in.close();
    }
}
