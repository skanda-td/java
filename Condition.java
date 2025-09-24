import java.math.BigDecimal;
import java.math.RoundingMode;

public class Condition {
    public static void main(String[] args) {
        // if (false) {
        //     System.out.println("if");
        // }
        // else if (true) {
        //     System.out.println("else if");
        // }
        // else {
        //     System.out.println("Else");
        // }

        String trail = "21";
        System.out.println(trail.substring(0,1));

        double a = 160000.0;
        double b = 370000.0;
        // BigDecimal bigDecimal = new BigDecimal(a/b).setScale(6,RoundingMode.HALF_UP);

        BigDecimal numerator = BigDecimal.valueOf(a);
        BigDecimal denominator = BigDecimal.valueOf(b);
        double resDecimal = numerator.divide(denominator,6,RoundingMode.HALF_UP).doubleValue();
       
        System.out.println(resDecimal);

        BigDecimal result = new BigDecimal(resDecimal);
        result = result.setScale(6, RoundingMode.HALF_UP);
        double returnValue = result.doubleValue();


        System.out.println(result);
        System.out.println(returnValue);
        // System.out.println(returnValue);

         // Step 1: Create a BigDecimal instance
         BigDecimal bd = new BigDecimal("123.456789123"); // Example value with more than 6 decimal places
        
         // Step 2: Set scale to 6 decimal places
         bd = bd.setScale(6, RoundingMode.HALF_UP); // Rounding mode can be adjusted as needed
         
         // Step 3: Convert to double
         double result1 = bd.doubleValue();
         
         // Output the results
         System.out.println("BigDecimal value: " + bd); // Outputs: 123.456789
         System.out.println("Converted double value: " + result1); // Outputs: 123.456789
    }
}
