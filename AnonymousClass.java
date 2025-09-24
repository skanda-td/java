class AC{
    public void show(){
        System.out.println("Show");
    }
}

// class BC extends AC{
//     public void show(){
//         System.out.println("Show BC");
//     }
// }

public class AnonymousClass {
    public static void main(String[] args) {
        // Inner class as it is inside AnonymousClass class.
        // Anonymous class as it as no name.
        AC obj = new AC(){
            @Override
            public void show() {
                System.out.println("In AnonymousClass Show");
            }
        };
        obj.show();
    }
}
