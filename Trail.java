public class Trail {
    public static void main(String[] args) {
        int x = 10;
        System.out.println("Before : " + x);
        modifyValue(x);
        System.out.println("After : " + x);

        StringBuilder str = new StringBuilder("Hello");
        System.out.println("Before : " + str);
        modifyString(str);
        System.out.println("After : " + str);
    }

    public static void modifyValue(int num){
        num = 20;
        System.out.println("Num : " + num);
    }

    public static void modifyString(StringBuilder obj){
        obj.append(" World");
        System.out.println("String : " + obj);
    }
}
