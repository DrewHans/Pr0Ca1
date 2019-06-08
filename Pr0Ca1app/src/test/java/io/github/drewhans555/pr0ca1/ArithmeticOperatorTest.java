package io.github.drewhans555.pr0ca1;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArithmeticOperatorTest {
    @Test
    public void add() throws Exception {
        // test operator.add can handle full range of 32-bit Signed Integer values
        ArithmeticOperator operator = new ArithmeticOperator();

        // test numbers around zero
        assertEquals("-2", operator.add("-1", "-1"));
        assertEquals("-1", operator.add("0", "-1"));
        assertEquals("-1", operator.add("-1", "0"));
        assertEquals("0", operator.add("-1", "1"));
        assertEquals("0", operator.add("0", "0"));
        assertEquals("0", operator.add("1", "-1"));
        assertEquals("1", operator.add("0", "1"));
        assertEquals("1", operator.add("1", "0"));
        assertEquals("2", operator.add("1", "1"));

        // test numbers past 32-bit Signed Integer range [-2147483648, 2147483647]
        assertEquals("2147483648", operator.add("1", "2147483647"));
        assertEquals("2147483648", operator.add("2147483647", "1"));
        assertEquals("-2147483649", operator.add("-1", "-2147483648"));
        assertEquals("-2147483649", operator.add("-2147483648", "-1"));
    }

    @Test(expected = NumberFormatException.class)
    public void addNumberFormatExceptionTest1() {
        ArithmeticOperator operator = new ArithmeticOperator();
        operator.add("A", "1");
    }

    @Test(expected = NumberFormatException.class)
    public void addNumberFormatExceptionTest2() {
        ArithmeticOperator operator = new ArithmeticOperator();
        operator.add("1", "A");
    }

    @Test
    public void sub() throws Exception {
        // test operator.sub can handle full range of 32-bit Signed Integer values
        ArithmeticOperator operator = new ArithmeticOperator();

        // test numbers around zero
        assertEquals("-2", operator.sub("-1", "1"));
        assertEquals("-1", operator.sub("0", "1"));
        assertEquals("-1", operator.sub("-1", "0"));
        assertEquals("0", operator.sub("-1", "-1"));
        assertEquals("0", operator.sub("0", "0"));
        assertEquals("0", operator.sub("1", "1"));
        assertEquals("1", operator.sub("0", "-1"));
        assertEquals("1", operator.sub("1", "0"));
        assertEquals("2", operator.sub("1", "-1"));

        // test numbers past 32-bit Signed Integer range [-2147483648, 2147483647]
        assertEquals("2147483648", operator.sub("1", "-2147483647"));
        assertEquals("2147483648", operator.sub("2147483647", "-1"));
        assertEquals("-2147483649", operator.sub("-1", "2147483648"));
        assertEquals("-2147483649", operator.sub("-2147483648", "1"));
    }

    @Test(expected = NumberFormatException.class)
    public void subNumberFormatExceptionTest1() {
        ArithmeticOperator operator = new ArithmeticOperator();
        operator.sub("A", "1");
    }

    @Test(expected = NumberFormatException.class)
    public void subNumberFormatExceptionTest2() {
        ArithmeticOperator operator = new ArithmeticOperator();
        operator.sub("1", "A");
    }

    @Test
    public void mul() throws Exception {
        // test operator.mul can handle full range of 32-bit Signed Integer values
        ArithmeticOperator operator = new ArithmeticOperator();

        // test numbers around zero
        assertEquals("-2", operator.mul("2", "-1"));
        assertEquals("-2", operator.mul("-1", "2"));
        assertEquals("-1", operator.mul("1", "-1"));
        assertEquals("-1", operator.mul("-1", "1"));
        assertEquals("0", operator.mul("-1", "0"));
        assertEquals("0", operator.mul("0", "-1"));
        assertEquals("0", operator.mul("0", "0"));
        assertEquals("0", operator.mul("0", "1"));
        assertEquals("0", operator.mul("1", "0"));
        assertEquals("1", operator.mul("1", "1"));
        assertEquals("1", operator.mul("-1", "-1"));
        assertEquals("2", operator.mul("1", "2"));
        assertEquals("2", operator.mul("2", "1"));

        // test numbers past 32-bit Signed Integer range [-2147483648, 2147483647]
        assertEquals("2147483648", operator.mul("2", "1073741824"));
        assertEquals("2147483648", operator.mul("1073741824", "2"));
        assertEquals("-2147483650", operator.mul("2", "-1073741825"));
        assertEquals("-2147483650", operator.mul("-1073741825", "2"));
    }

    @Test(expected = NumberFormatException.class)
    public void mulNumberFormatExceptionTest1() {
        ArithmeticOperator operator = new ArithmeticOperator();
        operator.mul("A", "1");
    }

    @Test(expected = NumberFormatException.class)
    public void mulNumberFormatExceptionTest2() {
        ArithmeticOperator operator = new ArithmeticOperator();
        operator.mul("1", "A");
    }

    @Test
    public void div() throws Exception {
        // test operator.div can handle full range of 32-bit Signed Integer values
        ArithmeticOperator operator = new ArithmeticOperator();

        assertEquals("-2", operator.div("2", "-1"));
        assertEquals("-2", operator.div("-2", "1"));
        assertEquals("-1", operator.div("1", "-1"));
        assertEquals("-1", operator.div("-1", "1"));
        assertEquals("0", operator.div("0", "-1"));
        assertEquals("0", operator.div("0", "1"));
        assertEquals("1", operator.div("1", "1"));
        assertEquals("1", operator.div("-1", "-1"));
        assertEquals("2", operator.div("2", "1"));
        assertEquals("2", operator.div("-2", "-1"));

        // test numbers past 32-bit Signed Integer range [-2147483648, 2147483647]
        assertEquals("1073741824", operator.div("2147483648", "2"));
        assertEquals("1073741824", operator.div("-2147483648", "-2"));
        assertEquals("-1073741825", operator.div("2147483650", "-2"));
        assertEquals("-1073741825", operator.div("-2147483650", "2"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void divDivideByZeroTest() {
        ArithmeticOperator operator = new ArithmeticOperator();
        operator.div("10", "0");
    }

    @Test(expected = NumberFormatException.class)
    public void divNumberFormatExceptionTest1() {
        ArithmeticOperator operator = new ArithmeticOperator();
        operator.div("A", "1");
    }

    @Test(expected = NumberFormatException.class)
    public void divNumberFormatExceptionTest2() {
        ArithmeticOperator operator = new ArithmeticOperator();
        operator.div("1", "A");
    }

    @Test
    public void mod() throws Exception {
        // test operator.mod can handle full range of 32-bit Signed Integer values
        ArithmeticOperator operator = new ArithmeticOperator();

        assertEquals("-2", operator.mod("-10", "-8"));
        assertEquals("-2", operator.mod("-10", "8"));
        assertEquals("0", operator.mod("0", "2"));
        assertEquals("2", operator.mod("10", "-8"));
        assertEquals("2", operator.mod("10", "8"));
        assertEquals("-5", operator.mod("-5", "-10"));

        // test numbers past 32-bit Signed Integer range [-2147483648, 2147483647]
        assertEquals("0", operator.mod("2147483648", "2"));
        assertEquals("-1", operator.mod("-2147483649", "-2"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void modDivideByZeroTest() {
        ArithmeticOperator operator = new ArithmeticOperator();
        operator.mod("10", "0");
    }

    @Test(expected = NumberFormatException.class)
    public void modNumberFormatExceptionTest1() {
        ArithmeticOperator operator = new ArithmeticOperator();
        operator.mod("A", "1");
    }

    @Test(expected = NumberFormatException.class)
    public void modNumberFormatExceptionTest2() {
        ArithmeticOperator operator = new ArithmeticOperator();
        operator.mod("1", "A");
    }

}//end ArithmeticOperatorTest Class