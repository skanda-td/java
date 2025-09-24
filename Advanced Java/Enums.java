enum Laptop{
    // Create Laptop constructor with price input;
    Macbook(2000), XPS(2200), Surface, ThinkPad(1800);

    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    private Laptop(int price) {
        this.price = price;
        System.out.println("Const Count : " + this.name());
    }

    private Laptop() {
        this.price = 500;
        System.out.println("Const Count : " + this.name());
    }
}

public class Enums {
    public static void main(String[] args) {
        // Laptop laptop = Laptop.Macbook;
        // System.out.println(laptop + " : $" + laptop.getPrice());

        for (Laptop laptop : Laptop.values()) {
            System.out.println(laptop + " : $" + laptop.getPrice()); 
        }
    }
}
