package org.example.assignment.corejava.Task9;

import java.util.*;
import java.util.stream.Collectors;

public class task7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of integers:");
        int n = sc.nextInt();

        List<Integer> numbers = new ArrayList<>();
        System.out.println("Enter the integers:");
        for (int i = 0; i < n; i++) {
            numbers.add(sc.nextInt());
        }

        int max = numbers.stream().max(Integer::compareTo).orElseThrow();

        int min = numbers.stream().min(Integer::compareTo).orElseThrow();

        System.out.println("Maximum Value: " + max);
        System.out.println("Minimum Value: " + min);

    }
}
