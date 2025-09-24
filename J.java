import java.time.LocalDate;
import java.time.YearMonth;

public class J {
    public static void main(String[] args) {
        // Get the current year
        int currentYear = LocalDate.now().getYear();

        // Find the last day of the 6th month
        YearMonth sixthMonth = YearMonth.of(currentYear, 6);
        System.out.println(sixthMonth);
        LocalDate lastDayOfSixthMonth = sixthMonth.atEndOfMonth();
        System.out.println("Last day of the 6th month: " + lastDayOfSixthMonth);

        // Find the last day of the 12th month
        YearMonth twelfthMonth = YearMonth.of(currentYear, 12);
        LocalDate lastDayOfTwelfthMonth = twelfthMonth.atEndOfMonth();
        System.out.println("Last day of the 12th month: " + lastDayOfTwelfthMonth);

        // PBI
        System.out.println(DateUtil.monthChange(LocalDate.of(2020, 02,1), LocalDate.of(2020, 02,1).plusDays(1)));
    }
}

class DateUtil {

    public static boolean monthChange(LocalDate date1, LocalDate date2) {

        YearMonth d1 = YearMonth.from(date1);
        System.out.println(d1.atEndOfMonth());
        LocalDate monthChange = d1.atEndOfMonth().plusDays(1);

        if (monthChange.compareTo(date2) == 0 && date1.compareTo(date2) < 0) {
            
            System.out.println(monthChange + "," + date2);
            return true;
        }
        System.out.println(monthChange + "," + date2);
        return false;
    }
}   