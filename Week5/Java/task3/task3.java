package org.example.assignment.corejava.Task3;

import java.io.File;
import java.util.Scanner;

public class task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the path name: ");
        String path = sc.nextLine();
        File file = new File(path);
        if (file.isDirectory()) {
            if (file.isFile()) {
                System.out.println("The given path exists and it is a File!");
            } else if (file.isDirectory()) {
                System.out.println("The given path exists and it is a Directory!");
            } else {
                System.out.println("The given path does not exist!");
            }
        }
    }
}
