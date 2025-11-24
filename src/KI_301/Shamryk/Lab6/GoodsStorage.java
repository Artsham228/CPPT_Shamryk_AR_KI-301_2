package KI_301.Shamryk.Lab6;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Параметризований клас "Сховище товарів".
 * @param <T> Тип товару, який має реалізовувати інтерфейс Comparable.
 */
public class GoodsStorage<T extends Comparable<T>> {
    
    // Внутрішній список для зберігання речей
    private ArrayList<T> storage;

    /**
     * Конструктор сховища.
     */
    public GoodsStorage() {
        storage = new ArrayList<>();
    }

    /**
     * Метод 1: Додавання товару у сховище.
     * @param item Товар для додавання.
     */
    public void addItem(T item) {
        storage.add(item);
        System.out.println("Товар додано: " + item.toString());
    }

    /**
     * Метод 2: Видалення товару зі сховища за індексом.
     * @param index Індекс товару.
     */
    public void removeItem(int index) {
        if (index >= 0 && index < storage.size()) {
            T removed = storage.remove(index);
            System.out.println("Товар видалено: " + removed.toString());
        } else {
            System.out.println("Помилка: Невірний індекс.");
        }
    }

    /**
     * Метод 3: Пошук максимального елемента (ВАРІАНТ 25).
     * @return Найбільший (максимальний) об'єкт у сховищі.
     */
    public T findMax() {
        if (storage.isEmpty()) {
            return null;
        }
        // Використовуємо вбудований метод Java для пошуку максимуму
        return Collections.max(storage);
    }

    /**
     * Метод 4: Вивід всього вмісту сховища.
     */
    public void printStorage() {
        System.out.println("--- Вміст сховища: ---");
        for (T item : storage) {
            System.out.println(item);
        }
        System.out.println("----------------------");
    }
}