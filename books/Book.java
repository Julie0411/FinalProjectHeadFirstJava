package books;

public class Book {
  private String title; //crea un Attributo privato in questo modo è più "sicuro"
  private String author; //crea un Attributo privato in questo modo è più "sicuro"

  public Book(String title, String author) { //Costruttore che serve per fare il collegamento
    this.title = title;                      //tra il private title e il title e tra il private author e l'author
    this.author = author;
  }

  public String getTitle() { //Getter che serve a portare il title in una public class (è un metodo)
    return title;
  }

  public void setTitle(String title) { //Setter che serve a sovrascrivere un valore
    this.title = title;
  }

  public String getAuthor() { //Getter che serve a portare l'author in una public class (è un metodo)
    return author;
  }

  public void setAuthor(String author) { //Setter che serve a sovrascrivere un valore
    this.author = author;
  }

}