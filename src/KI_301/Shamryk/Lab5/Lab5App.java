package KI_301.Shamryk.Lab5;

import java.io.IOException;
import java.util.Scanner;

/**
 * Драйвер-клас для тестування файлового вводу/виводу.
 */
public class Lab5App {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            // 1. Створюємо об'єкти
            Equations eq = new Equations();
            CalcWFio fileIO = new CalcWFio();

            // 2. Отримуємо дані від користувача
            System.out.print("Введіть кут x (градуси): ");
            int x = in.nextInt();

            // 3. Обчислюємо результат (y = 1/sin(x))
            double result = eq.calculate(x);
            System.out.println("Обчислено: " + result);

            // Передаємо результат в об'єкт для роботи з файлами
            fileIO.calculate(result);

            // --- ТЕСТ ТЕКСТОВОГО ФОРМАТУ ---
            System.out.println("\n--- Робота з Текстовим файлом ---");
            fileIO.writeResTxt("Lab5_Res.txt");
            System.out.println("Записано у Lab5_Res.txt");

            // Обнуляємо результат в об'єкті, щоб перевірити читання чесно
            fileIO.calculate(0.0); 
            
            fileIO.readResTxt("Lab5_Res.txt");
            System.out.println("Зчитано з файлу: " + fileIO.getResult());


            // --- ТЕСТ ДВІЙКОВОГО ФОРМАТУ ---
            System.out.println("\n--- Робота з Двійковим файлом ---");
            fileIO.writeResBin("Lab5_Res.bin");
            System.out.println("Записано у Lab5_Res.bin");

            fileIO.calculate(0.0); // Знову "забуваємо" результат

            fileIO.readResBin("Lab5_Res.bin");
            System.out.println("Зчитано з файлу: " + fileIO.getResult());


        } catch (CalcException e) {
            System.out.println("Помилка обчислень: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Помилка файлів: " + e.getMessage());
        }
    }
}