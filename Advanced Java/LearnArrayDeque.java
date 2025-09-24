// ArrayDeck

import java.util.ArrayDeque;

public class LearnArrayDeque {
    public static void main(String[] args) {

        ArrayDeque<Integer> adQueue = new ArrayDeque<>();

        adQueue.offer(23);
        adQueue.offerFirst(12);
        System.out.println(adQueue);

        adQueue.offerLast(45);
        System.out.println(adQueue);

        adQueue.offerLast(26);
        System.out.println(adQueue);

        System.out.println("adQueue.peek() : " + adQueue.peek());
        System.out.println("adQueue.peekFirst() : " + adQueue.peekFirst());
        System.out.println("adQueue.peekLast() : " + adQueue.peekLast());

        System.out.println(adQueue);
        System.out.println("adQueue.poll() " + adQueue.poll());
        System.out.println(adQueue);
        System.out.println("adQueue.pollFirst() " + adQueue.pollFirst());
        System.out.println(adQueue);
        System.out.println("adQueue.pollLast() " + adQueue.pollLast());
        System.out.println("" + adQueue);

        // Output : 
        // [12, 23]
        // [12, 23, 45]
        // [12, 23, 45, 26]
        // adQueue.peek() : 12
        // adQueue.peekFirst() : 12
        // adQueue.peekLast() : 26
        // [12, 23, 45, 26]
        // adQueue.poll() 12
        // [23, 45, 26]
        // adQueue.pollFirst() 23
        // [45, 26]
        // adQueue.pollLast() 26
        // [45]

    }
}