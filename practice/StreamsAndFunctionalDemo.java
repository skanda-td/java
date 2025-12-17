package practice;

import java.util.*;
import java.util.function.*;
// import java.util.stream.*;
import static java.util.stream.Collectors.*;
import java.util.stream.Stream;

public class StreamsAndFunctionalDemo {

    @FunctionalInterface
    interface Greeter {
        void greet(); // only one method → functional interface
    }

    static class Person {
        final String name;
        final int age;
        final List<String> hobbies;

        Person(String name, int age, List<String> hobbies) {
            this.name = name;
            this.age = age;
            this.hobbies = hobbies;
        }

        @Override
        public String toString() {
            return name + "(" + age + ")";
        }
    }

    public static void main(String[] args) {

        // A lambda is a short way to write the implementation of that one method.
        Greeter g = new Greeter() {
            @Override
            public void greet() {
                System.out.println("Hello Normal!");
            }
        };
        g.greet();

        Greeter g1 = () -> System.out.println("Hello Lambda!");
        g1.greet();

        // sample data
        List<Person> people = new ArrayList<>(Arrays.asList(
                new Person("Alice", 30, Arrays.asList("java", "reading")),
                // new Person("Alice", 30, Arrays.asList("java", "reading")),

                // Exception in thread "main" java.lang.IllegalStateException: Duplicate key Alice (attempted merging values 30 and 30)
                // at java.base/java.util.stream.Collectors.duplicateKeyException(Collectors.java:135)
                // at java.base/java.util.stream.Collectors.lambda$uniqKeysMapAccumulator$1(Collectors.java:182)
                // at java.base/java.util.stream.ReduceOps$3ReducingSink.accept(ReduceOps.java:169)
                // at java.base/java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1625)
                // at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:509)
                // at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
                // at java.base/java.util.stream.ReduceOps$ReduceOp.evaluateSequential(ReduceOps.java:921)
                // at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                // at java.base/java.util.stream.ReferencePipeline.collect(ReferencePipeline.java:682)
                // at practice.StreamsAndFunctionalDemo.main(StreamsAndFunctionalDemo.java:148)

                new Person("Bob", 22, Arrays.asList("gaming", "java")),
                new Person("Carol", 40, Arrays.asList("gardening")),
                new Person("Dan", 17, Arrays.asList("gaming", "skate")),
                new Person("Eve", 30, Arrays.asList("java", "kotlin"))));

        // --------------------
        // LAMBDAS & FUNCTIONAL INTERFACES
        // --------------------

        // Supplier<T> - supplies values
        Supplier<Person> sampleSupplier = () -> new Person("Zed", 99, Arrays.asList("none"));
        people.add(sampleSupplier.get());

        // Predicate<T> - returns boolean
        Predicate<Person> isAdult = p -> p.age >= 18;

        // Function<T,R> - maps T to R
        Function<Person, String> nameFn = p -> p.name;

        // Consumer<T> - accepts a T, returns void
        Consumer<String> printer = s -> System.out.println(" -> " + s);

        System.out.println("=== Lambdas & Functional Interfaces ===");
        // use predicate and function
        people.stream()
                .filter(isAdult) // intermediate (lazy)
                .map(nameFn) // intermediate (lazy)
                .forEach(printer); // terminal (runs pipeline)

        // --------------------
        // map vs flatMap
        // --------------------
        System.out.println("\n=== map vs flatMap ===");
        // map: Person -> List<String> (Stream<List<String>>)
        people.stream()
                .map(p -> p.hobbies)
                .forEach(list -> System.out.println("list: " + list));

        // flatMap: Person -> Stream<String> then flattened to Stream<String>
        System.out.println("flattened hobbies:");
        people.stream()
                .flatMap(p -> p.hobbies.stream())
                .distinct()
                .forEach(System.out::println);

        // --------------------
        // Intermediate vs Terminal ops
        // --------------------
        System.out.println("\n=== intermediate vs terminal ===");
        Stream<String> lazy = people.stream()
                .filter(isAdult)
                .map(nameFn); // pipeline built, not executed
        System.out.println("Pipeline created but not run yet");
        // terminal op triggers execution
        lazy.forEach(System.out::println);

        // --------------------
        // Optional - avoid null
        // --------------------
        System.out.println("\n=== Optional ===");
        Optional<Person> maybe = people.stream().filter(p -> p.name.equals("Alice1")).findFirst();
        maybe.ifPresentOrElse(
                p -> System.out.println("Found: " + p),
                () -> System.out.println("No person found"));
        String nameOrDefault = people.stream()
                .filter(p -> p.name.equals("Missing"))
                .findFirst()
                .map(p -> p.name)
                .orElse("NoName");
        System.out.println("Name or default: " + nameOrDefault);

        // --------------------
        // Primitive streams and reduce
        // --------------------
        System.out.println("\n=== mapToInt & reduce ===");
        int totalAge = people.stream()
                .mapToInt(p -> p.age) // IntStream (primitive)
                .sum(); // terminal
        System.out.println("Total age: " + totalAge);

        // reduce example: join names separated by comma
        String joined = people.stream()
                .map(p -> p.name)
                .reduce((a, b) -> a + "," + b)
                .orElse("");
        System.out.println("Joined names (reduce): " + joined);

        // --------------------
        // Collectors: groupingBy, toMap, joining, counting
        // --------------------
        System.out.println("\n=== Collectors (groupingBy, toMap, joining) ===");
        Map<Integer, List<Person>> byAge = people.stream()
                .collect(groupingBy(p -> p.age));
        System.out.println("Grouped by age: " + byAge);

        // toMap: name -> age (careful with duplicate keys)
        Map<String, Integer> nameToAge = people.stream()
                .collect(toMap(p -> p.name, p -> p.age));
        System.out.println("Name->Age: " + nameToAge);

        // joining collector for hobbies of a person (example)
        String hobbiesOfAlice = people.stream()
                .filter(p -> p.name.equals("Alice"))
                .flatMap(p -> p.hobbies.stream())
                .collect(joining(";"));
        System.out.println("Alice hobbies: " + hobbiesOfAlice);

        // counting
        Map<Integer, Long> countByAge = people.stream()
                .collect(groupingBy(p -> p.age, counting()));
        System.out.println("Count by age: " + countByAge);

        // grouping with downstream mapping
        Map<Integer, List<String>> namesByAge = people.stream()
                .collect(groupingBy(p -> p.age,
                        mapping(p -> p.name, toList())));
        System.out.println("Names by age: " + namesByAge);

        // --------------------
        // toMap with merge function (handle duplicate keys)
        // --------------------
        System.out.println("\n=== toMap with merge ===");
        Map<String, String> nameToHobbies = people.stream()
            .collect(toMap(
                p -> p.name,
                p -> String.join("|", p.hobbies),
                (existing, replacement) -> existing + ";" + replacement // merge if same name
            ));
        System.out.println("Name->Hobbies: " + nameToHobbies);

        // --------------------
        // flatMap producing many elements per input
        // --------------------
        System.out.println("\n=== flatMap -> distinct tags ===");
        List<String> distinctHobbies = people.stream()
                                             .flatMap(p -> p.hobbies.stream())
                                             .distinct()
                                             .collect(toList());
        System.out.println("Distinct hobbies: " + distinctHobbies);

        // --------------------
        // Parallel streams (advantages + dangers)
        // --------------------
        System.out.println("\n=== Parallel streams ===");
        // advantage: easy parallelism for CPU-bound tasks
        int sumParallel = people.parallelStream()
                                 .mapToInt(p -> p.age)
                                 .sum();
        System.out.println("Sum ages (parallel): " + sumParallel);

        // danger: shared mutable state -> avoid
        System.out.println("Danger example (do not do this in parallel):");
        List<String> badSink = new ArrayList<>();
        // This may produce race conditions when parallel
        people.parallelStream().forEach(p -> badSink.add(p.name));
        System.out.println("Bad sink size (risky): " + badSink.size());

        // safe alternative: use collectors which handle concurrency correctly
        List<String> safeNames = people.parallelStream()
                                       .map(p -> p.name)
                                       .collect(toList()); // collector handles accumulation
        System.out.println("Safe names collected in parallel: " + safeNames);

        // --------------------
        // Example: pipeline combining many concepts
        // - find distinct hobbies of adults, sorted, top 3 joined by comma
        // --------------------
        System.out.println("\n=== Combined pipeline example ===");
        String topHobbies = people.stream()
            .filter(isAdult)                     // intermediate
            .flatMap(p -> p.hobbies.stream())    // intermediate
            .map(String::toLowerCase)            // intermediate
            .distinct()                          // intermediate
            .sorted()                            // intermediate (natural order)
            .limit(3)                            // intermediate
            .collect(joining(", "));             // terminal
        System.out.println("Top hobbies: " + topHobbies);

        // --------------------
        // Optional: convert stream to map safely when duplicate keys exist
        // --------------------
        System.out.println("\n=== toMap safe example (key conflict resolution) ===");
        Map<Integer, List<String>> ageToNames = people.stream()
            .collect(toMap(
                p -> p.age,                      // key
                p -> new ArrayList<>(Arrays.asList(p.name)), // value (list)
                (list1, list2) -> {              // merge lists for same key
                    list1.addAll(list2);
                    return list1;
                }
            ));
        System.out.println("Age -> Names lists: " + ageToNames);

        // --------------------
        // Small Optional usage for a possibly-missing person
        // --------------------
        System.out.println("\n=== Optional small usage ===");
        Optional<Person> maybeDan = people.stream().filter(p -> p.name.equals("Dan")).findFirst();
        String danHobby = maybeDan.flatMap(p -> p.hobbies.stream().findFirst()).orElse("no-hobby");
        System.out.println("Dan first hobby (or default): " + danHobby);

        // --------------------
        // End
        // --------------------
        System.out.println("\n=== Demo complete ===");

        // Expected output:
        // Hello Normal!
        // Hello Lambda!
        // === Lambdas & Functional Interfaces ===
        // -> Alice
        // -> Bob
        // -> Carol
        // -> Eve
        // -> Zed

        // === map vs flatMap ===
        // list: [java, reading]
        // list: [gaming, java]
        // list: [gardening]
        // list: [gaming, skate]
        // list: [java, kotlin]
        // list: [none]
        // flattened hobbies:
        // java
        // reading
        // gaming
        // gardening
        // skate
        // kotlin
        // none

        // === intermediate vs terminal ===
        // Pipeline created but not run yet
        // Alice
        // Bob
        // Carol
        // Eve
        // Zed

        // === Optional ===
        // No person found
        // Name or default: NoName

        // === mapToInt & reduce ===
        // Total age: 238
        // Joined names (reduce): Alice,Bob,Carol,Dan,Eve,Zed

        // === Collectors (groupingBy, toMap, joining) ===
        // Grouped by age: {17=[Dan(17)], 99=[Zed(99)], 22=[Bob(22)], 40=[Carol(40)], 30=[Alice(30), Eve(30)]}
        // Name->Age: {Dan=17, Bob=22, Eve=30, Alice=30, Zed=99, Carol=40}
        // Alice hobbies: java;reading
        // Count by age: {17=1, 99=1, 22=1, 40=1, 30=2}
        // Names by age: {17=[Dan], 99=[Zed], 22=[Bob], 40=[Carol], 30=[Alice, Eve]}

        // === toMap with merge ===
        // Name->Hobbies: {Dan=gaming|skate, Bob=gaming|java, Eve=java|kotlin, Alice=java|reading, Zed=none, Carol=gardening}

        // === flatMap -> distinct tags ===
        // Distinct hobbies: [java, reading, gaming, gardening, skate, kotlin, none]

        // === Parallel streams ===
        // Sum ages (parallel): 238
        // Danger example (do not do this in parallel):
        // Bad sink size (risky): 6
        // Safe names collected in parallel: [Alice, Bob, Carol, Dan, Eve, Zed]

        // === Combined pipeline example ===
        // Top hobbies: gaming, gardening, java

        // === toMap safe example (key conflict resolution) ===
        // Age -> Names lists: {17=[Dan], 99=[Zed], 22=[Bob], 40=[Carol], 30=[Alice, Eve]}

        // === Optional small usage ===
        // Dan first hobby (or default): gaming

        // === Demo complete ===
    }
}
