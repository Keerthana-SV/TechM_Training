package org.example.assignment.corejava.Task7;

import java.util.ArrayList;
import java.util.Scanner;

public class task9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> org = new ArrayList<>();

        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter the elements: ");
        for (int i = 0; i < n; i++) {
            org.add(sc.nextInt());
        }
        ArrayList<Integer> copy = new ArrayList<>(org);

        System.out.println("Original List: " + org);
        System.out.println("Copied List: " + copy);
    }
}
