public class Cap2es3 {

    public static void main(String[] args) {

        Rettangolo rett1 = new Rettangolo(4, 10);
        Quadrato quadr1 = new Quadrato(5);
        Rettangolo rett2 = new Quadrato(10); //È possibile perche quadrato estende rettangolo
        totalArea(rett1, quadr1, rett2);

    }

    static void totalArea(Forma ... forme) {
        int sommaRettangoli = 0;
        for (Forma f : forme) {
            sommaRettangoli += f.area();
        }
        System.out.println("L'area totale è: " + sommaRettangoli);
    }

}
