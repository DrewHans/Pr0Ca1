package io.github.drewhans555.pr0ca1;

/**
 * Pr0Number Class
 *
 * @author Drew Hans(https://github.com/DrewHans555)
 */
public class Pr0Number {

    private static BaseConverter baseConverter;
    private static int bitPrecision; //calculator state
    private static boolean isSigned; //calculator state
    private String binString; //object state
    private String octString; //object state
    private String decString; //object state
    private String hexString; //object state

    /**
     * Pr0Number Constructor
     */
    public Pr0Number() {
        //shared across all Pr0Number objects
        baseConverter = new BaseConverter();

        //unique to an single Pr0Number object
        this.binString = "";
        this.octString = "";
        this.decString = "";
        this.hexString = "";
    }//end Pr0Number Constructor

    /**
     * Pr0Number Constructor
     *
     * @param bitState  - the precision state of the calculator
     * @param signState - the signed state of the calculator
     */
    public Pr0Number(int bitState, boolean signState) {
        //shared across all Pr0Number objects
        baseConverter = new BaseConverter();
        bitPrecision = bitState;
        isSigned = signState;

        //unique to an single Pr0Number object
        this.binString = "";
        this.octString = "";
        this.decString = "";
        this.hexString = "";
    }//end Pr0Number Constructor

    /**
     * appendBinValue Method
     *
     * @param binValue - a single base 2 string
     * @throws NumberOutOfModeBoundsException when BaseConverter throws NumberOutOfModeBoundsException
     */
    public void appendBinValue(String binValue) throws NumberOutOfModeBoundsException {
        this.setBinValue(this.binString + binValue);
    }//end appendBinValue method

    /**
     * appendOctValue Method
     *
     * @param octValue - a single base 8 string
     * @throws NumberOutOfModeBoundsException when BaseConverter throws NumberOutOfModeBoundsException
     */
    public void appendOctValue(String octValue) throws NumberOutOfModeBoundsException {
        this.setOctValue(this.octString + octValue);
    }//end appendOctValue method

    /**
     * appendDecValue Method
     *
     * @param decValue - a single base 10 string
     * @throws NumberOutOfModeBoundsException when BaseConverter throws NumberOutOfModeBoundsException
     */
    public void appendDecValue(String decValue) throws NumberOutOfModeBoundsException {
        this.setDecValue(this.decString + decValue);
    }//end appendDecValue method

    /**
     * appendHexValue Method
     *
     * @param hexValue - a single base 16 string
     * @throws NumberOutOfModeBoundsException when BaseConverter throws NumberOutOfModeBoundsException
     */
    public void appendHexValue(String hexValue) throws NumberOutOfModeBoundsException {
        this.setHexValue(this.hexString + hexValue);
    }//end appendBinValue method

    /**
     * clearValues Method
     */
    public void clearValues() {
        this.binString = "";
        this.octString = "";
        this.decString = "";
        this.hexString = "";
    }//end clearValues method

    /**
     * copyPr0Number Method - takes an existing Pr0Number and copies its values
     *
     * @param originalPr0Number - an existing Pr0Number
     */
    public void copyPr0Number(Pr0Number originalPr0Number) {
        this.binString = originalPr0Number.getBinValue();
        this.octString = originalPr0Number.getOctValue();
        this.decString = originalPr0Number.getDecValue();
        this.hexString = originalPr0Number.getHexValue();
    }

    /**
     * deAppendBinValue Method
     *
     * @throws NumberOutOfModeBoundsException when BaseConverter throws NumberOutOfModeBoundsException
     */
    public void deAppendBinValue() throws NumberOutOfModeBoundsException {
        if (this.binString.length() > 0) {
            this.setBinValue(this.binString.substring(0, this.binString.length() - 1));
        }
    }//end appendBinValue method

    /**
     * deAppendOctValue Method
     *
     * @throws NumberOutOfModeBoundsException when BaseConverter throws NumberOutOfModeBoundsException
     */
    public void deAppendOctValue() throws NumberOutOfModeBoundsException {
        if (this.octString.length() > 0) {
            this.setOctValue(this.octString.substring(0, this.octString.length() - 1));
        }
    }//end appendOctValue method

    /**
     * deAppendDecValue Method
     *
     * @throws NumberOutOfModeBoundsException when BaseConverter throws NumberOutOfModeBoundsException
     */
    public void deAppendDecValue() throws NumberOutOfModeBoundsException {
        if (this.decString.length() > 0) {
            this.setDecValue(this.decString.substring(0, this.decString.length() - 1));
        }
    }//end appendDecValue method

    /**
     * deAppendHexValue Method
     *
     * @throws NumberOutOfModeBoundsException when BaseConverter throws NumberOutOfModeBoundsException
     */
    public void deAppendHexValue() throws NumberOutOfModeBoundsException {
        if (this.hexString.length() > 0) {
            this.setHexValue(this.hexString.substring(0, this.hexString.length() - 1));
        }
    }//end appendBinValue method

    /**
     * getBinValue Method
     *
     * @return this Pr0Number's binString
     */
    public String getBinValue() {
        return this.binString;
    }//end getBinValue method

    /**
     * getOctValue Method
     *
     * @return this Pr0Number's octString
     */
    public String getOctValue() {
        return this.octString;
    }//end getOctValue method

    /**
     * getDecValue Method
     *
     * @return this Pr0Number's decString
     */
    public String getDecValue() {
        return this.decString;
    }//end getDecValue method

    /**
     * getHexValue Method
     *
     * @return this Pr0Number's hexString
     */
    public String getHexValue() {
        return this.hexString;
    }//end getHexValue method

    /**
     * getBitPrecision Method
     *
     * @return the bitPrecision value for all Pr0Number objects
     */
    public static int getBitPrecision() {
        return bitPrecision;
    }//end getBitPrecision method

    /**
     * getIsSigned Method
     *
     * @return the isSigned value for all Pr0Number objects
     */
    public static boolean getIsSigned() {
        return isSigned;
    }//end getIsSigned method

    /**
     * onBinStringUpdate Method
     *
     * @throws NumberOutOfModeBoundsException when BaseConverter throws NumberOutOfModeBoundsException
     */
    private void onBinStringUpdate() throws NumberOutOfModeBoundsException {
        if (this.binString.length() == 0) {
            this.clearValues();
        } else {
            this.binString = truncateLeadingZeros(this.binString);
            this.octString = truncateLeadingZeros(baseConverter.convertBase2toBase8(this.binString, bitPrecision, isSigned));
            this.decString = truncateLeadingZeros(baseConverter.convertBase2toBase10(this.binString, bitPrecision, isSigned));
            this.hexString = truncateLeadingZeros(baseConverter.convertBase2toBase16(this.binString, bitPrecision, isSigned));
        }
    }//end onBinStringUpdate method

    /**
     * onOctStringUpdate Method
     *
     * @throws NumberOutOfModeBoundsException when BaseConverter throws NumberOutOfModeBoundsException
     */
    private void onOctStringUpdate() throws NumberOutOfModeBoundsException {
        if (this.octString.length() == 0) {
            this.clearValues();
        } else {
            this.octString = truncateLeadingZeros(this.octString);
            this.binString = truncateLeadingZeros(baseConverter.convertBase8toBase2(this.octString, bitPrecision, isSigned));
            this.decString = truncateLeadingZeros(baseConverter.convertBase2toBase10(this.binString, bitPrecision, isSigned));
            this.hexString = truncateLeadingZeros(baseConverter.convertBase2toBase16(this.binString, bitPrecision, isSigned));
        }
    }//end onOctStringUpdate method

    /**
     * onDecStringUpdate Method
     *
     * @throws NumberOutOfModeBoundsException when BaseConverter throws NumberOutOfModeBoundsException
     */
    private void onDecStringUpdate() throws NumberOutOfModeBoundsException {
        if (this.decString.length() == 0) {
            this.clearValues();
        } else {
            this.decString = truncateLeadingZeros(this.decString);
            this.binString = truncateLeadingZeros(baseConverter.convertBase10toBase2(this.decString, bitPrecision, isSigned));
            this.octString = truncateLeadingZeros(baseConverter.convertBase2toBase8(this.binString, bitPrecision, isSigned));
            this.hexString = truncateLeadingZeros(baseConverter.convertBase2toBase16(this.binString, bitPrecision, isSigned));
        }
    }//end onDecStringUpdate method

    /**
     * onHexStringUpdate Method
     *
     * @throws NumberOutOfModeBoundsException when BaseConverter throws NumberOutOfModeBoundsException
     */
    private void onHexStringUpdate() throws NumberOutOfModeBoundsException {
        if (this.hexString.length() == 0) {
            this.clearValues();
        } else {
            this.hexString = truncateLeadingZeros(this.hexString);
            this.binString = truncateLeadingZeros(baseConverter.convertBase16toBase2(this.hexString, bitPrecision, isSigned));
            this.octString = truncateLeadingZeros(baseConverter.convertBase2toBase8(this.binString, bitPrecision, isSigned));
            this.decString = truncateLeadingZeros(baseConverter.convertBase2toBase10(this.binString, bitPrecision, isSigned));
        }
    }//end onHexStringUpdate method

    /**
     * setBinValue Method
     *
     * @param binValue - a base 2 number string representing some value x
     * @throws NumberOutOfModeBoundsException when BaseConverter throws NumberOutOfModeBoundsException
     */
    public void setBinValue(String binValue) throws NumberOutOfModeBoundsException {
        this.binString = binValue;
        this.onBinStringUpdate(); //efficient code reuse
    }//end setBinValue method

    /**
     * setOctValue Method
     *
     * @param octValue - a base 8 number string representing some value x
     * @throws NumberOutOfModeBoundsException when BaseConverter throws NumberOutOfModeBoundsException
     */
    public void setOctValue(String octValue) throws NumberOutOfModeBoundsException {
        this.octString = octValue;
        this.onOctStringUpdate(); //efficient code reuse
    }//end setOctValue method

    /**
     * setDecValue Method
     *
     * @param decValue - a base 10 number string representing some value x
     * @throws NumberOutOfModeBoundsException when BaseConverter throws NumberOutOfModeBoundsException
     */
    public void setDecValue(String decValue) throws NumberOutOfModeBoundsException {
        this.decString = decValue;
        this.onDecStringUpdate(); //efficient code reuse
    }//end setDecValue method

    /**
     * setHexValue Method
     *
     * @param hexValue - a base 16 number string representing some value x
     * @throws NumberOutOfModeBoundsException when BaseConverter throws NumberOutOfModeBoundsException
     */
    public void setHexValue(String hexValue) throws NumberOutOfModeBoundsException {
        this.hexString = hexValue;
        this.onHexStringUpdate(); //efficient code reuse
    }//end setHexValue method

    /**
     * truncateLeadingZeros Method - removes any leading zeros from a string. Written by Dakota Tebbe (credit where credit is due,
     * because I would have never figured this out - Drew)
     *
     * @param string - a string with zeros in it... probably
     * @return the string without any zeros
     */
    private String truncateLeadingZeros(String string) {
        return string.replaceFirst("^0+(?!$)", "");
    }//end truncateLeadingZeros method

    /**
     * updateState Method - updates the internal state of all Pr0Number objects (you should call clearValues() after)
     *
     * @param newBitState  - the new bitPrecision int value
     * @param newSignState - the new isSigned boolean value
     */
    public static void updateState(int newBitState, boolean newSignState) {
        bitPrecision = newBitState;
        isSigned = newSignState;
    }//end updateState method

}//end Pr0Number class
