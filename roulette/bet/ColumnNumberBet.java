package roulette.bet;

import roulette.player.Player;
import roulette.Slot;

import java.util.ArrayList;
import java.util.List;

public class ColumnNumberBet extends Bet {

    public ColumnNumberBet(Player player, int amount, int column) {
        // @TODO guard condition
        super(player, amount);
        List<Slot> slots = new ArrayList<>();
        if (column == 1) {
            for (int i = column; i <= Slot.MAX_SLOT_VALUE; i += 3) {
                slots.add(new Slot(i));
            }
        } else if (column == 2) {
            for (int i = column; i <= Slot.MAX_SLOT_VALUE; i += 3) {
                slots.add(new Slot(i));
            }
        } else {
            for (int i = 3; i <= Slot.MAX_SLOT_VALUE; i += 3) {
                slots.add(new Slot(i));
            }
        }
        this.setBettedSlots(slots);
    }

}
