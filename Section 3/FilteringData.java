package Product3.FunctionalProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class FilteringData {
    public static void main(String args[]) {
        List<Integer> listOfRandoms = getListOfRandoms(10000);

        List<Integer> collect = listOfRandoms.stream()
            .filter(value -> value % 2 == 0)
            .collect(Collectors.toList());


        System.out.println("This is even " + collect.get(54));
        System.out.println("So is this " + collect.get(10));
        System.out.println("And this... " + collect.get(100));
    }

    private static List<Integer> getListOfRandoms(int listSize) {
        List<Integer> values = new ArrayList<>(listSize);
        for (int i = 0; i < listSize; i++) {
            values.add(getRandomValue());
        }
        return values;
    }

    private static int getRandomValue() {
        Random r = new Random();
        int Low = 1;
        int High = 1000;
        return r.nextInt(High - Low) + Low;
    }
}
