package roulette.bet;

import roulette.Slot;
import roulette.player.Player;

public class SingleNumberBetStrategy implements BetStrategy {
    private Slot bettedSlot;

    public SingleNumberBetStrategy(Slot bettedSlot) {
        this.bettedSlot = bettedSlot;
    }

    @Override
    public Bet selectBet(Player player) {
        SingleNumberBet singleNumberBet = new SingleNumberBet(player, FIXED_BET_AMOUNT, this.bettedSlot);
        return singleNumberBet;
    }
}
