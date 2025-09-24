import java.time.LocalDate;
import java.time.YearMonth;

public class Code {
    public static void main(String[] args) {
        // Get the current date
        LocalDate currentDate = LocalDate.parse("2023-11-20");

        // Get the YearMonth object for the current month
        YearMonth currentYearMonth = YearMonth.from(currentDate);

        // Get the last day of the month
        LocalDate lastDayOfMonth = currentYearMonth.atEndOfMonth();

        // Print the result
        System.out.println("Last day of the month: " + lastDayOfMonth);
    }
}
class SplitDateComponents {
    public static void main(String[] args) {
        // Initialize a LocalDate object (you can use any of the methods mentioned earlier)
        LocalDate date = LocalDate.of(2023, 11, 21);

        // Split day, month, and year components
        int day = date.getDayOfMonth();
        int month = date.getMonthValue();
        int year = date.getYear();

        // Print the components
        System.out.println("Day: " + day);
        System.out.println("Month: " + month);
        System.out.println("Year: " + year);
    }
}


