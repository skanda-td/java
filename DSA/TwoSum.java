package DSA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class TwoSum {
    public static void main(String[] args) {
        getTwoSumBrute();
        getTwoSumBrute2();
        getTwoSumBetter();
        getTwoSumBest();
    }

    private static void getTwoSumBest() {
        // Best  - Sort & two pointer
        List<Integer> arrayList = new ArrayList<>(Arrays.asList(2, 6, 5, 8, 11));
        int target = 14;
        arrayList.sort(Comparator.naturalOrder());

        for (int i = 0, j = arrayList.size() - 1; i < j; i++, j--) {
            if (arrayList.get(i) + arrayList.get(j) == target) {
                System.out.println(true);
                return;
            }
            else if (arrayList.get(i) + arrayList.get(j) < target) i++;
            else j--;
        }

        System.out.println(false);
    }

    private static void getTwoSumBetter() {
        // Better - HashMap

        int array[] = {2,6,5,8,11};
        int target = 14;
        boolean output = false;

        // HashMap<KeyType, ValueType> - value and index
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            // Dry run for more
            int neededInt = target - array[i];
            if (hashMap.containsKey(neededInt)) {
                output = true;
                System.out.println("True : " + i + " " + hashMap.get(neededInt));
            }
            else hashMap.put(array[i],i);
        }

        if (!output) {
            System.out.println("False : Empty/End");
        }
    }

    private static void getTwoSumBrute2() {
        // Brute Force 2

        int array[] = {2,6,5,8,11};
        int target = 14;
        boolean output = false;

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == target) {
                    output = true;
                    System.out.println("True : " + i + " " + j);
                } 
            }
        }
        
        if (!output) {
            System.out.println("False : Empty/End");
        }
    }

    private static void getTwoSumBrute() {
        // Brute Force

        int array[] = {2,6,5,8,11};
        int target = 14;
        boolean output = false;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i == j) continue; // No repetative
                if (array[i] + array[j] == target) {
                    output = true;
                    System.out.println("True : " + i + " " + j);
                } 
            }
        }

        if (!output) {
            System.out.println("False : Empty/End");
        }
    }
}
