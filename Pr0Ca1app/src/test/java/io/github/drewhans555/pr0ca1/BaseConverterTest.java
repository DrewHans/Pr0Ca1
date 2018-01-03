package io.github.drewhans555.pr0ca1;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Drew Hans on 1/3/2018.
 *
 * @author Jessica Cramer(https://github.com/JessicaCramer117)
 * @author Hannah Goett(https://github.com/hannahgoett)
 * @author Drew Hans(https://github.com/DrewHans555)
 * @author Ashley Holcomb(https://github.com/ashleyholcomb)
 * @author Braydon Rekart(https://github.com/BRekart)
 */
public class BaseConverterTest {
    @Test
    public void convertBase2toBase8() throws Exception {
        BaseConverter converter = new BaseConverter();

        // test convertBase2toBase8 unsigned base cases
        assertEquals("", converter.convertBase2toBase8("", 3, false));

        assertEquals("0", converter.convertBase2toBase8("0", 3, false));
        assertEquals("1", converter.convertBase2toBase8("1", 3, false));

        assertEquals("0", converter.convertBase2toBase8("00", 3, false));
        assertEquals("1", converter.convertBase2toBase8("01", 3, false));
        assertEquals("2", converter.convertBase2toBase8("10", 3, false));
        assertEquals("3", converter.convertBase2toBase8("11", 3, false));

        assertEquals("0", converter.convertBase2toBase8("000", 3, false));
        assertEquals("1", converter.convertBase2toBase8("001", 3, false));
        assertEquals("2", converter.convertBase2toBase8("010", 3, false));
        assertEquals("3", converter.convertBase2toBase8("011", 3, false));
        assertEquals("4", converter.convertBase2toBase8("100", 3, false));
        assertEquals("5", converter.convertBase2toBase8("101", 3, false));
        assertEquals("6", converter.convertBase2toBase8("110", 3, false));
        assertEquals("7", converter.convertBase2toBase8("111", 3, false));

        // test convertBase2toBase8 signed base cases
        assertEquals("", converter.convertBase2toBase8("", 4, false));

        assertEquals("0", converter.convertBase2toBase8("0", 4, true));
        assertEquals("1", converter.convertBase2toBase8("1", 4, true));

        assertEquals("0", converter.convertBase2toBase8("00", 4, true));
        assertEquals("1", converter.convertBase2toBase8("01", 4, true));
        assertEquals("2", converter.convertBase2toBase8("10", 4, true));
        assertEquals("3", converter.convertBase2toBase8("11", 4, true));

        assertEquals("0", converter.convertBase2toBase8("000", 4, true));
        assertEquals("1", converter.convertBase2toBase8("001", 4, true));
        assertEquals("2", converter.convertBase2toBase8("010", 4, true));
        assertEquals("3", converter.convertBase2toBase8("011", 4, true));
        assertEquals("4", converter.convertBase2toBase8("100", 4, true));
        assertEquals("5", converter.convertBase2toBase8("101", 4, true));
        assertEquals("6", converter.convertBase2toBase8("110", 4, true));
        assertEquals("7", converter.convertBase2toBase8("111", 4, true));

        assertEquals("00", converter.convertBase2toBase8("0000", 4, true));
        assertEquals("01", converter.convertBase2toBase8("0001", 4, true));
        assertEquals("02", converter.convertBase2toBase8("0010", 4, true));
        assertEquals("03", converter.convertBase2toBase8("0011", 4, true));
        assertEquals("04", converter.convertBase2toBase8("0100", 4, true));
        assertEquals("05", converter.convertBase2toBase8("0101", 4, true));
        assertEquals("06", converter.convertBase2toBase8("0110", 4, true));
        assertEquals("07", converter.convertBase2toBase8("0111", 4, true));
        assertEquals("10", converter.convertBase2toBase8("1000", 4, true));
        assertEquals("11", converter.convertBase2toBase8("1001", 4, true));
        assertEquals("12", converter.convertBase2toBase8("1010", 4, true));
        assertEquals("13", converter.convertBase2toBase8("1011", 4, true));
        assertEquals("14", converter.convertBase2toBase8("1100", 4, true));
        assertEquals("15", converter.convertBase2toBase8("1101", 4, true));
        assertEquals("16", converter.convertBase2toBase8("1110", 4, true));
        assertEquals("17", converter.convertBase2toBase8("1111", 4, true));

        // test convertBase2toBase8 edge cases
        assertEquals("00000000000", converter.convertBase2toBase8("00000000000000000000000000000000", 32, true));
        assertEquals("17777777777", converter.convertBase2toBase8("01111111111111111111111111111111", 32, true));
        assertEquals("20000000000", converter.convertBase2toBase8("10000000000000000000000000000000", 32, true));
        assertEquals("37777777777", converter.convertBase2toBase8("11111111111111111111111111111111", 32, true));

        // original unit tests
        //4 bit unsigned
        assertEquals("11", converter.convertBase2toBase8("1001", 4, false));
        assertEquals("01", converter.convertBase2toBase8("0001", 4, false));
        assertEquals("00", converter.convertBase2toBase8("0000", 4, false));
        //8 bit unsigned
        assertEquals("211", converter.convertBase2toBase8("10001001", 8, false));
        assertEquals("001", converter.convertBase2toBase8("00000001", 8, false));
        assertEquals("000", converter.convertBase2toBase8("00000000", 8, false));
        //8 bit signed
        assertEquals("211", converter.convertBase2toBase8("10001001", 8, true));
        assertEquals("001", converter.convertBase2toBase8("00000001", 8, true));
        assertEquals("000", converter.convertBase2toBase8("00000000", 8, true));
        //16 But unsigned
        assertEquals("177771", converter.convertBase2toBase8("1111111111111001", 16, false));
        assertEquals("000001", converter.convertBase2toBase8("0000000000000001", 16, false));
        assertEquals("000000", converter.convertBase2toBase8("0000000000000000", 16, false));
        //16 bit signed
        assertEquals("177771", converter.convertBase2toBase8("1111111111111001", 16, true));
        assertEquals("000001", converter.convertBase2toBase8("0000000000000001", 16, true));
        assertEquals("000000", converter.convertBase2toBase8("0000000000000000", 16, true));
        //32 bit signed
        assertEquals("37777777771", converter.convertBase2toBase8("11111111111111111111111111111001", 32, true));
        assertEquals("000001", converter.convertBase2toBase8("0000000000000001", 32, true));
        assertEquals("000000", converter.convertBase2toBase8("0000000000000000", 32, true));

    }

    @Test
    public void convertBase2toBase10() throws Exception {
        BaseConverter converter = new BaseConverter();

        // test convertBase2toBase10 unsigned base cases
        assertEquals("", converter.convertBase2toBase10("", 4, false));

        assertEquals("0", converter.convertBase2toBase10("0", 4, false));
        assertEquals("1", converter.convertBase2toBase10("1", 4, false));

        assertEquals("0", converter.convertBase2toBase10("00", 4, false));
        assertEquals("1", converter.convertBase2toBase10("01", 4, false));
        assertEquals("2", converter.convertBase2toBase10("10", 4, false));
        assertEquals("3", converter.convertBase2toBase10("11", 4, false));

        assertEquals("0", converter.convertBase2toBase10("000", 4, false));
        assertEquals("1", converter.convertBase2toBase10("001", 4, false));
        assertEquals("2", converter.convertBase2toBase10("010", 4, false));
        assertEquals("3", converter.convertBase2toBase10("011", 4, false));
        assertEquals("4", converter.convertBase2toBase10("100", 4, false));
        assertEquals("5", converter.convertBase2toBase10("101", 4, false));
        assertEquals("6", converter.convertBase2toBase16("110", 4, false));
        assertEquals("7", converter.convertBase2toBase10("111", 4, false));

        assertEquals("0", converter.convertBase2toBase10("0000", 4, false));
        assertEquals("1", converter.convertBase2toBase10("0001", 4, false));
        assertEquals("2", converter.convertBase2toBase10("0010", 4, false));
        assertEquals("3", converter.convertBase2toBase10("0011", 4, false));
        assertEquals("4", converter.convertBase2toBase10("0100", 4, false));
        assertEquals("5", converter.convertBase2toBase10("0101", 4, false));
        assertEquals("6", converter.convertBase2toBase10("0110", 4, false));
        assertEquals("7", converter.convertBase2toBase10("0111", 4, false));
        assertEquals("8", converter.convertBase2toBase10("1000", 4, false));
        assertEquals("9", converter.convertBase2toBase10("1001", 4, false));
        assertEquals("10", converter.convertBase2toBase10("1010", 4, false));
        assertEquals("11", converter.convertBase2toBase10("1011", 4, false));
        assertEquals("12", converter.convertBase2toBase10("1100", 4, false));
        assertEquals("13", converter.convertBase2toBase10("1101", 4, false));
        assertEquals("14", converter.convertBase2toBase10("1110", 4, false));
        assertEquals("15", converter.convertBase2toBase10("1111", 4, false));

        // test convertBase2toBase10 signed base cases
        assertEquals("", converter.convertBase2toBase10("", 5, false));

        assertEquals("0", converter.convertBase2toBase10("0", 5, true));
        assertEquals("1", converter.convertBase2toBase10("1", 5, true));

        assertEquals("0", converter.convertBase2toBase10("00", 5, true));
        assertEquals("1", converter.convertBase2toBase10("01", 5, true));
        assertEquals("2", converter.convertBase2toBase10("10", 5, true));
        assertEquals("3", converter.convertBase2toBase10("11", 5, true));

        assertEquals("0", converter.convertBase2toBase10("000", 5, true));
        assertEquals("1", converter.convertBase2toBase10("001", 5, true));
        assertEquals("2", converter.convertBase2toBase10("010", 5, true));
        assertEquals("3", converter.convertBase2toBase10("011", 5, true));
        assertEquals("4", converter.convertBase2toBase10("100", 5, true));
        assertEquals("5", converter.convertBase2toBase10("101", 5, true));
        assertEquals("6", converter.convertBase2toBase10("110", 5, true));
        assertEquals("7", converter.convertBase2toBase10("111", 5, true));

        assertEquals("0", converter.convertBase2toBase10("0000", 5, true));
        assertEquals("1", converter.convertBase2toBase10("0001", 5, true));
        assertEquals("2", converter.convertBase2toBase10("0010", 5, true));
        assertEquals("3", converter.convertBase2toBase10("0011", 5, true));
        assertEquals("4", converter.convertBase2toBase10("0100", 5, true));
        assertEquals("5", converter.convertBase2toBase10("0101", 5, true));
        assertEquals("6", converter.convertBase2toBase10("0110", 5, true));
        assertEquals("7", converter.convertBase2toBase10("0111", 5, true));
        assertEquals("8", converter.convertBase2toBase10("1000", 5, true));
        assertEquals("9", converter.convertBase2toBase10("1001", 5, true));
        assertEquals("10", converter.convertBase2toBase10("1010", 5, true));
        assertEquals("11", converter.convertBase2toBase10("1011", 5, true));
        assertEquals("12", converter.convertBase2toBase10("1100", 5, true));
        assertEquals("13", converter.convertBase2toBase10("1101", 5, true));
        assertEquals("14", converter.convertBase2toBase10("1110", 5, true));
        assertEquals("15", converter.convertBase2toBase10("1111", 5, true));

        assertEquals("0", converter.convertBase2toBase10("00000", 5, true));
        assertEquals("1", converter.convertBase2toBase10("00001", 5, true));
        assertEquals("2", converter.convertBase2toBase10("00010", 5, true));
        assertEquals("3", converter.convertBase2toBase10("00011", 5, true));
        assertEquals("4", converter.convertBase2toBase10("00100", 5, true));
        assertEquals("5", converter.convertBase2toBase10("00101", 5, true));
        assertEquals("6", converter.convertBase2toBase10("00110", 5, true));
        assertEquals("7", converter.convertBase2toBase10("00111", 5, true));
        assertEquals("8", converter.convertBase2toBase10("01000", 5, true));
        assertEquals("9", converter.convertBase2toBase10("01001", 5, true));
        assertEquals("10", converter.convertBase2toBase10("01010", 5, true));
        assertEquals("11", converter.convertBase2toBase10("01011", 5, true));
        assertEquals("12", converter.convertBase2toBase10("01100", 5, true));
        assertEquals("13", converter.convertBase2toBase10("01101", 5, true));
        assertEquals("14", converter.convertBase2toBase10("01110", 5, true));
        assertEquals("15", converter.convertBase2toBase10("01111", 5, true));
        assertEquals("-16", converter.convertBase2toBase10("10000", 5, true));
        assertEquals("-15", converter.convertBase2toBase10("10001", 5, true));
        assertEquals("-14", converter.convertBase2toBase10("10010", 5, true));
        assertEquals("-13", converter.convertBase2toBase10("10011", 5, true));
        assertEquals("-12", converter.convertBase2toBase10("10100", 5, true));
        assertEquals("-11", converter.convertBase2toBase10("10101", 5, true));
        assertEquals("-10", converter.convertBase2toBase10("10110", 5, true));
        assertEquals("-9", converter.convertBase2toBase10("10111", 5, true));
        assertEquals("-8", converter.convertBase2toBase10("11000", 5, true));
        assertEquals("-7", converter.convertBase2toBase10("11001", 5, true));
        assertEquals("-6", converter.convertBase2toBase10("11010", 5, true));
        assertEquals("-5", converter.convertBase2toBase10("11011", 5, true));
        assertEquals("-4", converter.convertBase2toBase10("11100", 5, true));
        assertEquals("-3", converter.convertBase2toBase10("11101", 5, true));
        assertEquals("-2", converter.convertBase2toBase10("11110", 5, true));
        assertEquals("-1", converter.convertBase2toBase10("11111", 5, true));

        // test convertBase2toBase10 edge cases
        assertEquals("0", converter.convertBase2toBase10("00000000000000000000000000000000", 32, true));
        assertEquals("2147483647", converter.convertBase2toBase10("01111111111111111111111111111111", 32, true));
        assertEquals("-2147483648", converter.convertBase2toBase10("10000000000000000000000000000000", 32, true));
        assertEquals("-1", converter.convertBase2toBase10("11111111111111111111111111111111", 32, true));


        // original unit tests
        //4 bit unsigned
        assertEquals("9", converter.convertBase2toBase10("1001", 4, false));
        assertEquals("1", converter.convertBase2toBase10("0001", 4, false));
        assertEquals("0", converter.convertBase2toBase10("0000", 4, false));
        //8 bit unsigned
        assertEquals("137", converter.convertBase2toBase10("10001001", 8, false));
        assertEquals("1", converter.convertBase2toBase10("00000001", 8, false));
        assertEquals("0", converter.convertBase2toBase10("00000000", 8, false));
        //8 bit signed
        assertEquals("-9", converter.convertBase2toBase10("11110111", 8, true));
        assertEquals("1", converter.convertBase2toBase10("00000001", 8, true));
        assertEquals("0", converter.convertBase2toBase10("00000000", 8, true));
        //16 But unsigned
        assertEquals("32777", converter.convertBase2toBase10("1000000000001001", 16, false));
        assertEquals("1", converter.convertBase2toBase10("0000000000000001", 16, false));
        assertEquals("0", converter.convertBase2toBase10("0000000000000000", 16, false));
        //16 bit signed
        assertEquals("-7", converter.convertBase2toBase10("1111111111111001", 16, true));
        assertEquals("1", converter.convertBase2toBase10("0000000000000001", 16, true));
        assertEquals("0", converter.convertBase2toBase10("0000000000000000", 16, true));
        //32 bit signed
        assertEquals("-7", converter.convertBase2toBase10("11111111111111111111111111111001", 32, true));
        assertEquals("1", converter.convertBase2toBase10("0000000000000001", 32, true));
        assertEquals("0", converter.convertBase2toBase10("0000000000000000", 32, true));
    }

    @Test
    public void convertBase2toBase16() throws Exception {
        BaseConverter converter = new BaseConverter();

        // test convertBase2toBase16 unsigned base cases
        assertEquals("", converter.convertBase2toBase16("", 4, false));

        assertEquals("0", converter.convertBase2toBase16("0", 4, false));
        assertEquals("1", converter.convertBase2toBase16("1", 4, false));

        assertEquals("0", converter.convertBase2toBase16("00", 4, false));
        assertEquals("1", converter.convertBase2toBase16("01", 4, false));
        assertEquals("2", converter.convertBase2toBase16("10", 4, false));
        assertEquals("3", converter.convertBase2toBase16("11", 4, false));

        assertEquals("0", converter.convertBase2toBase16("000", 4, false));
        assertEquals("1", converter.convertBase2toBase16("001", 4, false));
        assertEquals("2", converter.convertBase2toBase16("010", 4, false));
        assertEquals("3", converter.convertBase2toBase16("011", 4, false));
        assertEquals("4", converter.convertBase2toBase16("100", 4, false));
        assertEquals("5", converter.convertBase2toBase16("101", 4, false));
        assertEquals("6", converter.convertBase2toBase16("110", 4, false));
        assertEquals("7", converter.convertBase2toBase16("111", 4, false));

        assertEquals("0", converter.convertBase2toBase16("0000", 4, false));
        assertEquals("1", converter.convertBase2toBase16("0001", 4, false));
        assertEquals("2", converter.convertBase2toBase16("0010", 4, false));
        assertEquals("3", converter.convertBase2toBase16("0011", 4, false));
        assertEquals("4", converter.convertBase2toBase16("0100", 4, false));
        assertEquals("5", converter.convertBase2toBase16("0101", 4, false));
        assertEquals("6", converter.convertBase2toBase16("0110", 4, false));
        assertEquals("7", converter.convertBase2toBase16("0111", 4, false));
        assertEquals("8", converter.convertBase2toBase16("1000", 4, false));
        assertEquals("9", converter.convertBase2toBase16("1001", 4, false));
        assertEquals("A", converter.convertBase2toBase16("1010", 4, false));
        assertEquals("B", converter.convertBase2toBase16("1011", 4, false));
        assertEquals("C", converter.convertBase2toBase16("1100", 4, false));
        assertEquals("D", converter.convertBase2toBase16("1101", 4, false));
        assertEquals("E", converter.convertBase2toBase16("1110", 4, false));
        assertEquals("F", converter.convertBase2toBase16("1111", 4, false));

        // test convertBase2toBase16 signed base cases
        assertEquals("", converter.convertBase2toBase16("", 5, false));

        assertEquals("0", converter.convertBase2toBase16("0", 5, true));
        assertEquals("1", converter.convertBase2toBase16("1", 5, true));

        assertEquals("0", converter.convertBase2toBase16("00", 5, true));
        assertEquals("1", converter.convertBase2toBase16("01", 5, true));
        assertEquals("2", converter.convertBase2toBase16("10", 5, true));
        assertEquals("3", converter.convertBase2toBase16("11", 5, true));

        assertEquals("0", converter.convertBase2toBase16("000", 5, true));
        assertEquals("1", converter.convertBase2toBase16("001", 5, true));
        assertEquals("2", converter.convertBase2toBase16("010", 5, true));
        assertEquals("3", converter.convertBase2toBase16("011", 5, true));
        assertEquals("4", converter.convertBase2toBase16("100", 5, true));
        assertEquals("5", converter.convertBase2toBase16("101", 5, true));
        assertEquals("6", converter.convertBase2toBase16("110", 5, true));
        assertEquals("7", converter.convertBase2toBase16("111", 5, true));

        assertEquals("0", converter.convertBase2toBase16("0000", 5, true));
        assertEquals("1", converter.convertBase2toBase16("0001", 5, true));
        assertEquals("2", converter.convertBase2toBase16("0010", 5, true));
        assertEquals("3", converter.convertBase2toBase16("0011", 5, true));
        assertEquals("4", converter.convertBase2toBase16("0100", 5, true));
        assertEquals("5", converter.convertBase2toBase16("0101", 5, true));
        assertEquals("6", converter.convertBase2toBase16("0110", 5, true));
        assertEquals("7", converter.convertBase2toBase16("0111", 5, true));
        assertEquals("8", converter.convertBase2toBase16("1000", 5, true));
        assertEquals("9", converter.convertBase2toBase16("1001", 5, true));
        assertEquals("A", converter.convertBase2toBase16("1010", 5, true));
        assertEquals("B", converter.convertBase2toBase16("1011", 5, true));
        assertEquals("C", converter.convertBase2toBase16("1100", 5, true));
        assertEquals("D", converter.convertBase2toBase16("1101", 5, true));
        assertEquals("E", converter.convertBase2toBase16("1110", 5, true));
        assertEquals("F", converter.convertBase2toBase16("1111", 5, true));

        assertEquals("00", converter.convertBase2toBase16("00000", 5, true));
        assertEquals("01", converter.convertBase2toBase16("00001", 5, true));
        assertEquals("02", converter.convertBase2toBase16("00010", 5, true));
        assertEquals("03", converter.convertBase2toBase16("00011", 5, true));
        assertEquals("04", converter.convertBase2toBase16("00100", 5, true));
        assertEquals("05", converter.convertBase2toBase16("00101", 5, true));
        assertEquals("06", converter.convertBase2toBase16("00110", 5, true));
        assertEquals("07", converter.convertBase2toBase16("00111", 5, true));
        assertEquals("08", converter.convertBase2toBase16("01000", 5, true));
        assertEquals("09", converter.convertBase2toBase16("01001", 5, true));
        assertEquals("0A", converter.convertBase2toBase16("01010", 5, true));
        assertEquals("0B", converter.convertBase2toBase16("01011", 5, true));
        assertEquals("0C", converter.convertBase2toBase16("01100", 5, true));
        assertEquals("0D", converter.convertBase2toBase16("01101", 5, true));
        assertEquals("0E", converter.convertBase2toBase16("01110", 5, true));
        assertEquals("0F", converter.convertBase2toBase16("01111", 5, true));
        assertEquals("10", converter.convertBase2toBase16("10000", 5, true));
        assertEquals("11", converter.convertBase2toBase16("10001", 5, true));
        assertEquals("12", converter.convertBase2toBase16("10010", 5, true));
        assertEquals("13", converter.convertBase2toBase16("10011", 5, true));
        assertEquals("14", converter.convertBase2toBase16("10100", 5, true));
        assertEquals("15", converter.convertBase2toBase16("10101", 5, true));
        assertEquals("16", converter.convertBase2toBase16("10110", 5, true));
        assertEquals("17", converter.convertBase2toBase16("10111", 5, true));
        assertEquals("18", converter.convertBase2toBase16("11000", 5, true));
        assertEquals("19", converter.convertBase2toBase16("11001", 5, true));
        assertEquals("1A", converter.convertBase2toBase16("11010", 5, true));
        assertEquals("1B", converter.convertBase2toBase16("11011", 5, true));
        assertEquals("1C", converter.convertBase2toBase16("11100", 5, true));
        assertEquals("1D", converter.convertBase2toBase16("11101", 5, true));
        assertEquals("1E", converter.convertBase2toBase16("11110", 5, true));
        assertEquals("1F", converter.convertBase2toBase16("11111", 5, true));

        // test convertBase2toBase16 edge cases
        assertEquals("00000000", converter.convertBase2toBase16("00000000000000000000000000000000", 32, true));
        assertEquals("7FFFFFFF", converter.convertBase2toBase16("01111111111111111111111111111111", 32, true));
        assertEquals("80000000", converter.convertBase2toBase16("10000000000000000000000000000000", 32, true));
        assertEquals("FFFFFFFF", converter.convertBase2toBase16("11111111111111111111111111111111", 32, true));

        // original unit tests
        //4 bit unsigned
        assertEquals("F", converter.convertBase2toBase16("1111", 4, false));
        assertEquals("1", converter.convertBase2toBase16("01", 4, false));
        assertEquals("0", converter.convertBase2toBase16("0", 4, false));
        //8 bit unsigned
        assertEquals("FF", converter.convertBase2toBase16("11111111", 8, false));
        assertEquals("1", converter.convertBase2toBase16("01", 8, false));
        assertEquals("0", converter.convertBase2toBase16("0", 8, false));
        //8 bit signed
        assertEquals("F7", converter.convertBase2toBase16("11110111", 8, true));
        assertEquals("1", converter.convertBase2toBase16("01", 8, true));
        assertEquals("0", converter.convertBase2toBase16("0", 8, true));
        //16 bit unsigned
        assertEquals("FFFF", converter.convertBase2toBase16("1111111111111111", 16, false));
        assertEquals("1", converter.convertBase2toBase16("01", 16, false));
        assertEquals("0", converter.convertBase2toBase16("0", 16, false));
        //16 bit signed
        assertEquals("FFF9", converter.convertBase2toBase16("1111111111111001", 16, true));
        assertEquals("1", converter.convertBase2toBase16("01", 16, true));
        assertEquals("0", converter.convertBase2toBase16("0", 16, true));
        //32 bit signed
        assertEquals("FFFFFFF9", converter.convertBase2toBase16("11111111111111111111111111111001", 32, true));
        assertEquals("1", converter.convertBase2toBase16("01", 32, true));
        assertEquals("0", converter.convertBase2toBase16("0", 32, true));
    }

    @Test
    public void convertBase8toBase2() throws Exception {
        BaseConverter converter = new BaseConverter();

        // test convertBase8toBase2 unsigned base cases
        assertEquals("", converter.convertBase8toBase2("", 3, false));

        assertEquals("0", converter.convertBase8toBase2("0", 3, false));
        assertEquals("1", converter.convertBase8toBase2("1", 3, false));
        assertEquals("10", converter.convertBase8toBase2("2", 3, false));
        assertEquals("11", converter.convertBase8toBase2("3", 3, false));
        assertEquals("100", converter.convertBase8toBase2("4", 3, false));
        assertEquals("101", converter.convertBase8toBase2("5", 3, false));
        assertEquals("110", converter.convertBase8toBase2("6", 3, false));
        assertEquals("111", converter.convertBase8toBase2("7", 3, false));

        // test convertBase8toBase2 signed base cases
        assertEquals("", converter.convertBase8toBase2("", 4, false));

        assertEquals("0", converter.convertBase8toBase2("0", 4, true));
        assertEquals("1", converter.convertBase8toBase2("1", 4, true));
        assertEquals("10", converter.convertBase8toBase2("2", 4, true));
        assertEquals("11", converter.convertBase8toBase2("3", 4, true));
        assertEquals("100", converter.convertBase8toBase2("4", 4, true));
        assertEquals("101", converter.convertBase8toBase2("5", 4, true));
        assertEquals("110", converter.convertBase8toBase2("6", 4, true));
        assertEquals("111", converter.convertBase8toBase2("7", 4, true));

        assertEquals("0000", converter.convertBase8toBase2("00", 4, true));
        assertEquals("0001", converter.convertBase8toBase2("01", 4, true));
        assertEquals("0010", converter.convertBase8toBase2("02", 4, true));
        assertEquals("0011", converter.convertBase8toBase2("03", 4, true));
        assertEquals("0100", converter.convertBase8toBase2("04", 4, true));
        assertEquals("0101", converter.convertBase8toBase2("05", 4, true));
        assertEquals("0110", converter.convertBase8toBase2("06", 4, true));
        assertEquals("0111", converter.convertBase8toBase2("07", 4, true));
        assertEquals("1000", converter.convertBase8toBase2("10", 4, true));
        assertEquals("1001", converter.convertBase8toBase2("11", 4, true));
        assertEquals("1010", converter.convertBase8toBase2("12", 4, true));
        assertEquals("1011", converter.convertBase8toBase2("13", 4, true));
        assertEquals("1100", converter.convertBase8toBase2("14", 4, true));
        assertEquals("1101", converter.convertBase8toBase2("15", 4, true));
        assertEquals("1110", converter.convertBase8toBase2("16", 4, true));
        assertEquals("1111", converter.convertBase8toBase2("17", 4, true));

        // test convertBase8toBase2 edge cases
        assertEquals("0000000000000000000000000000000", converter.convertBase8toBase2("00000000000", 32, true));
        assertEquals("1111111111111111111111111111111", converter.convertBase8toBase2("17777777777", 32, true));
        assertEquals("10000000000000000000000000000000", converter.convertBase8toBase2("20000000000", 32, true));
        assertEquals("11111111111111111111111111111111", converter.convertBase8toBase2("37777777777", 32, true));

        // original unit tests
        //4 bit unsigned
        assertEquals("1001", converter.convertBase8toBase2("11", 4, false));
        assertEquals("0001", converter.convertBase8toBase2("01", 4, false));
        assertEquals("0", converter.convertBase8toBase2("0", 4, false));
        //8 bit unsigned
        assertEquals("10001001", converter.convertBase8toBase2("211", 8, false));
        assertEquals("0001", converter.convertBase8toBase2("01", 8, false));
        assertEquals("0", converter.convertBase8toBase2("0", 8, false));
        //8 bit signed
        assertEquals("10001001", converter.convertBase8toBase2("211", 8, true));
        assertEquals("0001", converter.convertBase8toBase2("01", 8, true));
        assertEquals("0", converter.convertBase8toBase2("0", 8, true));
        //16 But unsigned
        assertEquals("1111111111111001", converter.convertBase8toBase2("177771", 16, false));
        assertEquals("0001", converter.convertBase8toBase2("01", 16, false));
        assertEquals("0", converter.convertBase8toBase2("0", 16, false));
        //16 bit signed
        assertEquals("1111111111111001", converter.convertBase8toBase2("177771", 16, true));
        assertEquals("0001", converter.convertBase8toBase2("01", 16, true));
        assertEquals("0", converter.convertBase8toBase2("0", 16, true));
        //32 bit signed
        assertEquals("111111111111111111111111111001", converter.convertBase8toBase2("7777777771", 32, true));
        assertEquals("0001", converter.convertBase8toBase2("01", 32, true));
        assertEquals("0", converter.convertBase8toBase2("0", 32, true));
    }

    @Test
    public void convertBase8toBase10() throws Exception {
        BaseConverter converter = new BaseConverter();

        // original unit tests
        //4 bit unsigned
        assertEquals("15", converter.convertBase8toBase10("17", 4, false));
        assertEquals("1", converter.convertBase8toBase10("01", 4, false));
        assertEquals("0", converter.convertBase8toBase10("0", 4, false));
        //8 bit unsigned
        assertEquals("255", converter.convertBase8toBase10("377", 8, false));
        assertEquals("1", converter.convertBase8toBase10("01", 8, false));
        assertEquals("0", converter.convertBase8toBase10("0", 8, false));
        //8 bit signed
        assertEquals("-9", converter.convertBase8toBase10("367", 8, true));
        assertEquals("1", converter.convertBase8toBase10("01", 8, true));
        assertEquals("0", converter.convertBase8toBase10("0", 8, true));
        //16 bit unsigned
        assertEquals("65535", converter.convertBase8toBase10("177777", 16, false));
        assertEquals("1", converter.convertBase8toBase10("01", 16, false));
        assertEquals("0", converter.convertBase8toBase10("0", 16, false));
        //16 bit signed
        assertEquals("-7", converter.convertBase8toBase10("177771", 16, true));
        assertEquals("1", converter.convertBase8toBase10("01", 16, true));
        assertEquals("0", converter.convertBase8toBase10("0", 16, true));
        //32 bit signed
        assertEquals("-7", converter.convertBase8toBase10("37777777771", 32, true));
        assertEquals("1", converter.convertBase8toBase10("01", 32, true));
        assertEquals("0", converter.convertBase8toBase10("0", 32, true));
    }

    @Test
    public void convertBase8toBase16() throws Exception {
        BaseConverter converter = new BaseConverter();

        // original unit tests
        //4 bit unsigned
        assertEquals("F", converter.convertBase8toBase16("17", 4, false));
        assertEquals("1", converter.convertBase8toBase16("01", 4, false));
        assertEquals("0", converter.convertBase8toBase16("0", 4, false));
        //8 bit unsigned
        assertEquals("FF", converter.convertBase8toBase16("377", 8, false));
        assertEquals("1", converter.convertBase8toBase16("01", 8, false));
        assertEquals("0", converter.convertBase8toBase16("0", 8, false));
        //8 bit signed
        assertEquals("F7", converter.convertBase8toBase16("367", 8, true));
        assertEquals("1", converter.convertBase8toBase16("01", 8, true));
        assertEquals("0", converter.convertBase8toBase16("0", 8, true));
        //16 bit unsigned
        assertEquals("FFFF", converter.convertBase8toBase16("177777", 16, false));
        assertEquals("1", converter.convertBase8toBase16("01", 16, false));
        assertEquals("0", converter.convertBase8toBase16("0", 16, false));
        //16 bit signed
        assertEquals("FFF9", converter.convertBase8toBase16("177771", 16, true));
        assertEquals("1", converter.convertBase8toBase16("01", 16, true));
        assertEquals("0", converter.convertBase8toBase16("0", 16, true));
        //32 bit signed
        assertEquals("FFFFFFF7", converter.convertBase8toBase16("37777777767", 32, true));
        assertEquals("1", converter.convertBase8toBase16("01", 32, true));
        assertEquals("0", converter.convertBase8toBase16("0", 32, true));
    }

    @Test
    public void convertBase10toBase2() throws Exception {
        BaseConverter converter = new BaseConverter();

        // test convertBase10toBase2 unsigned base cases
        assertEquals("", converter.convertBase10toBase2("", 4, false));

        assertEquals("0", converter.convertBase10toBase2("0", 4, false));
        assertEquals("1", converter.convertBase10toBase2("1", 4, false));
        assertEquals("10", converter.convertBase10toBase2("2", 4, false));
        assertEquals("11", converter.convertBase10toBase2("3", 4, false));
        assertEquals("100", converter.convertBase10toBase2("4", 4, false));
        assertEquals("101", converter.convertBase10toBase2("5", 4, false));
        assertEquals("110", converter.convertBase10toBase2("6", 4, false));
        assertEquals("111", converter.convertBase10toBase2("7", 4, false));
        assertEquals("1000", converter.convertBase10toBase2("8", 4, false));
        assertEquals("1001", converter.convertBase10toBase2("9", 4, false));
        assertEquals("1010", converter.convertBase10toBase2("10", 4, false));
        assertEquals("1011", converter.convertBase10toBase2("11", 4, false));
        assertEquals("1100", converter.convertBase10toBase2("12", 4, false));
        assertEquals("1101", converter.convertBase10toBase2("13", 4, false));
        assertEquals("1110", converter.convertBase10toBase2("14", 4, false));
        assertEquals("1111", converter.convertBase10toBase2("15", 4, false));

        // test convertBase10toBase2 signed base cases
        assertEquals("", converter.convertBase10toBase2("", 5, false));

        assertEquals("0", converter.convertBase10toBase2("0", 5, true));
        assertEquals("1", converter.convertBase10toBase2("1", 5, true));
        assertEquals("10", converter.convertBase10toBase2("2", 5, true));
        assertEquals("11", converter.convertBase10toBase2("3", 5, true));
        assertEquals("100", converter.convertBase10toBase2("4", 5, true));
        assertEquals("101", converter.convertBase10toBase2("5", 5, true));
        assertEquals("110", converter.convertBase10toBase2("6", 5, true));
        assertEquals("111", converter.convertBase10toBase2("7", 5, true));
        assertEquals("1000", converter.convertBase10toBase2("8", 5, true));
        assertEquals("1001", converter.convertBase10toBase2("9", 5, true));
        assertEquals("1010", converter.convertBase10toBase2("10", 5, true));
        assertEquals("1011", converter.convertBase10toBase2("11", 5, true));
        assertEquals("1100", converter.convertBase10toBase2("12", 5, true));
        assertEquals("1101", converter.convertBase10toBase2("13", 5, true));
        assertEquals("1110", converter.convertBase10toBase2("14", 5, true));
        assertEquals("1111", converter.convertBase10toBase2("15", 5, true));
        assertEquals("10000", converter.convertBase10toBase2("-16", 5, true));
        assertEquals("10001", converter.convertBase10toBase2("-15", 5, true));
        assertEquals("10010", converter.convertBase10toBase2("-14", 5, true));
        assertEquals("10011", converter.convertBase10toBase2("-13", 5, true));
        assertEquals("10100", converter.convertBase10toBase2("-12", 5, true));
        assertEquals("10101", converter.convertBase10toBase2("-11", 5, true));
        assertEquals("10110", converter.convertBase10toBase2("-10", 5, true));
        assertEquals("10111", converter.convertBase10toBase2("-9", 5, true));
        assertEquals("11000", converter.convertBase10toBase2("-8", 5, true));
        assertEquals("11001", converter.convertBase10toBase2("-7", 5, true));
        assertEquals("11010", converter.convertBase10toBase2("-6", 5, true));
        assertEquals("11011", converter.convertBase10toBase2("-5", 5, true));
        assertEquals("11100", converter.convertBase10toBase2("-4", 5, true));
        assertEquals("11101", converter.convertBase10toBase2("-3", 5, true));
        assertEquals("11110", converter.convertBase10toBase2("-2", 5, true));
        assertEquals("11111", converter.convertBase10toBase2("-1", 5, true));

        // test convertBase10toBase2 edge cases
        assertEquals("0", converter.convertBase10toBase2("0", 32, true));
        assertEquals("1111111111111111111111111111111", converter.convertBase10toBase2("2147483647", 32, true));
        assertEquals("10000000000000000000000000000000", converter.convertBase10toBase2("-2147483648", 32, true));
        assertEquals("11111111111111111111111111111111", converter.convertBase10toBase2("-1", 32, true));

        // original unit tests
        //4 bit unsigned
        assertEquals("1001", converter.convertBase10toBase2("9", 4, false));
        assertEquals("1", converter.convertBase10toBase2("01", 4, false));
        assertEquals("0", converter.convertBase10toBase2("0", 4, false));
        //8 bit unsigned
        assertEquals("10001001", converter.convertBase10toBase2("137", 8, false));
        assertEquals("1", converter.convertBase10toBase2("01", 8, false));
        assertEquals("0", converter.convertBase10toBase2("0", 8, false));
        //8 bit signed
        assertEquals("11110111", converter.convertBase10toBase2("-9", 8, true));
        assertEquals("1", converter.convertBase10toBase2("01", 8, true));
        assertEquals("0", converter.convertBase10toBase2("0", 8, true));
        //16 But unsigned
        assertEquals("1000000000001001", converter.convertBase10toBase2("32777", 16, false));
        assertEquals("1", converter.convertBase10toBase2("01", 16, false));
        assertEquals("0", converter.convertBase10toBase2("0", 16, false));
        //16 bit signed
        assertEquals("1111111111111001", converter.convertBase10toBase2("-7", 16, true));
        assertEquals("1", converter.convertBase10toBase2("01", 16, true));
        assertEquals("0", converter.convertBase10toBase2("0", 16, true));
        //32 bit signed
        assertEquals("11111111111111111111111111111001", converter.convertBase10toBase2("-7", 32, true));
        assertEquals("1", converter.convertBase10toBase2("01", 32, true));
        assertEquals("0", converter.convertBase10toBase2("0", 32, true));
    }


    @Test
    public void convertBase10toBase8() throws Exception {
        BaseConverter converter = new BaseConverter();

        // original unit tests
        //4 bit unsigned
        assertEquals("17", converter.convertBase10toBase8("15", 4, false));
        assertEquals("1", converter.convertBase10toBase8("01", 4, false));
        assertEquals("0", converter.convertBase10toBase8("0", 4, false));
        //8 bit unsigned
        assertEquals("377", converter.convertBase10toBase8("255", 8, false));
        assertEquals("1", converter.convertBase10toBase8("01", 8, false));
        assertEquals("0", converter.convertBase10toBase8("0", 8, false));
        //8 bit signed
        assertEquals("367", converter.convertBase10toBase8("-9", 8, true));
        assertEquals("1", converter.convertBase10toBase8("01", 8, true));
        assertEquals("0", converter.convertBase10toBase8("0", 8, true));
        //16 But unsigned
        assertEquals("177777", converter.convertBase10toBase8("65535", 16, false));
        assertEquals("1", converter.convertBase10toBase8("01", 16, false));
        assertEquals("0", converter.convertBase10toBase8("0", 16, false));
        //16 bit signed
        assertEquals("177771", converter.convertBase10toBase8("-7", 16, true));
        assertEquals("1", converter.convertBase10toBase8("01", 16, true));
        assertEquals("0", converter.convertBase10toBase8("0", 16, true));
        //32 bit signed
        assertEquals("37777777771", converter.convertBase10toBase8("-7", 32, true));
        assertEquals("1", converter.convertBase10toBase8("01", 32, true));
        assertEquals("0", converter.convertBase10toBase8("0", 32, true));
    }

    @Test
    public void convertBase10toBase16() throws Exception {
        BaseConverter converter = new BaseConverter();

        // original unit tests
        //4 bit unsigned
        assertEquals("F", converter.convertBase10toBase16("15", 4, false));
        assertEquals("1", converter.convertBase10toBase16("01", 4, false));
        assertEquals("0", converter.convertBase10toBase16("0", 4, false));
        //8 bit unsigned
        assertEquals("FF", converter.convertBase10toBase16("255", 8, false));
        assertEquals("1", converter.convertBase10toBase16("01", 8, false));
        assertEquals("0", converter.convertBase10toBase16("0", 8, false));
        //8 bit signed
        assertEquals("F7", converter.convertBase10toBase16("-9", 8, true));
        assertEquals("1", converter.convertBase10toBase16("01", 8, true));
        assertEquals("0", converter.convertBase10toBase16("0", 8, true));
        //16 But unsigned
        assertEquals("FFFF", converter.convertBase10toBase16("65535", 16, false));
        assertEquals("1", converter.convertBase10toBase16("01", 16, false));
        assertEquals("0", converter.convertBase10toBase16("0", 16, false));
        //16 bit signed
        assertEquals("FFF9", converter.convertBase10toBase16("-7", 16, true));
        assertEquals("1", converter.convertBase10toBase16("01", 16, true));
        assertEquals("0", converter.convertBase10toBase16("0", 16, true));
        //32 bit signed
        assertEquals("FFFFFFF9", converter.convertBase10toBase16("-7", 32, true));
        assertEquals("1", converter.convertBase10toBase16("01", 32, true));
        assertEquals("0", converter.convertBase10toBase16("0", 32, true));
    }

    @Test
    public void convertBase16toBase2() throws Exception {
        BaseConverter converter = new BaseConverter();

        // test convertBase16toBase2 unsigned base cases
        assertEquals("", converter.convertBase16toBase2("", 4, false));

        assertEquals("0", converter.convertBase16toBase2("0", 4, false));
        assertEquals("1", converter.convertBase16toBase2("1", 4, false));
        assertEquals("10", converter.convertBase16toBase2("2", 4, false));
        assertEquals("11", converter.convertBase16toBase2("3", 4, false));
        assertEquals("100", converter.convertBase16toBase2("4", 4, false));
        assertEquals("101", converter.convertBase16toBase2("5", 4, false));
        assertEquals("110", converter.convertBase16toBase2("6", 4, false));
        assertEquals("111", converter.convertBase16toBase2("7", 4, false));
        assertEquals("1000", converter.convertBase16toBase2("8", 4, false));
        assertEquals("1001", converter.convertBase16toBase2("9", 4, false));
        assertEquals("1010", converter.convertBase16toBase2("A", 4, false));
        assertEquals("1011", converter.convertBase16toBase2("B", 4, false));
        assertEquals("1100", converter.convertBase16toBase2("C", 4, false));
        assertEquals("1101", converter.convertBase16toBase2("D", 4, false));
        assertEquals("1110", converter.convertBase16toBase2("E", 4, false));
        assertEquals("1111", converter.convertBase16toBase2("F", 4, false));

        // test convertBase16toBase2 signed base cases
        assertEquals("", converter.convertBase16toBase2("", 5, false));

        assertEquals("0", converter.convertBase16toBase2("0", 5, true));
        assertEquals("1", converter.convertBase16toBase2("1", 5, true));
        assertEquals("10", converter.convertBase16toBase2("2", 5, true));
        assertEquals("11", converter.convertBase16toBase2("3", 5, true));
        assertEquals("100", converter.convertBase16toBase2("4", 5, true));
        assertEquals("101", converter.convertBase16toBase2("5", 5, true));
        assertEquals("110", converter.convertBase16toBase2("6", 5, true));
        assertEquals("111", converter.convertBase16toBase2("7", 5, true));
        assertEquals("1000", converter.convertBase16toBase2("8", 5, true));
        assertEquals("1001", converter.convertBase16toBase2("9", 5, true));
        assertEquals("1010", converter.convertBase16toBase2("A", 5, true));
        assertEquals("1011", converter.convertBase16toBase2("B", 5, true));
        assertEquals("1100", converter.convertBase16toBase2("C", 5, true));
        assertEquals("1101", converter.convertBase16toBase2("D", 5, true));
        assertEquals("1110", converter.convertBase16toBase2("E", 5, true));
        assertEquals("1111", converter.convertBase16toBase2("F", 5, true));

        assertEquals("00000", converter.convertBase16toBase2("00", 5, true));
        assertEquals("00001", converter.convertBase16toBase2("01", 5, true));
        assertEquals("00010", converter.convertBase16toBase2("02", 5, true));
        assertEquals("00011", converter.convertBase16toBase2("03", 5, true));
        assertEquals("00100", converter.convertBase16toBase2("04", 5, true));
        assertEquals("00101", converter.convertBase16toBase2("05", 5, true));
        assertEquals("00110", converter.convertBase16toBase2("06", 5, true));
        assertEquals("00111", converter.convertBase16toBase2("07", 5, true));
        assertEquals("01000", converter.convertBase16toBase2("08", 5, true));
        assertEquals("01001", converter.convertBase16toBase2("09", 5, true));
        assertEquals("01010", converter.convertBase16toBase2("0A", 5, true));
        assertEquals("01011", converter.convertBase16toBase2("0B", 5, true));
        assertEquals("01100", converter.convertBase16toBase2("0C", 5, true));
        assertEquals("01101", converter.convertBase16toBase2("0D", 5, true));
        assertEquals("01110", converter.convertBase16toBase2("0E", 5, true));
        assertEquals("01111", converter.convertBase16toBase2("0F", 5, true));
        assertEquals("10000", converter.convertBase16toBase2("10", 5, true));
        assertEquals("10001", converter.convertBase16toBase2("11", 5, true));
        assertEquals("10010", converter.convertBase16toBase2("12", 5, true));
        assertEquals("10011", converter.convertBase16toBase2("13", 5, true));
        assertEquals("10100", converter.convertBase16toBase2("14", 5, true));
        assertEquals("10101", converter.convertBase16toBase2("15", 5, true));
        assertEquals("10110", converter.convertBase16toBase2("16", 5, true));
        assertEquals("10111", converter.convertBase16toBase2("17", 5, true));
        assertEquals("11000", converter.convertBase16toBase2("18", 5, true));
        assertEquals("11001", converter.convertBase16toBase2("19", 5, true));
        assertEquals("11010", converter.convertBase16toBase2("1A", 5, true));
        assertEquals("11011", converter.convertBase16toBase2("1B", 5, true));
        assertEquals("11100", converter.convertBase16toBase2("1C", 5, true));
        assertEquals("11101", converter.convertBase16toBase2("1D", 5, true));
        assertEquals("11110", converter.convertBase16toBase2("1E", 5, true));
        assertEquals("11111", converter.convertBase16toBase2("1F", 5, true));

        // test convertBase16toBase2 edge cases
        assertEquals("00000000000000000000000000000", converter.convertBase16toBase2("00000000", 32, true));
        assertEquals("1111111111111111111111111111111", converter.convertBase16toBase2("7FFFFFFF", 32, true));
        assertEquals("10000000000000000000000000000000", converter.convertBase16toBase2("80000000", 32, true));
        assertEquals("11111111111111111111111111111111", converter.convertBase16toBase2("FFFFFFFF", 32, true));

        // original unit tests
        //4 bit unsigned
        assertEquals("1111", converter.convertBase16toBase2("F", 4, false));
        assertEquals("1", converter.convertBase16toBase2("1", 4, false));
        assertEquals("0", converter.convertBase16toBase2("0", 4, false));
        //8 bit unsigned
        assertEquals("11111111", converter.convertBase16toBase2("FF", 8, false));
        assertEquals("00001", converter.convertBase16toBase2("01", 8, false));
        assertEquals("0", converter.convertBase16toBase2("0", 8, false));
        //8 bit signed
        assertEquals("11110111", converter.convertBase16toBase2("F7", 8, true));
        assertEquals("00001", converter.convertBase16toBase2("01", 8, true));
        assertEquals("0", converter.convertBase16toBase2("0", 8, true));
        //16 But unsigned
        assertEquals("1111111111111111", converter.convertBase16toBase2("FFFF", 16, false));
        assertEquals("00001", converter.convertBase16toBase2("01", 16, false));
        assertEquals("0", converter.convertBase16toBase2("0", 16, false));
        //16 bit signed
        assertEquals("1111111111111001", converter.convertBase16toBase2("FFF9", 16, true));
        assertEquals("00001", converter.convertBase16toBase2("01", 16, true));
        assertEquals("0", converter.convertBase16toBase2("0", 16, true));
        //32 bit signed
        assertEquals("11111111111111111111111111111001", converter.convertBase16toBase2("FFFFFFF9", 32, true));
        assertEquals("00001", converter.convertBase16toBase2("01", 32, true));
        assertEquals("0", converter.convertBase16toBase2("0", 32, true));
    }

    @Test
    public void convertBase16toBase8() throws Exception {
        BaseConverter converter = new BaseConverter();

        // original unit tests
        //4 bit unsigned
        assertEquals("17", converter.convertBase16toBase8("F", 4, false));
        assertEquals("1", converter.convertBase16toBase8("1", 4, false));
        assertEquals("0", converter.convertBase16toBase8("0", 4, false));
        //8 bit unsigned
        assertEquals("377", converter.convertBase16toBase8("FF", 8, false));
        assertEquals("01", converter.convertBase16toBase8("01", 8, false));
        assertEquals("0", converter.convertBase16toBase8("0", 8, false));
        //8 bit signed
        assertEquals("367", converter.convertBase16toBase8("F7", 8, true));
        assertEquals("01", converter.convertBase16toBase8("01", 8, true));
        assertEquals("0", converter.convertBase16toBase8("0", 8, true));
        //16 bit unsigned
        assertEquals("177777", converter.convertBase16toBase8("FFFF", 16, false));
        assertEquals("01", converter.convertBase16toBase8("01", 16, false));
        assertEquals("0", converter.convertBase16toBase8("0", 16, false));
        //16 bit signed
        assertEquals("177771", converter.convertBase16toBase8("FFF9", 16, true));
        assertEquals("01", converter.convertBase16toBase8("01", 16, true));
        assertEquals("0", converter.convertBase16toBase8("0", 16, true));
        //32 bit signed
        assertEquals("37777777767", converter.convertBase16toBase8("FFFFFFF7", 32, true));
        assertEquals("01", converter.convertBase16toBase8("01", 32, true));
        assertEquals("0", converter.convertBase16toBase8("0", 32, true));
    }

    @Test
    public void convertBase16toBase10() throws Exception {
        BaseConverter converter = new BaseConverter();

        // original unit tests
        //4 bit unsigned
        assertEquals("15", converter.convertBase16toBase10("F", 4, false));
        assertEquals("1", converter.convertBase16toBase10("1", 4, false));
        assertEquals("0", converter.convertBase16toBase10("0", 4, false));
        //8 bit unsigned
        assertEquals("255", converter.convertBase16toBase10("FF", 8, false));
        assertEquals("1", converter.convertBase16toBase10("1", 8, false));
        assertEquals("0", converter.convertBase16toBase10("0", 8, false));
        //8 bit signed
        assertEquals("-9", converter.convertBase16toBase10("F7", 8, true));
        assertEquals("1", converter.convertBase16toBase10("1", 8, true));
        assertEquals("0", converter.convertBase16toBase10("0", 8, true));
        //16 But unsigned
        assertEquals("65535", converter.convertBase16toBase10("FFFF", 16, false));
        assertEquals("1", converter.convertBase16toBase10("1", 16, false));
        assertEquals("0", converter.convertBase16toBase10("0", 16, false));
        //16 bit signed
        assertEquals("-7", converter.convertBase16toBase10("FFF9", 16, true));
        assertEquals("1", converter.convertBase16toBase10("1", 16, true));
        assertEquals("0", converter.convertBase16toBase10("0", 16, true));
        //32 bit signed
        assertEquals("-7", converter.convertBase16toBase10("FFFFFFF9", 32, true));
        assertEquals("1", converter.convertBase16toBase10("1", 32, true));
        assertEquals("0", converter.convertBase16toBase10("0", 32, true));
    }

}