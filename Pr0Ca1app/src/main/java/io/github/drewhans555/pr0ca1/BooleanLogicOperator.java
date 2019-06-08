package io.github.drewhans555.pr0ca1;

/**
 * BooleanLogicOperator Class - Creates a BooleanLogicOperator object that can perform not, and, or, xor, nand, nor, and
 * xnor operations using base 2 numbers.
 */
public class BooleanLogicOperator {

    public BooleanLogicOperator() {

    }

    /**
     * not Method - Takes in a string of 1s and 0s and flips the bits
     *
     * @param bitPrecision - the number of bits available for representing not-binString
     * @param binString    - assume a String of 1s and 0s
     * @return bitwise NOT of binString (after padding with 0s) as a String
     */
    public String not(int bitPrecision, String binString) {
        binString = String.format("%" + bitPrecision + "s", binString).replace(' ', '0'); //pad with zeros when necessary
        binString = binString.replace("0", "x"); // temporarily set 0s to xs
        binString = binString.replace("1", "0"); // set 1s to 0s
        binString = binString.replace("x", "1"); // set xs to 1s
        return binString;
    }

    /**
     * and Method - Takes in two binary numbers as Strings and returns the bitwise AND of input1 and input2 as a String
     *
     * @param input1 - first binary number
     * @param input2 - second binary number
     * @return bitwise AND of input1 and input2 as a String
     */
    public String and(String input1, String input2) {
        String largest = input2;
        String smallest = input1;
        if (input2.length() < smallest.length()) {
            largest = input1;
            smallest = input2;
        }

        //expand smallest to be same size as largest
        smallest = String.format("%" + largest.length() + "s", smallest).replace(" ", "0");

        String buffer = "";
        for (int i = 0; i < smallest.length(); i++) {
            if (largest.charAt(i) == '1' && smallest.charAt(i) == '1') {
                buffer = buffer + "1";
            } else {
                buffer = buffer + "0";
            }
        }
        return buffer;
    }

    /**
     * or Method - Takes in two binary numbers as Strings and returns the bitwise OR of input1 and input2 as a String
     *
     * @param input1 - first binary number
     * @param input2 - second binary number
     * @return bitwise OR of input1 and input2 as a String
     */
    public String or(String input1, String input2) {
        String largest = input2;
        String smallest = input1;
        if (input2.length() < smallest.length()) {
            largest = input1;
            smallest = input2;
        }

        //expand smallest to be same size as largest
        smallest = String.format("%" + largest.length() + "s", smallest).replace(" ", "0");

        String buffer = "";
        for (int i = 0; i < smallest.length(); i++) {
            if (largest.charAt(i) == '1' || smallest.charAt(i) == '1') {
                buffer = buffer + "1";
            } else {
                buffer = buffer + "0";
            }
        }
        return buffer;
    }

    /**
     * xor Method - Takes in two binary numbers as Strings and returns the bitwise XOR of input1 and input2 as a String
     *
     * @param input1 - first binary number
     * @param input2 - second binary number
     * @return bitwise XOR of input1 and input2 as a String
     */
    public String xor(String input1, String input2) {
        String largest = input2;
        String smallest = input1;
        if (input2.length() < smallest.length()) {
            largest = input1;
            smallest = input2;
        }

        //expand smallest to be same size as largest
        smallest = String.format("%" + largest.length() + "s", smallest).replace(" ", "0");

        String buffer = "";
        for (int i = 0; i < smallest.length(); i++) {
            if (largest.charAt(i) == '1' ^ smallest.charAt(i) == '1') {
                buffer = buffer + "1";
            } else {
                buffer = buffer + "0";
            }
        }
        return buffer;
    }

    /**
     * nand Method - Takes in two binary numbers as Strings and returns the bitwise NAND of input1 and input2 as a
     * String
     *
     * @param bitPrecision - the number of bits available for representing nand
     * @param input1       - first binary number
     * @param input2       - second binary number
     * @return bitwise NAND of input1 and input2 as a String
     */
    public String nand(int bitPrecision, String input1, String input2) {
        return this.not(bitPrecision, this.and(input1, input2));
    }

    /**
     * not Method - Takes in two binary numbers as Strings and returns the bitwise NOR of input1 and input2 as a String
     *
     * @param bitPrecision - the number of bits available for representing nor
     * @param input1       - first binary number
     * @param input2       - second binary number
     * @return bitwise NOR of input1 and input2 as a String
     */
    public String nor(int bitPrecision, String input1, String input2) {
        return this.not(bitPrecision, this.or(input1, input2));
    }

    /**
     * xnor Method - Takes in two binary numbers as Strings and returns the bitwise XNOR of input1 and input2 as a
     * String
     *
     * @param bitPrecision - the number of bits available for representing xnor
     * @param input1       - first binary number
     * @param input2       - second binary number
     * @return bitwise XNOR of input1 and input2 as a String
     */
    public String xnor(int bitPrecision, String input1, String input2) {
        return this.not(bitPrecision, this.xor(input1, input2));
    }

}
