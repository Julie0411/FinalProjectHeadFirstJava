import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class JulieLambda {

    public static void main(String[] args) {


        Predicate<Integer> positiveFilterNested = new Predicate<Integer>() {
            @Override
            public boolean test(Integer x) {
                return x >= 0;
            }
        };

        Predicate<Integer> positiveFilter = new Positive();

        Predicate<Integer> positiveFilterWithLambda =  x -> {return x >= 0;};

        System.out.println(useThePredicate(positiveFilter,5));
        System.out.println(useThePredicate(positiveFilterNested,-5));
        System.out.println(useThePredicate(positiveFilterWithLambda,5));
        System.out.println(useThePredicate(x -> {return x >= 0;},5));

        List<Integer> list = List.of(-3,-2,-1,1,2,3,4);
        System.out.println(list.stream().filter(x -> {return x >= 0;}).count());
        System.out.println(list.stream().filter(x -> {return x < 0;}).count());
        System.out.println(list.stream().filter(x -> {return x % 2 == 0;}).count());

    }

    private static boolean useThePredicate(Predicate<Integer> thePredicate, int argument){
        return thePredicate.test(argument);
    }
}

class Positive implements Predicate<Integer> {
    @Override
    public boolean test(Integer x) {
        return x >= 0;
    }
}