package com.netcracker.tests;

import com.netcracker.sources.MyLinkedList;

import java.util.LinkedList;

public class TestTimeMyLinkedList {
    public static void testCreating(int len) {
        final int numWarmup = (int) 1e5, num = 100;
        final int warmupLen = 10000;
        long start, finish, sum;

        // Warmup for LinkedList
        for (int i = 0; i < numWarmup; i++) {
            LinkedList<Integer> javaTestList = new LinkedList<>();
            for (int j = 0; j < warmupLen; j++)
                javaTestList.addLast(0);
        }

        // Testing LinkedList
        sum = 0;
        for (int i = 0; i < num; i++) {
            start = System.nanoTime();
            LinkedList<Integer> javaTestList = new LinkedList<>();
            for (int j = 0; j < len; j++)
                javaTestList.addLast(0);
            finish = System.nanoTime();
            sum += finish - start;
        }
        System.out.println("Avg time of creating LinkedList of " + len + " elements: " + sum / num + " ns");

        // Warmup for MyLinkedList
        for (int i = 0; i < numWarmup; i++) {
            MyLinkedList<Integer> myTestList = new MyLinkedList<>();
            for (int j = 0; j < warmupLen; j++)
                myTestList.add(0);
        }

        // Testing MyLinkedList
        sum = 0;
        for (int i = 0; i < num; i++) {
            start = System.nanoTime();
            MyLinkedList<Integer> myTestList = new MyLinkedList<>();
            for (int j = 0; j < len; j++)
                myTestList.add(0);
            finish = System.nanoTime();
            sum += finish - start;
        }
        System.out.println("Avg time of creating MyLinkedList of " + len + " elements: " + sum / num + " ns");
    }

    public static void testAdding(int numOfAdds) {
        final int numWarmup = (int) 1e5;
        long start, finish, sum;

        LinkedList<Integer> javaTestList = new LinkedList<>();

        // Warmup for LinkedList
        for (int i = 0; i < numWarmup; i++) {
            javaTestList.add((int) (Math.random() * i), 0);
        }

        // Testing LinkedList
        sum = 0;
        for (int i = 0; i < numOfAdds; i++) {
            int index = (int) (Math.random() * numWarmup);
            start = System.nanoTime();
            javaTestList.add(index, 0);
            finish = System.nanoTime();
            javaTestList.removeFirst();
            sum += finish - start;
        }
        System.out.println("Avg time of adding an element to LinkedList of " + numWarmup + " elements: " +
                + sum / numOfAdds + " ns");

        MyLinkedList<Integer> myTestList = new MyLinkedList<>();

        // Warmup for MyLinkedList
        for (int i = 0; i < numWarmup; i++) {
            myTestList.add((int) (Math.random() * i), 0);
        }

        // Testing MyLinkedList
        sum = 0;
        for (int i = numWarmup; i < numWarmup + numOfAdds; i++) {
            int index = (int) (Math.random() * numWarmup);
            start = System.nanoTime();
            myTestList.add(index, 0);
            finish = System.nanoTime();
            myTestList.popHead();
            sum += finish - start;
        }
        System.out.println("Avg time of adding an element to MyLinkedList of " + numWarmup + " elements: " +
                + sum / numOfAdds + " ns");
    }

    public static void testSearching(int numOfSearches) {
        final int numWarmup = (int) 1e5;
        long start, finish, sum;

        LinkedList<Integer> javaTestList = new LinkedList<>();

        // Warmup for LinkedList
        for (int i = 0; i < numWarmup; i++) {
            javaTestList.add((int) (Math.random() * i), 0);
        }

        // Testing LinkedList
        sum = 0;
        for (int i = 0; i < numOfSearches; i++) {
            int index = (int) (Math.random() * numWarmup);
            start = System.nanoTime();
            javaTestList.get(index);
            finish = System.nanoTime();
            sum += finish - start;
        }
        System.out.println("Avg time of searching an element in LinkedList of " + numWarmup + " elements: " +
                + sum / numOfSearches + " ns");

        MyLinkedList<Integer> myTestList = new MyLinkedList<>();

        // Warmup for MyLinkedList
        for (int i = 0; i < numWarmup; i++) {
            myTestList.add((int) (Math.random() * i), 0);
        }

        // Testing MyLinkedList
        sum = 0;
        for (int i = 0; i < numOfSearches; i++) {
            int index = (int) (Math.random() * numWarmup);
            start = System.nanoTime();
            myTestList.get(index);
            finish = System.nanoTime();
            sum += finish - start;
        }
        System.out.println("Avg time of searching an element in MyLinkedList of " + numWarmup + " elements: " +
                + sum / numOfSearches + " ns");
    }

    public static void testRemoving(int numOfRemoves) {
        final int numWarmup = (int) 1e5;
        long start, finish, sum;

        LinkedList<Integer> javaTestList = new LinkedList<>();

        // Warmup for LinkedList
        for (int i = 0; i < numWarmup; i++) {
            javaTestList.add((int) (Math.random() * i), 0);
        }

        // Testing LinkedList
        sum = 0;
        for (int i = 0; i < numOfRemoves; i++) {
            int index = (int) (Math.random() * numWarmup);
            start = System.nanoTime();
            javaTestList.remove(index);
            finish = System.nanoTime();
            javaTestList.add(0);
            sum += finish - start;
        }
        System.out.println("Avg time of removing an element from LinkedList of " + numWarmup + " elements: " +
                + sum / numOfRemoves + " ns");

        MyLinkedList<Integer> myTestList = new MyLinkedList<>();

        // Warmup for MyLinkedList
        for (int i = 0; i < numWarmup; i++) {
            myTestList.add((int) (Math.random() * i), 0);
        }

        // Testing MyLinkedList
        sum = 0;
        for (int i = 0; i < numOfRemoves; i++) {
            int index = (int) (Math.random() * numWarmup);
            start = System.nanoTime();
            myTestList.remove(index);
            finish = System.nanoTime();
            myTestList.add(0);
            sum += finish - start;
        }
        System.out.println("Avg time of removing an element from MyLinkedList of " + numWarmup + " elements: " +
                + sum / numOfRemoves + " ns");
    }

    public static void main(String[] args) {
        System.out.println("--------Test creating list--------");

        System.out.println();
        testCreating(100000);
        System.out.println();

        System.out.println("----------------------------------\n");

        System.out.println("--------Test adding to list-------");

        System.out.println();
        testAdding(10000);
        System.out.println();

        System.out.println("----------------------------------\n");

        System.out.println("-------Test searching in list-----");

        System.out.println();
        testSearching(10000);
        System.out.println();

        System.out.println("----------------------------------\n");

        System.out.println("------Test removing from list-----");

        System.out.println();
        testRemoving(10000);
        System.out.println();

        System.out.println("----------------------------------\n");
    }
}
