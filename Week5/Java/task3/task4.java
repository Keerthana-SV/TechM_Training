package org.example.assignment.corejava.Task3;

import java.io.File;
import java.util.Scanner;

public class task4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the file or directory path: ");
        String path = sc.nextLine();

        File file = new File(path);

        if (file.exists()) {
            System.out.println("The given path exists.");
            
            if (file.canRead()) {
                System.out.println("The file/directory has read permission.");
            } else {
                System.out.println("The file/directory does NOT have read permission.");
            }

            if (file.canWrite()) {
                System.out.println("The file/directory has write permission.");
            } else {
                System.out.println("The file/directory does NOT have write permission.");
            }
        } else {
            System.out.println("The specified file or directory does not exist.");
        }

        sc.close();
    }
}
