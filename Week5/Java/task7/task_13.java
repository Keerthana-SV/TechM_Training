package org.example.assignment.corejava.Task7;

import java.util.LinkedList;
import java.util.Scanner;

public class task13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> list = new LinkedList<>();

        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter the elements: ");
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        System.out.println("Traverse the list from: ");
        int index=sc.nextInt();
        for(int i=index;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }
    }
}
