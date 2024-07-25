package books;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Versione 2

        Book[] myBooks = new Book[3]; //viene creato un array con 3 elementi

        String[] titles = {"The grapes of Java", "The Java Gatsby", "The Java Cookbook"};
        String[] authors = {"Bob", "Sue", "Ian"};

        for (int i = 0; i < myBooks.length; i++) {
            myBooks[i] = new Book(titles[i], authors[i]);
        } //viene istanziata (attraverso il new) un'istanza di tipo Book

        /*
        myBooks[0] = new Book("The grapes of Java", "Bob");
        myBooks[1] = new Book("The Java Gatsby", "Sue");
        myBooks[2] = new Book("The Java Cookbook", "Ian");

        vengono inizializzati e allo stesso tempo vengono inseriti i valori
        nei vari index di Book
        */

        for (Book myBook : myBooks) {
            System.out.println(myBook.getTitle() + " by " + myBook.getAuthor());
        }
        //attraverso il foreach vengono printate le info dei vari libri

        // versione 3
        /*
        List<Book> myBooks = new ArrayList<>();
        myBooks.add(new Book("The grapes of Java", "Bob"));
        myBooks.add(new Book("The Java Gatsby", "Sue"));
        myBooks.add(new Book("The Java Cookbook", "Ian"));

        for (Book singularBook : myBooks) {
            System.out.println(singularBook.getTitle() + " by " + singularBook.getAuthor());
        }
        */

    }

}
