package org.example.assignment.corejava.Task6;

import java.util.List;

class task3 {
    public static <T> int findFirstIndex(List<T> list, T target) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(target)) {
                return i; 
            }
        }
        return -1; 
    }

    public static void main(String[] args) {
        List<Integer> intList = List.of(10, 20, 30, 40, 50, 30);
        System.out.println("Index of 30 in intList: " + findFirstIndex(intList, 30));
        System.out.println("Index of 100 in intList: " + findFirstIndex(intList, 100));

        List<String> strList = List.of("apple", "banana", "cherry", "banana", "grapes");
        System.out.println("Index of 'grapes' in strList: " + findFirstIndex(strList, "grapes"));
        System.out.println("Index of 'mango' in strList: " + findFirstIndex(strList, "mango"));
    }
}
