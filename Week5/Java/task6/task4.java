package org.example.assignment.corejava.Task6;

import java.util.ArrayList;
import java.util.List;

class task4 {
    public static <T> List<T> reverseList(List<T> list) {
        List<T> reversedList = new ArrayList<>();
        
        for (int i = list.size() - 1; i >= 0; i--) {
            reversedList.add(list.get(i));
        }
        
        return reversedList;
    }

    public static void main(String[] args) {
        List<Integer> intList = List.of(1, 2, 3, 4, 5);
        System.out.println("Original Integer List: " + intList);
        System.out.println("Reversed Integer List: " + reverseList(intList));

        List<String> strList = List.of("apple", "lime", "cherry", "plum");
        System.out.println("\nOriginal String List: " + strList);
        System.out.println("Reversed String List: " + reverseList(strList));
    }
}
