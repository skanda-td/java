import java.util.List;

public class Optional {
    public static void main(String[] args) {
        List<String> names = List.of("A,","B,","C");
        // names.forEach(name -> System.err.print(name + " "));
        names.forEach(System.out::print);
    }
}
