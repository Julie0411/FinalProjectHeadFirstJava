package roulette;

class RandomNumberPicker implements NumberPicker {

    @Override
    public int pickNumber(int range) {
        return (int) Math.round((Math.random() * range));
    }

}
