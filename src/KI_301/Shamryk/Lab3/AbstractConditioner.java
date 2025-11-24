package KI_301.Shamryk.Lab3;

import KI_301.Shamryk.Lab2.components.*; // Імпорт деталей
import KI_301.Shamryk.Lab2.enums.*;      // Імпорт режимів
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class AbstractConditioner implements AutoCloseable {

    // protected - щоб нащадок мав доступ
    protected final Compressor compressor;
    protected final Fan fan;
    protected final Thermostat thermostat;
    protected boolean isOn;
    protected Mode currentMode;
    protected final PrintWriter logger;

    public AbstractConditioner(String logFilePath) throws IOException {
        this.compressor = new Compressor();
        this.fan = new Fan(FanSpeed.MEDIUM);
        this.thermostat = new Thermostat(22);
        this.currentMode = Mode.COOL;
        this.isOn = false;
        this.logger = new PrintWriter(new FileWriter(logFilePath, true), true);
        logActivity("Базовий абстрактний кондиціонер створено.");
    }

    // Абстрактний метод (обов'язковий для нащадка)
    public abstract void showDetailedInfo();

    public void turnOn() {
        if (!isOn) {
            this.isOn = true;
            if (currentMode != Mode.FAN_ONLY) compressor.start();
            logActivity("Увімкнено.");
        }
    }

    public void turnOff() {
        if (isOn) {
            this.isOn = false;
            compressor.stop();
            logActivity("Вимкнено.");
        }
    }
    
    public void setTemperature(int temp) {
        thermostat.setTargetTemperature(temp);
        logActivity("Температура змінена на: " + temp);
    }

    protected void logActivity(String message) {
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        logger.println("[" + time + "] " + message);
    }

    @Override
    public void close() {
        logActivity("Завершення роботи.");
        logger.close();
    }
}