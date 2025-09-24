import java.util.ArrayList;
import java.util.List;

public class Skanda {

    public static void main(String[] args) {
    System.out.println("Hello World!!!");

    List <Integer> numList = new ArrayList<>(List.of(1));
    System.out.println(numList);
    numU(numList);
    System.out.println(numList);

}

public static void numU(List <Integer> nums){
    nums.add(2);
}
}