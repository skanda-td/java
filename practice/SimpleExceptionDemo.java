package practice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SimpleExceptionDemo {

    // ----- throws (checked exception declaration) -----
    static void readFile(String path) throws IOException {
        // try-with-resources → auto closes resource
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            System.out.println(br.readLine());
        }
    }

    // ----- throw (explicitly throwing exception) -----
    static void validateAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Age must be 18 or above");
        }
    }

    public static void main(String[] args) {

        // ----- unchecked exception handling -----
        try {
            int x = 10 / 0; // ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("Division by zero handled");
        } finally {
            System.out.println("Finally always runs");
        }

        // ----- throw example -----
        try {
            validateAge(16);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // ----- checked exception handling -----
        try {
            readFile("test.txt"); // may throw IOException
        } catch (IOException e) {
            System.out.println("File handling error");
        }

        System.out.println("Program continues normally");
    }
}