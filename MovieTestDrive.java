class Movie {
  String title;
  String genre;
  int rating;
  void playIt() {
    System.out.println("Playing the movie");
  }
}

/*
Creo una classe movie e assegno degli attributi a quell'oggetto in questo caso titolo, genere e valutazione
creo anche un metodo che printa "Playing the movie"
*/

public class MovieTestDrive {

  public static void main(String[] args) {

    Movie one = new Movie(); //creo un oggetto two che è di tipo Movieche ho definito nella classe Movie
    one.title = "Gone with the Stock"; //Assegno un valore al titolo di one
    one.genre = "Tragic"; //Assegno un valore al genere di one
    one.rating = -2; //Assegno un valore alla valutazione di one

    Movie two = new Movie(); //creo un oggetto two che è di tipo Movieche ho definito nella classe Movie
    two.title = "Lost in Cubicle Space"; //Assegno un valore al titolo di two
    two.genre = "Comedy"; //Assegno un valore al genere di two
    two.rating = 5; //Assegno un valore alla valutazione di two
    two.playIt(); //richiamo il metodo playIt() e perciò verrà visualizzato a schermo "Playing the moovie"

    Movie three = new Movie(); //creo un oggetto three che è di tipo Movieche ho definito nella classe Movie
    three.title = "Byte Club"; //Assegno un valore al titolo di three
    three.genre = "Tragic but ultimately uplifting"; //Assegno un valore al genere di three
    three.rating = 127; //Assegno un valore alla valutazione di three

  }

}