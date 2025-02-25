package org.example.assignment.corejava.Task9;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class task5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter words separated by spaces:");
        List<String> words = Arrays.asList(sc.nextLine().split(" "));
        
        System.out.println("Enter the letter to filter words:");
        char letter = sc.next().charAt(0);
        
        long count = words.stream()
                          .filter(word -> word.startsWith(String.valueOf(letter)))
                          .count();
        
        System.out.println("Number of words starting with '" + letter + "': " + count);

    }
}
