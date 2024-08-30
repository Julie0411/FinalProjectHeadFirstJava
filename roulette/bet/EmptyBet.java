package roulette.bet;

import roulette.Slot;
import roulette.player.Player;

import java.util.List;

public class EmptyBet extends Bet {

    public EmptyBet(Player player) {
        super(player, 0, List.of(new Slot(999)));
    }

}
