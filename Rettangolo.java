public class Rettangolo implements Forma {

    private int b;
    private int h;

    public Rettangolo(int b, int h) {
        this.b = b;
        this.h = h;
    }

    @Override
    public int area() {
        return this.b * this.h;
    }

    @Override
    public int perimentro() {
        return 2 *( this.b +  this.h);
    }

}
