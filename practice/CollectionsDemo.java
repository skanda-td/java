package practice;

import java.util.*;

public class CollectionsDemo {
    public static void main(String[] args) {
        // -------- LIST (ordered, duplicates allowed) --------
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("apple");  // duplicates allowed
        System.out.println("List: " + list);  

        // iterate list
        for (String s : list) {
            System.out.println("List item: " + s);
        }

        // sorting a list
        Collections.sort(list); // ascending
        System.out.println("Sorted List: " + list);

        // -------- SET (unique items, no duplicates) --------
        Set<String> hashSet = new HashSet<>();
        hashSet.add("red");
        hashSet.add("blue");
        hashSet.add("red");   // ignored
        System.out.println("\nHashSet (no order): " + hashSet);

        // LinkedHashSet → maintains insertion order
        Set<String> linkedSet = new LinkedHashSet<>();
        linkedSet.add("red");
        linkedSet.add("blue");
        linkedSet.add("green");
        System.out.println("LinkedHashSet (insertion order): " + linkedSet);

        // TreeSet → sorted order
        Set<String> treeSet = new TreeSet<>();
        treeSet.add("banana");
        treeSet.add("apple");
        treeSet.add("cherry");
        System.out.println("TreeSet (sorted): " + treeSet);

        // -------- MAP (key-value pairs) --------

        // HashMap → fast, no order
        Map<String, Integer> map = new HashMap<>();
        map.put("age", 25);
        map.put("year", 2025);
        map.put("age", 26); // overwrites
        System.out.println("\nHashMap: " + map);

        // iterate map
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + 
                               ", Value: " + entry.getValue());
        }

        // LinkedHashMap → insertion order
        Map<String, Integer> linkedMap = new LinkedHashMap<>();
        linkedMap.put("b", 2);
        linkedMap.put("a", 1);
        linkedMap.put("c", 3);
        System.out.println("LinkedHashMap: " + linkedMap);

        // TreeMap → sorted by key
        Map<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("banana", 3);
        treeMap.put("apple", 5);
        treeMap.put("cherry", 1);
        System.out.println("TreeMap (sorted keys): " + treeMap);

        // -------- QUEUE (FIFO) --------
        Queue<String> queue = new LinkedList<>();
        queue.offer("task1");
        queue.offer("task2");
        queue.offer("task3");
        System.out.println("\nQueue: " + queue);

        // remove from queue (FIFO)
        System.out.println("Removed: " + queue.poll());
        System.out.println("Queue after poll: " + queue);

           // -------- STACK (LIFO) --------
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("\nStack: " + stack);

        System.out.println("Popped: " + stack.pop()); // removes last
        System.out.println("Stack after pop: " + stack);

        // -------- PRIORITYQUEUE (min-heap) --------
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(30);
        pq.add(10);
        pq.add(20);
        System.out.println("\nPriorityQueue: " + pq);
        System.out.println("Peek (smallest): " + pq.peek());
        System.out.println("Poll (remove smallest): " + pq.poll());
        System.out.println("After poll: " + pq);

        // -------- ITERATOR --------
        Iterator<String> it = list.iterator();
        System.out.println("\nIterating using Iterator:");
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        // -------- CUSTOM SORTING --------
        List<String> names = Arrays.asList("Charlie", "Bob", "Alice");

        // sort by length
        names.sort((a, b) -> Integer.compare(a.length(), b.length()));
        System.out.println("\nSorted by length: " + names);

        // reverse alphabetical
        names.sort(Comparator.reverseOrder());
        System.out.println("Reverse sorted: " + names);
    }
}
