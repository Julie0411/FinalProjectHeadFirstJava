package logicalPort;

public abstract class LogicalPort {
    abstract boolean calculate();
}

abstract class BinaryLogicalPort extends LogicalPort {
    protected boolean in1;
    protected boolean in2;
    void setIn1(boolean i1){
        this.in1 = i1;
    }
    void setIn2(boolean i2) {
        this.in2 = i2;
    }
    BinaryLogicalPort(boolean i1, boolean i2){
        this.in1=i1;
        this.in2=i2;
    }
}

class OrPort extends BinaryLogicalPort {
    OrPort(boolean i1, boolean i2) {
        super(i1, i2);
    }
    @Override
    boolean calculate() {
        return in1 || in2;
    }
}

class AndPort extends BinaryLogicalPort {
    AndPort(boolean i1, boolean i2) {
        super(i1, i2);
    }
    @Override
    boolean calculate() {
        return in1 && in2;
    }
}

class NotPort extends LogicalPort {
    protected boolean in;
    NotPort(boolean in) {
        this.in = in;
    }
    void setIn(boolean in) {
        this.in = in;
    }
    @Override
    boolean calculate() {
        return !this.in;
    }
}

class VeryComplexLogicalPort extends LogicalPort {
    private boolean in1;
    private boolean in2;
    private boolean in3;
    private boolean in4;

    public VeryComplexLogicalPort(boolean in1, boolean in2, boolean in3, boolean in4) {
        this.in1 = in1;
        this.in2 = in2;
        this.in3 = in3;
        this.in4 = in4;
    }

    public void setIn1(boolean in1) {
        this.in1 = in1;
    }

    public void setIn2(boolean in2) {
        this.in2 = in2;
    }

    public void setIn3(boolean in3) {
        this.in3 = in3;
    }

    public void setIn4(boolean in4) {
        this.in4 = in4;
    }

    @Override
    boolean calculate() {
        LogicalPort firstAnd = new AndPort(in1, in2);
        LogicalPort or = new OrPort(in3, in4);
        LogicalPort secondAnd = new AndPort(firstAnd.calculate(), or.calculate());
        LogicalPort not = new NotPort(secondAnd.calculate());
        return not.calculate();
    }

}


class main {

    public static void main(String[] args) {

      VeryComplexLogicalPort port = new VeryComplexLogicalPort(false, false, false, false);
      System.out.println(port.calculate());
      port.setIn3(true);
      port.setIn4(true);
      System.out.println(port.calculate());
      port.setIn1(true);
      port.setIn2(true);
      System.out.println(port.calculate());

    }

}