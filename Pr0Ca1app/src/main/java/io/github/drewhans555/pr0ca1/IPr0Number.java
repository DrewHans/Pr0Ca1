package io.github.drewhans555.pr0ca1;

public interface IPr0Number {
    void appendBinValue(String binValue) throws NumberOutOfModeBoundsException;
    void appendOctValue(String octValue) throws NumberOutOfModeBoundsException;
    void appendDecValue(String decValue) throws NumberOutOfModeBoundsException;
    void appendHexValue(String hexValue) throws NumberOutOfModeBoundsException;
    void clearValues();
    void copyPr0Number(IPr0Number originalPr0Number);
    void deAppendBinValue() throws NumberOutOfModeBoundsException;
    void deAppendOctValue() throws NumberOutOfModeBoundsException;
    void deAppendDecValue() throws NumberOutOfModeBoundsException;
    void deAppendHexValue() throws NumberOutOfModeBoundsException;
    String getBinValue();
    String getOctValue();
    String getDecValue();
    String getHexValue();
    int getBitPrecision();
    boolean getIsSigned();
    void setBinValue(String binValue) throws NumberOutOfModeBoundsException;
    void setOctValue(String octValue) throws NumberOutOfModeBoundsException;
    void setDecValue(String decValue) throws NumberOutOfModeBoundsException;
    void setHexValue(String hexValue) throws NumberOutOfModeBoundsException;
    void updateState(int newBitState, boolean newSignState);
}