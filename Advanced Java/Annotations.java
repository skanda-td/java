@Deprecated
class A{
    public void showMethod(){
        System.out.println("In A");
    }
}

class B extends A{
    @Override
    public void showMethod(){
        System.out.println("In B");
    }
}

public class Annotations {
    public static void main(String[] args) {
        B obj = new B();
        obj.showMethod();

        // FutureRefactor in SAC (Variables also).
    }
}
