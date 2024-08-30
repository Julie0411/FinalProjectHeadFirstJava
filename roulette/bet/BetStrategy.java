package roulette.bet;

import roulette.player.Player;

public interface BetStrategy {
    public final int FIXED_BET_AMOUNT = 1;
    public Bet selectBet(Player player);
}
