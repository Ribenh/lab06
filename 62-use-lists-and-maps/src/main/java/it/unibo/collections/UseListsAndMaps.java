package it.unibo.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import static java.util.concurrent.TimeUnit.NANOSECONDS;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private static final long AFRICA_POPULATION = 1110635000;
    private static final long AMERICAS_POPULATION = 972005000;
    private static final long ANTARCTICA_POPULATION = 0;
    private static final long ASIA_POPULATION = 4298723000L;
    private static final long EUROPE_POPULATION = 742452000;
    private static final long OCEANIA_POPULATION = 38304000;


    private UseListsAndMaps() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1000; i < 2000; i++) {
            list.add(i);
        }
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        LinkedList<Integer> linked = new LinkedList<>(list);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        int temp = list.get(list.size() - 1);
        list.set(list.size() - 1, list.get(0));
        list.set(0, temp);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for (int i : list) {
            System.out.println(i);
        }
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        long time = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            list.add(0, i);
        }
        time = System.nanoTime() - time;
        System.out.println("Inserting " + 100000 + " elements as first in an ArrayList took " + timeAsString(time));
        
        time = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            linked.add(0, i);
        }
        time = System.nanoTime() - time;
        System.out.println("Inserting " + 100000 + " elements as first in a LinkedList took " + timeAsString(time));
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        time = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            list.get(list.size() / 2);
        }
        time = System.nanoTime() - time;
        System.out.println("Reading " + 1000 + " times an element in the middle ArrayList " + timeAsString(time));

        time = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            linked.get(linked.size() / 2);
        }
        time = System.nanoTime() - time;
        System.out.println("Reading " + 1000 + " times an element in the middle LinkedList " + timeAsString(time));
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        Map<String, Long> world = new HashMap<>();
        /*
         * 8) Compute the population of the world
         */
        world.put("Africa", AFRICA_POPULATION);
        world.put("Americas", AMERICAS_POPULATION);
        world.put("Antarctica", ANTARCTICA_POPULATION);
        world.put("Asia", ASIA_POPULATION);
        world.put("Europe", EUROPE_POPULATION);
        world.put("Oceania", OCEANIA_POPULATION);
    }
    
    private static String timeAsString(final long nanoseconds) {
        return nanoseconds + "ns (" + NANOSECONDS.toMillis(nanoseconds) + "ms)";
    }
}
