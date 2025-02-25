package org.example.assignment.corejava.Task9;

import java.util.*;
import java.util.stream.Collectors;

public class task4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter numbers separated by spaces:");
        List<Integer> numbers = Arrays.stream(sc.nextLine().split(" "))
                                      .map(Integer::parseInt)
                                      .collect(Collectors.toList());
        
        List<Integer> uniqueNumbers = numbers.stream()
                                             .distinct()
                                             .collect(Collectors.toList());
        
        System.out.println("List after removing duplicates: " + uniqueNumbers);

    }
}
