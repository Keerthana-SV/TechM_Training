package org.example.assignment.corejava.Task7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class task6 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        ArrayList<Integer> ar=new ArrayList<>();

        System.out.println("Enter the no. of elements: ");
        int no=sc.nextInt();

        System.out.println("Enter the elements: ");
        for(int i = 0; i < no; i++){
            int elem = sc.nextInt();
            ar.add(elem);
        }

        if(ar.size() >= 3){
            System.out.println("The third element: " + ar.get(2));
            ar.remove(2);
            System.out.println("Updated array: " + ar);
        } else {
            System.out.println("There are less than 3 elements in the list.");
        }
    }
}
