package KI_301.Shamryk.Lab2.components;


public class Thermostat {
    private int targetTemperature;
    // @param initialTemp Початкова температура
    public Thermostat(int initialTemp) { this.targetTemperature = initialTemp; }
    // @param temperature Нова температура
    public void setTargetTemperature(int temperature) { this.targetTemperature = temperature; }
    // @return Цільова температура
    public int getTargetTemperature() { return targetTemperature; }
}