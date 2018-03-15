package Product3.FunctionalProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaExpressions {
    public static void main(String args[]) {
        List<String> names = Arrays.asList("James", "John", "Peter", "Anna", "Tom", "Janice", "Sarah");

        //The old way - using an anonymous class to override the default comparator operation
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });

        //New option using a lambda expression, note the use of the ->
        Collections.sort(names, (String a, String b) -> {
            return b.compareTo(a);
        });

        //In Java 8 the return is explicit, and it's smart enough to figure out
        // the parameter types so actually we can do...
        Collections.sort(names, (a, b) -> b.compareTo(a));
    }
}
