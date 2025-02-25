package org.example.assignment.corejava.Task3;

import java.io.*;
import java.util.Scanner;

public class task10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the file path:");
        String filePath = sc.nextLine();

        File file = new File(filePath);

        if (!file.exists() || !file.isFile()) {
            System.out.println("File not found or not a valid file.");
            return;
        }
        ;
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            System.out.println("\nFile Content:");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
