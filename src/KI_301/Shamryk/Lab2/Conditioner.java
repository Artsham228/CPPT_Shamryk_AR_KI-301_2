package KI_301.Shamryk.Lab2;

import KI_301.Shamryk.Lab2.components.Compressor;
import KI_301.Shamryk.Lab2.components.Fan;
import KI_301.Shamryk.Lab2.components.Thermostat;
import KI_301.Shamryk.Lab2.enums.FanSpeed;
import KI_301.Shamryk.Lab2.enums.Mode;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Conditioner implements AutoCloseable {

    private final Compressor compressor;
    private final Fan fan;
    private final Thermostat thermostat;
    private boolean isOn;
    private Mode currentMode;
    private final PrintWriter logger;

    /**
     * @param logFilePath 
     * @throws IOException 
     */
    public Conditioner(String logFilePath) throws IOException {
        this.compressor = new Compressor();
        this.fan = new Fan(FanSpeed.MEDIUM);
        this.thermostat = new Thermostat(22);
        this.currentMode = Mode.COOL;
        this.isOn = false;
        this.logger = new PrintWriter(new FileWriter(logFilePath, true),true);
        logActivity("Об'єкт Conditioner створено з налаштуваннями за замовчуванням.");
    }

    /**
     * @param initialTemp  
     * @param initialSpeed 
     * @param initialMode 
     * @param logFilePath  
     * @throws IOException 
     */
    public Conditioner(int initialTemp, FanSpeed initialSpeed, Mode initialMode, String logFilePath) throws IOException {
        this.compressor = new Compressor();
        this.fan = new Fan(initialSpeed);
        this.thermostat = new Thermostat(initialTemp);
        this.currentMode = initialMode;
        this.isOn = false;
        this.logger = new PrintWriter(new FileWriter(logFilePath, true), true);
        logActivity("Об'єкт Conditioner створено з параметрами: Temp=" + initialTemp + ", Speed=" + initialSpeed + ", Mode=" + initialMode);
    }

    public void turnOn() {
        if (!isOn) {
            this.isOn = true;
            if (currentMode != Mode.FAN_ONLY) {
                compressor.start();
            }
            logActivity("Кондиціонер увімкнено.");
        }
    }

    public void turnOff() {
        if (isOn) {
            this.isOn = false;
            compressor.stop();
            logActivity("Кондиціонер вимкнено.");
        }
    }

    /**
     * @param temperature Нова температура в градусах 
     */
    public void setTemperature(int temperature) {
        thermostat.setTargetTemperature(temperature);
        logActivity("Встановлено нову температуру: " + temperature + "°C.");
    }

    /** 
     * @param newMode Новий режим .
     */
    public void setMode(Mode newMode) {
        this.currentMode = newMode;
        if (isOn) {
            if (newMode == Mode.FAN_ONLY) compressor.stop(); else compressor.start();
        }
        logActivity("Змінено режим роботи на: " + newMode);
    }

    /** 
     * @param newSpeed Нова швидкість. */
    public void setFanSpeed(FanSpeed newSpeed) {
        fan.setSpeed(newSpeed);
        logActivity("Встановлено швидкість вентилятора: " + newSpeed);
    }

    public boolean isOn() { return this.isOn; }

    public int getTemperature() { return thermostat.getTargetTemperature(); }

    public void displayStatus() {
        String status = "--- СТАТУС ---\n" + "Стан: " + (isOn ? "Увімкнено" : "Вимкнено") + "\n" + "Режим: " + currentMode + "\n" + "Температура: " + thermostat.getTargetTemperature() + "°C\n" + "Швидкість: " + fan.getSpeed() + "\n" + "Компресор: " + (compressor.isActive() ? "Активний" : "Вимкнений") + "\n" + "--------------";
        System.out.println(status);
        logActivity("Запит статусу кондиціонера.");
    }

    public void activateSwing() {
        logActivity("Режим коливання шторок (Swing) активовано.");
        System.out.println("Шторки почали рухатись.");
    }

    public String checkFilterStatus() {
        logActivity("Виконано перевірку стану фільтра.");
        return "Фільтр чистий.";
    }

    /** 
     * @param message Повідомлення для запису.
     */
    private void logActivity(String message) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        logger.println("[" + timestamp + "] " + message);
    }

    // Метод закриття лог-файлу
    @Override
    public void close() {
        logActivity("Роботу завершено. Файл логів закрито.");
        logger.close();
    }
}