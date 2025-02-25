package org.example.assignment.corejava.Task3;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class task9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the file path:");
        String path = sc.nextLine();
        
        File file = new File(path);
        
        if (!file.exists() || !file.isFile()) {
            System.out.println("File not found or not a valid file.");
            return;
        }
        
        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] byteArray = new byte[(int) file.length()];
            fis.read(byteArray);
            
            System.out.println("File contents in byte array: " + Arrays.toString(byteArray));
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
