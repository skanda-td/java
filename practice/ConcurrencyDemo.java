package practice;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ConcurrencyDemo {
    // volatile flag example: ensures visibility across threads
    private static volatile boolean stopRequested = false;

    // shared counter with synchronization vs atomic
    private static int syncCounter = 0;
    private static final Object lock = new Object();
    private static final AtomicInteger atomicCounter = new AtomicInteger(0);

    public static void main(String[] args) throws Exception {
        System.out.println("=== Thread, Runnable ===");
        // Runnable: task with no return
        Runnable r = () -> {
            System.out.println("Runnable running on: " + Thread.currentThread().getName());
        };

        Thread t = new Thread(r);        // create a thread with Runnable
        t.start();                       // start thread
        t.join();                        // wait for it to finish

        System.out.println("\n=== Callable + ExecutorService + Future ===");

        // Callable: task that returns a value and can throw checked exceptions
        Callable<String> callable = () -> {
            Thread.sleep(100);          // simulate work
            return "Result from Callable on " + Thread.currentThread().getName();
        };

        ExecutorService pool = Executors.newFixedThreadPool(2); // thread pool
        Future<String> future = pool.submit(callable);          // submit task
        System.out.println("Future result: " + future.get());   // blocks until done

        System.out.println("\n=== CompletableFuture (non-blocking composition) ===");
        // CompletableFuture: async pipeline
        CompletableFuture<String> cf = CompletableFuture
            .supplyAsync(() -> "hello")
            .thenApply(s -> s.toUpperCase())
            .thenCompose(s -> CompletableFuture.supplyAsync(() -> s + " WORLD"));
        System.out.println("CompletableFuture result: " + cf.get()); // block to show result

        System.out.println("\n=== volatile vs synchronized (visibility vs atomicity) ===");
        // start a thread that sets the volatile flag after short delay
        Thread stopper = new Thread(() -> {
            try { Thread.sleep(200); } catch (InterruptedException ignored) {}
            stopRequested = true;       // visible to other threads immediately
            System.out.println("stopRequested set to true by " + Thread.currentThread().getName());
        });
        stopper.start();

        // busy-wait using volatile flag (simple demo; avoid in real code)
        while (!stopRequested) { /* spin until visible */ }
        System.out.println("Main saw stopRequested = true");

        // synchronized vs atomic increment demo
        System.out.println("\nIncrement counters using 1000 tasks (synchronized vs AtomicInteger)");
        int tasks = 1000;
        CountDownLatch latch = new CountDownLatch(tasks);
        for (int i = 0; i < tasks; i++) {
            pool.execute(() -> {
                // synchronized increment (not scalable, but correct)
                synchronized (lock) {
                    syncCounter++;
                }
                // atomic increment (recommended)
                atomicCounter.incrementAndGet();
                latch.countDown();
            });
        }
        latch.await();  // wait for all tasks to finish
        System.out.println("syncCounter = " + syncCounter + ", atomicCounter = " + atomicCounter.get());

        System.out.println("\n=== Producer-Consumer using BlockingQueue ===");
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(5);

        // Producer Runnable: puts items into queue, waits if full
        Runnable producer = () -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    String item = "task-" + i;
                    queue.put(item);                     // blocks if queue full
                    System.out.println("Produced: " + item);
                    Thread.sleep(50);
                }
                queue.put("DONE"); // signal consumer to stop
            } catch (InterruptedException ignored) {}
        };

        // Consumer Runnable: takes items from queue, waits if empty
        Runnable consumer = () -> {
            try {
                while (true) {
                    String item = queue.take();         // blocks if queue empty
                    if ("DONE".equals(item)) {
                        System.out.println("Consumer received DONE, exiting");
                        break;
                    }
                    System.out.println("Consumed: " + item);
                }
            } catch (InterruptedException ignored) {}
        };

        // run producer and consumer
        Future<?> prodFuture = pool.submit(producer);
        Future<?> consFuture = pool.submit(consumer);
        prodFuture.get(); // wait producer to finish
        consFuture.get(); // wait consumer to finish

        // shutdown pool cleanly
        pool.shutdown();
        if (!pool.awaitTermination(1, TimeUnit.SECONDS)) {
            pool.shutdownNow();
        }

        System.out.println("\n=== Thread pools and best-practice notes shown in demo ===");

        // Expected Output:

        // === Thread, Runnable ===
        // Runnable running on: Thread-0

        // === Callable + ExecutorService + Future ===
        // Future result: Result from Callable on pool-1-thread-1

        // === CompletableFuture (non-blocking composition) ===
        // CompletableFuture result: HELLO WORLD

        // === volatile vs synchronized (visibility vs atomicity) ===
        // Main saw stopRequested = true

        // Increment counters using 1000 tasks (synchronized vs AtomicInteger)
        // stopRequested set to true by Thread-1
        // syncCounter = 1000, atomicCounter = 1000

        // === Producer-Consumer using BlockingQueue ===
        // Produced: task-1
        // Consumed: task-1
        // Consumed: task-2
        // Produced: task-2
        // Produced: task-3
        // Consumed: task-3
        // Produced: task-4
        // Consumed: task-4
        // Produced: task-5
        // Consumed: task-5
        // Consumer received DONE, exiting

        // === Thread pools and best-practice notes shown in demo ===
    }
}
