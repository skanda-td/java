import java.util.ArrayList;
import java.util.List;

import java.util.Iterator;

/**
 * LearnArrayList
 */
public class LearnArrayList {
    public static void main(String[] args) {

        String[] studentName = new String[30];
        studentName[0] = "Rakesh";
        /*
         * studentName[1]
         * ........
         * studentName[28]
         */
        studentName[29] = "Harish";

        // New Student
        // try {
        //     studentName[30] = "Raman";
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }

        ArrayList <String> studentsName = new ArrayList<>();
        // InitialSize -> n, NextSize -> n + n/2 + 1;
        studentsName.add("Skanda");

        List <Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);

        list.add(4);
        System.out.println(list);

        list.add(1,50);
        System.out.println(list);

        List <Integer> newList = new ArrayList<>();
        newList.add(150);
        newList.add(160);

        list.addAll(newList);
        System.out.println(newList);
        System.out.println(list);

        list.remove(1);
        System.out.println(list);

        list.remove(Integer.valueOf(150));
        System.out.println(list);

        list.set(1, 23);
        System.out.println(list);

        System.out.println(list.contains(550));

        System.out.println(list.size());
        System.out.println(list.toString());

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        int sum = 0;
        for (Integer integer : list) {
            sum += integer;
        }
        System.out.println(sum);

        
        System.out.println(studentName.length);

        Iterator <Integer> iterator = list.iterator();

        while (iterator.hasNext()) {
            System.out.println("Iterator " + iterator.next());
        }

        list.clear();
        System.out.println(list);

         

    }
}