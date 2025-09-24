// Parent class
class Animal {
    void eat() {
        System.out.println("Animal is eating");
    }

    void makeSound() {
        System.out.println("Generic Animal Sound");
    }
}

// Child class inheriting from Animal
class Dog extends Animal {
    void bark() {
        System.out.println("Dog is barking");
    }

    void eat() {
        super.eat(); // Calls the eat() method of the parent class
        System.out.println("Dog is eating");
    }

    void makeSound() {
        System.out.println("Dog Barks.");
    }
}

abstract class Sha {
    abstract void draw();
}

class Circ extends Sha {
    void draw() {
        System.out.println("Drawing a Circle");
    }
}

// Usage
public class Main {
    public static void main(String[] args) {
        Dog myDog = new Dog();
        myDog.eat(); // Inherited method
        myDog.bark(); // Method from the child class

        Animal1 a = new Animal1();
        a.makeSound();
        myDog.makeSound();

        myDog.eat();

        Animal myAnimal = new Dog();  // Polymorphic reference
        myAnimal.makeSound();  // Calls overridden method in Dog

        // Sha s1 = new Sha ();
        Circ myCircle = new Circ();
        myCircle.draw();  // Calls overridden draw() method in Circle
    }
}
