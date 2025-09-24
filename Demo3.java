class A1 {
    public void show() throws ClassNotFoundException{
        Class.forName("Demo10");
    }
}

public class Demo3 {

    static {
        System.out.println("In Demo Static");
    }

    public static void main(String[] args){
        A1 obj = new A1();
        try {
            obj.show();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Bye");
    }
}
