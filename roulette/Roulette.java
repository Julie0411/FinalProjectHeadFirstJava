package roulette;

import java.util.Scanner;

public class Roulette {

    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        
    }

    private class Giocatore {
        private String nome;
        private int numeroGiocatore;
        public Giocatore(String nome, int numeroGiocatore) {
            this.nome = nome;
            this.numeroGiocatore = numeroGiocatore;
        }
    }

    private class Banco {
        int[] dozzina1 = new int[12];
        int[] dozzina2 = new int[12];
        int[] dozzina3 = new int[12];
        private Banco(int[] dozzina1, int[] dozzina2, int[] dozzina3) {
            dozzina1 = this.dozzina1;
            dozzina2 = this.dozzina2;
            dozzina3 = this.dozzina3;
        }
        public Banco assegna() {
            for (int i = 0; i < 12; i++) {
                dozzina1[i] = i + 1;
                dozzina2[i] = 1 + 12;
                dozzina3[i] = 1 + 24;
            }
            Banco banco = new Banco(dozzina1, dozzina2, dozzina3);
            return banco;
        }
    }

    private class Bet {
        Scanner sc = new Scanner(System.in);
        private int accessi;
        String nome = "Giocatore " + accessi;
        int numero = sc.nextInt();
        Giocatore giocatore1 = new Giocatore(nome, numero);
    }
}