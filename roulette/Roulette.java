package roulette;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

abstract class Player{
    private String name;

    public abstract Bet placeBet();
}

abstract class Bet {

    private Player player;
    protected int amount;
    protected List<Slot> bettedSlots;

    public Bet(Player player, int amount, List<Slot> slots) {
        this(player,amount);
        if (bettedSlots == null || bettedSlots.isEmpty()) throw new RuntimeException("You have to choose to what point");
        this.bettedSlots = slots;
    }
    public Bet(Player player, int amount) {
        if (player == null) throw new RuntimeException("the player can't be null");
        if (amount < 0) throw new RuntimeException("You have to place a bet");
        this.player = player;
        this.amount = amount;

    }

    boolean isWinning(Slot extractedSlot) {
        if (extractedSlot == null) throw new RuntimeException("extracted Slot can't be null, you have to extract one!");
        checkSlotSet();
        for (Slot s:this.bettedSlots) {
            if (s.equals(extractedSlot))return true;
        }
        return false;
    }

    protected int prize() {
        checkSlotSet();
        return this.amount * (Slot.MAX_SLOT_VALUE/this.bettedSlots.size());
    }

    protected void checkSlotSet() {
        if (this.bettedSlots!=null && !this.bettedSlots.isEmpty()) throw new RuntimeException("You have to choose to what point");
    }
    protected void setBettedSlots(List<Slot> bettedSlots){
        this.bettedSlots = bettedSlots;
    }
}

class SingleNumberBet extends Bet{

    public SingleNumberBet(Player player, int amount, Slot slot) {
        // @TODO guard condition
        super(player, amount, Arrays.asList(slot));
    }

}

class ColumnNumberBet extends Bet{

    public ColumnNumberBet(Player player, int amount, int column) {
        // @TODO guard condition
        super(player, amount);
        List<Slot> slots = new ArrayList<>();
        for (int i = column; i <= Slot.MAX_SLOT_VALUE; i++){
            slots.add(new Slot(i));
        }
        this.setBettedSlots(slots);
    }

}

class DozenBet extends Bet{
    public DozenBet(Player player, int amount, int dozen) {
        super(player, amount);
        if (dozen < 1 || dozen > 3) throw new RuntimeException("Dozen is invalid");
        List<Slot> slots = new ArrayList<>();
        for (int i = 12 * (dozen - 1) + 1; i <= 12 * dozen; i++) {
            slots.add(new Slot(i));
        }
        this.setBettedSlots(slots);
    }

}

class ColorBet extends Bet {

    enum Color{

        GREEN,
        RED,
        BLACK;

    }
    public ColorBet(Player player, int amount, Color color) {
        super(player, amount);
        this.setBettedSlots(fillSlot(color));
    }

    private static List<Slot> fillSlot(Color color){
        List<Slot> slots = new ArrayList<>();
        if (color == Color.GREEN){
            slots.add(new Slot(0));
        } else {
            for (int i = 1; i <= Slot.MAX_SLOT_VALUE; i++) {
                if (color == Color.RED){
                    if (i % 2 == 1)  slots.add(new Slot(i));

                }else{ // Color.BLACK
                    if (i % 2 == 0)  slots.add(new Slot(i));
                }
            }
        }
        return slots;
    }

}

class Slot{
    public static final int MAX_SLOT_VALUE = 36;
    public Slot(int number) {
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