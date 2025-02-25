package org.example.assignment.corejava.Task3;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class task6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the file path: ");
        String filePath = sc.nextLine();
        
        File file = new File(filePath);
        
        if (file.exists() && file.isFile()) {
            long lastModified = file.lastModified();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            String formattedDate = sdf.format(new Date(lastModified));
            
            System.out.println("Last Modified Date: " + formattedDate);
        } else {
            System.out.println("The specified file does not exist or is not a valid file.");
        }
        
        sc.close();
    }
}
