package KI_301.Shamryk.Lab2.components;


public class Thermostat {
    private int targetTemperature;

    /**
     * Конструктор температури.
     * @param initialTemp Початкова температура.
     */
    public Thermostat(int initialTemp) { this.targetTemperature = initialTemp; }

    /** * Встановлює нову температуру.
     * @param temperature Нова температура.
     */
    public void setTargetTemperature(int temperature) { this.targetTemperature = temperature; }

    /** * Повертає температуру.
     * @return Цільова температура.
     */
    public int getTargetTemperature() { return targetTemperature; }
}