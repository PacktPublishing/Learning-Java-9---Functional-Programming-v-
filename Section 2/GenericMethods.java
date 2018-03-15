package Product3.GenericFunctions;

import Product1.OOP.TransportInterface;

import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GenericMethods {
    //Casts a list of any number to a list of Strings
    public static <T extends Number> List<String> toListOfStrings(List<T> numberList) {
        return numberList.stream()
            .map(value -> value.toString())
            .collect(Collectors.toList());
    }

    //Sorts a list of and number type (T) and casts each entry to another number type (V)
    public static <T extends Number, V extends Number> List<V> sortAndTransformListOfNumbers(List<T> numbers) {
        return numbers.stream()
            .sorted()
            .map(value -> (V) value)
            .collect(Collectors.toList());
    }

    //Leverages a custom function to convert a list of anything to a list of anything else
    public static <T, G> List<T> listOfSomethingToSomethingElse(List<G> someList, Function<G, T> mapper) {
        return someList.stream()
            .map(value -> mapper.apply(value))
            .collect(Collectors.toList());
    }

    //Compares two vehicles by top speed
    public static <T extends TransportInterface> int compareTwoVehicles(T vehicle1, T vehicle2) {
        return vehicle2.getMaxSpeed() - vehicle1.getMaxSpeed();
    }

    public static List<Double> getListOfDoubles(int length) {
        return new Random().doubles().limit(length).boxed().collect(Collectors.toList());
    }
}
