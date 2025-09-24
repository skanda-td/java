import java.util.Objects;
class MyClass {

    private int id;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public MyClass(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        MyClass myClass = (MyClass) obj;
        return id == myClass.id && name.equals(myClass.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}

public class Run{
    public static void main(String[] args) {
        MyClass obj1 = new MyClass(1, "Skanda");
        MyClass obj2 = new MyClass(1, "Skanda");
        System.out.println("Using Equals " + obj1.equals(obj2));
        System.out.println("Using HashCode " + obj1.hashCode());
        System.out.println("Using HashCode " + obj2.hashCode());
        System.out.println("Using == " + (obj1 == obj2));
        System.out.println("Using Equals " + obj1.getName().equals(obj2.getName()));
        System.out.println("Using HashCode " + obj1.getName().hashCode());
        System.out.println("Using HashCode " + obj2.getName().hashCode());
    }
}
