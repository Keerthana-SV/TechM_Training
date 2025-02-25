package org.example.assignment.corejava.Task7;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class task19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> list = new LinkedList<>();

        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter the elements: ");
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        System.out.print("Enter the number of elements to insert: ");
        int m = sc.nextInt();
        List<Integer> newElements = new LinkedList<>();

        System.out.println("Enter the elements to insert: ");
        for (int i = 0; i < m; i++) {
            newElements.add(sc.nextInt());
        }

        System.out.print("Enter the position to insert at: ");
        int pos = sc.nextInt();

        if (pos >= 0 && pos <= list.size()) {
            list.addAll(pos, newElements);
            System.out.println("Updated Linked List: " + list);
        } else {
            System.out.println("Invalid position!");
        }
    }
}
