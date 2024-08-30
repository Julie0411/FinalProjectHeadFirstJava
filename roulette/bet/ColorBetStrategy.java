package roulette.bet;

import roulette.player.Player;

public class ColorBetStrategy implements BetStrategy{
    private ColorBet.Color bettedColor;

    public ColorBetStrategy(ColorBet.Color bettedColor) {
        this.bettedColor = bettedColor;
    }

    @Override
    public Bet selectBet(Player player) {
        ColorBet colorBet = new ColorBet(player, BetStrategy.FIXED_BET_AMOUNT, this.bettedColor);
        return colorBet;
    }
}
