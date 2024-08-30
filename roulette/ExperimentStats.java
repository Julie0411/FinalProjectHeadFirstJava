package roulette;

import roulette.player.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ExperimentStats {
    private Player[] players;

    // postion on list represents the manche
    // position on array represents player
    private List<long[]> results;

    private List<boolean[]> bankruptPlayers;
    public ExperimentStats(Player... players) {
        this.players = players;
        this.results = new ArrayList<>();
        this.bankruptPlayers = new ArrayList<>();
    }

    private void addMancheResult(long[] mancheResult) {
        this.results.add(mancheResult);
    }

    public void collectManchesResults(){
        // gather results
        long[] prizes = new long[players.length];
        int countPlayer = 0;

        for(Player p : players){
            prizes[countPlayer] = p.getPrize();
            countPlayer++;
        }
        this.addMancheResult(prizes);

        boolean[] bankrupts = new boolean[players.length];
        for (int i = 0; i < players.length; i++) {
             bankrupts[i] = players[i].isBankrupt();
        }
        this.bankruptPlayers.add(bankrupts);

    }

    public Map<Player, Integer> winsPerPlayer() {
        Map<Player, Integer> winsPerPlayer = new HashMap<>();
        this.initMap(winsPerPlayer, players);

        for (long[] mancheResult : results) {
            Player winner = this.winner(players, mancheResult);
            this.addAWinToPlayer(winsPerPlayer, winner);
        }

        return winsPerPlayer;
    }

    // inizializza la mappa in modo che contenga una entry per ogni player e il valore corrispondente sia 0;
    private void initMap(Map<Player, Integer> map, Player[] players){
        for (Player p : players) {
            map.put(p, 0);
        }
    }
    // devi trovar l'elemento corrispondete al vincitore nella map  incrementare di uno il valore corrispondente.
    private void addAWinToPlayer(Map<Player, Integer> winsPerPlayer, Player winner) {

        int currentValue = winsPerPlayer.get(winner);
        currentValue++;

        winsPerPlayer.put(winner, currentValue);
    }

    private Player winner(Player[] players, long[] mancheResult) {
        return players[findIndexOfMax(mancheResult)];
    }

    protected int findIndexOfMax(long[] value) {
         int indexOfMax = 0;
         for (int i = 0; i < value.length; i++) {
             if (value[i] > value[indexOfMax]) {
                 indexOfMax = i;
             }
         }
         return indexOfMax;
    }

    public void printWinsPerPlayer() {

        Map<Player, Integer> winsPerPlayer = winsPerPlayer();

        for (Player key : winsPerPlayer.keySet()) {
            String playerName = key.toString();
            int win = winsPerPlayer.get(key);

            System.out.println("Player " + playerName +  " won " + win + " manches.");
        }

    }

    public void printAveragePrizePerPlayer() {

        Map<Player, Long> averagePrizePerPlayer = averagePrizePerPlayer();

        for (Player key : averagePrizePerPlayer.keySet()) {
            String playerName = key.toString();
            long average = averagePrizePerPlayer.get(key);

            System.out.println("Player " + playerName +  " has an average prize of " + average + " chf.");
        }

    }

    public void printBankruptPerPlayer() {

        Map<Player, Integer> bankruptPerPlayer = bankruptPerPlayer();

        for (Player key : bankruptPerPlayer.keySet()) {
            String playerName = key.toString();
            int bankrupts = bankruptPerPlayer.get(key);

            System.out.println("Player " + playerName +  " went bankrupt " + bankrupts + " times.");
        }

    }

    public Map<Player, Long> averagePrizePerPlayer() {

        Map <Player,Long> averages = new HashMap<>();

        long sum = 0;
        long average = 0;

        for (int j = 0; j < players.length; j++) {

            Player currentPlayer = players[j];

            for (long[] result : results) {
                sum += result[j];
                average = sum / results.size();
            }

            averages.put(currentPlayer, average);
            sum = 0;
            average = 0;

        }

        return averages;

    }

    public Map<Player, Integer> bankruptPerPlayer() {

        Map<Player, Integer> bankrupts = new HashMap<>();

        for (int i = 0; i < players.length; i++) {

            Player currentPlayer = players[i];
            int numberOfBankrupt = 0;

            for (boolean[] bankruptPerManche : bankruptPlayers) {
                if (bankruptPerManche[i]) {
                    numberOfBankrupt++;
                }
            }

            bankrupts.put(currentPlayer, numberOfBankrupt);
        }

        return bankrupts;

    }

}
