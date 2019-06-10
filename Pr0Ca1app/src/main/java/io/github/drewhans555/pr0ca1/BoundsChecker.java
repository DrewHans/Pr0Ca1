package io.github.drewhans555.pr0ca1;

public class BoundsChecker implements IBoundsChecker {

    /**
     * binStringIsWithinBounds Method
     *
     * @param binString    - a string of 1s and 0s representing a base 2 number
     * @param bitPrecision - the number of binary bits we have to represent binString
     * @return true if binString is within our bitPrecision bounds
     */
    public boolean binStringIsWithinBounds(String binString, int bitPrecision) {
        return binString.length() <= bitPrecision;
    }

    /**
     * octStringIsWithinBounds Method
     *
     * @param octString    - a string base 8 number
     * @param bitPrecision - the number of binary bits we have to represent octString
     * @return true if octString is within our bitPrecision bounds
     */
    public boolean octStringIsWithinBounds(String octString, int bitPrecision) {
        if(octString.isEmpty()) {
            return true;
        }
        String legal2BitOct = "23";
        String legal1BitOct = "01";
        int octStringBits = (octString.length() * 3); // assume each octal value uses all three bits
        if (legal2BitOct.contains(String.valueOf(octString.charAt(0)))) {
            octStringBits = octStringBits - 1; // the leftmost bit is unused so we ignore it
        } else if (legal1BitOct.contains(String.valueOf(octString.charAt(0)))) {
            octStringBits = octStringBits - 2; // the two leftmost bits are unused so we ignore them
        }
        return octStringBits <= bitPrecision;
    }

    /**
     * decStringIsWithinBounds Method
     *
     * @param decString    - a string base 10 number
     * @param bitPrecision - the number of binary bits we have to represent decString
     * @param signed       - true if we want the binary representation to be signed
     * @return true if decString is within upper and lower bounds (inclusive)
     */
    public boolean decStringIsWithinBounds(String decString, int bitPrecision, boolean signed) throws NumberOutOfModeBoundsException {
        if(decString.isEmpty()) {
            return true;
        }
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
    }

    /**
     * hexStringIsWithinBounds Method
     *
     * @param hexString    - a string base 16 number
     * @param bitPrecision - the number of binary bits we have to represent hexString
     * @return true if hexString is within our bitPrecision bounds
     */
    public boolean hexStringIsWithinBounds(String hexString, int bitPrecision) {
        if(hexString.isEmpty()) {
            return true;
        }
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
    }
}
