import java.util.function.Function;
import java.util.function.Predicate;

public class StefanoLambda {

    public static void main(String[] args) {
        Function<Integer,Integer> quadratoClassico = new Quadrato();

        Function<Integer,Integer> quadratoAnnidatoAnonimo = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer arg) {
                return arg*arg;
            }
        };

        Function<Integer,Integer> quadratoConLambda =  x -> {return x*x;};


        System.out.println(useThefunction(quadratoClassico,2));
        System.out.println(useThefunction(quadratoAnnidatoAnonimo,2));
        System.out.println(useThefunction(quadratoConLambda,2));
        System.out.println(useThefunction(x -> {return x*x;},2));
        System.out.println(useThefunction(MathButBetter::powOfTwo,2));

    }

    private static int useThefunction(Function<Integer,Integer> theFunction, int argument){
        return theFunction.apply(argument);
    }
}

class MathButBetter {
    public static Integer powOfTwo(Integer arg){
        return (int)Math.pow(arg,2);
    }
}

class Quadrato implements Function<Integer,Integer>{
    @Override
    public Integer apply(Integer arg) {
        return arg*arg;
    }
}

