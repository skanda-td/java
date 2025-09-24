class A{
     int age;

     public void show(){
        System.out.println("In show");
     }

     class B{

        public void config(){
            System.out.println("In config");
        }
     }
}

// class Able{
//     int age;

//     public void show(){
//        System.out.println("In show");
//     }

//     static class B{

//        public void config(){
//            System.out.println("In config");
//        }
//     }
// }

public class InnerClass {
    public static void main(String[] args) {
        A a = new A();
        a.show();

        A.B b = a.new B();
        b.config();
    }
}
