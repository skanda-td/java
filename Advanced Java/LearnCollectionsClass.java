import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * LearnCollectionsClass
 */
public class LearnCollectionsClass {

    public static void main(String[] args) {
        
        List <Integer> list = new ArrayList<>();
        list.add(34);
        list.add(12);
        list.add(9);
        list.add(76);
        list.add(29);
        list.add(75);

        System.out.println("min : " + Collections.min(list));
        System.out.println("max : " + Collections.max(list));
        System.out.println("frequency (9) : " + Collections.frequency(list,9));

        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        Collections.sort(list,Comparator.reverseOrder());
        System.out.println(list);

        // min : 9
        // max : 76
        // frequency (9) : 1
        // [34, 12, 9, 76, 29, 75]
        // [9, 12, 29, 34, 75, 76]
        // [76, 75, 34, 29, 12, 9]
    }
}