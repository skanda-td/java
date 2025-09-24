import java.util.Scanner;

public class UserInput {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter any integer : ");
        int a = sc.nextInt();
        System.out.println(a);

        System.out.println("Enter any name : ");
        String name = sc.next();
        System.out.println("Hello " + name);

        System.out.println("Enter any decimal number : ");
        double b = sc.nextDouble();
        System.out.println(b);

        // sc.nextLine();

        if (sc.hasNextInt()) {
            int i = sc.nextInt();
            System.out.println(i);
        }
        else{
            System.out.println("Enter Integer Only");
        }

        sc.close();
    }
}