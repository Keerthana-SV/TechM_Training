package org.example.assignment.corejava.Task6;

import java.util.List;

class task2 {
    public static <T extends Number> void sumEvenOdd(List<T> numbers) {
        int evenSum = 0, oddSum = 0;

        for (T num : numbers) {
            int value = num.intValue(); 
            if (value % 2 == 0) {
                evenSum += value;
            } else {
                oddSum += value;
            }
        }

        System.out.println("Sum of Even Numbers: " + evenSum);
        System.out.println("Sum of Odd Numbers: " + oddSum);
    }

    public static void main(String[] args) {
        List<Integer> intList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("For Integer List:");
        sumEvenOdd(intList);

        List<Double> doubleList = List.of(10.5, 20.0, 30.2, 41.8, 55.3, 60.6);
        System.out.println("\nFor Double List (Converted to Integer):");
        sumEvenOdd(doubleList);
    }
}
