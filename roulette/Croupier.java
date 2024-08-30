package roulette;

import roulette.bet.Bet;
import roulette.player.Player;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Croupier {
    private Roulette roulette;
    private Set<Player> players = new HashSet<>();

    private Slot spinRoulette() {
        return this.roulette.spin();
    }

    public Croupier registerPlayer(Player p) {
        this.players.add(p);
        return this;
    }

    private List<Bet> collectBet(Set<Player> players) {
        List<Bet> bets = new ArrayList<>();

        for (Player p : players) {
            bets.add(p.placeBet());
        }
        return bets;
    }

    private void resolveRun(Slot winningSlot, List<Bet> bets) {
        for (Bet b : bets) {
            if (b.isWinning(winningSlot)) {
                b.cashIn();
            }
        }
    }

    public void launchARun() {
        List<Bet> bets = collectBet(this.players);
        Slot winningSlot = spinRoulette();
        resolveRun(winningSlot, bets);
    }

    public Croupier(Roulette roulette) {
        this.roulette = roulette;
    }
}
