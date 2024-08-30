package roulette;

import java.util.*;

class Roulette {

    enum SupportedRoulettes{
        STANDARD, // only 0
        USA, // 0 and 00
        TEXAS // 0 and 00 and 000
        ;
    }
    private List<Slot> slots = new ArrayList<>();
    private NumberPicker numberPicker;

    public int getNumberOfSlot() {
        return slots.size();
    }

    public int getZeroCount() {
        return Collections.frequency(slots, new Slot(0));
    }

    public Roulette(SupportedRoulettes rouletteKind, NumberPicker numberPicker) {
        if (rouletteKind == null) throw new IllegalArgumentException("You have to choose a roulette");
        if (numberPicker == null) throw new IllegalArgumentException("You have to choose a number picker");
        this.numberPicker = numberPicker;
        for (int i = 0; i < 37; i++) {
            this.slots.add(new Slot(i));
        }
        if (rouletteKind == SupportedRoulettes.USA) {
            this.slots.add(new Slot(0));
        } else if (rouletteKind == SupportedRoulettes.TEXAS){
            this.slots.add(new Slot(0));
            this.slots.add(new Slot(0));
        }

    }

    public Roulette(SupportedRoulettes rouletteKind){
        this(rouletteKind, new RandomNumberPicker());
    }

    public Slot spin() {
        int slotIndex = numberPicker.pickNumber(slots.size()-1);
        return slots.get(slotIndex);
    }
}

