public class Prac {
    public static void main(String[] args) {
        String s2 = "NT";
        int number = 7;
        String s1 = String.format(s2 + "_%03d",number);
        System.out.println(s1);
    }
}
