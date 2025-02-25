package org.example.assignment.corejava.Task10;

import java.sql.*;
import java.util.Scanner;

class Library {
    private boolean bookAvailable = false;

    public synchronized void borrowBook() {
        while (!bookAvailable) {
            try {
                System.out.println(Thread.currentThread().getName() + " is waiting to borrow a book...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        bookAvailable = false;
        System.out.println(Thread.currentThread().getName() + " borrowed the book.");
    }

    public synchronized void returnBook() {
        bookAvailable = true;
        System.out.println(Thread.currentThread().getName() + " returned the book.");
        notify();
    }
}

public class task2 {
    static String url = "jdbc:mysql://localhost:3306/school";
    static String username = "root";
    static String password = "Pakjesagaslav@25";

    public static void main(String[] args) throws SQLException {
        Library lib = new Library();
        
        Thread borrower = new Thread(() -> {
            lib.borrowBook();
        }, "Borrower");

        Thread returner = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lib.returnBook();
        }, "Returner");

        borrower.start();
        returner.start();
    }
}
