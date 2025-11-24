package KI_301.Shamryk.Lab3;

public interface HvacInterface {
    // Метод для ЕКО-режиму
    void setEcoMode(boolean enable);

    // Метод для діагностики
    String runSelfDiagnosis();
}