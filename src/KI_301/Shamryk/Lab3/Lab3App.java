package KI_301.Shamryk.Lab3;

import java.io.IOException;

public class Lab3App {
    public static void main(String[] args) {
        // Запускаємо і тестуємо
        try (SmartConditioner ac = new SmartConditioner("Lab3_Log.txt")) {
            
            ac.turnOn();
            ac.setTemperature(20);
            
            // Використання інтерфейсу
            ac.setEcoMode(true);
            System.out.println(ac.runSelfDiagnosis());
            
            // Вивід інфо
            ac.showDetailedInfo();
            
            ac.turnOff();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}