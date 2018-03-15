package Product3.GenericFunctions;

import Product3.GenericDataStructures.Grade;

import java.util.List;

public class Main {
    public static void main(String args[]) {
        List<Double> someDoubles = GenericMethods.getListOfDoubles(100);

        List<String> strings = GenericMethods.toListOfStrings(someDoubles);

        List<Integer> listOfInts = GenericMethods.sortAndTransformListOfNumbers(someDoubles);

        List<Pair> pairs = GenericMethods.listOfSomethingToSomethingElse(someDoubles, Main::pairMapper);

        List<Grade> grades = GenericMethods.listOfSomethingToSomethingElse(someDoubles, Main::gradeMapper);

        System.out.println();
    }

    private static Pair pairMapper(double input) {
        return new Pair("I'm a pair!", input);
    }

    private static Grade gradeMapper(double input) {
        String gradeString;

        if (input > 0.5) {
            gradeString = "Pass";
        } else {
            gradeString = "Fail";
        }

        return new Grade((int) input, gradeString);
    }
}
