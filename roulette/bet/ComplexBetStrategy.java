package roulette.bet;

import roulette.player.Player;

public class ComplexBetStrategy implements BetStrategy {
    private final int dozen;
    private final ColorBet.Color bettedColor;
    private boolean placeDozen = false;

    public ComplexBetStrategy(int dozen, ColorBet.Color bettedColor) {
        this.dozen = dozen;
        this.bettedColor = bettedColor;
    }

    @Override
    public Bet selectBet(Player player) {

        Bet selectedBet = null;

        if (placeDozen) {
           selectedBet = new DozenBet(player, FIXED_BET_AMOUNT, this.dozen);
        } else {
           selectedBet = new ColorBet(player, FIXED_BET_AMOUNT, this.bettedColor);
        }

        placeDozen = !placeDozen;

        return selectedBet;

    }
}
