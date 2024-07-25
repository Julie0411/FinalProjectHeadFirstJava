package students;

public class student {
    private String nome;
    private String cognome;
    private String matricola;
    private double voto;

    student(String nome, String cognome, String matricola, double voto) {
        this.nome = nome;
        this.cognome = cognome;
        this.matricola = matricola;
        this.voto = voto;
    }

    public student() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getMatricola() {
        return matricola;
    }

    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }

    public double getVoto() {
        return voto;
    }

    public void setVoto(double voto) {
        this.voto = voto;
    }

    public void info() {
        System.out.println("Nome: " + nome);
        System.out.println("Cognome: " + cognome);
        System.out.println("Matricola: : " + matricola);
        System.out.println("Voto: " + voto);
    }

}

class main {

    public static void main(String[] args) {

        student studente1 = new student("Fabio", "Giger", "6900", 17);
        student studente2 = new student("Francesco", "Gonzalez", "6901", 18);
        student studente3 = new student("Francesca", "Somazzi", "6902", 30);
        studente1.info();
        System.out.println("------------");
        studente2.info();
        System.out.println("------------");
        studente3.info();

    }

}
