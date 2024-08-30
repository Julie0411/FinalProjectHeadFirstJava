package roulette;

class FixedNumberPicker implements NumberPicker {

    private int fixedNumber;

    FixedNumberPicker(int fixedNumber) {
        this.fixedNumber = fixedNumber;
    }

    @Override
    public int pickNumber(int max) {
        return fixedNumber;
    }

}
