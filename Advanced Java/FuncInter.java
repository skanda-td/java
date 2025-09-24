@FunctionalInterface
interface AB {
    int add(int a, int b);
    // Only single un-implemented method;
}

// class BC implements AB{
// @Override
// public void show() {
// System.out.println("AB implmented in BC");
// }
// }

@FunctionalInterface
interface B{
    void show();
}

public class FuncInter {
    public static void main(String[] args) {
        // AB obj = new BC();
        // Lambda Expression see FunctionalInterface Link
        // AB obj = integer -> System.out.println("AB implmented and int value is : " + integer);
        // obj.show(5);

        AB obj = (a,b) -> a + b;
        System.out.println(obj.add(1, 2));

        B ob = () -> System.out.println("Implemnetd");
        ob.show();
    }
}
