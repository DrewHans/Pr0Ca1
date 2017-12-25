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
     * @param binValue
     * @throws NumberOutOfModeBoundsException
     */
    public void appendBinValue(String binValue) throws NumberOutOfModeBoundsException {
        this.binString = this.binString + binValue;
        this.onBinStringUpdate(); //efficient code reuse
    }//end appendBinValue method

    /**
     * appendOctValue Method
     *
     * @param octValue
     * @throws NumberOutOfModeBoundsException
     */
    public void appendOctValue(String octValue) throws NumberOutOfModeBoundsException {
        this.octString = this.octString + octValue;
        this.onOctStringUpdate(); //efficient code reuse
    }//end appendOctValue method

    /**
     * appendDecValue Method
     *
     * @param decValue
     * @throws NumberOutOfModeBoundsException
     */
    public void appendDecValue(String decValue) throws NumberOutOfModeBoundsException {
        this.decString = this.decString + decValue;
        this.onDecStringUpdate(); //efficient code reuse
    }//end appendDecValue method

    /**
     * appendHexValue Method
     *
     * @param hexValue
     * @throws NumberOutOfModeBoundsException
     */
    public void appendHexValue(String hexValue) throws NumberOutOfModeBoundsException {
        this.hexString = this.hexString + hexValue;
        this.onHexStringUpdate(); //efficient code reuse
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
     * deappendBinValue Method
     *
     * @throws NumberOutOfModeBoundsException
     */
    public void deappendBinValue() throws NumberOutOfModeBoundsException {
        if (this.octString.length() != 0) {
            this.binString = this.binString.substring(0, this.binString.length() - 1);
            this.onBinStringUpdate(); //efficient code reuse
        }
    }//end appendBinValue method

    /**
     * deappendOctValue Method
     *
     * @throws NumberOutOfModeBoundsException
     */
    public void deappendOctValue() throws NumberOutOfModeBoundsException {
        if (this.octString.length() != 0) {
            this.octString = this.octString.substring(0, this.octString.length() - 1);
            this.onOctStringUpdate(); //efficient code reuse
        }
    }//end appendOctValue method

    /**
     * deappendDecValue Method
     *
     * @throws NumberOutOfModeBoundsException
     */
    public void deappendDecValue() throws NumberOutOfModeBoundsException {
        if (this.decString.length() != 0) {
            this.decString = this.decString.substring(0, this.decString.length() - 1);
            this.onDecStringUpdate(); //efficient code reuse
        }
    }//end appendDecValue method

    /**
     * deappendHexValue Method
     *
     * @throws NumberOutOfModeBoundsException
     */
    public void deappendHexValue() throws NumberOutOfModeBoundsException {
        if (this.hexString.length() != 0) {
            this.hexString = this.hexString.substring(0, this.hexString.length() - 1);
            this.onHexStringUpdate(); //efficient code reuse
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
     * onBinStringUpdate Method
     */
    private void onBinStringUpdate() throws NumberOutOfModeBoundsException {
        this.binString = truncZero(this.binString);
        this.octString = truncZero(baseConverter.convertBase2toBase8(this.binString, bitPrecision, isSigned));
        this.decString = truncZero(baseConverter.convertBase2toBase10(this.binString, bitPrecision, isSigned));
        this.hexString = truncZero(baseConverter.convertBase2toBase16(this.binString, bitPrecision, isSigned));
    }//end onBinStringUpdate method

    /**
     * onOctStringUpdate Method
     */
    private void onOctStringUpdate() throws NumberOutOfModeBoundsException {
        this.octString = truncZero(this.octString);
        this.binString = truncZero(baseConverter.convertBase8toBase2(this.octString, bitPrecision, isSigned));
        this.decString = truncZero(baseConverter.convertBase8toBase10(this.octString, bitPrecision, isSigned));
        this.hexString = truncZero(baseConverter.convertBase8toBase16(this.octString, bitPrecision, isSigned));
    }//end onOctStringUpdate method

    /**
     * onDecStringUpdate Method
     */
    private void onDecStringUpdate() throws NumberOutOfModeBoundsException {
        this.decString = truncZero(this.decString);
        this.binString = truncZero(baseConverter.convertBase10toBase2(this.decString, bitPrecision, isSigned));
        this.octString = truncZero(baseConverter.convertBase10toBase8(this.decString, bitPrecision, isSigned));
        this.hexString = truncZero(baseConverter.convertBase10toBase16(this.decString, bitPrecision, isSigned));
    }//end onDecStringUpdate method

    /**
     * onHexStringUpdate Method
     */
    private void onHexStringUpdate() throws NumberOutOfModeBoundsException {
        this.hexString = truncZero(this.hexString);
        this.binString = truncZero(baseConverter.convertBase16toBase2(this.hexString, bitPrecision, isSigned));
        this.octString = truncZero(baseConverter.convertBase16toBase8(this.hexString, bitPrecision, isSigned));
        this.decString = truncZero(baseConverter.convertBase16toBase10(this.hexString, bitPrecision, isSigned));
    }//end onHexStringUpdate method

    /**
     * setBinValue Method
     *
     * @param binValue
     * @throws NumberOutOfModeBoundsException
     */
    public void setBinValue(String binValue) throws NumberOutOfModeBoundsException {
        this.binString = "";
        this.appendBinValue(binValue); //efficient code reuse
    }//end setBinValue method

    /**
     * setOctValue Method
     *
     * @param octValue
     * @throws NumberOutOfModeBoundsException
     */
    public void setOctValue(String octValue) throws NumberOutOfModeBoundsException {
        this.octString = "";
        this.appendOctValue(octValue); //efficient code reuse
    }//end setOctValue method

    /**
     * setDecValue Method
     *
     * @param decValue
     * @throws NumberOutOfModeBoundsException
     */
    public void setDecValue(String decValue) throws NumberOutOfModeBoundsException {
        this.decString = "";
        this.appendDecValue(decValue); //efficient code reuse
    }//end setDecValue method

    /**
     * setHexValue Method
     *
     * @param hexValue
     * @throws NumberOutOfModeBoundsException
     */
    public void setHexValue(String hexValue) throws NumberOutOfModeBoundsException {
        this.hexString = "";
        this.appendHexValue(hexValue); //efficient code reuse
    }//end setHexValue method

    /**
     * truncZero Method - removes any leading zeros from a string. Written by Dakota Tebbe (credit where credit is due,
     * because I would have never figured this out - Drew)
     *
     * @param string - a string with zeros in it... probably
     * @return the string without any zeros
     */
    private String truncZero(String string) {
        return string.replaceFirst("^0+(?!$)", "");
    }//end truncZero method

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
