package org.example.assignment.corejava.Task7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class task2 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        ArrayList<Integer> no=new ArrayList<>();

        System.out.println("Enter the no of numbers: ");
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            System.out.print("Enter the elements: ");
            int elem=sc.nextInt();
            no.add(elem);
        }
        Iterator<Integer> it=no.iterator();
        System.out.println("\nIterating through the elements:");
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
