package roulette.bet;

import roulette.player.Player;
import roulette.Slot;
import roulette.bet.Bet;

import java.util.ArrayList;
import java.util.List;

public class ColorBet extends Bet {

    public enum Color {

        GREEN,
        RED,
        BLACK;

    }

    public ColorBet(Player player, int amount, Color color) {
        super(player, amount);
        this.setBettedSlots(fillSlot(color));
    }

    private static List<Slot> fillSlot(Color color) {
        List<Slot> slots = new ArrayList<>();
        if (color == Color.GREEN) {
            slots.add(new Slot(0));
        } else {
            for (int i = 1; i <= Slot.MAX_SLOT_VALUE; i++) {
                if (color == Color.RED) {
                    if (i % 2 == 1) slots.add(new Slot(i));
                } else { // Color.BLACK
                    if (i % 2 == 0) slots.add(new Slot(i));
                }
            }
        }
        return slots;
    }

}
