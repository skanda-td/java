public class ToString {
    private String name;
    private int age;

    public ToString(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Override the toString() method to provide a custom string representation
    @Override
    public String toString() {
        return this.getClass() + " with fields values : " + this.name + ", " + this.age;
    }

    public static void main(String[] args) {
        ToString obj = new ToString("Skanda", 30);
        System.out.println(obj); // Automatically calls obj.toString()
    }
}
