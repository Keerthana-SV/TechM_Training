package org.example.assignment.corejava.Task7;

import java.util.LinkedList;
import java.util.Scanner;

public class task12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> list = new LinkedList<>();

        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter the elements: ");
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        for (int i : list) {
            System.out.print(i + " ");
        }
    }
}
