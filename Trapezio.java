public class Trapezio implements Forma {

    int bMag;
    int bMin;
    int l1;
    int l2;
    int h;

    public Trapezio(int bMag, int bMin, int l1, int l2, int h) {
        this.bMag = bMag;
        this.bMin = bMin;
        this.l1 = l1;
        this.l2 = l2;
        this.h = h;
    }

    @Override
    public int area() {
        return ((this.bMag + this.bMin) * this.h) / 2;
    }

    @Override
    public int perimentro() {
        return this.bMag + this.bMin + this.l1 + this.l2;
    }

}
