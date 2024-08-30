package roulette;

import roulette.bet.*;
import roulette.player.Player;

public class Main {
    private static final int MANCHES = 10000;
    private static final int RUN_PER_MANCHE = 1000;

    public static void main(String[] args) {

        BetStrategy betOnRed = new ColorBetStrategy(ColorBet.Color.RED);
        BetStrategy betOnBlack = new ColorBetStrategy(ColorBet.Color.BLACK);
        BetStrategy betOnASingleNumber = new SingleNumberBetStrategy(new Slot(18));
        BetStrategy betOnAColumn = new ColumnNumberBetStrategy(2);
        BetStrategy betOnADozen = new DozenBetStrategy(3);
        BetStrategy betOnColorAndDozen = new ComplexBetStrategy(1, ColorBet.Color.BLACK);

        Player fra = new Player("fra", betOnASingleNumber);
        Player bro = new Player("bro", betOnRed);
        Player fratm = new Player("fratm", betOnBlack);
        Player zio = new Player("zio", betOnAColumn);
        Player zia = new Player("zia", betOnADozen);
        Player sis = new Player("sis", betOnColorAndDozen);

        runSimulation(fra, bro, fratm, zio, zia, sis);

    }

    private static void runSimulation(Player... players) {
        Roulette roulette = new Roulette(Roulette.SupportedRoulettes.TEXAS);
        ExperimentStats stats = new ExperimentStats(players);
        Croupier croupier = new Croupier(roulette);

        for (Player p : players) croupier.registerPlayer(p);

        for (int i = 0; i < MANCHES; i++) {

            for (Player p : players) {
                p.reset();
            }


            runManche(croupier);
            stats.collectManchesResults();

        }

        System.out.println("----- wins per player -----");
        stats.printWinsPerPlayer();
        System.out.println("----- Average prize per player -----");
        stats.printAveragePrizePerPlayer();
        System.out.println("----- Bankrupts per player -----");
        stats.printBankruptPerPlayer();

    }
    private static void runManche(Croupier croupier) {

        for (int j = 0; j < RUN_PER_MANCHE; j++) {
            croupier.launchARun();
        }

    }

}
