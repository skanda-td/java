public class Conditionals {
    public static void main(String[] args) {

        int number = 6;

        // Basic if-statements
        if (number > 0) {
            System.out.println("Number is positive!!!");
        }

        // if-else statements
        int n1 = -2;
        if (n1 > 0) {
            System.out.println("Number is positive!!!");
        } else {
            System.out.println("Number is negative");
        }

        // else-if statement
        int num = 0;
        if (num > 0) {
            System.out.println("Number is positive");
        } else if (num < 0) {
            System.out.println("Number is negative");
        } else {
            System.out.println("Number is zero!");
        }

        // Nested if-statements
        int x = 130;
        int y = 30;

        if (x > 0) {
            if (y > 0) {
                System.out.println("x,y > 0");
            }
        }

        // Logical operators
        int age = 25;
        boolean isStudent = false;
        if (age >= 18 && !isStudent) {
            System.out.println("Can get DL");
        }

        // Ternary operator
        int n = 9;
        String res = (n % 2 == 0) ? "Even" : "Odd";
        System.out.println(res);

        // Switch statement
        char grade = 'C';

        switch (grade) {
            case 'A':
                System.out.println("Execellent");
                break;

            case 'B':
                System.out.println("Good");
                break;

            case 'C':
                System.out.println("ok");
                break;

            default:
                System.out.println("FAIL");
                break;
        }

        // Comparing objects
        String s1 = "Hello";
        String s2 = "Hello";
        if (s1.equals(s2)) {
            System.out.println("s1==s2 ");
        }

    }
}
