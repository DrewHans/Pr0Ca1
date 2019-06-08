package io.github.drewhans555.pr0ca1;

import org.junit.Test;

import static org.junit.Assert.*;

public class BooleanLogicOperatorTest {
    @Test
    public void not() throws Exception {
        BooleanLogicOperator operator = new BooleanLogicOperator();
        assertEquals("11101", operator.not(5, "00010"));
        assertEquals("00010", operator.not(5, "11101"));
        assertEquals("11111", operator.not(5, "00000"));
        assertEquals("00000", operator.not(5, "11111"));

        assertEquals("111101", operator.not(6, "00010"));
        assertEquals("100010", operator.not(6, "11101"));
        assertEquals("111111", operator.not(6, "00000"));
        assertEquals("100000", operator.not(6, "11111"));
    }

    @Test
    public void and() throws Exception {
        BooleanLogicOperator operator = new BooleanLogicOperator();
        assertEquals("010", operator.and("010", "011"));
        assertEquals("110", operator.and("110", "111"));
        assertEquals("010", operator.and("110", "011"));
        assertEquals("010", operator.and("010", "111"));
        assertEquals("0000", operator.and("000", "0000"));
        assertEquals("0000", operator.and("0111", "000"));
    }

    @Test
    public void or() throws Exception {
        BooleanLogicOperator operator = new BooleanLogicOperator();
        assertEquals("011", operator.or("010", "011"));
        assertEquals("111", operator.or("110", "111"));
        assertEquals("111", operator.or("110", "011"));
        assertEquals("111", operator.or("010", "111"));
        assertEquals("0000", operator.or("000", "0000"));
        assertEquals("0111", operator.or("0111", "000"));
    }

    @Test
    public void xor() throws Exception {
        BooleanLogicOperator operator = new BooleanLogicOperator();
        assertEquals("001", operator.xor("010", "011"));
        assertEquals("001", operator.xor("110", "111"));
        assertEquals("101", operator.xor("110", "011"));
        assertEquals("101", operator.xor("010", "111"));
        assertEquals("0000", operator.xor("000", "0000"));
        assertEquals("0111", operator.xor("0111", "000"));
    }

    @Test
    public void nand() throws Exception {
        BooleanLogicOperator operator = new BooleanLogicOperator();
        assertEquals("101", operator.nand(3, "010", "011"));
        assertEquals("001", operator.nand(3, "110", "111"));
        assertEquals("101", operator.nand(3, "110", "011"));
        assertEquals("101", operator.nand(3, "010", "111"));
        assertEquals("1111", operator.nand(4, "000", "0000"));
        assertEquals("1111", operator.nand(4, "0111", "000"));
    }

    @Test
    public void nor() throws Exception {
        BooleanLogicOperator operator = new BooleanLogicOperator();
        assertEquals("100", operator.nor(3, "010", "011"));
        assertEquals("000", operator.nor(3, "110", "111"));
        assertEquals("000", operator.nor(3, "110", "011"));
        assertEquals("000", operator.nor(3, "010", "111"));
        assertEquals("1111", operator.nor(4, "000", "0000"));
        assertEquals("1000", operator.nor(4, "0111", "000"));
    }

    @Test
    public void xnor() throws Exception {
        BooleanLogicOperator operator = new BooleanLogicOperator();
        assertEquals("110", operator.xnor(3, "010", "011"));
        assertEquals("110", operator.xnor(3, "110", "111"));
        assertEquals("010", operator.xnor(3, "110", "011"));
        assertEquals("010", operator.xnor(3, "010", "111"));
        assertEquals("1111", operator.xnor(4, "000", "0000"));
        assertEquals("1000", operator.xnor(4, "0111", "000"));
    }

}