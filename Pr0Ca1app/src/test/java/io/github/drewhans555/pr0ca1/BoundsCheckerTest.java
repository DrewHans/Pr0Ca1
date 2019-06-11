package io.github.drewhans555.pr0ca1;

import org.junit.Test;

import static org.junit.Assert.*;

public class BoundsCheckerTest {
    @Test
    public void binStringIsWithinBounds__with_valid_data__returns_expected_boolean() {
        BoundsChecker checker = new BoundsChecker();
        assertTrue(checker.binStringIsWithinBounds("", 1));
        assertTrue(checker.binStringIsWithinBounds("0", 1));
        assertTrue(checker.binStringIsWithinBounds("1", 1));
        assertFalse(checker.binStringIsWithinBounds("00", 1));
        assertFalse(checker.binStringIsWithinBounds("01", 1));
    }

    @Test
    public void octStringIsWithinBounds__with_valid_data__returns_expected_boolean() {
        BoundsChecker checker = new BoundsChecker();
        assertTrue(checker.octStringIsWithinBounds("", 3));
        assertTrue(checker.octStringIsWithinBounds("0", 3));
        assertTrue(checker.octStringIsWithinBounds("1", 3));
        assertTrue(checker.octStringIsWithinBounds("7", 3));
        assertFalse(checker.octStringIsWithinBounds("10", 3));
        assertFalse(checker.octStringIsWithinBounds("17", 3));
        assertFalse(checker.octStringIsWithinBounds("20", 3));
        assertFalse(checker.octStringIsWithinBounds("30", 3));
        assertFalse(checker.octStringIsWithinBounds("40", 3));

        assertTrue(checker.octStringIsWithinBounds("", 4));
        assertTrue(checker.octStringIsWithinBounds("0", 4));
        assertTrue(checker.octStringIsWithinBounds("1", 4));
        assertTrue(checker.octStringIsWithinBounds("7", 4));
        assertTrue(checker.octStringIsWithinBounds("10", 4));
        assertTrue(checker.octStringIsWithinBounds("17", 4));
        assertFalse(checker.octStringIsWithinBounds("20", 4));
        assertFalse(checker.octStringIsWithinBounds("30", 4));
        assertFalse(checker.octStringIsWithinBounds("40", 4));

        assertTrue(checker.octStringIsWithinBounds("", 5));
        assertTrue(checker.octStringIsWithinBounds("0", 5));
        assertTrue(checker.octStringIsWithinBounds("1", 5));
        assertTrue(checker.octStringIsWithinBounds("7", 5));
        assertTrue(checker.octStringIsWithinBounds("17", 5));
        assertTrue(checker.octStringIsWithinBounds("27", 5));
        assertTrue(checker.octStringIsWithinBounds("37", 5));
        assertFalse(checker.octStringIsWithinBounds("40", 5));
    }

    @Test
    public void hexStringIsWithinBounds__with_valid_data__returns_expected_boolean() {
        BoundsChecker checker = new BoundsChecker();

        assertTrue(checker.hexStringIsWithinBounds("", 4));
        assertTrue(checker.hexStringIsWithinBounds("0", 4));
        assertTrue(checker.hexStringIsWithinBounds("1", 4));
        assertTrue(checker.hexStringIsWithinBounds("F", 4));

        assertTrue(checker.hexStringIsWithinBounds("", 5));
        assertTrue(checker.hexStringIsWithinBounds("0", 5));
        assertTrue(checker.hexStringIsWithinBounds("1", 5));
        assertTrue(checker.hexStringIsWithinBounds("F", 5));
        assertTrue(checker.hexStringIsWithinBounds("10", 5));
        assertTrue(checker.hexStringIsWithinBounds("1F", 5));
        assertFalse(checker.hexStringIsWithinBounds("20", 5));

        assertTrue(checker.hexStringIsWithinBounds("", 6));
        assertTrue(checker.hexStringIsWithinBounds("0", 6));
        assertTrue(checker.hexStringIsWithinBounds("1", 6));
        assertTrue(checker.hexStringIsWithinBounds("F", 6));
        assertTrue(checker.hexStringIsWithinBounds("10", 6));
        assertTrue(checker.hexStringIsWithinBounds("1F", 6));
        assertTrue(checker.hexStringIsWithinBounds("20", 6));
        assertTrue(checker.hexStringIsWithinBounds("2F", 6));
        assertTrue(checker.hexStringIsWithinBounds("30", 6));
        assertTrue(checker.hexStringIsWithinBounds("3F", 6));
        assertFalse(checker.hexStringIsWithinBounds("40", 6));

        assertTrue(checker.hexStringIsWithinBounds("", 7));
        assertTrue(checker.hexStringIsWithinBounds("0", 7));
        assertTrue(checker.hexStringIsWithinBounds("1", 7));
        assertTrue(checker.hexStringIsWithinBounds("F", 7));
        assertTrue(checker.hexStringIsWithinBounds("10", 7));
        assertTrue(checker.hexStringIsWithinBounds("1F", 7));
        assertTrue(checker.hexStringIsWithinBounds("20", 7));
        assertTrue(checker.hexStringIsWithinBounds("2F", 7));
        assertTrue(checker.hexStringIsWithinBounds("30", 7));
        assertTrue(checker.hexStringIsWithinBounds("3F", 7));
        assertTrue(checker.hexStringIsWithinBounds("40", 7));
        assertTrue(checker.hexStringIsWithinBounds("4F", 7));
        assertTrue(checker.hexStringIsWithinBounds("50", 7));
        assertTrue(checker.hexStringIsWithinBounds("5F", 7));
        assertTrue(checker.hexStringIsWithinBounds("60", 7));
        assertTrue(checker.hexStringIsWithinBounds("6F", 7));
        assertTrue(checker.hexStringIsWithinBounds("70", 7));
        assertTrue(checker.hexStringIsWithinBounds("7F", 7));
        assertFalse(checker.hexStringIsWithinBounds("100", 7));
    }
}
