package io.github.drewhans555.pr0ca1;

public class Pr0Calculator {
    private Pr0Mode inputMode;
    private Pr0Operation operationSelected;
    private Pr0Number previousNumber;
    private Pr0Number currentNumber;
    private ArithmeticOperator arithmeticOperator;
    private BooleanLogicOperator booleanLogicOperator;

    public Pr0Calculator(int bitState, boolean signState, Pr0Mode inputState) {
        arithmeticOperator = new ArithmeticOperator();
        booleanLogicOperator = new BooleanLogicOperator();
        previousNumber = new Pr0Number(bitState, signState);
        currentNumber = new Pr0Number(bitState, signState);
        inputMode = inputState;
        operationSelected = Pr0Operation.NONE;
    }

    public Pr0Number getCurrentNumber() {
        return currentNumber;
    }

    public Pr0Number getPreviousNumber() {
        return previousNumber;
    }

    public void press0Button() {
        tryAppendToCurrentNumber("0");
    }

    public void press1Button() {
        tryAppendToCurrentNumber("1");
    }

    public void press2Button() {
        tryAppendToCurrentNumber("2");
    }

    public void press3Button() {
        tryAppendToCurrentNumber("3");
    }

    public void press4Button() {
        tryAppendToCurrentNumber("4");
    }

    public void press5Button() {
        tryAppendToCurrentNumber("5");
    }

    public void press6Button() {
        tryAppendToCurrentNumber("6");
    }

    public void press7Button() {
        tryAppendToCurrentNumber("7");
    }

    public void press8Button() {
        tryAppendToCurrentNumber("8");
    }

    public void press9Button() {
        tryAppendToCurrentNumber("9");
    }

    public void pressAButton() {
        tryAppendToCurrentNumber("A");
    }

    public void pressBButton() {
        tryAppendToCurrentNumber("B");
    }

    public void pressCButton() {
        tryAppendToCurrentNumber("C");
    }

    public void pressDButton() {
        tryAppendToCurrentNumber("D");
    }

    public void pressEButton() {
        tryAppendToCurrentNumber("E");
    }

    public void pressFButton() {
        tryAppendToCurrentNumber("F");
    }

    public void pressNotButton() throws NumberOutOfModeBoundsException, IllegalArgumentException {
        if (currentNumber.getBinValue().isEmpty()) {
            operationSelected = Pr0Operation.NONE;
            return;
        }

        currentNumber.setBinValue(booleanLogicOperator.not(Pr0Number.getBitPrecision(), currentNumber.getBinValue()));
        operationSelected = Pr0Operation.NONE;
        previousNumber.clearValues();
    }

    public void pressAndButton() throws Exception {
        handleLingeringOperation();
        operationSelected = Pr0Operation.AND;
        previousNumber.copyPr0Number(currentNumber);
        currentNumber.clearValues();
    }

    public void pressOrButton() throws Exception {
        handleLingeringOperation();
        operationSelected = Pr0Operation.OR;
        previousNumber.copyPr0Number(currentNumber);
        currentNumber.clearValues();
    }

    public void pressXorButton() throws Exception {
        handleLingeringOperation();
        operationSelected = Pr0Operation.XOR;
        previousNumber.copyPr0Number(currentNumber);
        currentNumber.clearValues();
    }

    public void pressNandButton() throws Exception {
        handleLingeringOperation();
        operationSelected = Pr0Operation.NAND;
        previousNumber.copyPr0Number(currentNumber);
        currentNumber.clearValues();
    }

    public void pressNorButton() throws Exception {
        handleLingeringOperation();
        operationSelected = Pr0Operation.NOR;
        previousNumber.copyPr0Number(currentNumber);
        currentNumber.clearValues();
    }

    public void pressXnorButton() throws Exception {
        handleLingeringOperation();
        operationSelected = Pr0Operation.XNOR;
        previousNumber.copyPr0Number(currentNumber);
        currentNumber.clearValues();
    }

    public void pressAddButton() throws Exception {
        handleLingeringOperation();
        operationSelected = Pr0Operation.ADD;
        previousNumber.copyPr0Number(currentNumber);
        currentNumber.clearValues();
    }

    public void pressSubtractButton() throws Exception {
        handleLingeringOperation();
        operationSelected = Pr0Operation.SUB;
        previousNumber.copyPr0Number(currentNumber);
        currentNumber.clearValues();
    }

    public void pressMultiplyButton() throws Exception {
        handleLingeringOperation();
        operationSelected = Pr0Operation.MUL;
        previousNumber.copyPr0Number(currentNumber);
        currentNumber.clearValues();
    }

    public void pressDivideButton() throws Exception {
        handleLingeringOperation();
        operationSelected = Pr0Operation.DIV;
        previousNumber.copyPr0Number(currentNumber);
        currentNumber.clearValues();
    }

    public void pressModButton() throws Exception {
        handleLingeringOperation();
        operationSelected = Pr0Operation.MOD;
        previousNumber.copyPr0Number(currentNumber);
        currentNumber.clearValues();
    }

    public void pressEqualButton() throws Exception {
        tryPerformOperation();
    }

    public void pressAcButton() {
        reset();
    }

    public void pressDeleteButton() throws Exception {
        try {
            if (inputMode == Pr0Mode.BIN) {
                currentNumber.deAppendBinValue();
            } else if (inputMode == Pr0Mode.OCT) {
                currentNumber.deAppendOctValue();
            } else if (inputMode == Pr0Mode.DEC) {
                currentNumber.deAppendDecValue();
            } else if (inputMode == Pr0Mode.HEX) {
                currentNumber.deAppendHexValue();
            }
        } catch (Exception e) {
            reset();
            throw e;
        }
    }

    public void reset() {
        operationSelected = Pr0Operation.NONE;
        currentNumber.clearValues();
        previousNumber.clearValues();
    }

    public void setInputMode(Pr0Mode newInputMode) {
        inputMode = newInputMode;
    }

    public void updateState(int newBitState, boolean newSignState) {
        Pr0Number.updateState(newBitState, newSignState);
        operationSelected = Pr0Operation.NONE;
        currentNumber.clearValues();
        previousNumber.clearValues();
    }

    private void appendToCurrentNumber(String numberValue) throws NumberOutOfModeBoundsException {
        String legalBinInputs = "01";
        String legalOctInputs = "01234567";
        String legalDecInputs = "0123456789";
        String legalHexInputs = "0123456789ABCDEF";

        if (inputMode == Pr0Mode.BIN && legalBinInputs.contains(numberValue)) {
            currentNumber.appendBinValue(numberValue);
        } else if (inputMode == Pr0Mode.OCT && legalOctInputs.contains(numberValue)) {
            currentNumber.appendOctValue(numberValue);
        } else if (inputMode == Pr0Mode.DEC && legalDecInputs.contains(numberValue)) {
            currentNumber.appendDecValue(numberValue);
        } else if (inputMode == Pr0Mode.HEX && legalHexInputs.contains(numberValue)) {
            currentNumber.appendHexValue(numberValue);
        }
    }

    private void tryAppendToCurrentNumber(String numberValue) {
        try {
            appendToCurrentNumber(numberValue);
        } catch (Exception e) {
            //do nothing, let them continue pressing buttons in vain
        }
    }

    private void performOperation() throws NumberOutOfModeBoundsException, IllegalArgumentException {
        if (operationSelected == null || operationSelected == Pr0Operation.NONE ) {
            return;
        }
        if (previousNumber.getBinValue().isEmpty() && currentNumber.getBinValue().isEmpty()) {
            operationSelected = Pr0Operation.NONE;
            return;
        }

        if (operationSelected == Pr0Operation.AND) {
            currentNumber.setBinValue(booleanLogicOperator.and(previousNumber.getBinValue(), currentNumber.getBinValue()));
        } else if (operationSelected == Pr0Operation.OR) {
            currentNumber.setBinValue(booleanLogicOperator.or(previousNumber.getBinValue(), currentNumber.getBinValue()));
        } else if (operationSelected == Pr0Operation.XOR) {
            currentNumber.setBinValue(booleanLogicOperator.xor(previousNumber.getBinValue(), currentNumber.getBinValue()));
        } else if (operationSelected == Pr0Operation.NAND) {
            currentNumber.setBinValue(booleanLogicOperator.nand(Pr0Number.getBitPrecision(), previousNumber.getBinValue(), currentNumber.getBinValue()));
        } else if (operationSelected == Pr0Operation.NOR) {
            currentNumber.setBinValue(booleanLogicOperator.nor(Pr0Number.getBitPrecision(), previousNumber.getBinValue(), currentNumber.getBinValue()));
        } else if (operationSelected == Pr0Operation.XNOR) {
            currentNumber.setBinValue(booleanLogicOperator.xnor(Pr0Number.getBitPrecision(), previousNumber.getBinValue(), currentNumber.getBinValue()));
        } else if (operationSelected == Pr0Operation.ADD) {
            currentNumber.setDecValue(arithmeticOperator.add(previousNumber.getDecValue(), currentNumber.getDecValue()));
        } else if (operationSelected == Pr0Operation.SUB) {
            currentNumber.setDecValue(arithmeticOperator.sub(previousNumber.getDecValue(), currentNumber.getDecValue()));
        } else if (operationSelected == Pr0Operation.MUL) {
            currentNumber.setDecValue(arithmeticOperator.mul(previousNumber.getDecValue(), currentNumber.getDecValue()));
        } else if (operationSelected == Pr0Operation.DIV) {
            currentNumber.setDecValue(arithmeticOperator.div(previousNumber.getDecValue(), currentNumber.getDecValue()));
        } else if (operationSelected == Pr0Operation.MOD) {
            currentNumber.setDecValue(arithmeticOperator.mod(previousNumber.getDecValue(), currentNumber.getDecValue()));
        } else {
            // some unexpected operation was set
            reset();
        }
        operationSelected = Pr0Operation.NONE;
        previousNumber.clearValues();
    }

    private void tryPerformOperation() throws Exception {
        try {
            performOperation();
            operationSelected = Pr0Operation.NONE;
            previousNumber.clearValues();
        } catch (NumberOutOfModeBoundsException iae) {
            reset();
            throw new Exception("NumberOutOfModeBoundsException thrown. Calculator will now be reset.");
        } catch (IllegalArgumentException iae) {
            reset();
            throw new Exception("IllegalArgumentException thrown. Calculator will now be reset.");
        } catch (Exception e) {
            reset();
            throw e;
        }
    }

    private void handleLingeringOperation() throws Exception {
        if (operationSelected != null && operationSelected != Pr0Operation.NONE) {
            pressEqualButton();
        }
    }

}
