package org.example.assignment.corejava.Task3;

import java.io.File;
import java.util.Scanner;

public class task5 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the directory/file:");
        String path=sc.nextLine();

        File f=new File(path);

        if(f.exists()){
            if(f.isDirectory()){
                System.out.println(f+ " is a Directory!");
            } else if (f.isFile()) {
                System.out.println(f+" is a File!");
            }
        }else{
            System.out.println("The directory/file does not exist!");
        }
    }
}
