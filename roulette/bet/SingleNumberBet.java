package roulette.bet;

import roulette.player.Player;
import roulette.Slot;
import roulette.bet.Bet;

import java.util.Arrays;

public class SingleNumberBet extends Bet {

    public SingleNumberBet(Player player, int amount, Slot slot) {
        super(player, amount, Arrays.asList(slot));
        if (player == null) throw new IllegalArgumentException("You must have a player");
        if (amount <= 0) throw new IllegalArgumentException("You have to place a bet");
        if (slot == null) throw new IllegalArgumentException("You have to choose to what point");
    }

}
