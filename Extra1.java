import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Extra1 {
    public static void main(String[] args) throws NumberFormatException, IOException {

        int num;
        // BufferedReader br = null;

        // try {
        // System.out.print("Enter a number : ");
        // br = new BufferedReader(new InputStreamReader(System.in));
        // num = Integer.parseInt(br.readLine());
        // System.out.println(num);
        // }
        // finally {
        // br.close();
        // }

        System.out.print("Enter a number : ");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            num = Integer.parseInt(br.readLine());
            System.out.println(num);
        }
    }
}
