import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class LearnPriorityQueue {
    public static void main(String[] args) {

        // Observe first Element
        // Use PriorityQueue to implement minheap
        Queue<Integer> pQueue = new PriorityQueue<>();

        pQueue.offer(4);
        pQueue.offer(1);
        pQueue.offer(2);
        pQueue.offer(3); // Output : [1, 3, 2, 4] , reason : minheap

        System.out.println(pQueue);
        pQueue.poll();
        System.out.println(pQueue); // // Output : [2, 3, 4] , reason : heapify & minheap

        System.out.println(pQueue.peek());

        // Use PriorityQueue to implement maxheap
        Queue<Integer> pQueue1 = new PriorityQueue<>(Comparator.reverseOrder());

        pQueue1.offer(4);
        pQueue1.offer(1);
        pQueue1.offer(2);
        pQueue1.offer(3); // Output :  , reason : maxheap

        System.out.println(pQueue1);
        pQueue1.poll();
        System.out.println(pQueue1); // // Output :  , reason : heapify & maxheap

        System.out.println(pQueue1.peek());

    }
}
