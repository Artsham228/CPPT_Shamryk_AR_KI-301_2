package KI_301.Shamryk.Lab5;

public class Equations {
    public double calculate(int x) throws CalcException {
        double rad = Math.toRadians(x);
        if (x % 180 == 0) {
            throw new CalcException("При x = " + x + " sin(x) = 0. Ділення на нуль!");
        }
        return 1.0 / Math.sin(rad);
    }
}