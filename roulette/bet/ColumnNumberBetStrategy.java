package roulette.bet;

import roulette.player.Player;

public class ColumnNumberBetStrategy implements BetStrategy {
    private int column;

    public ColumnNumberBetStrategy(int column) {
        this.column = column;
    }

    @Override
    public Bet selectBet(Player player) {
        ColumnNumberBet columnNumberBet = new ColumnNumberBet(player, FIXED_BET_AMOUNT, column);
        return columnNumberBet;
    }
}
