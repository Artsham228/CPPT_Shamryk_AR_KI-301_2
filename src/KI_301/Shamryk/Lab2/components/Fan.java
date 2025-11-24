package KI_301.Shamryk.Lab2.components;

import KI_301.Shamryk.Lab2.enums.FanSpeed;


public class Fan {
    private FanSpeed speed;

    //@param initialSpeed  Початкова швидкість
    public Fan(FanSpeed initialSpeed) { this.speed = initialSpeed; }

    // @param speed Нова швидкість
    public void setSpeed(FanSpeed speed) { this.speed = speed; }

    //@return Поточна швидкість
    public FanSpeed getSpeed() { return speed; }
}