package KI_301.Shamryk.Lab4;

/**
 * Клас власного виключення для арифметичних помилок.
 */
public class CalcException extends ArithmeticException {
    public CalcException() {
    }

    public CalcException(String cause) {
        super(cause);
    }
}