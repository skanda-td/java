package practice;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

// --------------------
// Java 17 feature #1: Record (immutable data carrier)
// --------------------
record User(String name, int age) {}

public class JavaFeaturesDemo {

    public static void main(String[] args) throws Exception {

        // =====================================================
        // JAVA 11 FEATURES (2)
        // =====================================================

        // --- Java 11 Feature #1: var (local variable type inference)
        var message = "Hello Java 11";   // compiler infers String
        System.out.println(message);

        // --- Java 11 Feature #2: Standard HTTP Client
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://example.com"))
                .GET()
                .build();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("HTTP status: " + response.statusCode());


        // =====================================================
        // JAVA 17 FEATURES (3)
        // =====================================================

        // --- Java 17 Feature #1: Record usage
        User user = new User("Skanda", 25);
        System.out.println("User: " + user.name() + ", " + user.age());

        // --- Java 17 Feature #2: instanceof pattern matching
        Object obj = user;
        if (obj instanceof User u) {  // no casting needed
            System.out.println("Pattern matched user: " + u.name());
        }

        // --- Java 17 Feature #3: Switch expression
        int day = 1;
        String type = switch (day) {
            case 1, 7 -> "Weekend";
            case 2, 3, 4, 5, 6 -> "Weekday";
            default -> "Invalid";
        };
        System.out.println("Day type: " + type);

        // Old switch → does actions
        // New switch → gives a value
        // No break

        // Cleaner

        // Safer

        // Less boilerplate


        // =====================================================
        // JAVA 21 FEATURES (2)
        // =====================================================

        // --- Java 21 Feature #1: Virtual Threads
        // Thread vThread = Thread.startVirtualThread(() -> {
        //     System.out.println("Running in virtual thread: "
        //             + Thread.currentThread());
        // });
        // vThread.join(); // wait for completion

        // --- Java 21 Feature #2: Pattern Matching for switch
        // Object value = 10;

        // String result = switch (value) {
        //     case Integer i -> "Integer: " + i;
        //     case String s  -> "String: " + s;
        //     default        -> "Unknown type";
        // };
        // System.out.println(result);

        // Expected Output:

        // Hello Java 11
        // HTTP status: 200
        // User: Skanda, 25
        // Pattern matched user: Skanda
        // Day type: Weekend
    }
}
