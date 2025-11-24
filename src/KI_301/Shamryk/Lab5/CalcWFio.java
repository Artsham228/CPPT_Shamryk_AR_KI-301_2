package KI_301.Shamryk.Lab5;

import java.io.*;
import java.util.Scanner;

/**
 * Клас для запису та читання результатів обчислень у текстовому та двійковому форматах.
 */
public class CalcWFio {
    
    private double result;

    /**
     * Конструктор.
     */
    public CalcWFio() {
        this.result = 0.0;
    }

    /**
     * Записує результат у текстовий файл.
     * @param fName Ім'я файлу.
     * @throws IOException При помилках запису.
     */
    public void writeResTxt(String fName) throws IOException {
        try (PrintWriter f = new PrintWriter(fName)) {
            f.printf("%f", result);
        }
    }

    /**
     * Зчитує результат з текстового файлу.
     * @param fName Ім'я файлу.
     * @throws IOException При помилках читання.
     */
    public void readResTxt(String fName) throws IOException {
        try (Scanner s = new Scanner(new File(fName))) {
            // Scanner автоматично розпізнає число з файлу (навіть з комою замість крапки)
            if (s.hasNextDouble()) {
                result = s.nextDouble();
            } else {
                throw new IOException("Файл порожній або не містить числа");
            }
        }
    }

    /**
     * Записує результат у двійковий файл.
     * @param fName Ім'я файлу.
     * @throws IOException При помилках запису.
     */
    public void writeResBin(String fName) throws IOException {
        try (DataOutputStream f = new DataOutputStream(new FileOutputStream(fName))) {
            f.writeDouble(result);
        }
    }

    /**
     * Зчитує результат з двійкового файлу.
     * @param fName Ім'я файлу.
     * @throws IOException При помилках читання.
     */
    public void readResBin(String fName) throws IOException {
        try (DataInputStream f = new DataInputStream(new FileInputStream(fName))) {
            result = f.readDouble();
        }
    }

    /**
     * Метод для збереження результату обчислень всередині об'єкта.
     * @param result Результат обчислення.
     */
    public void calculate(double result) {
        this.result = result;
    }

    /**
     * Повертає поточний збережений результат.
     * @return Результат.
     */
    public double getResult() {
        return result;
    }
}