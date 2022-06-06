package arraylist_vs_linkedlist;

import java.util.ArrayList;
import java.util.LinkedList;

public class Comparison {

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        LinkedList<Integer> link = new LinkedList<>();

        int elements = 10000000;

        System.out.println("Calculating time initialization for the list with: " + elements + " elements");

        long startArrInit =System.currentTimeMillis();
        for (int i = 0; i < elements; i++) {
            arr.add(i);
        }

        System.out.println("Time initialization for arraylist with " + elements +
                 " elements took " + (System.currentTimeMillis() - startArrInit) + "ms");

        long startLinkInit = System.currentTimeMillis();
        for (int i = 0; i < elements; i++) {
            link.addLast(i);
        }

        System.out.println("Time initialization for linked-list with " + elements +
                " elements took " + (System.currentTimeMillis() - startLinkInit) + "ms");

        System.out.println("\nCalculating time modification for the list with: " + elements + " elements");

        long startArrMod = System.currentTimeMillis();
//        arr.removeIf(n -> n % 10 == 0);
        arr.remove(elements / 2);
        System.out.println("Time modification for arraylist with " + elements +
                " elements took " + (System.currentTimeMillis() - startArrMod) + "ms");

        long startLinkMod = System.currentTimeMillis();
//        link.removeIf(n -> n % 10 == 0);
        link.remove(elements / 2);

        System.out.println("Time modification for linked-list with " + elements +
                " elements took " + (System.currentTimeMillis() - startLinkMod) + "ms");
    }
}
