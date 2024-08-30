package roulette.bet;

import roulette.player.Player;

public class DozenBetStrategy implements BetStrategy {
    private int dozen;

    public DozenBetStrategy(int dozen) {
        this.dozen = dozen;
    }

    @Override
    public Bet selectBet(Player player) {
        DozenBet dozenBet = new DozenBet(player, FIXED_BET_AMOUNT, this.dozen);
        return dozenBet;
    }
}
