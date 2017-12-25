package io.github.drewhans555.pr0ca1;

/**
 * ArithmeticOperator Class - Creates an ArithmeticOperator object that can perform addition, subtraction,
 * multiplication, division, and modulo operations using base 10 numbers. Formerly part of the [Super] Model(s) Class.
 *
 * @author Jessica Cramer(https://github.com/JessicaCramer117)
 * @author Hannah Goett(https://github.com/hannahgoett)
 * @author Drew Hans(https://github.com/DrewHans555)
 * @author Ashley Holcomb(https://github.com/ashleyholcomb)
 * @author Braydon Rekart(https://github.com/BRekart)
 */
public class ArithmeticOperator {

    /**
     * ArithmeticOperator Constructor
     */
    public ArithmeticOperator() {

    }//end ArithmeticOperator constructor

    /**
     * add Method - Takes in two decimal numbers as Strings and returns the sum as a String
     *
     * @param dec1 - first addend
     * @param dec2 - second addend
     * @return sum
     * @throws NumberFormatException on Long.parseLong error
     */
    public String add(String dec1, String dec2) throws NumberFormatException {
        long value = Long.parseLong(dec1) + Long.parseLong(dec2);
        return "" + (value);
    }//end add method

    /**
     * sub Method - Takes in two decimal numbers as Strings and returns the difference as a String
     *
     * @param dec1 - minuend
     * @param dec2 - subtrahend
     * @return difference
     * @throws NumberFormatException on Long.parseLong error
     */
    public String sub(String dec1, String dec2) throws NumberFormatException {
        long value = Long.parseLong(dec1) - Long.parseLong(dec2);
        return "" + (value);
    }//end sub method

    /**
     * mul Method - Takes in two decimal numbers as Strings and returns the product as a String
     *
     * @param dec1 - first factor
     * @param dec2 - second factor
     * @return product
     * @throws NumberFormatException on Long.parseLong error
     */
    public String mul(String dec1, String dec2) throws NumberFormatException {
        long value = Long.parseLong(dec1) * Long.parseLong(dec2);
        return "" + (value);
    }//end mul method

    /**
     * div Method - Takes in two decimal numbers as Strings and returns the truncated quotient as a String
     *
     * @param dec1 - dividend
     * @param dec2 - divisor
     * @return quotient
     * @throws NumberFormatException on Long.parseLong error
     */
    public String div(String dec1, String dec2) throws NumberFormatException {
        long value = Long.parseLong(dec1) / Long.parseLong(dec2);
        return "" + (value);
    }//end div method

    /**
     * mod Method - Takes in two decimal numbers as Strings and returns the remainder as a String
     *
     * @param dec1 - modulo dividend
     * @param dec2 - modulo divisor
     * @return remainder
     * @throws NumberFormatException on Long.parseLong error
     */
    public String mod(String dec1, String dec2) throws NumberFormatException {
        long value = Long.parseLong(dec1) % Long.parseLong(dec2);
        return "" + (value);
    }//end mod method

}//end ArithmeticOperator class
