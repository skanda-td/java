public class Loops {

    public static void main(String[] args) {
        int count = 0;

        // While Loop
        while (count <= 3) {
            System.out.println("Count is " + count);
            count++;
        }

        // For Loop
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }

        // Do-While Loop
        do {
            System.out.println("Single Execution");
        } while (false);

        // Break Statement
        for (int i = 0; i < 3; i++) {
            if (i == 2) {
                break;
            }
            System.out.println("Count: " + i);
        }

        // Continue Statement
        for (int i = 0; i < 4; i++) {
            if (i == 2) {
                continue;
            }
            System.out.println("Count " + i);
        }

        // Nested Loops
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println(i + " " + j);
            }
        }

        // Enhanced for-each Loop (for-each)
        int num[] = {10,20,30,40,50};
        for (int i : num) {
            System.out.println(i);
        }
    }
}
