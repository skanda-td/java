import java.util.Map;
import java.util.TreeMap;

public class LearnMap {
    public static void main(String[] args) {
        
        Map <String,Integer> numberMap = new TreeMap<>();
        numberMap.put("One", 1);
        numberMap.put("Two", 2);
        numberMap.put("Three", 3);

        System.out.println(numberMap);

        // if (!numberMap.containsKey("Two")) {
        //     numberMap.put("Two", 23);
        // }

        numberMap.putIfAbsent("Two", 23);
        System.out.println(numberMap);

        for (Map.Entry<String,Integer> e : numberMap.entrySet()){
            System.out.println(e);
            System.out.println("Key : " + e.getKey() + ",Value : " + e.getValue());
        }

        System.out.println(numberMap.keySet());
        System.out.println(numberMap.values());

        System.out.println(numberMap.containsValue(3));
        System.out.println(numberMap.isEmpty());

        numberMap.remove("Three");
        System.out.println(numberMap);

        numberMap.clear();
        System.out.println(numberMap);

        // Output
        // {One=1, Two=2, Three=3}
        // {One=1, Two=2, Three=3}
        // One=1
        // Key : One,Value : 1
        // Two=2
        // Key : Two,Value : 2
        // Three=3
        // Key : Three,Value : 3
        // [One, Two, Three]
        // [1, 2, 3]
        // true
        // false
        // {}
            
    }
}
