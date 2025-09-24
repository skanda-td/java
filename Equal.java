public class Equal {

    // private int id;
    private String s;
    public static void main(String[] args) {
        String s1 = new String();
        s1.equals(null);

        String s2 = null;
        // s2.equals(null);

        // if (s2.isNull()) {
        //     System.out.println("O");
            
        // }

        String s = new String("He");
        String s3 = new String("He");

        Equal a = new Equal();
        // a.id = 1;
        a.s = "He";

        Equal b = new Equal();
        // b.id = 1;
        b.s = "He";

        System.out.println(a.equals(b));
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println(a == b);


        System.out.println(s.equals(s3));
        System.out.println(s.hashCode());
        System.out.println(s3.hashCode());
        System.out.println(s == s3);


    }
}
