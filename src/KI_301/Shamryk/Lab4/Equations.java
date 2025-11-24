package KI_301.Shamryk.Lab4;

/**
 * Клас для обчислення виразу y = 1/sin(x).
 */
public class Equations {

    /**
     * Обчислює вираз y = 1/sin(x).
     * @param x Кут у градусах (int).
     * @return Результат обчислення (double).
     * @throws CalcException Якщо sin(x) дорівнює нулю (ділення на нуль).
     */
    public double calculate(int x) throws CalcException {
        // Переводимо градуси в радіани, бо Math.sin приймає радіани
        double rad = Math.toRadians(x);

        // Перевірка на ділення на нуль.
        // sin(x) = 0 при x = 0, 180, 360... 
        // Використовуємо малу похибку або перевірку цілих чисел
        if (x % 180 == 0) {
            throw new CalcException("При x = " + x + " sin(x) дорівнює 0. Ділення на нуль неможливе!");
        }
        
        // Власне формула варіанту 25
        double y = 1.0 / Math.sin(rad);
        return y;
    }
}