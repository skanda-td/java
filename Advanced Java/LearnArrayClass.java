import java.util.Arrays;

public class LearnArrayClass {
    public static void main(String[] args) {
        
        int [] numbers = {1,2,3,4,5,6,7,8,9,10};
        int index = Arrays.binarySearch(numbers, 4);

        System.out.println(index);

        Integer [] valuIntegers = {5, 2, 9, 1, 7, 4, 8, 3, 6, 10};
        Arrays.sort(valuIntegers);

        for (Integer integer : valuIntegers) {
            System.out.print(integer + " ");
        }

        System.out.println();
        Arrays.fill(valuIntegers,13);
        
        for (Integer integer : valuIntegers) {
            System.out.print(integer + " ");
        }
    }
}
