package Product3.FunctionalProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class ParallelSortStream {
    public static void main(String args[]) throws ExecutionException, InterruptedException {
        List<String> values = getReallyBigList(10000000);
        sequentialSort(values);
        parallelSort(values);
        maxParallelSort(values, 8);
    }

    private static void maxParallelSort(List<String> values, int threads) throws ExecutionException, InterruptedException {
        long t0 = System.nanoTime();
        ForkJoinPool forkJoinPool = new ForkJoinPool(threads);
        List<String> sorted = forkJoinPool.submit(() ->
            //parallel task here, for example
            values.parallelStream().sorted().collect(Collectors.toList())
        ).get();

        System.out.println(sorted.get(10));
        long t1 = System.nanoTime();
        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("Max parallel sort took: %d ms", millis));
    }

    private static void parallelSort(List<String> values) {
        long t0 = System.nanoTime();
        List<String> sorted = values.parallelStream().sorted().collect(Collectors.toList());
        System.out.println(sorted.get(10));
        long t1 = System.nanoTime();
        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("parallel sort took: %d ms", millis));
    }

    private static void sequentialSort(List<String> values) {
        //Sequential sort
        long t0 = System.nanoTime();
        List<String> sorted = values.stream().sorted().collect(Collectors.toList());
        System.out.println(sorted.get(10));
        long t1 = System.nanoTime();
        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("sequential sort took: %d ms", millis));
    }

    private static List<String> getReallyBigList(int listSize) {
        List<String> values = new ArrayList<>(listSize);
        for (int i = 0; i < listSize; i++) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }
        return values;
    }
}
