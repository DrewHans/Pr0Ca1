package io.github.drewhans555.pr0ca1;

public class Pr0Number implements IPr0Number {

    private static IBaseConverter baseConverter;
    private static IBoundsChecker boundChecker;
    private static int bitPrecision;
    private static boolean isSigned;
    private String binString;
    private String octString;
    private String decString;
    private String hexString;

    public Pr0Number(IBaseConverter baseCon, IBoundsChecker boundsChec, int bitState, boolean signState) {
        this.binString = "";
        this.octString = "";
        this.decString = "";
        this.hexString = "";
        baseConverter = baseCon;
        boundChecker = boundsChec;
        bitPrecision = bitState;
        isSigned = signState;
    }

    public void appendBinValue(String binValue) throws NumberOutOfModeBoundsException {
        this.setBinValue(this.binString + binValue);
    }

    public void appendOctValue(String octValue) throws NumberOutOfModeBoundsException {
        this.setOctValue(this.octString + octValue);
    }

    public void appendDecValue(String decValue) throws NumberOutOfModeBoundsException {
        this.setDecValue(this.decString + decValue);
    }

    public void appendHexValue(String hexValue) throws NumberOutOfModeBoundsException {
        this.setHexValue(this.hexString + hexValue);
    }

    public void clearValues() {
        this.binString = "";
        this.octString = "";
        this.decString = "";
        this.hexString = "";
    }

    public void copyPr0Number(IPr0Number originalPr0Number) {
        this.binString = originalPr0Number.getBinValue();
        this.octString = originalPr0Number.getOctValue();
        this.decString = originalPr0Number.getDecValue();
        this.hexString = originalPr0Number.getHexValue();
    }

    public void deAppendBinValue() throws NumberOutOfModeBoundsException {
        if (this.binString.length() > 0) {
            this.setBinValue(this.binString.substring(0, this.binString.length() - 1));
        }
    }

    public void deAppendOctValue() throws NumberOutOfModeBoundsException {
        if (this.octString.length() > 0) {
            this.setOctValue(this.octString.substring(0, this.octString.length() - 1));
        }
    }

    public void deAppendDecValue() throws NumberOutOfModeBoundsException {
        if (this.decString.length() > 0) {
            this.setDecValue(this.decString.substring(0, this.decString.length() - 1));
        }
    }

    public void deAppendHexValue() throws NumberOutOfModeBoundsException {
        if (this.hexString.length() > 0) {
            this.setHexValue(this.hexString.substring(0, this.hexString.length() - 1));
        }
    }

    public String getBinValue() {
        return this.binString;
    }

    public String getOctValue() {
        return this.octString;
    }

    public String getDecValue() {
        return this.decString;
    }

    public String getHexValue() {
        return this.hexString;
    }

    public int getBitPrecision() {
        return bitPrecision;
    }

    public boolean getIsSigned() {
        return isSigned;
    }

    private void onBinStringUpdate() throws NumberOutOfModeBoundsException {
        this.binString = truncateLeadingZeros(this.binString);
        if (this.binString.length() == 0) {
            this.clearValues();
        } else {
            this.octString = truncateLeadingZeros(baseConverter.convertBase2toBase8(this.binString, bitPrecision, isSigned));
            this.decString = truncateLeadingZeros(baseConverter.convertBase2toBase10(this.binString, bitPrecision, isSigned));
            this.hexString = truncateLeadingZeros(baseConverter.convertBase2toBase16(this.binString, bitPrecision, isSigned));
        }
    }

    private void onOctStringUpdate() throws NumberOutOfModeBoundsException {
        this.octString = truncateLeadingZeros(this.octString);
        if (this.octString.length() == 0) {
            this.clearValues();
        } else {
            this.binString = truncateLeadingZeros(baseConverter.convertBase8toBase2(this.octString, bitPrecision, isSigned));
            this.decString = truncateLeadingZeros(baseConverter.convertBase2toBase10(this.binString, bitPrecision, isSigned));
            this.hexString = truncateLeadingZeros(baseConverter.convertBase2toBase16(this.binString, bitPrecision, isSigned));
        }
    }

    private void onDecStringUpdate() throws NumberOutOfModeBoundsException {
        this.decString = truncateLeadingZeros(this.decString);
        if (this.decString.length() == 0) {
            this.clearValues();
        } else {
            this.binString = truncateLeadingZeros(baseConverter.convertBase10toBase2(this.decString, bitPrecision, isSigned));
            this.octString = truncateLeadingZeros(baseConverter.convertBase2toBase8(this.binString, bitPrecision, isSigned));
            this.hexString = truncateLeadingZeros(baseConverter.convertBase2toBase16(this.binString, bitPrecision, isSigned));
        }
    }

    private void onHexStringUpdate() throws NumberOutOfModeBoundsException {
        this.hexString = truncateLeadingZeros(this.hexString);
        if (this.hexString.length() == 0) {
            this.clearValues();
        } else {
            this.binString = truncateLeadingZeros(baseConverter.convertBase16toBase2(this.hexString, bitPrecision, isSigned));
            this.octString = truncateLeadingZeros(baseConverter.convertBase2toBase8(this.binString, bitPrecision, isSigned));
            this.decString = truncateLeadingZeros(baseConverter.convertBase2toBase10(this.binString, bitPrecision, isSigned));
        }
    }

    public void setBinValue(String binValue) throws NumberOutOfModeBoundsException {
        if (boundChecker.binStringIsWithinBounds(binValue, bitPrecision)) {
            this.binString = binValue;
            this.onBinStringUpdate();
        }
    }

    public void setOctValue(String octValue) throws NumberOutOfModeBoundsException {
        if (boundChecker.octStringIsWithinBounds(octValue, bitPrecision)) {
            this.octString = octValue;
            this.onOctStringUpdate();
        }
    }

    public void setDecValue(String decValue) throws NumberOutOfModeBoundsException {
        if (boundChecker.decStringIsWithinBounds(decValue, bitPrecision, isSigned)) {
            this.decString = decValue;
            this.onDecStringUpdate();
        }
    }

    public void setHexValue(String hexValue) throws NumberOutOfModeBoundsException {
        if (boundChecker.hexStringIsWithinBounds(hexValue, bitPrecision)) {
            this.hexString = hexValue;
            this.onHexStringUpdate();
        }
    }

    private String truncateLeadingZeros(String string) {
        return string.replaceFirst("^0+(?!$)", "");
    }

    public void updateState(int newBitState, boolean newSignState) {
        bitPrecision = newBitState;
        isSigned = newSignState;
    }

}
