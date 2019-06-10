package io.github.drewhans555.pr0ca1;

public interface IBoundsChecker {
    boolean binStringIsWithinBounds(String binString, int bitPrecision);
    boolean octStringIsWithinBounds(String octString, int bitPrecision);
    boolean decStringIsWithinBounds(String decString, int bitPrecision, boolean signed) throws NumberOutOfModeBoundsException;
    boolean hexStringIsWithinBounds(String hexString, int bitPrecision);
}
