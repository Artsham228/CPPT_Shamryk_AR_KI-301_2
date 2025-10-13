package KI_301.Shamryk.Lab2;

import KI_301.Shamryk.Lab2.enums.FanSpeed;
import KI_301.Shamryk.Lab2.enums.Mode;

import java.io.IOException;

/**
 * Клас для тесту.
 */
public class ConditionerDriver {


    public static void main(String[] args) {
        System.out.println("Запуск демонстрації роботи кондиціонера...");

        try (Conditioner myCooler = new Conditioner("conditioner_log.txt")) {

            myCooler.displayStatus();
            myCooler.turnOn();
            myCooler.setTemperature(18);
            myCooler.setFanSpeed(FanSpeed.HIGH);
            myCooler.activateSwing();

            System.out.println("\n[ДІЯ] Налаштовано на інтенсивне охолодження.");
            myCooler.displayStatus();

            System.out.println("\n[ДІЯ] Перевірка фільтра: " + myCooler.checkFilterStatus());

            myCooler.setMode(Mode.HEAT);
            myCooler.setTemperature(25);
            myCooler.setFanSpeed(FanSpeed.LOW);

            System.out.println("\n[ДІЯ] Переведено в режим обігріву.");
            myCooler.displayStatus();

            myCooler.turnOff();
            System.out.println("\n[ДІЯ] Кондиціонер вимкнено.");
            myCooler.displayStatus();

        } catch (IOException e) {
            System.err.println("Помилка роботи з файлом логів: " + e.getMessage());
        }

        System.out.println("\nДемонстрацію завершено. Перевірте файл 'conditioner_log.txt'.");
    }
}