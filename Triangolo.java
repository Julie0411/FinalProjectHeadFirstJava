import jdk.jfr.Frequency;

public class Triangolo implements Forma {

    private int b;
    private int h;
    private int l1;
    private int l2;
    private int l3;

    public Triangolo(int b, int h, int l1, int l2, int l3) {
        this.b = b;
        this.h = h;
        this.l1 = l1;
        this.l2 = l2;
        this.l3 = l3;
    }

    @Override
    public int area() {
        return (this.h * this.b) / 2;
    }

    @Override
    public int perimentro() {
        return l1 + l2 + l3;
    }
}
