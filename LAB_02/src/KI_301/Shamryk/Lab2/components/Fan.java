package KI_301.Shamryk.Lab2.components;

import KI_301.Shamryk.Lab2.enums.FanSpeed;


public class Fan {
    private FanSpeed speed;

    /**
     * Конструктор початкової швидкості.
     * @param initialSpeed 
     */
    public Fan(FanSpeed initialSpeed) { this.speed = initialSpeed; }

    /** * Встановлює нову швидкість вентилятора.
     * @param speed Нова швидкість.
     */
    public void setSpeed(FanSpeed speed) { this.speed = speed; }

    /** * Повертає поточну швидкість вентилятора.
     * @return Поточна швидкість.
     */
    public FanSpeed getSpeed() { return speed; }
}