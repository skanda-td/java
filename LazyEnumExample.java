enum Day {
    MONDAY("First day"), TUESDAY("Second day"), WEDNESDAY("Third day"), THURSDAY("Fourth day"),
    FRIDAY("Fifth day"), SATURDAY("Sixth day"), SUNDAY("Seventh day");

    private final String description;

    private Day(String description) { this.description = description; }

    public String getDescription() { return description; }
}

public class LazyEnumExample {
    public static void main(String[] args) {
        Day today = Day.SUNDAY;
        System.out.println("Today is " + today);

        System.out.println(today.getDescription());

        switch (today) {
            case MONDAY: System.out.println("Start of the week"); break;
            case TUESDAY: System.out.println("Second day of the week"); break;
            case WEDNESDAY: System.out.println("Third day of the week"); break;
            case THURSDAY: System.out.println("Fourth day of the week"); break;
            case FRIDAY: System.out.println("Fifth day of the week"); break;
            case SATURDAY: System.out.println("Sixth day of the week"); break;
            case SUNDAY: System.out.println("Seventh day of the week"); break;
        }
    }
}

