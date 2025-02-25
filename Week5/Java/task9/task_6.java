package org.example.assignment.corejava.Task9;

import java.util.*;
import java.util.stream.Collectors;

public class task6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of strings:");
        int n = sc.nextInt();
        sc.nextLine();

        List<String> str = new ArrayList<>();
        System.out.println("Enter the strings:");
        for (int i = 0; i < n; i++) {
            str.add(sc.nextLine());
        }

        // Sorting in ascending order
        List<String> ascending = str.stream()
                .sorted()
                .collect(Collectors.toList());

        // Sorting in descending order
        List<String> descending = str.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        System.out.println("Ascending Order: " + ascending);
        System.out.println("Descending Order: " + descending);
        
    }
}
