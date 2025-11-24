package KI_301.Shamryk.Lab6;

/**
 * Клас Меблі. Реалізує інтерфейс Comparable для порівняння за висотою.
 */
public class Furniture implements Comparable<Furniture> {
    private String type;
    private int heightCm;

    public Furniture(String type, int heightCm) {
        this.type = type;
        this.heightCm = heightCm;
    }

    public int getHeight() {
        return heightCm;
    }

    // Метод порівняння
    @Override
    public int compareTo(Furniture other) {
        return Integer.compare(this.heightCm, other.getHeight());
    }

    @Override
    public String toString() {
        return "Меблі: " + type + " (Висота: " + heightCm + " см)";
    }
}