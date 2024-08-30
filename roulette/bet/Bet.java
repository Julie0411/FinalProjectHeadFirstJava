package roulette.bet;

import roulette.player.Player;
import roulette.Slot;

import java.util.List;

public class Bet {

    private Player player;
    private int amount;
    protected List<Slot> bettedSlots;

    public Bet(Player player, int amount, List<Slot> slots) {
        this(player, amount);
        if (slots == null || slots.isEmpty()) throw new IllegalArgumentException("You have to choose to what point");
        this.bettedSlots = slots;
    }

    public Bet(Player player, int amount) {
        if (player == null) throw new IllegalArgumentException("the player can't be null");
        if (amount < 0) throw new IllegalArgumentException("You have to place a bet");
        this.player = player;
        this.amount = amount;
    }

    public int bettedAmount(){
        return amount;
    }
    public boolean isWinning(Slot extractedSlot) {
        if (extractedSlot == null)
            throw new IllegalArgumentException("extracted Slot can't be null, you have to extract one!");
        checkSlotSet();
        for (Slot s : this.bettedSlots) {
            if (s.equals(extractedSlot)) return true;
        }
        return false;
    }

    public void cashIn() {
        this.player.takeMoney(this.prize());
    }

    public int prize() {
        checkSlotSet();
        return this.amount * (Slot.MAX_SLOT_VALUE / this.bettedSlots.size());
    }

    protected void checkSlotSet() {
        if (this.bettedSlots == null || this.bettedSlots.isEmpty())
            throw new IllegalArgumentException("You have to make a point");
    }

    public void setBettedSlots(List<Slot> slots) {
        this.bettedSlots = slots;
    }
}
