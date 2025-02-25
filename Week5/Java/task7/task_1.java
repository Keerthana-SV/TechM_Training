package org.example.assignment.corejava.Task7;

import java.util.ArrayList;
import java.util.Scanner;

public class task1 {
    public static void main(String[] args){
        ArrayList<String> ar=new ArrayList<>();
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the no. of colors: ");
        int no=sc.nextInt();

        for(int i=0;i<no;i++){
            System.out.println("Enter the color: ");
            String color=sc.nextLine();
            ar.add(color);
        }

        System.out.print("Colors are : "+ ar);

    }
}
