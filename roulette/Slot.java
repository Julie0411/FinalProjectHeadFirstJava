package roulette;

public class Slot {
    public final static int MAX_SLOT_VALUE = 36;

    public Slot(Integer number) {
        //@TODO guard condition
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Slot slot = (Slot) o;
        return number == slot.number;
    }

    private final int number;

}
