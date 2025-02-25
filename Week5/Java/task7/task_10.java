package org.example.assignment.corejava.Task7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class task10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();

        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter the elements: ");
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        Collections.shuffle(list);
        System.out.println("Shuffled array: " + list);
    }
}
