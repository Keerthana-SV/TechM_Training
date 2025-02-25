package org.example.assignment.corejava.Task7;

import java.util.ArrayList;
import java.util.Scanner;

public class task3 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        ArrayList<Integer> no=new ArrayList<>();

        System.out.println("Enter the no of numbers: ");
        int n=sc.nextInt();
        System.out.print("Enter the elements: ");
        for(int i=0;i<n;i++){
            int elem=sc.nextInt();
            no.add(elem);
        }
        System.out.println("Enter the new element: ");
        int a=sc.nextInt();

        no.add(0,a);

        System.out.print("Updated elements: "+ no);
    }
}
