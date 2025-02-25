package org.example.assignment.corejava.Task7;

import java.util.LinkedList;
import java.util.Scanner;

public class task15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> list = new LinkedList<>();

        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter the elements: ");
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        System.out.print("Enter the element to insert: ");
        int elem = sc.nextInt();
        System.out.print("Enter the position to insert at: ");
        int pos = sc.nextInt();

        if (pos >= 0 && pos <= list.size()) {
            list.add(pos, elem);
            System.out.println("Updated Linked List: " + list);
        } else {
            System.out.println("Invalid position!");
        }
    }
}
