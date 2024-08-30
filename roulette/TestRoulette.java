package roulette;

import roulette.bet.*;
import roulette.player.*;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class TestRoulette {
    Player emptyUnnamedPlayer = new Player("unnamed", new ColorBetStrategy(ColorBet.Color.RED));
    private static final int SOME_AMOUNT = 13;
    private static final int ONE = 1;
    private static final int NEGATIVE_AMOUNT = -1;

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {

        TestRoulette test = new TestRoulette();

        for (Method m: TestRoulette.class.getDeclaredMethods()){
            String name = m.getName();

            if (name.startsWith("test_")){
                System.out.println("executing " + name);
                m.invoke(test);
            }

        }

    }
    void test_bet_constructor_when_player_is_null_should_throw_RuntimeException(){

        try{
            Bet bet = new Bet(null, SOME_AMOUNT);
            fail();
        } catch(IllegalArgumentException ex){
            pass();
        }

    }
    void test_bet_constructor_when_amount_is_negative_should_throw_RuntimeException(){

        try {
            Bet bet = new Bet(emptyUnnamedPlayer, NEGATIVE_AMOUNT);
            fail();
        } catch(IllegalArgumentException ex){
            pass();
        }

    }
    void test_bet_constructor_when_amount_is_negative_and_player_is_null_should_throw_RuntimeException() {

        try {
            Bet bet = new Bet(null, NEGATIVE_AMOUNT);
            fail();
        } catch (IllegalArgumentException ex) {
            pass();
        }

    }
    void test_bet_constructor_when_amount_is_one_and_player_is_not_null_should_pass() {

        try {
            Bet bet = new Bet(emptyUnnamedPlayer, ONE);
            pass();
        } catch(IllegalArgumentException ex){
            fail();
        }

    }
    void test_bet_constructor_when_betted_slots_is_null_should_throw_RuntimeException() {

        try {
            Bet bet = new Bet(emptyUnnamedPlayer, SOME_AMOUNT, null);
            fail();
        } catch (IllegalArgumentException ex) {
            pass();
        }

    }

    void test_bet_constructor_when_betted_slots_is_empty_should_throw_RuntimeException() {

        try {
            Bet bet = new Bet(emptyUnnamedPlayer, SOME_AMOUNT, Collections.emptyList());
            fail();
        } catch (IllegalArgumentException ex) {
            pass();
        }

    }
    void test_bet_constructor_when_amount_is_one_and_player_is_not_null_and_betted_slots_is_not_null_or_empty_should_pass() {

        try {
            Bet bet = new Bet(emptyUnnamedPlayer, ONE, new ArrayList<>(8));
            fail();
        } catch (IllegalArgumentException ex) {
            pass();
        }

    }
    void test_is_winning_when_extractedSlot_is_null_should_throw_RuntimeException() {

        Bet bet = new Bet(emptyUnnamedPlayer, SOME_AMOUNT);
        try {
            bet.isWinning(null);
            fail();
        } catch (IllegalArgumentException ex) {
            pass();
        }

    }
    void test_is_winning_when_bettedSlot_is_empty_should_throw_RuntimeException() {

        Slot extractedSlot =  new Slot(1);
        Bet bet = new Bet(emptyUnnamedPlayer, SOME_AMOUNT);
        bet.setBettedSlots(Collections.emptyList());
        try {
            bet.isWinning(extractedSlot);
            fail();
        } catch (IllegalArgumentException ex) {
            pass();
        }

    }
    void test_is_winning_when_bettedSlot_is_null_should_throw_RuntimeException() {

        Slot extractedSlot = new Slot(1);
        Bet bet = new Bet(emptyUnnamedPlayer, SOME_AMOUNT);
        try {
            bet.isWinning(extractedSlot);
            fail();
        } catch (IllegalArgumentException ex) {
            pass();
        }

    }
    void test_is_winning_when_extractedSlot_is_in_my_bet_should_return_true() {

        Slot extractedSlot = new Slot(1);

        Slot bettedSlot = new Slot(1);
        Bet bet = new Bet(emptyUnnamedPlayer, SOME_AMOUNT, List.of(bettedSlot));

        if (bet.isWinning(extractedSlot)){
            pass();
        } else {
            fail();
        }

    }
    void test_is_winning_when_extractedSlot_is_not_in_my_bet_should_return_false() {

        Slot extractedSlot = new Slot(1);

        Slot bettedSlot = new Slot(2);
        Bet bet = new Bet(emptyUnnamedPlayer, SOME_AMOUNT, List.of(bettedSlot));

        if (bet.isWinning(extractedSlot)){
            fail();
        } else {
            pass();
        }

    }
    void test_prize_when_you_bet_on_one_slot_the_prize_should_be_36_times_the_amount() {

        Bet bet = new Bet(emptyUnnamedPlayer, SOME_AMOUNT, List.of(new Slot(8)));

        if (bet.prize() == bet.bettedAmount() * 36){
            pass();
        } else {
            fail();
        }

    }
    void test_prize_when_you_bet_on_a_row_the_prize_should_be_3_times_the_amount() {

        ColumnNumberBet columnNumberBet = new ColumnNumberBet(emptyUnnamedPlayer, SOME_AMOUNT, 1);

        if (columnNumberBet.prize() == columnNumberBet.bettedAmount() * 3) {
            pass();
        } else {
            fail();
        }

    }
    void test_prize_when_you_bet_on_a_dozen_the_prize_should_be_3_times_the_amount() {

        DozenBet dozenBet = new DozenBet(emptyUnnamedPlayer, SOME_AMOUNT, 2);

        if (dozenBet.prize() == dozenBet.bettedAmount() * 3) {
            pass();
        } else {
            fail();
        }

    }
    void test_prize_when_you_bet_on_a_red_or_black_the_prize_should_be_2_times_the_amount() {

        ColorBet colorBet = new ColorBet(emptyUnnamedPlayer, SOME_AMOUNT, ColorBet.Color.RED);
        ColorBet colorBet1 = new ColorBet(emptyUnnamedPlayer, SOME_AMOUNT, ColorBet.Color.BLACK);

        if (colorBet.prize() == colorBet.bettedAmount() * 2) {
            pass();
        } else {
            fail();
        }

        if (colorBet1.prize() == colorBet.bettedAmount() * 2) {
            pass();
        } else {
            fail();
        }

    }
    void test_prize_when_you_bet_on_green_the_prize_should_be_36_times_the_amount() {

        ColorBet colorBet = new ColorBet(emptyUnnamedPlayer, SOME_AMOUNT, ColorBet.Color.GREEN);

        if (colorBet.prize() == SOME_AMOUNT * 36){
            pass();
        } else {
            fail();
        }

    }
    void test_Roulette_when_rouletteKind_is_null_should_throw_illegal_argument_exception() {

        try{
            new Roulette(null);
            fail();
        } catch(IllegalArgumentException ex){
            pass();
        }

    }
    void test_Roulette_when_numberPicker_is_null_should_throw_illegal_argument_exception() {

        try {
            new Roulette(Roulette.SupportedRoulettes.STANDARD, null);
            fail();
        } catch(IllegalArgumentException ex){
            pass();
        }

    }
    void test_Roulette_when_is_standard_slots_size_should_be_37() {

        Roulette roulette = new Roulette(Roulette.SupportedRoulettes.STANDARD);

        if (roulette.getNumberOfSlot() == 37) {
            pass();
        } else {
            fail();
        }

    }
    void test_Roulette_when_is_USA_slots_size_should_be_38() {

        Roulette roulette = new Roulette(Roulette.SupportedRoulettes.USA);

        if (roulette.getNumberOfSlot() == 38) {
            pass();
        } else {
            fail();
        }

    }
    void test_Roulette_when_is_texas_slots_size_should_be_39() {

        Roulette roulette = new Roulette(Roulette.SupportedRoulettes.TEXAS);

        if (roulette.getNumberOfSlot() == 39) {
            pass();
        } else {
            fail();
        }

    }

    void test_Roulette_a_standard_roulette_should_have_a_zero() {

        Roulette roulette = new Roulette(Roulette.SupportedRoulettes.STANDARD);

        if (roulette.getZeroCount() == 1) {
            pass();
        } else {
            fail();
        }

    }
    void test_Roulette_a_USA_roulette_should_have_two_zeros() {

        Roulette roulette = new Roulette(Roulette.SupportedRoulettes.USA);

        if (roulette.getZeroCount() == 2) {
            pass();
        } else {
            fail();
        }

    }
    void test_Roulette_a_Texas_roulette_should_have_three_zeros() {

        Roulette roulette = new Roulette(Roulette.SupportedRoulettes.TEXAS);

        if (roulette.getZeroCount() == 3) {
            pass();
        } else {
            fail();
        }

    }
    void test_spin_when_you_give_an_index_it_should_return_the_selected_slot() {

        int expextedSlotNumber = 8;

        Roulette roulette = new Roulette(Roulette.SupportedRoulettes.STANDARD, new FixedNumberPicker(expextedSlotNumber));

        Slot expectedSlot = new Slot(expextedSlotNumber);
        if (roulette.spin().equals(expectedSlot) ) {
            pass();
        } else {
            fail();
        }

    }
    void test_RandomNumberPicker_pickNumber_when_invoked_1000_times_should_return_a_number_in_the_range() {

        for (int i = 0; i < 1000; i++) {

            int range = 36;
            NumberPicker randomNumberPicker = new RandomNumberPicker();
            int number = randomNumberPicker.pickNumber(range);

            if (number < 0 || number > range) {
                fail();
            }
        }

        pass();

    }
    void test_findIndexOfMax_when_gived_an_array_of_int_should_return_the_index_of_the_greater_number_in_the_range() {

        ExperimentStats experimentStats = new ExperimentStats();

        long[] exampleArray = {1, 2, 3, 4, 5, 6};
        long[] exampleArray1 = {1, 2, 4, 8, 5, 3};
        long[] exampleArray2 = {1, 2, 6, 4, 5, 6};
        int findIndexOfMax = experimentStats.findIndexOfMax(exampleArray);
        int findIndexOfMax1 = experimentStats.findIndexOfMax(exampleArray1);
        int findIndexOfMax2 = experimentStats.findIndexOfMax(exampleArray2);

        if (findIndexOfMax == 5 && findIndexOfMax1 == 3 && findIndexOfMax2 == 2) {
            pass();
        } else {
            fail();
        }

    }

    void test_winsPerPlayer_when_called_should_give_an_empty_map() {

        ExperimentStats experimentStats = new ExperimentStats();

        Map<Player, Integer> winsPerPlayer = experimentStats.winsPerPlayer();

        if (winsPerPlayer.isEmpty()) {
            pass();
        } else {
            fail();
        }

    }

    void test_winsPerPlayer_when_called_should_return_a_map_with_an_entry_for_each_player_with_the_manches_won_by_it() {

        //setup

        Player alice = new Player("alice",new ColorBetStrategy(ColorBet.Color.RED));
        Player bob = new Player("bob",new ColorBetStrategy(ColorBet.Color.RED));
        int numberOfPlayer = 2;

        ExperimentStats experimentStats = new ExperimentStats(alice, bob);
        alice.takeMoney(4);
        bob.takeMoney(5);
        experimentStats.collectManchesResults();

        alice.takeMoney(4);
        bob.takeMoney(7);
        experimentStats.collectManchesResults();

        // execution
        Map<Player, Integer> winsPerPlayer = experimentStats.winsPerPlayer();

        // assertion
        if (winsPerPlayer.containsKey(alice)) {
            pass();
        } else {
            fail();
        }

        if (winsPerPlayer.containsKey(bob)) {
            pass();
        } else {
            fail();
        }

        if (winsPerPlayer.get(alice) == 0) {
            pass();
        } else {
            fail();
        }

        if (winsPerPlayer.get(bob) == 2) {
            pass();
        } else {
            fail();
        }

        if (winsPerPlayer.size() == numberOfPlayer) {
            pass();
        } else {
            fail();
        }

    }

    void test_winsPerPlayer_when_draw_should_win_the_first_player() {

        //setup
        Player alice = new Player("alice", new ColorBetStrategy(ColorBet.Color.RED));
        Player bob = new Player("bob", new ColorBetStrategy(ColorBet.Color.RED));

        ExperimentStats experimentStats = new ExperimentStats(alice, bob);
        alice.takeMoney(5);
        bob.takeMoney(5);
        experimentStats.collectManchesResults();

        // execution
        Map<Player, Integer> winsPerPlayer = experimentStats.winsPerPlayer();

        // assertion
        if (winsPerPlayer.get(alice) == 1) {
            pass();
        } else {
            fail();
        }

        if (winsPerPlayer.get(bob) == 0) {
            pass();
        } else {
            fail();
        }

    }

    void test_player_placeBet_when_bet_on_something_prize_should_decrese_by_one() {

        Player alice = new Player("Alice", new ColorBetStrategy(ColorBet.Color.BLACK));

        long initialPrize = alice.getPrize();

        alice.placeBet();

        long prizeAfterBet = alice.getPrize();

        if (prizeAfterBet-initialPrize == -1) {
            pass();
        } else {
            fail();
        }

    }

    public void test_averagePrizePerPlayer_should_return_correct_averages() {

        Player alice = new Player("Alice", new ColorBetStrategy(ColorBet.Color.BLACK));
        Player bob = new Player("Bob", new ColorBetStrategy(ColorBet.Color.BLACK));
        Player charlie = new Player("Charlie", new ColorBetStrategy(ColorBet.Color.BLACK));

        ExperimentStats experimentStats = new ExperimentStats(alice, bob, charlie);

        alice.resetPrize();
        bob.resetPrize();
        charlie.resetPrize();

        alice.takeMoney(1);
        bob.takeMoney(2);
        charlie.takeMoney(3);

        experimentStats.collectManchesResults();

        alice.resetPrize();
        alice.takeMoney(4);

        bob.resetPrize();
        bob.takeMoney(5);

        charlie.resetPrize();
        charlie.takeMoney(6);

        experimentStats.collectManchesResults();

        alice.resetPrize();
        alice.takeMoney(7);

        bob.resetPrize();
        bob.takeMoney(8);

        charlie.resetPrize();
        charlie.takeMoney(9);

        experimentStats.collectManchesResults();

        Map<Player, Long> averages = experimentStats.averagePrizePerPlayer();

        if (averages.get(alice) == 4) {
            pass();
        } else {
            fail();
        }

        if (averages.get(bob) == 5) {
            pass();
        } else {
            fail();
        }

        if (averages.get(charlie) == 6) {
            pass();
        } else {
            fail();
        }

    }

    public void test_ExperimentsStats_collectManchesResults_when_gived_a_list_of_results_should_return_count_of_bankrupts() {

        Player alice = new Player("Alice", new ColorBetStrategy(ColorBet.Color.BLACK));
        Player bob = new Player("Bob", new ColorBetStrategy(ColorBet.Color.BLACK));
        Player charlie = new Player("Charlie", new ColorBetStrategy(ColorBet.Color.BLACK));

        ExperimentStats experimentStats = new ExperimentStats(alice, bob, charlie);

        alice.resetPrize();
        bob.resetPrize();
        charlie.resetPrize();

        alice.takeMoney(1);
        bob.takeMoney(2);
        charlie.takeMoney(3);

        experimentStats.collectManchesResults();

        alice.resetPrize();
        bob.resetPrize();
        charlie.resetPrize();

        alice.takeMoney(-2);
        bob.takeMoney(2);
        charlie.takeMoney(-4);

        experimentStats.collectManchesResults();

        Map<Player, Integer> bankrupts = experimentStats.bankruptPerPlayer();

        if (bankrupts.get(alice) == 1) {
            pass();
        } else {
            fail();
        }

        if (bankrupts.get(bob) == 0) {
            pass();
        } else {
            fail();
        }

        if (bankrupts.get(charlie) == 1) {
            pass();
        } else {
            fail();
        }

    }

    private static void fail(){
        throw new RuntimeException("test failed");
    }
    private static void pass(){
        System.out.println("          test passed");
    }

}
