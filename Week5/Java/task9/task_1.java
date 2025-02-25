package org.example.assignment.corejava.Task9;

import java.util.Arrays;
import java.util.List;

public class task1 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,5,10,15,20,25);

        double average = numbers.stream()
                                .mapToInt(Integer::intValue)
                                .average()
                                .orElse(0.0); 

        System.out.println("Average: " + average);
    }
}
