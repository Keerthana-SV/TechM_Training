package org.example.assignment.corejava.Task3;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Scanner;

public class task2 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path=sc.nextLine();

        File f=new File(path);
        System.out.println("Enter the file extension(eg. .txt, .pdf. docs): ");
        String ext=sc.nextLine();

        if(f.isDirectory()){
            File[] files=f.listFiles(new FilenameFilter(){
                @Override
                public boolean accept(File file, String name) {
                    return name.toLowerCase().endsWith(ext);
                }
            });
            if (files != null && files.length > 0) {
                System.out.println("\nFiles with extension '" + ext + "' in " + path + ":");
                for (File file : files) {
                    System.out.println(file.getName());
                }
            } else {
                System.out.println("No files with extension '" + ext + "' found.");
            }
        } else {
            System.out.println("Invalid directory path!");
        }
    }
}
