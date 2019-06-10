package io.github.drewhans555.pr0ca1;

public interface IBaseConverter {
    String convertBase2toBase8(String binString, int bitPrecision, boolean signed) throws NumberOutOfModeBoundsException;
    String convertBase2toBase10(String binString, int bitPrecision, boolean signed) throws NumberOutOfModeBoundsException;
    String convertBase2toBase16(String binString, int bitPrecision, boolean signed) throws NumberOutOfModeBoundsException;
    String convertBase8toBase2(String octString, int bitPrecision, boolean signed) throws NumberOutOfModeBoundsException;
    String convertBase8toBase10(String octString, int bitPrecision, boolean signed) throws NumberOutOfModeBoundsException;
    String convertBase8toBase16(String octString, int bitPrecision, boolean signed) throws NumberOutOfModeBoundsException;
    String convertBase10toBase2(String decString, int bitPrecision, boolean signed) throws NumberOutOfModeBoundsException;
    String convertBase10toBase8(String decString, int bitPrecision, boolean signed) throws NumberOutOfModeBoundsException;
    String convertBase10toBase16(String decString, int bitPrecision, boolean signed) throws NumberOutOfModeBoundsException;
    String convertBase16toBase2(String hexString, int bitPrecision, boolean signed) throws NumberOutOfModeBoundsException;
    String convertBase16toBase8(String hexString, int bitPrecision, boolean signed) throws NumberOutOfModeBoundsException;
    String convertBase16toBase10(String hexString, int bitPrecision, boolean signed) throws NumberOutOfModeBoundsException;
}
