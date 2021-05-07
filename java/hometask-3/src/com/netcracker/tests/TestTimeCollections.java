package com.netcracker.tests;

import com.netcracker.sources.MyLinkedList;

import java.util.*;

public class TestTimeCollections {
    public static void testLinkedList(int numActions) {
        final int numWarmup = (int) 1e5;
        long start, finish, sum;
        LinkedList<Integer> list = new LinkedList<>();

        // Warmup
        for (int i = 0; i < numWarmup; i++) {
            list.add((int) (Math.random() * i), 0);
        }

        // Testing
        sum = 0;
        for (int i = 0; i < numActions; i++) {
            int index = (int) (Math.random() * numWarmup);
            start = System.nanoTime();
            list.get(index);
            finish = System.nanoTime();
            sum += finish - start;
        }
        System.out.println("Avg time of searching an element in LinkedList of " + numWarmup + " elements: " +
                +sum / numActions + " ns");

        sum = 0;
        for (int i = 0; i < numActions; i++) {
            int index = (int) (Math.random() * numWarmup);
            start = System.nanoTime();
            list.add(index, 0);
            finish = System.nanoTime();
            list.removeFirst();
            sum += finish - start;
        }

        System.out.println("Avg time of adding an element to LinkedList of " + numWarmup + " elements: " +
                +sum / numActions + " ns");

        sum = 0;
        for (int i = 0; i < numActions; i++) {
            int index = (int) (Math.random() * numWarmup);
            start = System.nanoTime();
            list.remove(index);
            finish = System.nanoTime();
            list.add(0);
            sum += finish - start;
        }
        System.out.println("Avg time of removing an element from LinkedList of " + numWarmup + " elements: " +
                +sum / numActions + " ns");
    }

    public static void testArrayList(int numActions) {
        final int numWarmup = (int) 1e5;
        long start, finish, sum;
        ArrayList<Integer> list = new ArrayList<>();

        // Warmup
        for (int i = 0; i < numWarmup; i++) {
            list.add((int) (Math.random() * i), 0);
        }

        // Testing
        sum = 0;
        for (int i = 0; i < numActions; i++) {
            int index = (int) (Math.random() * numWarmup);
            start = System.nanoTime();
            list.get(index);
            finish = System.nanoTime();
            sum += finish - start;
        }
        System.out.println("Avg time of searching an element in ArrayList of " + numWarmup + " elements: " +
                +sum / numActions + " ns");

        sum = 0;
        for (int i = 0; i < numActions; i++) {
            int index = (int) (Math.random() * numWarmup);
            start = System.nanoTime();
            list.add(index, 0);
            finish = System.nanoTime();
            list.remove(0);
            sum += finish - start;
        }

        System.out.println("Avg time of adding an element to ArrayList of " + numWarmup + " elements: " +
                +sum / numActions + " ns");

        sum = 0;
        for (int i = 0; i < numActions; i++) {
            int index = (int) (Math.random() * numWarmup);
            start = System.nanoTime();
            list.remove(index);
            finish = System.nanoTime();
            list.add(0);
            sum += finish - start;
        }
        System.out.println("Avg time of removing an element from ArrayList of " + numWarmup + " elements: " +
                +sum / numActions + " ns");
    }

    public static void testHashSet(int numActions) {
        final int numWarmup = (int) 1e6;
        long start, finish, sum;
        HashSet<Integer> set = new HashSet<>();

        // Warmup
        for (int i = 0; i < numWarmup; i++) {
            set.add(2 * i);
        }

        // Testing
        sum = 0;
        for (int i = 0; i < numActions; i++) {
            int index = (int) (Math.random() * numWarmup);
            start = System.nanoTime();
            set.contains(index);
            finish = System.nanoTime();
            sum += finish - start;
        }
        System.out.println("Avg time of searching an element in ArrayList of " + numWarmup + " elements: " +
                +sum / numActions + " ns");

        sum = 0;
        for (int i = 0; i < numActions; i++) {
            int index = 2 * (int) (Math.random() * numWarmup) + 1;
            start = System.nanoTime();
            set.add(index);
            finish = System.nanoTime();
            set.remove(index);
            sum += finish - start;
        }

        System.out.println("Avg time of adding an element to ArrayList of " + numWarmup + " elements: " +
                +sum / numActions + " ns");

        sum = 0;
        for (int i = 0; i < numActions; i++) {
            int index = 2 * (int) (Math.random() * numWarmup);
            start = System.nanoTime();
            set.remove(index);
            finish = System.nanoTime();
            set.remove(index);
            sum += finish - start;
        }
        System.out.println("Avg time of removing an element from ArrayList of " + numWarmup + " elements: " +
                +sum / numActions + " ns");
    }

    public static void testLinkedHashSet(int numActions) {
        final int numWarmup = (int) 1e6;
        long start, finish, sum;
        LinkedHashSet<Integer> set = new LinkedHashSet<>();

        // Warmup
        for (int i = 0; i < numWarmup; i++) {
            set.add(2 * i);
        }

        // Testing
        sum = 0;
        for (int i = 0; i < numActions; i++) {
            int index = (int) (Math.random() * numWarmup);
            start = System.nanoTime();
            set.contains(index);
            finish = System.nanoTime();
            sum += finish - start;
        }
        System.out.println("Avg time of searching an element in ArrayList of " + numWarmup + " elements: " +
                +sum / numActions + " ns");

        sum = 0;
        for (int i = 0; i < numActions; i++) {
            int index = 2 * (int) (Math.random() * numWarmup) + 1;
            start = System.nanoTime();
            set.add(index);
            finish = System.nanoTime();
            set.remove(index);
            sum += finish - start;
        }

        System.out.println("Avg time of adding an element to ArrayList of " + numWarmup + " elements: " +
                +sum / numActions + " ns");

        sum = 0;
        for (int i = 0; i < numActions; i++) {
            int index = 2 * (int) (Math.random() * numWarmup);
            start = System.nanoTime();
            set.remove(index);
            finish = System.nanoTime();
            set.remove(index);
            sum += finish - start;
        }
        System.out.println("Avg time of removing an element from ArrayList of " + numWarmup + " elements: " +
                +sum / numActions + " ns");
    }

    public static void testTreeSet(int numActions) {
        final int numWarmup = (int) 1e6;
        long start, finish, sum;
        TreeSet<Integer> set = new TreeSet<>();

        // Warmup
        for (int i = 0; i < numWarmup; i++) {
            set.add(2 * i);
        }

        // Testing
        sum = 0;
        for (int i = 0; i < numActions; i++) {
            int index = (int) (Math.random() * numWarmup);
            start = System.nanoTime();
            set.contains(index);
            finish = System.nanoTime();
            sum += finish - start;
        }
        System.out.println("Avg time of searching an element in ArrayList of " + numWarmup + " elements: " +
                +sum / numActions + " ns");

        sum = 0;
        for (int i = 0; i < numActions; i++) {
            int index = 2 * (int) (Math.random() * numWarmup) + 1;
            start = System.nanoTime();
            set.add(index);
            finish = System.nanoTime();
            set.remove(index);
            sum += finish - start;
        }

        System.out.println("Avg time of adding an element to ArrayList of " + numWarmup + " elements: " +
                +sum / numActions + " ns");

        sum = 0;
        for (int i = 0; i < numActions; i++) {
            int index = 2 * (int) (Math.random() * numWarmup);
            start = System.nanoTime();
            set.remove(index);
            finish = System.nanoTime();
            set.remove(index);
            sum += finish - start;
        }
        System.out.println("Avg time of removing an element from ArrayList of " + numWarmup + " elements: " +
                +sum / numActions + " ns");
    }

    public static void testHashMap(int numActions) {
        final int numWarmup = (int) 1e6;
        long start, finish, sum;
        HashMap<Integer, Integer> map = new HashMap<>();

        // Warmup
        
        for (int i = 0; i < numWarmup; i++) {
            map.put(2 * i, 0);
        }

        // Testing
        sum = 0;
        for (int i = 0; i < numActions; i++) {
            int index = (int) (Math.random() * numWarmup) * 2;
            start = System.nanoTime();
            map.containsKey(index);
            finish = System.nanoTime();
            sum += finish - start;
        }
        System.out.println("Avg time of searching an element in ArrayList of " + numWarmup + " elements: " +
                +sum / numActions + " ns");

        sum = 0;
        for (int i = 0; i < numActions; i++) {
            int key = 2 * (int) (Math.random() * numWarmup) + 1;
            start = System.nanoTime();
            map.put(key, 0);
            finish = System.nanoTime();
            map.remove(key);
            sum += finish - start;
        }

        System.out.println("Avg time of adding an element to ArrayList of " + numWarmup + " elements: " +
                +sum / numActions + " ns");

        sum = 0;
        for (int i = 0; i < numActions; i++) {
            int key = 2 * (int) (Math.random() * numWarmup) + 1;
            start = System.nanoTime();
            map.remove(key);
            finish = System.nanoTime();
            map.put(key, 0);
            sum += finish - start;
        }
        System.out.println("Avg time of removing an element from ArrayList of " + numWarmup + " elements: " +
                +sum / numActions + " ns");
    }

    public static void testLinkedHashMap(int numActions) {
        final int numWarmup = (int) 1e6;
        long start, finish, sum;
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

        // Warmup

        for (int i = 0; i < numWarmup; i++) {
            map.put(2 * i, 0);
        }

        // Testing
        sum = 0;
        for (int i = 0; i < numActions; i++) {
            int index = (int) (Math.random() * numWarmup) * 2;
            start = System.nanoTime();
            map.containsKey(index);
            finish = System.nanoTime();
            sum += finish - start;
        }
        System.out.println("Avg time of searching an element in ArrayList of " + numWarmup + " elements: " +
                +sum / numActions + " ns");

        sum = 0;
        for (int i = 0; i < numActions; i++) {
            int key = 2 * (int) (Math.random() * numWarmup) + 1;
            start = System.nanoTime();
            map.put(key, 0);
            finish = System.nanoTime();
            map.remove(key);
            sum += finish - start;
        }

        System.out.println("Avg time of adding an element to ArrayList of " + numWarmup + " elements: " +
                +sum / numActions + " ns");

        sum = 0;
        for (int i = 0; i < numActions; i++) {
            int key = 2 * (int) (Math.random() * numWarmup) + 1;
            start = System.nanoTime();
            map.remove(key);
            finish = System.nanoTime();
            map.put(key, 0);
            sum += finish - start;
        }
        System.out.println("Avg time of removing an element from ArrayList of " + numWarmup + " elements: " +
                +sum / numActions + " ns");
    }

    public static void testTreeMap(int numActions) {
        final int numWarmup = (int) 1e6;
        long start, finish, sum;
        TreeMap<Integer, Integer> map = new TreeMap<>();

        // Warmup

        for (int i = 0; i < numWarmup; i++) {
            map.put(2 * i, 0);
        }

        // Testing
        sum = 0;
        for (int i = 0; i < numActions; i++) {
            int index = (int) (Math.random() * numWarmup) * 2;
            start = System.nanoTime();
            map.containsKey(index);
            finish = System.nanoTime();
            sum += finish - start;
        }
        System.out.println("Avg time of searching an element in ArrayList of " + numWarmup + " elements: " +
                +sum / numActions + " ns");

        sum = 0;
        for (int i = 0; i < numActions; i++) {
            int key = 2 * (int) (Math.random() * numWarmup) + 1;
            start = System.nanoTime();
            map.put(key, 0);
            finish = System.nanoTime();
            map.remove(key);
            sum += finish - start;
        }

        System.out.println("Avg time of adding an element to ArrayList of " + numWarmup + " elements: " +
                +sum / numActions + " ns");

        sum = 0;
        for (int i = 0; i < numActions; i++) {
            int key = 2 * (int) (Math.random() * numWarmup) + 1;
            start = System.nanoTime();
            map.remove(key);
            finish = System.nanoTime();
            map.put(key, 0);
            sum += finish - start;
        }
        System.out.println("Avg time of removing an element from ArrayList of " + numWarmup + " elements: " +
                +sum / numActions + " ns");
    }

    public static void main(String[] args) {
        int numActions = 10000;
        System.out.println("--------Testing collections-------\n");

        System.out.println("\n------------LinkedList------------\n");

        testLinkedList(numActions);

        System.out.println("\n----------------------------------\n");

        System.out.println("\n------------ArrayList-------------\n");

        testArrayList(numActions);

        System.out.println("\n----------------------------------\n");

        System.out.println("\n-------------HashSet--------------\n");

        testHashSet(numActions);

        System.out.println("\n----------------------------------\n");

        System.out.println("\n----------LinkedHashSet-----------\n");

        testLinkedHashSet(numActions);

        System.out.println("\n----------------------------------\n");

        System.out.println("\n-------------TreeSet--------------\n");

        testTreeSet(numActions);

        System.out.println("\n----------------------------------\n");

        System.out.println("\n-------------HashMap--------------\n");

        testHashMap(numActions);

        System.out.println("\n----------------------------------\n");

        System.out.println("\n----------LinkedHashMap-----------\n");

        testLinkedHashMap(numActions);

        System.out.println("\n----------------------------------\n");

        System.out.println("\n-------------TreeMap--------------\n");

        testTreeMap(numActions);

        System.out.println("\n----------------------------------\n");

        System.out.println("\n----End of testing collections----\n");
    }
}
