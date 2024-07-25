package elettrodomestici;

public class Elettrodomestico {
    private boolean stato;
    public void accendi() {
        this.stato = true;
    }
    public void spegni() {
        this.stato = false;
    }

    public boolean eAcceso() {
        return stato;
    }

    public Elettrodomestico() {
        this.stato = false;
    }

    public static void main(String[] args) {
        Lavatrice vecchia = new Lavatrice(true, 100);
        Lavatrice vecchissima = new Lavatrice(false, 100);
        Lavatrice nuova = new Lavatrice(true, 0);
        Lavatrice usata = new Lavatrice(true, 50);
    }

}
interface Apribile {
    void apri();
    void chiudi();
    boolean eAperto();
}



class FrullatoreAImmersione extends Elettrodomestico {
    public FrullatoreAImmersione() {
        super();
    }
}

class Frigorifero extends Elettrodomestico implements Apribile {
    boolean statoSportello;
    public Frigorifero(boolean statoSportello) {
        super();
        this.statoSportello = statoSportello;
    }
    public void apri() {
        statoSportello = true;
    }
    public void chiudi() {
        statoSportello = false;
    }
    public boolean eAperto() {
        return statoSportello;
    }
}

class Lavatrice extends Elettrodomestico implements Apribile {
    private boolean statoSportello;
    private ControlloSicurezzaSportello controlloSicurezzaSportello;
    private ControlloAccesso controlloAccesso;
    private GuarnizioneSportello guarnizioneSportello;
    //private guarnizioneSportello.statoConsumo();
    public Lavatrice (boolean statoSportello) {
        this(statoSportello,0);
    }

    public Lavatrice (boolean statoSportello, int statoInizialeGuarnizione) {
        super();
        this.controlloSicurezzaSportello = new SimpleControlloSicurezzaSportello(this);
        GuarnizioneSportello g = new GuarnizioneSportello(statoInizialeGuarnizione);
        this.controlloAccesso = new ControlloAccesso(g);
        this.guarnizioneSportello = g;
        this.statoSportello = statoSportello;
    }

    @Override
    public void apri() {
        controlloSicurezzaSportello.puoAprireSportello();
        this.statoSportello = true;
    }

    @Override
    public void accendi() {
        this.controlloAccesso.siPuoAccendere();
        super.accendi();
    }

    @Override
    public void chiudi() {
        this.statoSportello = false;
    }

    @Override
    public boolean eAperto() {
        return this.statoSportello;
    }

}

class Lavastoviglie extends Elettrodomestico implements Apribile  {
    private boolean statoSportello;
    private ControlloSicurezzaSportello controlloSicurezzaSportello;
    public Lavastoviglie (boolean statoSportello) {
        super();
        this.controlloSicurezzaSportello = new SimpleControlloSicurezzaSportello(this);
        this.statoSportello = statoSportello;
    }

    @Override
    public void apri() {
       controlloSicurezzaSportello.puoAprireSportello();
       this.statoSportello = true;

    }

    @Override
    public void chiudi() {
        this.statoSportello = false;
    }

    @Override
    public boolean eAperto() {
        return this.statoSportello;
    }
}


interface ControlloSicurezzaSportello{
     void puoAprireSportello();
}
class SimpleControlloSicurezzaSportello implements ControlloSicurezzaSportello{
    private Elettrodomestico elettrodomestico;
    SimpleControlloSicurezzaSportello(Elettrodomestico el){
        this.elettrodomestico = el;
    }

    public void puoAprireSportello(){
        if (elettrodomestico.eAcceso()) throw new RuntimeException("Can't open");
    }

}

class BrockenControlloSicurezzaSportello implements ControlloSicurezzaSportello{
    @Override
    public void puoAprireSportello() {
        if (Math.random() >= 0.5) throw new RuntimeException();
    }
}

class GuarnizioneSportello {
    private int statoConsumo;

    public GuarnizioneSportello(int statoConsumo) {
        this.statoConsumo = statoConsumo;
    }

    boolean isConsumptionBelowTreshold(int treshold) {
        return this.statoConsumo < treshold;
    }

}

class ControlloAccesso {
    private GuarnizioneSportello guarnizioneSportello;
    ControlloAccesso(GuarnizioneSportello guarnizioneSportello) {
        this.guarnizioneSportello = guarnizioneSportello;
    }
    public void siPuoAccendere() {
        if (!guarnizioneSportello.isConsumptionBelowTreshold(70)) {
            throw new RuntimeException("Non è possibile accendere la lavatrice, la guarnizione è distrutta");
        }
    }
}