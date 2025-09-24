public class Casting {
    public static void main(String[] args) {
        int a = 10;
        double d = a;
        System.out.println(d);

        int b = (int) d;
        System.out.println(b);

        int intValue = 1000000000;
        byte byteValue = (byte) intValue;
        System.out.println(byteValue);

        int intValue1 = 123456789;
        float floatValue = intValue1; // int to float (implicit conversion)
        System.out.println(floatValue); // Output: 1.23456792E8

    }
}
