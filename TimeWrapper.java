import java.time.LocalTime;

public class TimeWrapper {
    private LocalTime localTime;
    private int originalTimeInMinutes;

    // Constructor to handle the time conversion and special case for 1440
    public TimeWrapper(int timeInMinutes) {
        this.originalTimeInMinutes = timeInMinutes;
        if (timeInMinutes == 1440) {
            this.localTime = LocalTime.MIDNIGHT; // Treat 1440 as 00:00 in LocalTime
        } else if (timeInMinutes >= 0 && timeInMinutes < 1440) {
            int hours = timeInMinutes / 60;
            int minutes = timeInMinutes % 60;
            this.localTime = LocalTime.of(hours, minutes);
        } else {
            throw new IllegalArgumentException("Invalid time: " + timeInMinutes);
        }
    }

    // Method to get the original time as an integer (for old system compatibility)
    public int getOriginalTimeInMinutes() {
        return originalTimeInMinutes;
    }

    // Method to get the time as LocalTime (for new system operations)
    public LocalTime getLocalTime() {
        return localTime;
    }

    // Example of how to use this
    public static void main(String[] args) {
        int oldSystemTime = 1440; // Example time from the old system

        // Create the wrapper
        TimeWrapper timeWrapper = new TimeWrapper(oldSystemTime);

        // Fetch the original time (old system logic)
        System.out.println("Original time (minutes): " + timeWrapper.getOriginalTimeInMinutes());

        // Fetch the converted LocalTime
        System.out.println("Converted LocalTime: " + timeWrapper.getLocalTime());
        
        // For logic checks in the old system, you can still use getOriginalTimeInMinutes()
        if (timeWrapper.getOriginalTimeInMinutes() == 1440) {
            System.out.println("This is the end of the day in the old system.");
        }
    }
}