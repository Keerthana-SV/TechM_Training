package org.example.assignment.corejava.Task3;

import java.io.Console;

public class task7{
    public static void main(String[] args) {
        Console con = System.console();

        if (con == null) {
            System.out.println("No console available.");
            return;
        }

        String name = con.readLine("Enter your name: ");
        int age = Integer.parseInt(con.readLine("Enter your age: "));
        double salary = Double.parseDouble(con.readLine("Enter your salary: "));

        System.out.println("\nUser Details:");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Salary: " + salary);
    }
}
