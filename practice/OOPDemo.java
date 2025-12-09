package practice;

// OOPDemo.java
import java.util.Objects;
import java.util.List;

/*
  Demonstrates:
  - class / object
  - encapsulation (private fields + getters/setters)
  - constructor, this, static
  - inheritance (abstract base + concrete subclass)
  - interface (capability)
  - composition (has-a)
  - polymorphism (override)
  - overloading (same name, different params)
  - final (variable, method, class)
  - immutable class
  - equals() and hashCode()
*/

/////////////////////////
// Immutable value type
/////////////////////////
final class Address {
    // final class: cannot be extended (helps immutability)
    private final String street; // final field: set once
    private final String city;

    public Address(String street, String city) {
        // constructor assigns final fields
        this.street = street;
        this.city = city;
    }

    public String getStreet() { return street; } // no setter -> cannot change
    public String getCity() { return city; }

    // public void setStreet(String street) {
    //     // compilation error: cannot assign a value to final variable street
    //     // this.street = street; 
    //     // // The final field Address.street cannot be assignedJava(33554512)
    // }

    @Override
    public String toString() {
        return street + ", " + city;
    }

    // equals/hashCode so Address can be used as a value reliably
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;               // same reference
        if (o == null || getClass() != o.getClass()) return false;
        Address a = (Address) o;
        return Objects.equals(street, a.street) &&
               Objects.equals(city, a.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, city);
    }
}

// class A extends Address{
// The type A cannot subclass the final class Address
// }

/////////////////////////
// Encapsulation example
/////////////////////////
class Person {
    private String name;        // private field -> encapsulated
    private int age;

    public Person(String name, int age) {
        this.name = name;       // 'this' distinguishes field from param
        this.age = age;
    }

    public String getName() { return name; }    // controlled access
    public void setName(String name) { this.name = name; } // setter allows controlled mutation

    public int getAge() { return age; }
    public void setAge(int age) {
        if (age < 0) throw new IllegalArgumentException("age < 0"); // guard invariant
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}


/////////////////////////
// Interface: capability
/////////////////////////
interface Drivable {
    void accelerate(int delta);  // capability method
    void brake(int delta);
}

/////////////////////////
// Abstract class: partial implementation / abstraction
/////////////////////////
abstract class Vehicle implements Drivable {
    protected final String model;    // protected visible in subclasses
    private int speed;               // encapsulated
    private final Address origin;    // composition: vehicle "has an" address (origin)

    public Vehicle(String model, Address origin) {
        this.model = model;          // final field set in constructor
        this.origin = origin;        // store composed object (immutable Address)
        this.speed = 0;              // default speed
    }

    public String getModel() { return model; }
    public int getSpeed() { return speed; }
    protected void setSpeed(int s) { this.speed = Math.max(0, s); } // controlled mutation

    public Address getOrigin() { return origin; } // returns immutable object safely

    // a concrete method shared by subclasses
    public void info() {
        System.out.println("Model: " + model + ", speed: " + speed + ", origin: " + origin);
    }

    // final method cannot be overridden by subclasses
    public final void start() {
        System.out.println(model + " started");
    }

    // abstract method forces subclasses to provide specific behavior
    public abstract void horn();
}

/////////////////////////
// Concrete subclass: inheritance + overriding
/////////////////////////
class Car extends Vehicle {
    private final String engineType;      // car-specific state

    public Car(String model, Address origin, String engineType) {
        super(model, origin);             // call parent constructor (super)
        this.engineType = engineType;
    }

    // overriding abstract method
    @Override
    public void horn() {
        System.out.println("Car horn: beep beep!");
    }
    
    // implement interface methods (from Vehicle -> Drivable)
    @Override
    public void accelerate(int delta) {
        // call protected setter in parent
        setSpeed(getSpeed() + Math.abs(delta));
    }

    @Override
    public void brake(int delta) {
        setSpeed(getSpeed() - Math.abs(delta));
    }

    // overloaded method: same name, different parameters
    public void accelerate() {
        accelerate(10); // default accelerate
    }

    @Override
    public String toString() {
        return "Car{" + model + ", engine=" + engineType + ", speed=" + getSpeed() + "}";
    }
}

/////////////////////////
// Another subclass to show polymorphism
/////////////////////////
class Bike extends Vehicle {
    public Bike(String model, Address origin) {
        super(model, origin);
    }

    @Override
    public void horn() {
        System.out.println("Bike horn: trii trii!");
    }

    @Override
    public void accelerate(int delta) {
        setSpeed(getSpeed() + Math.abs(delta / 2)); // bikes accelerate slower
    }

    @Override
    public void brake(int delta) {
        setSpeed(getSpeed() - Math.abs(delta / 2));
    }

    @Override
    public String toString() {
        return "Bike{" + model + ", speed=" + getSpeed() + "}";
    }
}

/////////////////////////
// Utility: demonstrates static method and overloading
/////////////////////////
class Utils {
    // static method: belongs to class, not instance
    public static void printVehicles(Vehicle... vehicles) {
        for (Vehicle v : vehicles) {
            v.info();               // polymorphism: calls subclass info()
        }
    }

    // overloaded utility: accepts list
    public static void printVehicles(List<Vehicle> list) {
        for (Vehicle v : list) v.info();
    }
}

public class OOPDemo {
    public static void main(String[] args) {
        // create immutable Address objects (composition)
        Address addr1 = new Address("1st Street", "Mumbai"); // immutable
         Address addr2 = new Address("2nd Avenue", "Bengaluru");

        System.out.println(addr1.toString());
        System.out.println(addr2.toString());

        System.out.println(addr1.equals(addr2));
        System.out.println(addr1.hashCode());
        System.out.println(addr2.hashCode());

        // addr1.setStreet("New Street"); // compilation error: no setter

        // create Person demonstrating encapsulation
        Person p = new Person("Skanda", 25);
        // p.setAge(-1);
        // Exception in thread "main" java.lang.IllegalArgumentException: age < 0
        // at practice.Person.setAge(OOPDemo.java:88)
        // at practice.OOPDemo.main(OOPDemo.java:115)
        p.setAge(26);// safe update via setter
        System.out.println("Person: " + p); // uses toString()

        // create Vehicles (inheritance + composition)
        Car car = new Car("Honda City", addr1, "Petrol");
        Bike bike = new Bike("Royal Enfield", addr2);

        // polymorphism: Vehicle reference holds Car
        Vehicle v = car;             // upcast to parent type
        v.start();                   // final method from Vehicle
        v.horn();                    // dynamic dispatch -> Car.horn()

        // accelerate using overridden methods
        car.accelerate(30);          // Car implementation
        bike.accelerate(20);         // Bike implementation (different behavior)
        System.out.println(car);     // calls Car.toString()
        System.out.println(bike);    // calls Bike.toString()

        // overloaded method
        car.accelerate();            // uses default overload

        // static utility usage
        Utils.printVehicles(car, bike);

        // equals/hashCode on Address (value semantics)
        Address sameAsAddr1 = new Address("1st Street", "Mumbai");
        System.out.println("addr1 equals sameAsAddr1? " + addr1.equals(sameAsAddr1));

        // demonstrate instanceof and safe casting
        if (v instanceof Car) {
            Car c = (Car) v;         // downcast safe because v actually points to Car
            System.out.println("Downcasted model: " + c.getModel());
        }

        // show immutability: cannot change Address fields (no setters)
        System.out.println("Origin of car: " + car.getOrigin());

        // composition: Vehicle has an Address (we used it)
        // end
    }

    // Expected output:

    // 1st Street, Mumbai
    // 2nd Avenue, Bengaluru
    // false
    // -452842891
    // -698079860
    // Person: Skanda (26)
    // Honda City started
    // Car horn: beep beep!
    // Car{Honda City, engine=Petrol, speed=30}
    // Bike{Royal Enfield, speed=10}
    // Model: Honda City, speed: 40, origin: 1st Street, Mumbai
    // Model: Royal Enfield, speed: 10, origin: 2nd Avenue, Bengaluru
    // addr1 equals sameAsAddr1? true
    // Downcasted model: Honda City
    // Origin of car: 1st Street, Mumbai
}