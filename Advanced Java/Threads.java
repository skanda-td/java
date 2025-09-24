// class A extends Thread{
//     public void run(){
//         for (int i = 0; i < 10; i++) {
//             System.out.println("Thread 1 : " + i);
//             try {
//                 Thread.sleep(10);
//             } catch (InterruptedException e) {
//                 e.printStackTrace();
//             }
//         }
//     }
// }

// class B extends Thread{
//     public void run(){
//         for (int i = 0; i < 10; i++) {
//             System.out.println("Thread 2 : " + i);
//             try {
//                 Thread.sleep(10);
//             } catch (InterruptedException e) {
//                 e.printStackTrace();
//             }
//         }
//     }
// }

// public class Threads {
//     public static void main(String[] args) {
//         A obj1 = new A();
//         B obj2 = new B();

//         System.out.println(obj1.getPriority()); // Default Priority = 5
//         System.out.println(obj2.getPriority());

//         obj2.setPriority(Thread.MAX_PRIORITY);

//         obj1.start();
//         try {
//             Thread.sleep(10);
//         } catch (InterruptedException e) {
//             e.printStackTrace();
//         }
//         obj2.start();
//     }
// }

// class A implements Runnable{
//     public void run(){
//         for (int i = 0; i < 10; i++) {
//             System.out.println("Thread 1 : " + i);
//             try {
//                 Thread.sleep(1000);
//             } catch (InterruptedException e) {
//                 e.printStackTrace();
//             }
//         }
//     }
// }

// class B implements Runnable {
//     public void run() {
//         for (int i = 0; i < 10; i++) {
//             System.out.println("Thread 2 : " + i);
//             try {
//                 Thread.sleep(1000);
//             } catch (InterruptedException e) {
//                 e.printStackTrace();
//             }
//         }
//     }
// }

class Counter{
    private int count;
    public int getCount() {
        return count;
    }
    public synchronized void increment(){
        count++;
    }
}

public class Threads {
    public static void main(String[] args) {

        Counter c = new Counter();

        Runnable obj1 = () -> {
            for (int i = 1; i <= 10000; i++) {
                c.increment();
            }
        };

        Runnable obj2 = () -> {
            for (int i = 1; i <= 10000; i++) {
                c.increment();
            }
        };

        Thread t1 = new Thread(obj1);
        Thread t2 = new Thread(obj2);

        t1.start();
        t2.start();

        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(c.getCount());
    }
}