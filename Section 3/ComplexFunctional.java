package Product3.FunctionalProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ComplexFunctional {
    public static void main(String args[]) {
        System.out.println("################## Flatmap 1 #####################");
        flatmap1();
        System.out.println("################## Flatmap 2 #####################");
        flatmap2();

        //Reduce
        System.out.println("################## Sum Reduce #####################");
        sumReduce();

        //Count
        System.out.println("################## Sum Reduce #####################");
        count();
    }

    public static void count() {
        long count = IntStream.range(1, 100).count();
        long sum = IntStream.range(1, 100).sum();
        System.out.println("Total values between 1 and 100 is " + count);
        System.out.println("Sum of values between 1 and 100 is " + sum);
    }

    private static void sumReduce() {
        class Person {
            private final int age;

            public Person(int age) {
                this.age = age;
            }

            public int getAge() {
                return this.age;
            }
        }

        List<Person> people = new ArrayList<>();
        people.add(new Person(10));
        people.add(new Person(16));
        people.add(new Person(25));
        people.add(new Person(65));
        people.add(new Person(21));
        people.add(new Person(94));
        people.add(new Person(25));

        int totalAge = people.stream()
            .map(person -> person.getAge())
            .reduce((a, b) -> a + b)
            .get();

        int alsoTotalAge = people.stream().mapToInt(person -> person.getAge()).sum();

        System.out.println("Total age is " + totalAge);
    }

    private static void flatmap1() {
        List<String> UKCities = Arrays.asList("London", "Manchester", "Birmingham", "Glasgow", "Cardiff");
        List<String> USCities = Arrays.asList("New York", "Washington DC", "LA", "Miami", "Atlanta");
        List<String> EUCities = Arrays.asList("Paris", "Brussels", "Munich", "Berlin", "Madrid");
        List<String> AsianCities = Arrays.asList("Beijing", "Singapore", "Hong Kong", "Jakarta", "Tokyo");

        List<List<String>> allTheCities = new ArrayList<>();
        allTheCities.add(UKCities);
        allTheCities.add(USCities);
        allTheCities.add(EUCities);
        allTheCities.add(AsianCities);

        //I want to combine all the lists
        allTheCities.stream()
            .flatMap(cityList -> cityList.stream())
            .forEach(city -> System.out.println(city));
    }

    private static void flatmap2() {
        LibraryMember member = new LibraryMember();
        member.addBook("Java 8 in Action");
        member.addBook("Spring Boot in Action");
        member.addBook("Effective Java (2nd Edition)");

        LibraryMember member2 = new LibraryMember();
        member2.addBook("Learning Python, 5th Edition");
        member2.addBook("Effective Java (2nd Edition)");

        List<LibraryMember> list = new ArrayList<>();
        list.add(member);
        list.add(member2);

        List<String> collect =
            list.stream()
                .map(x -> x.getBooksOnLoan())      //Stream<Set<String>>
                .flatMap(x -> x.stream())   //Combines all the streams into one
                .distinct()
                .collect(Collectors.toList());

        collect.forEach(x -> System.out.println(x));
    }
}
