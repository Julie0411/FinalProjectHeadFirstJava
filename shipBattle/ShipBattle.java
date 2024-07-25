package shipBattle;

import java.util.ArrayList;
import java.util.Scanner;

public class ShipBattle {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> sea = new ArrayList<>();

        int n1 = (int) (Math.random() * 4);
        int n2 = n1 + 1;
        int n3 = n1 + 2;

        sea.add(n1);
        sea.add(n2);
        sea.add(n3);

        int counter = 0;
        String status;

        while (true) {

            try {
                System.out.println("Inserisci una posizione");
                int guess = sc.nextInt();

                if (!(guess >= 0 && guess <= 7)) {
                    throw new IllegalArgumentException(); // Guard contition
                }


                if (sea.contains(guess)) {
                    sea.remove(Integer.valueOf(guess));
                    status = "colpito";
                    System.out.println("Hai " + status + " la nave");
                } else {
                    status = "mancato";
                    System.out.println("Hai " + status + " la nave");
                }

                counter++;

                if (sea.size() == 0) {
                    status = "affondato";
                    System.out.println("Hai " + status + " la nave");
                    System.out.println("Numero turni: " + counter);
                    break;
                }

                System.out.println("Numero turni: " + counter);

            } catch (Exception e) {
                System.out.println("La tua guess è invalida, scegli un altro valore");
            }

        }

    }

}



/*
*
 System.out.println("Inserisci una posizione");
            int guess = sc.nextInt();

            if (!(guess >= 0 && guess <= 7)) {
                System.out.println("La tua guess è invalida, scegli un altro valore");
            } else {
                if (sea.contains(guess)) {
                    sea.remove(Integer.valueOf(guess));
                    status = "colpito";
                    System.out.println("Hai " + status + " la nave");
                } else {
                    status = "mancato";
                    System.out.println("Hai " + status + " la nave");
                }

                counter++;

                if (sea.size() == 0) {
                    status = "affondato";
                    System.out.println("Hai " + status + " la nave");
                    System.out.println("Numero turni: " + counter);
                    break;
                }

                System.out.println("Numero turni: " + counter);

* */
