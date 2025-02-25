package org.example.assignment.corejava.Task7;

import java.util.ArrayList;
import java.util.Scanner;

public class task5 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> no = new ArrayList<>();

        System.out.println("Enter the no of numbers: ");
        int n = sc.nextInt();
        System.out.print("Enter the elements: ");
        for (int i = 0; i < n; i++) {
            int elem = sc.nextInt();
            no.add(elem);
        }
        System.out.println("Enter the new element: ");
        int New=sc.nextInt();
        System.out.println("Enter the element you want to replace with "+ New);
        int rep=sc.nextInt();
        int index = no.indexOf(rep);
        no.set(index,New);
        System.out.println("Updated list: "+no);

    }
}
