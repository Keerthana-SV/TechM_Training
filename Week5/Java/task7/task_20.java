package org.example.assignment.corejava.Task7;

import java.util.LinkedList;
import java.util.Scanner;

public class task20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> list = new LinkedList<>();

        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter the elements: ");
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        System.out.print("Enter the element to find occurrences: ");
        int element = sc.nextInt();

        int first = list.indexOf(element);
        int last = list.lastIndexOf(element);

        if (first != -1) {
            System.out.println("First occurrence of " + element + " is at index: " + first);
            System.out.println("Last occurrence of " + element + " is at index: " + last);
        } else {
            System.out.println("Element not found in the list.");
        }
    }
}
