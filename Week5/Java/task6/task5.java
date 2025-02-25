package org.example.assignment.corejava.Task5;

import java.util.Scanner;

class Prime extends Thread {
    int start, end;
    long sum = 0;

    Prime(int start, int end) {
        this.start = start;
        this.end = end;
    }

    private boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public void run() {
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                sum += i;
            }
        }
        //System.out.println(10/0);
    }

    public long getSum() {

        return sum;
    }
}

public class task5 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the limit: ");
        int limit = sc.nextInt();
        System.out.println("Enter the number: ");
        int numThreads = sc.nextInt();
        Prime[] threads = new Prime[numThreads];

        int range = limit / numThreads;
        int start = 1;
        int end;
        long totalSum = 0;

        for (int i = 0; i < numThreads; i++) {
            end = (i == numThreads - 1) ? limit : start + range - 1;
            threads[i] = new Prime(start, end);
            threads[i].start();
            start = end + 1;
        }

        for (Prime thread : threads) {
            try {
                thread.join();
                totalSum += thread.getSum();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Sum of prime numbers up to " + limit + " is: " + totalSum);
    }
}
