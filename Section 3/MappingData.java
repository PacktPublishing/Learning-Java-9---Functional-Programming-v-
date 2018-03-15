package Product3.FunctionalProgramming;

import java.util.Arrays;
import java.util.List;

public class MappingData {
    public static void main(String args[]) {
        List<Double> numbers = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0);

//        numbers.stream()
//            .map(number -> number +=1)
//            .map(number -> number *= 5)
//            .map(number -> number /= 2)
//            .map(number -> new MyDoubleClass(number))
//            .map(number -> number.getStringValue())
//            .forEach(number -> System.out.println(number));


        numbers.parallelStream()
            .map(number -> number += 1)
            .map(number -> number *= 5)
            .map(number -> number /= 2)
            .map(number -> new MyDoubleClass(number))
            .map(number -> number.getStringValue())
            .forEach(number -> System.out.println(number));
    }

    static class MyDoubleClass {
        Double value;

        MyDoubleClass(Double value) {
            this.value = value;
        }

        String getStringValue() {
            return Double.toString(value);
        }
    }
}
