package roulette.bet;

import roulette.player.Player;

public class EmptyBetStrategy implements BetStrategy {
    @Override
    public Bet selectBet(Player player) {
        return new EmptyBet(player);
    }

}
