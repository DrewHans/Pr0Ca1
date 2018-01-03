package io.github.drewhans555.pr0ca1;

/**
 * BaseConverter Class - Creates a BaseConverter object that can perform number base conversions between base 2, base 8,
 * base 10, and base 16 numbers. Formerly part of the [Super] Model(s) Class.
 *
 * @author Jessica Cramer(https://github.com/JessicaCramer117)
 * @author Hannah Goett(https://github.com/hannahgoett)
 * @author Drew Hans(https://github.com/DrewHans555)
 * @author Ashley Holcomb(https://github.com/ashleyholcomb)
 * @author Braydon Rekart(https://github.com/BRekart)
 */
public class BaseConverter {

    /**
     * BaseConverter Constructor
     */
    public BaseConverter() {

    }//end BaseConverter constructor

    /**
     * convertBase2toBase8 Method
     *
     * @param binString    - assume a String of 1s and 0s with length bitPrecision or less
     * @param bitPrecision - any bit precision in range 5 - 32 will work for both signed/unsigned
     * @param signed       - a boolean that indicates two's compliment conversion
     * @return a string base8 representation of binString or an error message
     * @throws NumberOutOfModeBoundsException when binString input exceeds bitPrecision
     */
    public String convertBase2toBase8(String binString, int bitPrecision, boolean signed) throws NumberOutOfModeBoundsException {
        String buffer = "";

        // check that binString is not empty and does not exceed our bitPrecision
        if (binString.isEmpty()) {
            buffer = "";
        } else if (this.binStringIsWithinBounds(binString, bitPrecision)) {
            // initialize variables for the for-loop
            String temp = "";
            char[] bits = binString.toCharArray();

            // substitute every 3 bits with their octal value (from right to left)
            for (int i = bits.length - 1; i > -1; i--) {
                temp = bits[i] + temp; // prefix next bit to temp

                if (temp.equalsIgnoreCase("111")) {
                    buffer = "7" + buffer; // prefix 7
                    temp = ""; // clear temp
                } else if (temp.equalsIgnoreCase("110")) {
                    buffer = "6" + buffer; // prefix 6
                    temp = ""; // clear temp
                } else if (temp.equalsIgnoreCase("101")) {
                    buffer = "5" + buffer; // prefix 5
                    temp = ""; // clear temp
                } else if (temp.equalsIgnoreCase("100")) {
                    buffer = "4" + buffer; // prefix 4
                    temp = ""; // clear temp
                } else if (temp.equalsIgnoreCase("011")) {
                    buffer = "3" + buffer; // prefix 3
                    temp = ""; // clear temp
                } else if (temp.equalsIgnoreCase("010")) {
                    buffer = "2" + buffer; // prefix 2
                    temp = ""; // clear temp
                } else if (temp.equalsIgnoreCase("001")) {
                    buffer = "1" + buffer; // prefix 1
                    temp = ""; // clear temp
                } else if (temp.equalsIgnoreCase("000")) {
                    buffer = "0" + buffer; // prefix 0
                    temp = ""; // clear temp
                }
            }//end for loop

            // substitute any remaining bits with their octal value
            if (temp.equalsIgnoreCase("11")) {
                buffer = "3" + buffer; // prefix 3
            } else if (temp.equalsIgnoreCase("10")) {
                buffer = "2" + buffer; // prefix 2
            } else if (temp.equalsIgnoreCase("01") || temp.equalsIgnoreCase("1")) {
                buffer = "1" + buffer; // prefix 1
            } else if (temp.equalsIgnoreCase("00") || temp.equalsIgnoreCase("0")) {
                buffer = "0" + buffer; // prefix 0
            }
        } else {
            throw new NumberOutOfModeBoundsException("binString input exceeds bitPrecision!");
        }//end if else statement

        return buffer;
    }//end convertBase2toBase8

    /**
     * convertBase2toBase10 Method
     *
     * @param binString    - assume a String of 1s and 0s with length bitPrecision or less
     * @param bitPrecision - any bit precision in range 5 - 32 will work for both signed/unsigned
     * @param signed       - a boolean that indicates two's compliment conversion
     * @return a string base10 representation of binString or an error message
     * @throws NumberOutOfModeBoundsException when binString input exceeds bitPrecision
     */
    public String convertBase2toBase10(String binString, int bitPrecision, boolean signed) throws NumberOutOfModeBoundsException {
        String buffer;
        long temp;

        // check that binString is not empty and does not exceed our bitPrecision
        if (binString.isEmpty()) {
            buffer = "";
        } else if (this.binStringIsWithinBounds(binString, bitPrecision)) {
            // pad with zeros when necessary (assume user forgot to input zeros for positive signed value)
            binString = String.format("%" + bitPrecision + "s", binString).replace(' ', '0');

            if (signed && binString.charAt(0) == '1') {
                // if negative signed
                binString = flipBits(binString); // flip bits
                temp = unsignedBinaryStringToPositiveDecimalInt(binString); // get positive base 10 value
                temp = temp + 1; // add one
                temp = temp * (-1); // get the negative
                buffer = Long.toString(temp); // stuff the base 10 value into buffer
            } else {
                // if positive signed or unsigned
                temp = unsignedBinaryStringToPositiveDecimalInt(binString);  // get positive base 10 value
                buffer = Long.toString(temp); // stuff the base 10 value into buffer
            }
        } else {
            throw new NumberOutOfModeBoundsException("binString input exceeds bitPrecision!");
        }//end if else statement

        return buffer;
    }//end convertBase2toBase10

    /**
     * convertBase2toBase16 Method
     *
     * @param binString    - assume a String of 1s and 0s with length bitPrecision or less
     * @param bitPrecision - any bit precision in range 5 - 32 will work for both signed/unsigned
     * @param signed       - a boolean that indicates two's compliment conversion
     * @return a string base16 representation of binString or an error message
     * @throws NumberOutOfModeBoundsException when binString input exceeds bitPrecision
     */
    public String convertBase2toBase16(String binString, int bitPrecision, boolean signed) throws NumberOutOfModeBoundsException {
        String buffer = "";

        // check that binString is not empty and does not exceed our bitPrecision
        if (binString.isEmpty()) {
            buffer = "";
        } else if (this.binStringIsWithinBounds(binString, bitPrecision)) {
            // initialize variables for the for-loop
            String temp = "";
            char[] bits = binString.toCharArray();

            // substitute every 4 bits with their hexadecimal value
            for (int i = bits.length - 1; i > -1; i--) {
                temp = bits[i] + temp; // prefix next bit to temp

                if (temp.equalsIgnoreCase("1111")) {
                    buffer = "F" + buffer; // prefix F
                    temp = ""; // clear temp
                } else if (temp.equalsIgnoreCase("1110")) {
                    buffer = "E" + buffer; // prefix E
                    temp = ""; // clear temp
                } else if (temp.equalsIgnoreCase("1101")) {
                    buffer = "D" + buffer; // prefix D
                    temp = ""; // clear temp
                } else if (temp.equalsIgnoreCase("1100")) {
                    buffer = "C" + buffer; // prefix C
                    temp = ""; // clear temp
                } else if (temp.equalsIgnoreCase("1011")) {
                    buffer = "B" + buffer; // prefix B
                    temp = ""; // clear temp
                } else if (temp.equalsIgnoreCase("1010")) {
                    buffer = "A" + buffer; // prefix A
                    temp = ""; // clear temp
                } else if (temp.equalsIgnoreCase("1001")) {
                    buffer = "9" + buffer; // prefix 9
                    temp = ""; // clear temp
                } else if (temp.equalsIgnoreCase("1000")) {
                    buffer = "8" + buffer; // prefix 8
                    temp = ""; // clear temp
                } else if (temp.equalsIgnoreCase("0111")) {
                    buffer = "7" + buffer; // prefix 7
                    temp = ""; // clear temp
                } else if (temp.equalsIgnoreCase("0110")) {
                    buffer = "6" + buffer; // prefix 6
                    temp = ""; // clear temp
                } else if (temp.equalsIgnoreCase("0101")) {
                    buffer = "5" + buffer; // prefix 5
                    temp = ""; // clear temp
                } else if (temp.equalsIgnoreCase("0100")) {
                    buffer = "4" + buffer; // prefix 4
                    temp = ""; // clear temp
                } else if (temp.equalsIgnoreCase("0011")) {
                    buffer = "3" + buffer; // prefix 3
                    temp = ""; // clear temp
                } else if (temp.equalsIgnoreCase("0010")) {
                    buffer = "2" + buffer; // prefix 2
                    temp = ""; // clear temp
                } else if (temp.equalsIgnoreCase("0001")) {
                    buffer = "1" + buffer; // prefix 1
                    temp = ""; // clear temp
                } else if (temp.equalsIgnoreCase("0000")) {
                    buffer = "0" + buffer; // prefix 0
                    temp = ""; // clear temp
                }
            }//end for loop

            // substitute any remaining bits with their hexadecimal value
            if (temp.equalsIgnoreCase("111")) {
                buffer = "7" + buffer; // prefix 7
            } else if (temp.equalsIgnoreCase("110")) {
                buffer = "6" + buffer; // prefix 6
            } else if (temp.equalsIgnoreCase("101")) {
                buffer = "5" + buffer; // prefix 5
            } else if (temp.equalsIgnoreCase("100")) {
                buffer = "4" + buffer; // prefix 4
            } else if (temp.equalsIgnoreCase("011") || temp.equalsIgnoreCase("11")) {
                buffer = "3" + buffer; // prefix 3
            } else if (temp.equalsIgnoreCase("010") || temp.equalsIgnoreCase("10")) {
                buffer = "2" + buffer; // prefix 2
            } else if (temp.equalsIgnoreCase("001") || temp.equalsIgnoreCase("01") || temp.equalsIgnoreCase("1")) {
                buffer = "1" + buffer; // prefix 1
            } else if (temp.equalsIgnoreCase("000") || temp.equalsIgnoreCase("00") || temp.equalsIgnoreCase("0")) {
                buffer = "0" + buffer; // prefix 0
            }
        } else {
            throw new NumberOutOfModeBoundsException("binString input exceeds bitPrecision!");
        }//end if else statement

        return buffer;
    }//end convertBase2toBase16

    ////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////// convertBase8toBase* Methods /////////////////////////////////

    /**
     * convertBase8toBase2 Method
     *
     * @param octString    - assume a String of octal values with bit length of bitPrecision or less
     * @param bitPrecision - any bit precision in range 5 - 32 will work for both signed/unsigned
     * @param signed       - a boolean that indicates two's compliment conversion
     * @return a string base2 representation of octString or an error message
     * @throws NumberOutOfModeBoundsException when octString input exceeds bitPrecision
     */
    public String convertBase8toBase2(String octString, int bitPrecision, boolean signed) throws NumberOutOfModeBoundsException {
        String buffer = "";

        // check that octString is not empty and does not exceed our base2 bitPrecision
        if (octString.isEmpty()) {
            buffer = "";
        } else if (this.octStringIsWithinBounds(octString, bitPrecision)) {
            // initialize variable for the for-loop
            char[] bits = octString.toCharArray();

            // substitute every hexadecimal value with the appropriate binary value
            for (int i = 0; i < bits.length; i++) {

                if (bits[i] == '7') {
                    buffer = buffer + "111"; // append 111
                } else if (bits[i] == '6') {
                    buffer = buffer + "110"; // append 110
                } else if (bits[i] == '5') {
                    buffer = buffer + "101"; // append 101
                } else if (bits[i] == '4') {
                    buffer = buffer + "100"; // append 100
                } else if (bits[i] == '3') {
                    if (i == 0) {
                        buffer = buffer + "11"; // append 11
                    } else {
                        buffer = buffer + "011"; // append 011
                    }
                } else if (bits[i] == '2') {
                    if (i == 0) {
                        buffer = buffer + "10"; // append 10
                    } else {
                        buffer = buffer + "010"; // append 010
                    }
                } else if (bits[i] == '1') {
                    if (i == 0) {
                        buffer = buffer + "1"; // append 1
                    } else {
                        buffer = buffer + "001"; // append 001
                    }
                } else if (bits[i] == '0') {
                    if (i == 0) {
                        buffer = buffer + "0"; // append 0
                    } else {
                        buffer = buffer + "000"; // append 000
                    }
                }//end if else statement
            }//end for loop

        } else {
            throw new NumberOutOfModeBoundsException("octString input exceeds bitPrecision!");
        }//end if else statement

        return buffer;
    }//end convertBase8toBase2

    /**
     * convertBase8toBase10 Method
     *
     * @param octString    - assume a String of octal values with bit length of bitPrecision or less
     * @param bitPrecision - any bit precision in range 5 - 32 will work for both signed/unsigned
     * @param signed       - a boolean that indicates two's compliment conversion
     * @return a string base10 representation of octString or an error message
     * @throws NumberOutOfModeBoundsException when octString input exceeds bitPrecision
     */
    public String convertBase8toBase10(String octString, int bitPrecision, boolean signed) throws NumberOutOfModeBoundsException {
        String binString = convertBase8toBase2(octString, bitPrecision, signed); // throws exception on failure
        return convertBase2toBase10(binString, bitPrecision, signed); // throws exception on failure
    }//end convertBase8toBase10

    /**
     * convertBase8toBase10 Method
     *
     * @param octString    - assume a String of octal values with bit length of bitPrecision or less
     * @param bitPrecision - any bit precision in range 5 - 32 will work for both signed/unsigned
     * @param signed       - a boolean that indicates two's compliment conversion
     * @return a string base16 representation of octString or an error message
     * @throws NumberOutOfModeBoundsException when octString input exceeds bitPrecision
     */
    public String convertBase8toBase16(String octString, int bitPrecision, boolean signed) throws NumberOutOfModeBoundsException {
        String binString = convertBase8toBase2(octString, bitPrecision, signed); // throws exception on failure
        return convertBase2toBase16(binString, bitPrecision, signed); // throws exception on failure
    }//end convertBase8toBase16

    ////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////// convertBase10toBase* Methods /////////////////////////////////

    /**
     * convertBase8toBase2 Method
     *
     * @param decString    - assume a standard 32-bit integer decimal number
     * @param bitPrecision - any bit precision in range 5 - 32 will work for both signed/unsigned
     * @param signed       - a boolean that indicates two's compliment conversion
     * @return a string base2 representation of decInteger or an error message
     * @throws NumberOutOfModeBoundsException when decString input exceeds bitPrecision or Long.parseLong throws NumberFormatException
     */
    public String convertBase10toBase2(String decString, int bitPrecision, boolean signed) throws NumberOutOfModeBoundsException {
        String buffer;

        // check that decString is not empty and does not exceed our base2 bitPrecision
        if (decString.isEmpty()) {
            buffer = "";
        } else if (decStringIsWithinBounds(decString, bitPrecision, signed)) {
            long decValue;
            try {
                decValue = Long.parseLong(decString);
            } catch (NumberFormatException nfe) {
                throw new NumberOutOfModeBoundsException("Long.parseLong(decString) threw NumberFormatException in convertBase10toBase2 method!");
            }
            if (decValue < 0) {
                decValue = decValue * (-1);
                decValue = decValue - 1;
                buffer = positiveDecimalIntToUnsignedBinaryString(decValue);
                buffer = flipBits(buffer);

                // pad the signed value with ones up to bitPrecision
                buffer = String.format("%" + bitPrecision + "s", buffer).replace(' ', '1');
            } else {
                // get the unsigned value
                buffer = positiveDecimalIntToUnsignedBinaryString(decValue);
            }
        } else {
            throw new NumberOutOfModeBoundsException("decInteger input exceeds bitPrecision!");
        }//end if else statement

        return buffer;
    }//end convertBase10toBase2 method

    /**
     * convertBase10toBase8 Method
     *
     * @param decInteger   - assume a standard 32-bit integer decimal number in String form
     * @param bitPrecision - any bit precision in range 5 - 32 will work for both signed/unsigned
     * @param signed       - a boolean that indicates two's compliment conversion
     * @return a string base8 representation of decInteger or an error message
     * @throws NumberOutOfModeBoundsException when decString input exceeds bitPrecision or Long.parseLong throws NumberFormatException
     */
    public String convertBase10toBase8(String decInteger, int bitPrecision, boolean signed) throws NumberOutOfModeBoundsException {
        String binString = convertBase10toBase2(decInteger, bitPrecision, signed); // throws exception on failure
        return convertBase2toBase8(binString, bitPrecision, signed); // throws exception on failure
    }//end convertBase10toBase8 method

    /**
     * convertBase10toBase16 Method
     *
     * @param decInteger   - assume a standard 32-bit integer decimal number in String form
     * @param bitPrecision - any bit precision in range 5 - 32 will work for both signed/unsigned
     * @param signed       - a boolean that indicates two's compliment conversion
     * @return a string base16 representation of decInteger or an error message
     * @throws NumberOutOfModeBoundsException when decString input exceeds bitPrecision or Long.parseLong throws NumberFormatException
     */
    public String convertBase10toBase16(String decInteger, int bitPrecision, boolean signed) throws NumberOutOfModeBoundsException {
        String binString = convertBase10toBase2(decInteger, bitPrecision, signed); // throws exception on failure
        return convertBase2toBase16(binString, bitPrecision, signed); // throws exception on failure
    }//end convertBase10toBase16 method

    ////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////// convertBase16toBase* Methods /////////////////////////////////

    /**
     * convertBase16toBase2 Method
     *
     * @param hexString    - assume a String of hexadecimal values with bit length of bitPrecision or less
     * @param bitPrecision - any bit precision in range 5 - 32 will work for both signed/unsigned
     * @param signed       - a boolean that indicates two's compliment conversion
     * @return a string base2 representation of hexString or an error message
     * @throws NumberOutOfModeBoundsException when hexString input exceeds bitPrecision
     */
    public String convertBase16toBase2(String hexString, int bitPrecision, boolean signed) throws NumberOutOfModeBoundsException {
        String buffer = "";

        // check that hexString is not empty and does not exceed our base2 bitPrecision
        if (hexString.isEmpty()) {
            buffer = "";
        } else if (this.hexStringIsWithinBounds(hexString, bitPrecision)) {
            // initialize variable for the for-loop
            char[] bits = hexString.toCharArray();

            // substitute every hexadecimal value with the appropriate binary value
            for (int i = 0; i < bits.length; i++) {

                if (bits[i] == 'F') {
                    buffer = buffer + "1111"; // append 1111
                } else if (bits[i] == 'E') {
                    buffer = buffer + "1110"; // append 1110
                } else if (bits[i] == 'D') {
                    buffer = buffer + "1101"; // append 1101
                } else if (bits[i] == 'C') {
                    buffer = buffer + "1100"; // append 1100
                } else if (bits[i] == 'B') {
                    buffer = buffer + "1011"; // append 1011
                } else if (bits[i] == 'A') {
                    buffer = buffer + "1010"; // append 1010
                } else if (bits[i] == '9') {
                    buffer = buffer + "1001"; // append 1001
                } else if (bits[i] == '8') {
                    buffer = buffer + "1000"; // append 1000
                } else if (bits[i] == '7') {
                    if (i == 0) {
                        buffer = buffer + "111"; // append 111
                    } else {
                        buffer = buffer + "0111"; // append 0111
                    }
                } else if (bits[i] == '6') {
                    if (i == 0) {
                        buffer = buffer + "110"; // append 110
                    } else {
                        buffer = buffer + "0110"; // append 0110
                    }
                } else if (bits[i] == '5') {
                    if (i == 0) {
                        buffer = buffer + "101"; // append 101
                    } else {
                        buffer = buffer + "0101"; // append 0101
                    }
                } else if (bits[i] == '4') {
                    if (i == 0) {
                        buffer = buffer + "100"; // append 100
                    } else {
                        buffer = buffer + "0100"; // append 0100
                    }
                } else if (bits[i] == '3') {
                    if (i == 0) {
                        buffer = buffer + "11"; // append 11
                    } else {
                        buffer = buffer + "0011"; // append 0011
                    }
                } else if (bits[i] == '2') {
                    if (i == 0) {
                        buffer = buffer + "10"; // append 10
                    } else {
                        buffer = buffer + "0010"; // append 0010
                    }
                } else if (bits[i] == '1') {
                    if (i == 0) {
                        buffer = buffer + "1"; // append 1
                    } else {
                        buffer = buffer + "0001"; // append 0001
                    }
                } else if (bits[i] == '0') {
                    if (i == 0) {
                        buffer = buffer + "0"; // append 0
                    } else {
                        buffer = buffer + "0000"; // append 0000
                    }
                }//end if else statement
            }//end for loop

        } else {
            throw new NumberOutOfModeBoundsException("hexString input exceeds bitPrecision!");
        }//end if else statement

        return buffer;
    }//end convertBase16toBase2

    /**
     * convertBase16toBase8 Method
     *
     * @param hexString    - assume a String of hexadecimal values with bit length of bitPrecision or less
     * @param bitPrecision - any bit precision in range 5 - 32 will work for both signed/unsigned
     * @param signed       - a boolean that indicates two's compliment conversion
     * @return a string base8 representation of hexString or an error message
     * @throws NumberOutOfModeBoundsException when hexString input exceeds bitPrecision
     */
    public String convertBase16toBase8(String hexString, int bitPrecision, boolean signed) throws NumberOutOfModeBoundsException {
        String binString = convertBase16toBase2(hexString, bitPrecision, signed); // throws exception on failure
        return convertBase2toBase8(binString, bitPrecision, signed); // throws exception on failure
    }//end convertBase16toBase8

    /**
     * convertBase16toBase8 Method
     *
     * @param hexString    - assume a String of hexadecimal values with bit length of bitPrecision or less
     * @param bitPrecision - any bit precision in range 5 - 32 will work for both signed/unsigned
     * @param signed       - a boolean that indicates two's compliment conversion
     * @return a string base8 representation of hexString or an error message
     * @throws NumberOutOfModeBoundsException when hexString input exceeds bitPrecision
     */
    public String convertBase16toBase10(String hexString, int bitPrecision, boolean signed) throws NumberOutOfModeBoundsException {
        String binString = convertBase16toBase2(hexString, bitPrecision, signed); // throws exception on failure
        return convertBase2toBase10(binString, bitPrecision, signed); // throws exception on failure
    }//end convertBase16toBase10

    ////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////// Helper Methods ////////////////////////////////////////

    /**
     * binStringIsWithinBounds Method
     *
     * @param binString    - a string of 1s and 0s representing a base 2 number
     * @param bitPrecision - the number of binary bits we have to represent binString
     * @return true if binString is within our bitPrecision bounds
     */
    private boolean binStringIsWithinBounds(String binString, int bitPrecision) {
        return binString.length() <= bitPrecision;
    }//end binStringIsWithinBounds method

    /**
     * octStringIsWithinBounds Method
     *
     * @param octString    - a string base 8 number
     * @param bitPrecision - the number of binary bits we have to represent octString
     * @return true if octString is within our bitPrecision bounds
     */
    private boolean octStringIsWithinBounds(String octString, int bitPrecision) {
        String legal2BitOct = "23";
        String legal1BitOct = "01";
        int octStringBits = (octString.length() * 3); // assume each octal value uses all three bits
        if (legal2BitOct.contains(String.valueOf(octString.charAt(0)))) {
            octStringBits = octStringBits - 1; // the leftmost bit is unused so we ignore it
        } else if (legal1BitOct.contains(String.valueOf(octString.charAt(0)))) {
            octStringBits = octStringBits - 2; // the two leftmost bits are unused so we ignore them
        }
        return octStringBits <= bitPrecision;
    }//end octStringIsWithinBounds method

    /**
     * decStringIsWithinBounds Method
     *
     * @param decString    - a string base 10 number
     * @param bitPrecision - the number of binary bits we have to represent decString
     * @param signed       - true if we want the binary representation to be signed
     * @return true if decString is within upper and lower bounds (inclusive)
     */
    private boolean decStringIsWithinBounds(String decString, int bitPrecision, boolean signed) throws NumberOutOfModeBoundsException {
        long decValue;
        try {
            decValue = Long.parseLong(decString);
        } catch (NumberFormatException nfe) {
            throw new NumberOutOfModeBoundsException("Long.parseLong(decString) threw NumberFormatException in decStringIsWithinBounds method!");
        }
        //store upper and lower bounds as 64 bit numbers to avoid overflow
        long upperBound;
        long lowerBound;
        if (signed) {
            upperBound = (long) (Math.pow(2, bitPrecision - 1) - 1);
            lowerBound = (long) (Math.pow(2, bitPrecision - 1) * -1);
        } else {
            upperBound = (long) (Math.pow(2, bitPrecision) - 1);
            lowerBound = 0;
        }
        return (decValue <= upperBound) && (decValue >= lowerBound);
    }//end decStringIsWithinBounds method

    /**
     * hexStringIsWithinBounds Method
     *
     * @param hexString    - a string base 16 number
     * @param bitPrecision - the number of binary bits we have to represent hexString
     * @return true if hexString is within our bitPrecision bounds
     */
    private boolean hexStringIsWithinBounds(String hexString, int bitPrecision) {
        String legal3BitHex = "4567";
        String legal2BitHex = "23";
        String legal1BitHex = "01";
        int hexStringBits = (hexString.length() * 4); // assume each hexadecimal value uses all four bits
        if (legal3BitHex.contains(String.valueOf(hexString.charAt(0)))) {
            hexStringBits = hexStringBits - 1; // the leftmost bit is unused so we ignore it
        } else if (legal2BitHex.contains(String.valueOf(hexString.charAt(0)))) {
            hexStringBits = hexStringBits - 2; // the two leftmost bits are unused so we ignore them
        } else if (legal1BitHex.contains(String.valueOf(hexString.charAt(0)))) {
            hexStringBits = hexStringBits - 3; // the three leftmost bits are unused so we ignore them
        }
        return hexStringBits <= bitPrecision;
    }//end hexStringIsWithinBounds method

    /**
     * flipBits Method - Takes in a string of 1s and 0s and flips the bits
     *
     * @param binNum - assume a String of 1s and 0s
     * @return flipped bit version of binNum
     */
    private String flipBits(String binNum) {
        binNum = binNum.replace("0", "x"); // temporarily set 0s to xs
        binNum = binNum.replace("1", "0"); // set 1s to 0s
        binNum = binNum.replace("x", "1"); // set xs to 1s
        return binNum;
    }//end flipBits method

    /**
     * positiveDecimalIntToUnsignedBinaryString Method
     *
     * @param decValue - a decimal number
     * @return string binary representation of decValue
     */
    private String positiveDecimalIntToUnsignedBinaryString(long decValue) {
        String buffer = "";
        long remainder;

        if (decValue == 0) {
            buffer = "0";
        } else {
            while (decValue > 0) {
                remainder = decValue % 2;
                buffer = remainder + buffer;
                decValue = decValue / 2;
            }//end while loop
        }

        return buffer;
    }//end positiveDecimalIntToUnsignedBinaryString method

    /**
     * unsignedBinaryStringToPositiveDecimalInt Method
     *
     * @param binString - assume a String of 1s and 0s
     * @return int decimal representation of binString
     */
    private long unsignedBinaryStringToPositiveDecimalInt(String binString) {
        long temp = 0;
        char[] bits = binString.toCharArray();

        for (int i = 0; i < bits.length; i++) {
            if (bits[i] == '1') {
                temp = temp + (long) (Math.pow(2, bits.length - i - 1));
            }
        }
        return temp;
    }//end unsignedBinaryStringToPositiveDecimalInt method

}//end BaseConverter class
