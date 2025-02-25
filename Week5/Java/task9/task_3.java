package org.example.assignment.corejava.Task9;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter numbers separated by spaces:");
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                                      .map(Integer::parseInt)
                                      .collect(Collectors.toList());
        
        int even = numbers.stream()
                             .filter(n -> n % 2 == 0)
                             .mapToInt(Integer::intValue)
                             .sum();
        
        int odd = numbers.stream()
                            .filter(n -> n % 2 != 0)
                            .mapToInt(Integer::intValue)
                            .sum();
        
        System.out.println("Sum of even numbers: " + even);
        System.out.println("Sum of odd numbers: " + odd);
 
    }
}
