package org.example.assignment.corejava.Task3;

import java.io.File;
import java.util.Scanner;

public class task8 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the File path: ");
        String filePath = sc.nextLine();
        File file = new File(filePath);

        if (file.exists() && file.isFile()) {
            long bytes = file.length();
            double kb = bytes / 1024.0;
            double mb = kb / 1024.0;

            System.out.println("File Size:");
            System.out.println("Bytes: " + bytes);
            System.out.println("KB: " + kb);
            System.out.println("MB: " + mb);
        } else {
            System.out.println("File not found or not a valid file.");
        }
    }
}
