package io.github.drewhans555.pr0ca1;

public interface IBooleanLogicOperator {
    String not(int bitPrecision, String binString);
    String and(String input1, String input2);
    String or(String input1, String input2);
    String xor(String input1, String input2);
    String nand(int bitPrecision, String input1, String input2);
    String nor(int bitPrecision, String input1, String input2);
    String xnor(int bitPrecision, String input1, String input2);
}
