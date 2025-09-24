public class EnumValueExample {
    public static void main(String[] args) {
        DayOfWeek today = DayOfWeek.MONDAY;
        System.out.println("Today is " + today);

        System.out.println(today.getDayValue());

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

    public enum DayOfWeek {
        MONDAY(1), TUESDAY(2), WEDNESDAY(3), THURSDAY(4),
        FRIDAY(5), SATURDAY(6), SUNDAY(7);

        private final int dayValue;

        private DayOfWeek(int dayValue) { this.dayValue = dayValue; }

        public int getDayValue() { return dayValue; }
    }
}