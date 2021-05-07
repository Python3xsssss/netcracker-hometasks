package com.netcracker.tests;

import com.netcracker.sources.MyLinkedList;

import java.util.Arrays;
import java.util.Iterator;

public class TestMyLinkedList {
    public static void main(String[] args) {
        System.out.println("--------Testing MyLinkedList-------\n");

        MyLinkedList<String> myList = new MyLinkedList<String>();
        System.out.println("\nList is empty\n");

        System.out.println("\nAdd str1");
        myList.add("Str1");
        System.out.println("My Linked list: " + myList);

        System.out.println("\nAdd str2");
        myList.add("Str2");
        System.out.println("My Linked list: " + myList);

        System.out.println("\nAdd str3 by index 1");
        myList.add(1, "Str3");
        System.out.println("My Linked list: " + myList);

        for (int i = 0; i < myList.size(); i++) {
            System.out.println("List[" + i + "] = " + myList.get(i));
        }
        System.out.println("\nStr3 has index " + myList.indexOf("Str3"));

        System.out.println("\nRemove element with index 1");
        myList.remove(1);
        System.out.println("My Linked list: " + myList);

        System.out.println("\nChange element with index 1");
        myList.set(1, "AAAAA");
        System.out.println("My Linked list: " + myList);

        System.out.println("\nSize of My Linked list: " + myList.size());

        String[] arr = new String[myList.size()];
        arr = myList.toArray(arr);
        System.out.println("\nArray created by My Linked list: " + Arrays.toString(arr));

        System.out.println("\nPrinting list by iterator: ");
        for (Iterator<String> it = myList.iterator(); it.hasNext(); System.out.print(it.next() + " "));

        System.out.println("\n----End of testing MyLinkedList----\n");
    }
}
