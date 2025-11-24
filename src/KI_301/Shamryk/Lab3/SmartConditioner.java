package KI_301.Shamryk.Lab3;

import KI_301.Shamryk.Lab2.enums.FanSpeed;
import java.io.IOException;

// Успадковує AbstractConditioner і реалізує HvacInterface
public class SmartConditioner extends AbstractConditioner implements HvacInterface {

    private boolean isEcoMode;

    public SmartConditioner(String logFilePath) throws IOException {
        super(logFilePath); // Виклик конструктора батька
        this.isEcoMode = false;
    }

    // Реалізація методу з Інтерфейсу
    @Override
    public void setEcoMode(boolean enable) {
        this.isEcoMode = enable;
        if (enable) {
            fan.setSpeed(FanSpeed.LOW); // Економимо енергію
            logActivity("ECO-режим увімкнено. Швидкість знижено.");
        } else {
            logActivity("ECO-режим вимкнено.");
        }
    }

    // Реалізація методу з Інтерфейсу
    @Override
    public String runSelfDiagnosis() {
        return "Діагностика: Всі системи в нормі (OK).";
    }

    // Реалізація методу від батька (Abstract)
    @Override
    public void showDetailedInfo() {
        System.out.println("--- SMART INFO ---");
        System.out.println("Статус: " + (isOn ? "Працює" : "Вимкнено"));
        System.out.println("Температура: " + thermostat.getTargetTemperature());
        System.out.println("ECO режим: " + isEcoMode);
    }
}