interface Fly{
    void fly();
}

interface Swim{
    void swim();
}

class Bird implements Fly,Swim{
    @Override
    public void fly(){
        System.out.println("Bird can fly");
    }

    @Override
    public void swim(){
        System.out.println("Bird can swin");
    }
}

public class MultipleInheritance {
    public static void main(String[] args) {
        Bird bird = new Bird();
        bird.fly();
        bird.swim();
    }
}
