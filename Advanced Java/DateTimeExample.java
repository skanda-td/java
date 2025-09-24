import java.time.*;
import java.time.format.*;
import java.time.temporal.*;

public class DateTimeExample {
    public static void main(String[] args) {
        // LocalDate
        LocalDate today = LocalDate.now();
        System.out.println("LocalDate: " + today);

        // LocalTime
        LocalTime now = LocalTime.now();
        System.out.println("LocalTime: " + now);

        // LocalDateTime
        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println("LocalDateTime: " + currentDateTime);

        // ZonedDateTime
        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println("ZonedDateTime: " + zonedDateTime);

        // Instant
        Instant instant = Instant.now();
        System.out.println("Instant: " + instant);

        // Duration
        Duration duration = Duration.ofHours(2);
        System.out.println("Duration: " + duration);

        // Period
        Period period = Period.ofMonths(3);
        System.out.println("Period: " + period);

        // TemporalAdjuster
        TemporalAdjuster nextTuesday = TemporalAdjusters.next(DayOfWeek.TUESDAY);
        LocalDate nextTuesdayDate = today.with(nextTuesday);
        System.out.println("Next Tuesday: " + nextTuesdayDate);

        // TemporalAmount
        TemporalAmount amount = Duration.ofDays(5);
        LocalDateTime futureDateTime = currentDateTime.plus(amount);
        System.out.println("Future DateTime: " + futureDateTime);

        // DateTimeFormatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);
        System.out.println("Formatted DateTime: " + formattedDateTime);

        // ChronoUnit
        long daysBetween = ChronoUnit.DAYS.between(LocalDate.of(2023, 1, 1), LocalDate.of(2024, 1, 1));
        System.out.println("Days between 2023-01-01 and 2024-01-01: " + daysBetween);

        // Clock
        Clock clock = Clock.systemUTC();
        Instant clockInstant = Instant.now(clock);
        System.out.println("Clock Instant: " + clockInstant);

        // Parsing Example
        String dateStr = "2024-04-01";
        LocalDate parsedDate = LocalDate.parse(dateStr);
        System.out.println("Parsed date: " + parsedDate);

        // Period Example
        LocalDate startDate = LocalDate.of(2020, 1, 1);
        LocalDate endDate = LocalDate.of(2022, 12, 31);
        Period period1 = Period.between(startDate, endDate);
        System.out.println("Period between " + startDate + " and " + endDate + ": " + period1);

        // Duration Example
        LocalTime startTime = LocalTime.of(10, 0);
        LocalTime endTime = LocalTime.of(12, 30);
        Duration duration1 = Duration.between(startTime, endTime);
        System.out.println("Duration between " + startTime + " and " + endTime + ": " + duration1);
        
    }
}
