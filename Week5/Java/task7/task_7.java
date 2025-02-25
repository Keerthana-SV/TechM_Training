package org.example.assignment.corejava.Task7;

import java.util.ArrayList;
import java.util.Scanner;

public class task7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();

        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter the elements: ");
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        System.out.print("Enter the element to search: ");
        int search = sc.nextInt();

        if (list.contains(search)) {
            System.out.println(search + " is found at index: " + list.indexOf(search));
        } else {
            System.out.println(search + " is not found in the list.");
        }

        sc.close();
    }
}
