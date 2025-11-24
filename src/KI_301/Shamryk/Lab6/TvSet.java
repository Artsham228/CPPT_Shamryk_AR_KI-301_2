package KI_301.Shamryk.Lab6;

/**
 * Клас Телевізор. Реалізує інтерфейс Comparable для порівняння за ціною.
 */
public class TvSet implements Comparable<TvSet> {
    private String model;
    private int price;

    public TvSet(String model, int price) {
        this.model = model;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    // Метод порівняння (потрібен для пошуку максимуму)
    @Override
    public int compareTo(TvSet other) {
        return Integer.compare(this.price, other.getPrice());
    }

    @Override
    public String toString() {
        return "TV: " + model + " (Ціна: " + price + "$)";
    }
}