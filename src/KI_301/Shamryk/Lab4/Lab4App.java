package KI_301.Shamryk.Lab4;

import java.io.*;
import java.util.Scanner;

/**
 * Програма-драйвер для тестування класу Equations.
 */
public class Lab4App {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in);
            PrintWriter fout = new PrintWriter(new File("Lab4_Result.txt"))) {

            try {
                System.out.print("Введіть кут x (у градусах): ");
                int x = in.nextInt(); // Читаємо число

                // Створюємо об'єкт і рахуємо
                Equations eq = new Equations();
                double result = eq.calculate(x);

                // Вивід на екран
                System.out.println("Результат: y = " + result);

                // Запис у файл
                fout.print(result);
                System.out.println("Результат успішно записано у файл 'Lab4_Result.txt'");

            } catch (CalcException ex) {
                // Ловимо нашу математичну помилку (ділення на 0)
                System.out.print("Арифметична помилка: " + ex.getMessage());
                fout.print("Error: " + ex.getMessage());
                
            } catch (java.util.InputMismatchException ex) {
                // Ловимо, якщо ввели літери замість цифр
                System.out.print("Помилка: Введено не ціле число.");
            }

        } catch (FileNotFoundException ex) {
            // Ловимо, якщо не вдалося створити файл
            System.out.print("Помилка роботи з файлом: " + ex.getMessage());
        }
    }
}