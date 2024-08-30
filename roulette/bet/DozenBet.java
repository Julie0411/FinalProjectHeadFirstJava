package roulette.bet;

import roulette.player.Player;
import roulette.Slot;
import roulette.bet.Bet;

import java.util.ArrayList;
import java.util.List;

public class DozenBet extends Bet {
    public DozenBet(Player player, int amount, int dozen) {
        super(player, amount);
        if (dozen < 1 || dozen > 3) throw new IllegalArgumentException("Dozen is invalid");
        List<Slot> slots = new ArrayList<>();
        for (int i = 12 * (dozen - 1) + 1; i <= 12 * dozen; i++) {
            slots.add(new Slot(i));
        }
        this.setBettedSlots(slots);
    }

}
