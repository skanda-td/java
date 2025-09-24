import java.util.Map;
import java.util.HashMap;

public class MapExample {
    public static void main(String[] args) {
        Map<String, Integer> hashMap = new HashMap<>();

        hashMap.put("apple", 2);
        hashMap.put("banana", 5);
        hashMap.put("orange", 3);

        System.out.println("Bananas: " + hashMap.get("banana")); 
        System.out.println("Mangoes: " + hashMap.get("mango")); 

        System.out.println("Mangoes (safe): " + hashMap.getOrDefault("mango", 0));

        hashMap.put("banana", hashMap.get("banana") + 1);
        System.out.println("Updated bananas: " + hashMap.get("banana"));
    }
}
