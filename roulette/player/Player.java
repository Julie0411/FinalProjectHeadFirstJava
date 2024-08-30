package roulette.player;

import roulette.bet.Bet;
import roulette.bet.BetStrategy;
import roulette.bet.EmptyBetStrategy;

import java.util.Objects;

public class Player {
    private String name;
    private long prize;
    private boolean bankrupt;
    private BetStrategy initialStrategy;
    private BetStrategy strategy;

    public Player(String name, BetStrategy betStrategy) {
        this.strategy = betStrategy;
        this.name = name;
        this.prize = 100;
        this.bankrupt = false;
        this.initialStrategy = betStrategy;
    }

    public boolean isBankrupt() {
        return bankrupt;
    }

    public void resetPrize() {
        this.prize = 0;
    }

    public void reset(){
        this.prize = 100;
        this.bankrupt = false;
        this.strategy = this.initialStrategy;
    }

    public void takeMoney(int amount) {
        this.prize += amount;
        if (prize < 0) {
            bankrupt = true;
        }
    }

    public Bet placeBet() {
        if (prize <= 0 && !bankrupt) {
            bankrupt = true;
            this.strategy = new EmptyBetStrategy();
        }
        Bet bet = this.strategy.selectBet(this);
        this.prize -= bet.bettedAmount();
        if (prize < 0) {
            bankrupt = true;
        }
        return bet;
    }

    public long getPrize() {
        return prize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public String toString() {
        return "Player {" +
                "name = '" + this.name + '\'' + " " +
                "Strategy = '" + initialStrategy.getClass().getSimpleName() + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
