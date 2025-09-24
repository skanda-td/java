import java.util.List;
import java.util.Arrays;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) {
        
        List <Integer> numbers = Arrays.asList(4,5,7,3,2,6);
        // System.out.println(numbers);

        // int sum = 0;
        // for (Integer integer : numbers) {
        //     if (integer % 2 == 0) {
        //         integer = integer * 2;
        //         sum = sum + integer;
        //     }
        // }

        // for (int i = 0; i < numbers.size(); i++) {
        //     System.out.print(numbers.get(i) + " ");
        // }
        // System.out.println();

        // for (Integer integer : numbers) {
        //     System.out.print(integer + " ");
        // }
        // System.out.println();
 
        // numbers.forEach(n -> System.out.print(n + " "));
        // System.out.println();

        // System.out.println(sum);

        // Consumer <Integer> con = new Consumer <Integer>(){
        //     public void accept(Integer n){
        //         System.out.print(n + " ");
        //     }
        // };

        // numbers.forEach(con);
        // System.out.println();

        // Consumer <Integer> consumer = (Integer n) -> System.out.print(n + " ");

        // numbers.forEach(consumer);
        // System.out.println();

        // Consumer <Integer> consumer1 = (n) -> System.out.print(n + " ");

        // numbers.forEach(consumer1);
        // System.out.println(); 

        // Final

        // Stream <Integer> stream = numbers.stream();
        // stream.forEach(n -> System.out.print(n + " "));
        // Exception in thread "main" java.lang.IllegalStateException: stream has already been operated upon or closed
        // at java.base/java.util.stream.AbstractPipeline.sourceStageSpliterator(AbstractPipeline.java:279)
        // at java.base/java.util.stream.ReferencePipeline$Head.forEach(ReferencePipeline.java:762)        
        // at Streams.main(Streams.java:57)

        // Stream <Integer> stream2 = stream.filter(n -> n % 2 == 0);
        // Stream <Integer> stream3 = stream2.map(n -> n * 2);

        // int res = stream3.reduce(0, (c,e) -> c + e);
        // System.out.println(res);
        // // stream3.forEach(n -> System.out.print(n + " "));

        int value = numbers.stream()
        .filter(n -> n % 2 == 0)
        .map(n -> n * 2)
        .reduce(12, (c, e) -> c + e);
        System.out.println(value);


    }
}
